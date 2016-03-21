package demo.redis.list;

import harjo.basic.serialize.ListTranscoder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import redis.clients.jedis.Jedis;

public class TestList {
	public static void main(String[] args) {
		// Jedis jedis = new Jedis("127.0.0.1", 6379);
		Jedis jedis = new Jedis("127.0.0.1", 6379);

		// jedis.flushAll();
		/*
		 * jedis.del("harjoe");
		 * 
		 * jedis.set("harjoe", ""); jedis.append("harjoe", "bridge");
		 * System.out.println(jedis.get("harjoe"));
		 * 
		 * jedis.append("harjoe", "harjoe");
		 * 
		 * System.out.println(jedis.get("harjoe"));
		 */

		// System.out.println(jedis.get("key155"));
		System.out.println(jedis.get("name"));

		jedis.set("age", "2222");

		jedis.set("harjo.sex", "boy");
		
		jedis.set("name", "harjo");

		System.out.println(jedis.get("harjo.sex"));
		/*
		 * long begin; long end; Map<String, String> map = new HashMap<String,
		 * String>();
		 * 
		 * System.out.println("start test..."); begin =
		 * System.currentTimeMillis(); for(Integer i = 0; i < 10000; i++)
		 * jedis.set(i.toString(),
		 * "fdsafdsafdsadsfdsafdsafdsafdsafdsafdsafdsafdsafdsafdsafdsa" );
		 * 
		 * end = System.currentTimeMillis(); System.out.println(end - begin);
		 * System.out.println("end test.");
		 * 
		 * System.out.println("start test..."); begin =
		 * System.currentTimeMillis(); for(int i = 0; i < 10000; i++)
		 * map.put("key" + i, "fdsa");
		 * 
		 * end = System.currentTimeMillis(); System.out.println(end - begin);
		 * System.out.println("end test.");
		 */

		List<Person> list = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			Student student = new Student();
			student.setId(i);
			student.setName("bridge" + i);
			student.setAge(i*10);
			list.add(student);
		}
		ListTranscoder<Person> listTranscoder = new ListTranscoder<>();
		byte[] bs = listTranscoder.serialize(list);
		
		
		jedis.set("student.list".getBytes(), bs);
		
		byte[] bs_student = jedis.get("student.list".getBytes());
		ListTranscoder<Teacher> teacherTranscoder = new ListTranscoder<>();
		List<Teacher> teachers = teacherTranscoder.deserialize(bs_student);
		
		
		for(Teacher teacher: teachers){
			System.out.println(teacher.getId());
			System.out.println(teacher.getName());
			System.out.println(teacher.getAge());
			System.out.println("-----------");
		}
		
		
	}
}
