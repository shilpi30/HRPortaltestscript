import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class hrisLogIn {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver;
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\shilpi.agarwal\\Downloads\\Selenium Docs\\Driver\\geckodriver-v0.16.1-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		String baseURL = "http://hris/login.do";
		driver.get(baseURL);
		driver.manage().window().maximize();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//table[@id= \"tableposition\"]//td//input[@type= \"text\"]"))
				.sendKeys("0002000377");
		driver.findElement(By.xpath("//table[@id= \"tableposition\"]//td//input[@type= \"password\"]"))
				.sendKeys("shilpi1990@");
		driver.findElement(By.xpath("//input[@id= \"Submit\"]")).click();
		Thread.sleep(20000);

		// Timer for delay
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@id= \"navigation\"]//li//a[@href = \"/empinfo/group_info.do\"]")));

		driver.findElement(By.xpath("//div[@id= \"navigation\"]//li//a[@href = \"/empinfo/group_info.do\"]")).click();

		Thread.sleep(5000);
		checkAttendance a1 = new checkAttendance();
		a1.Attendance(driver);
		a1.Calender(driver);

		applyAttendanceregularization a2 = new applyAttendanceregularization();
	a2.attendanceRegularization(driver);
		a2.Calender(driver);
		// a2.regularizeEntries(driver);

	  leaveApply a3 = new leaveApply();
		a3.toLeaveApply(driver);
	 a3.leaveCalender(driver);

	}

}

// driver.findElement(By.xpath("//a[contains(@href,
// \"/empinfo/group_info.do\")]")).click();
