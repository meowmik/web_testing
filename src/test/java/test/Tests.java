package test;

import org.junit.*;
import org.openqa.selenium.*;

import static org.junit.Assert.assertEquals;


	public class Tests extends BaseRunner {

		@Test
		public void testFirst(){
			driver.get(baseUrl);
			driver.findElement(By.xpath("//input[@name='name']")).click();
			driver.findElement(By.xpath("//input[@name='birthday']")).click();
			driver.findElement(By.xpath("//input[@name='city']")).click();
			driver.findElement(By.xpath("//input[@name='email']")).click();
			driver.findElement(By.xpath("//input[@name='phone']")).click();
			driver.findElement(By.cssSelector("svg.ui-icon-checkbox.ui-checkbox__icon")).click();
			assertEquals("Поле обязательно",
					driver.findElement(By.xpath("(//div[@class='ui-form-field-error-message ui-form-field-error-message_ui-form'])[1]")).getText());
		}


		@Test
		public void testSecond(){
			driver.get(baseUrl);
			driver.findElement(By.xpath("//input[@name='name']")).click();
			driver.findElement(By.xpath("//input[@name='name']")).clear();
			driver.findElement(By.xpath("//input[@name='name']")).sendKeys("kugf");
			driver.findElement(By.xpath("//input[@name='birthday']")).click();
			driver.findElement(By.xpath("//input[@name='birthday']")).clear();
			driver.findElement(By.xpath("//input[@name='birthday']")).sendKeys("34.");
			driver.findElement(By.xpath("//input[@name='city']")).click();
			driver.findElement(By.xpath("//input[@name='city']")).clear();
			driver.findElement(By.xpath("//input[@name='city']")).sendKeys("дкпло");
			driver.findElement(By.xpath("//input[@name='email']")).click();
			driver.findElement(By.xpath("//input[@name='email']")).clear();
			driver.findElement(By.xpath("//input[@name='email']")).sendKeys("lknlk");
			driver.findElement(By.xpath("//input[@name='phone']")).click();
			driver.findElement(By.xpath("//input[@name='phone']")).clear();
			driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("+7(234)");
			driver.findElement(By.cssSelector("svg.ui-icon-checkbox.ui-checkbox__icon")).click();
			assertEquals("Поле обязательно",
					driver.findElement(By.xpath("(//div[@class='ui-form-field-error-message ui-form-field-error-message_ui-form'])[1]")).getText());
			assertEquals("Допустимо использовать только буквы русского алфавита и дефис",
					driver.findElement(By.xpath("//div[@class='ui-form__row ui-form__row_default-error-view-visible']//div[@class='ui-form-field-error-message ui-form-field-error-message_ui-form'][2]")).getText());
			assertEquals("Поле заполнено некорректно",
					driver.findElement(By.xpath("//div[@class='ui-form__row ui-form__row_date ui-form__row_default-error-view-visible']//div[@class='ui-form-field-error-message ui-form-field-error-message_ui-form'][3]")).getText());
			assertEquals("Введите корректный адрес эл. почты",
					driver.findElement(By.xpath("//div[contains(text(),'Введите корректный адрес эл. почты')][4]")).getText());
			assertEquals("Номер телефона должен состоять из 10 цифр, начиная с кода оператора",
					driver.findElement(By.xpath("//div[contains(text(),'Номер телефона должен состоять из 10 цифр, начиная')][5]")).getText());

		}
	}


