package org.yangjie.jackson;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class XmlUtil {

	private static final XmlMapper xmlMapper = new XmlMapper();
	
	
	/**
	 * 将对象转换成xml字符串
	 * @param object
	 * @return
	 * @throws Exception
	 */
	public static String toXml(Object object) throws Exception {
		return xmlMapper.writeValueAsString(object);
	}
	
	/**
	 * xml字符串转换成对象
	 * @param xml
	 * @param valueType
	 * @return
	 * @throws Exception
	 */
	public static <T> T toObject(String xml, Class<T> valueType) throws Exception {
		return xmlMapper.readValue(xml, valueType);
	}
	
	/**
	 * xml转对象(容器对象类型) 
	 * List<Bean> : (xml, List.class, Bean.class)
	 * Map<Bean1, Bean2> : (xml, Map.class, Bean1.class, Bean2.class)
	 * @param xml
	 * @param parametrized 容器类型
	 * @param parameterClasses 实体类型
	 * @return
	 * @throws Exception
	 */
	public static <T> T toObject(String xml, Class<?> parametrized, Class<?>... parameterClasses) throws Exception {
		return xmlMapper.readValue(xml, xmlMapper.getTypeFactory().constructParametricType(parametrized, parameterClasses));
	}

}
