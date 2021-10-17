package kr.hubble.web.service.clss;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.hubble.exception.BizException;
import kr.hubble.exception.SysException;
import kr.hubble.util.OpenCVUtil;
import kr.hubble.util.XUtil;
import kr.hubble.web.model.TcFileVO;
import kr.hubble.web.service.cmon.FileService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("cousTakeService")
public class CousTakeServiceImpl implements CousTakeService
{
	@Value("${upload.prof}")
	private String profUpload;
	
	@Value("${upload.temp}")
	private String tempDir;
	
	// TAKE_EVNT_CD
	private final String ATTENDANCE			= "10";		// 출석
	private final String SUB_ATTENDANCE		= "11";		// 대리출석 
	private final String LEAVING			= "41";		// 자리이탈 
	
	private final String REQ_ATTENDANCE		= "18";		// 출석요청 
	private final String REQ_CONCENTRATION	= "28";		// 집중요청 
	private final String RES_CONCENTRATION	= "29";		// 집중응답 
	private final String REQ_QUESTION		= "38";		// 질문요청
	private final String RES_QUESTION		= "39";		// 질문응답
	private final String REQ_PRESENT		= "48";		// 자리체크요청
	private final String RES_PRESENT		= "49";		// 자리체크응답
	private final String EXIT				= "58";		// 퇴장
	
	@Autowired
	private FileService fileService;
	
	@Autowired
	private SqlSessionTemplate dao;
	
	@Transactional(rollbackFor = Exception.class)
	public void procEvent(Map<String, String> params) throws BizException
	{
		String cousNo  = params.get("cousNo");
		String lectSeq = params.get("lectSeq");
		String stdtId  = params.get("stdtId");
		
		String action = params.get("action");
		
		String takeEvntCd = "";
		String data       = "";
		
		if ( "REQ_ATTD".equals(action) ) {
			takeEvntCd = REQ_ATTENDANCE;		// 출석요청
			data       = params.get("dataURL");
		} else if ( "SUB_ATTD".equals(action) ) {
			takeEvntCd = SUB_ATTENDANCE;		// 대리출석
		} else if ( "LEAVE".equals(action) ) {
			takeEvntCd = LEAVING;				// 자리이탈
		} else if ( "REQ_CONC".equals(action) ) {
			takeEvntCd = REQ_CONCENTRATION;		// 집중요청
		} else if ( "RES_CONC".equals(action) ) {
			takeEvntCd = RES_CONCENTRATION;		// 집중응답
		} else if ( "REQ_QUST".equals(action) ) {
			takeEvntCd = REQ_QUESTION;			// 질문요청
		} else if ( "RES_QUST".equals(action) ) {
			takeEvntCd = RES_QUESTION;			// 질문응답
		} else if ( "REQ_PRST".equals(action) ) {
			takeEvntCd = REQ_PRESENT;			// 자리체크요청
		} else if ( "RES_PRST".equals(action) ) {
			takeEvntCd = RES_PRESENT;			// 자리체크응답
			data       = params.get("dataURL");
		} else if ( "EXIT".equals(action) ) {
			takeEvntCd = EXIT;					// 나가기
		}
		
		Map<String, String> takeEventMap = new HashMap<>();
		takeEventMap.put("cousNo"    , cousNo);
		takeEventMap.put("lectSeq"   , lectSeq);
		takeEventMap.put("stdtId"    , stdtId);
		takeEventMap.put("takeEvntCd", takeEvntCd);
		takeEventMap.put("occrDttm"  , XUtil.getCurrDttm());
		
		if ( REQ_ATTENDANCE.equals(takeEvntCd) || RES_PRESENT.equals(takeEvntCd) ) {
			TcFileVO tcFileVo = new TcFileVO();
			tcFileVo.setFileDivCd(action);
			tcFileVo.setCousNo   (cousNo);
			tcFileVo.setLectSeq  (lectSeq);
			tcFileVo.setDataURL  (data);
			tcFileVo.setUserId   (stdtId);
			fileService.save(tcFileVo);
			
			if ( XUtil.isEmpty(tcFileVo.getFileNo()) ) {
				log.error("파일을 저장하지 못하였습니다.");
				//throw new BizException("ECOM999", new String[] {"파일 저장에 실패하였습니다."});
			} else {
				takeEventMap.put("fileNo", tcFileVo.getFileNo());
				
				if ( "REQ_ATTD".equals(action) )
				{
					reqAttd(params, tcFileVo);
				}
				
				if ( "RES_PRST".equals(action) )
				{
					checkSeat(params, tcFileVo);
				}
			}
		}
		
		dao.insert("hist.takeDetlMng.insertTsTakeHist", takeEventMap);
	}
	
