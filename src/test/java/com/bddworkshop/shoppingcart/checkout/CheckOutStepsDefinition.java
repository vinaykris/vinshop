package com.bddworkshop.shoppingcart.checkout;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.*;

public class CheckOutStepsDefinition {
	
	private String user;
	private String product;
	private String price;
	private String vat;
	private CheckOutService checkOutService = new CheckOutService();
	CheckOutItem checkOutItem = null; 
	
	
	@Given("^user \"([^\"]*)\" has logged in$")
	public void user_has_logged_in(String user) throws Throwable {
		this.user = user; 
	}

	@Given("^has \"([^\"]*)\" mobile in the cart priced Rs \"([^\"]*)\"$")
	public void has_mobile_in_the_cart_priced_Rs(String product, String price) throws Throwable {
	    this.product = product;
	    this.price = price;
	}

	@Given("^Vat is \"([^\"]*)\" %$")
	public void Vat_is_(String vat) throws Throwable {
	    this.vat = vat;
	}

	@When("^user checks out the cart$")
	public void user_checks_out_the_cart() throws Throwable {
	    this.checkOutItem = checkOutService.checkOut(user, product, price, vat);
	}

	@Then("^confirmation of billing is generated with \"([^\"]*)\" mobile$")
	public void confirmation_of_billing_is_generated_with_mobile(String productInCheckOut) throws Throwable {
	    assertEquals(productInCheckOut, checkOutItem.getProduct());
	}

	@Then("^Total price is Rs \"([^\"]*)\"$")
	public void Total_price_is_Rs(String totalPriceInCheckOut) throws Throwable {
		assertEquals(new BigDecimal(totalPriceInCheckOut), checkOutItem.getTotalPrice());
	}

}
