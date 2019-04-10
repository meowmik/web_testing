package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.util.HashSet;

public class Page {
	Logger logger = LoggerFactory.getLogger(Page.class);

	protected WebDriver driver;
	protected WebDriverWait wait;

	public Page(WebDriver driver){
		this.driver = driver;
		wait = new WebDriverWait(driver, 10);
	}


	public void closeSearchTab(){
		HashSet<String> windows = (HashSet<String>) driver.getWindowHandles();
		driver.switchTo().window(windows.toArray()[0].toString());
		try {
			driver.close();
			logger.info("Вкладка поиска закрыта");
		}catch (Exception e){
			logger.error("Вкладка поиска не закрыта");

		}
	}

	public void checkOrderButtonForActivity(){
		try {
			driver.findElement(By.xpath("//div[@class='LoaderRound__container_no-background_GvpfD LoaderRound__container_coverParent_2-_fi']")).isEnabled();
			logger.info("Кнопка активациии симкарты осталась активной");
		}
		catch (Exception e){
			System.out.println("кнопка активации симкарты не активна");
		}
	}

	public void checkOpenTabLink(String url){
		if(!driver.getCurrentUrl().equals(url))
			logger.error("У вкладки не верный Url и равен: " + driver.getCurrentUrl());
		else logger.info("У вкладки нужный Url");
	}

	public void getPage(String url) {
		driver.navigate().to(url);
	}



}
