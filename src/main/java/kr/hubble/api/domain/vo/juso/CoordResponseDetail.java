package kr.hubble.api.domain.vo.juso;

import lombok.Data;

@Data
public class CoordResponseDetail {

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
