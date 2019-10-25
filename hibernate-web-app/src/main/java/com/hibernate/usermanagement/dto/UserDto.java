package com.hibernate.usermanagement.dto;

import com.hibernate.usermanagement.model.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
	private String email;
	private String phone;
	private String name;
	private String country;


	public UserDto(User user) {
		this.email = user.getEmail();
		this.phone = user.getPhone();
		this.name = user.getName();
		this.country = user.getCountry();
	}
}
