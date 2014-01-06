package it.unical.uniexam.hibernate.domain;

import it.unical.uniexam.hibernate.domain.utility.Address;
import it.unical.uniexam.hibernate.domain.utility.Email;
import it.unical.uniexam.hibernate.domain.utility.PhoneNumber;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * @category Actor 
 * 
 * This class describe the actor Professor
 * each Professor extend User class, in addition have a set of a phone numbers
 * At each Professor 	is associated with a department
 * 						have many Appeals (appelli)
 * 						have many Appeals like commission (commissario) ?
 * 						have many Course as holder (titolare)	
 * 						have many Groups like a creator					
 * 
 * 					something else?
 * 
 * 
 * @author luigi
 *
 */

@Entity
@Table(name="PROFESSOR")
@PrimaryKeyJoinColumn(name="ID")
public class Professor extends User{

	public Professor(TYPE type, String name, String surname, URL webSite,
			String password, Address address, Set<Email> emails,
			Set<PhoneNumber> phoneNumbers, Department department_associated) {
		super(type, name, surname, webSite, password, address,emails,phoneNumbers);
		this.department_associated = department_associated;
	}
	
	public Professor() {
	}

	
	
	@ManyToOne(fetch=FetchType.LAZY)
	Department department_associated;

	@OneToMany(fetch=FetchType.LAZY)
	@JoinTable(name="PROFESSOR_APPEAL",
	joinColumns={
			@JoinColumn(name="PROFESSOR_ID")
	}, 
	inverseJoinColumns={
			@JoinColumn(name="APPEAL_ID")
	})
	Set<Appeal>appeals=new HashSet<Appeal>();

	@OneToMany(fetch=FetchType.LAZY)
	@JoinTable(name="PROFESSOR_COURSE_HOLDER",
	joinColumns={
			@JoinColumn(name="PROFESSOR_ID")
	}, 
	inverseJoinColumns={
			@JoinColumn(name="COURSE_ID")
	})
	Set<Course>holder=new HashSet<Course>();

	@ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinTable(name="PROFESSOR_COURSE_COMMISSION", 
	joinColumns={
			@JoinColumn(name="PROFESSOR_ID")
	}, 
	inverseJoinColumns={
			@JoinColumn(name="COURSE_ID")
	})
	Set<Course>asCommission=new HashSet<Course>();

	@OneToMany(fetch=FetchType.LAZY)
	@JoinTable(name="PROFESSOR_GRUOP",
	joinColumns={
			@JoinColumn(name="PROFESSOR_ID")
	}, 
	inverseJoinColumns={
			@JoinColumn(name="GROUP_ID")
	})
	Set<Group>groups=new HashSet<Group>();

	@ElementCollection(fetch=FetchType.EAGER)
	@JoinTable(
	name = "READ_COMMENT",
	joinColumns = @JoinColumn(name = "ID")
	)
//	@org.hibernate.annotations.IndexColumn(
//	name="POSITION", base = 1
//	)
	@Column(name = "UNREAD")
	private List<Long> noReadComments = new ArrayList<Long>();
	
	/**
	 * Implementation
	 */

	/**
	 * 
	 */
//	@Override
//	public String toString(){
//		return null;
//	}
//	
//	public Professor getIntanceFromAttributes(String attributes){
//		//name?cicio$surname?pasticcio //restituita dal toString senza il nome della classe
//		
//		
//		Professor res=null;
//		return res;
//	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Department getDepartment_associated() {
		return department_associated;
	}

	public void setDepartment_associated(Department department_associated) {
		this.department_associated = department_associated;
	}

	public Set<Appeal> getAppeals() {
		return appeals;
	}

	public void setAppeals(Set<Appeal> appeals) {
		this.appeals = appeals;
	}

	public Set<Course> getSetHoldersCourse() {
		return holder;
	}

	public void setHolder(Set<Course> holder) {
		this.holder = holder;
	}

	public Set<Course> getSetAsCommission() {
		return asCommission;
	}

	public void setSetAsCommission(Set<Course> asCommission) {
		this.asCommission = asCommission;
	}

	public Set<Group> getGroups() {
		return groups;
	}

	public void setGroups(Set<Group> groups) {
		this.groups = groups;
	}

	public List<Long> getNoReadComments() {
		return noReadComments;
	}

	public void setNoReadComments(List<Long> noReadComments) {
		this.noReadComments = noReadComments;
	}

}
