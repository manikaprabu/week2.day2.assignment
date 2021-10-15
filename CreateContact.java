package week2.day2.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		String text = driver.findElement(By.tagName("h2")).getText();
		System.out.println(text);
	
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		
		driver.findElement(By.id("password")).sendKeys("crmsfa");
	
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.linkText("Create Contact")).click();
		driver.findElement(By.id("firstNameField")).sendKeys("Manikaprabu");
		driver.findElement(By.id("lastNameField")).sendKeys("K");
		driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("Flocal");
		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("Llocal");
		driver.findElement(By.id("createContactForm_departmentName")).sendKeys("IT");
		driver.findElement(By.id("createContactForm_description")).sendKeys("Contact Description");
		driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("testmail@gm.com");
		WebElement stateProv = driver.findElement(By.id("createContactForm_generalStateProvinceGeoId"));
		Select dropDownState = new Select(stateProv);
		dropDownState.selectByVisibleText("New York");
		driver.findElement(By.xpath("//input[@value = 'Create Contact']")).click();
		driver.findElement(By.xpath("//a[text()= 'Edit']")).click();
		driver.findElement(By.id("updateContactForm_description")).clear();
		driver.findElement(By.id("updateContactForm_importantNote")).sendKeys("Import desc note - Description");
		driver.findElement(By.xpath("//input[@value = 'Update']")).click();
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
		
	}

}
