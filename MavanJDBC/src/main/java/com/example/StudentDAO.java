package com.example;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;

public class StudentDAO {
	
	private JdbcTemplate temp;

	public void setTemp(JdbcTemplate temp) {
		this.temp = temp;
	}
	public int insert(Student sobj) {
		
		String sql="insert into Student values("+sobj.getSid()+",'"+sobj.getSname()+"','"+sobj.getSemail()+"')";
		//insert,update,delete all can be done using this same statement
		return temp.update(sql);
		
		
	}
	
	
	
	
	public Student getDetails(String name) {
		String sql="select * from student where sname=?";
java.util.List<Student> students= temp.query(sql,new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1,name);
				
			}
		}, new StudentMapper() );

		return students.get(0);
		
	}

public List<Student> getallstudents(){
	String sql="select * from student";
	return temp.query(sql, new ResultSetExtractor<List<Student>>() {

		@Override
		public List<Student> extractData(ResultSet rs) throws SQLException, DataAccessException {
		
			List<Student> list=new ArrayList<>();
			while(rs.next()) {
				Student student=new Student();
				student.setSid(rs.getInt(1));
				student.setSname(rs.getString(2));
				student.setSemail(rs.getString(3));
				list.add(student);
			}
			return list;
			
		}
	});
}

	
}
