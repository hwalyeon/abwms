package kr.co.seculink.web.service.devc.band;//

import kr.co.seculink.exception.BizException;

import java.util.List;
import java.util.Map;

public interface BandOpenInfoMngService
{
	//밴드/개통정보_리스트 조회
	public List<Map<String, String>> searchBandOpenInfoList(Map<String, String> params) throws BizException;

	//밴드/개통정보_보호자_전화번호_리스트 조회
	public List<Map<String, String>> searchBandOpenInfoGuarTelNoList(Map<String, String> params) throws BizException;

	//밴드ID 중복 조회
	public Map<String, String> searchDupBandId(Map<String, String> params) throws BizException;

	//밴드ID 채번
	public Map<String, Object> numberingBandId(Map<String, String> params) throws BizException;

	//밴드_정보_저장
	public void saveBandOpenInfoDetl(Map<String, Object> params) throws BizException;

}
