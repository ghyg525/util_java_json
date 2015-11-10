package jackson;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;


public class Demo {
	
	public static void main(String[] args) throws Exception {
		
		Bean bean = new Bean();
		List<Bean> beanList = new ArrayList<Bean>();
		beanList.add(bean);
		beanList.add(bean);
		Map<Object, Bean> beanMap = new HashMap<Object, Bean>();
		beanMap.put("bean1", bean);
		List<Object> objList = new ArrayList<Object>();
		objList.add(bean.getId());
		objList.add(bean.getName());
		objList.add(bean.getDate());
		Map<Object, Object> objMap = new HashMap<Object, Object>();
		objMap.put("id", bean.getId());
		objMap.put("name", bean.getName());
		objMap.put("date", bean.getDate());
		
		
		// bean
		System.err.println("bean:");
		String beanJson = JsonUtil.toJson(bean);
		System.out.println(beanJson);
		Bean beanObject = JsonUtil.toObject(beanJson, Bean.class);
		System.out.println(beanObject);
		
		// bean list
		System.err.println("bean list:");
		String beanListJson = JsonUtil.toJson(beanList);
		System.out.println(beanListJson);
		List<Bean> beanListObject = JsonUtil.toObject(beanListJson, ArrayList.class, List.class, Bean.class);
		System.out.println(beanListObject);
		
		// bean map
		System.err.println("bean map:");
		String beanMapJson = JsonUtil.toJson(beanMap);
		System.out.println(beanMapJson);
		Map<Object, Bean> beanMapObject = JsonUtil.toObject(beanMapJson, new TypeReference<Map<Object, Bean>>(){});
		System.out.println(beanMapObject);
		
		// object list
		System.err.println("object list:");
		String objListJson = JsonUtil.toJson(objList);
		System.out.println(objListJson);
		List<Object> objListObject = JsonUtil.toObject(objListJson, new TypeReference<List<Object>>(){});
		System.out.println(objListObject);
		
		// object map
		System.err.println("object map:");
		String objMapJson = JsonUtil.toJson(objMap);
		System.out.println(objMapJson);
		Map<Object, Object> objMapObject = JsonUtil.toObject(objMapJson, HashMap.class, Map.class, Object.class, Object.class);
		System.out.println(objMapObject);
		
	}
	
	
	static class Bean{
		
		// 序列化时忽略此属性
		@JsonIgnore
		private int id = 1;
		// 修改序列化后key
		@JsonProperty("str")
		private String name = "name";
		// 日期格式化为字符串
		@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
		private Date date = new Date();
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Date getDate() {
			return date;
		}
		public void setDate(Date date) {
			this.date = date;
		}
		@Override
		public String toString() {
			return super.toString() +": id="+ getId() +", name="+ getName() +", date="+ getDate();
		}
		
	}
	
}
