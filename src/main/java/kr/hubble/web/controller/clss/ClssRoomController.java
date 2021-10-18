package kr.hubble.web.controller.clss;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.seculink.api.model.RtnMsg;
import kr.co.seculink.exception.BizException;
import kr.co.seculink.util.GEUtil;
import kr.co.seculink.util.XUtil;
import kr.hubble.web.service.clss.CousTakeService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ClssRoomController
{
	@Autowired
	private CousTakeService cousTakeService;
	
	@Autowired
	private SqlSessionTemplate dao;
	
	@ResponseBody
	@RequestMapping("/clss/clssRoom/searchLectInfo")
	public RtnMsg searchLectInfo(@RequestBody(required=false) Map<String, String> params) throws BizException
	{
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		
		Map<String, String> lectInfo = dao.selectOne("lect.crclMng.selectTsCousLect", params);
		this.lectValidation(lectInfo);
		
		if ( !XUtil.isEmpty(params.get("stdtId")) ) {
			Map<String, String> stdtInfo = dao.selectOne("clss.stdtMng.selectToStdtBase", params);
			String attdYn = dao.selectOne("clss.stdtMng.selectLectAttdYn", params);
			
			if ( !XUtil.getCurrDate().equals(lectInfo.get("lectStrtDt")) && XUtil.getCurrDate().equals(lectInfo.get("lectEndDt")) ) {
				attdYn = "N";
			}
			
			stdtInfo.put("ATTD_YN", attdYn);
			
			rtnMap.put("stdtInfo", stdtInfo);
		}
		
		if ( !XUtil.isEmpty(params.get("lctrId"))) {
			Map<String, String> lctrInfo = dao.selectOne("lect.lctrMng.selectToLctrBase", params);
			rtnMap.put("lctrInfo", lctrInfo);
		}
		
		List<Map<String, String>> cousStdtList = dao.selectList("clss.clssRoom.selectTsCousStdt", params);
		
		rtnMap.put("lectInfo", lectInfo);
		rtnMap.put("cousStdtList", cousStdtList);
		
		RtnMsg vo = new RtnMsg();
		vo.setRtnData(rtnMap);
		
		return vo;
	}
	
	private void lectValidation(Map<String, String> lectInfo) throws BizException
	{
		if ( lectInfo == null || lectInfo.isEmpty() ) {
			throw new BizException("ECOM999", new String[] {"강의정보를 찾을 수 없습니다.\n수강신청 정보를 확인해보시기 바랍니다."}); 
		}
		
		if ( "20".equals(lectInfo.get("cousStatCd")) ) {
			throw new BizException("ECOM999", new String[] {"해당 강의는 종료되었습니다."});
		}
		
		int BUFFER_MINUTE = 10;
		
		BigDecimal lectStrtDt = new BigDecimal(XUtil.getString(lectInfo.get("lectStrtDt")));
		BigDecimal lectEndDt  = new BigDecimal(XUtil.getString(lectInfo.get("lectEndDt")));
		BigDecimal currDt     = new BigDecimal(XUtil.getCurrDate());
		
		String lectStrtTm = XUtil.getString(lectInfo.get("lectStrtTm"));
		String lectEndTm  = XUtil.getString(lectInfo.get("lectEndTm"));
		String currTm     = XUtil.getCurrTime();
		
		if ( currDt.compareTo(lectStrtDt) < 0 ) {
			throw new BizException("ECOM999", new String[] {"강의시작일자가 미래입니다."});
		} else {
			log.debug("강의시작일자가 오늘이거나 과거인 경우는 패스");
		}
		
		if ( currDt.compareTo(lectEndDt) > 0 ) {
			if ( XUtil.isEmpty(XUtil.getString(lectInfo.get("lectUrl"))) ) {
				throw new BizException("ECOM999", new String[] {"종료된 강의입니다."});
			} else {
				log.debug("종료된 강의지만 다시보기가 있어서 패스");
			}
		}
		
		if ( currDt.compareTo(lectStrtDt) == 0 && currDt.compareTo(lectEndDt) == 0 ) {
			
			if ( XUtil.minuteBetween(lectStrtTm, currTm) > BUFFER_MINUTE ) {
				throw new BizException("ECOM999", new String[] {"강의 준비중입니다."});
			} else {
				log.debug("강의중이라 패스");
			}
				
			if ( XUtil.minuteBetween(currTm, lectEndTm) > BUFFER_MINUTE ) {
				if ( XUtil.isEmpty(XUtil.getString(lectInfo.get("lectUrl"))) ) {
					throw new BizException("ECOM999", new String[] {"종료된 강의입니다."});
				} else {
					log.debug("종료된 강의지만 다시보기가 있어서 패스");
				}
			} else {
				log.debug("강의중이라 패스");
			}
			
		} else {
			
			if ( currDt.compareTo(lectStrtDt) == 0 && currDt.compareTo(lectEndDt) < 0 ) {
				
				if ( XUtil.minuteBetween(lectStrtTm, currTm) > BUFFER_MINUTE ) {
					throw new BizException("ECOM999", new String[] {"강의 준비중입니다."});
				} else {
					log.debug("강의중이라 패스");
				}
			} else {
				if ( XUtil.minuteBetween(currTm, lectEndTm) > BUFFER_MINUTE ) {
					if ( XUtil.isEmpty(XUtil.getString(lectInfo.get("lectUrl"))) ) {
						throw new BizException("ECOM999", new String[] {"종료된 강의입니다."});
					} else {
						log.debug("종료된 강의지만 다시보기가 있어서 패스");
					}
				} else {
					log.debug("강의중이라 패스");
				}
			}
		}
	}
	
	@ResponseBody
	@RequestMapping("/clss/clssRoom/searchCousStdtList")
	public RtnMsg searchCousStdtList(@RequestBody(required=false) Map<String, String> params) throws BizException
	{
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		
		List<Map<String, String>> result = dao.selectList("clss.clssRoom.selectTsCousStdt", params);
		if ( result == null || result.size() == 0 ) {
			throw new BizException("ECOM025");
		} else {
			rtnMap.put("result", result);
		}
		
		RtnMsg vo = new RtnMsg();
		
		if ( !GEUtil.isEmpty(params.get("paging")) ) {
			params.put("paging", "N");
			vo.setTotalCount(((List)dao.selectList("clss.clssRoom.selectTsCousStdt", params)).size());
		}
		
		vo.setRtnData(rtnMap, params);
		
		return vo;
	}
	
	@ResponseBody
	@RequestMapping("/clss/clssRoom/saveEvent")
	public RtnMsg saveEvent(@RequestBody(required=false) Map<String, String> params) throws BizException
	{
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		
		cousTakeService.procEvent(params);
		
		RtnMsg vo = new RtnMsg();
		vo.setRtnData(rtnMap, params);
		
		return vo;
	}
}
