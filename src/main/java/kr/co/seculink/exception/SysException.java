package kr.co.seculink.exception;

import javax.annotation.Nullable;

public class SysException extends BaseException {

	private static final long serialVersionUID = -2182593837536375954L;

	public SysException(Throwable throwable, String errCd, @Nullable String[] params) {
		super(throwable, errCd, params);
	}
	
	public SysException(String errCd, String[] params) {
		super(errCd, params);
	}
	
	public SysException(String errCd) {
		super(errCd);
	}
}
