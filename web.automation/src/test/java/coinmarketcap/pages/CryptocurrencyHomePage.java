package coinmarketcap.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CryptocurrencyHomePage {

	// Locators
	@FindBy(xpath = "(//p[text()='Show rows'])[1]/following-sibling::div")
	WebElement lstShowRows;// variable

	@FindBy(xpath = "//div[contains(@class,'dropdown-container')]/button[text()='20']")
	WebElement optShowRow20;

	@FindBy(xpath = "(//p[text()='Show rows'])[1]/../..//button[text()='Filters']")
	WebElement btnFiltters;

	@FindBy(xpath = "//button[text()='Algorithm']")
	WebElement lstAlgorithm;

	@FindBy(xpath = "//h6[text()='Popular Algorithms']/parent::div//li[text()='PoW']")
	WebElement optPowAlgorithm;
	//
	@FindBy(xpath = "//button[text()='Add Filter']")
	WebElement selectmorthanfilters;

	@FindBy(xpath = "//button[text()='All Cryptocurrencies']/div")
	WebElement clkoptioncryptocurrencies;

	@FindBy(xpath = "//button[text()='Coins']")
	WebElement dropdowncoinsclk;

	@FindBy(xpath = "//button[text()='Price']")
	WebElement selectprice; // variable

	@FindBy(xpath = "//input[@data-qa-id='range-filter-input-min']")
	WebElement selectminprice;

	@FindBy(xpath = "//input[@data-qa-id='range-filter-input-max']")
	WebElement selectmaxprice;

	@FindBy(xpath = "//button[text()='Apply Filter']")
	WebElement applyfilters;

	@FindBy(xpath = "//button[text()='Show results']")
	WebElement showresults;

	@FindBy(xpath = "//table//tr[not(th)]")
	List<WebElement> rowsTable;

	WebDriver driver;

	// constructor
	public CryptocurrencyHomePage(WebDriver driver) {
		this.driver = driver;
		// non-parameterized constructor
		PageFactory.initElements(driver, this);
	}

	// methods
	public CryptocurrencyHomePage setNumberOfRowsAs20() throws InterruptedException {
		lstShowRows.click();
		Thread.sleep(1000);
		optShowRow20.click();
		return this;
	}

	public int getNumberOfRows() {
		return rowsTable.size();
	}

	public CryptocurrencyHomePage showAdditionalFilters() throws InterruptedException {
		btnFiltters.click();
		Thread.sleep(1000);
		return this;
	}

	public CryptocurrencyHomePage setAlgorithmAsPow() throws InterruptedException {
		lstAlgorithm.click();
		Thread.sleep(1000);
		optPowAlgorithm.click();
		return this;
	}

	public CryptocurrencyHomePage addFilters() throws InterruptedException {
		selectmorthanfilters.click();
		Thread.sleep(1000);
		return this;
	}

	public CryptocurrencyHomePage selectCryptocurrencyAsCoin() throws InterruptedException {
		clkoptioncryptocurrencies.click();
		Thread.sleep(1000);
		dropdowncoinsclk.click();
		return this;
	}

	public CryptocurrencyHomePage selectPriceFilters() throws InterruptedException {
		selectprice.click();
		Thread.sleep(1000);
		selectminprice.sendKeys("100");
		Thread.sleep(1000);
		selectmaxprice.sendKeys("10000");
		Thread.sleep(1000);
		applyfilters.click();
		Thread.sleep(1000);
		showresults.click();
		return this;
	}

}
