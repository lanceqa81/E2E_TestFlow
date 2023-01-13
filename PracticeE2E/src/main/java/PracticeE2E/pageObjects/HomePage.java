package PracticeE2E.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage {
	
	WebDriver driver;
	By pageTitle=By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']");
	By infoBtn=By.xpath("//a[@class='oxd-main-menu-item active']");
	By profileBtn = By.xpath("//p[@class='oxd-userdropdown-name']");
	By logoutBtn = By.xpath("//a[@href='/web/index.php/auth/logout']");
	By supportBtn = By.xpath("//a[@href='/web/index.php/help/support']");
	By custSupport = By.xpath("//a[@class='orangehrm-support-link']");
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
		driver.findElement(infoBtn).click();
		String header= driver.findElement(pageTitle).getText();
		if(header.contains("PIM")) {
			System.out.println("Landed on Info Page");
		}else {
			System.out.println("Failed to load Info page");
		}
	}
	
	public void clickSupport() {
			driver.findElement(profileBtn).click();
			driver.findElement(supportBtn).click();
			String getSupportDetail = driver.findElement(custSupport).getText();
			Assert.assertEquals(getSupportDetail, "ossuport@orangehrm.com");
			System.out.println("Support Page Displayed");
		}
	
	public void logout() {
		driver.findElement(profileBtn).click();
		driver.findElement(logoutBtn).click();
	}
	

}
