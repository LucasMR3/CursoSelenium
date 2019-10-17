package cursoSelenium;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

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
		dsl.escrever("elementosForm:nome", "José");
		Assert.assertEquals("José", dsl.obterValorCampo("elementosForm:nome"));

		String desafioNome = "José";

		dsl.escrever("elementosForm:sobrenome","Teste");
		Assert.assertEquals("Teste",  dsl.obterValorCampo("elementosForm:sobrenome"));

		dsl.clickRadio("elementosForm:sexo:0");
		Assert.assertTrue(dsl.isRadioMark("elementosForm:sexo:0"));

		dsl.clickButton("elementosForm:comidaFavorita:2");
		Assert.assertTrue(dsl.isClicked("elementosForm:comidaFavorita:2"));

		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(element);
		combo.selectByVisibleText("Superior");

		new Select(driver.findElement(By.id("elementosForm:esportes"))).selectByVisibleText("Natacao");

		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Sem sugestoes");
		Assert.assertEquals("Sem sugestoes",
				driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));

		driver.findElement(By.id("elementosForm:cadastrar")).click();

		// Assert.assertEquals("Nome: José",
		// driver.findElement(By.id("descNome")).getText());
		Assert.assertEquals(desafioNome, driver.findElement(By.xpath("//*[@id=\"descNome\"]/span")).getText());
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