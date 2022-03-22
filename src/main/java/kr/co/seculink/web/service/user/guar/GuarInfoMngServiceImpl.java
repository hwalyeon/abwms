package kr.co.seculink.web.service.user.guar;

import kr.co.seculink.domain.RtnMsg;
import kr.co.seculink.exception.BizException;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service("guarInfoMngService")
public class GuarInfoMngServiceImpl implements GuarInfoMngService
{
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate dao;

	//보호자(사용자)_정보_리스트 조회
	public List<Map<String, String>> searchGuarInfoList(Map<String, String> params) throws BizException
	{
		List<Map<String, String>> result = dao.selectList("user.guar.guarInfoMng.selectGuarInfoList", params);

		return result;
	}

	//보호자(사용자)_정보 상세보기
	public Map<String, Object> searchGuarInfo(Map<String, String> params) throws BizException
	{
		Map<String, String> result = dao.selectOne("user.guar.guarInfoMng.selectGuarInfoDetl", params);

		Map<String, Object> rtnMap = new HashMap<>();

		rtnMap.put("result", result);

		return rtnMap;
	}

	//보호자(사용자)_정보 저장
	public void saveGuarInfoDetl(Map<String, Object> params) throws BizException
	{
		RtnMsg vo = new RtnMsg();
		Map<String, Object> rtnMap = new HashMap<String, Object>();

		int saveCnt = 0;

		System.out.println("params:"+params);
		if ("U".equals(params.get("crud"))) {
			saveCnt += dao.update("user.guar.guarInfoMng.updateTmGuarInfoList", params);
		} else if ("D".equals(params.get("crud"))) {
			saveCnt += dao.delete("user.guar.guarInfoMng.deleteTmGuarInfoList", params);
		}
		if (saveCnt == 0) {
			throw new BizException("ECOM999", new String[]{"보호자(사용자) 정보 저장이 실패하였습니다."});
		}
	}

	//학부모_정보 저장
	public void savePrntInfoDetl(Map<String, Object> params) throws BizException
	{
		RtnMsg vo = new RtnMsg();
		Map<String, Object> rtnMap = new HashMap<String, Object>();

		int saveCnt = 0;

		System.out.println("params:"+params);
		if ("C".equals(params.get("crud"))) {
			saveCnt += dao.insert("user.prnt.prntInfoMng.insertTmPrntBase", params);
		} else if ("U".equals(params.get("crud"))) {
			saveCnt += dao.update("user.prnt.prntInfoMng.updateTmPrntBase", params);
		}/* else if ("D".equals(params.get("crud"))) {
			saveCnt += dao.delete("user.prnt.prntInfoMng.deleteTmPrntBase", params);
		}*/
		if (saveCnt == 0) {
			throw new BizException("ECOM999", new String[]{"보호자(사용자) 정보 저장이 실패하였습니다."});
		}
	}

	//약관동의여부_정보 상세보기
	public List<Map<String, Object>> searchTermAgreYnInfoDetlList(Map<String, String> params) throws BizException
	{
		List<Map<String, Object>> result = dao.selectList("user.guar.guarInfoMng.selectTermAgreYnInfoDetl", params);

		return result;
	}

}
	
