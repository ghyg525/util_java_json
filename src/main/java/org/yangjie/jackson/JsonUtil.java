package org.yangjie.jackson;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * json处理工具类
 * @author YangJie [2017年9月18日 上午11:32:33]
 */
public class JsonUtil {
	
	public static ObjectMapper objectMapper = new ObjectMapper()
			.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false); // 忽略未知属性
	
	/**
	 * 将对象转换成json字符串
	 * @param object
	 * @return
	 * @throws Exception
	 */
	public static String toJson(Object object) throws Exception {
		return objectMapper.writeValueAsString(object);
	}
	
	/**
	 * 将json字符串转换成对象
	 * @param json
	 * @param valueType
	 * @return
	 * @throws Exception
	 */
	public static <T> T toObject(String json, Class<T> valueType) throws Exception {
		return objectMapper.readValue(json, valueType);
	}
	
	/**
	 * json转对象(处理复杂类型对象) 
	 * List<bean> : json, ArrayList.class, List.class, Bean.class
	 * Map<bean1, bean2> : json, HashMap.class, Map.class, Bean1.class, Bean2.class
	 * @param json
	 * @param parametrized 要转换的真实类型
	 * @param parametersFor 要转换类型的类或接口
	 * @param parameterClasses 类型中的泛型类型
	 * @return
	 * @throws Exception
	 */
	public static <T> T toObject(String json, Class<?> parametrized, Class<?> parametersFor, Class<?>... parameterClasses) throws Exception {
		return objectMapper.readValue(json, objectMapper.getTypeFactory().constructParametrizedType(parametrized, parametersFor, parameterClasses));
	}
	
}
