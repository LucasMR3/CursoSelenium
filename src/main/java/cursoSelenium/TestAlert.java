package cursoSelenium;
import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestAlert {

	private WebDriver driver;
	private DSL dsl;
	
	@Before
	public void inicializaSelenium() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file://" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new DSL(driver);
	}

	@After
	public void finalizaSelenium() {
		driver.quit();
	}

	@Test
	public void interagirAlertSimple() {
		dsl.clickButtonId("alert");
			
		Alert alert = driver.switchTo().alert();
		String texto = alert.getText();
		dsl.checkFieldNoSearch("Alert Simples", texto);
		
		
		alert.accept();
	}

	@Test
	public void interagirAlertDuplo() {
		driver.findElement(By.id("confirm")).click();
		
		
		Alert alert = driver.switchTo().alert();

		Assert.assertEquals("Confirm Simples", alert.getText());
		alert.dismiss();
		Assert.assertEquals("Negado", alert.getText());
		alert.accept();
		}

	@Test
	public void interagirAlertPrompt() {
		driver.findElement(By.id("prompt")).click();
		Alert alerta = driver.switchTo().alert();

		Assert.assertEquals("Digite um numero", alerta.getText());
		alerta.sendKeys("12");
		alerta.accept();
		Assert.assertEquals("Era 12?", alerta.getText());
		alerta.accept();
		assertEquals(":D", alerta.getText());
	}

}