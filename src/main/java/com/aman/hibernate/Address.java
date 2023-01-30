package com.aman.hibernate;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "student_address")
public class Address {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	
	
	@Column(name="addressid")
	private int address_id;
	
	
	
	
	@Column(length = 20)
	private String street, city ;
	@Column(name="is_open")
	private boolean isOpen;
	
//	transient - hibernate will not enter this column into the database
	@Transient
	private double x;
	
	

	@Temporal(TemporalType.DATE)
	private Date addeddate;
	
//	lob is used for the large objects
	@Lob
	private byte[] image;
	
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(int address_id, String street, String city, boolean isOpen, double x, Date addeddate, byte[] image) {
		super();
		this.address_id = address_id;
		this.street = street;
		this.city = city;
		this.isOpen = isOpen;
		this.x = x;
		this.addeddate = addeddate;
		this.image = image;
	}

	public int getAddress_id() {
		return address_id;
	}

	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public boolean isOpen() {
		return isOpen;
	}

	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public Date getAddeddate() {
		return addeddate;
	}

	public void setAddeddate(Date addeddate) {
		this.addeddate = addeddate;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Address [address_id=" + address_id + ", street=" + street + ", city=" + city + ", isOpen=" + isOpen
				+ ", x=" + x + ", addeddate=" + addeddate + ", image=" + Arrays.toString(image) + "]";
	}
	
	
	
	
	
	

}
