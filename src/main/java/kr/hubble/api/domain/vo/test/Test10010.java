package kr.hubble.api.domain.vo.test;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Test10010 {
	
	@ApiModelProperty(required = true)
	private String testKey1;
	private String testKey2;
	private String testKey3;
	
	private List<Test10011> testList;
}
