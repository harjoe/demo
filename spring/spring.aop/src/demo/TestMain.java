package demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import demo.service.StudentService;

public class TestMain
{
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"applicationContext.xml");

		StudentService service = (StudentService) ctx.getBean("studentService");
		//System.out.println(service.getClass());
		service.add(new Student());
		//System.out.println("###");

		ctx.destroy();

	}
}
