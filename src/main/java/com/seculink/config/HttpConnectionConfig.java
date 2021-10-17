package com.seculink.config;

import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class HttpConnectionConfig {

	@Value("${http.conn-timeout}")
	private int connTimeout;
	@Value("${http.read-timeout}")
	private int readTimeout;
	@Value("${http.max-conn}")
	private int maxConn;
	@Value("${http.max-conn-per-route}")
	private int maxConnPerRoute;
	
	@Bean("restTemplateToast")
	public RestTemplate restTemplateToast() {
		
		log.debug("Http Connection Timeout : {}", connTimeout);
		log.debug("Http Read Timeout : {}", readTimeout);
		log.debug("Http Max Connection : {}", maxConn);
		log.debug("Http Max Connection per Route : {}", maxConnPerRoute);
		
		HttpComponentsClientHttpRequestFactory httpRequestFactory = new HttpComponentsClientHttpRequestFactory();
		httpRequestFactory.setConnectTimeout(connTimeout);
		httpRequestFactory.setReadTimeout(readTimeout);
		HttpClient httpClient = HttpClientBuilder.create().setMaxConnTotal(maxConn).setMaxConnPerRoute(maxConnPerRoute).build();
		httpRequestFactory.setHttpClient(httpClient);
		RestTemplate template = new RestTemplate(httpRequestFactory);
		template.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));
		
		DefaultUriBuilderFactory defaultUriBuilderFactory = new DefaultUriBuilderFactory();
	    defaultUriBuilderFactory.setEncodingMode(DefaultUriBuilderFactory.EncodingMode.NONE);
	    template.setUriTemplateHandler(defaultUriBuilderFactory);
		
		template.getInterceptors().add(new ClientHttpRequestInterceptor(){
	        @Override
	        public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
	            request.getHeaders().set("Content-Type", "application/json;charset=UTF-8");
	        	request.getHeaders().set("cache-control", "no-cache");
	            
	            log.debug("REQUEST URI {}", request.getURI());
	            log.debug("SET HEADERS {}", request.getHeaders());
	            
	            return execution.execute(request, body);
	        }
		});
		
		log.debug("messageConverters {}", template.getMessageConverters());
		
		return template;
	}
	
	@Bean("restTemplateJuso")
	public RestTemplate restTemplateJuso() {
		
		log.debug("Http Connection Timeout : {}", connTimeout);
		log.debug("Http Read Timeout : {}", readTimeout);
		log.debug("Http Max Connection : {}", maxConn);
		log.debug("Http Max Connection per Route : {}", maxConnPerRoute);
		
		HttpComponentsClientHttpRequestFactory httpRequestFactory = new HttpComponentsClientHttpRequestFactory();
		httpRequestFactory.setConnectTimeout(connTimeout);
		httpRequestFactory.setReadTimeout(readTimeout);
		HttpClient httpClient = HttpClientBuilder.create().setMaxConnTotal(maxConn).setMaxConnPerRoute(maxConnPerRoute).build();
		httpRequestFactory.setHttpClient(httpClient);
		RestTemplate template = new RestTemplate(httpRequestFactory);
		template.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));
		
		DefaultUriBuilderFactory defaultUriBuilderFactory = new DefaultUriBuilderFactory();
	    defaultUriBuilderFactory.setEncodingMode(DefaultUriBuilderFactory.EncodingMode.NONE);
	    template.setUriTemplateHandler(defaultUriBuilderFactory);
		
		template.getInterceptors().add(new ClientHttpRequestInterceptor(){
	        @Override
	        public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
	            //request.getHeaders().set("Content-Type", MediaType.APPLICATION_FORM_URLENCODED.toString());
	        	//request.getHeaders().set("cache-control", "no-cache");
	            
	            log.debug("REQUEST URI {}", request.getURI());
	            log.debug("SET HEADERS {}", request.getHeaders());
	            
	            return execution.execute(request, body);
	        }
		});
		
		log.debug("messageConverters {}", template.getMessageConverters());
		
		return template;
	}

}
