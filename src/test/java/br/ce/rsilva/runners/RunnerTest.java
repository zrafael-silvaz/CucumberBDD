package br.ce.rsilva.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features/",
		glue = {"br.ce.rsilva.steps"},
		tags = "@unitarios", //"~@ignore", ignora anotacoes
		plugin = "pretty", //"html:target/report-html/report.html","json:target/report.json"}, //criar arquivos de logs no formato html e json
		monochrome = true,
		dryRun = false,		
		stepNotifications = true,		
		snippets = SnippetType.CAMELCASE
		)
public class RunnerTest {
	
}
