package kr.hubble.api.domain.vo.toast;

import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class ToastSmsRequest {

	private String templateId;
	private String body;
	private String sendNo;
	private String requestDate;
	private String senderGroupingKey;
	private String userId;
	private String statsId;
	
	private List<Recipient> recipientList;
	
	@Data
	public class Recipient {
		String recipientNo;
		String countryCode;
		String internationalRecipientNo;
		String recipientGroupingKey;
		
		Map<String, String> templateParameter;
	}
	
}
