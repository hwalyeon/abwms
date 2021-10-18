package kr.co.seculink.api.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import javax.annotation.Resource;

import org.apache.commons.lang3.math.NumberUtils;
import org.locationtech.proj4j.BasicCoordinateTransform;
import org.locationtech.proj4j.CRSFactory;
import org.locationtech.proj4j.CoordinateReferenceSystem;
import org.locationtech.proj4j.ProjCoordinate;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.firebase.messaging.BatchResponse;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.MulticastMessage;
import com.google.firebase.messaging.SendResponse;
import com.google.firebase.messaging.WebpushConfig;
import com.google.firebase.messaging.WebpushNotification;

import kr.co.seculink.api.domain.vo.common.AddrDetail;
import kr.co.seculink.api.domain.vo.common.AddrResultVO;
import kr.co.seculink.api.domain.vo.common.CoordDetail;
import kr.co.seculink.api.domain.vo.common.CoordResultVO;
import kr.co.seculink.api.domain.vo.juso.CoordRequest;
import kr.co.seculink.api.domain.vo.juso.CoordResponse;
import kr.co.seculink.api.domain.vo.juso.CoordResponseCommon;
import kr.co.seculink.api.domain.vo.juso.CoordResponseDetail;
import kr.co.seculink.api.domain.vo.juso.JusoResponse;
import kr.co.seculink.api.domain.vo.juso.JusoResponseCommon;
import kr.co.seculink.api.domain.vo.juso.JusoResponseDetail;
import kr.co.seculink.exception.BaseException;
import kr.co.seculink.exception.SysException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("commonService")
public class CommonServiceImpl implements CommonService {

	@Value("${juso.api.url}")
	private String jusoApiUrl;
	
	@Value("${juso.api.key}")
	private String jusoApiKey;
	
	@Value("${juso.coordApi.url}")
	private String jusoCoordApiUrl;
	
	@Value("${juso.coordApi.key}")
	private String jusoCoordApiKey;
	
	@Resource(name = "restTemplateJuso")
	private RestTemplate restTemplate;
	
	@Lazy
	@Resource(name = "commonService")
	private CommonService commonService;
	
	@Autowired
	private SqlSessionTemplate dao;
	
	ObjectMapper om = new ObjectMapper();
	
	@Override
	public AddrResultVO srchAddr(String srchWord, int curPage, int cntPerPage) throws BaseException {
		
		om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		AddrResultVO result = new AddrResultVO();
		
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
		
		parameters.add("keyword", srchWord);
		parameters.add("confmKey", this.jusoApiKey);
		parameters.add("currentPage", curPage + "");
		parameters.add("countPerPage", cntPerPage + "");
		parameters.add("resultType", "json");
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		HttpEntity<MultiValueMap<String, String>> formEntity = new HttpEntity<>(parameters, headers);
		
		ResponseEntity<JusoResponse> outputEntity = this.restTemplate.postForEntity(this.jusoApiUrl
				, formEntity
				, JusoResponse.class);
		
		JusoResponse output = outputEntity.getBody();
		
		if (null != output) {
			if (null != output.getResults()) {
				if (null != output.getResults().getCommon()) {
					
					JusoResponseCommon common = output.getResults().getCommon();
					
					result.setTotCnt(Integer.parseInt(common.getTotalCount()));
					result.setCurPage(common.getCurrentPage());
					result.setCntPerPage(common.getCountPerPage());
				}
				
				if (null != output.getResults().getJuso()) {
					List<AddrDetail> list = new ArrayList<>();
					
					List<JusoResponseDetail> detail = output.getResults().getJuso();
					
					for (JusoResponseDetail item : detail) {
						AddrDetail vo = om.convertValue(item, AddrDetail.class);
						
						vo.setZip(item.getZipNo());
						vo.setRoadAddrAll(item.getRoadAddr());
						vo.setRoadAddr(item.getRoadAddrPart1());
						vo.setBdNm(item.getBdNm());
						vo.setJiAddr(item.getJibunAddr());

						list.add(vo);
					}
					
					result.setList(list);
				}
			}
		}
		
		return result;
	}
	
