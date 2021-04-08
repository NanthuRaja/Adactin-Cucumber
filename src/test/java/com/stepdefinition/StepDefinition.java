package com.stepdefinition;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.base.BaseClass;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefinition extends BaseClass {

	@Given("user is in login page")
	public void user_is_in_login_page() {
		 WebDriverManager.chromedriver().setup();
	      driver=new ChromeDriver();
	      driver.get("https://adactinhotelapp.com/index.php");
	      driver.manage().window().maximize();

	}

	@When("user should enter userName and password")
	public void user_should_enter_userName_and_password(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> emp = dataTable.asMaps();
		Map<String, String> mp = emp.get(0);
		String user = mp.get("userName");
		String pass = mp.get("password");

		driver.findElement(By.id("userName")).sendKeys(user);
		driver.findElement(By.id("password")).sendKeys(pass);

	}

	@Then("user should click on login button")
	public void user_should_click_on_login_button() {
		driver.findElement(By.id("login")).click();
		
	}

	@Then("user should verify the msg")
	public void user_should_verify_the_msg() {
		String Url = driver.getCurrentUrl();
		boolean b = Url.contains("SearchHotel");
		Assert.assertTrue("verify url", b);

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

		WebElement e1 = driver.findElement(By.xpath("//select[@id='location']"));
		Select s = new Select(e1);
		s.selectByVisibleText(location);
		WebElement e2 = driver.findElement(By.xpath("//select[@id='hotels']"));
		Select s1 = new Select(e2);
		s1.selectByVisibleText(hotel);
		WebElement e3 = driver.findElement(By.xpath("//select[@id='room_type']"));
		Select s2 = new Select(e3);
		s2.selectByVisibleText(roomType);
		WebElement e4 = driver.findElement(By.xpath("//select[@id='room_nos']"));
		Select s3 = new Select(e4);
		s3.selectByVisibleText(numberOfRooms);
		WebElement e5 = driver.findElement(By.xpath("//input[@id='datepick_in']"));
        e5.clear(); 
		e5.sendKeys(checkInDate);
		WebElement e6 = driver.findElement(By.xpath("//input[@id='datepick_out']"));
		e6.clear();
		e6.sendKeys(checkOutDate);
		WebElement e7 = driver.findElement(By.xpath("//select[@id='adult_room']"));
		Select s4 = new Select(e7);
		s4.selectByVisibleText(adultsPerRoom);
		WebElement e8 = driver.findElement(By.xpath("//select[@id='child_room']"));
		Select s5 = new Select(e8);
		s5.selectByVisibleText(childrenPerRoom);
	}

	@Then("user should click the search button")
	public void user_should_click_the_search_button() {
		driver.findElement(By.id("Submit")).click();
	}

	@Then("user should click on radiobutton")
	public void user_should_click_on_radiobutton() {
		driver.findElement(By.id("radiobutton_0")).click();
	}

	@Then("user should click on continue button")
	public void user_should_click_on_continue_button() {
		driver.findElement(By.id("continue")).click();
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
		driver.findElement(By.id("first_name")).sendKeys(firstName);
		driver.findElement(By.id("last_name")).sendKeys(lastname);
		driver.findElement(By.id("address")).sendKeys(billingAddress);
		driver.findElement(By.id("cc_num")).sendKeys(creditCardNo);
		WebElement a1 = driver.findElement(By.id("cc_type"));
		Select sel = new Select(a1);
		sel.selectByVisibleText(creditCardType);
		WebElement a2 = driver.findElement(By.id("cc_exp_month"));
		Select sel1 = new Select(a2);
		sel1.selectByVisibleText(expiryMonth);
		WebElement a3 = driver.findElement(By.id("cc_exp_year"));
		Select sel2 = new Select(a3);
		sel2.selectByVisibleText(expiryYear);
		driver.findElement(By.id("cc_cvv")).sendKeys(cvv);
	}

	@Then("user should click on bookNow button")
	public void user_should_click_on_bookNow_button() {
		driver.findElement(By.id("book_now")).click();
		driver.manage().timeouts().implicitlyWait(7000, TimeUnit.MILLISECONDS);
		String text = driver.findElement(By.id("order_no")).getAttribute("value");
		System.out.println("orderId : " + text);
		driver.quit();
	}

}
