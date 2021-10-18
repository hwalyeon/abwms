package kr.hubble.web.service.clss;

import java.util.List;
import java.util.Map;

import kr.co.seculink.exception.BizException;

public interface HworkMngService
{
	public List<Map<String, String>> searchCousList(Map<String, String> params) throws BizException;
	
	public List<Map<String, String>> searchHworkList(Map<String, String> params) throws BizException;
	
	public Map<String, String> selectTsCousHworkBase(Map<String, String> params) throws BizException;
	
	public List<Map<String, String>> selectTsCousHworkDetl(Map<String, String> params) throws BizException;
	
	public List<Map<String, String>> selectTsHworkSolvDetl(Map<String, String> params) throws BizException;

	public void defaultTsHworkSolvDetl(Map<String, String> params) throws BizException;
	
	public void defaultTsCousTakeDetl(Map<String, String> params) throws BizException;
	
	public void saveAnswer(Map<String, Object> params) throws BizException;
	
	public void updateHworkFile(Map<String, String> params) throws BizException;
	
	public void deleteHworkFile(Map<String, String> params) throws BizException;
}
