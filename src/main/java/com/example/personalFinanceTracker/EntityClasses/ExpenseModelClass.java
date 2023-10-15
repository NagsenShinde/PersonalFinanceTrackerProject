package com.example.personalFinanceTracker.EntityClasses;

import java.time.LocalDate;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ExpenseModelClass {
	
	@JsonProperty("expense-id")
	private int expenseId;
	
	@JsonProperty("category-id")
	private int categoryId;
	
	@JsonProperty("merchant-name")
	private String merchantName;
	
	@JsonProperty("amount-expense")
	private int amountExpense;
	
	@JsonProperty("date")
	private LocalDate date;
	
	
	private List<CategoryEntity> categoryEntity;

	public int getExpenseId() {
		return expenseId;
	}

	public void setExpenseId(int expenseId) {
		this.expenseId = expenseId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public int getAmountExpense() {
		return amountExpense;
	}

	public void setAmountExpense(int amountExpense) {
		this.amountExpense = amountExpense;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}


	public List<CategoryEntity> getCategoryEntity() {
		return categoryEntity;
	}

	public void setCategoryEntity(List<CategoryEntity> categoryEntity) {
		this.categoryEntity = categoryEntity;
	}

	@Override
	public String toString() {
		return "ExpenseModelClass [expenseId=" + expenseId + ", categoryId=" + categoryId + ", merchantName="
				+ merchantName + ", amountExpense=" + amountExpense + ", date=" + date + ", userEntity=" +" categoryEntity=" + categoryEntity + "]";
	}

}
