import java.util.*;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class AutomationDriver {

	public static void main(String[] args) throws InterruptedException {

// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "//Users//aumapathi//Downloads//chromedriver");
		WebDriver driver = new ChromeDriver();

		driver.get("http://www.qaclickacademy.com/practice.php");
		AutomationDriver.exerciseOne(driver);
		AutomationDriver.exerciseTwo(driver);
		AutomationDriver.exerciseThree(driver);
		AutomationDriver.exerciseFour(driver);
		AutomationDriver.exerciseFourPointOne(driver);
		AutomationDriver.exerciseFourPointtwo(driver);
		AutomationDriver.exericseFive(driver);
		AutomationDriver.exericseSix(driver);
		AutomationDriver.exerciseSeven(driver);
		AutomationDriver.exerciseEight(driver);
		AutomationDriver.exerciseNine(driver);

	}
	
	/*MethodName:ExerciseOne
	 * ReturnType:void
	 * ParameterType:WebDriver
	 * Description:To Automate Radio Button
	 */

	public static void exerciseOne(WebDriver driver) throws InterruptedException {

		// Find radio button using value, Validate isSelected and then click

		driver.findElement(By.xpath("//*[@value='radio1']")).click(); // Find radio button using Xpath, Validate
																		// isSelected

		Assert.assertTrue(driver.findElement(By.xpath("//*[@value='radio1']")).isSelected());

		driver.findElement(By.xpath("//*[@value='radio2']")).click();

		Assert.assertTrue(driver.findElement(By.xpath("//*[@value='radio2']")).isSelected());

		driver.findElement(By.xpath("//*[@value='radio3']")).click();

		Assert.assertTrue(driver.findElement(By.xpath("//*[@value='radio3']")).isSelected());

	}

	/*
	 * MethodName:ExerciseTwo ReturnType:void
	 *  ParameterType:WebDriver Description:To Automate Suggestion Class
	 */
	static void exerciseTwo(WebDriver driver) throws InterruptedException {
		driver.findElement(By.id("autocomplete")).sendKeys("United State"); // similar to 'xpath' here we are using 'id'
		// locator to locate
		Thread.sleep(3000);
		List<WebElement> options = driver.findElements(By.xpath("//input[@type='text']"));
		for (WebElement option : options) { // this is advanced for which we use for collection or lists
		if (option.getText().equalsIgnoreCase("United State")) {
		option.click();
		break;
		}

		 }

		 }
	/*
	 * MethodName:ExerciseThree ReturnType:void ParameterType:WebDriver
	 * Description:To Automate drop down
	 */

	public static void exerciseThree(WebDriver driver) throws InterruptedException {

		driver.findElement(By.id("dropdown-class-example")).click();
		driver.findElement(By.xpath("//option[@value='option1']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//option[@value='option2']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//option[@value='option3']")).click();
	}

	/*
	 * MethodName:ExerciseFour
	 *  ReturnType:void ParameterType:WebDriver
	 * Description:To Automate Checkbox
	 */

	public static void exerciseFour(WebDriver driver) throws InterruptedException {

		driver.findElement(By.name("checkBoxOption1")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("checkBoxOption1")).click();
		driver.findElement(By.name("checkBoxOption2")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("checkBoxOption2")).click();
		driver.findElement(By.name("checkBoxOption3")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("checkBoxOption3")).click();
		AutomationDriver.exerciseFourPointOne(driver);
		AutomationDriver.exerciseFourPointtwo(driver);
	}

	/*
	 * MethodName:ExerciseFourPointOne 
	 * ReturnType:void ParameterType:WebDriver
	 * Description:To Automate Checkbox: Select All
	 */

	public static void exerciseFourPointOne(WebDriver driver) {
		driver.findElement(By.name("checkBoxOption1")).click();
		Assert.assertTrue(driver.findElement(By.name("checkBoxOption1")).isSelected());
		driver.findElement(By.name("checkBoxOption2")).click();
		Assert.assertTrue(driver.findElement(By.name("checkBoxOption2")).isSelected());
		driver.findElement(By.name("checkBoxOption3")).click();
		Assert.assertTrue(driver.findElement(By.name("checkBoxOption3")).isSelected());

	}

	/*
	 * MethodName:ExerciseFourPointTwo 
	 * ReturnType:void ParameterType:WebDriver
	 * Description:To Automate Checkbox:Deselect All
	 */

	public static void exerciseFourPointtwo(WebDriver driver) throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.name("checkBoxOption1")).click();
		Assert.assertFalse(driver.findElement(By.name("checkBoxOption1")).isSelected());
		Thread.sleep(2000);
		driver.findElement(By.name("checkBoxOption2")).click();
		Assert.assertFalse(driver.findElement(By.name("checkBoxOption2")).isSelected());
		Thread.sleep(2000);
		driver.findElement(By.name("checkBoxOption3")).click();
		Assert.assertFalse(driver.findElement(By.name("checkBoxOption3")).isSelected());

	}

	/*
	 * MethodName:ExerciseFive
	 *  ReturnType:void ParameterType:WebDriver
	 * Description:To Automate Switch Window
	 */

	public static void exericseFive(WebDriver driver) throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://www.qaclickacademy.com/practice.php");
		driver.findElement(By.id("openwindow")).click();

		Set<String> Windows = driver.getWindowHandles();
		Iterator<String> iter = Windows.iterator();
		String parentid = iter.next();
		Thread.sleep(2000);
