package com.quotations;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class NewQuotation extends TestBase {
    

    
    ErrorReport rep=new ErrorReport();
    
    String gtomdata;
    String gtomprofilingsheet = "profiling";
    
    
    Object obj[][];
    
    
    Object obj1[][];
    
    
    String uname,pwd;
    
    @BeforeClass
    public void beforeSignUp()
    {   
        
            rep.Reporting();
            
            obj=xlData(gtomprofilingsheet,6); 
            
            rep.message("Sign Up Page Test Fields are :Fname,Lname,Location,City,Email,Password,Confirm Pwd, Plan");
    }

    
    
    @Test(dataProvider="dp1")
    public  void LoginTest(String sno,String logintype,String username,String password, String businesstype, String plantype) throws InterruptedException
    {   
    	
    	int sn=1;
        
        rep.Reporting();
        
         String internallogin = "https://preprodapsso.axa-tech.com/forms/sso/gtom/all/axaloginint.fcc?TYPE=33554433&REALMOID=06-000ab3f4-1618-15c8-bb0f-42280a90908d&GUID=&SMAUTHREASON=0&METHOD=GET&SMAGENTNAME=-SM-mjIFa%2fRlDlrH0esHhDfJPgpNYGvDUoUJtPITw%2fMbRu%2bXtJDeIpHnVPfEtCDpjurT7FUWAzcu1fZXN16F%2fM4mTheQGCZocDar&TARGET=-SM-HTTPS%3a%2f%2finet7--my--test%2eapplications%2eservices%2ecorp%2eintraxa%2fuat2%2fprweb%2fPRServletCustom";
	     String externallogin = "https://preprodapsso.axa-tech.com/forms/sso/gtommy/uat/axalogin.fcc?TYPE=33554433&REALMOID=06-000053a2-14f8-15c8-bb0f-42280a90908d&GUID=&SMAUTHREASON=0&METHOD=GET&SMAGENTNAME=-SM-2x4FP5Xr%2fBS0As7NejkGZ7tvowRc2koNOq32ptNcyTx7pPKjN%2fcZWrw%2fcNU%2bb%2f2kw%2bIraFOw8SxlXWr%2biOROqJ9Y07COQUy%2b&TARGET=-SM-HTTPS%3a%2f%2finet7--test%2eaxa%2ecom%2emy%2fuat2%2fprweb%2fPRServletCustom";
	    
	     if(logintype.equals("internal")) {  System.out.println("Accessing Internal Login...");
	     driver.get(internallogin); }
	     else { System.out.println("Accessing External Login..."); driver.get(externallogin); }
        
                  
                      int  min=1;int max=6;int rand;
                      rand = (int) (Math.random() * (max - min + 1) ) + min;
                      
                      driver.findElement(By.name("USER")).sendKeys(username);
             	      driver.findElement(By.name("PASSWORD")).sendKeys(password);
             	      driver.findElement(By.name("PASSWORD")).submit();
             	      
             	     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
             	     
             	     String pagetitle = driver.getTitle();
             	     
             	     System.out.println(pagetitle);
             	     
             		 if(pagetitle.equals("AXA iConnect")) {  
             			 System.out.println(" Login Successfully, now it is the time to Log Off buddy.");
             			 
             			 
             		 }
             		 
             		 
             		 
                     if(businesstype.equals("Private Car")){
             			
             			driver.findElement(By.xpath("//*[@id='EXPAND-OUTERFRAME']/div[2]/div/div/div/div/div/div/div[1]/div/div/div/div/div[2]/div/div/div/div/div[1]/div/div/span/a")).click();
             			Thread.sleep(3000);
             		}
             		
             		else{
             			
             			driver.findElement(By.xpath("//*[@id='EXPAND-OUTERFRAME']/div[2]/div/div/div/div/div/div/div[2]/div/div/div/div/div[2]/div/div/div/div/div[1]/div/div/span/a")).click();
             			Thread.sleep(3000);
             			
             		}
             		 
             		driver.findElement(By.xpath("//*[@id='DisclaimerYesNew']")).click();
             		Thread.sleep(3000);
             		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
             		 
             		driver.findElement(By.xpath("//*[@id='CT']/div/div/span/button")).click();
             		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
             		 
             		
             		
             		
             		
                    if(plantype.equals("TPFT")){
             			
             			driver.findElement(By.xpath("html/body/div[3]/form/div[3]/div[2]/table/tbody/tr/td/div/table/tbody/tr/td/div/span/div/div[2]/div[2]/div/div[2]/div/div/div/div/div/div[3]/div/div/span/button")).click();
             			Thread.sleep(3000);
             		}
                    
                    else if(plantype.equals("TP")){
             			
             			driver.findElement(By.xpath("html/body/div[3]/form/div[3]/div[2]/table/tbody/tr/td/div/table/tbody/tr/td/div/span/div/div[2]/div[2]/div/div[3]/div/div/div/div/div/div[3]/div/div/span/button")).click();
             			Thread.sleep(3000);
             		}
             		
             		else{
             			
             			driver.findElement(By.xpath("html/body/div[3]/form/div[3]/div[2]/table/tbody/tr/td/div/table/tbody/tr/td/div/span/div/div[2]/div[2]/div/div[1]/div/div/div/div/div/div[3]/div/div/span/button")).click();
             			Thread.sleep(3000);
             			
             		}
             		
             		
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






        
