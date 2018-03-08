
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class IDEScriptTest {
	private static WebDriver driver;
	private static String baseUrl;
	

	@BeforeClass
	public static void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\shilpi.agarwal\\Downloads\\Selenium Docs\\Driver\\geckodriver-v0.16.1-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		baseUrl = "http://www.letskodeit.com/";
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}

	@Test
	public void testIDEScript() throws Exception {
		driver.get(baseUrl + "/");
		Thread.sleep(3000);
		driver.findElement(By.id("i90scv3glabel")).click();
		Thread.sleep(5000);
		driver.findElement(By.linkText("Practice")).click();
	}

	@AfterClass
	public static void tearDown() throws Exception {
		
		Thread.sleep(5000);
		driver.quit();

	}

}
