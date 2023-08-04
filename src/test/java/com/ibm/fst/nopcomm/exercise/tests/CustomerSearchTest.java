package com.ibm.fst.nopcomm.exercise.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ibm.fst.nopcomm.exercise.utility.BaseTest;

public class CustomerSearchTest extends BaseTest {
	
	@DataProvider(name="CustomerSearch")
	public Object[][] getTestData(){
		return new Object[][] {
			{"admin@yourstore.com","admin",false,"Dashboard","email","admin@yourstore.com","John Smith"}
			
		};
	}
	
	@Test(dataProvider = "CustomerSearch")
	public void verifyCustomerFunctionality(String username,String password,boolean remCheck,String dashBoardtxt,
			String criteria, String criteriaValue,String name ) throws Exception {
		
		// Call the loginPage actions
		loginPage.logIn(username, password, remCheck);
		
		// Call the CustomerSearchPage actions
		custSearchPage.verifyOnHomePage(dashBoardtxt);
		
		
		// Call the CustomerSearchPage actions
		custSearchPage.clickOnCustomerTab();
		
		
		// Call the CustomerSearchPage actions
		custSearchPage.searchCustomer(criteria, criteriaValue);
		
		
		// Call the CustomerSearchPage actions
		custSearchPage.validateCustResult(criteriaValue,name);
		
	}

}
