package kr.hubble.batch;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import kr.hubble.exception.BizException;
import kr.hubble.util.XUtil;
import kr.hubble.web.service.cous.LectMngService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class LectProcess
{
	@Autowired
	private LectMngService lectMngService;
	
	 /**
	  * DESC : 오늘 강의에 대한 이수내역 데이터 생성
	  * @throws BizException
	  */
	@Scheduled(cron="0 0 8 * * *")
	public void createLectTake() throws BizException
	{
		log.debug("createLectTake");
		List<Map<String, String>> lectInfoList = lectMngService.searchLectTakeObj();
		log.debug("lectInfoList.size : " + lectInfoList.size());
		for ( Map<String, String> lectInfo : lectInfoList )
		{
			log.debug(lectInfo.toString());
			if ( "0".equals(String.valueOf(lectInfo.get("cousTakeRegCnt"))) ) {
				lectMngService.insertLectTake(lectInfo);
			}
		}
	}
	
	/**
	 * desc : 종료일자가 지난 과정은 종료로 변경한다.
	 *        종료로 변경된 TS_COUS_STDT에도 종료로 변경한다.
	 * */
	@Scheduled(cron="0 5 8 * * *")
	public void changeCousState() throws BizException
	{
		log.debug("changeCousState");
		
		lectMngService.updateChangeCousStat();
		
		lectMngService.updateChangeCousStdtStat();
	}
}
