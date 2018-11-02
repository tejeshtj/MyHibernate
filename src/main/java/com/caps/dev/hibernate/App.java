package com.caps.dev.hibernate;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.caps.dev.beans.Movie;
import com.caps.model.JPAUtils;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main( String[] args )
	{
		getMovieById();
		//remove();
	}
	
	public static void save() {
		System.out.println("Enter Movie Details");
		System.out.println("-------------------");
		Movie movie = new Movie();
		Scanner in = new Scanner(System.in);

		System.out.println("Enter movie id: ");
		movie.setMovieId(Integer.parseInt(in.nextLine()));

		System.out.println("Enter movie name: ");
		movie.setMovieName(in.nextLine());

		System.out.println("Enter movie ratings: ");
		movie.setRatings(Double.parseDouble(in.nextLine()));

		System.out.println("Enter movie summary: ");
		movie.setSummmary(in.nextLine());
		System.out.println("Movie Saved");
		EntityManagerFactory emf = JPAUtils.getEMF();
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(movie);
		tx.commit();
		em.close();
		emf.close();
		
	}
	
	public static void getMovieById() {
		System.out.println("Enter a movie id: ");
		Scanner sc = new Scanner(System.in);
		int id = Integer.parseInt(sc.nextLine());
		EntityManagerFactory emf = JPAUtils.getEMF();//creates an entity manager factory on given persistant unit(creating a factory for a specific product)
		EntityManager em = emf.createEntityManager();//creating manager in emf factory with create entity manager machine
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Movie m = em.find(Movie.class, id);
		tx.commit();
		em.close();
		emf.close();
		
		System.out.println(m);
	}
	public static void remove() {
		//to remove an entity we have to get the record first and then we can delete it
		System.out.println("Enter a movie id: ");
		Scanner sc = new Scanner(System.in);
		int id = Integer.parseInt(sc.nextLine());
		EntityManagerFactory emf = JPAUtils.getEMF();//creates an entity manager factory on given persistant unit(creating a factory for a specific product)
		EntityManager em = emf.createEntityManager();//creating manager in emf factory with create entity manager machine
		EntityTransaction tx = em.getTransaction();//to start a transaction
		tx.begin();
		Movie m = em.find(Movie.class, id);
		System.out.println(m);	
		em.remove(m);//to remove an entity
		tx.commit();//to commit the transaction
		em.close();
		emf.close();
		
	}
	public static void update() {
		//to update an entity we must fetch the entity and then set the related column of object then update happends.
		System.out.println("Enter a movie id: ");
		Scanner sc = new Scanner(System.in);
		int id = Integer.parseInt(sc.nextLine());
		System.out.println("enter the movie rating: ");
		Double ratings=Double.parseDouble(sc.nextLine());
		EntityManagerFactory emf = JPAUtils.getEMF();//creates an entity manager factory on given persistant unit(creating a factory for a specific product)
		EntityManager em = emf.createEntityManager();//creating manager in emf factory with create entity manager machine
		EntityTransaction tx = em.getTransaction();//to start a transaction
		tx.begin();
		Movie m = em.find(Movie.class, id);
		m.setRatings(ratings);//to set a particular 
		tx.commit();//to commit the transaction
		em.close();
		emf.close();
	}
}