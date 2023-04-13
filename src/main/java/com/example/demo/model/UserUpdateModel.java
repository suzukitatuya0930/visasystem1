package com.example.demo.model;

import java.io.Serializable;

import lombok.Data;
@Data
public class UserUpdateModel implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String name;
	private String password;
	private String email;
	private String visa;
	private String visatype;
	private String remaining;
	private String address;
	
	
	
	
	
}
