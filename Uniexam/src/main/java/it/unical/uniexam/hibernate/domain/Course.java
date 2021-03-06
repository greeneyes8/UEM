package it.unical.uniexam.hibernate.domain;

import java.net.URL;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @category Structure 
 * 
 * This class describe a Course
 * each Course have a code, a name, a number of credits; 
 *                 and belongs at an DC;
 * At each Course         have a professor like holder (titolare)(don't need exerciser),
 *                                          have many other course as requested (propedeuticit�)
 *                                         possible have exam in pending (appelli)
 *                                         possible appears in a carrier of students (carriera)
 *                                         
 *                                         something else?
 *         
 * @author luigi
 *
 */

@Entity
@Table(name="COURSE")
public class Course {



	public Course() {
	}

	public Course(String code, String name, URL webSite, Integer credits,
			Set<RequestedCourse> requestedCourses,
			Set<Professor> commissionProfessors, Professor holder, DegreeCourse degreeCourse) {
		this.code = code;
		this.name = name;
		this.webSite = webSite;
		this.credits = credits;
		this.requestedCourses = requestedCourses;
		this.commissionProfessors = commissionProfessors;
		this.holder = holder;
		this.degreeCourse = degreeCourse;
	}
	
	public Course(String code, String name, Integer credits, Professor holder, DegreeCourse degreeCourse) {
		this.code = code;
		this.name = name;
		this.credits = credits;
		this.holder = holder;
		this.degreeCourse = degreeCourse;
	}

	@Id
	@Column(name="COURSE_ID")
	@GeneratedValue
	Long id;

	@Column(name="CODE", nullable=false)
	String code;

	@Column(name="NAME", nullable=false)
	String name;

	@Column(name="URL_WEB_SITE", nullable=true)
	URL webSite;

	@Column(name="CREDITS", nullable=false)
	Integer credits;

	@Column(name="NOTE")
	String note;

	@OneToMany(fetch=FetchType.LAZY)
	@JoinTable(name="COURSE_GROUP",
	joinColumns={
			@JoinColumn(name="COURSE_ID")
	}, 
	inverseJoinColumns={
			@JoinColumn(name="GROUP_ID")
	})
	Set<Group> groups=new HashSet<Group>();

	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="COURSE_REQUESTCOURSE",
	joinColumns={
			@JoinColumn(name="COURSE_ID")
	}, 
	inverseJoinColumns={
			@JoinColumn(name="REQUEST_COURSE_ID")
	})
	Set<RequestedCourse> requestedCourses=new HashSet<RequestedCourse>();

	@ManyToMany(mappedBy="asCommission",fetch=FetchType.LAZY)
	Set<Professor>commissionProfessors=new HashSet<Professor>();

	@ManyToOne
	Professor holder;

	@ManyToOne
	DegreeCourse degreeCourse;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="COURSE_APPEAL",
			joinColumns = {
				@JoinColumn(name="COURSE_ID")
			},
			inverseJoinColumns = {
				@JoinColumn(name="APPEAL_ID")
			}
		)
	Set<Appeal> appeals = new HashSet<Appeal>();
	
	@OneToMany(fetch=FetchType.LAZY)
	@JoinTable(name="COURSE_CARRIER",
			joinColumns = {
				@JoinColumn(name="COURSE_ID")
			},
			inverseJoinColumns = {
				@JoinColumn(name="CARRIER_ID")
			}
		)
	Set<Carrier> carrier = new HashSet<Carrier>();
	
	/**
	 * implementetion function part
	 * 
	 */

	/**
	 * 
	 */


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

	public URL getWebSite() {
		return webSite;
	}

	public void setWebSite(URL webSite) {
		//                if(webSite!=null)
			this.webSite = webSite;
	}

	public Integer getCredits() {
		return credits;
	}

	public void setCredits(Integer credits) {
		this.credits = credits;
	}

	public Set<RequestedCourse> getRequestedCourses() {
		return requestedCourses;
	}

	public void setRequestedCourses(Set<RequestedCourse> requestedCourses) {
		if(requestedCourses!=null)
			this.requestedCourses = requestedCourses;
	}

	public Set<Professor> getCommissionProfessors() {
		return commissionProfessors;
	}

	public void setCommissionProfessors(Set<Professor> commissionProfessors) {
		if(commissionProfessors!=null)
			this.commissionProfessors = commissionProfessors;
	}

	public Professor getHolder() {
		return holder;
	}

	public void setHolder(Professor holder) {
		//                if(holder!=null)
			this.holder = holder;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((credits == null) ? 0 : credits.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((webSite == null) ? 0 : webSite.hashCode());
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
		Course other = (Course) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Set<Group> getGroups() {
		return groups;
	}

	public void setGroups(Set<Group> groups) {
		this.groups = groups;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public DegreeCourse getDegreeCourse() {
		return degreeCourse;
	}

	public void setDegreeCourse(DegreeCourse degreeCourse) {
		this.degreeCourse = degreeCourse;
	}

	public Set<Appeal> getAppeals() {
		return appeals;
	}

	public void setAppeals(Set<Appeal> appeals) {
		this.appeals = appeals;
	}

	public Set<Carrier> getCarrier() {
		return carrier;
	}

	public void setCarrier(Set<Carrier> carrier) {
		this.carrier = carrier;
	}
	
}
