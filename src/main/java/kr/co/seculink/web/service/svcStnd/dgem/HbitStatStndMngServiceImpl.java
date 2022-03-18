package kr.co.seculink.web.service.svcStnd.dgem;

import kr.co.seculink.exception.BizException;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Slf4j
@Service("hbitStatStndMngService")
public class HbitStatStndMngServiceImpl implements HbitStatStndMngService
{

	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate dao;

	public List<Map<String, String>> searchHbitStatStndList(Map<String, String> params) throws BizException
	{
		List<Map<String, String>> result = dao.selectList("svcStnd.dgem.hbitStatStndMng.searchHbitStatStndList", params);

		return result;
	}

	//행추가_행삭제 저장
	@Transactional
	public void saveHbitStatStnd(Map<String, Object> params) throws BizException
	{
		int saveCnt = 0;

		List<Map<String, String>> gridDate = (List<Map<String, String>>) params.get("gridList");

		for(Map<String,String> info:gridDate){
			log.debug("crud         : " +  info.get("crud"));

			if( "C".equals(info.get("crud"))){
				saveCnt += dao.insert("svcStnd.dgem.hbitStatStndMng.insertHbitStatList", info);
			}else if( "U".equals(info.get("crud"))){
				saveCnt += dao.update("svcStnd.dgem.hbitStatStndMng.updateHbitStatList", info);
			}else if( "D".equals(info.get("crud"))){
				saveCnt += dao.delete("svcStnd.dgem.hbitStatStndMng.deleteHbitStatList", info);
			}
		}
		if(saveCnt == 0){
			throw new BizException("ECOM999", new String[]{"비만기준정보 저장이 실패하였습니다"});
		}
	}

}

