package cursoSelenium;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestFrameJanela {

	private WebDriver driver;
	
	@Before
	public void inicializaSelenium() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file://" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	}

	@After
	public void finalizaSelenium() {
		driver.quit();
	}
	
	@Test
	
	public void testeFrame() {
		driver.switchTo().frame("frame1"); // frame
		driver.findElement(By.id("frameButton")).click();

		Alert alert = driver.switchTo().alert();
		String messageAlert = alert.getText();
		Assert.assertEquals("Frame OK!", messageAlert);
		alert.accept();

		driver.switchTo().defaultContent(); // voltar
		driver.findElement(By.id("elementosForm:nome")).sendKeys(messageAlert);
	}

	@Test
	public void testeJanela() {
		driver.findElement(By.id("buttonPopUpEasy")).click();

		driver.switchTo().window("Popup");
		driver.findElement(By.tagName("textarea")).sendKeys("deu certo?");

		driver.close();

		driver.switchTo().window("");
		driver.findElement(By.tagName("textarea")).sendKeys("e agora?");
	}

	@Test
	public void testeJanelaHard(){
		driver.findElement(By.id("buttonPopUpHard")).click();
		System.out.println(driver.getWindowHandle()); //janela atual
		System.out.println(driver.getWindowHandles()); //janelas ativas

		driver.switchTo().window((String) driver.getWindowHandles().toArray()[1]);	
		System.out.println(driver.getWindowHandle()); //janela atual

		driver.findElement(By.tagName("textarea")).sendKeys("funcionou");
		driver.switchTo().window((String) driver.getWindowHandles().toArray()[0]);
		driver.findElement(By.tagName("textarea")).sendKeys("funcionou também");
	}

}