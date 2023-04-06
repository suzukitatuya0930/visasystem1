package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.demo.model.LoginUserModel;

@Repository
@Mapper

public interface LoginUserMapper {

	int count(LoginUserModel loginUser);
	
	List<LoginUserModel>getUser();

	List<LoginUserModel> user(LoginUserModel loginUserModel);

}
