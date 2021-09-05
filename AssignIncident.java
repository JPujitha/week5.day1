package week5.Day1.Assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class AssignIncident extends BaseSnow {
	@Test
	public void assign()   {
		driver.findElement(By.xpath("(//div[text()='All'])[2]")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("gsft_main");
		WebElement fltr = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']"));
		Select filter=new Select(fltr);
		filter.selectByValue("state");
		WebElement up = driver.findElement(By.xpath("(//input[@class='form-control'])[1]"));
		up.sendKeys("New");
		up.sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		WebElement id = driver.findElement(By.id("incident.number"));
		String ID = id.getAttribute("value");
		driver.findElement(By.id("lookup.incident.assignment_group")).click();
		Set<String> wh = driver.getWindowHandles();
		List<String> WH=new ArrayList<String>(wh);
		driver.switchTo().window(WH.get(1));
		driver.findElement(By.xpath("//a[text()='Software']")).click();
		driver.switchTo().window(WH.get(0));
		driver.switchTo().defaultContent();
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//textarea[@id='activity-stream-textarea']")).sendKeys("Updated to software group");
		driver.findElement(By.id("sysverb_update")).click();
		WebElement fltrs = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']"));
		Select filters=new Select(fltrs);
		filters.selectByValue("number");
		WebElement srch = driver.findElement(By.xpath("(//input[@class='form-control'])[1]"));
		srch.sendKeys(ID);
		srch.sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		WebElement val = driver.findElement(By.xpath("//input[@id='sys_display.incident.assignment_group']"));
		String Value = val.getAttribute("value");
		if (Value.contains("Software")) {
			System.out.println("Assigned to Software group");	
		}
		else {
			System.out.println("Not Assigned to Software group");
		}
		
		
	}

}
