package jsonorg;

import org.json.JSONObject;
import org.json.XML;


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
