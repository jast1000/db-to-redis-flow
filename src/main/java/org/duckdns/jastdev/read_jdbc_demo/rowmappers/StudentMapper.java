package org.duckdns.jastdev.read_jdbc_demo.rowmappers;

import java.sql.ResultSet;

import org.apache.beam.sdk.io.jdbc.JdbcIO.RowMapper;
import org.duckdns.jastdev.read_jdbc_demo.model.Student;

public class StudentMapper implements RowMapper<Student> {

	private static final long serialVersionUID = 6909210636218283756L;

	public Student mapRow(ResultSet resultSet) throws Exception {
		Student student = new Student();
		student.setStudentId(resultSet.getInt(1));
		student.setName(resultSet.getString(2));
		student.setLastName(resultSet.getString(3));
		student.setGender(resultSet.getString(4));
		
		System.out.println(student);
		
		return student;
	}

}
