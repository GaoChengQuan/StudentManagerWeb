package com.situ.student.service.impl;

import java.util.List;

import com.situ.student.dao.IStudentDao;
import com.situ.student.dao.impl.StudentDaoMysqlImpl;
import com.situ.student.entity.Student;
import com.situ.student.exception.NameRepeatException;
import com.situ.student.service.IStudentService;
import com.situ.student.vo.PageBean;
import com.situ.student.vo.SearchCondition;

public class StudentServiceImpl implements IStudentService{
	//后期这一块是Spring帮助我们管理
	private IStudentDao studentDao = new StudentDaoMysqlImpl();
	//private IStudentDao studentDao = new StudentDaoOraclempl();

	@Override
	public boolean add(Student student) throws NameRepeatException {
		if (studentDao.checkName(student.getName())) {
			throw new NameRepeatException("姓名重复");
		} else {
			return studentDao.add(student);
		}
	}

	@Override
	public boolean delete(int id) {
		return studentDao.delete(id);
	}

	@Override
	public boolean update(Student student) {
		return studentDao.update(student);
	}

	@Override
	public List<Student> findAll() {
		return studentDao.findAll();
	}

	@Override
	public Student findById(int id) {
		return studentDao.findById(id);
	}

	@Override
	public List<Student> findByName(String name) {
		return studentDao.findByName(name);
	}

	@Override
	public List<Student> findByAge(int begin, int end) {
		return studentDao.findByAge(begin, end);
	}

	@Override
	public List<Student> findByGender(String gender) {
		return studentDao.findByGender(gender);
	}

	@Override
	public List<Student> findByBirthday(String beginTime, String endTime) {
		return studentDao.findByBirthday(beginTime, endTime);
	}

	@Override
	public PageBean<Student> searchByCondition(SearchCondition searchCondition) {
		PageBean<Student> pageBean = new PageBean<Student>();
		// 1、当前页private Integer pageIndex;
		pageBean.setPageIndex(searchCondition.getPageIndex());
		// 2、当前页显示的条数private Integer pageSize;
		pageBean.setPageSize(searchCondition.getPageSize());
		// 3、总条数private Integer totalCount;
		int totalCount = studentDao.getTotalCountByCondition(searchCondition);
		pageBean.setTotalCount(totalCount);
		// 4、总页数private Integer totalPage;
		int totalPage = (int) Math.ceil((double)totalCount / searchCondition.getPageSize());
		pageBean.setTotalPage(totalPage);
		// 5、当前页要显示的数据private List<T> list = new ArrayList<T>();
		List<Student> list = studentDao.searchByCondition(searchCondition);
		pageBean.setList(list);
		
		return pageBean;
	}

	@Override
	public PageBean getPageBean(int pageIndex, int pageSize) {
		PageBean pageBean = new PageBean();
		// 1、当前页private Integer pageIndex;
		pageBean.setPageIndex(pageIndex);
		// 2、当前页显示的条数private Integer pageSize;
		pageBean.setPageSize(pageSize);
		// 3、总条数private Integer totalCount;
		int totalCount = studentDao.getTotalCount();
		pageBean.setTotalCount(totalCount);
		// 4、总页数private Integer totalPage;
		/*
		 * 总条数      当前页显示的条数        总页数   
		 * 10		3		      4
		 * 11		3			  4
		 * 12       3			  4
		 * 13       3			  5
		 */
		int totalPage = (int) Math.ceil((double)totalCount / pageSize);
		pageBean.setTotalPage(totalPage);
		// 5、当前页要显示的数据private List<Student> list = new ArrayList<Student>();
		int index = (pageIndex - 1) * pageSize;
		List<Student> list = studentDao.findPageBeanList(index, pageSize);
		pageBean.setList(list);
		
		return pageBean;
	}

	@Override
	public boolean checkName(String name) {
		return studentDao.checkName(name);
	}

	@Override
	public Student findByNameAndPassword(String name, String password) {
		return studentDao.findByNameAndPassword(name, password);
	}

}
