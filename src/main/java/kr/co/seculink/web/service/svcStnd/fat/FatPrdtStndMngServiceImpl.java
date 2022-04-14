package kr.co.seculink.web.service.svcStnd.fat;

import kr.co.seculink.domain.RtnMsg;
import kr.co.seculink.domain.vo.TiFatJudgSpecVo;
import kr.co.seculink.exception.BizException;
import kr.co.seculink.web.service.cmon.FileService;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service("fatPrdtStndMngService")
public class FatPrdtStndMngServiceImpl implements FatPrdtStndMngService
{
	@Autowired
	private FileService fileService;
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate dao;

	// 비만예측_기준_리스트_조회
	public List<Map<String, String>> searchFatPrdtList(Map<String, String> params) throws BizException
	{
		List<Map<String, String>> result = dao.selectList("svcStnd.fat.fatPrdtStndMng.selectTiFatPrdtSpecBase", params);
		
		return result;
	}

	//비만예측_기준_정보 저장
	public void saveFatJudgSpecDetl(Map<String, Object> params) throws BizException
	{
		RtnMsg vo = new RtnMsg();
		Map<String, Object> rtnMap = new HashMap<String, Object>();

		int saveCnt = 0;

		if( "C".equals(params.get("crud"))){
			TiFatJudgSpecVo exists = dao.selectOne("TI_FAT_JUDG_SPEC.select",params);
			if(exists == null)
			{
				saveCnt += dao.insert("svcStnd.fat.fatPrdtStndMng.insertTmGuarInfoList", params);
			}else {
				throw new BizException("ECOM999", new String[]{"이미 등록된 코드입니다."});
			}
		}else if ("U".equals(params.get("crud"))) {
			saveCnt += dao.update("svcStnd.fat.fatPrdtStndMng.updateTmGuarInfoList", params);
		} else if ("D".equals(params.get("crud"))) {
			saveCnt += dao.delete("svcStnd.fat.fatPrdtStndMng.deleteTmGuarInfoList", params);
		}
		if (saveCnt == 0) {
			throw new BizException("ECOM999", new String[]{"비만예측 기준 정보 저장이 실패하였습니다."});
		}
	}



}
