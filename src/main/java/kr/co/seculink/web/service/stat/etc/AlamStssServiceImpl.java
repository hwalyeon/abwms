package kr.co.seculink.web.service.stat.etc;

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
@Service("alamStssService")
public class AlamStssServiceImpl implements AlamStssService
{

	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate dao;

	public List<Map<String, Object>> searchAlamStssList(Map<String, String> params) throws BizException
	{
		List<Map<String, Object>> result = dao.selectList("stat.etc.alamStss.searchAlamStssList", params);

		List<Map<String, Object>> newResult = new ArrayList<Map<String, Object>>();

		if(result != null && result.size() > 0){
			Map<String, Object> newInfo = new HashMap<String, Object>();
			String alamTypeNm = null;
			String alamTypeCd = null;
			for (Map<String, Object> info : result){
				if(alamTypeNm != null && !alamTypeNm.equals(info.get("alamTypeNm").toString())){
					newInfo.put("alamTypeNm", alamTypeNm);
					newInfo.put("alamTypeCd", alamTypeCd);
					newResult.add(newInfo);
					newInfo = new HashMap<String, Object>();
				}
				newInfo.put(info.get("stndDt").toString(), info.get("alamCnt").toString());
				alamTypeNm = info.get("alamTypeNm").toString();
				alamTypeCd = info.get("alamTypeCd").toString();
			}
			newInfo.put("alamTypeNm", alamTypeNm);
			newInfo.put("alamTypeCd", alamTypeCd);
			newResult.add(newInfo);
		}
		return newResult;
	}

}

