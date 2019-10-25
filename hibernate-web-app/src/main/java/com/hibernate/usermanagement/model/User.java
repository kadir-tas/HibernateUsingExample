package com.hibernate.usermanagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


import com.hibernate.usermanagement.dto.UserDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "contact")
public class User {

	@Id
	@Column(name = "phone", updatable = false, nullable = false)
	protected String phone;
	
	@Column(name = "name")
	protected String name;

	@Column(name = "email")
	protected String email;

	@Column(name = "country")
	protected String country;
	
	public User(UserDto userDto) {
		this.country = userDto.getCountry();
		this.email = userDto.getEmail();
		this.name = userDto.getName();
		this.phone = userDto.getPhone();	
	}
}