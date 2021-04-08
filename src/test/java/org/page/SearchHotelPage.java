package org.page;

import org.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchHotelPage extends BaseClass {

	public SearchHotelPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "location")
	private WebElement location;

	public WebElement getLocation() {
		return location;
	}

	public WebElement getHotel() {
		return hotel;
	}

	public WebElement getRoom() {
		return room;
	}

	public WebElement getRoomnos() {
		return roomnos;
	}

	public WebElement getDatein() {
		return datein;
	}

	public WebElement getDateout() {
		return dateout;
	}

	public WebElement getAdult() {
		return adult;
	}

	public WebElement getChild() {
		return child;
	}

	public WebElement getSubmit() {
		return submit;
	}

	@FindBy(id = "hotels")
	private WebElement hotel;

	@FindBy(id = "room_type")
	private WebElement room;

	@FindBy(id = "room_nos")
	private WebElement roomnos;

	@FindBy(id = "datepick_in")
	private WebElement datein;

	@FindBy(id = "datepick_out")
	private WebElement dateout;

	@FindBy(id = "adult_room")
	private WebElement adult;

	@FindBy(id = "child_room")
	private WebElement child;

	@FindBy(id = "Submit")
	private WebElement submit;
	
	public void searchHotel(String location,String hotel,String roomType,String numberOfRooms,String checkInDate,String checkOutDate,String adultsPerRoom, String childrenPerRoom) {
		
		selectByVisibleText( getLocation() , location);
		selectByVisibleText( getHotel() , hotel);
		selectByVisibleText( getRoom() , roomType);
		selectByVisibleText( getRoomnos() , numberOfRooms);
		enterText( getDatein() , checkInDate);
		enterText( getDateout() , checkOutDate);
		selectByVisibleText( getAdult() , adultsPerRoom);
		selectByVisibleText( getChild() , childrenPerRoom);
		click(getSubmit());
	}

}
