package kr.co.seculink.web.service.user.stdt;

import kr.co.seculink.exception.BizException;

import java.util.List;
import java.util.Map;

public interface StdtInfoMngService
{
	//학생정보 리스트 조회
	public List<Map<String, String>> searchStdtInfoList(Map<String, String> params) throws BizException;
}

