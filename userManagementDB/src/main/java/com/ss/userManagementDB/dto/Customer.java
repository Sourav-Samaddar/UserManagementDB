package com.ss.userManagementDB.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO,generator="native")
	@GenericGenerator(name = "native",strategy = "native")
	@Column(name = "CUSTOMER_ID" , unique = true , nullable = false)
	private Long id;
	private String name;
	@Column(name = "PhoneNumber")
	private String contactNumber;
	private String email;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "CUSTOMER_VEHICLE",joinColumns = @JoinColumn(name="CUSTOMER_ID"),
				inverseJoinColumns = @JoinColumn(name="VEHICLE_ID"))
	private Collection<Vehicle> vehicleList = new ArrayList<Vehicle>();
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
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Collection<Vehicle> getVehicleList() {
		return vehicleList;
	}
	public void setVehicleList(Collection<Vehicle> vehicleList) {
		this.vehicleList = vehicleList;
	}
	
}
