package com.chinauicom.research.commons;

import java.util.Map;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.sf.json.JSONObject;

public class JsonUtils {

	public static <T> String getJson(T obj) {
	      String result = null;  
	      try {  
	    	  ObjectMapper mapper = new ObjectMapper();  
//	    	  mapper.setSerializationInclusion(Include.NON_NULL);
//	    	  mapper.configure(SerializationFeature.INDENT_OUTPUT,true);
	    	  result = mapper.writeValueAsString(obj);

	      } catch (Exception e) {  
	          e.printStackTrace();  
	      }  

	      return result;  
	  } 
	
	 public static <T> T getBean(String json,Class<T> elementClasses) {
	      T bean = null;  
	      try {  
	    	  ObjectMapper mapper = new ObjectMapper();  
	    	  mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

	    	  bean = mapper.readValue(json, elementClasses);

	      } catch (Exception e) {  
	          e.printStackTrace();  
	      }  

	      return bean;  
	  }
	
	/**
	 * ��ȡ���͵�Collection Type
	 * @param jsonStr json�ַ���
	 * @param collectionClass ���͵�Collection
	 * @param elementClasses Ԫ������
	 */
	public static JavaType readJson(String jsonStr, Class<?> collectionClass, Class<?>... elementClasses) throws Exception { 
	       ObjectMapper mapper = new ObjectMapper();

	       JavaType javaType = mapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);

	       return mapper.readValue(jsonStr, javaType);

	}
	
	/**
	 * map to json
	 * @param map
	 * 
	 */
	public static String map2json(Map<String,String> map){
	    JSONObject jsonObject = JSONObject.fromObject(map); 
		return jsonObject.toString();
	}
}
