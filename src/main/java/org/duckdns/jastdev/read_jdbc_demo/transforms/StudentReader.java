package org.duckdns.jastdev.read_jdbc_demo.transforms;

import org.apache.beam.sdk.coders.SerializableCoder;
import org.apache.beam.sdk.io.jdbc.JdbcIO;
import org.apache.beam.sdk.io.jdbc.JdbcIO.DataSourceConfiguration;
import org.apache.beam.sdk.io.jdbc.JdbcIO.Read;
import org.duckdns.jastdev.read_jdbc_demo.configurations.DatabaseConfiguration;
import org.duckdns.jastdev.read_jdbc_demo.model.Student;
import org.duckdns.jastdev.read_jdbc_demo.rowmappers.StudentMapper;

public class StudentReader {

	public static Read<Student> read() {
		DataSourceConfiguration config = DatabaseConfiguration.getDatasource();
		return JdbcIO.<Student>read()
			.withDataSourceConfiguration(config)
			.withQuery("select student_id, name, last_name, gender from student")
			.withCoder(SerializableCoder.of(Student.class))
			.withRowMapper(new StudentMapper());
	}

}
