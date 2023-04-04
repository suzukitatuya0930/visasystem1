package com.example.demo.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class LoginUserModel implements Serializable{
	
	private String name;
	private String password;
	private String email;
	private String visa;
	private String visatype;
	

}
