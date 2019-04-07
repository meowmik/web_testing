package test;

import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;


import java.util.HashSet;
import java.util.Set;
import java.util.List;


public class TestKeys extends BaseRunner{
	Logger logger = LoggerFactory.getLogger(TestKeys.class);

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
							logger.info("Переключились к вкладке " + driver.getTitle());
						}
					});
					return driver.getTitle().equals("Тарифы Тинькофф Мобайла");
				});
		if(!driver.getCurrentUrl().equals("https://www.tinkoff.ru/mobile-operator/tariffs/"))
			logger.error("У вкладки не верный Url и равен: " + driver.getCurrentUrl());
		else logger.info("У вкладки нужный Url");
		HashSet<String> windows = (HashSet<String>) driver.getWindowHandles();
		driver.switchTo().window(windows.toArray()[0].toString());
		try {
			driver.close();
			logger.info("Вкладка поиска закрыта");
		}catch (Exception e){
			logger.error("Вкладка поиска не закрыта");
		}


	}


	@Test
	public void test2(){

		driver.get("https://www.tinkoff.ru/mobile-operator/tariffs/");
		logger.info("Перешли на сайт тинькоффа с выбором тарифа");
		driver.findElement(By.xpath("//span[@class='MvnoRegionConfirmation__option_v9PfP']")).click();
		if (driver.findElement(By.xpath("//div[@class='MvnoRegionConfirmation__title_DOqnW']")).getText().equals("Москва и Московская область")) {
			logger.info("Регион был правильно выбран: Москва и Московская область");
			driver.navigate().refresh();
			if (driver.findElement(By.xpath("//div[@class='MvnoRegionConfirmation__title_DOqnW']")).getText().equals("Москва и Московская область")) {
				logger.info("После обновления страницы регион остался: Москва");
				String costM1 = cost("//h3[@class='ui-title ui-title_form ui-title_center ui-title_size_s MobileOperatorFormFieldTitle__title_2awZp mobileOperatorProductCalculatorSchema__amountTitle_6kgKn']");
				driver.findElement(By.xpath("//div[@class='MvnoRegionConfirmation__title_DOqnW']")).click();
				driver.findElement(By.xpath("//div[contains(text(),'Краснодарский кр.')]")).click();
				logger.info("Регион был изменён на Красноярский край");
				String costKr = cost("//h3[@class='ui-title ui-title_form ui-title_center ui-title_size_s MobileOperatorFormFieldTitle__title_2awZp mobileOperatorProductCalculatorSchema__amountTitle_6kgKn']");
				if (costM1.equals(costKr))
					logger.info("Почему-то цены двух разных городов равны при услугах по дефолду");
			}
		}
		Select.chooseFromListForCalls(driver, "//span[contains(text(),'Безлимитные минуты')]");
		Select.choseFromListForInternet(driver, "//span[contains(text(),'Безлимитный интернет')]");
		CheckBox.markModemMode(driver);
		CheckBox.markUnlimitedSms(driver);
		logger.info("Для Красноярского края были выбраны услуги с максимальной ценой");
		String costKr1 = cost("//h3[@class='ui-title ui-title_form ui-title_center ui-title_size_s MobileOperatorFormFieldTitle__title_2awZp mobileOperatorProductCalculatorSchema__amountTitle_6kgKn']");
		driver.findElement(By.xpath("//div[@class='MvnoRegionConfirmation__title_DOqnW']")).click();
		driver.findElement(By.xpath("//div[contains(text(),'Москва и Московская обл.')]")).click();
		logger.info("Регион был сменён на Москву и Московскую область");
		Select.chooseFromListForCalls(driver, "//span[contains(text(),'Безлимитные минуты')]");
		Select.choseFromListForInternet(driver, "//span[contains(text(),'Безлимитный интернет')]");
		CheckBox.markModemMode(driver);
		CheckBox.markUnlimitedSms(driver);
		logger.info("Для Москвы были выбраны услуги с максимальной ценой");
		String costM2 = cost("//h3[@class='ui-title ui-title_form ui-title_center ui-title_size_s MobileOperatorFormFieldTitle__title_2awZp mobileOperatorProductCalculatorSchema__amountTitle_6kgKn']");
		if(!costKr1.equals(costM2))
			logger.info("По какой-то причине цены при максимальных тарифах оказались разными");
	}

	@Test
	public void test3(){
		driver.get("https://www.tinkoff.ru/mobile-operator/tariffs/");
		logger.info("Перешли на сайт тинькоффа с выбором тарифа");
		driver.findElement(By.xpath("//span[@class='MvnoRegionConfirmation__option_v9PfP']")).click();
		logger.info("Регион был выбран: Москва и Московская область");
		//xpath такой бесконечный, потому что другими способами 0 минут никак не выбирается
		String xpath = "//div[contains(@class, 'ui-dropdown-field-list ui-dropdown-field-list__opened')]/div[contains(@class, 'ui-dropdown-field-list__item')][1]/div[contains(@class, 'ui-dropdown-field-list__item-event-handler')]/div[contains(@class, 'ui-dropdown-field-list__item-view ui-select__option_with-subtext_right-side')]/span[contains(@class, 'ui-dropdown-field-list__item-text')]";
		Select.chooseFromListForCalls(driver, xpath );
		Select.choseFromListForInternet(driver, "//span[contains(text(),'0 ГБ')]");
		CheckBox.markMessengers(driver);
		CheckBox.markSocialNetworks(driver);
		logger.info("обнулили все опции тарифа");
		String costFact = cost("//h3[@class='ui-title ui-title_form ui-title_center ui-title_size_s MobileOperatorFormFieldTitle__title_2awZp mobileOperatorProductCalculatorSchema__amountTitle_6kgKn']");
		String costExpect = "Общая цена: 0 \u20BD";
		if(!costExpect.equals(costFact)) {
			System.out.println("почему-то не 0");
			System.out.println(costFact);
			logger.info("Цена по какой-то причине не обнулилась и стала равной: " + costFact);
		}
		try {
			driver.findElement(By.xpath("//div[@class='LoaderRound__container_no-background_GvpfD LoaderRound__container_coverParent_2-_fi']")).isEnabled();
			logger.info("Кнопка активациии симкарты осталась активной");
		}
		catch (Exception e){
			System.out.println("кнопка активации симкарты не активна");
		}

	}

	protected String cost(String xpath){
		return driver.findElement(By.xpath(xpath)).getText();
	}



}
