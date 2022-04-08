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
@Service("avalActStssService")
public class AvalActStssServiceImpl implements AvalActStssService
{
    @Resource(name="sqlSessionTemplate")
    private SqlSessionTemplate dao;

    public List<Map<String, Object>> searchAvalActStssList(Map<String, String> params) throws BizException
    {
        List<Map<String, Object>> result = dao.selectList("stat.hc.avalActStss.searchAvalActStssList", params);

        List<Map<String, Object>> newResult = new ArrayList<Map<String, Object>>();

        if(result != null && result.size() > 0){
            Map<String, Object> newInfo = new HashMap<String, Object>();
            for (Map<String, Object> info : result){
                newInfo.put(info.get("stndDt").toString(), info.get("avgActEatQty").toString());
            }
            newInfo.put("divCd", "평균 칼로리 섭취 량");
            newResult.add(newInfo);
        }
        return newResult;
    }



}

