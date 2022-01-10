package com.springdata.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "studentID")
	private int id;
	@Column(name = "studentName")
	private String name;

	@OneToMany(cascade = CascadeType.ALL,mappedBy = "student")
	Set<Info> infos=new HashSet<Info>();
	
	
	

	public Set<Info> getInfos() {
		return infos;
	}

	public void setInfos(Set<Info> infos) {
		this.infos = infos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
