package com.example.personalFinanceTracker.EntityClasses;

import java.time.LocalDate;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class IncomeModelClass {

	@JsonProperty("income-id")
	private int incomeId;
	
	@JsonProperty("income-source")
	private String incomeSource;
	
	@JsonProperty("income-amount")
	private int incomeAmount;
	
	@JsonProperty("date-o-income")
	private LocalDate dateOfIncome;
	
	@JsonProperty("user-entity")
	public List<UserEntity> userEntity;

	public int getIncomeId() {
		return incomeId;
	}

	public void setIncomeId(int incomeId) {
		this.incomeId = incomeId;
	}

	public String getIncomeSource() {
		return incomeSource;
	}

	public void setIncomeSource(String incomeSource) {
		this.incomeSource = incomeSource;
	}

	public int getIncomeAmount() {
		return incomeAmount;
	}

	public void setIncomeAmount(int incomeAmount) {
		this.incomeAmount = incomeAmount;
	}

	public LocalDate getDateOfIncome() {
		return dateOfIncome;
	}

	public void setDateOfIncome(LocalDate dateOfIncome) {
		this.dateOfIncome = dateOfIncome;
	}

	public List<UserEntity> getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(List<UserEntity> userEntity) {
		this.userEntity = userEntity;
	}

	@Override
	public String toString() {
		return "IncomeModelClass [incomeId=" + incomeId + ", incomeSource=" + incomeSource + ", incomeAmount="
				+ incomeAmount + ", dateOfIncome=" + dateOfIncome + ", userEntity=" + userEntity + "]";
	}
	
	
}
