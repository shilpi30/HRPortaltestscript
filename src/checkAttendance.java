import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class checkAttendance extends hrisLogIn {

	public void Attendance(WebDriver driver) throws InterruptedException {

		driver.findElement(
				By.xpath("//div[@id= \"menuheader\"]//li//a[@href= \"/empinfo/myinfo.do?cat=__attendance&e=2\"]"))
				.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(text(), \"Attendance Info\")]")).click();

	}

	  public void Calender(WebDriver driver) throws InterruptedException {

		Thread.sleep(3000);

		driver.findElement(By.xpath("//img[@id= \"img_fromdate\"]")).click();
		Thread.sleep(1000);

		// Find Calender date
		WebElement dateWidget = driver.findElement(By.xpath("(//table)[2]"));
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//table//td[@class= \"button nav\"])[2]")).click(); // code
																							// for
																							// CLick
																							// on
																							// another
																							// month
																							// i.e
																							// may
		List<WebElement> selectDates = dateWidget.findElements(By.tagName("td"));

		// comparing the text of cell with today's date and clicking it.
		for (WebElement cell : selectDates) {
			Object date = "24";
			
			//System.out.println(cell.getText());
			if (cell.getText().equals(date) && !cell.getAttribute("class").equals("day wn") && !cell.getAttribute("class").equals("othermonth day")  && !cell.getAttribute("class").equals("day othermonth")) {
				System.out.println(cell.getAttribute("class"));
				cell.click();
				break;
			}
		}

		driver.findElement(By.xpath("//img[@id= \"img_todate\"]")).click();
		Thread.sleep(2000);

		WebElement dateToSelect = driver.findElement(By.xpath("(//table)[3]"));
		List<WebElement> Date = dateToSelect.findElements(By.tagName("td"));

		// comparing the text of cell with today's date and clicking it.
		for (WebElement cell : Date) {
			Object date = "30";
			// System.out.println(cell.getText());
			if (cell.getText().equals(date) && !cell.getAttribute("class").equals("day wn") && !cell.getAttribute("class").equals("othermonth day")  && !cell.getAttribute("class").equals("day othermonth")) {
				System.out.println(cell.getAttribute("class"));
				cell.click();
				break;
			}
		}

	driver.findElement(By.xpath("//span[@id= \"button\"]//a[@href= \"javascript:dosubmit(document.frmattinfo)\"]")).click();
	Thread.sleep(10000);
		// driver.quit();

	}

}
