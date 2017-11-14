/**
 * All rights Reserved, Designed By Suixingpay.
 *
 * @author: john.lee
 * @date: 2017/3/31 19:53
 * @copyright: ©2017 Suixingpay. All rights reserved. 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
package com.suixingpay.mybatis.core.exception;

import com.suixingpay.mybatis.core.enums.ExceptionEnum;

/**
 * 新增实体数据异常
 *
 * @author: john.lee
 * @date: 2017/3/31 19:53
 * @version: V1.0
 * @review: john.lee/2017/3/31 19:53
 */
public class SaveEntityException extends AbstractException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 构造器
     */
    public SaveEntityException() {
        super(ExceptionEnum.SAVE_EXCEPTION);
    }

    /**
     * 构造器
     * 
     * @param enums
     */
    public SaveEntityException(ExceptionEnum enums) {
        super(enums);
    }
}