	@Override
	public CoordResultVO srchCoord(CoordRequest request) throws BaseException {
		
		om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		CoordResultVO result = new CoordResultVO();
		
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
		
		parameters.add("confmKey", this.jusoCoordApiKey);
		parameters.add("resultType", "json");
		
		parameters.add("admCd", request.getAdmCd());
		parameters.add("rnMgtSn", request.getRnMgtSn());
		parameters.add("udrtYn", request.getUdrtYn());
		parameters.add("buldMnnm", request.getBuldMnnm());
		parameters.add("buldSlno", request.getBuldSlno());
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		HttpEntity<MultiValueMap<String, String>> formEntity = new HttpEntity<>(parameters, headers);
		
		ResponseEntity<CoordResponse> outputEntity = this.restTemplate.postForEntity(this.jusoCoordApiUrl
				, formEntity
				, CoordResponse.class);
		
		CoordResponse output = outputEntity.getBody();
		
		if (null != output) {
			if (null != output.getResults()) {
				if (null != output.getResults().getCommon()) {
					
					CoordResponseCommon common = output.getResults().getCommon();
					
					result.setTotCnt(Integer.parseInt(common.getTotalCount()));
				}
				
				if (null != output.getResults().getJuso()) {
					List<CoordDetail> list = new ArrayList<>();
					
					List<CoordResponseDetail> detail = output.getResults().getJuso();
					
					for (CoordResponseDetail item : detail) {
						CoordDetail vo = om.convertValue(item, CoordDetail.class);
						
						if (NumberUtils.isParsable(item.getEntX()) && 
								NumberUtils.isParsable(item.getEntY())) {
						
							String[] latlon = this.convertCoord(item.getEntX(), item.getEntY());
							
							vo.setLat(latlon[0]);
							vo.setLon(latlon[1]);
						}
						
						list.add(vo);
					}
					
					result.setList(list);
				}
			}
		}
		
		return result;
	}
	
	private String[] convertCoord(String strX, String strY ) {

		double x = Double.parseDouble( strX );//x좌표
		double y = Double.parseDouble( strY );//y좌표
		
		CRSFactory factory = new CRSFactory(); 
		CoordinateReferenceSystem srcCrs = factory.createFromName("EPSG:5179");//현재 좌표 
		CoordinateReferenceSystem dstCrs = factory.createFromName("EPSG:4326");//변경할 좌표 

		BasicCoordinateTransform transform = new BasicCoordinateTransform(srcCrs, dstCrs); 

		ProjCoordinate srcCoord = new ProjCoordinate(x, y); 
		ProjCoordinate dstCoord = new ProjCoordinate();

		transform.transform(srcCoord, dstCoord);//좌표변환 
		
		return new String[] {dstCoord.y + "", dstCoord.x + ""};
	}
	
	@Override
	public void sendFcmByTopic(String topic, String title, String message, String action, String seq) throws BaseException {
        Message fcmMessage = Message.builder()
        		.setWebpushConfig(WebpushConfig.builder().putHeader("ttl", "300")
                        .setNotification(new WebpushNotification(title,
                        		 message))
                        .build())
        		.setTopic(topic)
                .putData("title", title)
				.putData("message", message)
				.putData("action", action)
				.putData("seq", seq)
                .build();

        String response = "";
		try {
			response = FirebaseMessaging.getInstance().sendAsync(fcmMessage).get();
			log.debug("Sent message: " + response);
		} catch (InterruptedException | ExecutionException e) {
			throw new SysException(e, "ESYS005", null);
		}
        
    }
	
	@Override
	public void sendFcmByUsers(List<String> tokens, String title, String message, String action, String seq) throws BaseException {
		MulticastMessage fcmMessage = MulticastMessage.builder()
				.setWebpushConfig(WebpushConfig.builder().putHeader("ttl", "300")
                        .setNotification(new WebpushNotification(title,
                        		 message))
                        .build())
				.putData("title", title)
				.putData("message", message)
				.putData("action", action)
				.putData("seq", seq)
			    .addAllTokens(tokens)
			    .build();
		BatchResponse response = null;
		try {
			response = FirebaseMessaging.getInstance().sendMulticast(fcmMessage);
		} catch (FirebaseMessagingException e) {
			throw new SysException(e, "ESYS005", null);
		}
		
		log.debug(response.getSuccessCount() + " messages were sent successfully");
		log.debug(response.getFailureCount() + " messages were sent fail");
		
		int idx = 0;
		
		for (SendResponse item : response.getResponses()) {
			
			// 실패한 경우 잘못된 토큰 제거
			if (false == item.isSuccessful()) {
				
				String fcmTokn = tokens.get(idx);
				String errorCode = item.getException().getErrorCode();
				
				log.debug("error token = {}", fcmTokn);
				log.debug("error message {}", item.getException().getMessage());
				log.debug("exception = {}", errorCode);
				
				// registration-token-not-registered 폐기된 토큰
				// invalid-argument 잘못된 토큰
				
				if (true == "registration-token-not-registered".equals(errorCode)
						|| true == "invalid-argument".equals(errorCode)) {
				
					this.dao.delete("GEC.deleteInvalidFcm", fcmTokn);
				
				}
			}
			
			idx++;
		}
    }
	
	@Override
	public void sendFcmBySql(String sqlId, Map<String, Object> sqlParam, String title, String message, String action, String seq) throws BaseException {
		
		List<String> tokens = this.dao.selectList(sqlId, sqlParam);
		
		// 결과가 있는 경우에만 호출
		if (null != tokens && tokens.size() > 0) {
		
			this.commonService.sendFcmByUsers(tokens, title, message, action, seq);
		
		}
    }
}
