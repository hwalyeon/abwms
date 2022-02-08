package kr.co.seculink.web.service.svcStnd.grow;

import kr.co.seculink.exception.BizException;

import java.util.List;
import java.util.Map;

public interface GrowStndMngService
{
	public List<Map<String, String>> growStndVerList(Map<String, String> params) throws BizException;

	public List<Map<String, String>> ageYcntList(Map<String, String> params) throws BizException;

	public List<Map<String, String>> growStndList(Map<String, String> params) throws BizException;

	/*
	public Map<String, String> searchUserInfo(Map<String, String> params) throws BizException;

	public void saveAcdm(Map<String, String> params) throws BizException;

	public void saveLctr(MultipartFile uploadImg, Map<String, String> params) throws BizException;

	public void saveStdt(MultipartFile profImg, List<MultipartFile> uploadImgList, List<Map<String, String>> delImgList, Map<String, String> params) throws BizException;

	public void saveUser(Map<String, String> params) throws BizException;

	public void updateUserPw(Map<String, String> params) throws BizException;

	public Map<String, String> searchDupUserId(Map<String, String> params) throws BizException;*/
}
