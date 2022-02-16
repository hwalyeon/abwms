package kr.co.seculink.web.service.svcStnd.strs;

import kr.co.seculink.exception.BizException;
import kr.co.seculink.util.GEUtil;
import kr.co.seculink.util.XUtil;
import kr.co.seculink.web.model.cmon.TcFileVO;
import kr.co.seculink.web.service.cmon.FileService;
import kr.co.seculink.web.service.svcStnd.dgem.DgemStndMngService;
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
@Service("strsStndMngService")
public class StrsStndMngServiceImpl implements StrsStndMngService
{
	@Autowired
	private FileService fileService;

	@Autowired
	private DgemStndMngService dgemStndMngService;
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate dao;
	
	public List<Map<String, String>> searchStrsList(Map<String, String> params) throws BizException
	{
		List<Map<String, String>> result = dao.selectList("svcStnd.strs.strsStndMng.searchStrsList", params);

		return result;
	}

	@Transactional
	public void saveStrsList(Map<String, Object> params) throws BizException
	{
		int saveCnt = 0;


		List<Map<String, String>> gridData = (List<Map<String, String>>) params.get("gridList");
		for (Map<String, String> info : gridData) {
			log.debug("crud         : " +  info.get("crud"));
			log.debug("strsStndCd   : " +  info.get("strsStndCd"));
			log.debug("strsStndCntn : " +  info.get("strsStndCntn"));

			if( "C".equals(info.get("crud"))){
				saveCnt += dao.insert("svcStnd.strs.strsStndMng.insertTiStrsStnd", info);
			}else if( "U".equals(info.get("crud"))){
				saveCnt += dao.update("svcStnd.strs.strsStndMng.updateTiStrsStnd", info);
			}else if( "D".equals(info.get("crud"))){
				saveCnt += dao.delete("svcStnd.strs.strsStndMng.deleteTiStrsStnd", info);
			}
		}

		if ( saveCnt == 0 ) {
			throw new BizException("ECOM999", new String[]{"스트레스 상태 코드 저장이 실패하였습니다."});
		}
	}

}

