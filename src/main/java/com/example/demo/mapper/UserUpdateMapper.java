package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.UserUpdateModel;

@Repository
@Mapper
public interface UserUpdateMapper {
	
	List<UserUpdateModel> checkall(UserUpdateModel userUpdateModel);
	List<UserUpdateModel> selectusername(String email);
	List<UserUpdateModel> userupdate(@Param(value = "id") int id);
	int update1(UserUpdateModel id);

}