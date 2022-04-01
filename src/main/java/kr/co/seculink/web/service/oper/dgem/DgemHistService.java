package kr.co.seculink.web.service.oper.dgem;

import kr.co.seculink.exception.BizException;

import java.util.List;
import java.util.Map;

public interface DgemHistService
{
	//위험감정 발생이력 목록
	public List<Map<String, String>> searchDgemHistList(Map<String, String> params) throws BizException;
	//학생정보 및 보호자 정보
	public List<Map<String, String>> searchStdtGuarList(Map<String, String> params) throws BizException;
	//학교정보 리스트 조회
	public List<Map<String, String>> searchLocList(Map<String, String> params) throws BizException;
}

