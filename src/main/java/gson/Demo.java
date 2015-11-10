package gson;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;


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
		List<Bean> beanListObject = JsonUtil.toObject(beanListJson, new TypeToken<List<Bean>>(){}.getType());
		System.out.println(beanListObject);
		
		// bean map
		System.err.println("bean map:");
		String beanMapJson = JsonUtil.toJson(beanMap);
		System.out.println(beanMapJson);
		Map<Object, Bean> beanMapObject = JsonUtil.toObject(beanMapJson, new TypeToken<Map<Object, Bean>>(){}.getType());
		System.out.println(beanMapObject);
		
		// object list
		System.err.println("object list:");
		String objListJson = JsonUtil.toJson(objList);
		System.out.println(objListJson);
		List<Object> objListObject = JsonUtil.toObject(objListJson, new TypeToken<List<Object>>(){}.getType());
		System.out.println(objListObject);
		
		// object map
		System.err.println("object map:");
		String objMapJson = JsonUtil.toJson(objMap);
		System.out.println(objMapJson);
		Map<Object, Object> objMapObject = JsonUtil.toObject(objMapJson, new TypeToken<Map<Object, Object>>(){}.getType());
		System.out.println(objMapObject);
		
	}
	
	
	static class Bean{
		
		// 标志参与序列化(需要设置excludeFieldsWithoutExposeAnnotation属性)
		@Expose
		private int id = 1;
		// 修改序列化后key
		@SerializedName("str")
		private String name = "name";
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
