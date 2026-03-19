package com.ozod.policy.dto;

public class AddressDto extends BaseDto{

	private static final long serialVersionUID = 1L;

	private String tempAddress;

	private String permanentAddress;

	public String getTempAddress() {
		return tempAddress;
	}

	public void setTempAddress(String tempAddress) {
		this.tempAddress = tempAddress;
	}

	public String getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

}
