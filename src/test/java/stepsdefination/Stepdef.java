package stepsdefination;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utility.AddRecipient;
import utility.ConnectionClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Stepdef {

	WebDriver driver;

	@Given("user navigates to webpage")
	public void user_navigates_to_webpage() {
		System.setProperty("webdriver.chrome.driver", "src/main/java/driver/chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("http://elastic.rapidtestpro.com:8086/index");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("User provides neccessary details for login")
	public void user_provides_neccessary_details_for_login() {

		driver.findElement(By.id("username")).sendKeys("labuser");

		driver.findElement(By.id("password")).sendKeys("labuser@01");
	}

	@Then("User clicks submit button")
	public void user_clicks_submit_button() throws InterruptedException {
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		Thread.sleep(3000);
		
	}

	@Given("User clicks add recipient")
	public void user_clicks_add_recipient() {
		
		driver.findElement(By.xpath("//a[@role='button'][text()='Transfer ']")).click();
		 driver.findElement(By.xpath("//a[text()='Add/Edit Recipient']")).click();
		
	     
		
			}

	@When("User verify add recipient page title")
	public void user_verify_add_recipient_page_title() throws InterruptedException {

		Thread.sleep(2000);
		String actual = driver.getTitle();
		System.out.println(driver.getTitle());
		
		System.out.println("THE PAGE TITLE IS: " + actual);
	}

	@Then("User provides neccessary details for add recipient")
	public void user_provides_neccessary_details_for_add_recipient() {
        try {
		Class.forName("com.mysql.cj.jdbc.Driver");  
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/selActivity", "root", "Password634$$");   
		Statement stmt=con.createStatement();  
		ResultSet rs=stmt.executeQuery("select * from recipientinfo"); 
		while(rs.next()) {
			System.out.println("inside while");
			driver.findElement(By.id("recipientName")).sendKeys(rs.getString(1));
			driver.findElement(By.id("recipientEmail")).sendKeys(rs.getString(2));
			driver.findElement(By.id("recipientPhone")).sendKeys(rs.getString(3));
			driver.findElement(By.id("recipientAccountNumber")).sendKeys(rs.getString(4));
			driver.findElement(By.id("recipientDescription")).sendKeys(rs.getString(5));
			
			Actions act=new Actions(driver);
			act.moveToElement(driver.findElement(By.xpath("//button[text()='Add/Edit Recipient']"))).click().build().perform();

			Thread.sleep(4000);
			
		}
        }catch(Exception e ) {
        	e.printStackTrace();
        }

	}

	@Then("click add button")
	public void click_add_button() {
		driver.close();
	}

}
