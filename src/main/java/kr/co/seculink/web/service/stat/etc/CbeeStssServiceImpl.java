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
@Service("cbeeStssService")
public class CbeeStssServiceImpl implements CbeeStssService
{
    @Resource(name="sqlSessionTemplate")
    private SqlSessionTemplate dao;

    public List<Map<String, Object>> searchCbeeStssList(Map<String, String> params) throws BizException
    {
        List<Map<String, Object>> result = dao.selectList("stat.etc.cbeeStss.searchCbeeStssList", params);

        List<Map<String, Object>> newResult = new ArrayList<Map<String, Object>>();

        if(result != null && result.size() > 0){
            Map<String, Object> newInfo = new HashMap<String, Object>();
            for (Map<String, Object> info : result){
                newInfo.put(info.get("stndDt").toString(), info.get("cbeeAmt").toString());
            }
            newInfo.put("divCd", "캐시비 사용금액");
            newResult.add(newInfo);
        }
        return newResult;
    }


}

