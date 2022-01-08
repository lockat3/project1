package com.Library;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReusableLibrary {
	public static WebDriver driver;

	public static void setDriver() {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	public static void maximizeWindow() {
		driver.manage().window().maximize();
	}

	public WebElement findLocatorById(String id) {
		WebElement element = driver.findElement(By.id(id));
		return element;
	}

	public WebElement findLocatorByName(String name) {
		WebElement element = driver.findElement(By.name(name));
		return element;
	}

	public WebElement findLocatorByClassName(String classname) {
		WebElement element = driver.findElement(By.className(classname));
		return element;
	}

	public WebElement findLocatorByXpath(String xpath) {
		WebElement element = driver.findElement(By.xpath(xpath));
		return element;
	}

	public WebElement findLocatorByPartialLinkText(String partiallinktext) {
		WebElement element = driver.findElement(By.partialLinkText(partiallinktext));
		return element;
	}

	public WebElement findLocatorByTagName(String tagname) {
		WebElement element = driver.findElement(By.tagName(tagname));
		return element;
	}

	public WebElement findLocatorByLinkText(String linktext) {
		WebElement element = driver.findElement(By.linkText(linktext));
		return element;
	}

	public void enterText(WebElement element, String textcontent) {
		element.sendKeys(textcontent);
	}

	public String getText(WebElement element) {
		String text = element.getText();
		return text;
	}

	public String getAttributeValue(WebElement element, String attname) {
		String attValue = element.getAttribute(attname);
		return attValue;
	}

	public String getAttributeValue(WebElement element) {
		String attValue = element.getAttribute("Value");
		return attValue;
	}

	public void click(WebElement element) {
		element.click();
	}

	public void dragAndDrop(WebElement dragelement, WebElement dropelement) {
		Actions action = new Actions(driver);
		action.dragAndDrop(dragelement, dropelement).perform();
	}

	public void movoToElement(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element);
	}

	public void mouseRightClick(WebElement element) {
		Actions action = new Actions(driver);
		action.contextClick(element).perform();
		;
	}

	public void mouseDoubleClick(WebElement element) {
		Actions action = new Actions(driver);
		action.doubleClick(element).perform();
	}

	public void acceptAlert() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public void dismissAlert() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	public void enterTextInAlert(String text) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(text);
		alert.accept();
	}

	public String GetmessageFromAlert() {
		Alert alert = driver.switchTo().alert();
		String alertmessage = alert.getText();
		alert.accept();
		return alertmessage;
	}

	public void goForward() {
		driver.navigate().forward();
	}

	public void goBackward() {
		driver.navigate().back();
	}

	public void pageRefresh() {
		driver.navigate().refresh();
	}

	public void navigate(String url) {
		driver.navigate().to(url);
	}

	public static void launchUrl(String url) {
		driver.get(url);
	}

	public String getUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}

	public void enterTextwithJS(WebElement element, String value) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].setAttribute('value','" + value + "')", element);
	}

	public String getTextwithJS(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		String textcontent = executor.executeScript("argument[0].getAttribute('value')", element).toString();
		return textcontent;
	}

	public void clickWithJS(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click()", element);
	}

	public void scrolldowmwithJS(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(true)", element);
	}

	public void scrollUpwithJS(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(false)", element);
	}

	public void selectByText(WebElement element, String selectvalue) {
		Select select = new Select(element);
		select.selectByVisibleText(selectvalue);
	}

	public void selectByAttributeValue(WebElement element, String Attvalue) {
		Select select = new Select(element);
		select.selectByValue(Attvalue);
	}

	public void selectByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	public List<WebElement> getAllDropDownOption(WebElement element) {
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		return options;
	}

	public List<WebElement> getAllSelectedDropDownOption(WebElement element) {
		Select select = new Select(element);
		List<WebElement> allSelectedOptions = select.getAllSelectedOptions();
		return allSelectedOptions;
	}

	public WebElement getFirsTSelectedOption(WebElement element) {
		Select select = new Select(element);
		WebElement firstselectedoption = select.getFirstSelectedOption();
		return firstselectedoption;
	}

	public void deselectByText(WebElement element, String selectvalue) {
		Select select = new Select(element);
		select.deselectByVisibleText(selectvalue);
	}

	public void deselectByAttributeValue(WebElement element, String Attvalue) {
		Select select = new Select(element);
		select.deselectByValue(Attvalue);
	}

	public void deselectByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.deselectByIndex(index);
	}

	public void deselectAll(WebElement element) {
		Select select = new Select(element);
		select.deselectAll();
	}

	public boolean IsSelectMultiple(WebElement element) {
		Select select = new Select(element);
		boolean multiple = select.isMultiple();
		return multiple;
	}

	public void SwitchToFrameByIndex(int frameindex) {
		driver.switchTo().frame(frameindex);
	}

	public void SwitchToFrameByFrameId(String frameid) {
		driver.switchTo().frame(frameid);
	}

	public void swithToFrameByElement(WebElement element) {
		driver.switchTo().frame(element);
	}

	public void swithToWindowById(String windowId) {
		driver.switchTo().window(windowId);

	}

	public void swithToWindowByTitle(String windowTitle) {
		driver.switchTo().window(windowTitle);

	}

	public void swithToWindowByUrl(String windowurl) {
		driver.switchTo().window(windowurl);
	}

	public void switchToChildWindow() {
		String parentWindowId = driver.getWindowHandle();
		Set<String> allWindowId = driver.getWindowHandles();
		for (String eachwindowId : allWindowId) {
			if (!parentWindowId.equals(eachwindowId)) {
				driver.switchTo().window(eachwindowId);
			}
		}
	}

	public static void closeBrowser() {
		driver.quit();
	}

	public void closeWindow() {
		driver.close();
	}

	public Set<String> getWindowId() {
		Set<String> windowHandles = driver.getWindowHandles();
		return windowHandles;
	}

	public String getCurrentWindowId() {
		String windowHandle = driver.getWindowHandle();
		return windowHandle;
	}

	public void gotoParentFrame() {
		driver.switchTo().parentFrame();
	}

	public void gotoDefaultFrame() {
		driver.switchTo().defaultContent();
	}

	public File takeScreenshot() {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
		return screenshotAs;
	}

	public File takeScreenshotByElement(WebElement element) {
		File screenshotAs = element.getScreenshotAs(OutputType.FILE);
		return screenshotAs;
	}

	public String getData(String Sheetname, int rowNum, int cellnum) throws IOException {
		File f = new File("C:\\Users\\ADMIN\\eclipse-workspace\\AdactinHotelApp\\excelFiles\\DataTable.xlsx");
		FileInputStream in = new FileInputStream(f);
		Workbook workbook = new XSSFWorkbook(in);
		Sheet sheet = workbook.getSheet(Sheetname);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellnum);
		int cellType = cell.getCellType();
		String data = null;
		if (cellType == 1) {
			data = cell.getStringCellValue();
		}
		if (cellType == 0) {
			if (DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
				data = sf.format(dateCellValue);

			} else {
				double numericCellValue = cell.getNumericCellValue();
				long l = (long) numericCellValue;
				data = String.valueOf(l);
			}
		}
		return data;
	}

	public void Writedata(String Sheetname, int rowNum, int cellnum, String newdata) throws IOException {
		File f = new File("C:\\Users\\ADMIN\\eclipse-workspace\\AdactinHotelApp\\excelFiles\\DataTable.xlsx");
		FileInputStream in = new FileInputStream(f);
		Workbook workbook = new XSSFWorkbook(in);
		Sheet sheet = workbook.getSheet(Sheetname);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.createCell(cellnum);
		cell.setCellValue(newdata);
		FileOutputStream out = new FileOutputStream(f);
		workbook.write(out);

	}
	private void newReusableMethod() {
		// TODO Auto-generated method stub
		System.out.println("Method added by Dev");
	}
}
