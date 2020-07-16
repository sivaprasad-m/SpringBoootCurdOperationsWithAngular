package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Entity.UserEntity;
import com.app.Repository.UserRepository;
import com.app.model.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepo;
	

	@Override
	public UserEntity saveUser(User user) {
		UserEntity entity=new UserEntity();
		BeanUtils.copyProperties(user, entity);
		UserEntity userEntity=userRepo.save(entity);
		return userEntity;
	}


	@Override
	public List<UserEntity> getAllUsers() {
		List<UserEntity> list=userRepo.findAll();
		
		return list;
		
	}


	@Override
	public Optional<UserEntity> getUserById(Integer userId) {
		
		Optional<UserEntity> entity=userRepo.findById(userId);
		if(entity.isPresent()) {
			return entity;
		}
		return null;
		
	}

}