//Driver.switchTo().window(Childid);
//System.out.println(driver.findElement(By.xpath("//body/div/h3")).getText());
		driver.switchTo().window(parentid);
//System.out.println(driver.findElement(By.xpath("//div/div/h3")).getText());

	}

	/*
	 * MethodName:ExerciseSix
	 *  ReturnType:void 
	 *  ParameterType:WebDriver Automate Switch Tab
	 */

	public static void exericseSix(WebDriver driver) throws InterruptedException {

		driver.findElement(By.id("opentab")).click();
		Thread.sleep(2000);
		Set<String> window = driver.getWindowHandles();

		Iterator<String> it = window.iterator();

		String parent1 = it.next();
		String child1 = it.next();
		String child2 = it.next();
		Thread.sleep(2000);
		driver.switchTo().window(child2);
		driver.close();
		driver.switchTo().window(parent1);
	}

	/*
	 * public static void exerciseSeven(WebDriver driver) throws
	 * InterruptedException {
	 * 
	 * // Alert Message handling
	 * 
	 * driver.findElement(By.name("enter-name")).sendKeys("apeksha");
	 * driver.findElement(By.id("alertbtn")).submit(); Thread.sleep(2000);
	 * 
	 * // Switching to Alert Alert alert = driver.switchTo().alert();
	 * 
	 * // Capturing alert message. String alertMessage=
	 * driver.switchTo().alert().getText();
	 * driver.findElement(By.id("alertbtn()")).click();
	 * 
	 * // Displaying alert message System.out.println(alertMessage);
	 * Thread.sleep(5000);
	 * 
	 * // Accepting alert //alert.accept(); }
	 * 
	 * }
	 */
	
	
	/*
	 * MethodName:ExerciseSeven ReturnType:void 
	 * ParameterType:WebDriver Automate Switch To Alert 
	 */


	public static void exerciseSeven(WebDriver driver) throws InterruptedException {

		driver.findElement(By.id("name")).sendKeys("Apeksha");

		driver.findElement(By.xpath("//*[@value='Alert']")).click();
		Thread.sleep(2000);

		System.out.println(driver.switchTo().alert().getText());

		driver.switchTo().alert().accept();

	}

	/*
	 * MethodName:ExerciseEight
	 *  ReturnType:void 
	 *  ParameterType:WebDriver Automate Table
	 */

	public static void exerciseEight(WebDriver driver) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);
		js.executeScript("document.querySelector('.tableFixHead').scrollBy(0,5000)");
	}

	/*
	 * MethodName:ExerciseNine ReturnType:void 
	 * ParameterType:WebDriver Automate Mousehover
	 */

	private static void exerciseNine(WebDriver driver) throws InterruptedException {
		Actions a = new Actions(driver);
		Thread.sleep(3000);
		a.moveToElement(driver.findElement(By.xpath("//button[@id='mousehover']"))).click().build().perform();
		Thread.sleep(5000);
		a.moveToElement(driver.findElement(By.cssSelector("a[href='#top']"))).click().build().perform();

	}
}
