package PracticeE2E.pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class commons {
	
	static WebDriver driver;
	By profileBtn = By.xpath("//p[@class='oxd-userdropdown-name']");
	By logoutBtn = By.xpath("//a[@href='/web/index.php/auth/logout']");

	public WebDriver setWebDriver(String browserType, String url) {
		if(browserType.contains("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}else if(browserType.contains("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}else {
			System.out.println("Invalid Browser Selection");
		}
			driver.manage().window().maximize();
			driver.get(url);
			return driver;
	}
	
	public void timeout() {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}
	
	public void openUrl(String url) {
		driver.get(url);
	}
	
	public void waitUntilvisible(By locator,int waitTime) {
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(waitTime));
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	public void logout() {
		driver.findElement(profileBtn).click();
		driver.findElement(logoutBtn).click();
	}
	
	public void closeSession() {
		this.driver.quit();
	}
	public commons(WebDriver driver) {
		this.driver=driver;
	}
}
