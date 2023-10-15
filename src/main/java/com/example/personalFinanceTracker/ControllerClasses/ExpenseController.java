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
import com.example.personalFinanceTracker.EntityClasses.CategoryEntity;
import com.example.personalFinanceTracker.EntityClasses.ExpenseEntity;
import com.example.personalFinanceTracker.EntityClasses.ExpenseModelClass;
import com.example.personalFinanceTracker.EntityClasses.UserEntity;
import com.example.personalFinanceTracker.Repository.CategoryRepository;
import com.example.personalFinanceTracker.Repository.ExpenseRepository;
import com.example.personalFinanceTracker.Repository.UserRepository;
import com.example.personalFinanceTracker.UtilClasses.Constant;

@RestController
public class ExpenseController {
	
	@Autowired
	private ExpenseRepository expenseRepository;
	
	@Autowired
    private UserRepository userRepository;
	
	@Autowired
    private CategoryRepository categoryRepository;
	
	@GetMapping(Constant.GET_ALL_EXPENSEINFO)
	ResponseEntity<List<ExpenseEntity>> getAllExpenseInfo()
	{
		List<ExpenseEntity> expenseEntity= expenseRepository.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(expenseEntity);
	}
	
	@GetMapping(Constant.GET_EXPENSEINFO_BY_ID)
	ResponseEntity<ExpenseEntity> getExpenseInfoById(@PathVariable int id)
	{
		ExpenseEntity expenseEntity = expenseRepository.findById(id).orElse(null);
		return ResponseEntity.status(HttpStatus.OK).body(expenseEntity);
	}

	@PostMapping(Constant.CREATE_EXPENSEINFO)
	ResponseEntity<String> createExpenseInfo(@RequestBody ExpenseEntity expenseEntity)
	{
		expenseEntity.setDate(LocalDate.now());
		expenseRepository.save(expenseEntity);
		return ResponseEntity.status(HttpStatus.CREATED).body("ExpenseInfo is sucessfully created.");
	}
	
	@PutMapping(Constant.UPDATE_EXPENSEINFO_BY_ID)
	ResponseEntity<String> updateExpenseInfoById(@RequestBody ExpenseModelClass expenseEntity,@PathVariable int id)
	{
		ExpenseEntity existingExpenseEntity = expenseRepository.findById(id).orElse(null);
		if(expenseEntity.getAmountExpense() != 0)
		existingExpenseEntity.setAmountExpense(expenseEntity.getAmountExpense());
		if(expenseEntity.getMerchantName() != null)
		existingExpenseEntity.setMerchantName(expenseEntity.getMerchantName());
		if(expenseEntity.getDate() != null)
		existingExpenseEntity.setDate(expenseEntity.getDate());
		List<CategoryEntity> categoryEntity = expenseEntity.getCategoryEntity();
		for(CategoryEntity categoryEntity1:categoryEntity)
		{
			int a = categoryEntity.indexOf(categoryEntity1);
			int id1 = expenseEntity.getCategoryId();
			CategoryEntity categoryEntity2 = categoryRepository.findById(id1).orElse(null);
			categoryEntity.set(a,categoryEntity2);
		}
		existingExpenseEntity.setCategoryEntities(categoryEntity);
		expenseRepository.save(existingExpenseEntity);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("ExpenseInfo updated By ID");
		
	}
	@DeleteMapping(Constant.DELETE_EXPENSEINFO_BY_ID)
	ResponseEntity<String> deleteExpenseInfoById(@PathVariable int id)
	{
		expenseRepository.deleteById(id);
		return ResponseEntity.status(HttpStatus.OK).body("ExpenseInfo is deleted sucessfull by:-" +id);
	}
}
