package com.caps.dev.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="address_one_to_one")
@Table(name="girl")
public class Girl {
	
	@Id
	private int girl_id;
	
	@Column
	private String girlname;
	
	@Column
	private int girlage;

	public int getGirl_id() {
		return girl_id;
	}

	public void setGirl_id(int girl_id) {
		this.girl_id = girl_id;
	}

	public String getGirlname() {
		return girlname;
	}

	public void setGirlname(String girlname) {
		this.girlname = girlname;
	}

	public int getGirlage() {
		return girlage;
	}

	public void setGirlage(int girlage) {
		this.girlage = girlage;
	}
	
	
	
	
	
}