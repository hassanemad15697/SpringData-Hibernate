package com.springdata;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.springdata.model.Client;

public class main {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Client.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		// adding values to client
		// Client client=new Client("Hassan Askar","Milano","01050732153");

		try {
			session.beginTransaction();
			// saving data to database
//			Client client = new Client("Hager Emad", "Italy", "01550732153");
//			 session.save(client);

			// getting data from database
//			Client client1 = session.get(Client.class, 1);
//			System.out.println(client1.getName());
//			Client client2 = session.get(Client.class, 2);
//			System.out.println(client2.getName());

			// updating data in database
//			Client client = new Client(2,"Hassan Emad", "Cairo", "01550732153");
//			session.update(client);
//			

			// deleting data from the database
//			Client client=new Client();
//			client.setId(9);
//			session.delete(client);

			// getting all table data
//			List<Client> clients=session.createQuery("from Client").list();

			// GETTING DATA TABLE BY CONDITION
//			List<Client> clients=session.createQuery("from Client c where c.phone = '01550732153'").list();

			//// GETTING DATA TABLE BY Start with , end with or anywhere CONDITION
			// start with s% s id a letter
			// end with %s
			// anywhere %s%
//			List<Client> clients=session.createQuery("from Client c where c.name Like '%h%'").list();
//			

			// showing getted data
//			for(Client client : clients)
//			{
//				System.out.println(client.getName());
//			}
//			

			// updaing database values by session.createQuery
//			session.createQuery("update Client set phone ='01123456789' where name = 'Israa Emad'").executeUpdate();

			// deleting database values by session.createQuery
//			session.createQuery("delete from Client where name = 'Israa Emad'").executeUpdate();

//			Query q1 = session.createQuery("select Max(id) from Client");
//			Query q2 = session.createQuery("select Min(id) from Client");
//			Query q3 = session.createQuery("select sum(id) from Client");
//			Query q4 = session.createQuery("select avg(id) from Client");
//			Query q5 = session.createQuery("select count(phone) from Client");
//			Query q6 = session.createQuery("select count(distinct phone) from Client");
//			
//			
//			System.out.println(q1.list().get(0));
//			System.out.println(q2.list().get(0));
//			System.out.println(q3.list().get(0));
//			System.out.println(q4.list().get(0));
//			System.out.println(q5.list().get(0));
//			System.out.println(q6.list().get(0));
//			

			Criteria criteria=session.createCriteria(Client.class);
			//to get  data by specific range
//			criteria.setFirstResult(0);
//			criteria.setMaxResults(4);
			
			//get data from specific cloumn and specific raw
//			criteria.add(Restrictions.in("id", 2));
			//check if there is a raw has Null value?
//			criteria.add(Restrictions.isNotNull("phone"));
			//check if there is a raw started with "a" letter
//			criteria.add(Restrictions.like("name", "a",MatchMode.START));
			//check if there is a raw equals to name = hassan emad 
//			criteria.add(Restrictions.eq("name", "Hassan Emad"));
			
			
			//selecting many data based on differnet cloumns with OR operation
//			Criterion c1 = Restrictions.eq("address", "Cairo");
//			Criterion c2 = Restrictions.eq("name", "Amro Askar");
//			LogicalExpression expression = Restrictions.or(c1, c2);
//			criteria.add(expression);
//			for(Client client : clients)
//			{
//				System.out.println(client.getName());
//			}
			
			
			//gett min value of id
//			criteria.setProjection(Projections.min("id"));
			//gett min value of id
//			criteria.setProjection(Projections.max("id"));
			//gett min value of id
//			criteria.setProjection(Projections.avg("id"));
			//gett min value of id
//			criteria.setProjection(Projections.count("id"));
			//gett min value of id
			criteria.setProjection(Projections.countDistinct("id"));
			
			List<Client> clients=criteria.list();
			System.out.println(clients.get(0));
			
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		} finally {
			session.close();
		}

		/*
		 * final String host="jdbc:mysql://localhost/employee"; final String username =
		 * "DBHassan"; final String password="ELKBEER36647126358#"; Connection conn;
		 * conn = DriverManager.getConnection(host, username, password);
		 * System.out.println("Connected!"); conn.close();
		 */
	}

}
