package PracticeE2E.pageObjects;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Login{
	
	WebDriver driver;
	By enterUn = By.name("username");
	By enterPw = By.name("password");
	By loginBtn = By.xpath("//div[@class='oxd-form-actions orangehrm-login-action']/button");
	By forgotPwd = By.xpath("//div[@class='orangehrm-login-forgot']");
	By resetPageTitle =By.xpath("//h6[contains(text(),'Reset Password')]");
	By resetBtn = By.xpath("//button[@type='submit']");
	By linkSentTitle = By.xpath("//h6[@class='oxd-text oxd-text--h6 orangehrm-forgot-password-title']");
	
	
	public Login(WebDriver driver) {
		this.driver=driver;
	}
	
	public void login(String un, String pw) {
		driver.findElement(enterUn).sendKeys(un);
		driver.findElement(enterPw).sendKeys(pw);
		driver.findElement(loginBtn).click();
	}
	
	public void recoverPw(String un) {
		driver.findElement(forgotPwd).click();
		if(driver.findElement(resetPageTitle).isDisplayed()) {
			driver.findElement(enterUn).sendKeys(un);
			driver.findElement(resetBtn).click();
			String confirmText= driver.findElement(linkSentTitle).getText();
			Assert.assertEquals(confirmText,"Reset Password link sent successfully");
			System.out.println("Password reset link sent. Check mail");
		}
	}


}
