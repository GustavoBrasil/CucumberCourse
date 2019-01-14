package br.com.gustavo.steps;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;

import br.com.gustavo.converts.DateConverter;
import cucumber.api.Transform;
import cucumber.api.java.en.*;

public class Learn_CucumberSteps {

	@Given("^I created the file correctly$")
	public void iCreatedTheFileCorrectly() throws Throwable {

	}

	@When("^run it$")
	public void runIt() throws Throwable {

	}

	@Then("^the specification should finished it successfully$")
	public void theSpecificationShouldFinishedItSuccessfully() throws Throwable {

	}

	private int count = 0;

	@Given("^that the counter value is (\\d+)$")
	public void thatTheCounterValueIs(int arg1) throws Throwable {
		count = arg1;
	}

	@When("^add up (\\d+)$")
	public void addUp(int arg1) throws Throwable {
		count = count + arg1;
	}

	@Then("^the counter value will be (\\d+)$")
	public void theCounterValueWillBe(int arg1) throws Throwable {
		Assert.assertEquals(arg1, count);
	}

	Date delivery = new Date();

	@Given("^that the deadline is (.*)$")
	public void thatTheDeadlineIs(@Transform(DateConverter.class)Date date) throws Throwable {
		
		delivery = date;
	}

	@When("^the delivery delays in (\\d+) (day|days|month|months)$")
	public void theDeliveryDelaysInDays(int arg1, String time) throws Throwable {
		Calendar cal = Calendar.getInstance();
		cal.setTime(delivery);
		if (time.equals("days")) {
			cal.add(Calendar.DAY_OF_MONTH, arg1);
			delivery = cal.getTime();
		}
		if (time.equals("months")) {
			cal.add(Calendar.MONTH, arg1);
			delivery = cal.getTime();
		}
	}

	@Then("^delivery will be effected on (\\d{2}\\/\\d{2}\\/\\d{4})$")
	public void deliveryWillBeEffectedOn(String date) throws Throwable {
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		String formatDate = format.format(delivery);
		Assert.assertEquals(date, formatDate);
	}
	
	
	
	@Given("^that the( special)? ticket is (A.\\d{3})$")
	public void thattheTicketIsAF(String type, String arg1) throws Throwable {
	    
	}

	@Given("^that the ticket price is R\\$ (.*)$")
	public void thatTheTicketPriceIsR$(Double number) throws Throwable {
	    
	}

	@Given("^that the name of the passenger is \"(.{5,20})\"$")
	public void thatTheNameOfThePassengerIs(String arg1) throws Throwable {
	    
	}

	@Given("^that the passenger's phone number is (9\\d{3}-\\d{4})$")
	public void thatThePassengerSPhoneNumberIs(String phone) throws Throwable {
	    
	}

	@When("^creating the steps$")
	public void creatingTheSteps() throws Throwable {
	  
	}

	@Then("^the test will work$")
	public void theTestWillWork() throws Throwable {
	    
	}
	

	

}
