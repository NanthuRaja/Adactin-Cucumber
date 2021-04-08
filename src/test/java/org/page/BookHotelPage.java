package org.page;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookHotelPage extends BaseClass{
	public WebElement getFirstname() {
		return firstname;
	}

	public WebElement getLastname() {
		return lastname;
	}

	public WebElement getAddress() {
		return address;
	}

	public WebElement getCardno() {
		return cardno;
	}

	public WebElement getCardtype() {
		return cardtype;
	}

	public WebElement getExpmonth() {
		return expmonth;
	}

	public WebElement getExpyear() {
		return expyear;
	}

	public WebElement getCcv() {
		return ccv;
	}

	public WebElement getBook() {
		return book;
	}

	public BookHotelPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "first_name")
	private WebElement firstname;

	@FindBy(id = "last_name")
	private WebElement lastname;
	
	@FindBy(id = "address")
	private WebElement address;
	
	@FindBy(id = "cc_num")
	private WebElement cardno;
	
	@FindBy(id = "cc_type")
	private WebElement cardtype;
	
	@FindBy(id = "cc_exp_month")
	private WebElement expmonth;
	
	@FindBy(id = "cc_exp_year")
	private WebElement expyear;
	
	@FindBy(id="cc_cvv")
	private WebElement ccv;
	
	@FindBy(className ="reg_button")
	private WebElement book;

	
	public void bookHotel(String firstName,String lastname,String billingAddress,String creditCardNo,String creditCardType,String expiryMonth,String expiryYear,String cvv) {
		enterText(getFirstname(), firstName);
		enterText(getLastname(), lastname);
		enterText(getAddress(), billingAddress);
		enterText(getCardno(), creditCardNo);
		selectByVisibleText(getCardtype(), creditCardType);
		selectByVisibleText(getExpmonth(), expiryMonth);
		selectByVisibleText(getExpyear(), expiryYear);
		enterText(getCcv(), cvv);
		click(getBook());
	}
}
