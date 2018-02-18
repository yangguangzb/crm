package com.san.crm.utils;

import java.math.BigInteger;
import java.security.MessageDigest;

public class MyStringUtils {
	/**
	 * MD5加密
	 * @param value
	 * @return
	 */
	public static String getMD5Value(String value){
		try {
			//获得jdk提供消息摘要算法工具类
			MessageDigest messageDigest=MessageDigest.getInstance("MD5");
			//加密结果(10进制)
			byte[] md5ValueByArray=messageDigest.digest(value.getBytes());
			//将10进制，转化为16进制
			BigInteger bigInteger=new BigInteger(1,md5ValueByArray);
			return bigInteger.toString(16);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}
