package seleniumday1;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Program_Assignment10 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		driver.get("file:///C:/Growskillit/assignment/selenium-mission-game.html");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[text()='Start Mission']")).click();
		Thread.sleep(3000);
		Alert popUP = driver.switchTo().alert();
		popUP.sendKeys("level1");
		popUP.accept();
		Thread.sleep(3000);
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentWin = it.next();
		String childWin = it.next();
		driver.switchTo().window(childWin);
		Thread.sleep(3000);
		driver.findElement(By.id("levelInput")).sendKeys("level2");
		driver.findElement(By.xpath("//*[text()='Submit']")).click();
		Thread.sleep(7000);
		driver.switchTo().window(parentWin);
		WebElement circle=driver.findElement(By.id("circle"));
		WebElement dropCircle = driver.findElement(By.id("dropZone"));
		Actions act = new Actions(driver);
		act.dragAndDrop(circle, dropCircle).perform();
		Thread.sleep(3000);
		WebElement triangle = driver.findElement(By.id("triangle"));
		WebElement square = driver.findElement(By.id("square"));
		act.dragAndDrop(triangle, square).perform();
		Thread.sleep(3000);
		WebElement frameTag = driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(frameTag);
		Select country = new Select(driver.findElement(By.id("country")));
		country.selectByVisibleText("India");
		driver.findElement(By.xpath("//*[text()='Submit']")).click();
	}

}
