package kr.co.seculink.web.service.oper.sys;

import io.netty.util.internal.StringUtil;
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
@Service("btchJobHistService")
public class BtchJobHistServiceImpl implements BtchJobHistService
{
	@Autowired
	private FileService fileService;

	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate dao;

	public List<Map<String, String>> searchBtchJobHistList(Map<String, String> params) throws BizException
	{
		List<Map<String, String>> result = dao.selectList("oper.sys.btchJobHist.searchBtchJobHistList", params);

		return result;
	}

	public Map<String, Object> searchStdtDetlInfo(Map<String, String> params) throws BizException
	{
		Map<String, Object> stdtDetl = dao.selectOne("user.stdt.stdtInfoMng.searchStdtDetlInfo", params);

		if(stdtDetl == null){
			throw new BizException("조회 된 내역이 없습니다.");
		}

		if(stdtDetl.get("dgemStatCntn") != null) {
			String dgemStatCntn = stdtDetl.get("dgemStatCntn").toString();

			if (dgemStatCntn != null) {
				dgemStatCntn = dgemStatCntn.replace(":STDT_NM", stdtDetl.get("stdtNm").toString());
				dgemStatCntn = dgemStatCntn.replace(":PLC_CLSS_NM", stdtDetl.get("growPlcClssNm").toString());
				dgemStatCntn = dgemStatCntn.replace(":LOC_NM", stdtDetl.get("growLocNm").toString());
				dgemStatCntn = dgemStatCntn.replace(":PLC_NM", stdtDetl.get("plcNm").toString());
				dgemStatCntn = dgemStatCntn.replace(":HBIT_MDAN", stdtDetl.get("hbitMdan").toString());
				dgemStatCntn = dgemStatCntn.replace(":HBIT_STAT_NM", stdtDetl.get("hbitStatNm").toString());
				dgemStatCntn = dgemStatCntn.replace(":TEMP_VAL", stdtDetl.get("tempVal").toString());
				dgemStatCntn = dgemStatCntn.replace(":TEMP_STAT_NM", stdtDetl.get("tempStatNm").toString());
				dgemStatCntn = dgemStatCntn.replace(":PRNT_NM", StringUtil.isNullOrEmpty(stdtDetl.get("guarNm").toString()) ? "" : stdtDetl.get("guarNm").toString());
				stdtDetl.put("dgem_stat_cntn", dgemStatCntn);
			}
		}

		/*
		if(specCntn != null){
			specCntn = specCntn.replaceAll(":STDT_NM", stdtDetl.get("stdtNm").toString() );
			specCntn = specCntn.replaceAll("<BR>", "\n" );
			stdtDetl.put("spec_cntn", specCntn);
		}

		if(currEvalCntn != null){
			currEvalCntn = currEvalCntn.replaceAll(":STDT_NM", stdtDetl.get("stdtNm").toString() );
			currEvalCntn = currEvalCntn.replaceAll("<BR>", "\n" );
			stdtDetl.put("curr_eval_cntn", currEvalCntn);
		}
		*/

		return stdtDetl;
	}

	public void saveStdtInfo(Map<String, Object> params) throws BizException
	{

		if ("C".equals(params.get("crud"))) {
			Map<String, Object> guarInfo = dao.selectOne("user.stdt.stdtInfoMng.searchBandGuarTelNo", params);

			if(guarInfo == null || (guarInfo != null && Integer.valueOf(guarInfo.get("guarNoCnt").toString()) == 0 )){
				throw new BizException("등록 된 보호자 정보가 없습니다. 보호자 등록 후 진행하여 주시기 바랍니다.");
			}

			if(guarInfo == null || (guarInfo != null && Integer.valueOf(guarInfo.get("prntNoCnt").toString()) == 0 )){
				throw new BizException("등록 된 학부모 정보가 없습니다. 학부모 등록 후 진행하여 주시기 바랍니다.");
			}

			params.put("prntNo" , guarInfo.get("prntNo").toString());

			// 학생 저장
			dao.insert("user.stdt.stdtInfoMng.insertTmStdtBase",params);

			// 학생 성장 저장
			dao.insert("user.stdt.stdtInfoMng.insertTsStdtGrowHist",params);

			// 학생
			dao.insert("user.stdt.stdtInfoMng.insertTsDdHbitHist",params);

			// 학생 보호자 저장
			dao.insert("user.stdt.stdtInfoMng.insertTmStdtGuarConn",params);
		}
		else if("U".equals(params.get("crud"))){
			dao.update("user.stdt.stdtInfoMng.updateTmStdtBase",params);
			dao.update("user.stdt.stdtInfoMng.updateTsStdtGrowHist",params);
		}
		else if("D".equals(params.get("crud"))) {
			dao.insert("user.stdt.stdtInfoMng.deleteTmStdtBase",params);
		}

	}
}

