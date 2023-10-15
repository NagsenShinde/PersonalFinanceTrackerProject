package com.example.personalFinanceTracker.ControllerClasses;

import java.time.LocalDate;
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
import com.example.personalFinanceTracker.EntityClasses.IncomeEntity;
import com.example.personalFinanceTracker.EntityClasses.IncomeModelClass;
import com.example.personalFinanceTracker.EntityClasses.UserEntity;
import com.example.personalFinanceTracker.Repository.IncomeRepository;
import com.example.personalFinanceTracker.Repository.UserRepository;
import com.example.personalFinanceTracker.UtilClasses.Constant;

@RestController
public class IncomeController {
	
	@Autowired
	private IncomeRepository incomeRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping(Constant.GET_ALL_INCOMEINFO)
	ResponseEntity<List<IncomeEntity>> getAllIncomeInfo()
	{
		List<IncomeEntity> incomeEntity =	incomeRepository.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(incomeEntity);
	}
	
	@PostMapping(Constant.CREATE_NEW_INCOMEINFO)
	ResponseEntity<String> createIncomeInfo(@RequestBody IncomeEntity incomeEntity)
	{
		incomeEntity.setDateOfIncome(LocalDate.now());
		incomeRepository.save(incomeEntity);
		return ResponseEntity.status(HttpStatus.CREATED).body("Income Information is created");
	}
	
	@GetMapping(Constant.GET_INCOMEINFO_BY_ID)
	ResponseEntity<IncomeEntity> getIncomeInfoById(@PathVariable int id)
	{
		IncomeEntity incomeEntity = incomeRepository.findById(id).orElse(null);
		return ResponseEntity.status(HttpStatus.OK).body(incomeEntity);
	}

	@PutMapping(Constant.UPDATE_INCOMEINFO_BY_ID)
	ResponseEntity<String> updateIncomeById(@RequestBody IncomeModelClass incomeEntity ,@PathVariable int id)
	{
		IncomeEntity existingIncomeEntity = incomeRepository.findById(id).orElse(null);
		if(incomeEntity.getIncomeAmount() != 0) {
		existingIncomeEntity.setIncomeAmount(incomeEntity.getIncomeAmount());
		}
		if(incomeEntity.getIncomeSource()!= null) {
		existingIncomeEntity.setIncomeSource(incomeEntity.getIncomeSource());
		}
		List<UserEntity> userEntity = incomeEntity.getUserEntity();
		for(UserEntity userEntity1:userEntity)
		{
			int a = userEntity.indexOf(userEntity1);
		    int userId = userEntity1.getUserId();
		    UserEntity userEntity2 = userRepository.findById(userId).orElse(null);
		    userEntity.set(a, userEntity2);
		}
		existingIncomeEntity.setUserEntity(userEntity);
		incomeRepository.save(existingIncomeEntity);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Income information sucessfully updated");
	}
	
	@DeleteMapping(Constant.DELETE_INCOMEINFO_BY_ID)
	ResponseEntity<String> deleteIncomeInfoById(@PathVariable int id)
	{
		incomeRepository.deleteById(id);
		return ResponseEntity.status(HttpStatus.OK).body("Income Information is Sucessfully Deleted");
		
	}

}
