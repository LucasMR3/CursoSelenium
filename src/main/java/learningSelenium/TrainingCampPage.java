package learningSelenium;

import org.openqa.selenium.WebDriver;

public class TrainingCampPage {

	private DSL dsl;

	public TrainingCampPage(WebDriver driver) {
		dsl = new DSL(driver);
	}

	public void setName(String name) {
		dsl.writeField("elementosForm:nome", name);
	}

	public void setLastName(String lastName) {
		dsl.writeField("elementosForm:sobrenome", lastName);
	}

	public void setGenderMale() {
		dsl.clickRadio("elementosForm:sexo:0");
	}

	public void setFavoriteFoodPizza() {
		dsl.clickButtonId("elementosForm:comidaFavorita:2");
	}

	public void setFavoriteFoodCarne() {
		dsl.clickButtonId("elementosForm:comidaFavorita:0");
	}

	public void setFavoriteFoodVeg() {
		dsl.clickButtonId("elementosForm:comidaFavorita:3");
	}

	public void setEducationalLevel(String value) {
		dsl.selectComboVisibleTxt("elementosForm:escolaridade", value);
	}

	public void setFavoriteSport(String sport) {
		setFavoriteSports(sport);
	}

	public void setFavoriteSports(String... values) {
		for (String sport : values)
			dsl.selectComboVisibleTxt("elementosForm:esportes", sport);
	}

	public void register() {
		dsl.clickButtonId("elementosForm:cadastrar");
	}

	public String getResults() {
		return dsl.getTextXPath("//*[@id=\"resultado\"]/span");
	}
}