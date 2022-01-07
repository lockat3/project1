package com.test;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.Library.ReusableLibrary;
import com.pages.BookConfirmationPage;
import com.pages.BookHotelPage;
import com.pages.CancelBookPage;
import com.pages.LoginPage;
import com.pages.SearchHotelPage;
import com.pages.SelectHotelPage;

public class Testing extends ReusableLibrary{
	
	@BeforeClass
	public static void beforeClass() {
		setDriver();
		launchUrl("https://adactinhotelapp.com/index.php");
		maximizeWindow();
	}
	@Test
	public void testingmethod() throws IOException, InterruptedException
	{
		LoginPage loginPage = new LoginPage();
		loginPage.verifyLogin("Existing User Login - Build 1");
		loginPage.login( getData("BookingDetail",1, 0),  getData("BookingDetail",1, 1));
		
		SearchHotelPage searchHotelPage = new SearchHotelPage();
		searchHotelPage.verifyPageTitle("Search Hotel (Fields marked with Red asterix (*) are mandatory)");
		searchHotelPage.searchHotel( getData("BookingDetail", 1, 2), getData("BookingDetail", 1, 3), 
				getData("BookingDetail", 1, 4), getData("BookingDetail", 1, 5),
				getData("BookingDetail", 1, 6), getData("BookingDetail", 1, 7),
				getData("BookingDetail", 1, 8), getData("BookingDetail", 1, 9));
		
		
		SelectHotelPage selectHotelPage = new SelectHotelPage();
		selectHotelPage.verifyPageTile("Select Hotel");
		selectHotelPage.selectHotel();
		
		BookHotelPage  bookhotelpage= new BookHotelPage();
		bookhotelpage.verifyPageTile("Book A Hotel");
		bookhotelpage.BookHotel( getData("BookingDetail", 1, 10), getData("BookingDetail", 1, 11), 
				getData("BookingDetail", 1, 12), getData("BookingDetail", 1, 13),
				getData("BookingDetail", 1, 14), getData("BookingDetail", 1, 15),
				getData("BookingDetail", 1, 16), getData("BookingDetail", 1,17));
		
		
		BookConfirmationPage bookConfirmationPage = new BookConfirmationPage();
		bookConfirmationPage.verifyPageTile("Booking Confirmation");
		bookConfirmationPage.bookConfirmation();
		bookConfirmationPage.goToItinery();
		
		CancelBookPage cancelBookPage = new CancelBookPage();
		cancelBookPage.cancelBooking(getData("BookingDetail", 1, 18));
		cancelBookPage.verifyCancelMessage("The booking has been cancelled.");
		
		
		
	}
	@AfterClass
	public static void afterClass() {
		// TODO Auto-generated method stub
		closeBrowser();
	}

}
