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
//		
//		session.save(userDetails);
//		int i=0;
//		for(;i<10;i++)
//		{
//			
//			UserDetails user = new UserDetails();
//			user.setUserName("Mursil"+i);
//			user.setDescription("Hello World. Nice Description");
//			user.setJoindate(new Date());
//			session.save(user);
//		}
//		
//		session.getTransaction().commit();
//		session.close();
//		
//		
		Query query = (Query) session.createQuery("from UserDetails");
		query.setFirstResult(4);
		query.setMaxResults(5);
		List<UserDetails> result = (List<UserDetails>)query.list();
		for(UserDetails user:result)
		{
			System.out.println("User Name = "+user.getUserName());
			
		}
		
		
		//System.out.println("User name="+userDetails2.getUserName()+"\n UserID="+userDetails2.getUserid());
		session.getTransaction().commit();
		session.close();
		
	}

}
