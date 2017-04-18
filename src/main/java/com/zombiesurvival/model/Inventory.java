package com.zombiesurvival.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "inventory")
@SequenceGenerator(name="SEQUENCE", sequenceName="inventory_id_seq")
public class Inventory {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator = "SEQUENCE")
	private int id;
	
	@Column(nullable = false)
	private int amount;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_item",nullable = false)
	private Item item;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_survivor",nullable = false)
	private Survivor survivor;

	public Inventory() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Survivor getSurvivor() {
		return survivor;
	}

	public void setSurvivor(Survivor survivor) {
		this.survivor = survivor;
	}
	
}