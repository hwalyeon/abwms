package kr.co.seculink.api.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import kr.co.seculink.api.domain.GEConstant.ROLE;
import kr.co.seculink.api.domain.vo.test.Test10010;
import kr.co.seculink.auth.JwtTokenProvider;
import kr.co.seculink.exception.SysException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/test")
@Profile(value = {"local", "dev"})
public class TestController {
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate dao;
	
	@Autowired
    private JwtTokenProvider jwtTokenProvider;
	
	@Profile({"local", "dev"})
	@GetMapping("getTokenUser")
	@ApiOperation("테스트 사용자 토큰 얻기")
	public String getTokenUser(@RequestParam(required = true) String userId, @RequestParam(required = true) String clientId) throws SysException {

		return this.jwtTokenProvider.issueToken(userId, clientId, ROLE.일반사용자);
	}
	
	@Profile({"local", "dev"})
	@GetMapping("getTokenAdmin")
	@ApiOperation("테스트 Admin 토큰 얻기")
	public String getTokenAdmin(@RequestParam(required = true) String userId, @RequestParam(required = true) String clientId) throws SysException {

		return this.jwtTokenProvider.issueToken(userId, clientId, ROLE.어드민);
	}
	
	@GetMapping("getMap")
	@ApiOperation("테스트 Get")
	public Test10010 getMap(@RequestParam(name = "testId", required = true) String testId) {
		
		Map<String, String> rMap = new HashMap<String, String>();
		
		rMap.put("rKey1", "111");
		rMap.put("rKey2", "222");
		rMap.put("rKey3", "333");
		rMap.put("rKey4", "444");
		rMap.put("rKey5", "555");
		
		return new Test10010();
	}
	
	@GetMapping("getMapPath/{testId}")
	@ApiOperation("테스트 Get")
	public Test10010 getMapPath(@PathVariable("testId") String testId) {
		
		Map<String, String> rMap = new HashMap<String, String>();
		
		rMap.put("rKey1", "111");
		rMap.put("rKey2", "222");
		rMap.put("rKey3", "333");
		rMap.put("rKey4", "444");
		rMap.put("rKey5", "555");
		
		return new Test10010();
	}
	
	@PostMapping("postMap")
	@ApiOperation("테스트 Post")
	public Test10010 postMap(@RequestBody(required = true) Test10010 param) {
		
		Map<String, String> rMap = new HashMap<String, String>();
		
		rMap.put("rKey1", "111");
		rMap.put("rKey2", "222");
		rMap.put("rKey3", "333");
		rMap.put("rKey4", "444");
		rMap.put("rKey5", "555");
		
		return new Test10010();
	}
	
	@GetMapping("insert")
	@ApiOperation("테스트 Insert")
	public Test10010 insert() {
		
		Map<String, String> rMap = new HashMap<String, String>();
		
		rMap.put("allcApplSeq", "99");
		rMap.put("allcDivCd", "99");
		
		dao.insert("ALLC_APPL.insert", rMap);
				
		return new Test10010();
	}
}
