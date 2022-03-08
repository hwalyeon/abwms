package kr.co.seculink.web.service.svcStnd.act;

import kr.co.seculink.exception.BizException;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Slf4j
@Service("palStndMngService")
public class PalStndMngServiceImpl implements PalStndMngService
{
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate dao;
	
    //신체활동수준_기준_리스트 조회
	public List<Map<String, String>> searchPalStndList(Map<String, String> params) {
		return dao.selectList("svcStnd.act.palStndMng.searchPalStndList", params);
	}

	//행추가_행삭제 저장
	@Transactional
	public void savePalStnd(Map<String, Object> params) throws BizException
	{
		int saveCnt = 0;

		List<Map<String, String>> gridDate = (List<Map<String, String>>) params.get("gridList");

		for(Map<String,String> info:gridDate){
			if( "C".equals(info.get("crud"))){
				saveCnt += dao.insert("svcStnd.act.palStndMng.insertTiPalStndList", info);
			}else if( "U".equals(info.get("crud"))){
				saveCnt += dao.update("svcStnd.act.palStndMng.updateTiPalStndList", info);
			}else if( "D".equals(info.get("crud"))){
				saveCnt += dao.delete("svcStnd.act.palStndMng.deleteTiPalStndList", info);
			}
		}
		if(saveCnt == 0){
			throw new BizException("ECOM999", new String[]{"신체활동수준 기준 저장이 실패하였습니다"});
		}
	}

	//상세보기_저장
	@Transactional
	public void savePalStndInfo(Map<String, Object> params) throws BizException
	{
		int saveCnt = 0;

		if( "C".equals(params.get("crud"))){
			if(chkKey(params) && chkValid(params)) {
				saveCnt += dao.insert("svcStnd.act.palStndMng.insertTiPalStndList", params);
			}
		}else if( "U".equals(params.get("crud"))){
			if(chkValid(params)) {
				saveCnt += dao.update("svcStnd.act.palStndMng.updateTiPalStndList", params);
			}
		}else if( "D".equals(params.get("crud"))){
			saveCnt += dao.delete("svcStnd.act.palStndMng.deleteTiPalStndList", params);
		}

		if(saveCnt == 0){
			throw new BizException("ECOM999", new String[]{"신체활동수준 기준 저장이 실패하였습니다"});
		}
	}

	// PAL_VAL_FR ~ PAL_VAL_TO 범위 중복 방지
	private boolean chkValid(Map<String, Object> params) throws BizException
	{
		boolean chkRtn = true;
		List<Map<String, String>> result = dao.selectList("svcStnd.act.palStndMng.searchValidChk", params);

		if(result.size() > 0){
			throw new BizException("ECOM999", new String[]{"이미 등록된 From-To 범위 값입니다."});
		}
		return chkRtn;
	}

	// PAL_CD 값 중복 방지
	private boolean chkKey(Map<String, Object> params) throws BizException
	{
		boolean chkRtn = true;
		Map<String, String> result = dao.selectOne("svcStnd.act.palStndMng.searchPalCdChk", params);

		if(null != result){
			throw new BizException("ECOM999", new String[]{"이미 등록된 신체활동수준 코드입니다."});
		}
		return chkRtn;
	}

}
