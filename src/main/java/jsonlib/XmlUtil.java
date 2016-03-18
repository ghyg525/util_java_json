package jsonlib;

import net.sf.json.JSONSerializer;
import net.sf.json.xml.XMLSerializer;

public class XmlUtil {
	
	private static final XMLSerializer xmlSerializer = new XMLSerializer();
	
	/**
	 * 将对象转换成xml字符串
	 * @param object
	 * @return
	 * @throws Exception
	 */
	public static String toXml(Object object) throws Exception {
		return xmlSerializer.write(JSONSerializer.toJSON(object));
	}
	
	/**
	 * 将xml字符串转换成对象
	 * @param xml
	 * @param valueType
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public static <T> T toObject(String xml, Class<T> valueType) throws Exception {
		return (T) JSONSerializer.toJava(xmlSerializer.read(xml));
	}
	

}
