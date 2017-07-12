package com.situ.student.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.situ.student.dao.IClassDao;
import com.situ.student.entity.Clazz;
import com.situ.student.entity.Student;
import com.situ.student.util.JdbcUtil;
import com.situ.student.vo.SearchCondition;

public class ClazzDaoMysqlImpl implements IClassDao{

	@Override
	public boolean add(Clazz clazz) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = JdbcUtil.getConnection();
			String sql = "insert into clazz(name) values(?);";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, clazz.getName());
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
			String sql = "delete from clazz where id=?;";
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
	public boolean update(Clazz clazz) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = JdbcUtil.getConnection();
			String sql = "update clazz set name=? where id=?;";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, clazz.getName());
			preparedStatement.setInt(2, clazz.getId());
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
	public List<Clazz> findAll() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Clazz> list = new ArrayList<Clazz>();
		try {
			connection = JdbcUtil.getConnection();
			String sql = "select * from clazz;";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				Clazz clazz = new Clazz(id, name);
				list.add(clazz);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(connection, preparedStatement);
		}
		return list;
	}

	@Override
	public Clazz findById(int id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Clazz clazz = null;
		try {
			connection = JdbcUtil.getConnection();
			String sql = "select * from clazz where id=?;";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int stuId = resultSet.getInt("id");
				String name = resultSet.getString("name");
				clazz = new Clazz(id, name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(connection, preparedStatement);
		}
		return clazz;
	}

	@Override
	public boolean checkName(String name) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int count = 0;
		try {
			connection = JdbcUtil.getConnection();
			String sql = "SELECT COUNT(*) FROM clazz where name = ? ;";
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
	public List<Clazz> searchByCondition(SearchCondition searchCondition) {
		return null;
	}

	@Override
	public int getTotalCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Clazz> findPageBeanList(int index, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTotalCountByCondition(SearchCondition searchCondition) {
		// TODO Auto-generated method stub
		return 0;
	}}
