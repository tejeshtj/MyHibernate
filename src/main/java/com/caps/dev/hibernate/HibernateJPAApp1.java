package com.caps.dev.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.caps.model.JPAUtils;
import com.caps.dev.beans.Girl;
import com.caps.dev.beans.Person_OneToOneUnidirectional;
import com.caps.dev.beans.User_OneToOneBidirectional;
import com.caps.dev.beans.VoterCard;

public class HibernateJPAApp1 {
	public static void main(String[] args) {
		User_OneToOneBidirectional user=new User_OneToOneBidirectional();
		user.setName("vaishu");
		user.setUser_id(2);
		
		VoterCard card=new VoterCard();
		card.setVoter_id(101);
		card.setAddress("bangalore");
		
		card.setUser(user);
		user.setVoterCard(card);
		
		
		EntityManagerFactory emf = JPAUtils.getEMF();
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		//em.persist(user);
		User_OneToOneBidirectional user1=em.find(User_OneToOneBidirectional.class,1);
		System.out.println(user1);
		em.getTransaction().commit();
		em.close();
	}
}