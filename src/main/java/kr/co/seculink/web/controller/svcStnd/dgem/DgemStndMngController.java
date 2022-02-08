package kr.co.seculink.web.controller.svcStnd.dgem;

import kr.co.seculink.domain.RtnMsg;
import kr.co.seculink.exception.BizException;
import kr.co.seculink.util.GEUtil;
import kr.co.seculink.web.excel.ExcelConstant;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Slf4j
@Controller
public class DgemStndMngController
{
	@Autowired
	private SqlSessionTemplate dao;

	

	@ResponseBody
	@RequestMapping("")
	public RtnMsg  searchDuprCdSpec(@RequestBody(required=false)Map<String, String> params) throws BizException
	{	RtnMsg vo = new RtnMsg();
     	Map<String, String> rtnMap = new HashMap<>();
     	
    		Map<String, String> result = dao.selectOne("set.cdMng.selectDuprCdSpec", params);
    	   
    		
    
	    	
    		if (params.get("dataCk").equals("N") ||  result == null || GEUtil.isEmpty(result.get("cdGrp"))  && GEUtil.isEmpty(result.get("cdGrpNm"))) {
    			rtnMap.put("existsYn", "N");
    			
    			}
    		else
    		{
    			rtnMap.put("existsYn", "Y");		
    		}
    		
    		vo.setRtnData(rtnMap);
    		
    		return vo;
    	
	}

}
