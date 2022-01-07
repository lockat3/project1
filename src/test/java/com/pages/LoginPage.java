package com.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Library.ReusableLibrary;

public class LoginPage extends ReusableLibrary{
	public LoginPage() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	@FindBy(id = "username")
	private WebElement textUserName;
	
	@FindBy(id = "password")
	private WebElement textPassword;
	
	@FindBy(id = "login")
	private WebElement btnLogin;
	
	@FindBy (xpath = "//td[@class='login_title']")
	private WebElement pageTitle;

	public WebElement getPageTitle() {
		return pageTitle;
	}

	public WebElement getTextUserName() {
		return textUserName;
	}

	public WebElement getTextPassword() {
		return textPassword;
	}

	public WebElement getBtnLogin() {
		return btnLogin;
	}
	
	public void login(String userName, String password)
	{
		enterText(getTextUserName(), userName);
		enterText(getTextPassword(), password);
		click(getBtnLogin());
		
	}
	public void verifyLogin(String expecetdTitle) {
		
		Assert.assertEquals(getText(getPageTitle()),expecetdTitle);
		System.out.println(getText(getPageTitle()));
	}

}
