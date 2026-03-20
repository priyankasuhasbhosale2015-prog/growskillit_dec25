package day16;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Program_WaitsAssignment11 {

	public static void main(String[] args)throws InterruptedException {
				// TODO Auto-generated method stub
				ChromeDriver driver=new ChromeDriver();
				driver.manage().window().maximize();
				driver.get("file:///C:/Users/HP/AppData/Local/Temp/bc235374-794a-447e-bcf8-01a811181761_upload_92b75a56-02bc-4268-9b5c-7504f597a45a%20(1).zip.761/Selenium_waits_Assignment/example3.html");
				WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("foodHeading")));
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("category")));

				//WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cart
				System.out.println("Menu item is visible");

				//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

				WebElement category=driver.findElement(By.xpath("//button[contains(text(),'Dessert')]"));
				category.click();

				WebElement cart=driver.findElement(By.xpath("(//button[contains(text(),'Add to Cart')])[2]"));
				cart.click();
				wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("cartCount"),"1"));

				WebElement confirmBtn=driver.findElement(By.xpath("//button[@id='confirmOrderBtn']"));
				confirmBtn.click();
				driver.findElement(By.id("closePopupBtn")).click();

			}
		
	}


