package kr.hubble.api.domain.vo.juso;

import java.util.List;

import lombok.Data;

@Data
public class JusoResponseResult {

	private JusoResponseCommon common;
	
	private List<JusoResponseDetail> juso;
	
}
