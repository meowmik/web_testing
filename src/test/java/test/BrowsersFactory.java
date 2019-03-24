package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowsersFactory {
	public static WebDriver buildDriver(String browserName){
		switch (browserName){
			case "google":
				System.setProperty("webdriver.chrome.driver", "C:\\BrowsersDrivers\\Google Chrome 73\\chromedriver.exe");
				return new ChromeDriver();
			case "mazilla":
				System.setProperty("webdriver.gecko.driver", "C:\\BrowsersDrivers\\Mozilla Firefox\\geckodriver.exe");
				return new FirefoxDriver();
			default:
				System.setProperty("webdriver.chrome.driver", "C:\\BrowsersDrivers\\Google Chrome 73\\chromedriver.exe");
				return new ChromeDriver();
		}
	}
}
