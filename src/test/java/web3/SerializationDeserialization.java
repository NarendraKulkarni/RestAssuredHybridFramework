package web3;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import web.POJO_createUser3;

//POJO --- Serialize JSON --- De-Serialize ---- POJO

public class SerializationDeserialization {

	//@Test 
	void ConvertPojoToJSON() throws JsonProcessingException 
	{
		//Created java object using pojo class
		Student stupojo = new Student();  //pojo class object 
		   
			stupojo.setName("pavan1");
			stupojo.setJob("Teacher");
		   String cousrseArr[] = {"C","C++"};
		   stupojo.setCourses(cousrseArr);
		   
		   //convert java object ---> json object (Serialization)
		   ObjectMapper objMapper = new ObjectMapper(); //Import from Jasckson. data binder
		   
		  String jsonData =  objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(stupojo);
		  System.out.println(jsonData);
		   
	}
	
	//JSON to POJO --- Deserialization
	@Test 
	void ConvertJSONToPOJO() throws JsonProcessingException 
	{
		String jsonData = "{\r\n"
				+ "  \"name\" : \"pavan1\",\r\n"
				+ "  \"job\" : \"Teacher\",\r\n"
				+ "  \"courses\" : [ \"C\", \"C++\" ]\r\n"
				+ "}";
		
		
		ObjectMapper objMappers = new ObjectMapper();
		
		Student stupojo = objMappers.readValue(jsonData, Student.class); //convert json to pojo
		
		   System.out.println("Name "+stupojo.getName());
		   System.out.println("Class "+stupojo.getClass());
		   System.out.println("Course1 "+stupojo.getCourses()[0]);
		   System.out.println("Course2 "+stupojo.getCourses()[1]);
		   System.out.println("Job "+stupojo.getJob());
	}
}
