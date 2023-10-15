package com.example.personalFinanceTracker.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.personalFinanceTracker.EntityClasses.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

	  
}
