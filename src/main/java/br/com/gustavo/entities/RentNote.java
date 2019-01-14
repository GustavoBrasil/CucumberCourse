package br.com.gustavo.entities;

import java.util.Date;

public class RentNote {
private int price;
private int point;
private Date deliveryDate;
 

public int getPrice() {
	return price;
}

public void setPrice(int price) {
	this.price = price;
}

public Date getDataEntrega() {
	return deliveryDate;
}

public void setDeliveryDate(Date time) {
	deliveryDate = time;
	
}

public int getPointing() {
	
	return point;
}

public void setPointing(int point) {
	this.point = point;
	
}

}
