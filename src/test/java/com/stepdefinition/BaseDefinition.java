package com.stepdefinition;

import java.util.List;
import java.util.Map;

import org.base.BaseClass;
import org.openqa.selenium.By;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BaseDefinition extends BaseClass {

	@Given("user is in login page")
	public void user_is_in_login_page() {

		getdriver();
		loadUrl("https://adactinhotelapp.com/index.php");
	}

	@When("user should enter userName and password")
	public void user_should_enter_userName_and_password(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> emp = dataTable.asMaps();
		Map<String, String> mp = emp.get(0);
		String user = mp.get("userName");
		String pass = mp.get("password");

		enterText(driver.findElement(By.id("userName")), user);
		enterText(driver.findElement(By.id("password")), pass);

	}

	@Then("user should click on login button")
	public void user_should_click_on_login_button() {

		click(driver.findElement(By.id("login")));
	}

	@Then("user should select the location,hotel,roomType,numberOfRooms,checkInDate,checkOutDate,adultsPerRoom and childrenPerRoom")
	public void user_should_select_the_location_hotel_roomType_numberOfRooms_checkInDate_checkOutDate_adultsPerRoom_and_childrenPerRoom(
			io.cucumber.datatable.DataTable dataTable) {

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

		selectByVisibleText(driver.findElement(By.xpath("//select[@id='location']")), location);
		selectByVisibleText(driver.findElement(By.xpath("//select[@id='hotels']")), hotel);
		selectByVisibleText(driver.findElement(By.xpath("//select[@id='room_type']")), roomType);
		selectByVisibleText(driver.findElement(By.xpath("//select[@id='room_nos']")), numberOfRooms);
		selectByVisibleText(driver.findElement(By.xpath("//input[@id='datepick_in']")), checkInDate);
		selectByVisibleText(driver.findElement(By.xpath("//input[@id='datepick_out']")), checkOutDate);
		selectByVisibleText(driver.findElement(By.xpath("//select[@id='adult_room']")), adultsPerRoom);
		selectByVisibleText(driver.findElement(By.xpath("//select[@id='child_room']")), childrenPerRoom);

	}

	@Then("user should click the search button")
	public void user_should_click_the_search_button() {
		click(driver.findElement(By.id("Submit")));
	}

	@Then("user should click on radiobutton")
	public void user_should_click_on_radiobutton() {
		click(driver.findElement(By.id("radiobutton_0")));
	}
	

	@Then("user should click on continue button")
	public void user_should_click_on_continue_button() {
		click(driver.findElement(By.id("continue")));
	}
	
	@Then("user should enter firstName,lastname,billingAddress,creditCardNo,creditCardType,expiryMonth,expiryYear and cvv")
	public void user_should_enter_firstName_lastname_billingAddress_creditCardNo_creditCardType_expiryMonth_expiryYear_and_cvv(
			io.cucumber.datatable.DataTable dataTable) {

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
		enterText(driver.findElement(By.id("first_name")), firstName);
		enterText(driver.findElement(By.id("last_name")), lastname);
		enterText(driver.findElement(By.id("address")), billingAddress);
		enterText(driver.findElement(By.id("cc_num")), creditCardNo);
		selectByVisibleText(driver.findElement(By.id("cc_type")), creditCardType);
		selectByVisibleText(driver.findElement(By.id("cc_exp_month")), expiryMonth);
		selectByVisibleText(driver.findElement(By.id("cc_exp_year")), expiryYear);
		enterText(driver.findElement(By.id("cc_cvv")), cvv);
	}

	@Then("user should click on bookNow button")
	public void user_should_click_on_bookNow_button() {
		click(driver.findElement(By.id("book_now")));
		getAttribute(driver.findElement(By.id("order_no")));
		quit();
	}
	
	
	
	
	
	
	
	
	
	
	
}

