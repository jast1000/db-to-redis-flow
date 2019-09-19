package org.duckdns.jastdev.read_jdbc_demo.transforms;

import java.util.HashMap;
import java.util.Map;

import org.apache.beam.sdk.transforms.DoFn;
import org.duckdns.jastdev.read_jdbc_demo.configurations.RedisConfiguration;
import org.duckdns.jastdev.read_jdbc_demo.model.Student;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class StudentSaver extends DoFn<Student, Student> {

	private static final long serialVersionUID = 3824322027248280806L;
	
	private JedisPool jedisPool;

	@Setup
	public void init() {
		jedisPool = RedisConfiguration.getJedisPool();
	}
	
	@ProcessElement
	public void processElement(ProcessContext context) {
		Student student = context.element();
		try (Jedis jedis = jedisPool.getResource()) {
			String key = String.format("student:%d", student.getStudentId());
			
			Map<String, String> values = new HashMap<>();
			values.put("studentId", student.getStudentId().toString());
			values.put("name", student.getName());
			values.put("lastName", student.getLastName());
			values.put("gender", student.getGender());
			
			jedis.hmset(key, values);
			
			context.output(student);
		}
	}
	
	
}
