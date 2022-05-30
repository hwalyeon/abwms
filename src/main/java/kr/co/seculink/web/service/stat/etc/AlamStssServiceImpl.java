package kr.co.seculink.web.service.stat.etc;

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
@Service("alamStssService")
public class AlamStssServiceImpl implements AlamStssService
{

	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate dao;

	public List<Map<String, Object>> searchAlamStssList(Map<String, String> params) throws BizException
	{
		List<Map<String, Object>> result = dao.selectList("stat.etc.alamStss.searchAlamStssList", params);

		List<Map<String, Object>> outList = new ArrayList<Map<String, Object>>();
		
		String currAlamTypeCd = "";
		Map<String,Object> tmp = new HashMap<String,Object>();
		boolean bPending = false;
		
		for (int i = 0; i < result.size(); i++)
		{
		    Map<String,Object> map = result.get(i);
		    
		    String alamTypeCd = XUtil.getString (map.get("alamTypeCd"));
		    String alamTypeNm = XUtil.getString (map.get("alamTypeNm"));
		    String stndDt     = XUtil.getString (map.get("stndDt"    ));
		    String alamCnt    = XUtil.getDecimal(map.get("alamCnt"   ));
		    
		    if (i == 0)
		    {
		        tmp = new HashMap<String,Object>();
		        bPending = true;
	            tmp.put("alamTypeCd", alamTypeCd);
	            tmp.put("alamTypeNm", alamTypeNm);
	            
	            currAlamTypeCd = alamTypeCd;
		    }
		    else if (alamTypeCd.equals(currAlamTypeCd) == false)
		    {
		        outList.add(tmp);
		        bPending = false;
		        
	            tmp = new HashMap<String,Object>();
	            tmp.put("alamTypeCd", alamTypeCd);
	            tmp.put("alamTypeNm", alamTypeNm);
                
                currAlamTypeCd = alamTypeCd;
		    }
		    else if (alamTypeCd.equals(currAlamTypeCd))
		    {
		        bPending = true; 
		    }
		    
            tmp.put( stndDt     , alamCnt   );
		}
		if (bPending) outList.add(tmp);
		
		return outList;
	}

}

