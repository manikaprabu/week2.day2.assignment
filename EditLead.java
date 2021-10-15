package week2.day2.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

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

	//	driver.findElement(By.xpath("//span[text() = 'Email']")).click();
		driver.findElement(By.xpath("(//input[@name = 'firstName'])[3]")).sendKeys("manikaprabu");
		driver.findElement(By.xpath("//button[text() = 'Find Leads']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//table/tbody/tr/td/div/a)[1]")).click();
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
		
		driver.findElement(By.xpath("//a[text() ='Edit']")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		Thread.sleep(3000);
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("UpdatedName");
		
		driver.findElement(By.xpath("//input[@value = 'Update']")).click();
		Thread.sleep(5000);
		String leadCompanyName = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		//String leadLastName = driver.findElement(By.id("viewLead_lastName_sp")).getText();
		if(leadCompanyName.contains("UpdatedName")) {
			System.out.println("Company name updated with UpdatedName ");
		}
		else
			System.out.println("Company name is not updated with UpdatedName");
		Thread.sleep(5000);
		driver.close();


	}

}
