package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class BrowsersFactory {
	public static WebDriver buildDriver(String driverName, String driverPath){
		System.setProperty(driverName, driverPath);
		switch (driverName) {
			case "webdriver.chrome.driver":
				return new ChromeDriver();
			case "webdriver.gecko.driver":
				return new FirefoxDriver();
			default:
				//сюда не уходит, но надо было завершение сделать
				return new ChromeDriver();
		}
	}
}
