package week2.day2.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		String text = driver.findElement(By.tagName("h2")).getText();
		System.out.println(text);

		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");

		driver.findElement(By.id("password")).sendKeys("crmsfa");

		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(5000);

		driver.findElement(By.xpath("//span[text() = 'Phone']")).click();
		driver.findElement(By.name("phoneCountryCode")).clear();
		driver.findElement(By.name("phoneCountryCode")).sendKeys("91");
		driver.findElement(By.name("phoneAreaCode")).sendKeys("123");
		driver.findElement(By.name("phoneNumber")).sendKeys("9965387707");
		driver.findElement(By.xpath("//button[text() = 'Find Leads']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(5000);
		String leadId = driver.findElement(By.xpath("(//table/tbody/tr/td/div/a)[1]")).getText();
		System.out.println(leadId);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.findElement(By.xpath("(//table/tbody/tr/td/div/a)[1]")).click();
		driver.findElement(By.xpath("//a[text() ='Delete']")).click();
		Thread.sleep(5000);
		driver.findElement(By.linkText("Find Leads")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@name ='id']")).sendKeys(leadId);
		driver.findElement(By.xpath("//button[text() = 'Find Leads']")).click();
		Thread.sleep(5000);
		String leadFind = driver.findElement(By.xpath("//div[text() = 'No records to display']")).getText();
		System.out.println(leadFind);
		driver.close();

	}

}

