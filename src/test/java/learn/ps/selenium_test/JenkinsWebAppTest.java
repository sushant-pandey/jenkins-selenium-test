package learn.ps.selenium_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class JenkinsWebAppTest {
	WebDriver driver;
	
	@BeforeTest
	public void openApplication() {
		String pwd = System.getProperty("user.dir");
		System.out.println(pwd);
		System.setProperty("webdriver.gecko.driver", pwd + "\\src\\test\\resources\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:7070/JenkinsWebApp/");
	}
	
	@Test
	public void verifyContent() {
		By h2loc = By.tagName("h2");
		String bodyContent = driver.findElement(h2loc).getText();
		System.out.println(bodyContent);
		
		Assert.assertTrue(bodyContent.contains("Hello World! This is my application for jenkins ( tomcat ) deployment"));
		
	}
	
	@AfterTest
	public void cleanUp() {
		driver.quit();
	}

}
