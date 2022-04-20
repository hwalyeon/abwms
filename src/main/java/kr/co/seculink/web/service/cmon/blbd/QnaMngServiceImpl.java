package kr.co.seculink.web.service.cmon.blbd;

import kr.co.seculink.domain.RtnMsg;
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
@Service("qnaMngService")
public class QnaMngServiceImpl implements QnaMngService
{
	@Autowired
	private FileService fileService;
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate dao;

	//질의응답_리스트 조회
	public List<Map<String, Object>> searchQnaList(Map<String, String> params) throws BizException
	{
		List<Map<String, Object>> result = dao.selectList("cmon.blbd.qnaMng.selectTsQnaBaseList", params);

		return result;
	}

	//질의응답_저장
	public void saveInfo(Map<String, String> params) throws BizException
	{
		int saveCnt = 0;
		RtnMsg vo = new RtnMsg();

		if("U".equals(params.get("crud"))){
			saveCnt += dao.update("cmon.blbd.qnaMng.updateTsQnaBase", params);
		}
		else if("D".equals(params.get("crud"))){
			saveCnt += dao.update("cmon.blbd.qnaMng.deleteAns", params);
		}
		if (saveCnt == 0) {
			throw new BizException("ECOM999", new String[]{"답변 저장에 실패하였습니다."});
		}

	}

}
