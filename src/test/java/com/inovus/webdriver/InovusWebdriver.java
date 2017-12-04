package com.inovus.webdriver;

import java.util.concurrent.TimeUnit;

import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class InovusWebdriver {

	static final long MAX_WAIT_MILLI_SEC = 30000;
	static WebDriver driver;
	static String username = "chandra.shekar";
	static String pwd = "cha_th222";

	
	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.gecko.driver", "C:\\SeleniumGecko\\geckodriver.exe");		
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		homePage();
	}

	protected static void homePage() {
		driver.get("https://www.inovus.net/userlogin");
	}
	
	
	protected boolean sleepForPageContains(String containString) {
	    long end;
	    boolean result = false;
	    end = System.currentTimeMillis() + MAX_WAIT_MILLI_SEC;
	    while (System.currentTimeMillis() < end) {
	      result = driver.getPageSource().contains(containString);
	      if (result == true) {
	        return result;
	      }
	    }
	    return result;
	  }
	
	protected static void login() {
		WebElement userNameElement = driver.findElement(By.id("username"));
		userNameElement.clear();
		userNameElement.sendKeys(username);
		
		WebElement pwdElement = driver.findElement(By.id("passwordeye"));
		pwdElement.clear();
		pwdElement.sendKeys(pwd);
		
		WebElement loginButton = driver.findElement(By.className("SubmitBtn"));
		loginButton.click();
	}
	
}
