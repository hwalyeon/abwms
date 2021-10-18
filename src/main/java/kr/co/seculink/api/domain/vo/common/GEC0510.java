package kr.co.seculink.api.domain.vo.common;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class GEC0510 {

	/** 행정구역코드 */
	@NotBlank
	@ApiModelProperty(notes = "행정 구역코드", required = true)
	private String admCd;
	
	/** 도로명코드 */
	@NotBlank
	@ApiModelProperty(notes = "도로명코드", required = true)
	private String rnMgtSn;
	
	/** 지하여부 */
	@NotBlank
	@ApiModelProperty(notes = "지하여부", required = true)
	private String udrtYn;
	
	/** 건물본번 */
	@NotBlank
	@ApiModelProperty(notes = "건물본번", required = true)
	private String buldMnnm;
	
	/** 건물부번 */
	@NotBlank
	@ApiModelProperty(notes = "건물부번", required = true)
	private String buldSlno;
}
