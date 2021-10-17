package kr.hubble.web.service.cmon;

import kr.hubble.exception.BizException;
import kr.hubble.web.model.TcFileVO;

public interface FileService 
{
	public TcFileVO search(TcFileVO file) throws BizException;
	
	public void save(TcFileVO file) throws BizException;
	
	public boolean delete(String fileNo) throws BizException;
	
	public boolean delete(TcFileVO file) throws BizException;
	/*
	public Resource load(String fileNm);
	
	public void deleteAll();
	
	public Stream<Path> loadAll();
	*/
}
