package app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class Select {

	public static void chooseFromListForCalls (WebDriver driver, String xpathText ){

		driver.findElement(By.xpath("//body//div[@class='UIFormWrapper__container_1TIK8']//div[@data-qa-file='UIFormWrapper']//div[@data-qa-file='UIFormWrapper']//div[2]//div[1]//div[1]//div[1]//div[1]//div[1]//div[1]//div[2]")).click();
	Actions actions1 = new Actions(driver);
		actions1.moveToElement(driver.findElement(By.xpath(xpathText)))
				.click()
				.perform();
	}

	public static void choseFromListForInternet (WebDriver driver, String xpathText){
		driver.findElement(By.xpath("//div[@class='ui-form__fieldset ui-form__fieldset_inline ui-form__fieldset_column-mob']//div[1]//div[1]//div[1]//div[1]//div[1]//div[1]//div[1]//div[2]")).click();
		Actions actions2 = new Actions(driver);
		actions2.moveToElement(driver.findElement(By.xpath(xpathText)))
				.click()
				.perform();
	}

}
