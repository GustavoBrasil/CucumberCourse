package br.com.gustavo.entities;

public class Movie {
	private int stock;
	private int rental;

	public void setStock(int arg1) {
		this.stock = arg1;

	}

	public void setRental(int arg1) {
		this.rental = arg1;
	}

	public int getRent() {
		return rental;
	}

	public int getStock() {
		
		return stock;
	}

}
