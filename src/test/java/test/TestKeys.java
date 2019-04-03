package test;

import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;
import java.util.List;

public class TestKeys extends BaseRunner{

	@Test
	public void test1(){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.get("https://www.google.ru/");
		driver.findElement(By.xpath("//input[@title='Поиск']"))
				.sendKeys("мобайл тинькофф");
		driver.findElement(By.xpath("//input[@title='Поиск']"))
				.sendKeys(Keys.ENTER);
		By listItems = By.xpath("//div[@id='taw']");
		List<WebElement> items = (List<WebElement>) driver.findElement(listItems);
		wait
				.ignoring(StaleElementReferenceException.class)
				.withMessage("что-то пошло не так")
				.until(driver ->{
					for (WebElement element : items){
						if (element.getText().contains("Тинькофф мобайл | Тарифы")){
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
					return driver.getTitle().equals("Тарифы");

				});

	}
}
