package kr.co.seculink.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class CommonWebController {
	// thymleaf 적용하지 않을경우 static의 index.html로 간다.
	@GetMapping(path = "/")
	public String index() {
		log.debug("index!!");
		return "common/main/index";
	}

	@GetMapping(path = "/login.pg")
	public String login() {
		return "common/main/login";
	}

	@GetMapping(path = "/main.pg")
	public String main() {
		return "common/main/main";
	}

	@RequestMapping("/set/userMng.pg")
	public String getSetUserMng() {
		return "set/userMng";
	}

	@RequestMapping("/set/userRoleMng.pg")
	public String getSetUserRoleMng() {
		return "set/userRoleMng";
	}

	@RequestMapping("/set/roleMng.pg")
	public String getSetRoleMng() {
		return "set/roleMng";
	}

	@RequestMapping("/set/menuMng.pg")
	public String getSetMenuMng() {
		return "set/menuMng";
	}

	@RequestMapping("/set/menuRoleMng.pg")
	public String getSetMenuRoleMng() {
		return "set/menuRoleMng";
	}

	@RequestMapping("/set/cdMng.pg")
	public String getSetCdMng() {
		return "set/cdMng";
	}

	@RequestMapping("/svcStnd/strs/strsStndMng.pg")
	public String getSvsStndStrsStrsStndMng() {
		return "svcStnd/strs/strsStndMng";
	}

	//위험감정기준
	@RequestMapping("/svcStnd/dgem/dgemStndMng.pg")
	public String getSvcStndDgemDgemStndMng() {return "svcStnd/dgem/dgemStndMng";}

	//심박상태 기준
	@RequestMapping("/svcStnd/dgem/hbitStatStndMng.pg")
	public String getSvcStndDgemHbitStatStndMng() {return "svcStnd/dgem/hbitStatStndMng";}

	//체온상태 기준
	@RequestMapping("/svcStnd/dgem/tempStatStndMng.pg")
	public String getSvcStndDgemTempStatStndMng() {return "svcStnd/dgem/tempStatStndMng";}

	//성장기준
	@RequestMapping("/svcStnd/grow/growStndMng.pg")
	public String getSvcStndGrowGrowStndMng() {return "svcStnd/grow/growStndMng";}

	@RequestMapping("/svcStnd/grow/growJudgStndMng.pg")
	public String getSvcStndGrowGrowJudgStndMng() {return "svcStnd/grow/growJudgStndMng";}

	//활동기준
	@RequestMapping("/svcStnd/grow/actStndMng.pg")
	public String getSvcStndGrowActStndMng() {return "svcStnd/grow/actStndMng";}

	//비만기준
	@RequestMapping("/svcStnd/fat/fatStndMng.pg")
	public String getSvcStndFatFatStndMng() {return "svcStnd/fat/fatStndMng";}

	//비만판정기준
	@RequestMapping("/svcStnd/fat/fatJudgStndMng.pg")
	public String getSvcStndFatFatJudgStndMng() {return "svcStnd/fat/fatJudgStndMng";}

	//휴식대사량기준
	@RequestMapping("/svcStnd/fat/bpalCalcStndMng.pg")
	public String getSvcStndFatBpalCalcStndMng() {return "svcStnd/fat/bpalCalcStndMng";}

	//영양소정보
	@RequestMapping("/svcStnd/nutr/nutrInfoMng.pg")
	public String getSvcStndNutrNutrInfoMng() {return "svcStnd/nutr/nutrInfoMng";}

	//일일 영양소섭취기준
	@RequestMapping("/svcStnd/nutr/ddNutrEatStndMng.pg")
	public String getSvcStndNutrDdNutrEatStndMng() {return "svcStnd/nutr/ddNutrEatStndMng";}

	//일일 권장섭취량기준
	@RequestMapping("/svcStnd/nutr/ddRcmdEatStndMng.pg")
	public String getSvcStndNutrDdRcmdEatStndMng() {return "svcStnd/nutr/ddRcmdEatStndMng";}

	//위치정보
	@RequestMapping("/svcStnd/loc/locInfoMng.pg")
	public String getSvcStndLocLocInfoMng() {return "svcStnd/loc/locInfoMng";}

	//교육시설정보보
	@RequestMapping("/svcStnd/loc/eorgInfoMng.pg")
	public String getSvcStndLocEorgInfoMng() {return "svcStnd/loc/eorgInfoMng";}

	//식품정보
	@RequestMapping("/svcStnd/food/foodInfoMng.pg")
	public String getSvcStndFoodFoodInfoMng() {return "svcStnd/food/foodInfoMng";}

	//일일 신체활동수준
	@RequestMapping("/svcStnd/act/ddPalMng.pg")
	public String getSvcStndFatDdPalMng() {return "svcStnd/act/ddPalMng";}

	//밴드/개통정보
	@RequestMapping("/devc/band/bandOpenInfoMng.pg")
	public String getDevcBandBandOpenInfoMng() {return "devc/band/bandOpenInfoMng";}

	//약관정보
	@RequestMapping("/cmon/stnd/termInfoMng.pg")
	public String getCmonStndTermInfoMng() {return "cmon/stnd/termInfoMng";}

	//고객지원센터
	@RequestMapping("/cmon/stnd/csInfoMng.pg")
	public String getCmonStndCsInfoMng() {return "cmon/stnd/csInfoMng";}

	//보호자(사용자)정보
	@RequestMapping("/user/guar/guarInfoMng.pg")
	public String getUserGuarGuarInfoMng() {return "user/guar/guarInfoMng";}

	//학생정보
	@RequestMapping("/user/stdt/stdtInfoMng.pg")
	public String getUserStdtStdtInfoMng() {return "user/stdt/stdtInfoMng";}

	//신체활동수준 기준
	@RequestMapping("/svcStnd/act/palStndMng.pg")
	public String getSvcStndActPalStndMng() {return "svcStnd/act/palStndMng";}

	//성장활동 기준
	@RequestMapping("/svcStnd/act/growActStndMng.pg")
	public String getSvcStndActGrowActStndMng() {return "svcStnd/act/growActStndMng";}

	//비만활동 기준
	@RequestMapping("/svcStnd/act/fatActStndMng.pg")
	public String getSvcStndActFatActStndMng() {return "svcStnd/act/fatActStndMng";}

	//위험감정 발생이력
	@RequestMapping("/oper/dgem/dgemHist.pg")
	public String getOperDgemDgemHist() {return "oper/dgem/dgemHist";}

	//위치 이력
	@RequestMapping("/oper/dgem/locHist.pg")
	public String getOperDgemLocHist() {return "oper/dgem/locHist";}

	//위험안전지역 발생현황
	@RequestMapping("/oper/dgem/dszoneHist.pg")
	public String getOperDgemDszoneHist() {return "oper/dgem/dszoneHist";}

	//공공안전지역 탐지현황
	@RequestMapping("/oper/dgem/porgZoneStat.pg")
	public String getOperDgemPorgZoneStat() {return "oper/dgem/porgZoneStat";}

	//보호자관심지역 현황
	@RequestMapping("/oper/dgem/guarZoneStat.pg")
	public String getOperDgemGuarZoneStat() {return "oper/dgem/guarZoneStat";}

	//스트레스지수 이력
	@RequestMapping("/oper/hc/strsHist.pg")
	public String getOperHcStrsHist() {return "oper/hc/strsHist";}

	//섭취 이력
	@RequestMapping("/oper/hc/eatHist.pg")
	public String getOperHcEatHist() {return "oper/hc/eatHist";}

	//활동 이력
	@RequestMapping("/oper/hc/actHist.pg")
	public String getOperHcActHist() {return "oper/hc/actHist";}

	//성장비만지수 이력
	@RequestMapping("/oper/hc/gfixHist.pg")
	public String getOperHcGfixHist() {return "oper/hc/gfixHist";}

	//보호자식단표 현황
	@RequestMapping("/oper/hc/guarFmenuHist.pg")
	public String getOperHcGuarFmenuHist() {return "oper/hc/guarFmenuHist";}

	//비만예측설문조사 이력
	@RequestMapping("/oper/hc/fatpQustHist.pg")
	public String getOperHcFatpQustHist() {return "oper/hc/fatpQustHist";}

	//영양소섭취 이력
	@RequestMapping("/oper/hc/nutrEatHist.pg")
	public String getOperHcNutrEatHist() {return "oper/hc/nutrEatHist";}

	//캐시비 이력
	@RequestMapping("/oper/cbee/cbeeHist.pg")
	public String getOperCbeeCbeeHist() {return "oper/cbee/cbeeHist";}

	//배치작업 이력
	@RequestMapping("/oper/sys/btchJobHist.pg")
	public String getOperSysBtchJobHist() {return "oper/sys/btchJobHist";}

	//알람처기 이력
	@RequestMapping("/oper/sys/alamHist.pg")
	public String getOperSysAlamHist() {return "oper/sys/alamHist";}

	//종합관제현황
	@RequestMapping("/oper/cmon/totMonStat.pg")
	public String getOperCmonTotMonStat() {return "oper/cmon/totMonStat";}

	//종합관제현황 임시
	@RequestMapping("/oper/cmon/totMonStatTemp.pg")
	public String getOperCmonTotMonStatTemp() {return "oper/cmon/totMonStatTemp";}

	/* 통계 */
	// 위험감정 추이분석
	@RequestMapping("/stat/dgem/dgemStss.pg")
	public String getStatDgemDgemStss() {return "stat/dgem/dgemStss";}

	// 위험지역 추이분석
	@RequestMapping("/stat/dgem/dzoneStss.pg")
	public String getStatDgemZoneStss() {return "stat/dgem/dzoneStss";}

	// 성장지수 추이분석
	@RequestMapping("/stat/hc/gidxStss.pg")
	public String getStatHcGidxStss() {return "stat/hc/gidxStss";}

	// 비만지수 추이분석
	@RequestMapping("/stat/hc/fidxStss.pg")
	public String getStatHcFidxStss() {return "stat/hc/fidxStss";}

	// 비만예측지수 추이분석
	@RequestMapping("/stat/hc/fatpStss.pg")
	public String getStatHcFatpStss() {return "stat/hc/fatpStss";}

	// 평균 칼로리섭취 추이분석
	@RequestMapping("/stat/hc/avalCalStss.pg")
	public String getStatHcAvalCalStss() {return "stat/hc/avalCalStss";}

	// 평균 운동시간 추이분석
	@RequestMapping("/stat/hc/avalActStss.pg")
	public String getStatHcAvalActStss() {return "stat/hc/avalActStss";}

	// 식품별 섭취현황 추이분석
	@RequestMapping("/stat/hc/foodEatStss.pg")
	public String foodEatHcFoodEatStss() {return "stat/hc/foodEatStss";}

	// 유형별 결식율 추이분석
	@RequestMapping("/stat/hc/neatStss.pg")
	public String getStatHcNeatStss() {return "stat/hc/neatStss";}

	// 캐시비 추이분석
	@RequestMapping("/stat/etc/cbeeStss.pg")
	public String getStatEtcCbeeStss() {return "stat/etc/cbeeStss";}

}