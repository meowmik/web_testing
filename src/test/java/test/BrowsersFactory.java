package test;
import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.io.File;



public class BrowsersFactory {

	public static class MyListener extends AbstractWebDriverEventListener {
		Logger logger = LoggerFactory.getLogger(BrowsersFactory.class);

		@Override
		public void beforeFindBy(By by, WebElement element, WebDriver driver){
			logger.info("Обращение к элементу " + by);
		}

		@Override
		public void afterFindBy(By by, WebElement element, WebDriver driver){
			logger.info("Найден элемент " + by);
		}

		@Override
		public void onException(Throwable throwable, WebDriver driver) {
			File tmp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			File file = new File("target", "sccreen-" + System.currentTimeMillis() + ".png");
			try {
				Files.copy(tmp, file);
			} catch (IOException e) {
				e.printStackTrace();
				logger.error(file.getAbsolutePath());
			}
		}
	}


	public static WebDriver buildDriver(String driverName, String driverPath){
		System.setProperty(driverName, driverPath);
		switch (driverName) {
			case "webdriver.chrome.driver":
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--disable-notifications");
				return new ChromeDriver(options);
			case "webdriver.gecko.driver":
				return new FirefoxDriver();
			default:
				//сюда не уходит, но надо было завершение сделать
				return new ChromeDriver();
		}
	}
}
