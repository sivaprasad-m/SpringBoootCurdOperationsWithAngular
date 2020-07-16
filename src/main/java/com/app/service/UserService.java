package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.Entity.UserEntity;
import com.app.model.User;

public interface UserService {
	
	public UserEntity saveUser(User user);
	public List<UserEntity> getAllUsers();
	public Optional<UserEntity> getUserById(Integer userId);

}
