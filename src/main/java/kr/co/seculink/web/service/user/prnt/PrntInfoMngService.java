package kr.co.seculink.web.service.user.prnt;

import kr.co.seculink.exception.BizException;

import java.util.List;
import java.util.Map;

public interface PrntInfoMngService
{
	//보호자(사용자)_정보_리스트 조회
	public List<Map<String, String>> searchPrntInfoList(Map<String, String> params) throws BizException;

/*	//행추가_행삭제_저장
	public void saveBandOpenInfo(Map<String, Object> params) throws BizException;

	//밴드ID 중복 조회
	public Map<String, String> searchDupBandId(Map<String, String> params) throws BizException;

	//밴드ID 채번
	public Map<String, Object> numberingBandId(Map<String, String> params) throws BizException;

	//밴드_정보_저장
	public void saveBandOpenInfoDetl(Map<String, Object> params) throws BizException;

	//밴드_정보_상세보기
	public Map<String, Object> searchBandOpenInfo(Map<String, String> params) throws BizException;*/

	
}
