package PracticeE2E.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage {
	
	WebDriver driver;
	By pageTitle=By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']");
	By infoBtn=By.xpath("//a[@class='oxd-main-menu-item active']");
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void homeValidation() {
		String header= driver.findElement(pageTitle).getText();
		if(header.contains("Dashboard")) {
			System.out.println("Landed on home Page");
		}else {
			System.out.println("Failed to load home page");
		}
	}
	
	public void clickMyInfo() {
		
	}
	
	

}
