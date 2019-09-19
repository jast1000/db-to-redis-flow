package org.duckdns.jastdev.read_jdbc_demo.configurations;

import org.duckdns.jastdev.read_jdbc_demo.options.PipelineOptionParams;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisConfiguration {
	
	private static JedisPool jedisPool;
	
	public static void initialize(PipelineOptionParams options) {
		JedisPoolConfig config = new JedisPoolConfig();
		jedisPool = new JedisPool(config, options.getRedisHost(), options.getRedisPort());
	}
	
	public static JedisPool getJedisPool() {
		return jedisPool;
	}

}
