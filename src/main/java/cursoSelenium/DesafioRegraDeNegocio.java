package cursoSelenium;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DesafioRegraDeNegocio {

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
	public void desafioRegras() {
		driver.findElement(By.id("elementosForm:cadastrar")).click(); // cadastrar

		Alert alerta = driver.switchTo().alert();
		alerta.accept();

		// driver.findElement(By.id("prompt")).click();

		driver.findElement(By.id("elementosForm:nome")).sendKeys("José");
		driver.findElement(By.id("elementosForm:cadastrar")).click(); // cadastrar
		alerta.accept(); //aceitar alerta
		
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Teste");
		driver.findElement(By.id("elementosForm:cadastrar")).click(); // cadastrar
		alerta.accept(); //aceitar alerta
		
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		
		driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:3")).click();
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		alerta.accept(); //aceitar alerta
		
		driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
		
		new Select(driver.findElement(By.id("elementosForm:esportes"))).selectByVisibleText("Natacao");		
		new Select(driver.findElement(By.id("elementosForm:esportes"))).selectByVisibleText("O que eh esporte?");		
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		alerta.accept(); //aceitar alerta
		new Select(driver.findElement(By.id("elementosForm:esportes"))).deselectByVisibleText("Natacao");
		driver.findElement(By.id("elementosForm:cadastrar")).click();
	}

}