package kr.co.seculink.web.controller.stat.hc;

import kr.co.seculink.web.service.stat.hc.GidxStssService;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Slf4j
@Controller
public class AvalActStssController
{

	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate dao;

	@Autowired
	private GidxStssService gidxStssService;

}
