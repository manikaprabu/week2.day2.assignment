package week2.day2.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Acme_Test {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://acme-test.uipath.com/login");
		driver.findElement(By.id("email")).sendKeys("kumar.testleaf@gmail.com");
		driver.findElement(By.id("password")).sendKeys("leaf@12");
		driver.findElement(By.xpath("//button[@type ='submit']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
		driver.findElement(By.xpath("//form[@id = 'logout-form']/following-sibling::li/a")).click();
		driver.close();

	}

}
