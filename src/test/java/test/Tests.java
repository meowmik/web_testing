package test;

import org.junit.*;
import org.openqa.selenium.*;


	public class Tests extends BaseRanner {

		@Test
		public void testFirst(){
			driver.get(baseUrl);
			driver.findElement(By.name("name")).click();
			driver.findElement(By.name("birthday")).click();
			driver.findElement(By.name("city")).click();
			driver.findElement(By.name("email")).click();
			driver.findElement(By.name("phone")).click();
			driver.findElement(By.name("socialLink0")).click();
			driver.findElement(By.cssSelector("svg.ui-icon-checkbox.ui-checkbox__icon")).click();
		}

		@Test
		public void testSecond(){
			driver.get(baseUrl);
			driver.findElement(By.name("name")).click();
			driver.findElement(By.name("name")).clear();
			driver.findElement(By.name("name")).sendKeys("kugf");
			driver.findElement(By.name("birthday")).click();
			driver.findElement(By.name("birthday")).clear();
			driver.findElement(By.name("birthday")).sendKeys("34.");
			driver.findElement(By.name("city")).click();
			driver.findElement(By.name("city")).clear();
			driver.findElement(By.name("city")).sendKeys("дкпло");
			driver.findElement(By.name("email")).click();
			driver.findElement(By.name("email")).clear();
			driver.findElement(By.name("email")).sendKeys("lknlk");
			driver.findElement(By.name("phone")).click();
			driver.findElement(By.name("phone")).clear();
			driver.findElement(By.name("phone")).sendKeys("+7(234)");
			driver.findElement(By.name("socialLink0")).click();
			driver.findElement(By.cssSelector("svg.ui-icon-checkbox.ui-checkbox__icon")).click();
		}
	}


