package com.CRM.TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.CRM.Pages.ContactsPage;
import com.CRM.Pages.HomePage;
import com.CRM.Pages.LoginPage;
import com.CRM.TestBase.TestBase;
import com.CRM.TestUtil.TestUtil;

public class ContactsPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtil Testutil;
	ContactsPage contactsPage;
	String sheetName = "contacts";
	
	public ContactsPageTest(){
			super();
			
	}
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		Testutil = new TestUtil();
		contactsPage = new ContactsPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		TestUtil.switchToFrame();
	}
	@DataProvider
	public Object[][] getCRMContactsTestData(){
		Object data[][] =TestUtil.getTestData(sheetName);
		return data;
	
	}
	@Test(priority =1,dataProvider = "getCRMContactsTestData" )
	public void validateCreatenewContact(String title, String firstname, String lastname, String company) {
		homePage.clickOnNewContactLink();
		//contactsPage.createNewContact("Mr.","David", "Peter", "Amazon");
		contactsPage.createNewContact(title, firstname, lastname, company);			
	}
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
