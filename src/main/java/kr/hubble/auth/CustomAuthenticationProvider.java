package kr.hubble.auth;

import java.util.List;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import kr.hubble.api.model.SessionVo;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		String userId = (String) authentication.getPrincipal();
		String clientId = (String) authentication.getCredentials();
		List<SimpleGrantedAuthority> roleList = (List<SimpleGrantedAuthority>) authentication.getAuthorities();
		
//		log.debug("userId : {}", userId);
//		log.debug("clientId : {}", clientId);
//		log.debug("CustomAuthenticationProvider 권한 : " + roleList);
		
		SessionVo user = new SessionVo();
		user.setUserId(userId);
		user.setClntId(clientId);
		user.setRoleList(roleList);
		
		UsernamePasswordAuthenticationToken result = (UsernamePasswordAuthenticationToken) authentication;

		result.setDetails(user);

		// user session 생성 후 반환
		return result;

	}

	@Override
	public boolean supports(Class<?> authentication) {

		return authentication.equals(UsernamePasswordAuthenticationToken.class);

	}

}
