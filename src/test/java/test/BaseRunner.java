package test;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class BaseRunner {

	protected WebDriver driver;
	protected String baseUrl;
	
	protected void testBrowsers(String[] driverAttributes){
		driver = BrowsersFactory.buildDriver(driverAttributes[0], driverAttributes[1]);
		baseUrl = "https://www.tinkoff.ru/career/vacancies/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Before
	public void setUp(){
		String driverName = System.getProperty("browser");
		HashMap<String, String[]> map = new HashMap<>();
		String[] google = {"webdriver.chrome.driver", "C:\\BrowsersDrivers\\Google Chrome 73\\chromedriver.exe"};
		map.put("google", google);
		String[] mazilla = {"webdriver.gecko.driver", "C:\\BrowsersDrivers\\Mozilla Firefox\\geckodriver.exe"};
		map.put("mazilla", mazilla);
		if (driverName == null) {
			testBrowsers(map.get("google"));
		} else{
			if(map.containsKey(driverName))
				testBrowsers(map.get(driverName));
			else {
				StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
				System.err.printf("Driver name is not correct. Tests will not be executed.\n");
				for (int i = 0; i < stackTrace.length; i++)
					System.err.printf(stackTrace[i].toString() + "\n");
			}
		}
		
	}

	@After
	public void tearDown(){
		driver.quit();
	}
}
