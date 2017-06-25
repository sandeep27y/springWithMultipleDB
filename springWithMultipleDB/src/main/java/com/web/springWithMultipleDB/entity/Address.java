package com.web.springWithMultipleDB.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="address")
public class Address implements Serializable{
	@Id
	@GeneratedValue
	private Long addressId;
	private String addeess;
	private String city;
	private String country;
	
	@ManyToOne
	@JoinColumn(name="employeeid")
	private Employee employee;

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public String getAddeess() {
		return addeess;
	}

	public void setAddeess(String addeess) {
		this.addeess = addeess;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Address(Long addressId, String addeess, String city, String country, Employee employee) {
		super();
		this.addressId = addressId;
		this.addeess = addeess;
		this.city = city;
		this.country = country;
		this.employee = employee;
	}

	public Address(Long addressId, String addeess, String city, String country) {
		super();
		this.addressId = addressId;
		this.addeess = addeess;
		this.city = city;
		this.country = country;
	}

	
	
	
}
