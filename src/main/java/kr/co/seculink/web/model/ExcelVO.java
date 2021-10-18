package kr.co.seculink.web.model;

import java.util.List;

import lombok.Data;

@Data
public class ExcelVO
{
	private String [] headers;
	private String [] keys;
	private List data;
}
