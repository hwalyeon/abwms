package kr.hubble.web.controller.lect;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.seculink.api.model.RtnMsg;
import kr.co.seculink.exception.BizException;
import kr.co.seculink.util.XUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class WaitRoomController
{
	@Autowired
	private SqlSessionTemplate dao;
	
	@ResponseBody
	@RequestMapping("/lect/waitRoom/searchLectInfo")
	public RtnMsg saveLectUrl(@RequestBody(required=false) Map<String, String> params) throws BizException
	{
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		
//		Map<String, String> lectInfoMap = dao.selectOne("lect.crclMng.selectTsCousLect", params);
//		if ( lectInfoMap.get("lectUrl") == null || "".equals(lectInfoMap.get("lectUrl")) ) {
//			
//			params.put("lectUrl" , "/clss/clssRoom?cousNo=" + params.get("cousNo") + "&lectSeq=" + params.get("lectSeq"));
//
//			dao.update("lect.crclMng.updateTsCousLect", params);
//			
//			lectInfoMap.put("lectUrl", params.get("lectUrl"));
//		}
//		
//		rtnMap.put("result", lectInfoMap);
		
		RtnMsg vo = new RtnMsg();
		
		vo.setRtnData(rtnMap, params);
		
		return vo;
	}
	
	@ResponseBody
	@RequestMapping("/lect/waitRoom/searchAtndLect")
	public RtnMsg searchAtndLect(@RequestBody(required=false) Map<String, String> params) throws BizException
	{
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		
		Map<String, String> lectInfoMap = dao.selectOne("lect.crclMng.selectTsCousLect", params);
		if ( lectInfoMap == null || lectInfoMap.isEmpty() ) {
			throw new BizException("ECOM999", new String[] {"수강신청을 확인하시기 바랍니다."});
		}
		
		
		int diff = XUtil.daysBetween(lectInfoMap.get("lectStrtDt"), XUtil.getCurrDate());
		if ( diff == 0 ) {
			Map<String, String> cousTakeMap = dao.selectOne("hist.takeDetlMng.selectTsCousTakeDetl", params);
			if ( cousTakeMap == null || cousTakeMap.isEmpty() ) {
				/*
				Map<String, String> atndMap = new HashMap<>();
				atndMap.put("cousNo"  , params.get("cousNo"));
				atndMap.put("lectSeq" , params.get("lectSeq"));
				atndMap.put("stdtId"  , params.get("stdtId"));
				atndMap.put("atndYn"  , "Y");
				atndMap.put("swchYn"  , "N");
				atndMap.put("rwayYn"  , "N");
				atndMap.put("takeTcnt", "0");
				atndMap.put("hworkEvalScor", "0");					
				dao.insert("hist.takeDetlMng.insertTsCousTakeDetl", atndMap);
				
				Map<String, String> takeEventMap = new HashMap<>();
				takeEventMap.put("cousNo"    , params.get("cousNo"));
				takeEventMap.put("lectSeq"   , params.get("lectSeq"));
				takeEventMap.put("stdtId"    , params.get("stdtId"));
				takeEventMap.put("takeEvntCd", "10");
				takeEventMap.put("occrDttm"  , XUtil.getCurrDttm());
				dao.insert("hist.takeDetlMng.insertTsTakeHist", takeEventMap);
				*/
			}
		} else if ( diff > 0 ) {
			// 지난 강의
			if ( XUtil.isEmpty(lectInfoMap.get("lectUrl")) ) {
				throw new BizException("ECOM999", new String[] {"종료된 강의입니다.\n다시보기 강의 동영상이 없습니다."});
			} else {
				lectInfoMap.put("lectMethCd", "20");
			}
		} else {
			throw new BizException("ECOM999", new String[] {"강의시작일자가 도래하지 않았습니다."});
		}
		
		rtnMap.put("result", lectInfoMap);
		
		RtnMsg vo = new RtnMsg();
		
		vo.setRtnData(rtnMap);
		
		return vo;
	}
	
	private String setLectPassword()
	{
		String password = "1";
		
		return password;
	}
}
