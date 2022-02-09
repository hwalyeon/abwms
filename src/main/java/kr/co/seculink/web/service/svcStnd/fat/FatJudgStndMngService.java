package kr.co.seculink.web.service.svcStnd.fat;

import kr.co.seculink.exception.BizException;

import java.util.List;
import java.util.Map;

public interface BpalCalcStndMngService
{
	public List<Map<String, String>> searchBpalCalcList(Map<String, String> params) throws BizException;
}

