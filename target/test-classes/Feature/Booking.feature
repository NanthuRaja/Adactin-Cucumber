Feature: Verifying the Adactin details 

Scenario: Verifying the booking details after entering all the fields
	Given user is in login page 
	When user should  login with valid credentials
		|userName|password|
		|prakash0|J5M3AD|
	Then user should  search hotel after select the location,hotel,roomType,numberOfRooms,checkInDate,checkOutDate,adultsPerRoom and childrenPerRoom 
		| location | hotel| roomType | numberOfRooms | checkInDate| checkOutDate | adultsPerRoom | childrenPerRoom |
		|Melbourne | Hotel Sunshine | Deluxe | 1 - One | 10/04/2021 | 12/04/2021 | 2 - Two | 2 - Two |
	Then user should click on radiobutton and continue button 
	Then user should book hotel after enter firstName,lastname,billingAddress,creditCardNo,creditCardType,expiryMonth,expiryYear and cvv 
		| firstName | lastname | billingAddress | creditCardNo | creditCardType | expiryMonth | expiryYear | cvv |
		| Nantha | Kumar | Australia | 9876543210123456 |  VISA | May | 2021 | 111 |
	And user should verify the "Booking Confirmation" message 
	
	
	
Scenario: Verifying the booking details without entering any fields
	Given user is in login page 
	When user should login with valid credentials 
		|userName|password|
		|prakash0|J5M3AD|
	Then user should  search hotel after select the location,hotel,roomType,numberOfRooms,checkInDate,checkOutDate,adultsPerRoom and childrenPerRoom 
		| location | hotel| roomType | numberOfRooms | checkInDate| checkOutDate | adultsPerRoom | childrenPerRoom |
		|Melbourne | Hotel Sunshine | Deluxe | 1 - One | 10/04/2021 | 12/04/2021 | 2 - Two | 2 - Two |
	Then user should click on radiobutton and continue button 
	Then user should click on book button  
	And user should verify the "Please Enter your First Name", "Please Enter you Last Name", "Please Enter your Address", "Please Enter your 16 Digit Credit Card Number", "Please Select your Credit Card Type", "Please Select your Credit Card Expiry Month", "Please Enter your Credit Card CVV Number" message 
	
