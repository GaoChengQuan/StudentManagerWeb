package com.situ.student.web;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ClassMainSevlet extends BaseServlet {

	private void add(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		System.out.println("add");
	}

	
	private void findAll(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		System.out.println("findAll");
	}
	
	private void toUpdate(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		System.out.println("toUpdate");

	}
	
	private void update(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		System.out.println("update");
	}
}
