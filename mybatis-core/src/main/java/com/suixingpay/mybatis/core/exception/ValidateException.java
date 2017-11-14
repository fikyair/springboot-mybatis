/**
 * All rights Reserved, Designed By Suixingpay.
 *
 * @author: john.lee
 * @date: 2017/4/6 上午11:46
 * @Copyright ©2017 Suixingpay. All rights reserved.
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
package com.suixingpay.mybatis.core.exception;

import com.suixingpay.mybatis.core.enums.ExceptionEnum;

/**
 * 验证异常
 *
 * @author: john.lee
 * @date: 2017/4/6 上午11:46ß
 * @version: V1.0
 * @review: john.lee/2017/4/6 上午11:46
 */
public class ValidateException extends AbstractException {

    /**   
     * @Fields serialVersionUID
     */ 
    private static final long serialVersionUID = -5212568977199885179L;

    public ValidateException() {
        super(ExceptionEnum.VALIDATE_EXCEPTION);
    }

    public ValidateException(ExceptionEnum exceptionEnum) {
        super(exceptionEnum);
    }

    public ValidateException(Integer code, String message) {
        super(code, message);
    }
    
    public ValidateException(String message) {
        super(ExceptionEnum.VALIDATE_EXCEPTION.getCode(), message);
    }
}
