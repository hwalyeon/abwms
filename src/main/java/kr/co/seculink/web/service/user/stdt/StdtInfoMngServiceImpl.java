package kr.co.seculink.web.service.user.stdt;

import kr.co.seculink.domain.RtnMsg;
import kr.co.seculink.exception.BizException;
import kr.co.seculink.util.GEUtil;
import kr.co.seculink.web.service.cmon.FileService;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service("stdtInfoMngService")
public class StdtInfoMngServiceImpl implements StdtInfoMngService
{
	@Autowired
	private FileService fileService;

	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate dao;

	//학생정보 리스트 조회
	public List<Map<String, String>> searchStdtInfoList(Map<String, String> params) throws BizException
	{
		List<Map<String, String>> result = dao.selectList("user.stdt.stdtInfoMng.searchStdtInfoList", params);

		return result;
	}

	//밴드ID 중복 조회
	public Map<String, String> searchDupBandId(Map<String, String> params) throws BizException
	{
		Map<String, String> result = dao.selectOne("user.stdt.stdtInfoMng.searchDupBandId", params);

		Map<String, String> rtnMap = new HashMap<>();
		if (result == null || GEUtil.isEmpty(result.get("bandId")) ) {
			rtnMap.put("existsYn", "N");
		} else {
			rtnMap.put("existsYn", "Y");
		}

		return rtnMap;
	}

	//밴드ID 채번
	public Map<String, Object> numberingBandId(Map<String, String> params) throws BizException
	{
		String bandYtypCd = (params.get("bandYtypCd")).substring(0, 3);
		params.put("bandYtypCd", bandYtypCd);


		Map<String, String> result = dao.selectOne("user.stdt.stdtInfoMng.numberingBandId", params);

		Map<String, Object> rtnMap = new HashMap<>();

		rtnMap.put("result", result);

		return rtnMap;
	}

	//밴드_정보 저장
	public void saveBandOpenInfoDetl(Map<String, Object> params) throws BizException {

		RtnMsg vo = new RtnMsg();
		Map<String, Object> rtnMap = new HashMap<String, Object>();

		int saveCnt = 0;

		if ("C".equals(params.get("crud"))) {
			saveCnt += dao.insert("devc.band.bandOpenInfoMng.insertTsBandInfoList", params);
		} else if ("U".equals(params.get("crud"))) {
			saveCnt += dao.update("devc.band.bandOpenInfoMng.updateTsBandInfoList", params);
		} else if ("D".equals(params.get("crud"))) {
			saveCnt += dao.delete("devc.band.bandOpenInfoMng.deleteTsBandInfoList", params);
		}
		if (saveCnt == 0) {
			throw new BizException("ECOM999", new String[]{"밴드정보 저장이 실패하였습니다."});
		}

	}

	//밴드_정보_상세보기
	public Map<String, Object> searchBandOpenInfo(Map<String, String> params) throws BizException
	{

		Map<String, String> result = dao.selectOne("devc.band.bandOpenInfoMng.selectBandOpenInfo", params);

		Map<String, Object> rtnMap = new HashMap<>();

		rtnMap.put("result", result);

		return rtnMap;
	}

	//행추가_행삭제 저장
	public void saveBandOpenDetlGuarTelNo(Map<String, Object> params) throws BizException
	{
		int saveCnt = 0;

		List<Map<String, String>> gridDate = (List<Map<String, String>>) params.get("gridList");

		for(Map<String,String> info:gridDate){
			log.debug("crud         : " +  info.get("crud"));

			if( "C".equals(info.get("crud"))){
				saveCnt += dao.insert("svcStnd.nutr.bandOpenInfoMng.insertTmBandSpecList", info);
			}else if( "U".equals(info.get("crud"))){
				saveCnt += dao.update("svcStnd.nutr.bandOpenInfoMng.updateTmBandSpecList", info);
			}else if( "D".equals(info.get("crud"))){
				saveCnt += dao.delete("svcStnd.nutr.bandOpenInfoMng.deleteTmBandSpecList", info);
			}
		}
		if(saveCnt == 0){
			throw new BizException("ECOM999", new String[]{"밴드정보정보 저장이 실패하였습니다"});
		}
	}
}

