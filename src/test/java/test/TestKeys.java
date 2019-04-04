package test;

import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashSet;
import java.util.Set;
import java.util.List;

public class TestKeys extends BaseRunner{

	@Test
	public void test1(){
		WebDriverWait wait = new WebDriverWait(driver, 20);
		driver.get("https://www.google.ru/");
		driver.findElement(By.xpath("//input[@title='Поиск']"))
				.sendKeys("мобайл тинькофф");
		driver.findElement(By.xpath("//input[@title='Поиск']"))
				.sendKeys(Keys.ENTER);
		By listItems = By.xpath("//div[contains(@class, 'g')]/div/div[contains(@class, 'rc')]/div[contains(@class, 'r')]/a/h3");
		List<WebElement> items = driver.findElements(listItems);
		wait
				.ignoring(StaleElementReferenceException.class)
				.withMessage("что-то пошло не так")
				.until(driver ->{
					for (WebElement element : items){
						if (element.getText().contains("Тарифы Тинькофф Мобайла")){
							element.click();
							break;
						}
					}
					Set<String> ids = driver.getWindowHandles();
					ids.forEach(id -> {
						if (!id.equals(driver.getWindowHandle())){
							driver.switchTo().window(id);
						}
					});
					return driver.getTitle().equals("Тарифы Тинькофф Мобайла");
				});
		if(!driver.getCurrentUrl().equals("https://www.tinkoff.ru/mobile-operator/tariffs/"))
			System.out.println(123);
		HashSet<String> windows = (HashSet<String>) driver.getWindowHandles();
		driver.switchTo().window(windows.toArray()[0].toString());
		driver.close();
		/*if(!driver.getCurrentUrl().equals("https://www.tinkoff.ru/mobile-operator/tariffs/"))
			System.out.println(123);
		System.out.println("https://www.tinkoff.ru/mobile-operator/tariffs/");
		System.out.println(driver.getCurrentUrl());*/
	}

	@Test
	public void test2(){

		WebDriverWait wait = new WebDriverWait(driver, 20);
		driver.get("https://www.tinkoff.ru/mobile-operator/tariffs/");
		driver.findElement(By.xpath("//div[@class='MvnoRegionConfirmation__title_DOqnW']")).click();
		driver.findElement(By.xpath("//div[contains(text(),'Москва и Московская обл.')]")).click();
		driver.findElement(By.xpath("//div[@class='MvnoRegionConfirmation__title_DOqnW']")).getText().equals("Москва и Московская область");


	}
}
