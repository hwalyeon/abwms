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

	@RequestMapping("/svcStnd/dgem/dgemStndMng.pg")
	public String getSvcStndDgemDgemStndMng() {return "svcStnd/dgem/dgemStndMng";}

	@RequestMapping("/svcStnd/grow/growStndMng.pg")
	public String getSvcStndGrowGrowStndMng() {return "svcStnd/grow/growStndMng";}

	@RequestMapping("/svcStnd/grow/growJudgStndMng.pg")
	public String getSvcStndGrowGrowJudgStndMng() {return "svcStnd/grow/growJudgStndMng";}

	@RequestMapping("/svcStnd/fat/bpalCalcStndMng.pg")
	public String getSvcStndFatBpalCalcStndMng() {return "svcStnd/fat/bpalCalcStndMng";}


}