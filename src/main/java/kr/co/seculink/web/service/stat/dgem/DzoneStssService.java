package kr.co.seculink.web.service.stat.dgem;

import kr.co.seculink.exception.BizException;

import java.util.List;
import java.util.Map;

public interface DzoneStssService
{
    public List<Map<String, Object>> searchAvalActStssList(Map<String, String> params) throws BizException;
}

