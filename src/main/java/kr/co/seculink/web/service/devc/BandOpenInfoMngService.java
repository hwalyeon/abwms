package kr.co.seculink.web.service.devc;

import kr.co.seculink.exception.BizException;

import java.util.List;
import java.util.Map;

public interface BandOpenInfoMngService
{
	//밴드/개통정보_리스트 조회
	public List<Map<String, String>> searchBandOpenInfoList(Map<String, String> params) throws BizException;
/*

	//행추가_행삭제_저장
	public void saveDdRcmdEatStnd(Map<String, Object> params) throws BizException;
*/

	}
