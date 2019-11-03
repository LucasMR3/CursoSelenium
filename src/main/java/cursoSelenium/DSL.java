package cursoSelenium;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DSL {

	//////////// DSL = DOMAIN SPECIFIC LANGUAGE ///////////////////

	// Serve para resolver os problemas especificos do dominio

	private WebDriver driver;

	/// Inicia a variavel Driver para o WebDriver
	public DSL(WebDriver driver) {
		this.driver = driver;
	}

	//////////// BOX ///////////////////

	public void writeField(String id_field, String text) {
		driver.findElement(By.id(id_field)).sendKeys(text);
	}

	public String searchField(String id_field) {
		return driver.findElement(By.id(id_field)).getAttribute("value");
	}

	public void checkField(String field, String id_field) {
		Assert.assertEquals(field, searchField(id_field));
	}

	/////////////////// RADIO BUTTON /////////////////////
	public void clickRadio(String id) {
		driver.findElement(By.id(id)).click();
	}

	public boolean isRadioMark(String id) {
		return driver.findElement(By.id(id)).isSelected();
	}

	///////////////// COMBO ////////////////////
	public void selectCombo(String id, String value) {
		WebElement element = driver.findElement(By.id(id));
		Select combo = new Select(element);
		// combo.selectByIndex(3); // combo.selectByValue("superior");
		combo.selectByVisibleText(value);
	}

	public String getComboValue(String id) {
		WebElement element = driver.findElement(By.id(id));
		Select combo = new Select(element);
		return combo.getFirstSelectedOption().getText();
	}

	////////////// BUTTON /////////////////
	public void clickButtonId(String id) {
		driver.findElement(By.id(id)).click();
	}

	public void clickButtonXpath(String xpath) {
		driver.findElement(By.xpath(xpath)).click();
	}

	public boolean isClicked(String id) {
		return driver.findElement(By.id(id)).isSelected();
	}

	public void clickLink(String link) {
		driver.findElement(By.linkText(link)).click();

	}

	public String getText(By by) {
		return driver.findElement(by).getText();
	}

	public String getText(String id) {
		return getText(By.id(id));
	}

	public void waitSleep(int timeSec) {
		try {
			Thread.sleep(timeSec);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}