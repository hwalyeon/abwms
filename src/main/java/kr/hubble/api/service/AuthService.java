package kr.hubble.api.service;

import java.util.Map;

import kr.hubble.exception.BaseException;

public interface AuthService {

	Integer regUser(Map<String, Object> params) throws BaseException;

	Integer regFcmTokn(Map<String, Object> params) throws BaseException;

}
