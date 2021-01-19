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
		//****Opening cricbuzz.com in Google 
		driver.get("https://www.cricbuzz.com/");
		Thread.sleep(3000);
		//****Clicking on Menu option
		driver.findElement(By.xpath("//*[@id=\"top\"]/div/div[3]/div[2]/a")).click();
		Thread.sleep(3000);
		//****Clicking on Home option
		driver.findElement(By.xpath("//*[@id=\"top\"]/div/div[12]/table/tbody/tr[1]/td[1]/a")).click();
		
		//****Initializing JS object and scrolling to <Top Stories> element 
		JavascriptExecutor js =(JavascriptExecutor)driver;
		WebElement elm=driver.findElement(By.xpath("//*[contains(text(),'Top Stories')]"));
		js.executeScript("arguments[0].scrollIntoView()",elm);
		
		//****Using assertion to verify the element
		Assert.assertTrue(elm.getText().equals("Top Stories"));
	}

}
