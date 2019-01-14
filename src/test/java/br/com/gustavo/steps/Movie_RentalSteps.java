package br.com.gustavo.steps;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.junit.Assert;

import br.com.gustavo.entities.Movie;
import br.com.gustavo.entities.RentNote;
import br.com.gustavo.entities.RentType;
import br.com.gustavo.services.RentalService;
import br.com.gustavo.utils.DateUtils;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Movie_RentalSteps {

	private Movie movies;
	private RentalService rentals = new RentalService();
	private RentNote note;
	private String error;
	private RentType rentalType;
	
	@Given("^a film with stock of (\\d+) units$")
	public void aFilmWithStockOfUnits(int arg1) throws Throwable {
	    movies = new Movie();
	    movies.setStock(arg1);
	}

	@Given("^that the rental price is R\\$ (\\d+)$")
	public void thatTheRentalPriceIsR$(int arg1) throws Throwable {
	    movies.setRental(arg1);
	}
	
	@Given("^a film$")
	public void aFilm(DataTable table) throws Throwable {
	    Map<String, String>map = table.asMap(String.class,String.class);
	    movies = new Movie();
	    movies.setStock(Integer.parseInt(map.get("stock")));
	    movies.setRental(Integer.parseInt(map.get("price")));
	    String type = map.get("type");
	   rentalType = type.equals("weekly")?  RentType.WEEKLY: type.equals("extended")? RentType.EXTENDED: RentType.COMMON;

	}

	@When("^to rent$")
	public void toRent() throws Throwable {
	  try {
		note =  rentals.toRents(movies,rentalType);
	  }catch (RuntimeException e) {
		error = e.getMessage();
	}
	}

	@Then("^the rental price will be R\\$ (\\d+)$")
	public void theRentalPriceWillBeR$(int arg1) throws Throwable {
	    Assert.assertEquals(arg1, note.getPrice());
	}

	@Then("^the movie stock will be (\\d+) unit$")
	public void theMovieStockWillBeUnit(int arg1) throws Throwable {
		Assert.assertEquals(arg1, movies.getStock());
	}
	
	@Then("^it will not be possible due to lack of stock$")
	public void itWillNotBePossibleDueToLackOfStock() throws Throwable {
		Assert.assertEquals("Movie no stock",error);
	}
	
	@Given("^let the type of rent be (.*)$")
	public void letTheTypeOfRentBeExtended(String type) throws Throwable {
	  rentalType = type.equals("weekly")?  RentType.WEEKLY: type.equals("extended")? RentType.EXTENDED: RentType.COMMON;
	}

	@Then("^the delivery date will be in (\\d+) days?$")
	public void theDeliveryDateWillBeInDays(int arg1) throws Throwable {
	   Date expectedDate = DateUtils.differentsDates(arg1);
	   Date realDate = note.getDataEntrega();
	   DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	   Assert.assertEquals(format.format(expectedDate),format.format(realDate));
	}

	@Then("^the score received will be (\\d+) points$")
	public void theScoreReceivedWillBePoints(int arg1) throws Throwable {
		Assert.assertEquals(arg1,note.getPointing());
	}
	

	
}
