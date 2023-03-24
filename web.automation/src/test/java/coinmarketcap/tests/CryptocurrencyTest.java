package coinmarketcap.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import coinmarketcap.pages.CryptocurrencyHomePage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CryptocurrencyTest {
	WebDriver driver;
	CryptocurrencyHomePage cryptocurrencyHomePage;

	@Test
	public void testCyptocurrencyFilters() throws InterruptedException {
		cryptocurrencyHomePage.setNumberOfRowsAs20()
			.showAdditionalFilters()
			.setAlgorithmAsPow()
			.addFilters()
			.selectCryptocurrencyAsCoin()
			.selectPriceFilters();
		
		Assert.assertEquals(cryptocurrencyHomePage.getNumberOfRows(), 20);
	}

	@BeforeMethod
	public void launchApplication() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		cryptocurrencyHomePage = new CryptocurrencyHomePage(driver);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://coinmarketcap.com/");
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
