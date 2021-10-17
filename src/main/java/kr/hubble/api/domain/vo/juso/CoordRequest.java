package kr.hubble.api.domain.vo.juso;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class CoordRequest {

	/** 신청시 발급받은 승인키 */
	@NotBlank
	private String confmKey;
	
	/** 행정구역코드 */
	@NotBlank
	private String admCd;
	
	/** 도로명코드 */
	@NotBlank
	private String rnMgtSn;
	
	/** 지하여부 */
	@NotBlank
	private String udrtYn;
	
	/** 건물본번 */
	@NotBlank
	private String buldMnnm;
	
	/** 건물부번 */
	@NotBlank
	private String buldSlno;
	
	/** 검색결과형식 설정(xml, json) */
	private String resultType;
}
