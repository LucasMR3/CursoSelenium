package cursoSelenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChallengeBusinessRules {

	private WebDriver driver;
	private DSL dsl;
	private TrainingCampPage page;

	@Before
	public void startsSelenium() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file://" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new DSL(driver);
		page = new TrainingCampPage(driver);
	}

	@After
	public void endsSelenium() {
		driver.quit();
	}

	@Test
	public void checkNameRequired() {
		page.register();
		dsl.acceptAlert();
		// driver.findElement(By.id("prompt")).click();
	}

	@Test
	public void checkLastNameRequired() {
		page.setName("José");
		page.register();
		dsl.acceptAlert();
	}

	@Test
	public void checkGenderRequired() {
		page.setName("José");
		page.setLastName("Teste");
		page.register();
		dsl.acceptAlert();
	}

	@Test
	public void checkFoodRule() {
		page.setName("José");
		page.setLastName("Teste");
		page.setGenderMale();
		page.setFavoriteFoodCarne();
		page.setFavoriteFoodVeg();
		page.register();
		dsl.acceptAlert();
	}

	@Test
	public void checkSportsRule() {
		page.setName("José");
		page.setLastName("Teste");
		page.setGenderMale();
		page.setFavoriteFoodVeg();
		page.setFavoriteSports("Natacao", "O que eh esporte?");
		page.register();
		dsl.acceptAlert();
	}

	@Test
	public void checkSuccessfulRegistration() {
		page.setName("José");
		page.setLastName("Teste");
		page.setGenderMale();
		page.setFavoriteFoodVeg();
		page.setFavoriteSports("Natacao", "O que eh esporte?");
		dsl.deselectComboVisibleTxt("elementosForm:esportes", "Natacao");
		page.register();
	}

}