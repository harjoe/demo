package demo.redis.list;

import harjo.basic.serialize.ListTranscoder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import redis.clients.jedis.Jedis;

public class Test {
	public static void main(String[] args) {
		Jedis jedis = new Jedis("127.0.0.1", 6379);

		
		jedis.lpush("harjo.name", "bridge", "harjo", "harjoe");
		
		
		System.out.println("lpush");
		String value = jedis.getSet("harjo.name", "bridge");
		System.out.println(value);
				
		
	}
}
