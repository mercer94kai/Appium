package App;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class cricbuzzApp extends capability {
AndroidDriver<AndroidElement> driver;
	
	@BeforeTest
	public void bt () throws MalformedURLException 
	{
	
		driver = capabilities(); 
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	
	@Test
	public void testcase1() throws MalformedURLException, InterruptedException 
	{
		
		driver.get("https://www.cricbuzz.com/");
		//driver.findElement(By.xpath("//*[@name='q']")).sendKeys(Keys.RETURN);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"top\"]/div/div[3]/div[2]/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"top\"]/div/div[12]/table/tbody/tr[1]/td[1]/a")).click();
		
		JavascriptExecutor js =(JavascriptExecutor)driver;
		WebElement elm=driver.findElement(By.xpath("//*[contains(text(),'Top Stories')]"));
		js.executeScript("arguments[0].scrollIntoView()",elm);
		
		Assert.assertTrue(elm.getText().equals("Top Stories"));
	}

}
