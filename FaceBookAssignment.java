package week2.day2.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FaceBookAssignment {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://en-gb.facebook.com/");		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
		driver.findElement(By.name("firstname")).sendKeys("Ram");
		driver.findElement(By.name("lastname")).sendKeys("kumar");
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("9345678072");
		driver.findElement(By.id("password_step_input")).sendKeys("Test111");
		WebElement dayDrop = driver.findElement(By.id("day"));
		Select dropDownDay = new Select(dayDrop);
		dropDownDay.selectByVisibleText("12");
		WebElement monthDrop = driver.findElement(By.id("month"));
		Select dropDownMonth = new Select(monthDrop);
		dropDownMonth.selectByIndex(7);
		WebElement yearDrop = driver.findElement(By.id("year"));
		Select dropDownYear = new Select(yearDrop);
		dropDownYear.selectByValue("2000");
		driver.findElement(By.xpath("//label[text() ='Female']")).click();
		driver.findElement(By.xpath("//button[@name ='websubmit']")).click();
		String text = driver.findElement(By.tagName("h2")).getText();
		System.out.println(text);
	}

}
