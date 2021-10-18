package kr.co.seculink.api.domain.vo.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("좌표검색 목록")
public class CoordDetail {
	
	@ApiModelProperty(notes = "위도")
	private String lat;
	@ApiModelProperty(notes = "경도")
	private String lon;
	
	/** 행정구역코드 */
	private String admCd;
	/** 도로명코드 */
	private String rnMgtSn;
	/** 건물관리번호 */
	private String bdMgtSn;
	/** 지하여부(0 : 지상, 1 : 지하) */
	private String udrtYn;
	/** 건물본번 */
	private String buldMnnm;
	/** 건물부번 */
	private String buldSlno;
	/** X좌표 */
	private String entX;
	/** Y좌표 */
	private String entY;
	/** 건물명 */
	private String bdNm;
}
