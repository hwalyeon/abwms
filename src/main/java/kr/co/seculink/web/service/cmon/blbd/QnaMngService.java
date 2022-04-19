package kr.co.seculink.web.service.cmon.blbd;

import kr.co.seculink.exception.BizException;

import java.util.List;
import java.util.Map;

public interface QnaMngService
{
    //질의응답_리스트 조회
    public List<Map<String, Object>> searchQnaList(Map<String,String> params) throws BizException;
}
 