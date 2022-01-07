package com.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Library.ReusableLibrary;

public class SearchHotelPage extends ReusableLibrary{

	public SearchHotelPage() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	@FindBy(name = "location")
	private WebElement textLocation;
	
	@FindBy(name = "hotels")
	private WebElement texthotels;
	
	@FindBy(name = "room_type")
	private WebElement textroom_type;
	
	@FindBy(name = "room_nos")
	private WebElement textroom_nos;
	
	@FindBy(id = "datepick_in")
	private WebElement textdatepick_in;
	
	@FindBy(id = "datepick_out")
	private WebElement textdatepick_out;
	
	@FindBy(name = "adult_room")
	private WebElement textadult_room;
	
	@FindBy(name = "child_room")
	private WebElement textchild_room;
	
	@FindBy(id = "Submit")
	private WebElement btnSubmit;
	
	@FindBy (xpath = "//td[@class='login_title']")
	private WebElement pageTitle;

	public WebElement getPageTitle() {
		return pageTitle;
	}

	public WebElement getTextLocation() {
		return textLocation;
	}

	public WebElement getTexthotels() {
		return texthotels;
	}

	public WebElement getTextroom_type() {
		return textroom_type;
	}

	public WebElement getTextroom_nos() {
		return textroom_nos;
	}

	public WebElement getTextdatepick_in() {
		return textdatepick_in;
	}

	public WebElement getTextdatepick_out() {
		return textdatepick_out;
	}

	public WebElement getTextadult_room() {
		return textadult_room;
	}

	public WebElement getTextchild_room() {
		return textchild_room;
	}

	public WebElement getBtnSubmit() {
		return btnSubmit;
	}
	public void searchHotel(String location,String hotel,String roomtype,String roomnos,String datepickin,String datepickout,String adultroom,String childroom)
	{
		selectByText(getTextLocation(), location);
		selectByText(getTexthotels(), hotel);
		selectByText(getTextroom_type(), roomtype);
		selectByText(getTextroom_nos(), roomnos);
		enterTextwithJS(getTextdatepick_in(), datepickin);
		enterTextwithJS(getTextdatepick_out(), datepickout);
		selectByText(getTextadult_room(), adultroom);
		selectByText(getTextchild_room(), childroom);
		click(getBtnSubmit());
	}
	public void verifyPageTitle(String expecetdTitle) {
		// TODO Auto-generated method stub
		
		Assert.assertEquals(getText(getPageTitle()), expecetdTitle);
		System.out.println(getText(getPageTitle()));
	}
}
