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

	public void checkField(String fieldTxt, String id_field) {
		Assert.assertEquals(fieldTxt, searchField(id_field));
	}
	
	public void checkFieldNoSearch(String fieldTxt, String id_field) {
		Assert.assertEquals(fieldTxt, id_field);
	}

	/////////////////// RADIO BUTTON /////////////////////
	public void clickRadio(String id) {
		driver.findElement(By.id(id)).click();
	}

	public void findRadioMarked(String id) {
		Assert.assertTrue(isRadioMarked(id));
	}
	
	public boolean isRadioMarked(String id) {
		return driver.findElement(By.id(id)).isSelected();
	}

	///////////////// COMBO ////////////////////
	public void selectCombo(String id, String visibleTxt) {
		// combo.selectByIndex(3); // combo.selectByValue("superior");
		new Select(driver.findElement(By.id(id))).selectByVisibleText(visibleTxt);
	}

	public String getComboValueSelected(String id) {
		WebElement element = driver.findElement(By.id(id));
		Select combo = new Select(element);
		return combo.getFirstSelectedOption().getText();
	}
	
	public void checkCombo1Selected (String idCombo, String visibleTxt) {
		WebElement element = driver.findElement(By.id(idCombo));
		Select combo = new Select(element);
		Assert.assertEquals(combo.getFirstSelectedOption().getText(), visibleTxt);
	}
	
	////////////// BUTTON /////////////////
	public void clickButtonId(String id) {
		driver.findElement(By.id(id)).click();
	}

	public void clickButtonXpath(String xpath) {
		driver.findElement(By.xpath(xpath)).click();
	}

	public boolean ifIsClicked(String id) {
		return driver.findElement(By.id(id)).isSelected();
	}
	
	public void isClicked(String id) {
		Assert.assertTrue(ifIsClicked(id));
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