package gson;

import java.io.IOException;
import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;

public class JsonUtil {
	
	private static final Gson gson = new Gson();
	
	/*// 可使用GsonBuilder设置初始化参数后创建Gson对象;
	private static final Gson gson = new GsonBuilder()
		.excludeFieldsWithoutExposeAnnotation() //不导出实体中没有用@Expose注解的属性 
		.setPrettyPrinting()	 // 设置方便阅读样式
		.setDateFormat("yyyy-MM-dd HH:mm:ss") // 设置日期类型序列化格式
		.create(); // 构建对象
	*/
	
	
	/**
	 * 将对象转换成json字符串
	 * @param object
	 * @return
	 * @throws Exception
	 */
	public static String toJson(Object object) throws Exception {
		return gson.toJson(object);
	}
	
	/**
	 * 将json字符串转换成对象
	 * 
	 * @param json
	 * @param valueType
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public static <T> T toObject(String json, Class<T> valueType) throws Exception {
		return gson.fromJson(json, valueType);
	}
	
	/**
	 * 将json字符串转换成复杂对象
	 * @param json
	 * @param typeOfT 此属性可以通过new TypeToken<T>(){}.getType()获得
	 * @return
	 * @throws Exception
	 */
	public static <T> T toObject(String json, Type typeOfT) throws Exception {
		return gson.fromJson(json, typeOfT);
	}	

}
