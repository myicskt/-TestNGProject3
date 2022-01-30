package TestNG_Test_3;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;



public class TestNG_Project_Three {

	@Test
	public void init() {
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://techfios.com/test/101/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		// add category
		String[] exp = {"None","Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
		
		int size =exp.length;
		System.out.println(size);
		WebElement dropdown = driver.findElement(By.name("due_month"));  
		 Select select = new Select(dropdown);  
		
		 List<WebElement> options = select.getOptions();
		 
		 for(WebElement we:options)  {  
		  boolean match = false ;
		  for (int i=0; i<size; i++){
		      if (we.getText().equals(exp[i])){
		        match = true;
		        System.out.println(we.getText());
		      }
		    }
		  Assert.assertTrue(match);
		 } 
	
		driver.close();

	}

}
