package app;

import org.openqa.selenium.*;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import pages.GooglePage;
import pages.TinkoffMobileOperator;
import test.BrowsersFactory;
import java.util.concurrent.TimeUnit;


public class Application {
	Logger logger = LoggerFactory.getLogger(Application.class);
	private WebDriver driver;
	private WebDriverWait wait;
	public final String driverName = "webdriver.chrome.driver";
	public final String driverPath = "C:\\BrowsersDrivers\\Google Chrome 73\\chromedriver.exe";
	public TinkoffMobileOperator tinkoffmob;
	public GooglePage google;

	public Application(){
		driver = new EventFiringWebDriver(getDriver());
		((EventFiringWebDriver) driver).register(new BrowsersFactory.MyListener());
		wait = new WebDriverWait(driver, 10);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		//pages
		google = new GooglePage(driver);
		tinkoffmob = new TinkoffMobileOperator(driver);

	}

	public void quit() {
		driver.quit();
		driver = null;
	}

	private WebDriver getDriver() {
		return BrowsersFactory.buildDriver(driverName,driverPath);
	}


}
