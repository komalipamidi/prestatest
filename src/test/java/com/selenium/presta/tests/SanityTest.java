package com.selenium.presta.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.selenium.presta.CommonCode;
import com.selenium.presta.Configuration;
import com.selenium.presta.Elements;
import com.selenium.presta.MyAccount;
import com.selenium.presta.SeleniumEasyAccount;

public class SanityTest extends TestngAnnotationsTest {
	public MyAccount account;
public SeleniumEasyAccount easyaccount;
	public SanityTest() {

		//commons = new CommonCode();
		account = new MyAccount();
		easyaccount=new SeleniumEasyAccount();
	}

	@Test(priority = 1,testName = "login_Positive", description = "login_Positive", timeOut = 190000, enabled = true, groups = {
			"presta", "1" })
	public void alogin_Positive() {
		Assert.assertTrue(true);

	}

	@Test(priority = 2,testName = "login_Negative", description = "login_Negative", timeOut = 190000, enabled =true, groups = {
			"presta", "2" })
	public void login_Negative() throws InterruptedException {

		Reporter.log("Test case 2 is running...!", true);
		home.LogOut();
		login.LogintoApp("xyz", "xyz");
		login.ValidateErrormsg();
		login.LogintoApp(Configuration.loginUserName(), Configuration.Loginpassword());

		Reporter.log("Test case 2 passed...!", true);
		CommonCode.wait(5);
	}

	 @Test(priority = 3, testName = "Searchproduct", description = "Searching for product", enabled = true, groups = {"presta", "3" })
		public void Searchproduct() throws InterruptedException {
			 //Commoncode.wait(1);
			Reporter.log("Executing Second Test Case..!!", true);
			account.searchItem();
			
		}
/*
		 @Test(priority = 10, testName = "test2", description = "test 2 in selnium easy", enabled = false)
			public void test2() throws InterruptedException {
			 Reporter.log("Executing eight test case..!",true);
			 easyaccount.test2();
		 }
		 @Test(priority = 11, testName = "test3", description = "test 1 in selenium easyy ", enabled = false)
			public void test3() throws InterruptedException {
			 Reporter.log("Executing nineth test case..!",true); 
			 easyaccount.test3();
	}

		 @Test(priority = 12, testName = "test4", description = "test 2 in selnium easy", enabled = false)
			public void test4() throws InterruptedException {
			 Reporter.log("Executing eight test case..!",true);
			 easyaccount.test4();
	}
		 
		 */
	}

