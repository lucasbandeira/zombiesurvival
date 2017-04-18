package com.zombiesurvival.util.type;

public enum TypeItem {
	WATER("Water"), FOOD("Food"), MEDICATION("Medication"), AMMUNITION("Ammunition");
	
	private final String description;

	private TypeItem(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
	
}
