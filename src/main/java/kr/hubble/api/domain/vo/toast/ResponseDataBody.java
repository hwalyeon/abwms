package kr.hubble.api.domain.vo.toast;

import java.util.List;

import lombok.Data;

@Data
public class ResponseDataBody {

	String requestId;
	String statusCode;
	String senderGroupingKey;
	List<SendResultList> sendResultList;

}
