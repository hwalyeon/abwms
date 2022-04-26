package kr.co.seculink.feign.vo;

import lombok.Data;

@Data
public class HlthCareVO
{
    // 이벤트구분코드
    private String evntDivCd;

    // 입력공통
    private String stndDt;
    private String stdtNo;
    private String userId;

    // 결과기록
    private String rsltCd;
    private String rsltCntn;
}
