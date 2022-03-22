package kr.co.seculink.web.service.user.guar;

import kr.co.seculink.exception.BizException;

import java.util.List;
import java.util.Map;

public interface GuarInfoMngService
{
	//보호자(사용자)_정보_리스트 조회
	public List<Map<String, String>> searchGuarInfoList(Map<String, String> params) throws BizException;

	//보호자(사용자)_정보 상세보기
	public Map<String, Object> searchGuarInfo(Map<String, String> params) throws BizException;

	//보호자(사용자)_정보 저장
	public void saveGuarInfoDetl(Map<String, Object> params) throws BizException;

	//약관동의여부_정보 상세보기
	public List<Map<String, Object>> searchTermAgreYnInfoDetlList(Map<String, String> params) throws BizException;

	//학부모_정보 저장
	public void savePrntInfoDetl(Map<String, Object> params) throws BizException;

/*
	//보호자(약관동의여부_정보 저장
	public void saveTermAgreYnInfoDetl(Map<String, Object> params) throws BizException;*/

}
