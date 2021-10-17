package kr.hubble.api.model;

import java.io.Serializable;
import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import lombok.Data;

@Data
public class SessionVo implements Serializable {

	private static final long serialVersionUID = -6879974319831987454L;

	private String userId;
	
	private String userNm;

	private String clntId;
	
	private List<SimpleGrantedAuthority> roleList;
}
