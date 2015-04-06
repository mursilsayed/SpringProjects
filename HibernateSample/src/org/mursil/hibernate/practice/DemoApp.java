package org.mursil.hibernate.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.mursil.hibernate.practice.model.UserDetails;
import org.mariadb.jdbc.MySQLConnection;

public class DemoApp {

	public static void main(String[] args) {

		System.out.println("Hello World from Hibernate");
		//Basic JDBC code testing the database connectivity
		
//		try{
//			
//            Class.forName("org.mariadb.jdbc.Driver").newInstance();
//			Connection  connection = (Connection)DriverManager.getConnection("jdbc:mariadb://192.168.59.103:3306/hibernatedb", "Mursil", "sam200");
//			Statement stmt = (Statement)connection.createStatement();
//			stmt.execute("Insert into a values(1,'Mursil') ");
//			stmt.close();
//			connection.close();
//			
//		}catch(Exception e)
//		{
//			System.out.println("Exception Occured: e= "+e.toString());
//			
//		}
		
		UserDetails userDetails = new UserDetails();
		userDetails.setUserid(1);
		userDetails.setUserName("Mursil");
		
		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.save(userDetails);
		session.getTransaction().commit();
		
		
		
	}

}
