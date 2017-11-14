package com.suixingpay.mybatis.core.exception;

import com.suixingpay.mybatis.core.enums.ExceptionEnum;

public class BaseException extends AbstractException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    /**
     * 构造器
     * @param exceptionEnum
     */
    public BaseException(ExceptionEnum exceptionEnum) {
        super(exceptionEnum);
    }
    
    public BaseException(Integer code, String message) {
        super(code, message);
    }
    
    public BaseException(String message) {
        super(ExceptionEnum.BASE_EXCEPTION.getCode(), message);
    }
}
