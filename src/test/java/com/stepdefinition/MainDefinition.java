package com.stepdefinition;


import java.util.List;
import java.util.Map;

import org.base.BaseClass;
import org.openqa.selenium.By;
import org.page.BookHotelPage;
import org.page.LoginPage;
import org.page.SearchHotelPage;
import org.page.SelectHotelPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MainDefinition  extends BaseClass{
	
	@Given("user is in login page")
	public void user_is_in_login_page() {
        getdriver();
        loadUrl("https://adactinhotelapp.com/index.php");
	}

	@When("user should  login enter userName and password")
	public void user_should_login_enter_userName_and_password(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> emp = dataTable.asMaps();
		Map<String, String> mp = emp.get(0);
		String user = mp.get("userName");
		String pass = mp.get("password");
		LoginPage lp = new LoginPage();
		lp.login(user, pass);
	}

	@Then("user should  search hotel after select the location,hotel,roomType,numberOfRooms,checkInDate,checkOutDate,adultsPerRoom and childrenPerRoom")
	public void user_should_search_hotel_after_select_the_location_hotel_roomType_numberOfRooms_checkInDate_checkOutDate_adultsPerRoom_and_childrenPerRoom(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> e = dataTable.asMaps();
		Map<String, String> m = e.get(0);
		String location = m.get("location");
		String hotel = m.get("hotel");
		String roomType = m.get("roomType");
		String numberOfRooms = m.get("numberOfRooms");
		String checkInDate = m.get("checkInDate");
		String checkOutDate = m.get("checkOutDate");
		String adultsPerRoom = m.get("adultsPerRoom");
		String childrenPerRoom = m.get("childrenPerRoom");
		
		SearchHotelPage sh =new SearchHotelPage();
		sh.searchHotel(location, hotel, roomType, numberOfRooms, checkInDate, checkOutDate, adultsPerRoom, childrenPerRoom);
	    sh.getSubmit();
	}

	@Then("user should click on radiobutton and continue button")
	public void user_should_click_on_radiobutton_and_continue_button() {
		SelectHotelPage sp =new SelectHotelPage();
		sp.selectHotel();
	  
	}

	@Then("user should book hotel after enter firstName,lastname,billingAddress,creditCardNo,creditCardType,expiryMonth,expiryYear and cvv")
	public void user_should_book_hotel_after_enter_firstName_lastname_billingAddress_creditCardNo_creditCardType_expiryMonth_expiryYear_and_cvv(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> e = dataTable.asMaps();
		Map<String, String> m = e.get(0);
		String firstName = m.get("firstName");
		String lastname = m.get("lastname");
		String billingAddress = m.get("billingAddress");
		String creditCardNo = m.get("creditCardNo");
		String creditCardType = m.get("creditCardType");
		String expiryMonth = m.get("expiryMonth");
		String expiryYear = m.get("expiryYear");
		String cvv = m.get("cvv");
		
		BookHotelPage bh =new BookHotelPage();
		bh.bookHotel(firstName, lastname, billingAddress, creditCardNo, creditCardType, expiryMonth, expiryYear, cvv);
	    bh.getBook();
	    System.out.println( getAttribute(driver.findElement(By.id("order_no"))));
	    quit();
	}




}
