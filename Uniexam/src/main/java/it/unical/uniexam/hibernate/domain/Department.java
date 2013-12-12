package it.unical.uniexam.hibernate.domain;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;



@Entity
@Table(name="DEPARTMENT")
public class Department {

	@Id
	@Column(name="ID")
	@GeneratedValue
	private Long id;
	
	@Column(name="CODE")
	private String code;
	
	@Column(name="NAME")
	private String name;
	
	@Embedded
	private Address address;
	
	@OneToMany(mappedBy="department_assigned")
	private Set<Professor> professors;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Set<Professor> getProfessors() {
		return professors;
	}

	public void setProfessors(Set<Professor> professors) {
		this.professors = professors;
	}

	public void addProfessor(Professor p) {
		professors.add(p);
	}
	
//	@Column(name="PRESIDENT")
//	@OneToOne(fetch=FetchType.LAZY)
//	private Professor president;
//	
	
	
	
}
