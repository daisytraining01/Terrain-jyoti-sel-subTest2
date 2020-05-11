package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddRecipient {
	WebDriver driver;
	@FindBy(how=How.ID, using="recipientName")
	private WebElement repName;

	@FindBy(how=How.ID, using="recipientEmail")
	private WebElement repEmail;	
	
	@FindBy(how=How.ID, using="recipientPhone")
	private WebElement repPhone;

	@FindBy(how=How.ID, using="recipientAccountNumber")
	private WebElement repAccNumber;
	
	@FindBy(how=How.ID, using="recipientDescription")
	private WebElement repDesc;
	
	@FindBy(how=How.XPATH, using="//button[text()='Add/Edit Recipient']")
	private WebElement addButton;
	
	
	 public void recordSet() {
			
				try {
				Class.forName("com.mysql.cj.jdbc.Driver");  
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/selActivity", "root", "Password634$$");   
				Statement stmt=con.createStatement();  
				ResultSet rs=stmt.executeQuery("select * from recipientinfo");  
				System.out.println("inside recodset123");
				while(rs.next()) {
					Thread.sleep(2000);
					System.out.println("inside recodset");
					String s1=rs.getString(1);
					System.out.println(s1);
			        	 repName.sendKeys("jyoti");
			        	 Thread.sleep(200);
							repEmail.sendKeys(rs.getString(2));
							Thread.sleep(200);
							repPhone.sendKeys(rs.getString(3));
							Thread.sleep(200);
							
							repAccNumber.sendKeys(rs.getString(4));
							Thread.sleep(200);
							repDesc.sendKeys(rs.getString(5));
							Thread.sleep(200);
							addButton.click();
							Thread.sleep(200);
			        
				}
				
				}catch(Exception e)
			{
					e.printStackTrace();
				System.out.println(e);
			}finally {
				//con.close();  
			}
		
	 }

}
