package com.example.demo.service;

import java.util.List;

import com.example.demo.model.NewUserModel;

public interface NewUserService {
	public   Object insert(NewUserModel newUser);
	public int search(NewUserModel newUserModel);
	public List<NewUserModel> user(NewUserModel newUserModel);
	
	public int delete (NewUserModel newUserModel);
	 public List<NewUserModel>checkall (NewUserModel newUserModel);
	 public int update(NewUserModel newUserModel);
	 public List<NewUserModel>selectupdate(NewUserModel newUserModel);

}
