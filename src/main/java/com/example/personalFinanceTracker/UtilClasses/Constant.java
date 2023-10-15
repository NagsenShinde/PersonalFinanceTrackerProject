package com.example.personalFinanceTracker.UtilClasses;

public class Constant {
	
	//UserDetails EndPoints
	public final static String GET_ALL_USERS = "/getAllUsers";
	public final static String GET_USER_BY_USERID = "/getUserById/{id}";
	public final static String CREATE_NEW_USER = "/createNewUser";
	public final static String UPDATE_DATA_BY_USERID ="/updateDataByUserId/{id}";
	public final static String DELETE_USER_BY_USERID = "/deleteUserByUserId/{id}";
	
	//IncomeInfo Endpoints
	public final static String GET_ALL_INCOMEINFO = "/getAllIncomeInfo";
	public final static String GET_INCOMEINFO_BY_ID = "/getIncomeInfoById/{id}";
	public final static String CREATE_NEW_INCOMEINFO = "/createImcomeInformation";
	public final static String UPDATE_INCOMEINFO_BY_ID = "/updateIncomeInfoById/{id}";
	public final static String DELETE_INCOMEINFO_BY_ID = "/deleteIncomeInfoById/{id}";
	
	//Expense Endpoints
	public final static String GET_ALL_EXPENSEINFO = "/getAllExpenseInfo";
	public final static String GET_EXPENSEINFO_BY_ID = "/getExpenseInfoById/{id}";
	public final static String CREATE_EXPENSEINFO = "createExpenseInfo";
	public final static String UPDATE_EXPENSEINFO_BY_ID = "/updateExpenseInfoById/{id}";
	public final static String DELETE_EXPENSEINFO_BY_ID = "/deleteExpenseInfoById/{id}";
	
}
