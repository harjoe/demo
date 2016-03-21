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
	 	
	 	Engine engine = new Engine();
	 	engine.setName("V6");
	 	
	 	Car car = new Car();
	 	car.setName("CT6");
	 	car.setEngine(engine);
	 	
	 	jb = JSONObject.fromObject(car);
	 	System.out.println(jb.toString());
	 	
	 	JSONObject object = JSONObject.fromObject(jb.toString());
	 	Plane plane  = (Plane) JSONObject.toBean(object, Plane.class);
	 	System.out.println(plane.getName());
	 	plane.setEngine(object.getString("engine"));
	 	System.out.println(plane.getEngine());
	 	
	 	
	}
}
