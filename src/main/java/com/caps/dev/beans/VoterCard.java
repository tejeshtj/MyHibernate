package com.caps.dev.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class VoterCard {
	
	@Id
	private int voter_id;
	
	private String address;
	
	@OneToOne(mappedBy="voterCard")
	private User_OneToOneBidirectional user;

	public int getVoter_id() {
		return voter_id;
	}

	public void setVoter_id(int voter_id) {
		this.voter_id = voter_id;
	}
	

	public String getAddress() {
		return address;
	}

	@Override
	public String toString() {
		return "VoterCard [voter_id=" + voter_id + ", address=" + address + "]";
	}

	public void setAddress(String string) {
		this.address = string;
	}
	
	public User_OneToOneBidirectional getUser() {
		return user;
	}

	public void setUser(User_OneToOneBidirectional user) {
		this.user = user;
	}
	
}