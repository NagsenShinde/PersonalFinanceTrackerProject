package com.example.personalFinanceTracker.EntityClasses;

import java.time.LocalDate;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "expense")
public class ExpenseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "expense_id")
	@JsonProperty("expense-id")
	private int expenseId;
	
	
	@Column(name = "merchant_name")
	@JsonProperty("merchant-name")
	private String merchantName;
	
	
	@Column(name = "amount_expense")
	@JsonProperty("amount-expense")
	private int amountExpense;
	
	
	@Column(name = "date")
	@JsonProperty("date")
	private LocalDate date;

	
	public int getExpenseId() {
		return expenseId;
	}

	public void setExpenseId(int expenseId) {
		this.expenseId = expenseId;
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
	
	@OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH},targetEntity = CategoryEntity.class)
	@JoinColumn(name = "category_id")
	@JsonProperty("category")
	private List<CategoryEntity> categoryEntities;
	
	public List<CategoryEntity> getCategoryEntities() {
		return categoryEntities;
	}

	public void setCategoryEntities(List<CategoryEntity> categoryEntities) {
		this.categoryEntities = categoryEntities;
	}

	@Override
	public String toString() {
		return "ExpenseEntity [expenseId=" + expenseId + ", merchantName=" + merchantName + ", amountExpense="
				+ amountExpense + ", date=" + date + ", categoryEntities="
				+ categoryEntities + "]";
	}

		
}
