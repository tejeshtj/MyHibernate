package com.caps.dev.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.caps.model.JPAUtils;
import com.caps.dev.beans.Girl;
import com.caps.dev.beans.Person_OneToOneUnidirectional;

public class HibernateJPAApp {
	public static void main(String[] args) {
		Person_OneToOneUnidirectional p =
					new Person_OneToOneUnidirectional();
		p.setName("Tejesh");
		p.setAge(22);
		p.setId(102);
		
		Girl addr = new Girl();
		addr.setGirl_id(2);
		addr.setGirlage(22);
		addr.setGirlname("vaishu");
		
		p.setGirl(addr);
		
		EntityManagerFactory emf = JPAUtils.getEMF();
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		em.persist(p);
		
		em.getTransaction().commit();
		em.close();
	}
}