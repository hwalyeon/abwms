package kr.co.seculink.web.service.stat.hc;

import kr.co.seculink.exception.BizException;
import kr.co.seculink.util.XUtil;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service("strsStssService")
public class StrsStssServiceImpl implements StrsStssService
{

	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate dao;

	public List<Map<String, Object>> searchStrsStssList(Map<String, String> params) throws BizException
	{
		List<Map<String, Object>> result = dao.selectList("stat.hc.strsStss.searchStrsStssList", params);
		
	      List<Map<String, Object>> outList = new ArrayList<Map<String, Object>>();
	        
	        String currStrsTypeCd = "";
	        Map<String,Object> tmp = new HashMap<String,Object>();
	        boolean bPending = false;
	        
	        for (int i = 0; i < result.size(); i++)
	        {
	            Map<String,Object> map = result.get(i);
	            
	            String strsTypeCd = XUtil.getString (map.get("strsTypeCd"));
	            String strsTypeNm = XUtil.getString (map.get("strsTypeNm"));
	            String stndDt     = XUtil.getString (map.get("stndDt"    ));
	            String avgIdx     = XUtil.getDecimal(map.get("avgIdx"    ));
	            
	            if (i == 0)
	            {
	                tmp = new HashMap<String,Object>();
	                bPending = true;
	                tmp.put("strsTypeCd", strsTypeCd);
	                tmp.put("strsTypeNm", strsTypeNm);
	                
	                currStrsTypeCd = strsTypeCd;
	            }
	            else if (strsTypeCd.equals(currStrsTypeCd) == false)
	            {
	                outList.add(tmp);
	                bPending = false;
	                
	                tmp = new HashMap<String,Object>();
	                tmp.put("strsTypeCd", strsTypeCd);
	                tmp.put("strsTypeNm", strsTypeNm);
	                
	                currStrsTypeCd = strsTypeCd;
	            }
	            else if (strsTypeCd.equals(currStrsTypeCd))
	            {
	                bPending = true; 
	            }
	            
	            tmp.put( stndDt     , avgIdx   );
	        }
	        if (bPending) outList.add(tmp);
	        
	        return outList;

/*
		List<Map<String, Object>> newResult = new ArrayList<Map<String, Object>>();

		if(result != null && result.size() > 0){
			Map<String, Object> newInfo = new HashMap<String, Object>();
			String strsTypeNm = null;
			String strsTypeCd = null;
			for (Map<String, Object> info : result){
				if(strsTypeNm != null && !strsTypeNm.equals(info.get("strsTypeNm").toString())){
					newInfo.put("strsTypeNm", strsTypeNm);
					newInfo.put("strsTypeCd", strsTypeCd);
					newResult.add(newInfo);
					newInfo = new HashMap<String, Object>();
				}
				newInfo.put(info.get("stndDt").toString(), info.get("avgIdx").toString());
				strsTypeNm = info.get("strsTypeNm").toString();
				strsTypeCd = info.get("strsTypeCd").toString();
			}
			newInfo.put("strsTypeNm", strsTypeNm);
			newInfo.put("strsTypeCd", strsTypeCd);
			newResult.add(newInfo);
		}
		return newResult;
*/		
	}


	public List<Map<String, Object>> searchStrsJudgList(Map<String, String> params) throws BizException
	{
		List<Map<String, Object>> result = dao.selectList("stat.hc.strsStss.searchStrsJudgList", params);

		List<Map<String, Object>> newResult = new ArrayList<Map<String, Object>>();

		if(result != null && result.size() > 0){
			Map<String, Object> newInfo = new HashMap<String, Object>();
			Map<String, Object> newInfoPer = new HashMap<String, Object>();
			String total = null;
			for (Map<String, Object> info : result){
				newInfo.put(info.get("strsStatCd").toString(), info.get("occrCnt").toString());
				newInfoPer.put(info.get("strsStatCd").toString(), info.get("occrPer").toString());
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

