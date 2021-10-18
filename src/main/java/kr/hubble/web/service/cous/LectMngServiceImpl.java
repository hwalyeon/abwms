package kr.hubble.web.service.cous;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import kr.co.seculink.exception.BizException;

@Service("lectMngService")
public class LectMngServiceImpl implements LectMngService
{
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate dao;
	
	public List<Map<String, String>> searchLectTakeObj() throws BizException
	{
		return dao.selectList("lect.lectMng.selectLectTakeObj");
	}
	
	public void insertLectTake(Map<String, String> params) throws BizException
	{
		dao.insert("lect.lectMng.insertTsCousTakeDetl", params);
	}
	
	public void updateChangeCousStdtStat() throws BizException
	{
		dao.update("lect.lectMng.updateChangeCousStdtStat");
	}
	
	public void updateChangeCousStat() throws BizException
	{
		dao.update("lect.lectMng.updateChangeCousStat");
	}
}
