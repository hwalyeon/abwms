package kr.co.seculink.web.service.svcStnd.act;

import kr.co.seculink.exception.BizException;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Slf4j
@Service("fatActStndMngService")
public class FatActStndMngServiceImpl implements FatActStndMngService
{
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate dao;
	
    //비만활동_기준_리스트 조회
	public List<Map<String, String>> searchFatActStndList(Map<String, String> params) throws BizException
	{
		List<Map<String, String>> result = dao.selectList("svcStnd.act.fatActStndMng.searchFatActStndList", params);
		return result;
	}

	//상세보기_저장
	@Transactional
	public void saveFatActStndInfo(Map<String, Object> params) throws BizException
	{
		int saveCnt = 0;

		if( "C".equals(params.get("crud"))){
			if(chkKey(params)) {
				saveCnt += dao.insert("svcStnd.act.fatActStndMng.insertTiFatActStndList", params);
			}
		}else if( "U".equals(params.get("crud"))){
			saveCnt += dao.update("svcStnd.act.fatActStndMng.updateTiFatActStndList", params);
		}else if( "D".equals(params.get("crud"))){
			saveCnt += dao.delete("svcStnd.act.fatActStndMng.deleteTiFatActStndList", params);
		}

		if(saveCnt == 0){
			throw new BizException("ECOM999", new String[]{"비만활동 기준 저장이 실패하였습니다"});
		}
	}

	// GROW_JUDG_CD & PAL_CD 값 중복 방지
	private boolean chkKey(Map<String, Object> params) throws BizException
	{
		boolean chkRtn = true;
		Map<String, String> result = dao.selectOne("svcStnd.act.fatActStndMng.searchFatJudgCdChk", params);

		if(null != result && !"".equals(result)){
			throw new BizException("ECOM999", new String[]{"이미 등록된 비만활동 및 신체활동수준 코드입니다."});
		}
		return chkRtn;
	}

}
