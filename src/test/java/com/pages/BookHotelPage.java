package com.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Library.ReusableLibrary;

public class BookHotelPage extends ReusableLibrary {
	
	public BookHotelPage() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver,this);
	}

	@FindBy(id = "first_name")
	private WebElement textFirstName;
	
	@FindBy(id = "last_name")
	private WebElement textLastName;
	
	@FindBy(id = "address")
	private WebElement textAddress;
	
	@FindBy(id = "cc_num")
	private WebElement textCCNum;
	
	@FindBy(name  = "cc_type")
	private WebElement dropDwnCCType;
	
	@FindBy(name = "cc_exp_year")
	private WebElement dropDwnCCExpYear;
	
	@FindBy(name = "cc_exp_month")
	private WebElement dropDwnExpMonth;
	
	@FindBy(id = "cc_cvv")
	private WebElement textCCCvv;
	
	@FindBy(id = "book_now")
	private WebElement btnBookNow;
	
	@FindBy (xpath = "//tr[2][td[@class='login_title']]")
	private WebElement pageTitle;

	public WebElement getPageTitle() {
		return pageTitle;
	}

	public WebElement getTextFirstName() {
		return textFirstName;
	}

	public WebElement getTextLastName() {
		return textLastName;
	}

	public WebElement getTextAddress() {
		return textAddress;
	}

	public WebElement getTextCCNum() {
		return textCCNum;
	}

	public WebElement getDropDwnCCType() {
		return dropDwnCCType;
	}

	public WebElement getDropDwnCCExpYear() {
		return dropDwnCCExpYear;
	}

	public WebElement getDropDwnExpMonth() {
		return dropDwnExpMonth;
	}

	public WebElement getTextCCCvv() {
		return textCCCvv;
	}

	public WebElement getBtnBookNow() {
		return btnBookNow;
	}
	public void BookHotel(String firstname, String lastname , String address,String ccnum, String cctype , String ccyear , String ccexpmonth ,String cccvv) {
		enterText(getTextFirstName(), firstname);
		enterText(getTextLastName(), lastname);
		enterText(getTextAddress(), address);
		enterText(getTextCCNum(), ccnum);
		selectByText(getDropDwnCCType(), cctype);
		selectByText(getDropDwnCCExpYear(),ccyear );
		selectByText(getDropDwnExpMonth(),ccexpmonth );
		enterText(getTextCCCvv(), cccvv);
		click(getBtnBookNow());
		
	}
	public void verifyPageTile(String expectedTile) {
		
		Assert.assertEquals(getText(getPageTitle()), expectedTile);
		System.out.println(getText(getPageTitle()));
	}
}
