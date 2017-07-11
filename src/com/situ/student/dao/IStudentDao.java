package com.situ.student.dao;

import java.util.List;

import com.situ.student.entity.Student;
import com.situ.student.vo.SearchCondition;
/**
 * 对Student进行Dao操作的接口
 * @author Gao
 *
 */
public interface IStudentDao {
	/**
	 * 添加学生
	 * @param student
	 * @return true:添加成功  false：添加失败
	 */
	public abstract boolean add(Student student);
	
	/**
	 * 删除学生
	 * @param id
	 * @return true:删除成功  false：删除失败
	 */
	public abstract boolean delete(int id);
	
	/**
	 * 修改学生
	 * @param student
	 * @return true:修改成功  false：修改失败
	 */
	public abstract boolean update(Student student);
	
	/**
	 * 查询所有的学生信息
	 * @return 返回所有学生的集合
	 */
	public abstract List<Student> findAll();
	
	/**
	 * 根据id查找指定的学生
	 * @param id
	 * @return 返回学生信息
	 */
	public abstract Student findById(int id);
	
	/**
	 * 根据name查找学生
	 * @param id
	 * @return 返回学生信息的集合
	 */
	public abstract List<Student> findByName(String name);
	
	/**
	 * 根据年龄段查找学生
	 * @param begin开始的年龄 end 结束的年龄
	 * @return 返回学生信息的集合
	 */
	public abstract List<Student> findByAge(int begin, int end);
	
	/**
	 * 根据gender查找学生
	 * @param gender
	 * @return 返回学生信息的集合
	 */
	public abstract List<Student> findByGender(String gender);
	
	/**
	 * 查看指定的学生姓名存不存在
	 * @param name
	 * @return true:学生已经存在  false：学生不存在
	 */
	public abstract boolean checkName(String name);

	/**
	 * 根据出生时间段查找学生
	 * @param begin开始的出生年龄 end 结束的出生年龄
	 * @return 返回学生信息的集合
	 */
	public abstract List<Student> findByBirthday(String beginTime,
			String endTime);

	/**
	 * 根据条件完成搜索
	 * @param searchCondition
	 * @return
	 */
	public abstract List<Student> searchByCondition(
			SearchCondition searchCondition);

	/**
	 * 获得一共有多少条数据
	 * @return
	 */
	public abstract int getTotalCount();

	/**
	 * 分页查询
	 * @param index
	 * @param pageSize
	 * @return
	 */
	public abstract List<Student> findPageBeanList(int index, int pageSize);

	/**
	 * 根据条件查询一共有多少个
	 * @param searchCondition
	 * @return
	 */
	public abstract int getTotalCountByCondition(SearchCondition searchCondition);

	/**
	 * 根据用户名和密码查询学生对象
	 * @param name
	 * @param password
	 * @return student!=null 返回指定用户名和密码学生, null：没有这个用户名和密码学生，登陆失败
	 */
	public abstract Student findByNameAndPassword(String name, String password);

	
}
