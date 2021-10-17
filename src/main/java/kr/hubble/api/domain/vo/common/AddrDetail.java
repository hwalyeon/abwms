package kr.hubble.api.domain.vo.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("주소 목록")
public class AddrDetail {
	
	@ApiModelProperty(notes = "도로명 주소")
	private String roadAddr;
	@ApiModelProperty(notes = "우편번호")
	private String zip;
	@ApiModelProperty(notes = "도로명 주소전체")
	private String roadAddrAll;
	@ApiModelProperty(notes = "지번 주소")
	private String jiAddr;
	@ApiModelProperty(notes = "건물명")
	private String bdNm;
	
	/** 도로명주소(참고항목 제외) */
	private String roadAddrPart1;
	
	/** 도로명주소 참고항목 */
	private String roadAddrPart2;
	
	/** 지번주소 */
	private String jibunAddr;
	
	/** 도로명주소(영문) */
	private String engAddr;
	
	/** 우편번호 */
	private String zipNo;
	
	/** 행정구역코드 */
	private String admCd;
	
	/** 도로명코드 */
	private String rnMgtSn;
	
	/** 건물관리번호 */
	private String bdMgtSn;
	
	/** 상세건물명 */
	private String detBdNmList;
	
	/** 공동주택여부(1 : 공동주택, 0 : 비공동주택) */
	private String bdKdcd;
	
	/** 시도명 */
	private String siNm;
	
	/** 시군구명 */
	private String sggNm;
	
	/** 읍면동명 */
	private String emdNm;
	
	/** 법정리명 */
	private String liNm;
	
	/** 도로명 */
	private String rn;
	
	/** 지하여부(0 : 지상, 1 : 지하) */
	private String udrtYn;
	
	/** 건물본번 */
	private String buldMnnm;
	
	/** 건물부번 */
	private String buldSlno;
	
	/** 산여부(0 : 대지, 1 : 산) */
	private String mtYn;
	
	/** 지번본번(번지) */
	private String lnbrMnnm;
	
	/** 지번부번(호) */
	private String lnbrSlno;
	
	/** 읍면동일련번호 */
	private String emdANo;
}
