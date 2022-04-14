package kr.co.seculink.web.controller.oper.hc;

import kr.co.seculink.domain.RtnMsg;
import kr.co.seculink.exception.BizException;
import kr.co.seculink.util.GEUtil;
import kr.co.seculink.web.excel.ExcelConstant;
import kr.co.seculink.web.service.oper.hc.FatpQustHistService;
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
public class FatpQustHistController {

    @Resource(name = "sqlSessionTemplate")
    private SqlSessionTemplate dao;

    @Autowired
    private FatpQustHistService fatpQustHistService;

    // 성장/비만_지수_이력 리스트 조회
    @ResponseBody
    @RequestMapping("/oper/hc/fatpQustHist/searchFatpQustHistList.ab")
    public RtnMsg searchFatpQustHistList(@RequestBody(required = false) Map<String, String> params) throws BizException {
        RtnMsg vo = new RtnMsg();
        Map<String, Object> rtnMap = new HashMap<String, Object>();

        List<Map<String, String>> result = fatpQustHistService.searchFatpQustHistList(params);
        rtnMap.put("result", result);

        if (!GEUtil.isEmpty(params.get("paging"))) {
            params.put("paging", "N");
            vo.setTotalCount(((List) fatpQustHistService.searchFatpQustHistList(params)).size());
        }

        vo.setRtnData(rtnMap, params);

        return vo;
    }

    //비만예측설문조사_이력 리스트 엑셀다운로드
    @ResponseBody
    @RequestMapping("/oper/hc/fatpQustHist/searchFatpQustHistList/excel.ab")
    public ModelAndView downloadExcel(@RequestBody(required = false) Map<String, String> params) throws BizException {

        params.put("paging", "N");
        List<Map<String, String>> result = dao.selectList("oper.hc.fatpQustHist.selectFatpQustHistList", params);

        return new ModelAndView("excelXlsView", getExcelMap(result));
    }

    private Map<String, Object> getExcelMap(List<Map<String, String>> list) {
        String[] arrHeader = { "기준일자",
                               "학생 번호",
                               "학생 명",
                               "성별",
                               "나이(년)",
                               "주 평균 라면 섭취 횟수",
                               "주 평균 음료수 섭취 횟수",
                               "주 평균 패스트푸드 섭취 횟수",
                               "주 평균 육류 섭취 횟수",
                               "주 평균 유제품 섭취 횟수",
                               "주 평균 과일 섭취 횟수",
                               "주 평균 야채 (김치 제외) 섭취 횟수",
                               "주 평균 아침 결식 횟수",
                               "비만 예측 BMI",
                               "비만 예측 지수",
                               "비만 예측 판정 코드",
                               "비만 예측 판정 설명",
                            };
        List<String> headerList = Arrays.asList(arrHeader);

        List<List<String>> dataList = new ArrayList<List<String>>();
        List<String> data;

        for (Map<String, String> info : list) {
            data = new ArrayList<String>();

            data.add(info.get("stndDt"));                     //기준_일자
            data.add(String.valueOf(info.get("stdtNo")));     //학생_번호
            data.add(info.get("stdtNm"));                     //학생_명
            data.add(info.get("sexCdNm"));                    //성별_코드
            data.add(String.valueOf(info.get("ageYcnt")));    //나이_년수
            data.add(String.valueOf(info.get("qustNo1")));    //1번_질문_설문_내용
            data.add(String.valueOf(info.get("qustNo2")));    //2번_질문_설문_내용
            data.add(String.valueOf(info.get("qustNo3")));    //3번_질문_설문_내용
            data.add(String.valueOf(info.get("qustNo4")));    //4번_질문_설문_내용
            data.add(String.valueOf(info.get("qustNo5")));    //5번_질문_설문_내용
            data.add(String.valueOf(info.get("qustNo6")));    //6번_질문_설문_내용
            data.add(String.valueOf(info.get("qustNo7")));    //7번_질문_설문_내용
            data.add(String.valueOf(info.get("qustNo8")));    //8번_질문_설문_내용
            data.add(String.valueOf(info.get("fatpBmiVal"))); //비만예측_BMI_값
            data.add(String.valueOf(info.get("fatpIdx")));    //비만예측_지수
            data.add(info.get("fatpJudgCd"));                 //비만예측_판정_코드
            data.add(info.get("fatpJudgDesc"));               //비만예측_판정_설명

            dataList.add(data);
        }

        Map<String, Object> map = new HashMap<>();
        map.put(ExcelConstant.FILE_NAME, "excel");
        map.put(ExcelConstant.HEAD, headerList);
        map.put(ExcelConstant.BODY, dataList);
        return map;
    }
}
