package kr.co.seculink.web.controller.stat.hc;

import kr.co.seculink.domain.RtnMsg;
import kr.co.seculink.exception.BizException;
import kr.co.seculink.web.service.stat.hc.AvalCalStssService;
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
public class AvalCalStssController
{
    @Resource(name = "sqlSessionTemplate")
    private SqlSessionTemplate dao;

    @Autowired
    private AvalCalStssService avalCalStssService;

    @ResponseBody
    @RequestMapping("/stat/hc/avalCalStss/searchAvalCalStssColList.ab")
    public RtnMsg searchAvalCalStssColList(@RequestBody(required = false) Map<String, String> params) throws BizException
    {

        RtnMsg vo = new RtnMsg();
        Map<String, Object> rtnMap = new HashMap<String, Object>();

        List<Map<String, String>> stndDtList = dao.selectList("stat.hc.avalCalStss.searchAvalCalStssCdList", params);
        rtnMap.put("stndDtList", stndDtList);

        vo.setRtnData(rtnMap, params);

        return vo;
    }

    @ResponseBody
    @RequestMapping("/stat/hc/avalCalStss/searchAvalCalStssList.ab")
    public RtnMsg searchAvalCalStssList(@RequestBody(required = false) Map<String, String> params) throws BizException
    {

        RtnMsg vo = new RtnMsg();
        Map<String, Object> rtnMap = new HashMap<String, Object>();

        List<Map<String, Object>> result = avalCalStssService.searchAvalCalStssList(params);
        rtnMap.put("result", result);

        vo.setRtnData(rtnMap, params);

        return vo;
    }


}
