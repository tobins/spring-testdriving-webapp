Feature: Home Page Features

Scenario: Title is set on the Home Page
	Given I open the home page
	Then the page title is "Sample Spring Web Application"
	
Scenario: H2 is set on the Home Page
	Given I open the home page
	Then the h2 is "Hello World!"
	
