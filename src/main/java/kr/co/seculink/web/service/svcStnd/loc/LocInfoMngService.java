package kr.co.seculink.web.service.svcStnd.loc;

import kr.co.seculink.exception.BizException;

import java.util.List;
import java.util.Map;

public interface LocInfoMngService
{
	// 위치정보_관리_조회_조건_조회_1
	List<Map<String, String>> searchLocInfoSelect(Map<String, String> params) throws BizException;

	// 위치정보_관리_조회_조건_조회_2
	List<Map<String, String>> searchLocInfoSelect2(Map<String, String> params) throws BizException;

	// 위치정보_관리_보호자_학생_조건_조회
	List<Map<String, String>> searchGuarNoSelect(Map<String, String> params) throws BizException;

	// 위치정보_관리_보호자_학생_조건_조회_2
	List<Map<String, String>> searchStdtNoSelect(Map<String, String> params) throws BizException;

	// 위치정보_관리_리스트_조회
	List<Map<String, String>> searchLocInfoList(Map<String, String> params) throws BizException;

	// 위치정보_관리_리스트_상세정보_조회
	List<Map<String, String>> searchLocInfoSpec(Map<String, String> params) throws BizException;

	// 위치정보_관리_상세정보_저장
	void saveLocInfoSpec(Map<String,Object> params) throws BizException;

	// 위치정보_관리_학생_보호자_조회
	List<Map<String, String>> searchLocStdtGuarList(Map<String, String> params) throws BizException;

}
