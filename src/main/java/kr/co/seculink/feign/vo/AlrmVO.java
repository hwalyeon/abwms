package kr.co.seculink.feign.vo;

import lombok.Data;

@Data
public class AlrmVO
{
    private String alamTypeCd;
    private Double stdtNo;
    private Double guarNo;
    private Double judgNo;
    private Double dactJudgNo;
    private Double dgemHistSeq;
    private Double strsHistSeq;
    private Double locHistNo;
    private Double cbeeHistNo;
    private String gfixDt;
    private String alamTitl;
    private String alamCntn;
    private String etcAlamCntn;
    private String refUrl;
    private String refData;
    private String userId;

    private Double alamNo;
    private String rsltCd;
    private String rsltCntn;
}
