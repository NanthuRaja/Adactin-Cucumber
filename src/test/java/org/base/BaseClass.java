package org.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class BaseClass {

	 public static WebDriver driver;

	public WebDriver getdriver() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Driver\\chromedriver.exe");
		return driver = new ChromeDriver();

	}

	public void implicitWait(int sec) {
		driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);

	}

	public void maximize() {
		driver.manage().window().maximize();

	}

	public void loadUrl(String url) {
		driver.get(url);
		implicitWait(10);
		maximize();
	}

	public void enterText(WebElement element, String text) {
		element.sendKeys(text);

	}

	public void click(WebElement element) {

		element.click();
	}
	
	public void getText(WebElement element) {
		String text = element.getText();
		System.out.println(text);

	}
	
	public String getAttribute(WebElement element) {
		String attribute = element.getAttribute("value");
		return attribute;
		

	}

	public void selectByVisibleText(WebElement element, String text) {

		new Select(element).selectByVisibleText(text);
	}

	public void quit() {
		driver.quit();

	}
}
