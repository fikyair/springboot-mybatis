/*
 * 文 件 名:  RedisNamespace.java
 * 版    权:  Copyright  2014. 随行付支付有限公司版权所有
 * 描    述:  <描述>
 * 创 建 人:  wenc
 * 创建时间:  2016年4月16日 上午11:29:44  
 * 
 * 修改内容:  <修改内容>
 * 修改时间:  <修改时间>
 * 修改人:    <修改人>
 */
package com.suixingpay.mybatis.core.redis;

/**
 * <功能详细描述>
 * 
 * @author wenc
 * @version [版本号, 2016年4月16日 上午11:29:44 ]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public enum RedisNamespace {
    MERCH_WRONG_REGIST_NAME("XLM", "WRONG_REGIST_NAME", "错误注册名称"),
    MERCH_RIGHT_REGIST_NAME("XLM", "RIGHT_REGIST_NAME", "正确注册名称"),
    MERCH_COUNT_REGIST_NAME("XLM", "COUNT_REGIST_NAME", "校验注册名称次数"),
    MERCH_TASK_COUNT_WRONG_REGIST_NAME("XLM", "TASK_COUNT_WRONG_REGIST_NAME", "单个工单注册名称错误次数"),
    MERCH_WRONG_COUNT_LEGAL_IDCARD("XLM", "WRONG_COUNT_LEGAL_IDCARD", "校验法人身份证号错误次数"),
    MERCH_WRONG_COUNT_SETTLE_IDCARD("XLM", "WRONG_COUNT_SETTLE_IDCARD", "校验结算身份证号错误次数"),
    FUNCTION_SWITCH("XLM", "FUNCTION_SWITCH", "功能开关")
    ;

	/** 系统用户名 英文简称 */
	private String user;
	/** 集合名称的英文简称 */
	private String table;
	/** 中文描述 */
	private String displayName;

	private RedisNamespace(String user, String table, String displayName) {
		this.user = user;
		this.table = table;
		this.displayName = displayName;
	}

	public String getUser() {
		return user;
	}

	public String getTable() {
		return table;
	}

	public String getDisplayName() {
		return displayName;
	}
	
	/** 
	 * Description: 返回完整的 redis key
	 *
	 * @author ye_yh@suixingpay.com 
	 *
	 * @param  @param namespace
	 * @param  @param key
	 * @param  @return
	 * @return String
	 * @throws 
	 */
	public String getKeyName(String key) {
		StringBuffer sb = new StringBuffer();
		sb.append(user).append(":").append(table).append(":").append(key);
		return sb.toString();
	}

}
