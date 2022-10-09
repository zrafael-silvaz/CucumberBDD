package br.ce.rsilva.runners;

import org.junit.BeforeClass;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features/inserir_conta.feature",
		glue = {"br.ce.rsilva.steps"},
		tags = "", //"~@ignore", ignora anotacoes
		plugin = "pretty", //"html:target/report-html/report.html","json:target/report.json"}, //criar arquivos de logs no formato html e json
		monochrome = true,
		dryRun = true,		
		stepNotifications = true,		
		snippets = SnippetType.CAMELCASE
		)
public class RunnerFuncionalTest {	
	@BeforeClass
	@DisplayName("Resetando estado co banco de dados")
	public static void resetarBanco() {		
		
		WebDriver driver = new ChromeDriver();

		driver.get("https://seubarriga.wcaquino.me/");
		
		driver.findElement(By.id("email")).sendKeys("rafaelferreira@solucaosistemas.net");
		driver.findElement(By.id("senha")).sendKeys("123456");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		
		driver.findElement(By.linkText("Home")).click();
		driver.findElement(By.linkText("reset")).click();
		driver.quit();
	}
}
