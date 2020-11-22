package com.ss.userManagementDB.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;


@Entity
@Table(name = "STUDENT")
public class Student {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO,generator="native")
	@GenericGenerator(name = "native",strategy = "native")
	@Column(name = "STUDENT_ID")
	private Long id;
	private String name;
	private String phoneNumber;

	@ElementCollection
	@JoinTable(name = "USER_ADDRESS", joinColumns=@JoinColumn(name="STUDENT_ID"))
	@GenericGenerator(name = "increment-gen",strategy = "increment")
	@CollectionId(columns = {@Column(name = "ADDRESS_ID")},	generator ="increment-gen",type=@Type(type = "long")) 
	private Collection<Address>	listOfAddress = new ArrayList<Address>();
		
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public Collection<Address> getListOfAddress() { return listOfAddress; }
	public void setListOfAddress(Collection<Address> listOfAddress) {
	this.listOfAddress = listOfAddress; }
		
}
