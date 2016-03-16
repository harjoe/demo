package demo.json.helloworld;

import net.sf.json.JSONObject;

public class Tester {

	public static void main(String[] args) {
		
		Student student = new Student();
		student.setId(1);
		student.setName("harjo");
		student.setAge(22);
		
		JSONObject jsonObject = JSONObject.fromObject(student);
		System.out.println(jsonObject.toString());
		
		
		String jsonString =  jsonObject.toString();
	 	JSONObject  jb = JSONObject.fromObject(jsonString);
	 	
	 	Teacher teacher = (Teacher) JSONObject.toBean(jb, Teacher.class);
	 	System.out.println(teacher.getName());
	 	
	 	System.out.println(teacher.getRemark());
	 	System.out.println(jb.get("id"));
	 	System.out.println(jb.get("age"));
	}
}
