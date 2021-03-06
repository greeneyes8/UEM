package it.unical.uniexam.hibernate.domain;


import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import it.unical.uniexam.hibernate.domain.utility.Address;
import it.unical.uniexam.hibernate.domain.utility.CommentOfPost;
import it.unical.uniexam.hibernate.domain.utility.Email;
import it.unical.uniexam.hibernate.domain.utility.PhoneNumber;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * @author luigi
 *
 */
@Entity
@Table(name="USER")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class User {

	public enum TYPE{
		PROFESSOR,STUDENT,MANAGER,SECRETARY;
	}


	public User() {
	}

	public User(TYPE type, String name, String surname, URL webSite,
			String password, Address address,Set<Email> emails,
			Set<PhoneNumber> phoneNumbers) {
		super();
		this.type = type;
		this.name = name;
		this.surname = surname;
		this.webSite = webSite;
		this.password = password;
		this.address = address;
		this.emails = emails;
		this.phoneNumbers = phoneNumbers;
	}

	@Id
	@Column(name="ID", nullable=false)
	@GeneratedValue
	Long id;

	@Column(name="SESSION_ID")
	String sessionId;

	@Column(name="TYPE")
	TYPE type;

	@Column(name="NAME", nullable=false)
	String name;

	@Column(name="SURNAME", nullable=false)
	String surname;

	@Column(name="WEB_SITE",nullable=true)
	URL webSite;

	@Column(name="Personalizzation",length=100000)
	String personalizzation;

	@Column(name="PASSWORD", nullable=false)
	String password;

	@Embedded
	Address address;

	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="USER_EMAIL",
	joinColumns={
			@JoinColumn(name="ID")
	}, 
	inverseJoinColumns={
			@JoinColumn(name="EMAIL_ID")
	})
	private Set<Email> emails=new HashSet<Email>();

	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="USER_PHONE",
	joinColumns={
			@JoinColumn(name="ID")
	}, 
	inverseJoinColumns={
			@JoinColumn(name="PHONE_ID")
	})
	private Set<PhoneNumber> phoneNumbers=new HashSet<PhoneNumber>();

	@OneToMany(cascade=CascadeType.ALL)//°°°°MOKTODO lascialo questo dovrebbe servire
	@JoinTable(name="USER_COMMENT",
	joinColumns={
			@JoinColumn(name="ID")
	}, 
	inverseJoinColumns={
			@JoinColumn(name="COMMENT_ID")
	})
	private Set<CommentOfPost> comments=new HashSet<CommentOfPost>();

	@ElementCollection(fetch=FetchType.EAGER)
	@JoinTable(
			name = "READ_COMMENT",
			joinColumns = @JoinColumn(name = "ID")
			)
	@Column(name = "UNREAD")
	private List<Long> noReadComments = new ArrayList<Long>();

	@ManyToMany(mappedBy="iscribed")
	Set<Group>groups=new HashSet<Group>();


	/**
	 * Second part of function
	 */
	public Set<CommentOfPost> getComments() {
		return comments;
	}

	public void setComments(Set<CommentOfPost> comments) {
		this.comments = comments;
	}

	public String getPassword() {
		return password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public URL getWebSite() {
		return webSite;
	}

	public void setWebSite(URL webSite) {
		this.webSite = webSite;
	}

	public TYPE getType() {
		return type;
	}

	public void setType(TYPE type) {
		this.type = type;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	//        public Session getSession() {
		//                return session;
		//        }
	//
	//        public void setSession(Session session) {
		//                this.session = session;
		//        }
	public Set<PhoneNumber> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(Set<PhoneNumber> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}
	public Set<Email> getEmails() {
		return emails;
	}

	public void setEmails(Set<Email> emails) {
		this.emails = emails;
	}

	public List<Long> getNoReadComments() {
		return noReadComments;
	}

	public void setNoReadComments(List<Long> noReadComments) {
		this.noReadComments = noReadComments;
	}

	public Set<Group> getGroups() {
		return groups;
	}

	public void setGroups(Set<Group> groups) {
		this.groups = groups;
	}

	public String getPersonalizzation() {
		return personalizzation;
	}

	public void setPersonalizzation(String personalizzation) {
		this.personalizzation = personalizzation;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		return true;
	}
	
	
}
