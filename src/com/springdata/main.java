package com.springdata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.springdata.model.Client;

public class main {

	public static void main(String[] args) throws SQLException {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
													.addAnnotatedClass(Client.class)
													.buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		
		
		/*final String host="jdbc:mysql://localhost/employee";
		final String username = "DBHassan";
		final String password="ELKBEER36647126358#";
		Connection conn;
		conn = DriverManager.getConnection(host, username, password);
        System.out.println("Connected!");
        conn.close();*/
	}

}
