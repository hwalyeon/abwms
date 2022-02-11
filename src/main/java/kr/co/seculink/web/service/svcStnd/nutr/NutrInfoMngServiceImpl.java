package kr.co.seculink.web.service.svcStnd.nutr;

import kr.co.seculink.exception.BizException;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Slf4j
@Service("nutrInfoMngService")
public class NutrInfoMngServiceImpl implements NutrInfoMngService
{
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate dao;
	
    //영양소_정보_리스트 조회
	public List<Map<String, String>> searchNutrInfoList(Map<String, String> params) throws BizException
	{
		List<Map<String, String>> result = dao.selectList("svcStnd.nutr.nutrInfoMng.searchNutrInfoList", params);
		return result;
	}
    //영양소_코드,_리스트 조회
	public List<Map<String, String>> nutrCdList(Map<String, String> params) throws BizException
	{
		List<Map<String, String>> result = dao.selectList("svcStnd.nutr.nutrInfoMng.searchNutrCdList", params);
		return result;
	}
    //행추가,행삭제 저장
	@Transactional
	public void saveNutrInfo(Map<String, Object> params) throws BizException
	{
		int saveCnt = 0;


		List<Map<String, String>> gridData = (List<Map<String, String>>) params.get("gridList");

		for (Map<String, String> info : gridData) {

			log.debug("crud         : " +  info.get("crud"));

			if( "C".equals(info.get("crud"))){
				saveCnt += dao.insert("svcStnd.nutr.nutrInfoMng.insertTiNutrCdList", info);
			}else if( "U".equals(info.get("crud"))){
				saveCnt += dao.update("svcStnd.nutr.nutrInfoMng.updateTiNutrCdList", info);
			}else if( "D".equals(info.get("crud"))){
				saveCnt += dao.delete("svcStnd.nutr.nutrInfoMng.deleteTiNutrCdList", info);
			}
		}

		if ( saveCnt == 0 ) {
			throw new BizException("ECOM999", new String[]{"영양소정보  저장이 실패하였습니다."});
		}
	}


}
