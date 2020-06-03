package com.ocsc.poc.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDetails {

	@Getter
	@Setter
	private Integer userId;
	@Getter
	@Setter
	private String userName;
	@Getter
	@Setter
	private String mobileNumber;
	@Getter
	@Setter
	private String emailId;

}
