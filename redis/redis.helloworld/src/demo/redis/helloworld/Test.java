package demo.redis.helloworld;

import java.util.HashMap;
import java.util.Map;

import redis.clients.jedis.Jedis;

public class Test
{
	public static void main(String[] args) {
		//Jedis jedis = new Jedis("127.0.0.1", 6379);
		Jedis jedis = new Jedis("192.168.112.133", 6379);

		//jedis.flushAll();
		/*
		jedis.del("harjoe");
		
		jedis.set("harjoe", "");
		jedis.append("harjoe", "bridge");
		System.out.println(jedis.get("harjoe"));
		
		jedis.append("harjoe", "harjoe");
		
		System.out.println(jedis.get("harjoe"));
		*/
		
		
		//System.out.println(jedis.get("key155"));
		System.out.println(jedis.get("hello"));
		
		/*
		long begin;
		long end;
		Map<String, String> map = new HashMap<String, String>(); 
		
		System.out.println("start test...");
		begin = System.currentTimeMillis();
		for(Integer i = 0; i < 10000; i++)
			jedis.set(i.toString(), "fdsafdsafdsadsfdsafdsafdsafdsafdsafdsafdsafdsafdsafdsafdsa" );
		
		end = System.currentTimeMillis();
		System.out.println(end - begin);
		System.out.println("end test.");
		
		System.out.println("start test...");
		begin = System.currentTimeMillis();
		for(int i = 0; i < 10000; i++)
			map.put("key" + i, "fdsa");
			
		end = System.currentTimeMillis();
		System.out.println(end - begin);
		System.out.println("end test.");

		*/
	}
}
