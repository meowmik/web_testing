package pages;

import app.CheckBox;
import app.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class TinkoffMobileOperator extends Page{
	public TinkoffMobileOperator(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
	}
	protected String cost(String xpath){
		return driver.findElement(By.xpath(xpath)).getText();
	}


	public void initialChoiceOfMoscow(){
		driver.findElement(By.xpath("//span[@class='MvnoRegionConfirmation__option_v9PfP']")).click();
		logger.info("Регион был выбран: Москва и Московская область");
	}

	public String selectAndCheckRegionMoscowAndCost() {
		initialChoiceOfMoscow();
		if (driver.findElement(By.xpath("//div[@class='MvnoRegionConfirmation__title_DOqnW']")).getText().equals("Москва и Московская область")) {
			logger.info("Регион был правильно выбран: Москва и Московская область");
			driver.navigate().refresh();
			if (driver.findElement(By.xpath("//div[@class='MvnoRegionConfirmation__title_DOqnW']")).getText().equals("Москва и Московская область")) {
				logger.info("После обновления страницы регион остался: Москва");
			}
		}
		String costM1 = cost("//h3[@class='ui-title ui-title_form ui-title_center ui-title_size_s MobileOperatorFormFieldTitle__title_2awZp mobileOperatorProductCalculatorSchema__amountTitle_6kgKn']");
		return costM1;
	}
	public void changeOfRegion(String regionPath){
		driver.findElement(By.xpath("//div[@class='MvnoRegionConfirmation__title_DOqnW']")).click();
		driver.findElement(By.xpath(regionPath)).click();
		logger.info("Регион был изменён");
	}

	public void defaultPriceСomparison(String costM1){
		String costKr = cost("//h3[@class='ui-title ui-title_form ui-title_center ui-title_size_s MobileOperatorFormFieldTitle__title_2awZp mobileOperatorProductCalculatorSchema__amountTitle_6kgKn']");
		if (costM1.equals(costKr))
			logger.info("Почему-то цены двух разных городов равны при услугах по дефолду");
	}

	public void priceComparisonForMaximumServices() {
		selectionOfMaximumServices();
		logger.info("Для Красноярского края были выбраны услуги с максимальной ценой");
		String costKr1 = cost("//h3[@class='ui-title ui-title_form ui-title_center ui-title_size_s MobileOperatorFormFieldTitle__title_2awZp mobileOperatorProductCalculatorSchema__amountTitle_6kgKn']");
		changeOfRegion("//div[contains(text(),'Москва и Московская обл.')]");
		selectionOfMaximumServices();
		logger.info("Для Москвы были выбраны услуги с максимальной ценой");
		String costM2 = cost("//h3[@class='ui-title ui-title_form ui-title_center ui-title_size_s MobileOperatorFormFieldTitle__title_2awZp mobileOperatorProductCalculatorSchema__amountTitle_6kgKn']");
		if (!costKr1.equals(costM2))
			logger.info("По какой-то причине цены при максимальных тарифах оказались разными");
	}

	public void tariffReset(){
		//xpath такой бесконечный, потому что другими способами 0 минут никак не выбирается
		String xpath = "//div[contains(@class, 'ui-dropdown-field-list ui-dropdown-field-list__opened')]/div[contains(@class, 'ui-dropdown-field-list__item')][1]/div[contains(@class, 'ui-dropdown-field-list__item-event-handler')]/div[contains(@class, 'ui-dropdown-field-list__item-view ui-select__option_with-subtext_right-side')]/span[contains(@class, 'ui-dropdown-field-list__item-text')]";
		Select.chooseFromListForCalls(driver, xpath );
		Select.choseFromListForInternet(driver, "//span[contains(text(),'0 ГБ')]");
		CheckBox.markMessengers(driver);
		CheckBox.markSocialNetworks(driver);
		logger.info("обнулили все опции тарифа");
	}

	public void zeroPriceCheck(){
		String costFact = cost("//h3[@class='ui-title ui-title_form ui-title_center ui-title_size_s MobileOperatorFormFieldTitle__title_2awZp mobileOperatorProductCalculatorSchema__amountTitle_6kgKn']");
		String costExpect = "Общая цена: 0 \u20BD";
		if(!costExpect.equals(costFact)) {
			System.out.println("почему-то не 0");
			System.out.println(costFact);
			logger.info("Цена по какой-то причине не обнулилась и стала равной: " + costFact);
		}
	}


	protected void selectionOfMaximumServices(){
		Select.chooseFromListForCalls(driver, "//span[contains(text(),'Безлимитные минуты')]");
		Select.choseFromListForInternet(driver, "//span[contains(text(),'Безлимитный интернет')]");
		CheckBox.markModemMode(driver);
		CheckBox.markUnlimitedSms(driver);
	}


}
