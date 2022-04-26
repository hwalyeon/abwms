package kr.co.seculink.feign.service;

import kr.co.seculink.exception.BizException;
import kr.co.seculink.feign.vo.AlrmVO;
import kr.co.seculink.feign.vo.HlthCareVO;

public interface FeignService
{
    public static final String EVNT_DIV_CD_BODY = "body";  // 학생/부모의 신체정보가 변경된 경우
    public static final String EVNT_DIV_CD_EAT  = "eat" ;  // 음식물 섭취 등록인 경우
    public static final String EVNT_DIV_CD_ACT  = "act" ;  // 운동 등록인 경우
    public static final String EVNT_DIV_CD_FATP = "fatp";  // 비만예측 처리요청

    AlrmVO sendPush(AlrmVO params) throws BizException;

    HlthCareVO chagneBodyInfo(HlthCareVO params) throws BizException;
}
