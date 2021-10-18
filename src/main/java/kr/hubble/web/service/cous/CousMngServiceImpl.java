package kr.hubble.web.service.cous;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import kr.co.seculink.exception.BizException;
import kr.co.seculink.util.GEUtil;

@Service("cousMngService")
public class CousMngServiceImpl implements CousMngService
{
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate dao;
	
	public List<Map<String, String>> searchCousList(Map<String, String> params) throws BizException
	{
		return dao.selectList("acdm.cousMng.selectTsCousBase", params);
	}
	
	public Map<String, String> searchCous(Map<String, String> params) throws BizException
	{
		return dao.selectOne("acdm.cousMng.selectTsCousBase", params);
	}
	
	public void saveCous(Map<String, String> params) throws BizException
	{
		int saveCnt = 0;
		
		String crud = params.get("crud");
		if ( "C".equals(crud) ) {
			int cousNo = dao.selectOne("acdm.cousMng.selectCousNo", params);
			if(!GEUtil.isAdmin()) {
				params.put("acdmId", params.get("regUserId"));				
			}
			params.put("cousNo", String.valueOf(cousNo));
			saveCnt = dao.insert("acdm.cousMng.insertTsCousBase", params);
		} else if ( "U".equals(crud) ) {
			
			Map<String, String> cousInfo = this.searchCous(params);
			
			if ( "20".equals(cousInfo.get("cousStatCd")) ) {
				throw new BizException("ECOM999", new String[] {"종료된 과정은 저장할 수 없습니다."});
			}
			
			if ( "90".equals(cousInfo.get("cousStatCd")) ) {
				throw new BizException("ECOM999", new String[] {"취소된 과정은 저장할 수 없습니다."});
			}
			
			Map<String, String> paramMap = new HashMap<>();
			
			if ( "10".equals(cousInfo.get("cousStatCd")) ) {
				paramMap.put("cousNo"  , params.get("cousNo"));
				paramMap.put("cousDesc", params.get("cousDesc"));
			}
			
			saveCnt = dao.update("acdm.cousMng.updateTsCousBase", params);
		} else if ( "D".equals(crud) ) {

			List<Map<String, String>> cousStdtList = dao.selectList("acdm.cousMng.searchTsCousStdt", params);
			if ( cousStdtList != null && cousStdtList.size() > 0 ) {
				throw new BizException("ECOM999", new String[] {"수강중이 학생이 존재합니다.\n수강중인 학생이 없는 경우만 과정취소가 가능합니다."});
			}
			
			Map<String, String> paramMap = new HashMap<>();
			paramMap.put("cousNo"    , params.get("cousNo"));
			paramMap.put("cousStatCd", "90");
			
			saveCnt = dao.update("acdm.cousMng.updateTsCousBase", paramMap);
		}
			
		if ( saveCnt == 0 ) {
			throw new BizException("ECOM999", new String[]{"과정 저장이 실패하였습니다."});
		}
	}
	
}
