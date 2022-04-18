package kr.co.seculink.web.service.svcStnd.fat;

import kr.co.seculink.exception.BizException;

import java.util.List;
import java.util.Map;

public interface FatpQustMngService
{
	//비만예측_설문_기본_리스트 조회
	public List<Map<String, String>> searchFatpQustBaseList(Map<String, String> params) throws BizException;

	//비만예측_설문_기본 저장
	public void saveFatpQustBaseDetl(Map<String, Object> params) throws BizException;

	//비만예측_설문_상세_리스트 조회
	public List<Map<String, String>> searchFatpQustSpecList(Map<String, String> params) throws BizException;

	//비만예측_설문_상세_정보 조회(팝업)
	public Map<String, Object> searchFatpQustSpecInfo(Map<String, String> params) throws BizException;

    //비만예측_설문_상세 저장
	public void saveFatpQustSpecDetl(Map<String, Object> params) throws BizException;

}
 