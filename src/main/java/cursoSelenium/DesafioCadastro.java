package cursoSelenium;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DesafioCadastro {

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
	public void Cadastro() {
		page.setName("José");
		dsl.checkFieldEqValue("José", "elementosForm:nome");

		page.setLastName("Teste");
		dsl.checkFieldEqValue("Teste", "elementosForm:sobrenome");
		
		page.setGenderMale();
		dsl.isRadioMarked("elementosForm:sexo:0");
		
		page.setFavoriteFoodPizza();
		dsl.isClicked("elementosForm:comidaFavorita:2");
		
		page.setEducationalLevel("Superior");
		dsl.checkCombo1Selected("elementosForm:escolaridade", "Superior");

		page.setFavoriteSport("Natacao");
		dsl.selectComboVisibleTxt("elementosForm:esportes", "Natacao");
		
		
		dsl.writeField("elementosForm:sugestoes", "Sem sugestoes");
		dsl.checkFieldEqValue("Sem sugestoes", "elementosForm:sugestoes");
	
		page.register();
		
		// Assert.assertEquals("Nome: José",
		// driver.findElement(By.id("descNome")).getText());
		Assert.assertEquals("José", dsl.getTextXPath("//*[@id=\"descNome\"]/span"));
		// Assert.assertEquals("Nome: José",
		// driver.findElement(By.xpath("/html/body/center/div[2]/div[1]")).getText());

		page.getResults();
		Assert.assertEquals("Cadastrado!", page.getResults());
		Assert.assertTrue(dsl.getText("descSobrenome").endsWith("Teste"));
		Assert.assertTrue(dsl.getText("descSexo").endsWith("Masculino"));
		Assert.assertTrue(dsl.getText("descComida").endsWith("Pizza"));
		dsl.checkFieldEqText("Escolaridade: superior", "descEscolaridade");
		dsl.checkFieldEqText("Esportes: Natacao", "descEsportes");
		
//		Assert.assertTrue(dsl.getText("descSugestoes").endsWith("sugestoes"));
	}

}