package com.example.demo.model;

import java.io.Serializable;

import lombok.Data;
@Data
public class NewUserModel implements Serializable {
	private static final long serialVersionUID = 1L;
	

	private String name;
	private String password;
	private String address;
	private String visa;
	private String visatype;
	
	

}
