package kr.co.seculink.web.service.svcStnd.strs;

import kr.co.seculink.exception.BizException;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface StrsStndMngService
{
	//스트레스 리스트 조회
	public List<Map<String, String>> searchStrsList(Map<String, String> params) throws BizException;

	//스트레스 코드 리스트 조회
	public List<Map<String, String>> searchCdSpecList(Map<String, String> params) throws BizException;
}

