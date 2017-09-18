package org.yangjie.jsonlib;

import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

/**
 * json处理工具类
 * @author YangJie [2017年9月18日 上午11:32:38]
 */
public class JsonUtil {
	
	/**
	 * 将对象转换成json字符串
	 * @param object
	 * @return
	 * @throws Exception
	 */
	public static String toJson(Object object) throws Exception {
		return JSONSerializer.toJSON(object).toString();
	}
	
	/**
	 * 将json字符串转换成对象
	 * @param json
	 * @param valueType
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public static <T> T toObject(String json, Class<T> valueType) throws Exception {
		return (T) JSONObject.toBean(JSONObject.fromObject(json), valueType);
	}
	

}
