package cursoSelenium;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
//import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteCampoTreinamento {
	
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
	public void testTextField() {
		dsl.escrever("elementosForm:nome", "Teste de Escrita");
		Assert.assertEquals("Teste de Escrita", dsl.obterValorCampo("elementosForm:nome"));
	}

	@Test
	public void testTextArea() {
		dsl.escrever("elementosForm:sugestoes", "Teste de Escrita\n\nteste");
		Assert.assertEquals("Teste de Escrita\n\nteste", dsl.obterValorCampo("elementosForm:sugestoes"));
	}

	@Test
	public void testRadioButton() {
		dsl.clickRadio("elementosForm:sexo:0");
		Assert.assertTrue(dsl.isRadioMark("elementosForm:sexo:0"));
	}

	@Test
	public void testCheckBox(){
		dsl.clickRadio("elementosForm:comidaFavorita:2");
		Assert.assertTrue(dsl.isRadioMark("elementosForm:comidaFavorita:2"));
	}

	@Test
	public void testCombo() {
		dsl.selectCombo("elementosForm:escolaridade", "2o grau completo");

		Assert.assertEquals("2o grau completo", dsl.obterCombo("elementosForm:escolaridade"));
	}

	@Test
	public void verificarCombo() {
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(element);
		List<WebElement> options = combo.getOptions();
		Assert.assertEquals(8, options.size());

		boolean encontrou = false;

		for (WebElement option : options) {

			if (option.getText().equals("Mestrado")) {
				encontrou = true;
			}

		}
		Assert.assertTrue(encontrou);
	}

	@Test
	public void verificarMultCombo() {
		dsl.selectCombo("elementosForm:esportes", "Natacao");
		dsl.selectCombo("elementosForm:esportes", "Corrida");
		dsl.selectCombo("elementosForm:esportes", "O que eh esporte?");

		WebElement element = driver.findElement(By.id("elementosForm:esportes"));
		Select combo = new Select(element);

		List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
		Assert.assertEquals(3, allSelectedOptions.size());

		combo.deselectByVisibleText("Corrida");
		allSelectedOptions = combo.getAllSelectedOptions();
		Assert.assertEquals(2, allSelectedOptions.size());
	}

	@Test
	public void interagirBotton() {
		dsl.clickButton("buttonSimple");	

		WebElement botao = driver.findElement(By.id("buttonSimple")); 
		Assert.assertEquals("Obrigado!", botao.getAttribute("value"));
	}

	@Test

	// @Ignore
	public void interagirLink() {
		dsl.clickLink("Voltar");
		// Assert.fail();

		Assert.assertEquals("Voltou!", dsl.obterTexto("resultado"));
	}

	@Test
	public void buscarTextoTela() {
		System.out.println(driver.findElement(By.tagName("body")).getText());
		// Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("Campo
		// de Treinamento")); / metodo demorado

		Assert.assertEquals("Campo de Treinamento", dsl.obterTexto(By.tagName("h3")));
		// metodo rapido

		Assert.assertEquals("Cuidado onde clica, muitas armadilhas...",
				dsl.obterTexto(By.className("facilAchar")));
	}

}
	
	
	
	
	
	
	