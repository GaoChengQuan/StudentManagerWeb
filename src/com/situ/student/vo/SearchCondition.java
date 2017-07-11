package com.situ.student.vo;

public class SearchCondition {
	// 当前页
	private Integer pageIndex;
	// 当前页一共有多少数据
	private Integer pageSize;
	private String name;
	private String age;
	private String gender;

	public SearchCondition() {
		super();
	}

	public SearchCondition(Integer pageIndex, Integer pageSize, String name,
			String age, String gender) {
		super();
		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	@Override
	public String toString() {
		return "SearchCondition [pageIndex=" + pageIndex + ", pageSize="
				+ pageSize + ", name=" + name + ", age=" + age + ", gender="
				+ gender + "]";
	}
}
