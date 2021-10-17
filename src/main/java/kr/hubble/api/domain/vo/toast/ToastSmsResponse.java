package kr.hubble.api.domain.vo.toast;

import lombok.Data;

@Data
public class ToastSmsResponse {

	private Header header;
	private ResponseBody body;
	
	@Data
	public class Header {
		String isSuccessful;
		int resultCode;
		String resultMessage;
	}
}
