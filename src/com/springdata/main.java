package com.springdata;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.springdata.model.Car;
import com.springdata.model.Color;
import com.springdata.model.Data;
import com.springdata.model.Info;
import com.springdata.model.Person;
import com.springdata.model.Student;

public class main {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Color.class)
				.addAnnotatedClass(Car.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();
			
			
			Car BMW = new Car("BMW");
			Car VW = new Car("volkswagen");
			Car mercedes = new Car("mercedes");
			
			Color red = new Color("red");
			Color blue = new Color("blue");
			Color black = new Color("black");
			
			BMW.getColors().add(red);
			BMW.getColors().add(blue);
			BMW.getColors().add(black);
			
			VW.getColors().add(red);
			VW.getColors().add(blue);
			VW.getColors().add(black);
			
			mercedes.getColors().add(red);
			mercedes.getColors().add(blue);
			mercedes.getColors().add(black);
			
			session.save(BMW);
			session.save(VW);
			session.save(mercedes);
			
			
			
			
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		} finally {
			session.close();
		}

	}

}
