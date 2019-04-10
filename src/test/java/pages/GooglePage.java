package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Set;

public class GooglePage extends Page {

	public GooglePage(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@title='Поиск']")
	public WebElement searchField;

	public void open(){
		driver.navigate().to("https://www.google.ru/");
		isLoadedByTitleContains("Google");
	}

	public void openSearchResultsPageByRequest(String request, String requestItem){
		searchField.sendKeys(request);
		searchField.sendKeys(Keys.ENTER);
		By listItems = By.xpath("//div[contains(@class, 'g')]/div/div[contains(@class, 'rc')]/div[contains(@class, 'r')]/a/h3");
		List<WebElement> items = driver.findElements(listItems);
		wait
				.ignoring(StaleElementReferenceException.class)
				.withMessage("что-то пошло не так")
				.until(driver ->{
					for (WebElement element : items){
						if (element.getText().contains(requestItem)){
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
					return driver.getTitle().equals(requestItem);
				});
	}

	public boolean isLoadedByTitleContains(String substring) {
		wait.until(d -> d.getTitle().contains(substring));
		return true;
	}
}
