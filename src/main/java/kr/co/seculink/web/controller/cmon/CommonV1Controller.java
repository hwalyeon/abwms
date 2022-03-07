package kr.co.seculink.web.controller.cmon;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ApiResponses({
		@ApiResponse(code = 200, message = "성공"),
		@ApiResponse(code = 400, message = "파라미터 오류"),
		@ApiResponse(code = 403, message = "인증 오류"),
		@ApiResponse(code = 500, message = "서버 오류"),
})
@Api(tags = { "Common Interface v1" })
@RestController
@RequestMapping("/common/v1")
public class CommonV1Controller {
	
	@ApiOperation(value = "HeartBeat (LB)", notes = "LB Heartbeat 체크용")
	@GetMapping("heartbeat")
	public String input() {
		
		//log.debug("heartbeat");
		
		return "{\"result\" : \"OK\"}";
	}
}

