package com.zombiesurvival.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.zombiesurvival.util.type.TypeItem;

@Entity
@Table(name = "item")
public class Item {
	@Id
    private TypeItem id;
	private int points;
	
	public Item() {}

	public TypeItem getId() {
		return id;
	}

	public void setId(TypeItem id) {
		this.id = id;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}
	
}