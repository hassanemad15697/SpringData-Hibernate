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

			//save new data
//			Student s=new Student();
//			s.setName("Amro");
//			Info info1=new Info();
//			info1.setPhone("01015367895");
//			Info info2=new Info();
//			info2.setPhone("388754126");
//			s.getInfos().add(info1);
//			s.getInfos().add(info2);
//			info1.setStudent(s);
//			info2.setStudent(s);
//			session.save(s);
			
			//get data from database
//			Student s = new Student();
//			s=session.get(Student.class, 1);
//			
//			System.out.println(s.getName());
//			for (Info i : s.getInfos()) {
//				System.out.println(i.getPhone());
//			}
//			
			//update data to database
			Student s=new Student();
			s=session.get(Student.class, 2);
			s.setName("Amr");
			s.getInfos().get(0).setPhone("01115367895");;
			session.update(s);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		} finally {
			session.close();
		}

	}

}
