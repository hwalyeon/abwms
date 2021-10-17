package kr.hubble.web.service.clss;

import java.util.Map;

import kr.hubble.exception.BizException;
import kr.hubble.web.model.TcFileVO;

public interface CousTakeService
{
	public void procEvent(Map<String, String> params) throws BizException;
	
	public void reqAttd(Map<String, String> params, TcFileVO tcFileVo) throws BizException;
	
	public void checkSeat(Map<String, String> params, TcFileVO tcFileVo) throws BizException;
}
