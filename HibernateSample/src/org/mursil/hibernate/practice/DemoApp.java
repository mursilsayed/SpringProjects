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

import org.mursil.hibernate.practice.model.FourWheeler;
import org.mursil.hibernate.practice.model.TwoWheeler;

import org.mursil.hibernate.practice.model.Vehicle;
import org.mariadb.jdbc.MySQLConnection;

public class DemoApp {

	public static void main(String[] args) {

		System.out.println("Hello World from Hibernate Inheritance Implementation");
	
		Vehicle v= new Vehicle("Car",1);
		TwoWheeler two=new TwoWheeler("Yamaha",2);
		FourWheeler four = new FourWheeler("Honda",3);
		
		
		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.save(v);
		session.save(two);
		session.save(four);
		session.getTransaction().commit();
		session.close();
		
		
		//Reading the User Detail from Table
		session = sessionFactory.openSession();
		Vehicle vehicle;
		//session = sessionFactory.openSession();
		vehicle = (Vehicle)session.get(Vehicle.class, 1);
		System.out.println("ID="+vehicle.getId()+"\n Name="+vehicle.getName());
		
		vehicle = (Vehicle)session.get(Vehicle.class, 2);
		System.out.println("ID="+vehicle.getId()+"\n Name="+vehicle.getName());
		
		vehicle = (Vehicle)session.get(Vehicle.class, 3);
		System.out.println("ID="+vehicle.getId()+"\n Name="+vehicle.getName());
		session.close();
		
	}

}
