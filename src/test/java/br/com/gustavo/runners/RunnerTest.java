package br.com.gustavo.runners;
import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features/movie_rental.feature",
		glue = "br.com.gustavo.steps",
		tags= "~@ignore",
		plugin = {"pretty","html:target/report-html","json:target/report-json"}, 
		monochrome =true, 
		snippets = SnippetType.CAMELCASE)

public class RunnerTest {

}
