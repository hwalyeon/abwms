package kr.co.seculink.web.service.oper.dgem;

import kr.co.seculink.exception.BizException;
import kr.co.seculink.web.service.oper.dgem.DszoneHistService;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Slf4j
@Service("dszoneHistService")
public class DszoneHistServiceImpl implements DszoneHistService
{

	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate dao;
	
    //위치정보_관리_조회_조건_조회_1
	public List<Map<String, String>> searchLocInfoSelect(Map<String, String> params) {
		return dao.selectList("oper.dgem.dszoneHist.searchLocInfoSelect", params);
	}

	//위치정보_관리_조회_조건_조회_2
	public List<Map<String, String>> searchLocInfoSelect2(Map<String, String> params) {
		return dao.selectList("oper.dgem.dszoneHist.searchLocInfoSelect2", params);
	}

	//위치정보_관리_학부모_학생_조건_조회
	public List<Map<String, String>> searchPrntNoSelect(Map<String, String> params) {
		return dao.selectList("oper.dgem.dszoneHist.searchPrntNoSelect", params);
	}

	//위치정보_관리_학부모_학생_조건_조회_2
	public List<Map<String, String>> searchStdtNoSelect(Map<String, String> params) {
		return dao.selectList("oper.dgem.dszoneHist.searchStdtNoSelect", params);
	}

	//위치정보_관리_리스트_조회
	public List<Map<String, String>> searchLocInfoList(Map<String, String> params) {
		return dao.selectList("oper.dgem.dszoneHist.searchLocInfoList", params);
	}

	//위치정보_관리_리스트_상세정보_조회
	public List<Map<String, String>> searchLocInfoSpec(Map<String, String> params) {
		return dao.selectList("oper.dgem.dszoneHist.searchLocInfoSpec", params);
	}

	//위치정보_관리_상세정보_저장
	@Transactional
	public void saveLocInfoSpec(Map<String, Object> params) throws BizException
	{
		int saveCnt = 0;

		if( "C".equals(params.get("crud"))) {
			saveCnt += dao.insert("oper.dgem.dszoneHist.insertTsLocInfoBase", params);

			if("prnt".equals(params.get("rdPublGuarDivSpec"))) {
				if(chkRegLimit(params)) {
					saveCnt += dao.insert("oper.dgem.dszoneHist.insertTmGuarApntPlc", params);
				}
			}
		}else if( "U".equals(params.get("crud"))) {
			saveCnt += dao.update("oper.dgem.dszoneHist.updateTsLocInfoBase", params);
		}else if( "D".equals(params.get("crud"))) {
			saveCnt += dao.update("oper.dgem.dszoneHist.deleteTsLocInfoBase", params);
			if("prnt".equals(params.get("rdPublGuarDivSpec"))) {
				saveCnt += dao.delete("oper.dgem.dszoneHist.deleteTmGuarApntPlc", params);
			}
		}

		if(saveCnt == 0) {
			throw new BizException("ECOM999", new String[]{"위치정보관리 저장이 실패하였습니다"});
		}
	}

	// 학생별 위치정보 등록 제한
	private boolean chkRegLimit(Map<String, Object> params) throws BizException
	{
		boolean chkRtn = true;
		int rowCount = dao.selectOne("oper.dgem.dszoneHist.searchChkRegLimit", params);

		if(rowCount > 999){
			throw new BizException("ECOM999", new String[]{"학생당 최대 1000개까지 등록 가능합니다."});
		}
		return chkRtn;
	}

}
