package jsonorg;

import org.json.JSONObject;


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
	

}
