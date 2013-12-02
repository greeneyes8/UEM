package it.unical.uniexam.hibernate.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;



@Entity
public class PhoneNumber {

	public PhoneNumber(){}
	
	@Id
	@Column(name="PHONE_ID")
	@GeneratedValue
	private Long id;
	
	@Column(name="PHONE_TYPE")
	private String type;
	
	@Column(name="PHONE_NUMBER")
	private String number;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
	
	
}