import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class applyAttendanceregularization {

	public void attendanceRegularization(WebDriver driver) throws InterruptedException {

		driver.findElement(By.xpath("//a[@href= \"/attendance/attregularization.do\"]")).click();

	}

	public void Calender(WebDriver driver) throws InterruptedException {
		Thread.sleep(1000);

		driver.findElement(By.xpath("//img[@id= \"img_attendanceDate\"]")).click();
		Thread.sleep(1000);

		// Find Calender date
		WebElement dateWidget = driver.findElement(By.xpath("(//table)[2]"));
		Thread.sleep(1000);
		List<WebElement> selectDates = dateWidget.findElements(By.tagName("td"));

		// comparing the text of cell with today's date and clicking it.
		for (WebElement cell : selectDates ) {
			Object date = "23";
			// System.out.println(cell.getText());
			if (cell.getText().equals(date) && !cell.getAttribute("class").equals("day wn") && !cell.getAttribute("class").equals("othermonth day")  && !cell.getAttribute("class").equals("day othermonth")) {
				cell.click();
				
				Thread.sleep(3000);

					WebElement toClear = driver.findElement(By.xpath("//input[@name= \"proposedFIT\"]"));
					toClear.sendKeys(Keys.CONTROL + "a");
					toClear.sendKeys(Keys.DELETE);

					driver.findElement(By.xpath("//input[@name= \"proposedFIT\"]")).sendKeys("09:30");

					WebElement toCleartext = driver.findElement(By.xpath("//input[@name= \"proposedLOT\"]"));
					toCleartext.sendKeys(Keys.CONTROL + "a");
					toCleartext.sendKeys(Keys.DELETE);

					driver.findElement(By.name("proposedLOT")).sendKeys("18:30");

					driver.findElement(By.name("remarks")).sendKeys("Punch out msising");
					driver.findElement(By.name("ccto")).sendKeys("ruch.kapoor@excelindia.com");
				}
			else {
				System.out.println("There is no swipe details to regularize" );
				
			}
				
			} 
		}

	}
	
	/* public void regularizeEntries(WebDriver driver) throws InterruptedException {

		Thread.sleep(4000);

		WebElement toClear = driver.findElement(By.xpath("//input[@name= \"proposedFIT\"]"));
		toClear.sendKeys(Keys.CONTROL + "a");
		toClear.sendKeys(Keys.DELETE);

		driver.findElement(By.xpath("//input[@name= \"proposedFIT\"]")).sendKeys("09:30");

		WebElement toCleartext = driver.findElement(By.xpath("//input[@name= \"proposedLOT\"]"));
		toCleartext.sendKeys(Keys.CONTROL + "a");
		toCleartext.sendKeys(Keys.DELETE);

		driver.findElement(By.name("proposedLOT")).sendKeys("18:30");

		driver.findElement(By.name("remarks")).sendKeys("Punch out msising");
		driver.findElement(By.name("ccto")).sendKeys("ruch.kapoor@excelindia.com");
	}   */
	

