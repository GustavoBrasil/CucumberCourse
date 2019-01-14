package br.com.gustavo.converts;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


import cucumber.api.Transformer;

public class DateConverter extends Transformer<Date> {

	@Override
	public Date transform(String value) {
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Date ret = format.parse(value);
			return ret;
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		return null;
	}

}
