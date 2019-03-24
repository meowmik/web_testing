package test;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class BaseRanner {

	protected WebDriver driver;
	protected String baseUrl;

	@Before
	public void setUp(){
		/*System.setProperty("webdriver.gecko.driver", "C:\\BrowsersDrivers\\Mozilla Firefox\\geckodriver.exe");
		driver = new FirefoxDriver();*/
		System.setProperty("webdriver.chrome.driver", "C:\\BrowsersDrivers\\Google Chrome 73\\chromedriver.exe");
		driver = new ChromeDriver();
		baseUrl = "https://www.tinkoff.ru/career/vacancies/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@After
	public void tearDown(){
		driver.quit();
	}
}
