package kr.hubble.web.controller;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/web")
public class WebController {

	@Autowired
	private SqlSessionTemplate dao;
	
	@GetMapping("/deeplink")
	public String deeplink(@RequestParam(name = "action", required = true) String action, 
			@RequestParam(name="seq", required = true) String seq, Model model) {
			
		model.addAttribute("action", action);
		model.addAttribute("seq", seq);
		
		String message = "";
		
		/*
		if (true == "event".equals(action)) {
			
			GEH0220 event = this.dao.selectOne("GEH.GEH0220", seq);
			
			if (null != event) {
				message = event.getEvtTitl();
				message += "<br/>";
				message += "<img src='" + event.getBnnrPhotUrl() + "'/>";
			}
			
		} else if (true == "astory".equals(action)) {
			GE30120 astory = this.dao.selectOne("GE3.GE30120", seq);
			
			if (null != astory) {
				message = astory.getAstrTitl();
				message += "<br/>";
				message += "<img src='" + astory.getReprPhotUrl() + "'/>";
			}
			
		} else if (true == "moveTab".equals(action)) {
			message = "<embed src='https://d9xcup0t2zcqt.cloudfront.net/movi/ar.mp4'";
		}
		*/
		
		model.addAttribute("message", message);
		
		return "deeplink";
	}
}
