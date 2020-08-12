package com.ocsc.poc.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LoginDetails {

	@Getter
	@Setter
	private String emailId;
	@Getter
	@Setter
	private String password;

}
