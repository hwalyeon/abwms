package kr.hubble.web.service.clss;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.seculink.exception.BizException;

@Service("hworkMngService")
public class HworkMngServiceImpl implements HworkMngService
{
	@Autowired
	private SqlSessionTemplate dao;
	
	public List<Map<String, String>> searchCousList(Map<String, String> params) throws BizException
	{
		return dao.selectList("clss.hworkMng.selectCousList", params);
	}
	
	public List<Map<String, String>> searchHworkList(Map<String, String> params) throws BizException
	{
		return dao.selectList("clss.hworkMng.selectHworkList", params);
	}
	
	public Map<String, String> selectTsCousHworkBase(Map<String, String> params) throws BizException
	{
		return dao.selectOne("clss.hworkMng.selectTsCousHworkBase", params);
	}
	
	public List<Map<String, String>> selectTsCousHworkDetl(Map<String, String> params) throws BizException
	{
		return dao.selectList("clss.hworkMng.selectTsCousHworkDetl", params);
	}
	
	public List<Map<String, String>> selectTsHworkSolvDetl(Map<String, String> params) throws BizException
	{
		return dao.selectList("clss.hworkMng.selectTsHworkSolvDetl", params);
	}
	
	public void defaultTsHworkSolvDetl(Map<String, String> params) throws BizException
	{
		dao.delete("clss.hworkMng.deleteTsHworkSolvDetl", params);
		dao.insert("clss.hworkMng.insertTsHworkSolvDetl", params);
	}
	
	public void defaultTsCousTakeDetl(Map<String, String> params) throws BizException
	{
		dao.insert("clss.hworkMng.insertTsCousTakeDetl", params);
	}	
	
	@Transactional
	public void saveAnswer(Map<String, Object> params) throws BizException
	{
		String cousNo  = (String) params.get("cousNo");
		String lectSeq = (String) params.get("lectSeq");
		String stdtId  = (String) params.get("stdtId");
		
		List<Map<String, String>> answerList = (List<Map<String, String>>) params.get("answList");
		
		for ( Map<String, String> answer : answerList)
		{
			answer.put("cousNo" , cousNo);
			answer.put("lectSeq", lectSeq);
			answer.put("stdtId" , stdtId);
			dao.insert("clss.hworkMng.updateTsHworkSolvDetl", answer);
		}
		
		Map<String, String> hworkSbmtMap = new HashMap<>();
		hworkSbmtMap.put("cousNo"       , cousNo);
		hworkSbmtMap.put("lectSeq"      , lectSeq);
		hworkSbmtMap.put("stdtId"       , stdtId);
		dao.update("clss.hworkMng.updateHworkSbmt", hworkSbmtMap);
	}
	
	public void updateHworkFile(Map<String, String> params) throws BizException
	{
		dao.update("clss.hworkMng.updateHworkSbmt", params);
	}
	
	public void deleteHworkFile(Map<String, String> params) throws BizException
	{
		dao.update("clss.hworkMng.deleteHworkSbmt", params);
	}
}
