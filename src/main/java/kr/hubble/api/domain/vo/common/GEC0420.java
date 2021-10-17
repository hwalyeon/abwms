package kr.hubble.api.domain.vo.common;

import javax.validation.constraints.NotEmpty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@ApiModel("내정보 조회 Output")
public class GEC0420 {

	@ApiModelProperty(notes = "사용자ID", required = true)
	@NotEmpty
	private String userId;
	
	@ApiModelProperty(notes = "사용자명")
	private String userNm;
	
	@ApiModelProperty(notes = "닉네임")
	private String nick;
	
	@ApiModelProperty(notes = "이메일")
	private String emal;
	
	@ApiModelProperty(notes = "휴대폰 번호")
	private String hp;
	
	@ApiModelProperty(notes = "SNS가입구분[10-카카오, 20-네이버, 30-페북, ''-해당없음]")
	private String snsDivCd;
	
	@ApiModelProperty(notes = "이벤트 알림 여부")
	private String evntNotiYn;
	
	@ApiModelProperty(notes = "리뷰 알림 여부")
	private String revwNotiYn;
	
	@ApiModelProperty(notes = "댓글 알림 여부")
	private String repyNotiYn;
	
	@ApiModelProperty(notes = "AS센터 댓글 알림 여부")
	private String asctNotiYn;
	
	@ApiModelProperty(notes = "사진URL")
	private String photUrl;
}
