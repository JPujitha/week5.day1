package week5.Day1.Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class DeleteIncident extends BaseSnow {
	String ID = "";

	@Test
	public void Delete() {
		driver.findElement(By.xpath("(//div[text()='All'])[2]")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("gsft_main");
		WebElement incident = driver.findElement(By.xpath("//a[@class='linked formlink']"));
		incident.click();
		driver.findElement(By.xpath("//button[text()='Delete']")).click();
		WebElement button = driver.findElement(By.id("ok_button"));
		String text = button.getText();
		button.click();
		if (text.contains("Delete")) {
			System.out.println("Incident Deleted");
		} else {
			System.out.println("Incident not Deleted");

		}
	}

}
