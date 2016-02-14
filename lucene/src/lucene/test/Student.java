package lucene.test;

import java.util.ArrayList;
import java.util.List;

public class Student
{

	private Integer id;
	private String name;
	private Integer age;
	private String sex;

	public Student(Integer id, String name, Integer age, String sex) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.sex = sex;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public static List<Student> getStudents() {
		List<Student> list = new ArrayList<Student>();
		list.add(new Student(1, "bridge1", 11, "man"));
		list.add(new Student(2, "bridge2", 11, "women"));
		list.add(new Student(3, "bridge3", 11, "man"));
		list.add(new Student(4, "bridge4", 11, "man"));
		list.add(new Student(5, "bridge5", 11, "women"));
		list.add(new Student(6, "bridge6", 11, "man"));
		list.add(new Student(7, "bridge7", 11, "man"));

		return list;
	}

}
