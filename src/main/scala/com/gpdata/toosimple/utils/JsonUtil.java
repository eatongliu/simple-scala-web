package com.gpdata.toosimple.utils;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by acer_liuyutong on 2017/6/29.
 */
public class JsonUtil {
	public static String toJsonString(Object object){
		return JSONObject.toJSONString(object);
	}

	public static <T> T  parseObject(String jsonString, Class<T> clazz){
		return JSONObject.parseObject(jsonString, clazz);
	}
}
