package com.ozod.policy.constants;

public enum Status {

	ACTIVE(1), INACTIVE(0), BLOCKED(2);

	private final Integer value;

	Status(Integer value) {
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}

}
