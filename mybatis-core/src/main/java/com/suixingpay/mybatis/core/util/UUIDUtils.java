package com.suixingpay.mybatis.core.util;

import java.util.UUID;

public class UUIDUtils {
	
	public static String getUUID() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
}
