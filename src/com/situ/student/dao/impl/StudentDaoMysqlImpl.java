package com.situ.student.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.situ.student.dao.IStudentDao;
import com.situ.student.entity.Student;
import com.situ.student.util.JdbcUtil;
import com.situ.student.vo.SearchCondition;

public class StudentDaoMysqlImpl implements IStudentDao{

	@Override
	public boolean add(Student student) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = JdbcUtil.getConnection();
			String sql = "insert into student(name,password,age,gender,birthday) values(?,?,?,?,?);";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, student.getName());
			preparedStatement.setString(2, student.getPassword());
			preparedStatement.setInt(3, student.getAge());
			preparedStatement.setString(4, student.getGender());
			//date milliseconds since January 1, 1970,
			preparedStatement.setDate(5, new java.sql.Date(student.getBirthday().getTime()));
			int result = preparedStatement.executeUpdate();
			if (result > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(connection, preparedStatement);
		}
		return false;
	}

	@Override
	public boolean delete(int id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = JdbcUtil.getConnection();
			String sql = "delete from student where id=?;";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			int result = preparedStatement.executeUpdate();
			if (result > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(connection, preparedStatement);
		}
		return false;
	}

	@Override
	public boolean update(Student student) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = JdbcUtil.getConnection();
			String sql = "update student set name=?,password=?,age=?,gender=? where id=?;";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, student.getName());
			preparedStatement.setString(2, student.getPassword());
			preparedStatement.setInt(3, student.getAge());
			preparedStatement.setString(4, student.getGender());
			preparedStatement.setInt(5, student.getId());
			int result = preparedStatement.executeUpdate();
			if (result > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(connection, preparedStatement);
		}
		return false;
	}

	@Override
	public List<Student> findAll() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Student> list = new ArrayList<Student>();
		try {
			connection = JdbcUtil.getConnection();
			String sql = "select * from student;";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String password = resultSet.getString("password");
				int age = resultSet.getInt("age");
				String gender = resultSet.getString("gender");
				Date birthday = resultSet.getDate("birthday");
				Student student = new Student(id, password, name, age, gender, birthday);
				list.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(connection, preparedStatement);
		}
		return list;
	}

	@Override
	public Student findById(int id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Student student = null;
		try {
			connection = JdbcUtil.getConnection();
			String sql = "select * from student where id=?;";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int stuId = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String password = resultSet.getString("password");
				int age = resultSet.getInt("age");
				String gender = resultSet.getString("gender");
				Date birthday = resultSet.getDate("birthday");
				student = new Student(id, name, password, age, gender, birthday);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(connection, preparedStatement);
		}
		return student;
	}

	@Override
	public boolean checkName(String name) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int count = 0;
		try {
			connection = JdbcUtil.getConnection();
			String sql = "SELECT COUNT(*) FROM student where name = ? ;";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				count = resultSet.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally {
			JdbcUtil.close(connection, preparedStatement, resultSet);
		}
		
		return count > 0 ? true : false;
	
	}

	@Override
	public List<Student> findByName(String name) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Student> list = new ArrayList<Student>();
		try {
			connection = JdbcUtil.getConnection();
			String sql = "select * from student where name like ?;";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, "%" + name + "%");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String stuName = resultSet.getString("name");
				String password = resultSet.getString("password");
				int age = resultSet.getInt("age");
				String gender = resultSet.getString("gender");
				Date birthday = resultSet.getDate("birthday");
				Student student = new Student(id, stuName, password, age, gender, birthday);
				list.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(connection, preparedStatement, resultSet);
		}
		return list;
	}

	@Override
	public List<Student> findByAge(int begin, int end) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Student> list = new ArrayList<Student>();
		try {
			connection = JdbcUtil.getConnection();
			String sql = "select * from student where age>=? and age<=?;";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, begin);
			preparedStatement.setInt(2, end);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String stuName = resultSet.getString("name");
				String password = resultSet.getString("password");
				int age = resultSet.getInt("age");
				String gender = resultSet.getString("gender");
				Date birthday = resultSet.getDate("birthday");
				Student student = new Student(id, stuName, password, age, gender, birthday);
				list.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(connection, preparedStatement, resultSet);
		}
		return list;
	}

	@Override
	public List<Student> findByGender(String gender) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Student> list = new ArrayList<Student>();
		try {
			connection = JdbcUtil.getConnection();
			String sql = "select * from student where gender=?;";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, gender);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String password = resultSet.getString("password");
				int age = resultSet.getInt("age");
				String stuGender = resultSet.getString("gender");
				Date birthday = resultSet.getDate("birthday");
				Student student = new Student(id, name, password, age, gender, birthday);
				list.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally {
			JdbcUtil.close(connection, preparedStatement, resultSet);
		}
		return list;
	}

	@Override
	public List<Student> findByBirthday(String beginTime, String endTime) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Student> list = new ArrayList<Student>();
		try {
			connection = JdbcUtil.getConnection();
			String sql = "select * from student where birthday>=? and birthday<=?;";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setObject(1, beginTime);
			preparedStatement.setObject(2, endTime);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String password = resultSet.getString("password");
				int age = resultSet.getInt("age");
				String gender = resultSet.getString("gender");
				Date birthday = resultSet.getDate("birthday");
				Student student = new Student(name, password, age, gender, birthday);
				list.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally {
			JdbcUtil.close(connection, preparedStatement, resultSet);
		}
		return list;
	}

	@Override
	public List<Student> searchByCondition(SearchCondition searchCondition) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Student> list = new ArrayList<Student>();
		try {
			connection = JdbcUtil.getConnection();
			//String sql = "select * from student where name like ? and age=? and gender=? limit ?,?;";
			String sql = "select * from student where 1=1 ";
			List listCondition = new ArrayList();
			if (searchCondition.getName() != null
					&& !searchCondition.getName().equals("")) {
				sql += " and name like ? ";
				listCondition.add("%" + searchCondition.getName() + "%");
			}
			if (searchCondition.getAge() != null
					&& !searchCondition.getAge().equals("")) {
				sql += " and age = ? ";
				listCondition.add(searchCondition.getAge());
			}
			if (searchCondition.getGender() != null
					&& !searchCondition.getGender().equals("")) {
				sql += " and gender = ? ";
				listCondition.add(searchCondition.getGender());
			}
		    //limit ?,?
			sql += "limit ?,?";
			int index = (searchCondition.getPageIndex() - 1) * searchCondition.getPageSize();
			listCondition.add(index);
			listCondition.add(searchCondition.getPageSize());
			
			preparedStatement = connection.prepareStatement(sql);
			
			for (int i = 0; i < listCondition.size(); i++) {
				preparedStatement.setObject(i + 1, listCondition.get(i));
			}
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String password = resultSet.getString("password");
				int age = resultSet.getInt("age");
				String gender = resultSet.getString("gender");
				Date birthday = resultSet.getDate("birthday");
				Student student = new Student(id, name, password, age, gender, birthday);
				list.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(connection, preparedStatement, resultSet);
		}
		return list;
	}

	@Override
	public int getTotalCount() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int count = 0;
		try {
			connection = JdbcUtil.getConnection();
			String sql = "SELECT COUNT(*) FROM student;";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				count = resultSet.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally {
			JdbcUtil.close(connection, preparedStatement, resultSet);
		}
		
		return count;
	}

	@Override
	public List<Student> findPageBeanList(int index, int pageSize) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Student> list = new ArrayList<Student>();
		try {
			connection = JdbcUtil.getConnection();
			String sql = "select * from student limit ?,?;";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setObject(1, index);
			preparedStatement.setObject(2, pageSize);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String password = resultSet.getString("password");
				int age = resultSet.getInt("age");
				String gender = resultSet.getString("gender");
				Date birthday = resultSet.getDate("birthday");
				Student student = new Student(id, name, password, age, gender, birthday);
				list.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally {
			JdbcUtil.close(connection, preparedStatement, resultSet);
		}
		return list;
	}

	@Override
	public int getTotalCountByCondition(SearchCondition searchCondition) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int count = 0;
		try {
			connection = JdbcUtil.getConnection();
			String sql = "select count(*) from student where 1=1 ";
			List listCondition = new ArrayList();
			if (searchCondition.getName() != null
					&& !searchCondition.getName().equals("")) {
				sql += " and name like ? ";
				listCondition.add("%" + searchCondition.getName() + "%");
			}
			if (searchCondition.getAge() != null
					&& !searchCondition.getAge().equals("")) {
				sql += " and age = ? ";
				listCondition.add(searchCondition.getAge());
			}
			if (searchCondition.getGender() != null
					&& !searchCondition.getGender().equals("")) {
				sql += " and gender = ? ";
				listCondition.add(searchCondition.getGender());
			}			
			preparedStatement = connection.prepareStatement(sql);
			for (int i = 0; i < listCondition.size(); i++) {
				preparedStatement.setObject(i + 1, listCondition.get(i));
			}
			System.out.println(preparedStatement);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				count = resultSet.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally {
			JdbcUtil.close(connection, preparedStatement, resultSet);
		}
		
		return count;
	}

	@Override
	public Student findByNameAndPassword(String name, String password) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Student student = null;
		try {
			connection = JdbcUtil.getConnection();
			String sql = "select * from student where name=? and password=?;";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, password);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String stuName = resultSet.getString("name");
				String stuPassword = resultSet.getString("password");
				int age = resultSet.getInt("age");
				String gender = resultSet.getString("gender");
				Date birthday = resultSet.getDate("birthday");
				student = new Student(id, stuName, stuPassword, age, gender, birthday);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(connection, preparedStatement);
		}
		return student;
	
	}
}
