package in.amazone.test;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import in.amazone.pages.TestBaseAmazone;

public class E2ETest extends TestBaseAmazone {
	
	
	@BeforeSuite
	public void suiteMethod() throws Exception {
		
		System.out.println("before suite..");
		
	}
	
	@BeforeClass
	public void classMethod() throws Exception {
		System.out.println("before class..");
		setup();
	
	}
	
	@BeforeMethod
	public void beforeMethod() throws IOException {	
		System.out.println("before method..");
		open();
		//load();
		
	}
	
	@Test
	public void TC001_test1() throws Exception {

		System.out.println("Welcome code is running successfully...");
//		login.click();
//		username.sendkeys();
//		password.sendkeys();
//		loginbtn.click();
//		searchProduct.sendkeys();
//		getSearchResults();
		
		
	}
	
	@AfterMethod
	public void afterMethod() {
		
		System.out.println("after method");
		
	}
	
	@AfterClass
	public void afterClassMethod() {
		System.out.println("after class method");
	}
	
	@AfterSuite
	public void afterSuiteMethod() {
		System.out.println("after suit mehtod...");
	}

	
	
}
