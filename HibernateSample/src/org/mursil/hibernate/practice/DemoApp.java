package org.mursil.hibernate.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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
		//userDetails.setUserid(1);
		
		
		//userDetails.setAddress("C-104 block 15 Gulistane Johar");
		Address add = new Address();
		add.setCity("Karachi");
		add.setStreet("Gulistane-e-Johar");
		
		Address add2 = new Address();
		add2.setCity("Karachi");
		add2.setStreet("Gulistane-e-Johar");
		Set<Address> list = new HashSet();
		list.add(add);
		list.add(add2);
		
		Vehicle vehicle = new Vehicle();
		vehicle.setName("Cultus");
		
		userDetails.setVehicle(vehicle);
		userDetails.setUserName("Mursil");
		userDetails.setAddressList(list);
		userDetails.setDescription("Hello World. Nice Description");
		userDetails.setJoindate(new Date());
		
		
		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.save(userDetails);
		session.save(vehicle);
		session.getTransaction().commit();
		session.close();
		
		
		//Reading the User Detail from Table
		session = sessionFactory.openSession();
		UserDetails user ;
		//session = sessionFactory.openSession();
		user = (UserDetails)session.get(UserDetails.class, 1);
		System.out.println("User name="+user.getUserName()+"\n UserID="+user.getUserid());
		session.close();
		
	}

}
