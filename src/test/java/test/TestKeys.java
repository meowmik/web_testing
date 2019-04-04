package test;

import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
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

	protected String cost(String xpath){
		return driver.findElement(By.xpath(xpath)).getText();
	}
    protected void packageSelectoin (){
		driver.findElement(By.xpath("//body//div[@class='UIFormWrapper__container_1TIK8']//div[@data-qa-file='UIFormWrapper']//div[@data-qa-file='UIFormWrapper']//div[2]//div[1]//div[1]//div[1]//div[1]//div[1]//div[1]//div[2]")).click();
		Actions actions1 = new Actions(driver);
		actions1.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'Безлимитные минуты')]")))
				.click()
				.perform();
		driver.findElement(By.xpath("//div[@class='ui-form__fieldset ui-form__fieldset_inline ui-form__fieldset_column-mob']//div[1]//div[1]//div[1]//div[1]//div[1]//div[1]//div[1]//div[2]")).click();
		Actions actions2 = new Actions(driver);
		actions2.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'Безлимитный интернет')]")))
				.click()
				.perform();
		driver.findElement(By.xpath("//div[@class='CheckboxSet__root_3OLWA']//div[2]//div[1]//div[1]//div[1]//div[1]//div[1]")).click();
		driver.findElement(By.xpath("//div[@class='CheckboxSet__root_3OLWA']//div[1]//div[1]//div[1]//div[1]//div[1]//div[1]")).click();

	}

	@Test
	public void test2(){

		driver.get("https://www.tinkoff.ru/mobile-operator/tariffs/");
		driver.findElement(By.xpath("//span[@class='MvnoRegionConfirmation__option_v9PfP']")).click();
		if (driver.findElement(By.xpath("//div[@class='MvnoRegionConfirmation__title_DOqnW']")).getText().equals("Москва и Московская область")) {
			driver.navigate().refresh();
			if (driver.findElement(By.xpath("//div[@class='MvnoRegionConfirmation__title_DOqnW']")).getText().equals("Москва и Московская область")) {
				String costM1 = cost("//h3[@class='ui-title ui-title_form ui-title_center ui-title_size_s MobileOperatorFormFieldTitle__title_2awZp mobileOperatorProductCalculatorSchema__amountTitle_6kgKn']");
				driver.findElement(By.xpath("//div[@class='MvnoRegionConfirmation__title_DOqnW']")).click();
				driver.findElement(By.xpath("//div[contains(text(),'Краснодарский кр.')]")).click();
				String costKr = cost("//h3[@class='ui-title ui-title_form ui-title_center ui-title_size_s MobileOperatorFormFieldTitle__title_2awZp mobileOperatorProductCalculatorSchema__amountTitle_6kgKn']");
				if (costKr == costM1) {
					System.out.println("Почему-то цены равны");
				}
			}
		}
		packageSelectoin();
		String costKr1 = cost("//h3[@class='ui-title ui-title_form ui-title_center ui-title_size_s MobileOperatorFormFieldTitle__title_2awZp mobileOperatorProductCalculatorSchema__amountTitle_6kgKn']");
		driver.findElement(By.xpath("//div[@class='MvnoRegionConfirmation__title_DOqnW']")).click();
		driver.findElement(By.xpath("//div[contains(text(),'Москва и Московская обл.')]")).click();
		packageSelectoin();
		String costM2 = cost("//h3[@class='ui-title ui-title_form ui-title_center ui-title_size_s MobileOperatorFormFieldTitle__title_2awZp mobileOperatorProductCalculatorSchema__amountTitle_6kgKn']");
		if(costKr1 == costM2)
			System.out.println("Почему-то цены равны");
	}

	@Test
	public void test3()throws Exception{
		driver.get("https://www.tinkoff.ru/mobile-operator/tariffs/");
		driver.findElement(By.xpath("//span[@class='MvnoRegionConfirmation__option_v9PfP']")).click();
		driver.findElement(By.xpath("//body//div[@class='UIFormWrapper__container_1TIK8']//div[@data-qa-file='UIFormWrapper']//div[@data-qa-file='UIFormWrapper']//div[2]//div[1]//div[1]//div[1]//div[1]//div[1]//div[1]//div[2]")).click();
		Actions actions1 = new Actions(driver);
		actions1.moveToElement(driver.findElement(By.xpath("//span[@class='ui-select__title-flex-text'][contains(text(),'0 минут')]")))
				.click()
				.perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='ui-form__fieldset ui-form__fieldset_inline ui-form__fieldset_column-mob']//div[1]//div[1]//div[1]//div[1]//div[1]//div[1]//div[1]//div[2]")).click();
		Actions actions2 = new Actions(driver);
		actions2.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'0 ГБ')]")))
				.click()
				.perform();
		driver.findElement(By.xpath("//div[@class='CheckboxSet__root_3OLWA']//div[1]//div[1]//div[1]//div[1]//div[1]//div[1]")).click();
		driver.findElement(By.xpath("//div[@class='CheckboxSet__checkboxSet_1aOBh']//div[1]//div[2]//div[1]//div[1]//div[1]")).click();
		Thread.sleep(3000);
		String costFact = cost("//h3[@class='ui-title ui-title_form ui-title_center ui-title_size_s MobileOperatorFormFieldTitle__title_2awZp mobileOperatorProductCalculatorSchema__amountTitle_6kgKn']");
		String costExpect = "Общая цена: 0 \u20BD";
		if(costExpect!=costFact)
			System.out.println("почему-то не 0");

	}

}
