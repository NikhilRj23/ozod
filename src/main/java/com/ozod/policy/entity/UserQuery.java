package com.ozod.policy.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "USER_QUERY")
public class UserQuery extends BaseEntity{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "ID")
	private String id;

	@NotBlank(message = "Name is required")
	private String userName;
	
	private String userId;

	private String email;
	
	@NotBlank(message = "Mobile number is required")
	private String phone;
	
	private String subject;
	
	@NotBlank(message = "Message number is required")
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
