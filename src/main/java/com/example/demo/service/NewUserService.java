package com.example.demo.service;

import com.example.demo.model.NewUserModel;

public interface NewUserService {
	public   Object insert(NewUserModel newUser);
	public int search(NewUserModel newUserModel);

}
