package com.tobin.homepage;

import junit.framework.Assert;

import org.springframework.beans.factory.annotation.Autowired;

import com.tobin.selenium.HomePage;
import com.tobin.selenium.WebSite;

import cucumber.annotation.After;
import cucumber.annotation.Before;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;

public class HomePageSteps {
	@Autowired WebSite webSite;
	
	private HomePage homePage; 
	
	@Before
	public void beforeScenario() {
		Assert.assertNull( homePage );
	}
	
	@Given("^I open the home page$")
	public void I_open_the_home_page() throws Throwable {
		homePage = webSite.openHomePage();
		Assert.assertNotNull( homePage );
	}

	@Then("^the page title is \"([^\"]*)\"$")
	public void the_page_title_is(String title) throws Throwable {
		Assert.assertNotNull( homePage );
		Assert.assertNotNull( homePage.getTitle() );
		Assert.assertEquals(title,homePage.getTitle().getText());
	}

	@Then("^the h(\\d+) is \"([^\"]*)\"$")
	public void the_h_is(int header, String text) throws Throwable {
		Assert.assertNotNull( homePage );
		Assert.assertNotNull( homePage.getH2() );
		Assert.assertEquals( text,homePage.getH2().getText() );		
	}
	
	@After
	public void afterScenario() {
		if( homePage != null ) {
			homePage.close();
		}
		homePage = null;
	}
}
