package test;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class BaseRanner {

	protected WebDriver driver;
	protected String baseUrl;

	@Before
	public void setUp(){
		String driverName;
		if ((driverName = System.getProperty("browser")) == null)
			driverName = "heh";
		driver = BrowsersFactory.buildDriver(driverName);
		baseUrl = "https://www.tinkoff.ru/career/vacancies/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@After
	public void tearDown(){
		driver.quit();
	}
}
