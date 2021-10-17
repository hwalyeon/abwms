package kr.hubble.api.service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import com.google.firebase.messaging.FirebaseMessagingException;

import kr.hubble.api.domain.vo.common.AddrResultVO;
import kr.hubble.api.domain.vo.common.CoordResultVO;
import kr.hubble.api.domain.vo.juso.CoordRequest;
import kr.hubble.exception.BaseException;

public interface CommonService {

	AddrResultVO srchAddr(String srchWord, int curPage, int cntPerPage) throws BaseException;

	CoordResultVO srchCoord(CoordRequest request) throws BaseException;

	void sendFcmByTopic(String topic, String title, String message, String action, String seq)
			throws BaseException;

	void sendFcmByUsers(List<String> tokens, String title, String message, String action, String seq)
			throws BaseException;

	void sendFcmBySql(String sqlId, Map<String, Object> sqlParam, String title, String message, String action,
			String seq) throws BaseException;

}
