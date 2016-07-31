package com.quotations;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;	
import com.OR.OR;
public class NewQuotation extends TestBase {
    

  
    ErrorReport rep=new ErrorReport();
   
    
    String gtomdata;
    String gtomprofilingsheet = "Sheet1";
    
    
    Object obj[][];
    
    
    Object obj1[][];
    
    
    String uname,pwd;
    
    @BeforeClass
    public void beforeSignUp()
    {   
        
            rep.Reporting();
            
            obj=xlData(gtomprofilingsheet,57); 
            
            rep.message("Sign Up Page Test Fields are :Fname,Lname,Location,City,Email,Password,Confirm Pwd, Plan");
    }

    
    
    @Test(dataProvider="dp1")
    public  void LoginTest(String sno, String logintype, String username, String password, String businesstype, String plantype,  
    		
    		String accountCode, String condition , String vehicleuse , String make, String model, String family, String yom,
    		
    		String enginecapacity, String chassis, String dutyfree, String placeofuse, String seats, String vehiclevalue, 
    		
    		String areaofreg, String vrn, String prevrn, String phtype, String phicyes, String phicnum, String pholdic,
    		
    		String phdobmonth, String phdobday, String phdobyear, String phmaindriver, String phdrivingexp, String phoffence,
    		
    		String claimsdamage, String claimswindscreen, String claimstheft, String claimsthirdparty,
    		
    		String pstartmonth, String pstartday, String pstartyear,
    		
    		String bodytype, String enginenum, String garage, String safety, String antitheft, String gender,
    		
    		String maritalstatus, String occupation, String surname, String givenname, String phone, String email,
    		
    		String postalcode, String country, String state, String city, String street, String block
    		
    		
    		
    		) throws InterruptedException, IOException
    {   
    	
    	
        
        rep.Reporting();
        
         String internallogin = OR.internalLogin;
	     String externallogin = OR.externalLogin;
	    
	     if(logintype.equals("internal")) {  System.out.println("Accessing Internal Login...");
	     driver.get(internallogin); }
	     else { System.out.println("Accessing External Login..."); driver.get(externallogin); }
        
	     
//                  
//                      int  min=1;int max=6;int rand;
//                      rand = (int) (Math.random() * (max - min + 1) ) + min;
                      
                       driver.findElement(By.xpath(OR.loginUser)).sendKeys(username);
             	       driver.findElement(By.xpath(OR.loginPassword)).sendKeys(password); 
             	       
             	      File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
             	      FileUtils.copyFile(scrFile, new File("D:\\tmp\\page1.png"));
             	      
             	       driver.findElement(By.xpath(OR.loginButton)).click();
             	      
             	       driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
             	     
             	     String pagetitle = driver.getTitle();
             	     
             	     System.out.println(pagetitle);
             	     
             		 if(pagetitle.equals("AXA iConnect")) {  
             			 System.out.println(" Login Successfull.");
             			 
             			 
             		 }
             		
             		 
                     if(businesstype.equals("Private Car")){
             			
             			driver.findElement(By.xpath(OR.productMotor)).click();
             			Thread.sleep(3000);
             		}
             		
             		else{
             			
             			driver.findElement(By.xpath(OR.productMotorcycle)).click();
             			Thread.sleep(3000);
             			
             		}
                     
                     scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
             		 FileUtils.copyFile(scrFile, new File("D:\\tmp\\page2.png"));
             		 
             		driver.findElement(By.xpath(OR.Disclaimeryes)).click();
             		Thread.sleep(3000);
             		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
             		
             		 
             		driver.findElement(By.xpath(OR.Startquotation)).click();
             		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
             		
             		 scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
             		 FileUtils.copyFile(scrFile, new File("D:\\tmp\\page4.png"));
                    if(plantype.equals("TPFT")){
             			
             			driver.findElement(By.xpath(OR.PlanTPFT)).click();
             			 scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
                		 FileUtils.copyFile(scrFile, new File("D:\\tmp\\page4.png"));
             			Thread.sleep(3000);
             		}
                    
                    else if(plantype.equals("TP")){
             			
             			driver.findElement(By.xpath(OR.PlanTP)).click();
             			 scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
                		 FileUtils.copyFile(scrFile, new File("D:\\tmp\\page4.png"));
             			Thread.sleep(3000);
             		}
             		
             		else{
             			
             			driver.findElement(By.xpath(OR.PlanComprehensive)).click();
             			 scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
                		 FileUtils.copyFile(scrFile, new File("D:\\tmp\\page4.png"));
             			Thread.sleep(3000);
             			
             		}
                    
                    
                    scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
                    FileUtils.copyFile(scrFile, new File("D:\\tmp\\page11.png"));
                    
                    
                    Thread.sleep(3000);
                    
                    if(logintype.equals("internal")){
                    
                    	driver.findElement(By.xpath("//*[@id='AccountCode']")).sendKeys(accountCode);
                    	
                    	if(driver.findElements( By.xpath("//*[@id='EXPAND-OUTERFRAME']/div[2]/div/div[2]/div/div/span/button") ).size() != 0){
                    		System.out.println("No Element");
                    	}
                    	
                    	//System.out.println("Yes element there"+driver.findElement(By.xpath("//*[@id='EXPAND-OUTERFRAME']/div[2]/div/div[2]/div/div/span/button")).isDisplayed());
                    	
                    	//driver.findElement(By.className("pzhc")).click();
                    	
                    	 //String jssearch = "var item = document.getElementsByName('ProfilingDetails_pyWorkPage_8'); item[0].click()";
                        
                         //((JavascriptExecutor)driver).executeScript(jssearch);
                    	
                    	
                    }
                    
                    driver.findElement(By.xpath(OR.carCondition)).sendKeys(condition);
                    
                    Thread.sleep(3000);
                    
                    WebElement select = driver.findElement(By.xpath(OR.carUsage));
                    List<WebElement> options = select.findElements(By.tagName("option"));
                   for (WebElement option : options) {
                       if(vehicleuse.equals(option.getText()))
                          option.click();   
                    }
                    
                   
                    
                    Thread.sleep(3000);
                    
                    driver.findElement(By.xpath(OR.carMake)).sendKeys(make);
                    
                    Thread.sleep(3000);
                    
                    driver.findElement(By.xpath(OR.carModel)).sendKeys(model);
                    
                    Thread.sleep(3000);
                    
                    driver.findElement(By.xpath(OR.carFamily)).sendKeys(family);
                    
                    Thread.sleep(3000);
                    
                    driver.findElement(By.xpath(OR.carYOM)).sendKeys(yom);
                    
                    Thread.sleep(3000);
                    
                    driver.findElement(By.xpath(OR.carEngineCapacity)).sendKeys(enginecapacity);
                    
                    Thread.sleep(3000);
                    
                    String jschassis = "document.getElementById('"+OR.carChassisid+"').value='"+chassis+"'";
                    
                   // System.out.println("This is JS Query: "+jschassis);
                    
                    ((JavascriptExecutor)driver).executeScript(jschassis);
                    
                   // driver.findElement(By.xpath(OR.carChassis)).sendKeys(chassis);
                    
                    Thread.sleep(3000);
                    
                    driver.findElement(By.xpath(OR.carDutyfreeNo)).click();
                    
                    Thread.sleep(3000);
                    
                    driver.findElement(By.xpath(OR.carPlaceofuseWestMalaysia)).click();
                    
                    Thread.sleep(3000);
                    
                    scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
                    FileUtils.copyFile(scrFile, new File("D:\\tmp\\page12.png"));
                    
                    driver.findElement(By.xpath(OR.carIsmlink)).click();
                    
                    Thread.sleep(3000);
                    
                    driver.findElement(By.xpath(OR.carSeatCapacity)).sendKeys(seats);
                    
                    Thread.sleep(3000);
                    
                    driver.findElement(By.xpath(OR.carVehicleValue)).sendKeys(vehiclevalue);
                    
                    Thread.sleep(3000);
                    
                    driver.findElement(By.xpath(OR.carAreaReg)).sendKeys(areaofreg);
                    
                    Thread.sleep(3000);
                    
                    driver.findElement(By.xpath(OR.carVRN)).sendKeys(vrn);
                    
                    Thread.sleep(3000);
                    
                    String jsprevrn = "document.getElementById('"+OR.carVRNpreid+"').value='"+prevrn+"'";
                    
                     
                     ((JavascriptExecutor)driver).executeScript(jsprevrn);
                    
                    //driver.findElement(By.xpath(OR.carVRNpre)).sendKeys("HSGD847");
                    
                    Thread.sleep(3000);
                    
                    driver.findElement(By.xpath(OR.policyholderTypeIndividual)).click();
                    
                    Thread.sleep(3000);
                    
                    scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
                    FileUtils.copyFile(scrFile, new File("D:\\tmp\\page13.png"));
                    
                    driver.findElement(By.xpath(OR.policyholderICYes)).click();
                    
                    Thread.sleep(3000);
                    
                    driver.findElement(By.xpath(OR.policyholderICNum)).sendKeys(phicnum);
                    
                    Thread.sleep(3000);
                    
                    driver.findElement(By.xpath(OR.policyholderOldIC)).sendKeys(pholdic);
                    
                    Thread.sleep(3000);
                    
                    scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
                    FileUtils.copyFile(scrFile, new File("D:\\tmp\\page14.png"));
                    
                    driver.findElement(By.xpath(OR.policyholderDOBMonth)).sendKeys(phdobmonth);
                    
                    Thread.sleep(3000);
                    
                    driver.findElement(By.xpath(OR.policyholderDOBDay)).sendKeys(phdobday);
                    
                    Thread.sleep(3000);
                    
                    driver.findElement(By.xpath(OR.policyholderDOBYear)).sendKeys(phdobyear);
                    
                    Thread.sleep(3000);
                    
                    driver.findElement(By.xpath(OR.policyholderMainDriverYes)).click();
                    
                    Thread.sleep(6000);
                    
                    driver.findElement(By.xpath(OR.policyholderDrivingExp)).sendKeys(phdrivingexp);
                    
                    Thread.sleep(3000);
                    
                    driver.findElement(By.xpath(OR.policyholderRoadOffenceNo)).click();
                    
                    Thread.sleep(3000);
                    
                    driver.findElement(By.xpath(OR.claimsDamage)).sendKeys(claimsdamage);
                    
                    Thread.sleep(3000);
                    
                    driver.findElement(By.xpath(OR.claimsWindscreen)).sendKeys(claimswindscreen);
                    
                    Thread.sleep(3000);
                    
                    driver.findElement(By.xpath(OR.claimsTheft)).sendKeys(claimstheft);
                    
                    Thread.sleep(3000);
                    
                    driver.findElement(By.xpath(OR.claimsThirdParty)).sendKeys(claimsthirdparty);
                    
                    Thread.sleep(3000);
                    
                    scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
                    FileUtils.copyFile(scrFile, new File("D:\\tmp\\page16.png"));
                    
                    //driver.findElement(By.xpath(OR.policystartdateMonth)).sendKeys(pstartmonth);
                    
                    //Thread.sleep(3000);
                    
                    //driver.findElement(By.xpath(OR.policystartdateDay)).sendKeys(pstartday);
                    
                    //Thread.sleep(3000);
                    
//                    select = driver.findElement(By.xpath(OR.policystartdateYear));
//                    options = select.findElements(By.tagName("option"));
//                   for (WebElement option : options) {
//                       if(pstartyear.equals(option.getText()))
//                          option.click();   
//                    }
                    
                    //driver.findElement(By.xpath(OR.policystartdateYear)).sendKeys(pstartyear);
                    
                    Thread.sleep(3000);
                    scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
                    FileUtils.copyFile(scrFile, new File("D:\\tmp\\page17.png"));
                    
                    driver.findElement(By.xpath(OR.nextButton)).click();
                    Thread.sleep(3000);
                    scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
                    FileUtils.copyFile(scrFile, new File("D:\\tmp\\page17.png"));
                    
                    
                    driver.findElement(By.xpath(OR.nextButton)).click();
                    
                    
                    Thread.sleep(3000);
                    
                 
                    driver.findElement(By.xpath(OR.bodyType)).sendKeys(bodytype);
                    
                    
                    Thread.sleep(1000);
                    
                    driver.findElement(By.xpath(OR.engineNumber)).sendKeys(enginenum);
                    
                    
                    Thread.sleep(3000);
                    
                    //String jsgarage = "document.getElementById('"+OR.garageid+"').value=11";
                    
                    
                    //((JavascriptExecutor)driver).executeScript(jsgarage);
                    
                   driver.findElement(By.xpath("//*[@id='Garage']/option[6]")).click();
                    
                    
                    Thread.sleep(1000);
                    
                    driver.findElement(By.xpath(OR.safety)).sendKeys(safety);
                    
                    
                    Thread.sleep(1000);
                    
                    driver.findElement(By.xpath(OR.antitheft)).sendKeys(antitheft);
                    
                   Thread.sleep(1000);
                    
                    driver.findElement(By.xpath(OR.genderMale)).click();
                    
                    Thread.sleep(1000);
                    
                    driver.findElement(By.xpath(OR.maritalStatus)).sendKeys(maritalstatus);
                    
                    Thread.sleep(1000);
                    
                    driver.findElement(By.xpath(OR.occupation)).sendKeys(occupation);
                    
                    
                   Thread.sleep(1000);
                    
                    driver.findElement(By.xpath(OR.surName)).sendKeys(surname);
                    
                    
                   Thread.sleep(1000);
                    
                    driver.findElement(By.xpath(OR.givenName)).sendKeys(givenname);
                    
                   Thread.sleep(1000);
                    
                    driver.findElement(By.xpath(OR.phoneNumber)).sendKeys(phone);
                    
                   Thread.sleep(1000);
                    
                    driver.findElement(By.xpath(OR.email)).sendKeys(email);
                    
                    
                    Thread.sleep(1000);
                    
                    driver.findElement(By.xpath(OR.postalCode)).sendKeys(postalcode);
                    
                    Thread.sleep(1000);
                    
                    driver.findElement(By.xpath(OR.country)).sendKeys(country);
                    
                    Thread.sleep(1000);
                    
                    driver.findElement(By.xpath(OR.address1)).sendKeys(state);
                    
                    
                   Thread.sleep(1000);
                    
                    driver.findElement(By.xpath(OR.address2)).sendKeys(city);
                    
                   Thread.sleep(1000);
                    
                    driver.findElement(By.xpath(OR.address3)).sendKeys(street);
                    
                     Thread.sleep(1000);
                    
                    driver.findElement(By.xpath(OR.address4)).sendKeys(block);
                    
                    Thread.sleep(3000);
                    
                    driver.findElement(By.xpath(OR.nextButton)).click();
                    
                    Thread.sleep(3000);
                    
                    
                    
             		
             }    
                     
    @DataProvider
    public Object[][] dp1()
    {
            return obj;
    }
    
    @AfterClass
    public void afterSignUp()
    {
        obj1=null;
       
    }




}






        
