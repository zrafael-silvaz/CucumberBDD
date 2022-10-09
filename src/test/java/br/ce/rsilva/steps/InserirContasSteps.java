package br.ce.rsilva.steps;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.ui.Wait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import io.github.bonigarcia.wdm.WebDriverManager;

public class InserirContasSteps {
	private WebDriver driver;
	
	@DisplayName("Iniciando os testes na aplicacao")
	@Before
	public void before() {
		System.out.println("Iniciando");
	}
	
	@Dado("que desejo acessar uma conta")
	public void queDesejoAcessarUmaConta() {
	    WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();		
		driver.get("https://seubarriga.wcaquino.me/");	
		driver.findElement(By.id("email")).sendKeys("rafaelferreira@solucaosistemas.net");
		driver.findElement(By.id("senha")).sendKeys("123456");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		driver.findElement(By.linkText("Contas")).click();
		driver.findElement(By.linkText("Adicionar")).click();
	}
	@Quando("adiciono a conta {}")
	public void adicionoAContaContaDeTeste(String conta) {
		driver.findElement(By.id("nome")).sendKeys(conta);
		driver.findElement(By.cssSelector("button[type='submit']")).click();
	}
	
	@Então("recebo a mensagem {string}")
	public void receboAMensagem(String string) {
		String informeConta = driver.findElement(By.cssSelector("div[class^='alert alert-']")).getText();
	    Assert.assertEquals(string, informeConta);
	}
	
	@After(order = 1, value = "@funcionais")
	public void screenshot() {				
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {			
			FileUtils.copyFile(file, new File("target/screenshot/"+file.getName()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@After(order = 0, value = "@funcionais")
	public void fecharBrowser() {			
		driver.quit();
	}
	
	

}
