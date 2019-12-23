package learningSelenium;
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
	public void startsSelenium() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file://" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new DSL(driver);
	}

	@After
	public void endsSelenium() {
		driver.quit();
	}

	@Test
	public void interactAlertSimple() {
		dsl.clickButtonId("alert");
			
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		dsl.checkField("Alert Simples", text);
		
		
		alert.accept();
	}

	@Test
	public void interactAlertDual() {
		driver.findElement(By.id("confirm")).click();
		Alert alert = driver.switchTo().alert();
		dsl.checkField("Confirm Simples", alert.getText());
		alert.dismiss();
		dsl.checkField("Negado", alert.getText());
		alert.accept();
		}

	@Test
	public void interactAlertPrompt() {
		driver.findElement(By.id("prompt")).click();
		Alert alert = driver.switchTo().alert();
		
		dsl.checkField("Digite um numero", alert.getText());
		alert.sendKeys("12");
		alert.accept();
		Assert.assertEquals("Era 12?", alert.getText());
		alert.accept();
		assertEquals(":D", alert.getText());
	}

}