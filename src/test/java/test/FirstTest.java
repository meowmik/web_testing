package test;

import org.junit.*;
import org.openqa.selenium.*;


	public class FirstTest extends BaseRanner {

		@Test
		public void testFirst(){
			driver.get(baseUrl);
			driver.findElement(By.name("name")).click();
			driver.findElement(By.name("birthday")).click();
			driver.findElement(By.name("city")).click();
			driver.findElement(By.name("email")).click();
			driver.findElement(By.name("phone")).click();
			driver.findElement(By.name("socialLink0")).click();
			driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Перетащите файлы сюда'])[1]/following::p[3]")).click();
			driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Перетащите файлы сюда'])[1]/following::span[2]")).click();
			driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Заполните анкету'])[1]/following::div[2]")).click();
			driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Заполните анкету'])[1]/following::div[2]")).click();
			// ERROR: Caught exception [ERROR: Unsupported command [doubleClick | xpath=(.//*[normalize-space(text()) and normalize-space(.)='Заполните анкету'])[1]/following::div[2] | ]]
			driver.findElement(By.name("birthday")).click();
			driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Дата рождения'])[1]/following::div[3]")).click();
			driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Дата рождения'])[1]/following::div[3]")).click();
		}

	}


