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

		if ("C".equals(params.get("crud"))){
			saveCnt += dao.insert("user.guar.guarInfoMng.insertTmGuarInfoList", params);
		} else if ("U".equals(params.get("crud"))) {
			saveCnt += dao.update("user.guar.guarInfoMng.updateTmGuarInfoList", params);
		} else if ("D".equals(params.get("crud"))) {
			saveCnt += dao.delete("user.guar.guarInfoMng.deleteTmGuarInfoList", params);
		}
		if (saveCnt == 0) {
			throw new BizException("ECOM999", new String[]{"보호자(사용자) 정보 저장이 실패하였습니다."});
		}
	}

	//배우자_정보 상세보기
	public Map<String, Object> searchSposInfo(Map<String, String> params) throws BizException
	{
		Map<String, String> result = dao.selectOne("user.guar.guarInfoMng.selectSposInfoDetl", params);

		Map<String, Object> rtnMap = new HashMap<>();

		rtnMap.put("result", result);

		return rtnMap;
	}

	//배우자_정보 저장
	public void saveSposInfoDetl(Map<String, Object> params) throws BizException
	{
		RtnMsg vo = new RtnMsg();
		Map<String, Object> rtnMap = new HashMap<String, Object>();

		int saveCnt = 0;

		if ("C".equals(params.get("crud"))){
			saveCnt += dao.insert("user.guar.guarInfoMng.insertTmSposInfoList", params);
			saveCnt += dao.update("user.guar.guarInfoMng.updateTmGuarInfoList", params);
		} else if ("U".equals(params.get("crud"))) {
			saveCnt += dao.update("user.guar.guarInfoMng.updateTmSposInfoList", params);

			//보호자 번호 가져오기
			Map<String, Object> result = dao.selectOne("user.guar.guarInfoMng.selectGuarNo",params);

			Object guarNo = result.get("guarNo");
			params.put("guarNo",guarNo);
			params.put("sposNo","");
			params.put("guarNm", params.get("sposNm"));
			params.put("guarTelNo", params.get("sposTelNo"));
			saveCnt += dao.update("user.guar.guarInfoMng.updateTmGuarInfoList", params);

		} else if ("D".equals(params.get("crud"))) {
			saveCnt += dao.delete("user.guar.guarInfoMng.deleteTmSposInfoList", params);
		}
		if (saveCnt == 0) {
			throw new BizException("ECOM999", new String[]{"배우자 정보 저장이 실패하였습니다."});
		}
	}

	//약관동의여부_정보 상세보기
	public List<Map<String, Object>> searchTermAgreYnInfoDetlList(Map<String, String> params) throws BizException
	{
		List<Map<String, Object>> result = dao.selectList("user.guar.guarInfoMng.selectTermAgreYnInfoDetl", params);

		return result;
	}
/*

	//약관동의여부_정보 저장
	public void saveTermAgreYnInfoDetl(Map<String, Object> params) throws BizException {

		int saveCnt = 0;

		List<Map<String, String>> gridDate = (List<Map<String, String>>) params.get("gridList");


		for(Map<String,String> info:gridDate) {

			log.debug("crud : " + info.get("crud"));
			Map<String, Object> result = dao.selectOne("user.guar.guarInfoMng.searchDupCdCk", info);

			if (result == null) {
				saveCnt += dao.insert("user.guar.guarInfoMng.insertTmTermAgreDetlInfoList", info);
			} else {
				saveCnt += dao.update("user.guar.guarInfoMng.updateTmTermAgreDetlInfoList", info);
			}

		}
		if (saveCnt == 0) {
			throw new BizException("ECOM999", new String[]{"약관동의여부 정보 저장이 실패하였습니다."});
		}
	}
*/

}
	
