package kr.co.seculink.api.domain.vo;

import java.io.Serializable;

import lombok.Data;

@Data
public class FileVO implements Serializable {

	private static final long serialVersionUID = 7889933583108822950L;

	private int fileSeq;
	
	private String bkitNm;
	
	private String keyNm;
	
	private String physNm;
	
	private String fileUrl;
	
	int thmbFileSeq01;
	int thmbFileSeq02;
	int thmbFileSeq03;
}
