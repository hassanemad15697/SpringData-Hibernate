package com.springdata;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.springdata.model.Data;
import com.springdata.model.Person;

public class main {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Person.class)
								.addAnnotatedClass(Data.class)
								.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();

			Person person=new Person();
			person.setName("Amro Askar");
			Data data = new Data();
			data.setAge("23");
			person.setData(data);
			
			session.save(person);
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		} finally {
			session.close();
		}

	}

}
