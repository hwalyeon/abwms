package kr.co.seculink.web.controller.stat.dgem;

import kr.co.seculink.domain.RtnMsg;
import kr.co.seculink.exception.BizException;
import kr.co.seculink.web.excel.ExcelConstant;
import kr.co.seculink.web.service.stat.dgem.DzoneStssService;
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
public class DzoneStssController
{

    @Resource(name = "sqlSessionTemplate")
    private SqlSessionTemplate dao;

    @Autowired
    private DzoneStssService dzoneStssService;

    @ResponseBody
    @RequestMapping("/stat/dgem/dzoneStss/searchDzoneStssColList.ab")
    public RtnMsg searchDzoneStssColList(@RequestBody(required = false) Map<String, String> params) throws BizException
    {

        RtnMsg vo = new RtnMsg();
        Map<String, Object> rtnMap = new HashMap<String, Object>();

        List<Map<String, String>> stndDtList = dao.selectList("stat.dgem.dzoneStss.searchDzoneStssCdList", params);
        rtnMap.put("stndDtList", stndDtList);

        vo.setRtnData(rtnMap, params);

        return vo;
    }

    @ResponseBody
    @RequestMapping("/stat/dgem/dzoneStss/searchDzoneStssList.ab")
    public RtnMsg searchDzoneStssList(@RequestBody(required = false) Map<String, String> params) throws BizException
    {

        RtnMsg vo = new RtnMsg();
        Map<String, Object> rtnMap = new HashMap<String, Object>();

        List<Map<String, Object>> result = dzoneStssService.searchDzoneStssList(params);
        rtnMap.put("result", result);

        vo.setRtnData(rtnMap, params);

        return vo;
    }

    //위험지역 발생 추이 엑셀 다운로드
    @ResponseBody
    @RequestMapping("/stat/dgem/dzoneStss/searchDzoneStssList/excel.ab")
    public ModelAndView downloadExcel(@RequestBody(required=false) Map<String, String> params) throws BizException
    {
        params.put("paging", "N");
        List<Map<String, Object>> result = dao.selectList("stat.dgem.dzoneStss.searchDzoneStssList", params);

        return new ModelAndView("excelXlsView", getExcelMap(result));
    }

    private Map<String, Object> getExcelMap(List<Map<String, Object>> list)
    {
        String [] arrHeader = {"기준일자","발생건수","발생학생수"};
        List<String> headerList = Arrays.asList(arrHeader);

        List<List<String>> dataList = new ArrayList<List<String>>();
        List<String> data;

        for ( Map<String, Object> info : list )
        {
            data = new ArrayList<String>();
            data.add(String.valueOf(info.get("stndDt")));
            data.add(String.valueOf(info.get("occrCnt")));
            data.add(String.valueOf(info.get("stdtCnt")));
            dataList.add(data);
        }

        Map<String, Object> map = new HashMap<>();
        map.put(ExcelConstant.FILE_NAME, "excel");
        map.put(ExcelConstant.HEAD, headerList);
        map.put(ExcelConstant.BODY, dataList);
        return map;
    }

}
