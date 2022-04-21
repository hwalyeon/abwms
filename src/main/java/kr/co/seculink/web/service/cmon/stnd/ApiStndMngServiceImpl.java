package kr.co.seculink.web.service.cmon.stnd;

import kr.co.seculink.exception.BizException;
import kr.co.seculink.util.GEUtil;
import kr.co.seculink.util.XUtil;
import kr.co.seculink.web.model.cmon.TcFileVO;
import kr.co.seculink.web.service.cmon.FileService;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service("apiStndMngService")
public class ApiStndMngServiceImpl implements ApiStndMngService
{
	@Autowired
	private FileService fileService;
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate dao;
	
	public List<Map<String, String>> searchApiList(Map<String, String> params) throws BizException
	{
		List<Map<String, String>> result = dao.selectList("cmon.stnd.apiStndMng.searchTcApiStnd", params);
		
		return result;
	}
	
	public Map<String, String> searchApiInfo(Map<String, String> params) throws BizException
	{
		Map<String, String> result = dao.selectOne("cmon.stnd.apiStndMng.searchTcApiStnd", params);
		
		return result;
	}

	public Map<String, String> searchDupSvrId(Map<String, String> params) throws BizException
	{
		Map<String, String> user = dao.selectOne("cmon.stnd.apiStndMng.searchTcApiStnd", params);

		Map<String, String> rtnMap = new HashMap<>();
		if ( user == null || GEUtil.isEmpty(user.get("svrId")) ) {
			rtnMap.put("existsYn", "N");
		} else {
			rtnMap.put("existsYn", "Y");
		}

		return rtnMap;
	}
	
	@Transactional
	public void saveApi(Map<String, String> params) throws BizException
	{
		int saveCnt = 0;
		
		if ( "C".equals(params.get("crud")) ) {
		
			Map<String, String> existUserParam = new HashMap<>();
			existUserParam.put("svrId", (String) params.get("svrId"));
			Map<String, String> user = dao.selectOne("cmon.stnd.apiStndMng.searchTcApiStnd", existUserParam);

			saveCnt = dao.insert("cmon.stnd.apiStndMng.insertTcApiStnd", params);
			
		} else if ( "U".equals(params.get("crud")) ) {
			
			saveCnt = dao.update("cmon.stnd.apiStndMng.updateTcApiStnd", params);
			
		} else if ( "D".equals(params.get("crud")) ) {
			
			Map<String, String> deleteMap = new HashMap<String, String>();
			deleteMap.put("svrId", params.get("svrId"));
			deleteMap.put("useYn" , "N");
			
			saveCnt = dao.delete("cmon.stnd.apiStndMng.deleteTcApiStnd", deleteMap);

		}
			
		if ( saveCnt == 0 ) {
			throw new BizException("ECOM999", new String[]{"사용자 저장이 실패하였습니다."});
		}
	}
}
