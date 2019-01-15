package br.com.gustavo.steps;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class InsertAccountSteps {
	protected static WebDriver driver;
	
	@Given("^I'm accessing the application$")
	public void iMAccessingTheApplication() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://srbarriga.herokuapp.com/");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	@When("^the user \"([^\"]*)\"$")
	public void theUser(String arg1) throws Throwable {
	  driver.findElement(By.id("email")).sendKeys(arg1);
	}

	@When("^the password \"([^\"]*)\"$")
	public void thePassword(String arg1) throws Throwable {
		driver.findElement(By.id("senha")).sendKeys(arg1);
	}

	@When("^select enter$")
	public void selectEnter() throws Throwable {
		driver.findElement(By.tagName("button")).click();
	}

	@Then("^view a home page$")
	public void viewAHomePage() throws Throwable {
		String text = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
		Assert.assertEquals("Bem vindo, testeCucumber!", text);
	}

	@When("^I select Accounts$")
	public void iSelectAccounts() throws Throwable {
		driver.findElement(By.linkText("Contas")).click();
	}

	@When("^select Add$")
	public void selectAdd() throws Throwable {
		driver.findElement(By.linkText("Adicionar")).click();
	}

	@When("^I enter the account \"([^\"]*)\"$")
	public void iEnterTheAccount(String arg1) throws Throwable {
		driver.findElement(By.id("nome")).sendKeys(arg1);
	}

	@When("^I select Save$")
	public void iSelectSave() throws Throwable {
		driver.findElement(By.tagName("button")).click();
	   
	}

	@Then("^the account is inserted successfully$")
	public void theAccountIsInsertedSuccessfully() throws Throwable {
		String text = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
		Assert.assertEquals("Conta adicionada com sucesso!", text);
		
	}
	
	@Then("^I'm notifying the account name is required$")
	public void iMNotifyingTheAccountNameIsRequired() throws Throwable {
		String text = driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText();
		Assert.assertEquals("Informe o nome da conta", text);
		
	}
	
	@Then("^I'm notified that there is already an account with this name$")
	public void iMNotifiedThatThereIsAlreadyAnAccountWithThisName() throws Throwable {
		String text = driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText();
		Assert.assertEquals("Já existe uma conta com esse nome!", text);
		
	}
	
	@Then("^I get the message \"([^\"]*)\"$")
	public void iGetTheMessage(String arg1) throws Throwable {
		String text = driver.findElement(By.xpath("//div[starts-with(@class, 'alert alert-')]")).getText();
		Assert.assertEquals(arg1, text);
	}

	@After (order = 1, value = {"@functional"})
	public void screenshot(Scenario  scenarios){
		File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file,new File("target/screenshot/"+scenarios.getId()+".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@After(order = 0, value = {"@functional"})
	public void closeDriver(){
		
		driver.close();
		driver.quit();
		
	}
}
