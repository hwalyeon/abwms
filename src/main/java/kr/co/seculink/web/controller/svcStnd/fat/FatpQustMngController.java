package kr.co.seculink.web.controller.svcStnd.fat;

import kr.co.seculink.domain.RtnMsg;
import kr.co.seculink.exception.BizException;
import kr.co.seculink.util.GEUtil;
import kr.co.seculink.web.service.svcStnd.fat.FatpQustMngService;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
public class FatpQustMngController {

    @Resource(name = "sqlSessionTemplate")
    private SqlSessionTemplate dao;

    @Autowired
    private FatpQustMngService fatpQustMngService;


    /*비만예측_설문_기본_리스트 조회*/
    @ResponseBody
    @RequestMapping("/svcStnd/fat/fatpQustMng/searchFatpQustBaseList.ab")
    public RtnMsg searchFatpQustBaseList(@RequestBody(required=false) Map<String, String> params) throws BizException
    {
        RtnMsg vo = new RtnMsg();
        Map<String, Object> rtnMap = new HashMap<>();

        List<Map<String, String>> result = fatpQustMngService.searchFatpQustBaseList(params);
        rtnMap.put("result", result);

        if (!GEUtil.isEmpty(params.get("paging"))) {
            params.put("paging", "N");
            vo.setTotalCount(((List) fatpQustMngService.searchFatpQustBaseList(params)).size());
        }

        vo.setRtnData(rtnMap, params);
        System.out.println("result"+result);

        return vo;
    }

    /*비만예측_설문_상세_리스트 조회*/
    @ResponseBody
    @RequestMapping("/svcStnd/fat/fatpQustMng/searchFatpQustSpecList.ab")
    public RtnMsg searchFatpQustSpecList(@RequestBody(required=false) Map<String, String> params) throws BizException
    {
        RtnMsg vo = new RtnMsg();
        Map<String, Object> rtnMap = new HashMap<>();

        List<Map<String, String>> result = fatpQustMngService.searchFatpQustSpecList(params);
        rtnMap.put("result", result);

        if (!GEUtil.isEmpty(params.get("paging"))) {
            params.put("paging", "N");
            vo.setTotalCount(((List) fatpQustMngService.searchFatpQustSpecList(params)).size());
        }

        vo.setRtnData(rtnMap, params);
        System.out.println("result"+result);

        return vo;
    }
}
