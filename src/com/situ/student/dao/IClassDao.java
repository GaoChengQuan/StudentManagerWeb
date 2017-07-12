package com.situ.student.dao;

import java.util.List;

import com.situ.student.entity.Clazz;
import com.situ.student.entity.Student;
import com.situ.student.vo.SearchCondition;

public interface IClassDao {

	/**
	 * 添加课程
	 * @param clazz
	 * @return true:添加成功  false：添加失败
	 */
	public abstract boolean add(Clazz clazz);
	
	/**
	 * 删除班级
	 * @param id
	 * @return true:删除成功  false：删除失败
	 */
	public abstract boolean delete(int id);
	
	/**
	 * 修改学生
	 * @param clazz
	 * @return true:修改成功  false：修改失败
	 */
	public abstract boolean update(Clazz clazz);
	
	/**
	 * 查询所有的班级信息
	 * @return 返回所有学生的集合
	 */
	public abstract List<Clazz> findAll();
	
	/**
	 * 根据id查找指定的班级
	 * @param id
	 * @return 返回班级信息
	 */
	public abstract Clazz findById(int id);
	
	
	/**
	 * 查看指定的班级姓名存不存在
	 * @param name
	 * @return true:班级已经存在  false：班级不存在
	 */
	public abstract boolean checkName(String name);

	/**
	 * 根据条件完成搜索
	 * @param searchCondition
	 * @return
	 */
	public abstract List<Clazz> searchByCondition(
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
	public abstract List<Clazz> findPageBeanList(int index, int pageSize);

	/**
	 * 根据条件查询一共有多少个
	 * @param searchCondition
	 * @return
	 */
	public abstract int getTotalCountByCondition(SearchCondition searchCondition);

}
