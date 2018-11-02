package com.caps.dev.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="person_one_to_one")
public class Person_OneToOneUnidirectional {
	
	@Id
	private int id;
	
	@Column
	private String name;
	
	@Column
	private int age;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="girl_id", referencedColumnName="girl_id")
	private Girl girl;

	
	
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Girl getGirl() {
		return girl;
	}
	public void setGirl(Girl girl) {
		this.girl= girl;
	}
	
}