package com.ozod.policy.dto;

import java.io.Serializable;

public class UserQueryDto extends BaseDto implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String id;

	private String userName;
	
	private String userId;

	private String email;
	
	private String phone;
	
	private String subject;
	
	private String message;
	
	private String resolution;
	
	private Integer resolveStatus;
	
	private Integer viewStatus;
	
	private Integer status;
	
	private Integer userType;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getResolution() {
		return resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	public Integer getResolveStatus() {
		return resolveStatus;
	}

	public void setResolveStatus(Integer resolveStatus) {
		this.resolveStatus = resolveStatus;
	}

	public Integer getViewStatus() {
		return viewStatus;
	}

	public void setViewStatus(Integer viewStatus) {
		this.viewStatus = viewStatus;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
}
