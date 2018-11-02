package com.caps.model;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtils {
	
	private JPAUtils() {}
	
	private static final EntityManagerFactory EMF = 
							getEntityManagerFactory();
	
	private static EntityManagerFactory getEntityManagerFactory() {
		EntityManagerFactory emf = Persistence.
				createEntityManagerFactory("myPersistanceUnit");//creates an emf invoking cemf on persistant unit name
		
		return emf;
	}
	
	public static EntityManagerFactory getEMF() {
		return EMF;
	}
	
	
	
}