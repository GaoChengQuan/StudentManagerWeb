package com.situ.student.listener;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.situ.student.entity.Student;

public class MyHttpSessionListener implements HttpSessionListener{

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		// 1.用户主动调用session.invalidate();
		// 2.30分钟之后session被tomcat主动销毁
		HttpSession httpSession = se.getSession();
		ServletContext servletContext = httpSession.getServletContext();
		List<Student> onlineStudentList = (List<Student>) servletContext
				.getAttribute("onlineStudentList");
		//从session取出当前用户
		Student student = (Student) httpSession.getAttribute("student");
		if (student != null) {
			//把当前用户从在线列表集合中删除
			onlineStudentList.remove(student);
		}
	}

}
