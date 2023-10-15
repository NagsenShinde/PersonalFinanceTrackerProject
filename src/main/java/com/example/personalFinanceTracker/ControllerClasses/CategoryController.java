package com.example.personalFinanceTracker.ControllerClasses;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.personalFinanceTracker.EntityClasses.CategoryEntity;
import com.example.personalFinanceTracker.Repository.CategoryRepository;
import com.example.personalFinanceTracker.Repository.UserRepository;

@RestController
public class CategoryController {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/getAllCategoryInfo")
	ResponseEntity<List<CategoryEntity>> getAllCategoryInfo()
	{
		List<CategoryEntity> categoryEntity = categoryRepository.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(categoryEntity);
	}

}
