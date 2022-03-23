package kr.co.seculink.web.service.user.prnt;

import kr.co.seculink.exception.BizException;

import java.util.Map;

public interface PrntInfoMngService
{
	//학부모정보 조회
	public Map<String, Object> searchPrntInfo(Map<String, Object> params) throws BizException;

	//학부모_정보 저장
	public void savePrntInfoDetl(Map<String, Object> params) throws BizException;


}
