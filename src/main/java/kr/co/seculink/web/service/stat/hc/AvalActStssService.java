package kr.co.seculink.web.service.stat.hc;

import kr.co.seculink.exception.BizException;

import java.util.List;
import java.util.Map;

public interface AvalActStssService
{
    public List<Map<String, Object>> searchAvalActStssList(Map<String, String> params) throws BizException;
}

