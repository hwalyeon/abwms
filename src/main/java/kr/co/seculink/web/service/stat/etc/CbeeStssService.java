package kr.co.seculink.web.service.stat.etc;

import kr.co.seculink.exception.BizException;

import java.util.List;
import java.util.Map;

public interface CbeeStssService
{
    public List<Map<String, Object>> searchCbeeStssList(Map<String, String> params) throws BizException;
}

