package com.springdata;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

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
			session.createQuery("delete from Client where name = 'Israa Emad'").executeUpdate();

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
