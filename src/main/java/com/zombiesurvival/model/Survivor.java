package com.zombiesurvival.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.zombiesurvival.util.type.TypeGender;

@Entity
@Table(name = "survivor")
@SequenceGenerator(name="SEQUENCE", sequenceName="survivor_id_seq")
public class Survivor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQUENCE")
    private int id;
	private String name;
	private int age;
	private TypeGender gender;
	private String latitude;
	private String longitude;
	private int delation;
	private boolean infected;
	
	public Survivor() {}

	public Survivor(String name, String latitude, String longitude) {
		this.name = name;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public TypeGender getGender() {
		return gender;
	}

	public void setGender(TypeGender gender) {
		this.gender = gender;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public int getDelation() {
		return delation;
	}

	public void setDelation(int delation) {
		this.delation = delation;
	}

	public boolean isInfected() {
		return infected;
	}

	public void setInfected(boolean infected) {
		this.infected = infected;
	}
	
	
}