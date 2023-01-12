package PracticeE2E.testClasses;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PracticeE2E.pageObjects.HomePage;
import PracticeE2E.pageObjects.Login;
import PracticeE2E.pageObjects.commons;

public class Test1{
	
	
		public WebDriver driver;
		String un="Admin", pw="admin123";
		String browser="chrome";
		String site="https://opensource-demo.orangehrmlive.com/";
		commons common = new commons(driver);
		Login login;
		HomePage hp;
		
		@BeforeTest
		public void systemSetup() {
			driver=common.setWebDriver(browser,site);
			common.timeout();
			login = new Login(driver);
			hp = new HomePage(driver);
		}

		@Test(priority=1)
		public void login() {
			login.login(un, pw);
			hp.homeValidation();
		}
		
		@Test
		public void getInfo() {
			
		}
		
		@AfterTest
		public void close() {
			common.logout();
			common.closeSession();
		}
	
	}
	
