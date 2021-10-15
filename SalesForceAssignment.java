package week2.day2.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesForceAssignment {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.salesforce.com/in/form/signup/freetrial-sales/?d=70130000000Enyk");		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.name("UserFirstName")).sendKeys("Ram");
		driver.findElement(By.name("UserLastName")).sendKeys("kumar");
		driver.findElement(By.name("UserEmail")).sendKeys("testaccount@gma.com");
		WebElement userTitle= driver.findElement(By.name("UserTitle"));
		Select dropDownTitle = new Select(userTitle);
		dropDownTitle.selectByVisibleText("IT Manager");
		driver.findElement(By.name("CompanyName")).sendKeys("testleaf");
		WebElement comEmp = driver.findElement(By.name("CompanyEmployees"));
		Select dropDownEmp = new Select(comEmp);
		dropDownEmp.selectByIndex(2);
		driver.findElement(By.name("UserPhone")).sendKeys("9233435533");
		WebElement comCountry = driver.findElement(By.name("CompanyCountry"));
		Select dropDownCountry = new Select(comCountry);
		dropDownCountry.selectByValue("IN");
		WebElement option1= driver.findElement(By.xpath("//input[@id='SubscriptionAgreement']/following-sibling::div"));
		option1.click();
		//driver.findElement(By.xpath("//button[contains(text(),'free trial')]")).isSelected();
		String text = driver.findElement(By.tagName("h2")).getText();
		System.out.println(text);
		driver.close();
	}

}
