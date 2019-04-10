package test;

import org.junit.Test;
import pages.GooglePage;
import pages.TinkoffMobileOperator;

public class TestKeys extends BaseRunner {

	@Test
	public void test1() {
		GooglePage google = app.google;
		google.open();
		google.openSearchResultsPageByRequest("мобайл тинькофф", "Тарифы Тинькофф Мобайла");
		google.checkOpenTabLink("https://www.tinkoff.ru/mobile-operator/tariffs/");
		google.closeSearchTab();
	}


	@Test
	public void test2() {
		TinkoffMobileOperator tinkoffmob = app.tinkoffmob;
		tinkoffmob.getPage("https://www.tinkoff.ru/mobile-operator/tariffs/");
		String cost = tinkoffmob.selectAndCheckRegionMoscowAndCost();
		tinkoffmob.changeOfRegion("//div[contains(text(),'Краснодарский кр.')]");
		tinkoffmob.defaultPriceСomparison(cost);
		tinkoffmob.priceComparisonForMaximumServices();
	}

	@Test
	public void test3() {
		TinkoffMobileOperator tinkoffmob = app.tinkoffmob;
		tinkoffmob.getPage("https://www.tinkoff.ru/mobile-operator/tariffs/");
		tinkoffmob.tariffReset();
		tinkoffmob.zeroPriceCheck();
		tinkoffmob.checkOrderButtonForActivity();
	}
}






