package com.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Library.ReusableLibrary;

public class CancelBookPage extends ReusableLibrary{

	public CancelBookPage() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	@FindBy(id = "order_id_text")
	private WebElement textOredrId;
	
	@FindBy(id = "search_hotel_id")
	private WebElement clickSearch;
	
	@FindBy(xpath = "//input[contains(@value,'Cancel')]")
	private WebElement btnCancel;
	
	@FindBy(id = "search_result_error")
	private WebElement textMessage;

	public WebElement getTextOredrId() {
		return textOredrId;
	}

	public WebElement getClickSearch() {
		return clickSearch;
	}

	public WebElement getBtnCancel() {
		return btnCancel;
	}

	public WebElement getTextMessage() {
		return textMessage;
	}
	public void cancelBooking(String pnrnumber) {
		
		enterText(getTextOredrId(),pnrnumber);
		click(getClickSearch());
		click(getBtnCancel());
		acceptAlert();
		
	}
	public void verifyCancelMessage(String expected) {
		// TODO Auto-generated method stub
		
		Assert.assertEquals(getText(getTextMessage()), expected);
		System.out.println(getText(getTextMessage()));
		
	}
	
	
}
