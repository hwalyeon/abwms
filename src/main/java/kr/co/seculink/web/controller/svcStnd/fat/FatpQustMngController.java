package kr.co.seculink.web.controller.svcStnd.fat;

import kr.co.seculink.domain.RtnMsg;
import kr.co.seculink.exception.BizException;
import kr.co.seculink.util.GEUtil;
import kr.co.seculink.web.excel.ExcelConstant;
import kr.co.seculink.web.service.svcStnd.fat.FatpQustMngService;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.*;

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

        return vo;
    }

    /*비만예측_설문_기본_리스트_저장*/
    @ResponseBody
    @RequestMapping("/svcStnd/fat/fatpQustMng/saveFatpQustBaseDetl.ab")
    public RtnMsg saveFatpQustBaseDetl(@RequestBody(required=false) Map<String, Object> params) throws BizException
    {
        RtnMsg vo = new RtnMsg();
        Map<String, Object> rtnMap = new HashMap();

        fatpQustMngService.saveFatpQustBaseDetl(params);

        rtnMap.put("result", params);
        vo.setRtnData(rtnMap, params);

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

        return vo;
    }

    /*비만예측_설문_상세_정보_조회(팝업)*/
    @ResponseBody
    @RequestMapping("/svcStnd/fat/fatpQustMng/searchFatpQustSpecInfo.ab")
    public RtnMsg searchFatpQustSpecInfo(@RequestBody(required=false) Map<String, String> params) throws BizException
    {
        RtnMsg vo = new RtnMsg();
        Map<String, Object> rtnMap = new HashMap<>();

        Map<String, Object> result = fatpQustMngService.searchFatpQustSpecInfo(params);
        rtnMap.put("result", result);

        vo.setRtnData(rtnMap, params);

        return vo;
    }

    /*비만예측_설문_상세_리스트_저장*/
    @ResponseBody
    @RequestMapping("/svcStnd/fat/fatpQustMng/saveFatpQustSpecDetl.ab")
    public RtnMsg saveFatpQustSpecDetl(@RequestBody(required=false) Map<String, Object> params) throws BizException
    {
        RtnMsg vo = new RtnMsg();
        Map<String, Object> rtnMap = new HashMap();

        fatpQustMngService.saveFatpQustSpecDetl(params);

        rtnMap.put("result", params);
        vo.setRtnData(rtnMap, params);

        return vo;
    }


    //비만예측_설문_기본_리스트 엑셀다운로드
    @ResponseBody
    @RequestMapping("/svcStnd/fat/fatpQustMng/searchFatpQustBaseList/excel.ab")
    public ModelAndView downloadExcelFatpQustBase(@RequestBody(required = false) Map<String, String> params) throws BizException {

        params.put("paging", "N");
        List<Map<String, String>> result = dao.selectList("svcStnd.fat.fatpQustMng.selectTcFatpQustStatBase", params);

        return new ModelAndView("excelXlsView", getExcelMapBase(result));
    }

    private Map<String, Object> getExcelMapBase(List<Map<String, String>> list) {
        String[] arrHeader = {
                  "설문 버전"
                , "설문 번호"
                , "설문 내용"};
        List<String> headerList = Arrays.asList(arrHeader);

        List<List<String>> dataList = new ArrayList<List<String>>();
        List<String> data;

        for (Map<String, String> info : list) {
            data = new ArrayList<String>();
            data.add(String.valueOf(info.get("qustVer")));  //설문_버전
            data.add(String.valueOf(info.get("qustNo")));   //설문_번호
            data.add(info.get("qustCntn"));                 //설문_내용
            dataList.add(data);
        }

        Map<String, Object> map = new HashMap<>();
        map.put(ExcelConstant.FILE_NAME, "excel");
        map.put(ExcelConstant.HEAD, headerList);
        map.put(ExcelConstant.BODY, dataList);
        return map;
    }
    //비만예측_설문_상세_리스트 엑셀다운로드
    @ResponseBody
    @RequestMapping("/svcStnd/fat/fatpQustMng/searchFatpQustSpecList/excel.ab")
    public ModelAndView downloadExcelFatpQustSpec(@RequestBody(required = false) Map<String, String> params) throws BizException {

        params.put("paging", "N");
        List<Map<String, String>> result = dao.selectList("svcStnd.fat.fatpQustMng.selectFatpQustSpecList", params);

        return new ModelAndView("excelXlsView", getExcelMapSpec(result));
    }

    private Map<String, Object> getExcelMapSpec(List<Map<String, String>> list) {
        String[] arrHeader =
        {
                  "설문 버전"
                , "설문 번호"
                , "답변 순번"
                , "답변 값"
                , "답변 내용"
        };
        List<String> headerList = Arrays.asList(arrHeader);

        List<List<String>> dataList = new ArrayList<List<String>>();
        List<String> data;

        for (Map<String, String> info : list) {
            data = new ArrayList<String>();
            data.add(String.valueOf(info.get("qustVer")));  //설문_버전
            data.add(String.valueOf(info.get("qustNo")));   //설문_번호
            data.add(String.valueOf(info.get("ansSeq")));   //답변_순번
            data.add(info.get("ansVal"));                   //답변_값
            data.add(info.get("ansCntn"));                  //답변_내용
            dataList.add(data);
        }

        Map<String, Object> map = new HashMap<>();
        map.put(ExcelConstant.FILE_NAME, "excel");
        map.put(ExcelConstant.HEAD, headerList);
        map.put(ExcelConstant.BODY, dataList);
        return map;
    }
}
