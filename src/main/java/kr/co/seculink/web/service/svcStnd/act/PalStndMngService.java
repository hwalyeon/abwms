package kr.co.seculink.web.service.svcStnd.act;

import kr.co.seculink.exception.BizException;

import java.util.List;
import java.util.Map;

public interface PalStndMngService
{
	//신체활동수준_기준_리스트 조회
	List<Map<String, String>> searchPalStndList(Map<String, String> params) throws BizException;

	//신체활동수준_기준_상세보기 조회
	List<Map<String, String>> searchPalStndInfo(Map<String, String> params) throws BizException;

	//행추가_행삭제 저장
	void savePalStnd(Map<String,Object> params) throws BizException;

	//상세보기_저장
	void savePalStndInfo(Map<String,Object> params) throws BizException;

}
