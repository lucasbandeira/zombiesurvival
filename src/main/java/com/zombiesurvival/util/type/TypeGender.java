package com.zombiesurvival.util.type;

public enum TypeGender {
	FEMALE("Female"), MALE("Male");
	
	private final String description;

	private TypeGender(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
