package kr.co.seculink.domain.vo;

import java.io.Serializable;
import lombok.ToString;
/**
 * tc_siml_base Value Object
 */
 @ToString
public class TcSimlBaseVo implements Serializable {

	/* siml_no 시뮬레이션_번호 numeric(null) */
	private Double simlNo;

	/* siml_nm 시뮬레이션_명 character varying(200) */
	private String simlNm;

	/* siml_cntn 시뮬레이션_내용 character varying(4000) */
	private String simlCntn;

	/* stdt_no 학생_번호 numeric(null) */
	private Double stdtNo;


	/**
	 * Get siml_no 시뮬레이션_번호 numeric(null)
	 * @Return Double simlNo
	 */
	public Double getSimlNo() {
		return this.simlNo;
	}
	
	/**
	 * Set siml_no 시뮬레이션_번호 numeric(null)
	 * @Param Double simlNo
	 */
	public void setSimlNo(Double simlNo) {
		this.simlNo = simlNo;
	}
	/**
	 * Get siml_nm 시뮬레이션_명 character varying(200)
	 * @Return String simlNm
	 */
	public String getSimlNm() {
		return this.simlNm;
	}
	
	/**
	 * Set siml_nm 시뮬레이션_명 character varying(200)
	 * @Param String simlNm
	 */
	public void setSimlNm(String simlNm) {
		this.simlNm = simlNm;
	}
	/**
	 * Get siml_cntn 시뮬레이션_내용 character varying(4000)
	 * @Return String simlCntn
	 */
	public String getSimlCntn() {
		return this.simlCntn;
	}
	
	/**
	 * Set siml_cntn 시뮬레이션_내용 character varying(4000)
	 * @Param String simlCntn
	 */
	public void setSimlCntn(String simlCntn) {
		this.simlCntn = simlCntn;
	}
	/**
	 * Get stdt_no 학생_번호 numeric(null)
	 * @Return Double stdtNo
	 */
	public Double getStdtNo() {
		return this.stdtNo;
	}
	
	/**
	 * Set stdt_no 학생_번호 numeric(null)
	 * @Param Double stdtNo
	 */
	public void setStdtNo(Double stdtNo) {
		this.stdtNo = stdtNo;
	}

} // end of class
