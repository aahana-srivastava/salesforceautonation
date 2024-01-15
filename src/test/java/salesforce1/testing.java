package salesforce1;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.qameta.allure.Step;

public class testing {
	ChromeDriver wd;
	WebDriverWait w;
	Actions act;
	 @Step("go to the website")
		
	@BeforeTest
	public void code1() throws AWTException {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\Downloads\\cynoteck\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");    	
	wd=new ChromeDriver();
   wd.get("https://login.salesforce.com/?locale=in");
   assertEquals(wd.getTitle(), "Login | Salesforce");
    wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
			   
	@Test (priority = 1)
	public void login () throws IOException {
		
		    
		    File excel=new File(""C:\Users\user\eclipse-workspace\salesforce1\saleforce.xlsx""); 
		    FileInputStream fis=new FileInputStream(excel); 
		       XSSFWorkbook book=new XSSFWorkbook(fis);
		       XSSFSheet sheet=book.getSheet("Sheet1"); 
		   
		       int rowcount=sheet.getLastRowNum(); 	 
		      
		       for(int i=0;i<=rowcount;i++) {
		           String username=sheet.getRow(i).getCell(0).getStringCellValue();
		           String password=sheet.getRow(i).getCell(1).getStringCellValue();
		           
		         
		          wd.findElement(By.cssSelector("input[type='email']")).sendKeys(username);
		          wd.findElement(By.cssSelector("input#password")).sendKeys(password);   
		          
		}
		       
		 book.close();
			 }
			@Test (priority = 2)
			public void home() throws InterruptedException,  IOException {
			 
		 wd.findElement(By.cssSelector("input#Login")).click();
		 WebDriverWait w = new WebDriverWait(wd, 100);

		
		
		
		   w.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.slds-button.slds-icon-waffle_container.slds-context-bar__button ")));
		 wd.findElement(By.cssSelector("button.slds-button.slds-icon-waffle_container.slds-context-bar__button ")).click();
		// wd.findElement(By.cssSelector("input.slds-input[placeholder='Search apps and items...']"));
		 //wd.switchTo().frame(wd.findElement(By.cssSelector("#content_2642\\:0 > one-app-launcher-menu > div")));
		// wd.findElement(By.xpath("/html/body/div[4]/div[2]/div[2]/div[1]/div[2]/one-app-launcher-menu/div/one-app-launcher-search-bar/lightning-input/lightning-primitive-input-simple/div/div/input")).click();
		 wd.findElement(By.xpath("/html/body/div[4]/div[2]/div[2]/div[1]/div[2]/one-app-launcher-menu/div/one-app-launcher-search-bar/lightning-input/lightning-primitive-input-simple/div/div/input")).sendKeys("sales");
		System.out.println("aaahn ");
		 //assertEquals(wd.getTitle(), "Home | Salesforce");
		 WebElement targetElement = wd.findElement(By.xpath("/html/body/div[4]/div[2]/div[2]/div[1]/div[2]/one-app-launcher-menu/div/div[1]/one-app-launcher-menu-item[4]/a"));
	      Actions act = new Actions(wd);
	      act.moveToElement(targetElement).click().build().perform();
	   	       WebElement a= wd.findElement(By.xpath("/html/body/div[4]/div[1]/section/div[1]/div[1]/one-appnav/div/one-app-nav-bar/nav/div/one-app-nav-bar-item-root[6]/a"));
	       w.until(ExpectedConditions.elementToBeClickable(a));
	       act.moveToElement(a).click().build().perform();
	        Thread.sleep(2000);
		       WebElement a1= wd.findElement(By.cssSelector("li.slds-button.slds-button--neutral>a[title='New']"));
		       w.until(ExpectedConditions.elementToBeClickable(a1));
		       act.moveToElement(a1).click().build().perform();
	       
	       //
	     //  w.until(ExpectedConditions.elementToBeClickable(wd.findElement(By.cssSelector("div.record-layout-container"))));
	      // wd.switchTo().frame(wd.findElement(By.cssSelector("div.record-layout-container")));
	      // wd.findElement(By.cssSelector(" li:nth-child(1) > a")).click();
	       
	      // WebElement b=wd.findElement(By.cssSelector("div[data-target-selection-name=\"sfdc:RecordField.Account.Name\"]>span>slot>records-record-layout-base-input>lightning-input>lightning-primitive-input-simple>div>div>input"));
	       
			 }
			 @Test (priority = 3)
	        public void accout() {
	    	   
	    
		     WebElement b=wd.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div/records-modal-lwc-detail-panel-wrapper/records-record-layout-event-broker/slot/records-lwc-detail-panel/records-base-record-form/div/div[2]/div/div/records-lwc-record-layout/forcegenerated-detailpanel_account___012000000000000aaa___full___create___recordlayout2/records-record-layout-block/slot/records-record-layout-section[1]/div/div/div/slot/records-record-layout-row[2]/slot/records-record-layout-item[1]/div/span/slot/records-record-layout-base-input/lightning-input/lightning-primitive-input-simple/div[1]/div/input"));
	    //   w.until(ExpectedConditions.elementToBeClickable(b));
	       b.sendKeys("john doe");
	      String c=wd.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div/records-modal-lwc-detail-panel-wrapper/records-record-layout-event-broker/slot/records-lwc-detail-panel/records-base-record-form/div/div[2]/div/div/records-lwc-record-layout/forcegenerated-detailpanel_account___012000000000000aaa___full___create___recordlayout2/records-record-layout-block/slot/records-record-layout-section[1]/div/h3/span")).getText();
	    assertEquals(c,"Account Information");
	    
	       
		wd.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div/records-modal-lwc-detail-panel-wrapper/records-record-layout-event-broker/slot/records-lwc-detail-panel/records-base-record-form/div/div[2]/div/div/records-lwc-record-layout/forcegenerated-detailpanel_account___012000000000000aaa___full___create___recordlayout2/records-record-layout-block/slot/records-record-layout-section[1]/div/div/div/slot/records-record-layout-row[2]/slot/records-record-layout-item[2]/div/span/slot/lightning-input/lightning-primitive-input-simple/div/div/input")).sendKeys("123456789");
		wd.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div/records-modal-lwc-detail-panel-wrapper/records-record-layout-event-broker/slot/records-lwc-detail-panel/records-base-record-form/div/div[2]/div/div/records-lwc-record-layout/forcegenerated-detailpanel_account___012000000000000aaa___full___create___recordlayout2/records-record-layout-block/slot/records-record-layout-section[1]/div/div/div/slot/records-record-layout-row[3]/slot/records-record-layout-item[2]/div/span/slot/lightning-input/lightning-primitive-input-simple/div/div/input")).sendKeys("987654321");
		wd.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div/records-modal-lwc-detail-panel-wrapper/records-record-layout-event-broker/slot/records-lwc-detail-panel/records-base-record-form/div/div[2]/div/div/records-lwc-record-layout/forcegenerated-detailpanel_account___012000000000000aaa___full___create___recordlayout2/records-record-layout-block/slot/records-record-layout-section[1]/div/div/div/slot/records-record-layout-row[4]/slot/records-record-layout-item[2]/div/span/slot/lightning-input/lightning-primitive-input-simple/div/div/input")).sendKeys("www.abc.com");
		//wd.findElement(By.cssSelector("#input-204")).sendKeys("1234");
		wd.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div/records-modal-lwc-detail-panel-wrapper/records-record-layout-event-broker/slot/records-lwc-detail-panel/records-base-record-form/div/div[2]/div/div/records-lwc-record-layout/forcegenerated-detailpanel_account___012000000000000aaa___full___create___recordlayout2/records-record-layout-block/slot/records-record-layout-section[1]/div/div/div/slot/records-record-layout-row[4]/slot/records-record-layout-item[1]/div/span/slot/records-record-layout-base-input/lightning-input/lightning-primitive-input-simple/div/div/input")).sendKeys("1qaz");
		//wd.findElement(By.cssSelector("input[name='NumberOfEmployees']")).sendKeys("25");

	 assertEquals(wd.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div/records-modal-lwc-detail-panel-wrapper/records-record-layout-event-broker/slot/records-lwc-detail-panel/records-base-record-form/div/div[2]/div/div/records-lwc-record-layout/forcegenerated-detailpanel_account___012000000000000aaa___full___create___recordlayout2/records-record-layout-block/slot/records-record-layout-section[2]/div/h3/span")).getText(),"Address Information");
		wd.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div/records-modal-lwc-detail-panel-wrapper/records-record-layout-event-broker/slot/records-lwc-detail-panel/records-base-record-form/div/div[2]/div/div/records-lwc-record-layout/forcegenerated-detailpanel_account___012000000000000aaa___full___create___recordlayout2/records-record-layout-block/slot/records-record-layout-section[1]/div/div/div/slot/records-record-layout-row[7]/slot/records-record-layout-item[2]/div/span/slot/lightning-input/lightning-primitive-input-simple/div/div/input")).sendKeys("25");
		wd.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div/records-modal-lwc-detail-panel-wrapper/records-record-layout-event-broker/slot/records-lwc-detail-panel/records-base-record-form/div/div[2]/div/div/records-lwc-record-layout/forcegenerated-detailpanel_account___012000000000000aaa___full___create___recordlayout2/records-record-layout-block/slot/records-record-layout-section[1]/div/div/div/slot/records-record-layout-row[8]/slot/records-record-layout-item[1]/div/span/slot/records-record-layout-base-input/lightning-input/lightning-primitive-input-simple/div/div/input")).sendKeys("2000000");
		
		wd.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div/records-modal-lwc-detail-panel-wrapper/records-record-layout-event-broker/slot/records-lwc-detail-panel/records-base-record-form/div/div[2]/div/div/records-lwc-record-layout/forcegenerated-detailpanel_account___012000000000000aaa___full___create___recordlayout2/records-record-layout-block/slot/records-record-layout-section[2]/div/div/div/slot/records-record-layout-row/slot/records-record-layout-item[1]/div/span/slot/records-record-layout-input-address/lightning-input-address/fieldset/div/div/div[1]/lightning-textarea/div/textarea")).sendKeys("abc buiding, dec street");
		wd.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div/records-modal-lwc-detail-panel-wrapper/records-record-layout-event-broker/slot/records-lwc-detail-panel/records-base-record-form/div/div[2]/div/div/records-lwc-record-layout/forcegenerated-detailpanel_account___012000000000000aaa___full___create___recordlayout2/records-record-layout-block/slot/records-record-layout-section[2]/div/div/div/slot/records-record-layout-row/slot/records-record-layout-item[1]/div/span/slot/records-record-layout-input-address/lightning-input-address/fieldset/div/div/div[2]/lightning-input[1]/lightning-primitive-input-simple/div/div/input")).sendKeys("def city");
		wd.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div/records-modal-lwc-detail-panel-wrapper/records-record-layout-event-broker/slot/records-lwc-detail-panel/records-base-record-form/div/div[2]/div/div/records-lwc-record-layout/forcegenerated-detailpanel_account___012000000000000aaa___full___create___recordlayout2/records-record-layout-block/slot/records-record-layout-section[2]/div/div/div/slot/records-record-layout-row/slot/records-record-layout-item[1]/div/span/slot/records-record-layout-input-address/lightning-input-address/fieldset/div/div/div[2]/lightning-input[2]/lightning-primitive-input-simple/div/div/input")).sendKeys("ghi state");
		wd.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div/records-modal-lwc-detail-panel-wrapper/records-record-layout-event-broker/slot/records-lwc-detail-panel/records-base-record-form/div/div[2]/div/div/records-lwc-record-layout/forcegenerated-detailpanel_account___012000000000000aaa___full___create___recordlayout2/records-record-layout-block/slot/records-record-layout-section[2]/div/div/div/slot/records-record-layout-row/slot/records-record-layout-item[1]/div/span/slot/records-record-layout-input-address/lightning-input-address/fieldset/div/div/div[3]/lightning-input[1]/lightning-primitive-input-simple/div/div/input")).sendKeys("234234");
		wd.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div/records-modal-lwc-detail-panel-wrapper/records-record-layout-event-broker/slot/records-lwc-detail-panel/records-base-record-form/div/div[2]/div/div/records-lwc-record-layout/forcegenerated-detailpanel_account___012000000000000aaa___full___create___recordlayout2/records-record-layout-block/slot/records-record-layout-section[2]/div/div/div/slot/records-record-layout-row/slot/records-record-layout-item[1]/div/span/slot/records-record-layout-input-address/lightning-input-address/fieldset/div/div/div[3]/lightning-input[2]/lightning-primitive-input-simple/div/div/input")).sendKeys("india");
	
	
		wd.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div/records-modal-lwc-detail-panel-wrapper/records-record-layout-event-broker/slot/records-lwc-detail-panel/records-base-record-form/div/div[2]/div/div/records-lwc-record-layout/forcegenerated-detailpanel_account___012000000000000aaa___full___create___recordlayout2/records-record-layout-block/slot/records-record-layout-section[2]/div/div/div/slot/records-record-layout-row/slot/records-record-layout-item[2]/div/span/slot/records-record-layout-input-address/lightning-input-address/fieldset/div/div/div[1]/lightning-textarea/div/textarea")).sendKeys("abc stree");
		wd.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div/records-modal-lwc-detail-panel-wrapper/records-record-layout-event-broker/slot/records-lwc-detail-panel/records-base-record-form/div/div[2]/div/div/records-lwc-record-layout/forcegenerated-detailpanel_account___012000000000000aaa___full___create___recordlayout2/records-record-layout-block/slot/records-record-layout-section[2]/div/div/div/slot/records-record-layout-row/slot/records-record-layout-item[2]/div/span/slot/records-record-layout-input-address/lightning-input-address/fieldset/div/div/div[2]/lightning-input[1]/lightning-primitive-input-simple/div/div/input")).sendKeys("def city");
		wd.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div/records-modal-lwc-detail-panel-wrapper/records-record-layout-event-broker/slot/records-lwc-detail-panel/records-base-record-form/div/div[2]/div/div/records-lwc-record-layout/forcegenerated-detailpanel_account___012000000000000aaa___full___create___recordlayout2/records-record-layout-block/slot/records-record-layout-section[2]/div/div/div/slot/records-record-layout-row/slot/records-record-layout-item[2]/div/span/slot/records-record-layout-input-address/lightning-input-address/fieldset/div/div/div[2]/lightning-input[2]/lightning-primitive-input-simple/div/div/input")).sendKeys("chi city");
		wd.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div/records-modal-lwc-detail-panel-wrapper/records-record-layout-event-broker/slot/records-lwc-detail-panel/records-base-record-form/div/div[2]/div/div/records-lwc-record-layout/forcegenerated-detailpanel_account___012000000000000aaa___full___create___recordlayout2/records-record-layout-block/slot/records-record-layout-section[2]/div/div/div/slot/records-record-layout-row/slot/records-record-layout-item[2]/div/span/slot/records-record-layout-input-address/lightning-input-address/fieldset/div/div/div[3]/lightning-input[1]/lightning-primitive-input-simple/div/div/input")).sendKeys("12313");
		wd.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div/records-modal-lwc-detail-panel-wrapper/records-record-layout-event-broker/slot/records-lwc-detail-panel/records-base-record-form/div/div[2]/div/div/records-lwc-record-layout/forcegenerated-detailpanel_account___012000000000000aaa___full___create___recordlayout2/records-record-layout-block/slot/records-record-layout-section[2]/div/div/div/slot/records-record-layout-row/slot/records-record-layout-item[2]/div/span/slot/records-record-layout-input-address/lightning-input-address/fieldset/div/div/div[3]/lightning-input[2]/lightning-primitive-input-simple/div/div/input")).sendKeys("xyz country");
	
		wd.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div/records-modal-lwc-detail-panel-wrapper/records-record-layout-event-broker/slot/records-lwc-detail-panel/records-base-record-form/div/div[2]/div/records-form-footer/div/div/div/runtime_platform_actions-actions-ribbon/ul/li[1]/runtime_platform_actions-action-renderer/runtime_platform_actions-executor-lwc-headless/slot[1]/slot/lightning-button/button")).click();
		
			 }
			 @AfterTest
			 public void at1() {
				 wd.quit();
			 }
	

}
