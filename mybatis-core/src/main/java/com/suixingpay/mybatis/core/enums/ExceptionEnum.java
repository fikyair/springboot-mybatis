/**
 * All rights Reserved, Designed By Suixingpay.
 *
 * @author: li_yang@suixingpay.com
 * @date: 2017/3/31 19:46
 * @copyright: ©2017 Suixingpay. All rights reserved. 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
package com.suixingpay.mybatis.core.enums;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 异常信息信息枚举
 *
 * @author: li_yang@suixingpay.com
 * @date: 2017/3/31 19:46
 * @version: V1.0
 * @review: li_yang@suixingpay.com/2017/3/31 19:46
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT) // 转json
public enum ExceptionEnum {

    /**
     * 基础异常
     */
    SYSTEM_EXCEPTION(500, "系统异常"),
    
    /**
     * 业务异常
     */
    SERVICE_EXCEPTION(1001, "业务异常"),
    
    /**
     * 业务异常
     */
    BASE_EXCEPTION(1002, "业务异常"),

    /**
     * 验证异常
     */
    VALIDATE_EXCEPTION(1003, "验证异常"),

    /**
     * 新增数据异常
     */
    SAVE_EXCEPTION(1004, "新增数据异常"),

    /**
     * 更新数据异常
     */
    UPDATE_EXCEPTION(1005, "更新数据异常"),

    /**
     * 删除数据异常
     */
    DELETE_EXCEPTION(1006, "删除数据异常"),

    /**
     * 查询数据异常
     */
    FIND_EXCEPTION(1007, "查询数据异常"),

    ;
    
    /**
     * 构造方法
     * 
     * @param code
     * @param message
     */
    ExceptionEnum(Integer code, String message) {
        this.setCode(code);
        this.setMessage(message);
    }

    /**
     * 通过code获取枚举
     *
     * @param code
     * @return
     */
    public static ExceptionEnum valueOfEnum(int code) {
        ExceptionEnum[] types = values();
        for (ExceptionEnum type : types) {
            if (type.getCode() == code) {
                return type;
            }
        }
        return null;
    }

    /**
     * code
     */
    private Integer code;

    /**
     * message
     */
    private String message;

    /**
     * 获取code
     * 
     * @return
     */
    public Integer getCode() {
        return code;
    }

    /**
     * 设置code
     * 
     * @param code
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * 获取message
     * 
     * @return
     */
    public String getMessage() {
        return message;
    }

    /**
     * 设置message
     * 
     * @return
     */
    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
