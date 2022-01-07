package com.pages;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Library.ReusableLibrary;

public class BookConfirmationPage extends ReusableLibrary{
//order_no
	public BookConfirmationPage() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	@FindBy(name = "order_no")
	private WebElement textOrderNum;
	
	@FindBy(linkText = "Booked Itinerary")
	private WebElement lnkItinerary;
	
	@FindBy (xpath = "//td[@class='login_title']")
	private WebElement pageTitle;

	public WebElement getPageTitle() {
		return pageTitle;
	}
	public WebElement getTextOrderNum() {
		return textOrderNum;
	}
	public WebElement getLnkItinerary() {
		return lnkItinerary;
	}
	public void bookConfirmation() throws InterruptedException, IOException {
		
		
		String pnrNumber = getAttributeValue(getTextOrderNum());
		Writedata("BookingDetail", 1, 18,pnrNumber); 
		System.out.println("order id "+ pnrNumber);
	}
	public void goToItinery() {
		click(getLnkItinerary());
	}
	public void verifyPageTile(String expectedTile) throws InterruptedException {
		Thread.sleep(7000);
		
		Assert.assertEquals(getText(getPageTitle()), expectedTile);
		System.out.println(getText(getPageTitle()));
	}
	
}
