package kr.co.seculink.web.service.stat.hc;

import kr.co.seculink.exception.BizException;

import java.util.List;
import java.util.Map;

public interface AvalCalStssService
{
    public List<Map<String, Object>> searchAvalCalStssList(Map<String, String> params) throws BizException;
}

