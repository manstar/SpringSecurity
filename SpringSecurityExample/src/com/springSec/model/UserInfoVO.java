package com.springSec.model;

import java.util.Date;

public class UserInfoVO {

	private String userId;
	private String studentSn;
	private String password;
	private String name;
	private Integer principle;
	private Integer permit;
	private String authority;
	private String email;
	private String phoneNum;
	private Integer sort;
	private Date recodeDate;
	private String departmentCode;
	private String departmentName;
	private String deleted;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getStudentSn() {
		return studentSn;
	}

	public void setStudentSn(String studentSn) {
		this.studentSn = studentSn;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrinciple() {
		return principle;
	}

	public void setPrinciple(Integer principle) {
		this.principle = principle;
	}

	public Integer getPermit() {
		return permit;
	}

	public void setPermit(Integer permit) {
		this.permit = permit;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Date getRecodeDate() {
		return recodeDate;
	}

	public void setRecodeDate(Date recodeDate) {
		this.recodeDate = recodeDate;
	}

	public String getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDeleted() {
		return deleted;
	}

	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}

}
