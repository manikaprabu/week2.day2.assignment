package week2.day2.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

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

		driver.findElement(By.xpath("//span[text() = 'Email']")).click();
		driver.findElement(By.name("emailAddress")).sendKeys("testsample@gmail.com");
		driver.findElement(By.xpath("//button[text() = 'Find Leads']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(5000);
		String firstName = driver.findElement(By.xpath("(//table/tbody/tr/td)[45]/div/a")).getText();
		System.out.println(firstName);
		String lastName = driver.findElement(By.xpath("(//table/tbody/tr/td)[46]/div/a")).getText();
		System.out.println(lastName);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.findElement(By.xpath("(//table/tbody/tr/td/div/a)[1]")).click();
		driver.findElement(By.xpath("//a[text() ='Duplicate Lead']")).click();
		Thread.sleep(5000);
		String pageTitle = driver.findElement(By.id("sectionHeaderTitle_leads")).getText();
		if(pageTitle.contains("Duplicate Lead")) {
			System.out.println("page is "+ pageTitle + " page");
		}
		else
			System.out.println("not redirect to duplicate page");
		
		driver.findElement(By.name("submitButton")).click();
		Thread.sleep(5000);
		String leadFirstName = driver.findElement(By.id("viewLead_firstName_sp")).getText();
		String leadLastName = driver.findElement(By.id("viewLead_lastName_sp")).getText();
		if(firstName.equals(leadFirstName) && lastName.equals(leadLastName)) {
			System.out.println("Duplicate lead created successfully with " + firstName + " " + lastName);
		}
		else
			System.out.println("Duplicate lead is not created");
		Thread.sleep(5000);
		driver.close();

	}

}
