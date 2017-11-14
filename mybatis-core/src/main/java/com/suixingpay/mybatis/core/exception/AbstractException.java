/**
 * All rights Reserved, Designed By Suixingpay.
 *
 * @author: john.lee
 * @date: 2017/3/31 19:40
 * @copyright: ©2017 Suixingpay. All rights reserved. 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
package com.suixingpay.mybatis.core.exception;


import com.suixingpay.mybatis.core.enums.ExceptionEnum;

/**
 * 异常基类
 *
 * @author: john.lee
 * @date: 2017/3/31 19:40
 * @version: V1.0
 * @review: john.lee/2017/3/31 19:40
 */
public class AbstractException extends RuntimeException  {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 异常码
     */
    private Integer code;

    /**
     * 异常信息
     */
    private String message;

    /**
     * 构造器
     */
    public AbstractException() {
        super();
    }

    /**
     * 构造器
     */
    public AbstractException(ExceptionEnum exceptionEnum) {
        super(exceptionEnum.getMessage());
        this.code = exceptionEnum.getCode();
        this.message = exceptionEnum.getMessage();
    }

    /**
     * 构造器
     * 
     * @param message
     */
    public AbstractException(String message) {
        super(message);
        this.message = message;
    }

    /**
     * 构造器
     * 
     * @param code
     * @param message
     */
    public AbstractException(Integer code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    /**
     * 获取code
     * 
     * @return
     */
    public Integer getCode() {
        return code;
    }

    /**
     * 获取message
     * 
     * @return
     */
    public String getMessage() {
        return message;
    }
}
