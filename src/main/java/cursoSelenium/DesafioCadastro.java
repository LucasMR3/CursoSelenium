package cursoSelenium;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DesafioCadastro {

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
	public void CadastroCompleto() {
		dsl.writeField("elementosForm:nome", "José");
		dsl.checkField("José", "elementosForm:nome");

		dsl.writeField("elementosForm:sobrenome", "Teste");
		dsl.checkField("Teste", "elementosForm:sobrenome");
		
		dsl.clickRadio("elementosForm:sexo:0");
		dsl.isRadioMarked("elementosForm:sexo:0");

		dsl.clickButtonId("elementosForm:comidaFavorita:2");
		dsl.isClicked("elementosForm:comidaFavorita:2");
		
		dsl.selectCombo("elementosForm:escolaridade", "Superior");
		dsl.checkCombo1Selected("elementosForm:escolaridade", "Superior");

		dsl.selectCombo("elementosForm:esportes", "Natacao");
		dsl.checkCombo1Selected("elementosForm:esportes", "Natacao");
		
		dsl.writeField("elementosForm:sugestoes", "Sem sugestoes");
		dsl.checkField("Sem sugestoes", "elementosForm:sugestoes");
	
		driver.findElement(By.id("elementosForm:cadastrar")).click();

		// Assert.assertEquals("Nome: José",
		// driver.findElement(By.id("descNome")).getText());
		Assert.assertEquals("José", driver.findElement(By.xpath("//*[@id=\"descNome\"]/span")).getText());
		// Assert.assertEquals("Nome: José",
		// driver.findElement(By.xpath("/html/body/center/div[2]/div[1]")).getText());

		Assert.assertEquals("Cadastrado!", driver.findElement(By.xpath("//*[@id=\"resultado\"]/span")).getText());
		Assert.assertTrue(driver.findElement(By.id("descSobrenome")).getText().endsWith("Teste"));
		Assert.assertTrue(driver.findElement(By.id("descSexo")).getText().endsWith("Masculino"));
		Assert.assertTrue(driver.findElement(By.id("descComida")).getText().endsWith("Pizza"));
		Assert.assertEquals("Escolaridade: superior", driver.findElement(By.id("descEscolaridade")).getText());
		Assert.assertEquals("Esportes: Natacao", driver.findElement(By.id("descEsportes")).getText());
		Assert.assertTrue(driver.findElement(By.id("descSugestoes")).getText().endsWith("sugestoes"));
	}

}