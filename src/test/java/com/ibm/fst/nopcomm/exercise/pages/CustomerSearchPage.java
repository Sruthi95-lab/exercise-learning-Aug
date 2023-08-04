package com.ibm.fst.nopcomm.exercise.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CustomerSearchPage {
	
	WebDriver driver;

	public CustomerSearchPage(WebDriver rdriver) {

		driver = rdriver;
		PageFactory.initElements(rdriver, this);

	}
	
	// Web Elements Repository

		// ************************************************//

		@FindBy(xpath = "//div[@class='content-header']")
		WebElement dashBoradWTxt;

		@FindBy(xpath = "//i[@class='nav-icon far fa-user']//following-sibling::p")
		WebElement customerTab;

		@FindBy(xpath = "//p[text()=' Customers']")
		WebElement customerSubTab;

		@FindBy(id = "SearchEmail")
		WebElement txtSearchEmail;

		@FindBy(css = "button#search-customers")
		WebElement btnSearch;

		@FindBy(xpath = "//a[text()='John Smith']")
		WebElement loginWTxt;

		@FindBy(xpath = "//table[@id='customers-grid']//tbody//tr")
		List<WebElement> rows;

		@FindBy(xpath = "//table[@id='customers-grid']//tbody//tr[1]//td")
		List<WebElement> cols;

		// ************************************************//

		// Actions or Methods on the login Page

		public void verifyOnHomePage(String expDBTxt) {

			// Verify Dashboard is visible on the screen after successful login

			Assert.assertEquals(dashBoradWTxt.getText(), expDBTxt);
			boolean isDisplay = loginWTxt.isDisplayed();
			Assert.assertTrue(isDisplay);

		}

		public void clickOnCustomerTab() {

			customerTab.click();
			customerSubTab.click();
		}

		public void searchCustomer(String criteria, String crtVal) throws InterruptedException {

			// search the Customer with specified criteria

			if (criteria.equals("email")) {

				txtSearchEmail.clear();
				txtSearchEmail.sendKeys(crtVal);
			}

			// click on search button
			btnSearch.click();
			Thread.sleep(1000);

		}

		public void validateCustResult(String email, String name) {

		
			int rowCount = rows.size();
			int colCount = cols.size();
			String emailVal = "";
			String nameVal = "";
			System.out.println(rowCount);
			System.out.println(colCount);
			for (int i = 1; i <= rowCount; i++) {
				
				emailVal =driver.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+i+"]/td[2]")).getText(); 
				nameVal =driver.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+i+"]/td[3]")).getText();
				if(emailVal.equalsIgnoreCase(email) && nameVal.equalsIgnoreCase(name)) {
					Assert.assertTrue(true); 
				}

		}

		}

}
