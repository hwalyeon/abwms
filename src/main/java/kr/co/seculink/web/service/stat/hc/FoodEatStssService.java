package kr.co.seculink.web.service.stat.hc;

import kr.co.seculink.exception.BizException;

import java.util.List;
import java.util.Map;

public interface FoodEatStssService
{
    public List<Map<String, Object>> searchFoodEatStssList(Map<String, String> params) throws BizException;
}

