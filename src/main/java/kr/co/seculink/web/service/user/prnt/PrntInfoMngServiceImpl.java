package kr.co.seculink.web.service.user.prnt;

import kr.co.seculink.domain.RtnMsg;
import kr.co.seculink.exception.BizException;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service("prntInfoMngService")
public class PrntInfoMngServiceImpl implements PrntInfoMngService
{
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate dao;

	//학부모_정보 상세보기
	public Map<String, Object> searchPrntInfo(Map<String, Object> params) throws BizException
	{
		Map<String, Object> result = dao.selectOne("user.prnt.prntInfoMng.selectPrntInfoDetl", params);
		return result;
	}


	//학부모_정보 저장
	public void savePrntInfoDetl(Map<String, Object> params) throws BizException
	{
		RtnMsg vo = new RtnMsg();
		Map<String, Object> rtnMap = new HashMap<String, Object>();

		int saveCnt = 0;

		System.out.println("params:"+params);
		if ("C".equals(params.get("crud"))) {
			saveCnt += dao.insert("user.prnt.prntInfoMng.insertTmPrntBase", params);
		} else if ("U".equals(params.get("crud"))) {
			saveCnt += dao.update("user.prnt.prntInfoMng.updateTmPrntBase", params);
		}/* else if ("D".equals(params.get("crud"))) {
			saveCnt += dao.delete("user.prnt.prntInfoMng.deleteTmPrntBase", params);
		}*/
		if (saveCnt == 0) {
			throw new BizException("ECOM999", new String[]{"보호자(사용자) 정보 저장이 실패하였습니다."});
		}
	}
}
	
