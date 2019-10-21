package cursoSelenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DSL {

	//////////// DSL = DOMAIN SPECIFIC LANGUAGE ///////////////////
	
	//Serve para resolver os problemas especificos do dominio
	
	private WebDriver driver;
	
	
	/// Inicia a variavel Driver para o WebDriver
	public DSL(WebDriver driver) {
		this.driver = driver;
	}
	
	//////////// BOX ///////////////////
	
	public void escrever(String id_campo, String texto) {
		driver.findElement(By.id(id_campo)).sendKeys(texto);

	}

	public String obterValorCampo(String id_campo) {
		return driver.findElement(By.id(id_campo)).getAttribute("value");
	}

	/////////////////// RADIO BUTTON /////////////////////
	public void clickRadio(String id) {
		driver.findElement(By.id(id)).click();
	}

	public boolean isRadioMark(String id) {
		return driver.findElement(By.id(id)).isSelected();
	}

	
	///////////////// COMBO ////////////////////
	public void selectCombo(String id, String valor) {
		WebElement element = driver.findElement(By.id(id));
		Select combo = new Select(element);
		// combo.selectByIndex(3); // combo.selectByValue("superior");
		combo.selectByVisibleText(valor);
	}

	public String obterCombo(String id) {
		WebElement element = driver.findElement(By.id(id));
		Select combo = new Select(element);
		return combo.getFirstSelectedOption().getText();
	}

	
	//////////////  BUTTON /////////////////
	public void clickButton(String id) {
		driver.findElement(By.id(id)).click();
	}
	
	public boolean isClicked(String id) {
		return driver.findElement(By.id(id)).isSelected();
	}
	
	
	
	public void clickLink(String link) {
		driver.findElement(By.linkText(link)).click();

	}

	public String obterTexto(By by) {
		return driver.findElement(by).getText();
	}

	public String obterTexto(String id) {
		return obterTexto(By.id(id));
	}

}