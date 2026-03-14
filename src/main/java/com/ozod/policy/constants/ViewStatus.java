package com.ozod.policy.constants;

public enum ViewStatus {

	VIEWED(1), UN_VIEWED(0);

	private final Integer value;

	ViewStatus(Integer value) {
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}

}
