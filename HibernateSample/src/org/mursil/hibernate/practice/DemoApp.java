package org.mursil.hibernate.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.mursil.hibernate.practice.model.Address;
import org.mursil.hibernate.practice.model.UserDetails;
import org.mursil.hibernate.practice.model.Vehicle;
import org.mariadb.jdbc.MySQLConnection;

public class DemoApp {

	public static void main(String[] args) {

		System.out.println("Hello World from Hibernate");
	
		
	
	
		
		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		
     	Query query = session.getNamedQuery("UserDetails.byidandname");
    	query.setInteger("id", 5);
		

		
		List<String> result = (List<String>)query.list();
		for(String user:result)
		{
			System.out.println("User Name = " +user);
			
		}
		
		
		session.getTransaction().commit();
		session.close();
		
	}

}
