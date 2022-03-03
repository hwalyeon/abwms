package kr.co.seculink.web.service.user.prnt;

import kr.co.seculink.domain.RtnMsg;
import kr.co.seculink.exception.BizException;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service("prntInfoMngService")
public class PrntInfoMngServiceImpl implements PrntInfoMngService
{
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate dao;

	//보호자(사용자)_정보_리스트 조회
	public List<Map<String, String>> searchPrntInfoList(Map<String, String> params) throws BizException
	{
		List<Map<String, String>> result = dao.selectList("user.prnt.prntInfoMng.selectPrntInfoList", params);

		return result;
	}


	//보호자(사용자)_정보_상세보기
	public Map<String, Object> searchPrntInfo(Map<String, String> params) throws BizException
	{

		Map<String, String> result = dao.selectOne("user.prnt.prntInfoMng.selectPrntInfoDetl", params);

		Map<String, Object> rtnMap = new HashMap<>();

		rtnMap.put("result", result);

		return rtnMap;
	}


	//밴드_정보 저장
	public void savePrntInfoDetl(Map<String, Object> params) throws BizException {

		RtnMsg vo = new RtnMsg();
		Map<String, Object> rtnMap = new HashMap<String, Object>();

		int saveCnt = 0;


		if ("C".equals(params.get("crud"))) {
			saveCnt += dao.insert("user.prnt.prntInfoMng.insertTsPrntInfoList", params);
		} else if ("U".equals(params.get("crud"))) {
			saveCnt += dao.update("user.prnt.prntInfoMng.updateTsPrntInfoList", params);
		} else if ("D".equals(params.get("crud"))) {
			saveCnt += dao.delete("user.prnt.prntInfoMng.deleteTsPrntInfoList", params);
		}

		if (saveCnt == 0) {
			throw new BizException("ECOM999", new String[]{"공통코드 저장이 실패하였습니다."});
		}

	}
/*

	//행추가_행삭제 저장
	public void saveBandOpenInfo(Map<String, Object> params) throws BizException
	{

		int saveCnt = 0;

		List<Map<String, String>> gridDate = (List<Map<String, String>>) params.get("gridList");

		for(Map<String,String> info:gridDate){
			log.debug("crud         : " +  info.get("crud"));

			if( "C".equals(info.get("crud"))){
				saveCnt += dao.insert("svcStnd.nutr.bandOpenInfoMng.insertTsBandInfoList", info);
			}else if( "U".equals(info.get("crud"))){
				saveCnt += dao.update("svcStnd.nutr.bandOpenInfoMng.updateTsBandInfoList", info);
			}else if( "D".equals(info.get("crud"))){
				saveCnt += dao.delete("svcStnd.nutr.bandOpenInfoMng.deleteTsBandInfoList", info);
			}
		}
		if(saveCnt == 0){
			throw new BizException("ECOM999", new String[]{"비만기준정보 저장이 실패하였습니다"});
		}

	}



	*/



}
	
