package com.situ.student.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.situ.student.dao.IStudentDao;
import com.situ.student.dao.impl.StudentDaoMysqlImpl;
import com.situ.student.entity.Student;
import com.situ.student.vo.SearchCondition;

public class StudentDaoMysqlImplTest {
	
	@Test
	public void testAdd() {
		Date date = new Date();
		Student student = new Student("xxxqqqq", "123", 99, "男", date);
		IStudentDao studentDao = new StudentDaoMysqlImpl();
		boolean result = studentDao.add(student);
		if (result) {
			System.out.println("添加成功");
		} else {
			System.out.println("添加失败");
		}
	}
	
	@Test
	public void testDelete() {
		Student student = new Student(7, "zhangsan", "123", 99, "男", new Date());
		IStudentDao studentDao = new StudentDaoMysqlImpl();
		boolean result = studentDao.delete(7);
		if (result) {
			System.out.println("删除成功");
		} else {
			System.out.println("删除失败");
		}
	}
	
	@Test
	public void testUpdate() {
		Student student = new Student(8, "zhangsan", "123", 99, "男", new Date());
		IStudentDao studentDao = new StudentDaoMysqlImpl();
		boolean result = studentDao.update(student);
		if (result) {
			System.out.println("更新成功");
		} else {
			System.out.println("更新失败");
		}
	}
	
	@Test
	public void testfindAll() {
		IStudentDao studentDao = new StudentDaoMysqlImpl();
		List<Student> list = studentDao.findAll();
		for (Student student : list) {
			System.out.println(student);
		}
	}
	
	@Test
	public void testFindById() {
		IStudentDao studentDao = new StudentDaoMysqlImpl();
		Student student= studentDao.findById(8);
		System.out.println(student);
	}
	
	@Test
	public void testFindByName() {
		IStudentDao studentDao = new StudentDaoMysqlImpl();
		List<Student> list = studentDao.findByName("符号");
		for (Student student : list) {
			System.out.println(student);
		}
	}
	
	@Test
	public void testFindByAge() {
		IStudentDao studentDao = new StudentDaoMysqlImpl();
		List<Student> list = studentDao.findByAge(20, 50);
		for (Student student : list) {
			System.out.println(student);
		}
	}
	
	@Test
	public void testFindByGender() {
		IStudentDao studentDao = new StudentDaoMysqlImpl();
		List<Student> list = studentDao.findByGender("男");
		for (Student student : list) {
			System.out.println(student);
		}
	}
	
	
	@Test
	public void testSearchByCondition() {
		SearchCondition searchCondition = new SearchCondition();
		searchCondition.setName("8");
		searchCondition.setPageIndex(2);
		searchCondition.setPageSize(3);
		IStudentDao studentDao = new StudentDaoMysqlImpl();
		List<Student> list = studentDao.searchByCondition(searchCondition);
		for (Student student : list) {
			System.out.println(student);
		}
	}
	
	@Test
	public void testGetTotalCountByCondition() {
		SearchCondition searchCondition = new SearchCondition();
		searchCondition.setName("8");
		searchCondition.setAge("8");
		searchCondition.setPageIndex(2);
		searchCondition.setPageSize(3);
		IStudentDao studentDao = new StudentDaoMysqlImpl();
		int count = studentDao.getTotalCountByCondition(searchCondition);
		System.out.println(count);
	}
}
