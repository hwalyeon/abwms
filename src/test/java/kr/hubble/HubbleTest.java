package kr.hubble;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.locationtech.proj4j.BasicCoordinateTransform;
import org.locationtech.proj4j.CRSFactory;
import org.locationtech.proj4j.CoordinateReferenceSystem;
import org.locationtech.proj4j.ProjCoordinate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import kr.hubble.api.service.CommonService;
import kr.hubble.auth.JwtTokenProvider;
import kr.hubble.exception.BaseException;
import kr.hubble.exception.BizException;
import kr.hubble.exception.SysException;
import kr.hubble.util.GEUtil;
import kr.hubble.util.OpenCVUtil;
import kr.hubble.util.SHAEncUtil;
import kr.hubble.util.Seed256EncUtil;
import kr.hubble.web.model.TcFileVO;
import kr.hubble.web.service.clss.CousTakeService;

@SpringBootTest
public class HubbleTest {

	@Autowired
	JwtTokenProvider jwtTokenProvider;
	
	@Autowired
	private CommonService commonService;
	
	@Autowired
	private CousTakeService cousTakeService;
	
	ObjectMapper om = new ObjectMapper();
	
	//@Test
	public void test() throws SysException {
		
		System.out.println(SHAEncUtil.getSHA512("1111"));
		
		System.out.println(jwtTokenProvider.issueToken("test", "android", new String[] {"111"}));
		
		DecodedJWT jwt = this.jwtTokenProvider.decodeToken("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJjbGllbnRJZCI6IjEyMyIsImlzcyI6ImdldGV5ZXMtYXBpLXNlcnZlci1kZXYiLCJleHAiOjE2MTU5NTY3MzQsInVzZXJJZCI6IjFzdHJpbmcifQ._ICsVgV3K6JxXaf3oCxivbQRE4_7D7bT9h7WSnY7CYo");
		
		boolean isValid = this.jwtTokenProvider.validateToken("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJjbGllbnRJZCI6IjEyMyIsImlzcyI6ImdldGV5ZXMtYXBpLXNlcnZlci1kZXYiLCJleHAiOjE2MTU5NTY3MzQsInVzZXJJZCI6IjFzdHJpbmcifQ._ICsVgV3K6JxXaf3oCxivbQRE4_7D7bT9h7WSnY7CYo");
		
		System.out.println("isValid " + isValid);
		
		System.out.println(jwt.getExpiresAt().toString());
		
		System.out.println(Seed256EncUtil.getRandomKey());
		System.out.println(Seed256EncUtil.getRandomKey());
		System.out.println(Seed256EncUtil.getRandomKey());
		
		String randomKey = Seed256EncUtil.getRandomKey();
		
		String encData = Seed256EncUtil.encrypt("1111111111111호구", randomKey);
		
		System.out.println(encData);
		System.out.println(Seed256EncUtil.decrypt(encData, randomKey));
	}
	
	//@Test
	public void test3() {
		System.out.println(GEUtil.checkPass("123"));
		System.out.println(GEUtil.checkPass("123asd"));
		System.out.println(GEUtil.checkPass("123asd23d132o8u98quweujaosjdioijasd"));
	}
	
	//@Test
	public void test4() throws SysException {
		System.out.println(GEUtil.convertRtName("송a강1민"));
		System.out.println(SHAEncUtil.getSHA512("1234qwer"));
	}
	
	//@Test
	public void testaddr() throws BaseException, JsonProcessingException {
		System.out.println(om.writeValueAsString(commonService.srchAddr("북악산로 844", 1, 100)));
	}
	
	//@Test
	public void test6() throws BaseException {
		//commonService.sendFcmByTopic("ALL", "test title", "test message");
		List<String> testList = new ArrayList<>();
		
		testList.add("entIpKNFSf6_m-RLeKTMp7:APA91bEQCJb8ymGOydt9FulkJbyWRT-qSJtfw2bf1xsToSmSI2dSV8KdSPfEaB54KsQS8fCNK53-ZbXazta7vV06drWAemtLwt2QjOsC17-5I6gzQOp8ve9-1RmnIW7GulrA90IPeWR7");
		testList.add("11111111");
		//testList.add("eWM5GndZSxuBLIAAQRvGHa:APA91bF10O90f-sMq0Zo8v940I1ed6cUjq31qOQ1t8rkexOSJOeZR5hvpNTTqYZWraRwlRqrkLHAS103It2RbSJkaVXe-9DVVBdCed_2jSrpVkD3u9Bh6whj_im_uw8p2l4hyq32n7ni");
		
		commonService.sendFcmByUsers(testList, "Geteyes", " test message", "event", "13");
	}
	
	//@Test
	public void test7() {
		double x = Double.parseDouble( "953332.8822066733" );//x좌표 
		double y = Double.parseDouble( "1952348.24570509" );//y좌표 

		CRSFactory factory = new CRSFactory(); 
		CoordinateReferenceSystem srcCrs = factory.createFromName("EPSG:5179");//현재 좌표 
		CoordinateReferenceSystem dstCrs = factory.createFromName("EPSG:4326");//변경할 좌표 

		BasicCoordinateTransform transform = new BasicCoordinateTransform(srcCrs, dstCrs); 

		ProjCoordinate srcCoord = new ProjCoordinate(x, y); 
		ProjCoordinate dstCoord = new ProjCoordinate();

		transform.transform(srcCoord, dstCoord);//좌표변환 
		System.out.println(dstCoord.x + "," + dstCoord.y);//변환된 좌표 O
	}
	
	//@Test
	public void test8() throws BaseException {
		String savePath = "C:\\Users\\drs\\Pictures";
		File testFile = new File("C:\\Users\\drs\\Documents\\WIN_20210221_17_37_25_Pro.jpg");
		
		OpenCVUtil.cropFaceImage(testFile, savePath);
		
	}
	

//	@Test
	public void test9() throws BaseException {
		List<File> profiles = new ArrayList<File>();
		profiles.add(new File("/Users/drs/k1.jpg"));
		profiles.add(new File("/Users/drs/k2.jpg"));
		profiles.add(new File("/Users/drs/k3.jpg"));
		profiles.add(new File("/Users/drs/k4.jpg"));
		profiles.add(new File("/Users/drs/k5.jpg"));
		
		File liveImage = new File("/Users/drs/k0.jpeg");
		
		System.out.println(OpenCVUtil.isEqaulFace(profiles, liveImage, 50));
		
	}
	
	@Test
	public void test10() throws BizException
	{
		// 출석요청
		Map<String, String> params = new HashMap<>();
		params.put("cousNo", "1");
		params.put("lectSeq", "1");
		params.put("stdtId", "kimjh");
		params.put("action", "REQ_ATTD");
		
		TcFileVO fileVo = new TcFileVO();
		fileVo.setFileNo("75");
		fileVo.setFilePath("event\\1\\1\\");
		fileVo.setPgicFileNm("WIN_20210303_14_37_49_Pro.jpg");
		fileVo.setLgicFileNm("WIN_20210303_14_37_49_Pro.jpg");
		
		cousTakeService.reqAttd(params, fileVo);
	
	}
}
