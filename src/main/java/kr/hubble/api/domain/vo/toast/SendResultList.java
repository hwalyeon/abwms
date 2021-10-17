package kr.hubble.api.domain.vo.toast;

import lombok.Data;

@Data
public class SendResultList {
	String recipientNo;
	int resultCode;
	String resultMessage;
	int recipientSeq;
	String recipientGroupingKey;
}
