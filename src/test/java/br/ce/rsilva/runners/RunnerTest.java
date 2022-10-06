package br.ce.rsilva.runners;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features/alugar_filme.feature",
		glue = {"br.ce.rsilva.steps"},
		tags = "",
		plugin = {"pretty","html:target/report-html","json:target/report.json"},
		monochrome = false,
		dryRun = false,
		stepNotifications = true,		
		snippets = SnippetType.CAMELCASE
		)
public class RunnerTest {
	
}
