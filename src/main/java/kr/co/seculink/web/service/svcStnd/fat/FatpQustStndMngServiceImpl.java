package kr.co.seculink.web.service.svcStnd.fat;

import kr.co.seculink.exception.BizException;
import kr.co.seculink.util.GEUtil;
import kr.co.seculink.web.service.cmon.FileService;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service("fatpQustStndMngService")
public class FatpQustStndMngServiceImpl implements FatpQustStndMngService
{
	@Autowired
	private FileService fileService;
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate dao;
	
	public List<Map<String, String>> searchFatpQustList(Map<String, String> params) throws BizException
	{
		List<Map<String, String>> result = dao.selectList("svcStnd.fatpQust.fatpQustStndMng.searchTcFatpQustStatBase", params);
		
		return result;
	}

	@Transactional
	public void saveFatpQustList(Map<String, Object> params) throws BizException
	{
		int saveCnt = 0;


		List<Map<String, String>> gridData = (List<Map<String, String>>) params.get("gridList");
		for (Map<String, String> info : gridData) {
			log.debug("crud         : " +  info.get("crud"));
			log.debug("fatpQustStatCd   : " +  info.get("fatpQustStatCd"));
			log.debug("fatpQustStatCntn : " +  info.get("fatpQustStatCntn"));

			if( "C".equals(info.get("crud"))){
				saveCnt += dao.insert("svcStnd.fatpQust.fatpQustStndMng.insertTiFatpQustStnd", info);
			}else if( "U".equals(info.get("crud"))){
				saveCnt += dao.update("svcStnd.fatpQust.fatpQustStndMng.updateTiFatpQustStnd", info);
			}else if( "D".equals(info.get("crud"))){
				saveCnt += dao.delete("svcStnd.fatpQust.fatpQustStndMng.deleteTiFatpQustStnd", info);
			}
		}

		if ( saveCnt == 0 ) {
			throw new BizException("ECOM999", new String[]{"위험감정기준 상태 코드 저장이 실패하였습니다."});
		}
	}


	//중복 조회
	public Map<String, String> searchDupCdCk(Map<String, String> params) throws BizException
	{
		Map<String, String> result = dao.selectOne("svcStnd.fatpQust.fatpQustStndMng.searchDupCdCk", params);

		Map<String, String> rtnMap = new HashMap<>();
		if ( result == null || GEUtil.isEmpty(result.get("actDivCd")) ) {
			rtnMap.put("existsYn", "N");
		} else {
			rtnMap.put("existsYn", "Y");
		}

		return rtnMap;
	}
}
