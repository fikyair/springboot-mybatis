/**
 * All rights Reserved, Designed By Suixingpay.
 *
 * @author: john.lee
 * @date: 2017/3/31  20:16
 * @copyright: ©2017 Suixingpay. All rights reserved.
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
package com.suixingpay.mybatis.core.exception;

import com.suixingpay.mybatis.core.enums.ExceptionEnum;

/**
 * 查询实体数据异常
 *
 * @author: john.lee
 * @date: 2017/3/31 20:16
 * @version: V1.0
 * @review: john.lee/2017/3/31 20:16
 */
public class FindEntityException extends AbstractException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 构造器
     */
    public FindEntityException() {
        super(ExceptionEnum.FIND_EXCEPTION);
    }

    /**
     * 构造器
     * @param exceptionEnum
     */
    public FindEntityException(ExceptionEnum exceptionEnum) {
        super(exceptionEnum);
    }

}
