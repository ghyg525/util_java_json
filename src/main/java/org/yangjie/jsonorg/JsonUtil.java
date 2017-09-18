package org.yangjie.jsonorg;

import org.json.JSONObject;
import org.json.XML;

/**
 * json处理工具类
 * @author YangJie [2017年9月18日 上午11:32:43]
 */
public class JsonUtil {
	
	/**
	 * 将对象转换成json字符串
	 * @param object
	 * @return
	 * @throws Exception
	 */
	public static String toJson(Object object) throws Exception {
		return new JSONObject(object).toString();
	}
	
	/**
	 * 将xml转换成json字符串
	 * @param object
	 * @return
	 * @throws Exception
	 */
	public static String toJson(String xml) throws Exception {
		return XML.toJSONObject(xml).toString();
	}

}
