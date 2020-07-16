package com.app.RestController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.Entity.UserEntity;
import com.app.model.User;
import com.app.service.UserServiceImpl;

@RestController
public class UserRestController {
	
	@Autowired
	private UserServiceImpl userService;
	
	
	@PostMapping(value="/save",consumes="application/json")
	public String saveUserDtls(@RequestBody User user) {
		UserEntity userEntity=userService.saveUser(user);
		Integer id=userEntity.getUserId();
		
		return "User Created Successfully With ID:"+id;
		
	}
	
	@GetMapping(value="getusers",produces="application/json")
	public String getAllUsers(){
		
		List<UserEntity> list=userService.getAllUsers();
		if(list!=null) {
		return "User List"+list;
		}else
			return "No Data Found";
	}
	
	@GetMapping(value="getoneuser/{userId}",produces="application/json")
	public String getUserDtlsById(@PathVariable Integer userId ) {
		
		
		Optional<UserEntity> entity=userService.getUserById(userId);
		if(entity.isPresent()) {
			return "Data"+entity;
		}
		
		return "No Data found";
	}

}
