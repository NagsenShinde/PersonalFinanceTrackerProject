package com.example.personalFinanceTracker.EntityClasses;

import java.time.LocalDate;
import java.util.ArrayList;
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
@Table(name ="income_table")
public class IncomeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "income_id")
	@JsonProperty("income-id")
	private int incomeId;

	@Column(name = "income_source")
	@JsonProperty("income-source")
	private String incomeSource;
	
	@Column(name = "income_amount")
	@JsonProperty("income-amount")
	private int incomeAmount;
	
	@Column(name = "date_of_income")
	@JsonProperty("date-of-income")
	private LocalDate dateOfIncome;

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
	
	@OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH},targetEntity = UserEntity.class)
	@JoinColumn(name = "user_id")
	@JsonProperty("user-entity")
	public List<UserEntity> userEntity;

	public List<UserEntity> getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(List<UserEntity> userEntity) {
		if(this.userEntity == null)
		{
			this.userEntity	= new ArrayList<>();
		}
		this.userEntity.addAll(userEntity);
	}

	@Override
	public String toString() {
		return "IncomeEntity [incomeId=" + incomeId + ", incomeSource=" + incomeSource + ", incomeAmount="
				+ incomeAmount + ", dateOfIncome=" + dateOfIncome + ", userEntity=" + userEntity + "]";
	}
	
	
	
}
