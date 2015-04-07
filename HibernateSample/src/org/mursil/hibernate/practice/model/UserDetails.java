package org.mursil.hibernate.practice.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity //(name="user_details")
//@Table (name="user_details")
public class UserDetails {

	@Id
	@Column(name="user_id")
	@GeneratedValue
	private int userid;
	private String userName;
	@Temporal( TemporalType.DATE)
	private Date joindate;
	//@Transient
	//private String address;

//	public String getAddress() {
//	return address;
//}
//public void setAddress(String address) {
//	this.address = address;
//}

	//@Lob
	private String description;
	//@Embedded
	//private Address address;

//	public Address getAddress() {
//		return address;
//	}
//	public void setAddress(Address address) {
//		this.address = address;
//	}
	
	
	@ElementCollection
	private Set<Address> addressList = new HashSet();

	
	
	public Set<Address> getAddressList() {
		return addressList;
	}


	public void setAddressList(Set<Address> addressList) {
		this.addressList = addressList;
	}


	public Date getJoindate() {
		return joindate;
	}
	
	
	public void setJoindate(Date joindate) {
		this.joindate = joindate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
