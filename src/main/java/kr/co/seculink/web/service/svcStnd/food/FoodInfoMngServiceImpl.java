package kr.co.seculink.web.service.svcStnd.food;

import kr.co.seculink.domain.vo.TsBandSpecVo;
import kr.co.seculink.exception.BizException;
import kr.co.seculink.web.service.cmon.FileService;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Slf4j
@Service("foodInfoMngService")
public class FoodInfoMngServiceImpl implements FoodInfoMngService
{
	@Autowired
	private FileService fileService;
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate dao;
	
	public List<Map<String, String>> searchFoodInfoList(Map<String, String> params) throws BizException
	{
		List<Map<String, String>> result = dao.selectList("svcStnd.food.foodInfoMng.searchFoodInfoList", params);

		return result;
	}


	public void saveFoodInfo(Map<String, Object> params) throws BizException
	{
		Map<String, Object> foodInfo = (Map<String, Object>) params.get("foodInfo");

		List<Map<String, Object>> gridData = (List<Map<String, Object>>) params.get("gridData");

		// 동일식품명 검색
		int foodCnt = dao.selectOne("svcStnd.food.foodInfoMng.searchFoodInfoCnt", foodInfo);

		if(foodCnt > 0){
			throw new BizException("등록된 식품명입니다. 식품명을 확인하여 주시기 바랍니다.");
		}

		// 식품정보
		if ("C".equals(foodInfo.get("crud").toString())){
			Double foodNo = dao.selectOne("svcStnd.food.foodInfoMng.selectTiFoodInfoNextVal");
			foodInfo.put("foodNo" , foodNo);
			dao.insert("svcStnd.food.foodInfoMng.insertTiFoodInfo" , foodInfo);
		}else if ("U".equals(foodInfo.get("crud").toString())){
			dao.update("svcStnd.food.foodInfoMng.updateTiFoodInfo" , foodInfo);
		}else if ("D".equals(foodInfo.get("crud").toString())){
			dao.delete("svcStnd.food.foodInfoMng.deleteTiFoodInfo" , foodInfo);
			dao.delete("svcStnd.food.foodInfoMng.deleteTiFoodElem" , foodInfo);
		}

		// 식품성분
		if ("C".equals(foodInfo.get("crud").toString()) || "U".equals(foodInfo.get("crud").toString())) {
			for (Map<String, Object> info : gridData) {
				if("C".equals(foodInfo.get("crud").toString())){
					info.put("foodNo" , foodInfo.get("foodNo"));
				}
				dao.update("svcStnd.food.foodInfoMng.mergeTiFoodElem", info);
			}
		}

	}


}

