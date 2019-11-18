package cursoSelenium;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DesafioRegraDeNegocio {

	private WebDriver driver;
	private DSL dsl;
	private CampoTreinamentoPage page;

	@Before
	public void inicializaSelenium() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file://" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new DSL(driver);
		page = new CampoTreinamentoPage(driver);
	}

	@After
	public void finalizaSelenium() {
		driver.quit();
	}
	
	@Test
	public void desafioRegras() {
		page.register();

		Alert alerta = driver.switchTo().alert();
		alerta.accept();

		// driver.findElement(By.id("prompt")).click();

		page.setName("José");
		page.register();
		alerta.accept(); //aceitar alerta
		
		page.setLastName("Teste");
		page.register();
		alerta.accept();
		
		page.setGenderMale();
		
		page.setFavoriteFoodCarne();
		page.setFavoriteFoodVeg();
		page.register();
		alerta.accept(); //aceitar alerta
		
		page.setFavoriteFoodCarne();
		
		page.setFavoriteSports("Natacao","O que eh esporte?");
		page.register();
		alerta.accept();
		dsl.deselectComboVisibleTxt("elementosForm:esportes", "Natacao");
		page.register();
	}

}