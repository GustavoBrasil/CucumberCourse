package br.com.gustavo.runners;
import java.util.concurrent.TimeUnit;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features/insert_account.feature",
		glue = "br.com.gustavo.steps",
	   	tags= {"~@ignore","@functional"},
		plugin = {"pretty","html:target/report-html","json:target/report-json"}, 
		monochrome = true, 
		dryRun = false,
		snippets = SnippetType.CAMELCASE)

public class RunnerFunctionalTest {

	@BeforeClass
	
	public static void reset() {
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://srbarriga.herokuapp.com/");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.id("email")).sendKeys("teste@selenium.com");
		driver.findElement(By.id("senha")).sendKeys("teste123");
		driver.findElement(By.tagName("button")).click();
		driver.findElement(By.linkText("reset")).click();
		driver.quit();
	}
}
