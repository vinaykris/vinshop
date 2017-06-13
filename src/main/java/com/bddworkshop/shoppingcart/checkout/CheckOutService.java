package com.bddworkshop.shoppingcart.checkout;

import java.math.BigDecimal;

public class CheckOutService {

	public CheckOutItem checkOut(String user, String product, String price,
			String vat) {
		CheckOutItem checkOutItem = new CheckOutItem();
		checkOutItem.setUser(user);
		checkOutItem.setProduct(product);
		checkOutItem.setPrice(new BigDecimal(price));
		checkOutItem.setVat(new BigDecimal(vat));
		BigDecimal totalPrice = checkOutItem.getPrice().add((checkOutItem.getPrice().multiply(checkOutItem.getVat())
				.divide(new BigDecimal("100"))));
		checkOutItem.setTotalPrice(totalPrice);
		return checkOutItem;

	}

}
