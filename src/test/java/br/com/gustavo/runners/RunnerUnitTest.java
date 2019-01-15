package br.com.gustavo.runners;

import org.junit.runner.RunWith;



import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features/",
		glue = "br.com.gustavo.steps",
	   	tags= {"~@ignore","@unit"},
		plugin = {"pretty","html:target/report-html","json:target/report-json"}, 
		monochrome = true, 
		dryRun = false,
		snippets = SnippetType.CAMELCASE)

public class RunnerUnitTest {

	}
