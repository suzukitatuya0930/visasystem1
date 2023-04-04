package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.demo.model.LoginUserModel;

@Repository
@Mapper

public interface LoginUserMapper {

	int count(LoginUserModel loginUser);

}
