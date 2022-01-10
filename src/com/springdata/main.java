package com.springdata;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.springdata.model.Data;
import com.springdata.model.Info;
import com.springdata.model.Person;
import com.springdata.model.Student;

public class main {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.addAnnotatedClass(Info.class	)
								.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();

			Student s=new Student();
			s.setName("Hassan");
			Info info1=new Info();
			info1.setPhone("01550732153");
			Info info2=new Info();
			info2.setPhone("3881298127");
			s.getInfos().add(info1);
			s.getInfos().add(info2);
			info1.setStudent(s);
			info2.setStudent(s);
			session.save(s);
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		} finally {
			session.close();
		}

	}

}
