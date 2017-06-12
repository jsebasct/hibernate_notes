package org.learn.grizzly.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Phone {
	
	@Id
	@GeneratedValue
	private Integer phoneId;
	private String phoneType;
	private String phoneNumber;
	
	public Phone() {
	}
	
	public Phone(String type, String number) {
		phoneType = type;
		phoneNumber = number;
	}
	
}