	public void reqAttd(Map<String, String> params, TcFileVO tcFileVo) throws BizException
	{
		// 등록된 프로필 사진정보를 조회한다.
		List<TcFileVO> stdtProfList = dao.selectList("clss.stdtMng.selectStdtProf", params);
		
		// openCV에 전송하여 일치여부를 판단한다.
		boolean sameYn = this.requestImageCompare(stdtProfList, tcFileVo);
		
		String atndYn = "N";
		String swchYn = "N";
		if ( sameYn ) {
			atndYn = "Y";
			swchYn = "N";
		} else {
			atndYn = "N";
			swchYn = "Y";
		}
		
		// 일치여부를 보고 데이터를 저장한다.
		Map<String, String> paramMap = new HashMap<>();
		paramMap.put("cousNo" , params.get("cousNo"));
		paramMap.put("lectSeq", params.get("lectSeq"));
		paramMap.put("stdtId" , params.get("stdtId"));
		paramMap.put("atndYn" , atndYn);
		paramMap.put("swchYn" , swchYn);
		dao.update("hist.takeDetlMng.updateTsCousTakeDetl", paramMap);
	}
	
	public void checkSeat(Map<String, String> params, TcFileVO tcFileVo) throws BizException
	{
		// 등록된 프로필 사진정보를 조회한다.
		List<TcFileVO> stdtProfList = dao.selectList("clss.stdtMng.selectStdtProf", params);
		
		// openCV에 전송하여 일치여부를 판단한다.
		boolean sameYn = this.requestImageCompare(stdtProfList, tcFileVo);
		
		String rwayYn = "N";
		if ( sameYn ) {
			rwayYn = "N";
		} else {
			rwayYn = "Y";
		}
		
		// 일치여부를 보고 데이터를 저장한다.
		Map<String, String> paramMap = new HashMap<>();
		paramMap.put("cousNo" , params.get("cousNo"));
		paramMap.put("lectSeq", params.get("lectSeq"));
		paramMap.put("stdtId" , params.get("stdtId"));
		paramMap.put("rwayYn" , rwayYn);
		dao.update("hist.takeDetlMng.updateTsCousTakeDetl", paramMap);
	}
	
	private boolean requestImageCompare(List<TcFileVO> stdtProfImageList, TcFileVO captureImageInfo) throws BizException
	{
		boolean sameYn = false;

		log.debug("path : " + Paths.get(profUpload));
		log.debug("=====================================");
		
		if ( stdtProfImageList == null || stdtProfImageList.size() == 0 )
			return sameYn;
		
		List<File> stndImgList = new ArrayList<>();
		for ( int i = 0 ; i < stdtProfImageList.size() ; i++ ) {
			TcFileVO fileVo = stdtProfImageList.get(i);
			
			if ( fileVo == null ) {
				continue;
			}
			
			File cropFile = null;
			File file = null;
			try {
				file = new File(profUpload + fileVo.getFilePath() + fileVo.getPgicFileNm());
				log.debug(file.getAbsolutePath() + " : " + file.exists());
				cropFile = OpenCVUtil.cropFaceImage(file, tempDir);
			} catch ( SysException e ) {
				// 시스템 라이브러리 연동 중 오류입니다
				log.error("시스템 라이브러리 연동 오류");
				e.printStackTrace();
				throw new BizException(e.getErrCd());
			} catch ( BizException e ) {
				log.debug("얼굴 검출오류");
				// 사진검출 요류
				//throw new BizException(e.getErrCd());
			} catch ( Exception e ) {
				// 그 밖에 오류
				log.error("무슨 오류다냐");
				e.printStackTrace();
				throw new BizException("ECOM999", new String[] {"오류 발생"});
			}
			
			if ( cropFile != null )
			{
				stndImgList.add(cropFile);
			}
			//log.debug(stndImgList[i].getAbsolutePath() + " : " + stndImgList[i].exists());
		}
		log.debug("=====================================");
		log.debug("");
		File captureImg = new File(Paths.get(profUpload) + File.separator + captureImageInfo.getFilePath() + captureImageInfo.getPgicFileNm());
		log.debug("=====================================");
		log.debug(captureImg.getAbsolutePath() + " : " + captureImg.exists());
		log.debug("=====================================");
		try {
			sameYn = OpenCVUtil.isEqaulFace(stndImgList, captureImg, 55);
		} catch ( SysException e ) {
			// 시스템 라이브러리 연동 중 오류입니다
			log.error("시스템 라이브러리 연동 오류");
			e.printStackTrace();
//			throw new BizException(e.getErrCd());
		} catch ( BizException e ) {
			log.debug("얼굴 검출오류");
			// 사진검출 요류
			e.printStackTrace();
//			throw new BizException(e.getErrCd());
		} catch ( Exception e ) {
			// 그 밖에 오류
			log.error("무슨 오류다냐");
			e.printStackTrace();
//			throw new BizException("ECOM999", new String[] {"오류 발생"});
		}
		
		for ( int i = 0 ; i < stndImgList.size() ; i++ ) {
			File delFile = stndImgList.get(i);
			if ( delFile.exists() )
			{
				delFile.delete();
			}
		}
		
		return sameYn;
	}
	
}
