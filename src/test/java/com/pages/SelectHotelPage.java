package com.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Library.ReusableLibrary;

public class SelectHotelPage extends ReusableLibrary{
	public SelectHotelPage() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver,this);
	}
	@FindBy(name = "radiobutton_0")
	private WebElement radioBtnSelect;
	
	@FindBy(id = "continue")
	private WebElement btnContinue;

	@FindBy (xpath = "//td[@class='login_title']")
	private WebElement pageTitle;

	public WebElement getPageTitle() {
		return pageTitle;
	}
	public WebElement getRadioBtnSelect() {
		return radioBtnSelect;
	}

	public WebElement getBtnContinue() {
		return btnContinue;
	}
	public void verifyPageTile(String expectedTile) {
		
		Assert.assertEquals(getText(getPageTitle()), expectedTile);
		System.out.println(getText(getPageTitle()));
	}
	public void selectHotel()
	{
		click(getRadioBtnSelect());
		click(getBtnContinue());
	}

}
