package kr.co.seculink.web.service.stat.hc;

import kr.co.seculink.exception.BizException;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service("fatpStssService")
public class FatpStssServiceImpl implements FatpStssService
{

	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate dao;

	public List<Map<String, Object>> searchFatpStssList(Map<String, String> params) throws BizException
	{
		List<Map<String, Object>> result = dao.selectList("stat.hc.fatpStss.searchFatpStssList", params);

		List<Map<String, Object>> newResult = new ArrayList<Map<String, Object>>();

		if(result != null && result.size() > 0){
			Map<String, Object> newInfo = new HashMap<String, Object>();
			for (Map<String, Object> info : result){
				newInfo.put(info.get("stndDt").toString(), info.get("avgIdx").toString());
			}
			newInfo.put("divCd", "비만예측지수");
			newResult.add(newInfo);
		}
		return newResult;
	}


	public List<Map<String, Object>> searchFatpJudgList(Map<String, String> params) throws BizException
	{
		List<Map<String, Object>> result = dao.selectList("stat.hc.fatpStss.searchFatpJudgList", params);

		List<Map<String, Object>> newResult = new ArrayList<Map<String, Object>>();

		if(result != null && result.size() > 0){
			Map<String, Object> newInfo = new HashMap<String, Object>();
			Map<String, Object> newInfoPer = new HashMap<String, Object>();
			String total = null;
			for (Map<String, Object> info : result){
				newInfo.put(info.get("fatpJudgCd").toString(), info.get("occrCnt").toString());
				newInfoPer.put(info.get("fatpJudgCd").toString(), info.get("occrPer").toString());
				total = info.get("totCnt").toString();
			}
			newInfo.put("divCd", "발생건수");
			newInfoPer.put("divCd", "발생비율(%)");
			newInfo.put("total", total);
			newInfoPer.put("total", "100");
			newResult.add(newInfo);
			newResult.add(newInfoPer);
		}
		return newResult;
	}

}

