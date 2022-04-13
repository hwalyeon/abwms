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
@Service("foodEatStssService")
public class FoodEatStssServiceImpl implements FoodEatStssService
{
    @Resource(name="sqlSessionTemplate")
    private SqlSessionTemplate dao;

    public List<Map<String, Object>> searchFoodEatStssList(Map<String, String> params) throws BizException {
        List<Map<String, Object>> result = dao.selectList("stat.hc.foodEatStss.searchFoodEatStssList", params);

        List<Map<String, Object>> newResult = new ArrayList<Map<String, Object>>();

        if(result != null && result.size() > 0) {
            Map<String, Object> newInfo = new HashMap<String, Object>();
            String foodNm = null;
            for (Map<String, Object> info : result) {
                if(foodNm != null && !foodNm.equals(info.get("foodNm"))){
                    newInfo.put("foodNm", foodNm);
                    newResult.add(newInfo);
                    newInfo = new HashMap<String, Object>();
                }
                newInfo.put(info.get("stndDt").toString(), info.get("avgCalEatQty").toString());
                foodNm = info.get("foodNm").toString();
            }
            newInfo.put("foodNm", foodNm);
            newResult.add(newInfo);
        }

        return newResult;
    }

}
