import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class leaveApply {

	public void toLeaveApply(WebDriver driver) throws InterruptedException {

		driver.findElement(By.xpath("//a[@href= \"/empinfo/myinfo.do?cat=__leave&e=2\"]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@href= \"../leave/apply.do\"]")).click();
		// Select leave type
		Thread.sleep(3000);
		driver.findElement(By.xpath("//select[@id= \"leaveTypeCategory\"]//option[text()= \"Earn Leave\"]")).click();

	}

	public void leaveCalender(WebDriver driver) throws InterruptedException {

		driver.findElement(By.xpath("//img[@id= \"img_fromDate\"]")).click();
		Thread.sleep(2000);

		WebElement dateWidget = driver.findElement(By.xpath("(//table)[5]"));
		List<WebElement> selectDates = dateWidget.findElements(By.tagName("td"));

		for (WebElement cell : selectDates) {

			Object leaveDate = "9";
			System.out.println(cell.getText());

			if (cell.getText().equals(leaveDate)) {

				Thread.sleep(2000);
				cell.click();
				break;
			}
		}

		driver.findElement(By.xpath("//img[@id= \"img_toDate\"]")).click();
		Thread.sleep(2000);

		WebElement dateWidget1 = driver.findElement(By.xpath("(//table)[6]"));
		List<WebElement> selectDates1 = dateWidget1.findElements(By.tagName("td"));

		for (WebElement cell : selectDates1) {

			Object leaveDate1 = "9";
			System.out.println(cell.getText());

			if (cell.getText().equals(leaveDate1)) {

				Thread.sleep(2000);
				cell.click();
				break;
			}
		}

		driver.findElement(By.xpath("//textarea[@name= \"reason\"]")).sendKeys("Personal work");
		driver.findElement(By.xpath("//textarea[@name= \"contactDetails\"]")).sendKeys("8130500228");
		driver.findElement(By.xpath("//textarea[@name= \"ccto\"]")).sendKeys("ruchi.kapoor@excelindia.com");
		driver.findElement(By.xpath("//a[@href= 'javascript:validate()']")).click();

	}
}
