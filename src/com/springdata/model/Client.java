package com.springdata.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clients")
public class Client {

	//attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private long client_id;
	@Column(name = "client_name")
	private String name;
	@Column(name = "client_address")
	private String address;
	@Column(name = "client_phone")
	private String phone;
	
	
	//Getters & Setters

	public Client(String name, String address, String phone) {
		this.name = name;
		this.address = address;
		this.phone = phone;
	}


	
	
	
}
