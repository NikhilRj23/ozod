package com.ozod.policy.constants;

public enum UserType {

	INTERNAL(1), EXTERNAL(0);

	private final Integer value;

	UserType(Integer value) {
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}

}
