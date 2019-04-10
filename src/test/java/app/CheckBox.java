package app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckBox {

	public static void markModemMode(WebDriver driver){

		driver.findElement(By.xpath("//div[@class='CheckboxSet__root_3OLWA']//div[1]//div[1]//div[1]//div[1]//div[1]//div[1]")).click();

	}

	public static void markUnlimitedSms(WebDriver driver){

		driver.findElement(By.xpath("//div[@class='CheckboxSet__root_3OLWA']//div[2]//div[1]//div[1]//div[1]//div[1]//div[1]")).click();
	}

	public static void markMessengers(WebDriver driver){
		driver.findElement(By.xpath("//div[@class='CheckboxSet__root_3OLWA']//div[1]//div[1]//div[1]//div[1]//div[1]//div[1]")).click();

	}

	public static void markSocialNetworks(WebDriver driver){
		driver.findElement(By.xpath("//div[@class='CheckboxSet__checkboxSet_1aOBh']//div[1]//div[2]//div[1]//div[1]//div[1]")).click();

	}

	public static  void markMusiс(WebDriver driver){
		driver.findElement(By.xpath("//div[@class='CheckboxSet__checkboxSet_1aOBh']//div[2]//div[1]//div[1]//div[1]//div[1]")).click();
	}

	public static void markVideo(WebDriver driver){
		driver.findElement(By.xpath("//div[@class='CheckboxSet__root_3OLWA']//div[2]//div[2]//div[1]//div[1]//div[1]q")).click();
	}

}
