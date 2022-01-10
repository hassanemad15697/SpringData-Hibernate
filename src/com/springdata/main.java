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

//			Person person=new Person();
//			person.setName("Emad Askar");
//			Data data = new Data();
//			data.setAge("56");
//			person.setData(data);
//			
//			session.save(person);
			
			
//			Person person=new Person();
//			person.setId(1);
//			person=session.get(Person.class, person.getId());
//			System.out.println(person.getId()+", "+person.getName()+", "+person.getData().getAge());
			
			//befor deleting any data you must get it befor
//			Person person=new Person();
//			person.setId(3);
//			person=session.get(Person.class, person.getId());
//			session.delete(person);
			
			//updating data on one to one relationship
//			Person person=new Person();
//			person.setId(4);
//			Data data = new Data();
			//this step is very important
//			data.setId(person.getId());
//			data.setAge("19");
//			person.setData(data);
//			session.update(person);
			
			//making operation by Data class "onther table"
			Data data= new Data();
			data.setAge("50");
			Person person=new Person();
			person.setName("Eslah Askar");
			data.setPerson(person);
			
			session.save(data);
			
			
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		} finally {
			session.close();
		}

	}

}
