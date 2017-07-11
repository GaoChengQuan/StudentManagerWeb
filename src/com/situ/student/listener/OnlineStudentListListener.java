package com.situ.student.listener;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.situ.student.entity.Student;

/**
 * 初始化在线列表集合监听器
 * @author Gao
 *
 */
public class OnlineStudentListListener implements ServletContextListener{

	//ServletContext创建的时候调用
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		//创建在线学生列表集合
		//每当用户登录时候，就往集合中添加。
		List<Student> onlineStudentList = new ArrayList<Student>();
		//放到ServletContext域对象中
		ServletContext servletContext = sce.getServletContext();
		servletContext.setAttribute("onlineStudentList", onlineStudentList);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}

}
