package org.learn.grizzly.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
//@Data
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //default strategy auto
	private Integer studentId;
	
	private String studentName;
	
	//
	//
	//
	//
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="STUDENT_PHONE", 
				joinColumns={ @JoinColumn(name="STUDENT_ID") }, 
				inverseJoinColumns={ @JoinColumn(name="PHONE_ID") })
	private Set<Phone> studentPhoneNumbers = new HashSet<Phone>();
	
	public Student() {
	}
	
	public Student(String name) {
		studentName = name;
	}
	
	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer stockId) {
		this.studentId = stockId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String stockName) {
		this.studentName = stockName;
	}

	public Set<Phone> getStudentPhoneNumbers() {
		return studentPhoneNumbers;
	}

	public void setStudentPhoneNumbers(Set<Phone> studentPhoneNumbers) {
		this.studentPhoneNumbers = studentPhoneNumbers;
	}

	
	
}
