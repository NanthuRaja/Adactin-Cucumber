Feature: Verifying the Adactin details 

Scenario: Verifying navigates to Select Hotel after entering all the fields 
	Given user is in login page 
	When user should login with valid credentials 
		|userName|password|
		|prakash0|J5M3AD|
	Then user should  search hotel after select the location,hotel,roomType,numberOfRooms,checkInDate,checkOutDate,adultsPerRoom and childrenPerRoom 
		| location | hotel| roomType | numberOfRooms | checkInDate| checkOutDate | adultsPerRoom | childrenPerRoom |
		|Melbourne | Hotel Sunshine | Deluxe | 1 - One | 10/04/2021 | 12/04/2021 | 2 - Two | 2 - Two |
	And user should verify the "Select Hotel" mesaage 
	
	
	
Scenario: Verifying navigates to Select Hotel after entering mandatory fields 
	Given user is in login page 
	When user should login with valid credentials 
		|userName|password|
		|prakash0|J5M3AD|
	Then user should  search hotel after select the location,numberOfRooms,checkInDate,checkOutDate and adultsPerRoom 
		| location | numberOfRooms | checkInDate| checkOutDate | adultsPerRoom | 
		|Melbourne | 1 - One | 10/04/2021 | 12/04/2021 | 2 - Two | 
	And user should verify the "Select Hotel" mesaage 
	
	
	
	
Scenario: Verifying checkindate and checkoutdate 
	Given user is in login page 
	When user should  login with valid credentials 
		|userName|password|
		|prakash0|J5M3AD|
	Then user should  search hotel after select the location,hotel,roomType,numberOfRooms,checkInDate,checkOutDate,adultsPerRoom and childrenPerRoom 
		| location | hotel| roomType | numberOfRooms | checkInDate| checkOutDate | adultsPerRoom | childrenPerRoom |
		|Melbourne | Hotel Sunshine | Deluxe | 1 - One | 10/04/2021 | 12/04/2021 | 2 - Two | 2 - Two |
	And user should verify the "Check-In Date shall be before than Check-Out Date", "Check-Out Date shall be after than Check-In Date" message 
	
	
	
Scenario: Verifying navigates to Select Hotel without entering any fields 
	Given user is in login page 
	When user should  login with valid credentials 
		|userName|password|
		|prakash0|J5M3AD|
	Then user should click on search button 
	And user should verify the "Please Select a Location" message 
	