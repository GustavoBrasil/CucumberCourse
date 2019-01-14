package br.com.gustavo.services;

import br.com.gustavo.entities.Movie;
import br.com.gustavo.entities.RentNote;
import br.com.gustavo.entities.RentType;
import br.com.gustavo.utils.DateUtils;

public class RentalService {

	public RentNote toRents(Movie movies, RentType rentalType) {
		if (movies.getStock() == 0)
			throw new RuntimeException("Movie no stock");
		RentNote note = new RentNote();
		switch (rentalType) {
		case COMMON:
			note.setPrice(movies.getRent());
			note.setDeliveryDate(DateUtils.differentsDates(1));
			note.setPointing(1);
			break;
			
		case EXTENDED:
			note.setPrice(movies.getRent()*2);
			note.setDeliveryDate(DateUtils.differentsDates(3));
			note.setPointing(2);
			break;
			
		case WEEKLY:
			note.setPrice(movies.getRent()*3);
			note.setDeliveryDate(DateUtils.differentsDates(7));
			note.setPointing(3);
			break;
		
		}
				
		movies.setStock(movies.getStock() - 1);
		return note;
	}

}
