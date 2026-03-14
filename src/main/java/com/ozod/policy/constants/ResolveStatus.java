package com.ozod.policy.constants;

public enum ResolveStatus {

	RESOLVED(1), UN_RESOLVED(0) ,PROGRESS(2);

	private final Integer value;

	ResolveStatus(Integer value) {
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}

}
