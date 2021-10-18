package kr.hubble.web.controller.cmon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.seculink.exception.BizException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HttpController
{
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate dao;
	
	@RequestMapping("/getNotiObjList")
	public void getNotiObjList(@RequestBody(required=false) Map<String, String> params) throws BizException
	{
		String reqUrl = "127.0.0.1:18080/getNotiObjList";
		URL url;
		
		try {
			
			url = new URL(reqUrl);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("POST");
			con.setDoOutput(true);
			con.setRequestProperty("Content-Type", "application/json");
			con.setRequestProperty("Accept", "application/json");
			
			String param = "{'sendCmplReqYn' : 'Y'}";
			
			OutputStreamWriter osw = new OutputStreamWriter(con.getOutputStream());
			osw.write(param);
			osw.flush();
			
			
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			
			String input;
			while ( (input = br.readLine()) != null ) {
				System.out.println(input);
			}
			
			osw.close();
			br.close();
			con.disconnect();
			con = null;
			
		} catch ( MalformedURLException e) {
			e.printStackTrace();
		} catch ( IOException e ) {
			e.printStackTrace();
		}
		
		
	}
}
