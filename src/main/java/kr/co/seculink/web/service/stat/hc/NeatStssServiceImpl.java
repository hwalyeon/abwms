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
@Service("neatStssService")
public class NeatStssServiceImpl implements NeatStssService
{
    @Resource(name="sqlSessionTemplate")
    private SqlSessionTemplate dao;

    public List<Map<String, Object>> searchNeatStssList(Map<String, String> params) throws BizException
    {
        List<Map<String, Object>> result = dao.selectList("stat.hc.neatStss.searchNeatStssList", params);

        List<Map<String, Object>> newResult = new ArrayList<Map<String, Object>>();

        if(result != null && result.size() > 0){
            Map<String, Object> newInfo          = new HashMap<String, Object>();
            Map<String, Object> newInfoNeatPer = new HashMap<>();

            for (Map<String, Object> info : result){
                newInfo.put(info.get("stndDt").toString(), info.get("neatCnt").toString());
                newInfoNeatPer.put(info.get("stndDt").toString(), info.get("neatPer").toString());
            }

            newInfo.put("divCd", "결식건수");
            newInfoNeatPer.put("divCd", "결식율(%)");
            newResult.add(newInfo);
            newResult.add(newInfoNeatPer);

            System.out.println("result"+result);
            System.out.println("newInfoNeatPer"+newInfoNeatPer);
            System.out.println("newInfo"+newInfo);
        }
        return newResult;
    }
}

