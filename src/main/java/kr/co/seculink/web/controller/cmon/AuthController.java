package kr.co.seculink.web.controller.cmon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.seculink.domain.RtnMsg;
import kr.co.seculink.web.model.cmon.SessionVO;
import kr.co.seculink.auth.CustomAuthenticationProvider;
import kr.co.seculink.auth.JwtTokenProvider;
import kr.co.seculink.exception.BaseException;
import kr.co.seculink.exception.BizException;
import kr.co.seculink.exception.SysException;
import kr.co.seculink.util.GEUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/v1/auth")
public class AuthController {
	
	@Autowired 
	private CustomAuthenticationProvider authenticationProvider;

	@Autowired
	private SqlSessionTemplate dao;
	
	@Autowired
    private JwtTokenProvider jwtTokenProvider;
	
	@PostMapping("/login.ab")
	public RtnMsg login(@RequestBody Map<String, String> params) throws BaseException {
		
		RtnMsg rtnMsg = new RtnMsg();

		try {
			
			// DB에서 사용자 정보 확인
			Map<String, String> userInfo = dao.selectOne("cmon.user.searchUserInfo", params);
			
			if (null == userInfo) {
				throw new BizException("ECOM007"); // 사용자ID 또는 비밀번호 오류
			}
			
			List<GrantedAuthority> grantedAuths = new ArrayList<>();
			
			// 권한조회
			List<Map<String, String>> roleList = dao.selectList("cmon.user.searchRoleList", params);
			
			String[] roles = new String[roleList.size()];
			
			for ( int i = 0 ; i < roleList.size() ; i++ )
			{
				Map<String, String> roleMap = roleList.get(i);
				
				grantedAuths.add(new SimpleGrantedAuthority(roleMap.get("roleCd")));
				roles[i] = roleMap.get("roleCd");
			}

			UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(params.get("userId"), params.get("userId"), grantedAuths);
			SecurityContextHolder.getContext().setAuthentication(this.authenticationProvider.authenticate(authToken));
			
			// token 발행
			String token = jwtTokenProvider.issueToken(params.get("userId"), params.get("userId"), roles);
	
			Map<String, Object> result = new HashMap<String, Object>();
			result.put("jwtToken", token);
			result.put("userInfo", userInfo);
			result.put("roleList", roleList);
			
			rtnMsg.setRtnData(result);

		} catch (UsernameNotFoundException e) {
			
			throw new BizException("ECOM007"); // 사용자ID 또는 비밀번호 오류
		} catch (AuthenticationException e) {
			
			throw new SysException(e, "ECOM008", null); // 로그인 처리 중 오류
		} catch (BaseException e) {
			throw e;
		}
				
		log.debug("session user id {}", GEUtil.getSessionUserId());
		
		return rtnMsg;
	}

	@PostMapping("/logout.ab")
//	@ApiOperation(value = "[" + API_DIV.마이페이지 + "-2000] 로그아웃 <Z완>", notes = "<로그아웃> 버튼 https://zpl.io/aBD6Z8K")
	public RtnMsg<Void> logout() {	

		// Session (Token) 정보에서 userId 및 clientId 취득
		SessionVO vo = GEUtil.getSessionVo();

		String userId   = "admin";
		String clientId = "admin";
		
		if ( vo != null ) {
			userId   = vo.getUserId();
			clientId = vo.getClntId();			
		}

		jwtTokenProvider.removeToken(userId, clientId);

		RtnMsg<Void> rtnMsg = new RtnMsg<>();

		return rtnMsg;
	}
}
