package kr.co.seculink.web.service.oper.hc;

import kr.co.seculink.exception.BizException;

import java.util.List;
import java.util.Map;

public interface FatpQustHistService
{
    public List<Map<String, String>> searchFatpQustHistList(Map<String, String> params) throws BizException;
}
 