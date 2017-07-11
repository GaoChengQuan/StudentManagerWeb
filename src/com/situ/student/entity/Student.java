package com.situ.student.entity;

import java.util.Date;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class Student implements HttpSessionBindingListener {
	private int id;
	private String name;
	private String password;
	private int age;
	private String gender;
	private Date birthday;

	public Student() {
		super();
	}

	public Student(String name, String password, int age, String gender,
			Date birthday) {
		super();
		this.name = name;
		this.password = password;
		this.age = age;
		this.gender = gender;
		this.birthday = birthday;
	}
	

	public Student(int id, String name, String password, int age,
			String gender, Date birthday) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.age = age;
		this.gender = gender;
		this.birthday = birthday;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date date) {
		this.birthday = date;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", password="
				+ password + ", age=" + age + ", gender=" + gender
				+ ", birthday=" + birthday + "]";
	}

	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		String name = event.getName();
		Student student = (Student) event.getValue();
		System.out.println("valueBound name:" + name);
		System.err.println("valueBound value: " + student);
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		String name = event.getName();
		Student student = (Student) event.getValue();
		System.out.println("valueUnbound name:" + name);
		System.err.println("valueUnbound value: " + student);
	}
}
