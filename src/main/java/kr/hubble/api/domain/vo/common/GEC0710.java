package kr.hubble.api.domain.vo.common;

import javax.validation.constraints.NotEmpty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("FCM token 등록 Input")
public class GEC0710 {

	@ApiModelProperty(notes = "FCM token", required = true)
	@NotEmpty
	private String fcmTokn;
}
