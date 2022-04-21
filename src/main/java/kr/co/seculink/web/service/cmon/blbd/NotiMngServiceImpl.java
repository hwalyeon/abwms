package kr.co.seculink.web.service.cmon.blbd;

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
@Service("notiMngService")
public class NotiMngServiceImpl implements NotiMngService
{
	@Autowired
	private FileService fileService;
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate dao;
	
	public List<Map<String, String>> searchNotiList(Map<String, String> params) throws BizException
	{
		List<Map<String, String>> result = dao.selectList("cmon.blbd.notiMng.searchTsBlbdBase", params);
		
		return result;
	}
	
	public Map<String, String> searchNotiInfo(Map<String, String> params) throws BizException
	{
		Map<String, String> result = dao.selectOne("cmon.blbd.notiMng.searchNotiList", params);

		return result;
	}
	
	@Transactional
	public void saveNoti(Map<String, String> params) throws BizException
	{
		int saveCnt = 0;
		
		if ( "C".equals(params.get("crud")) ) {
		
			Map<String, String> existUserParam = new HashMap<>();
			existUserParam.put("blbdNo", (String) params.get("blbdNo"));

			saveCnt = dao.insert("cmon.blbd.notiMng.insertTsBlbdBase", params);
			
		} else if ( "U".equals(params.get("crud")) ) {
			
			saveCnt = dao.update("cmon.blbd.notiMng.updateTsBlbdBase", params);
			
		} else if ( "D".equals(params.get("crud")) ) {
			
			Map<String, String> deleteMap = new HashMap<String, String>();
			deleteMap.put("blbdNo", params.get("blbdNo"));
			deleteMap.put("useYn" , "N");
			
			saveCnt = dao.delete("cmon.blbd.notiMng.deleteTcBlbdBase", deleteMap);

		}
			
		if ( saveCnt == 0 ) {
			throw new BizException("ECOM999", new String[]{"사용자 저장이 실패하였습니다."});
		}
	}
}
