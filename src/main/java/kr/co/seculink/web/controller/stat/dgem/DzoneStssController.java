package kr.co.seculink.web.controller.stat.dgem;

import kr.co.seculink.domain.RtnMsg;
import kr.co.seculink.exception.BizException;
import kr.co.seculink.web.service.stat.dgem.DzoneStssService;
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
public class DzoneStssController
{
    @Resource(name = "sqlSessionTemplate")
    private SqlSessionTemplate dao;

    @Autowired
    private DzoneStssService dzoneStssService;

    @ResponseBody
    @RequestMapping("/stat/dgem/dzoneStss/searchAvalActStssColList.ab")
    public RtnMsg searchAvalActStssColList(@RequestBody(required = false) Map<String, String> params) throws BizException
    {

        RtnMsg vo = new RtnMsg();
        Map<String, Object> rtnMap = new HashMap<String, Object>();

        List<Map<String, String>> stndDtList = dao.selectList("stat.dgem.dzoneStss.searchAvalActStssCdList", params);
        rtnMap.put("stndDtList", stndDtList);

        vo.setRtnData(rtnMap, params);

        return vo;
    }

    @ResponseBody
    @RequestMapping("/stat/dgem/dzoneStss/searchAvalActStssList.ab")
    public RtnMsg searchAvalActStssList(@RequestBody(required = false) Map<String, String> params) throws BizException
    {

        RtnMsg vo = new RtnMsg();
        Map<String, Object> rtnMap = new HashMap<String, Object>();

        List<Map<String, Object>> result = dzoneStssService.searchAvalActStssList(params);
        rtnMap.put("result", result);

        vo.setRtnData(rtnMap, params);

        return vo;
    }


}
