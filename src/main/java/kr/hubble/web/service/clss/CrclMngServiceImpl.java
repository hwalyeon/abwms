package kr.hubble.web.service.clss;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import kr.co.seculink.exception.BizException;
import kr.co.seculink.util.XUtil;
import kr.hubble.web.service.cous.CousMngService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("crclMngService")
public class CrclMngServiceImpl implements CrclMngService
{
	@Autowired
	private CousMngService cousMngService;
	
	@Autowired
	private SqlSessionTemplate dao;
	
	public List<Map<String, String>> searchCrclList(Map<String, String> params) throws BizException
	{
		return dao.selectList("lect.crclMng.selectTsCousLect", params);
	}
	
	public Map<String, String> searchCrcl(Map<String, String> params) throws BizException
	{
		return dao.selectOne("lect.crclMng.selectTsCousLect", params);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void saveCrcl(Map<String, String> params)throws BizException
	{
		int saveCnt = 0;
		
		String crud = params.get("crud");
		if ( "C".equals(crud) ) {
			saveCnt = this.insertLect(params);
		} else if ( "U".equals(crud) ) {
			saveCnt = this.updateLect(params);
		} else if ( "D".equals(crud) ) {
			saveCnt = this.deleteLect(params);
		}
			
		if ( saveCnt == 0 ) {
			throw new BizException("ECOM999", new String[]{"과정 저장이 실패하였습니다."});
		}
	}
	
	private int insertLect(Map<String, String> params) throws BizException
	{
		Map<String, String> paramMap = new HashMap<>();
		paramMap.put("cousNo", params.get("cousNo"));
		Map<String, String> cousInfo = cousMngService.searchCous(paramMap);
		
		if ( XUtil.getBigDecimal(params.get("lectStrtDt")).compareTo(XUtil.getBigDecimal(XUtil.getCurrDate())) < 0 ) {
			throw new BizException("ECOM999", new String[] {"강의시작일자를 과거로 등록할 수 없습니다."});
		}
		
		if ( XUtil.getBigDecimal(params.get("lectEndDt")).compareTo(XUtil.getBigDecimal(XUtil.getCurrDate())) < 0 ) {
			throw new BizException("ECOM999", new String[] {"강의시작일자를 과거로 등록할 수 없습니다."});
		}
		
		if ( XUtil.getBigDecimal(cousInfo.get("cousStrtDt")).compareTo(XUtil.getBigDecimal(params.get("lectStrtDt"))) > 0 ) {
			throw new BizException("ECOM999", new String[] {"강의시작일자는 과정시작일자보다 과거일 될 수 없습니다."});
		}
		
		if ( XUtil.getBigDecimal(cousInfo.get("cousStrtDt")).compareTo(XUtil.getBigDecimal(params.get("lectEndDt"))) > 0 ) {
			throw new BizException("ECOM999", new String[] {"강의종료일자는 과정시작일자보다 과거가 될 수 없습니다."});
		}
		
		if ( XUtil.getBigDecimal(cousInfo.get("cousEndDt")).compareTo(XUtil.getBigDecimal(params.get("lectStrtDt"))) < 0 ) {
			throw new BizException("ECOM999", new String[] {"강의시작일자는 과정종료일자보다 미래가 될 수 없습니다."});
		}
		
		if ( XUtil.getBigDecimal(cousInfo.get("cousEndDt")).compareTo(XUtil.getBigDecimal(params.get("lectEndDt"))) < 0 ) {
			throw new BizException("ECOM999", new String[] {"강의종료일자는 과정종료일자보다 미래가 될 수 없습니다."});
		}
		
		if ( "20".equals(cousInfo.get("cousStatCd")) ) {
			throw new BizException("ECOM999", new String[] {"해당 과정은 종료되었습니다."});
		}
		
		if ( "90".equals(cousInfo.get("cousStatCd")) ) {
			throw new BizException("ECOM999", new String[] {"해당 과정은 취소되었습니다."});
		}
		
		int lectSeq = dao.selectOne("lect.crclMng.selectLectSeq", params);
		
		params.put("lectSeq", String.valueOf(lectSeq));
		int saveCnt = dao.insert("lect.crclMng.insertTsCousLect", params);
		
		return saveCnt;
	}
	
	private int updateLect(Map<String, String> params) throws BizException
	{
		Map<String, String> paramMap = new HashMap<>();
		paramMap.put("cousNo" , params.get("cousNo"));
		paramMap.put("lectSeq", params.get("lectSeq"));
		Map<String, String> crclInfo = this.searchCrcl(paramMap);
		
		if ( XUtil.getBigDecimal(crclInfo.get("lectEndDttm")).compareTo(XUtil.getBigDecimal(XUtil.getCurrDttm())) < 0 ) {
			throw new BizException("ECOM999", new String[] {"강의가 종료되어서 수정할 수 없습니다."});
		}
		
		int saveCnt = dao.insert("lect.crclMng.updateTsCousLect", params);
		
		return saveCnt;
	}
	
	private int deleteLect(Map<String, String> params) throws BizException
	{
		Map<String, String> paramMap = new HashMap<>();
		paramMap.put("cousNo" , params.get("cousNo"));
		paramMap.put("lectSeq", params.get("lectSeq"));
		Map<String, String> crclInfo = this.searchCrcl(paramMap);
		
		if ( XUtil.getBigDecimal(crclInfo.get("lectStrtDt")).compareTo(XUtil.getBigDecimal(XUtil.getCurrDate())) <= 0 ) {
			throw new BizException("ECOM999", new String[] {"강의시작일자가 오늘이거나 지난 강의는 삭제할 수 없습니다."});
		}
		
		dao.delete("hist.takeDetlMng.deleteTsTakeHist"    , paramMap);
		dao.delete("hist.takeDetlMng.deleteTsCousTakeDetl", paramMap);
		dao.delete("clss.hworkMng.deleteTsCousHworkBase"  , paramMap);
		dao.delete("clss.hworkMng.deleteTsCousHworkDetl"  , paramMap);
		dao.delete("clss.hworkMng.deleteTsHworkSolvDetl"  , paramMap);
		
		return dao.delete("lect.crclMng.deleteTsCousLect", paramMap);
	}
}	
