package com.example.personalFinanceTracker.ControllerClasses;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.personalFinanceTracker.EntityClasses.UserEntity;
import com.example.personalFinanceTracker.Repository.UserRepository;
import com.example.personalFinanceTracker.UtilClasses.Constant;

@RestController
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping(Constant.GET_ALL_USERS)
	ResponseEntity<List<UserEntity>> getAllUser()
	{
		List<UserEntity> userEntity = userRepository.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(userEntity);
	}
   
	@GetMapping(Constant.GET_USER_BY_USERID)
	ResponseEntity<UserEntity> getUserByUserId(@PathVariable int id)
	{
		UserEntity userEntity = userRepository.findById(id).orElse(null);
		return ResponseEntity.status(HttpStatus.OK).body(userEntity);
	}
	
	@PostMapping(Constant.CREATE_NEW_USER)
	ResponseEntity<String> createUserNewUser(@RequestBody UserEntity userEntity)
	{
		 userRepository.save(userEntity);
		return ResponseEntity.status(HttpStatus.CREATED).body("User Sucessfully created");
	}
	
	@PutMapping(Constant.UPDATE_DATA_BY_USERID)
	ResponseEntity<String> updateUserData(@RequestBody UserEntity userEntity,@PathVariable int id)
	{	
		UserEntity existingUserEntity = userRepository.findById(id).orElse(null);
		if(userEntity.getUserName() != null)
		existingUserEntity.setUserName(userEntity.getUserName());
		if(userEntity.getEmailId() != null)
		existingUserEntity.setEmailId(userEntity.getEmailId());
		if(userEntity.getPassword() != null)
		existingUserEntity.setPassword(userEntity.getPassword());
		userRepository.save(existingUserEntity);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("user data Data Updated sucessfully");
	}
	
	@DeleteMapping(Constant.DELETE_USER_BY_USERID)
	ResponseEntity<String>deleteUserByUserId(@PathVariable int id)
	{
		userRepository.deleteById(id);
		return ResponseEntity.status(HttpStatus.OK).body("User Successfully deleted");
		
	}
}
