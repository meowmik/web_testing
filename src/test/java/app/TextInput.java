package app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TextInput {

	public static void fullName(WebDriver driver){
		driver.findElement(By.xpath("//input[@name = 'fio']")).sendKeys("Иванов Иван Иванович");
	}

	public static void fullPhoneNumber(WebDriver driver){
		driver.findElement(By.xpath("//input[@name=\"phone_mobile\"]")).sendKeys("89756789654");
	}

	public static void valueСheck(WebDriver driver, String xpath){
		driver.findElement(By.xpath(xpath)).getText();
	}


}
