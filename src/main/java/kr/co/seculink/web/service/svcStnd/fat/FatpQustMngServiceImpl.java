package kr.co.seculink.web.service.svcStnd.fat;

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
@Service("fatpQustStndMngService")
public class FatpQustMngServiceImpl implements FatpQustMngService
{
	@Autowired
	private FileService fileService;
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate dao;

	//비만예측_설문_기본_리스트 조회
	public List<Map<String, String>> searchFatpQustBaseList(Map<String, String> params) throws BizException
	{
		List<Map<String, String>> result = dao.selectList("svcStnd.fat.fatpQustMng.selectTcFatpQustStatBase", params);
		
		return result;
	}

	//비만예측_설문_기본 저장
	public void saveFatpQustBaseDetl(Map<String,Object> params) throws BizException{

		int saveCnt = 0;

		if("C".equals(params.get("crud"))){
			List<Map<String, String>> exists = dao.selectList("svcStnd.fat.fatpQustMng.selectTcFatpQustStatBase", params);

			if(exists.size() == 0)
			{
				saveCnt += dao.insert("svcStnd.fat.fatpQustMng.insertTiFatpQustStnd", params);
			}else
			{
				throw new BizException("ECOM999", new String[]{"이미 등록된 설문 번호입니다."});
			}
		}else if("U".equals(params.get("crud"))){
			saveCnt += dao.update("svcStnd.fat.fatpQustMng.updateTiFatpQustStnd", params);
		}else if("D".equals(params.get("crud"))){
			saveCnt += dao.update("svcStnd.fat.fatpQustMng.deleteTiFatpQustStnd", params);
		}
		if ( saveCnt == 0 ) {
			throw new BizException("ECOM999", new String[]{"비만예측설문 기본 저장이 실패하였습니다."});
		}
	}

	//비만예측_설문_상세_리스트 조회
	public List<Map<String, String>> searchFatpQustSpecList(Map<String, String> params) throws BizException
	{
		List<Map<String, String>> result = dao.selectList("svcStnd.fat.fatpQustMng.selectFatpQustSpecList", params);

		return result;
	}

	//비만예측_설문_상세_정보 조회(팝업)
	public Map<String, Object> searchFatpQustSpecInfo(Map<String, String> params) throws BizException
	{
		Map<String, Object> result = dao.selectOne("svcStnd.fat.fatpQustMng.selectFatpQustSpecList", params);

		return result;
	}

	//비만예측_설문_상세 저장(팝업)
	public void saveFatpQustSpecDetl(Map<String,Object> params) throws BizException{

		int saveCnt = 0;

		if("C".equals(params.get("crud")))
		{
			List<Map<String, String>> exists = dao.selectList("svcStnd.fat.fatpQustMng.selectFatpQustSpecList", params);

			if(exists.size() == 0)
			{
				saveCnt += dao.insert("svcStnd.fat.fatpQustMng.insertFatpQustSpecList", params);
			}
			else
			{
				throw new BizException("ECOM999", new String[]{"이미 등록된 설문 상세정보입니다."});
			}
		}else if("U".equals(params.get("crud")))
		{
			saveCnt += dao.update("svcStnd.fat.fatpQustMng.updateTiFatpQustSpec", params);
		}
		else if("D".equals(params.get("crud")))
		{
			saveCnt += dao.update("svcStnd.fat.fatpQustMng.deleteTiFatpQustSpec", params);
		}

		if ( saveCnt == 0 )
		{
			throw new BizException("ECOM999", new String[]{"비만예측설문 상세 저장이 실패하였습니다."});
		}
	}
}
