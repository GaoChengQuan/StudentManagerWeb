package com.situ.student.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletContext;

import com.situ.student.entity.Student;

public class JdbcUtil {
//	private static final String url = "jdbc:mysql://localhost:3306/java1705";
//	private static final String userName = "root";
//	private static final String password = "123";
//	private static final String driverClass = "com.mysql.jdbc.Driver";
	
	private static String url;
	private static String userName;
	private static String password;
	private static String driverClass;
	
	static {
		/*Properties properties = new Properties();
		//String path = ServletContext.class.getClassLoader().getResource("db.properties").getPath();
		FileInputStream fileInputStream = null;
		try {
			//fileInputStream = new FileInputStream("./src/db.properties");
			fileInputStream = new FileInputStream(path);
			properties.load(fileInputStream);
			url = properties.getProperty("url");
			userName = properties.getProperty("userName");
			password = properties.getProperty("password");
			driverClass = properties.getProperty("driverClass");
			System.out.println(url);
			System.out.println(userName);
			System.out.println(password);
			System.out.println(driverClass);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		
		
		
		url = "jdbc:mysql://localhost:3306/student_manager";
		userName = "root";
		password = "123";
		driverClass = "com.mysql.jdbc.Driver";
		
		// 1、加载驱动 Class.forName("");
		try {
			Class.forName(driverClass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	// 2、获取连接对象Connection
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, userName, password);
	}

	// 6、关闭
	public static void close(Connection connection, Statement statement) {
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	// 6、关闭
	public static void close(Connection connection, Statement statement, ResultSet resultSet) {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
