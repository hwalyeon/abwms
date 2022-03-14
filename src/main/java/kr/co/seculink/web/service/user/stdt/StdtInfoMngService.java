package kr.co.seculink.web.service.user.stdt;

import kr.co.seculink.exception.BizException;

import java.util.List;
import java.util.Map;

public interface StdtInfoMngService
{
	//학생정보 리스트 조회
	public List<Map<String, String>> searchStdtInfoList(Map<String, String> params) throws BizException;

	//밴드ID 중복 조회
	public Map<String, String> searchDupBandId(Map<String, String> parmas) throws BizException;

	//밴드ID 채번
	public Map<String, Object> numberingBandId(Map<String, String> params) throws BizException;

	//밴드_정보_저장
	public void saveBandOpenInfoDetl(Map<String, Object> params) throws BizException;

	//밴드_정보_상세보기
	public Map<String, Object> searchBandOpenInfo(Map<String, String> params) throws BizException;

	//행추가_행삭제_저장
	public void saveBandOpenDetlGuarTelNo(Map<String, Object> params) throws BizException;
}

