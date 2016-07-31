 package com.quotations;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;




public class TestBase {
    

         static WebDriver driver;
         HSSFWorkbook workbook;
         HSSFSheet sheet;
         static Xlaccess x3;
        List< String> list=new ArrayList<String>();
        Object obj3[][];
        String sheetname;
     
    String  Affluencexlfilepath;    
        
    public static  void setup()
    {  
    	 System.setProperty("webdriver.chrome.driver" , "D:/selenium/chromedriver/chromedriver.exe");
         driver = new ChromeDriver();
         driver.manage().window().maximize();
//         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         
         
             
               
    } 
    
    
    
    public Object[][] xlData(String sheetname,int colnums)
    {
        Affluencexlfilepath=System.getProperty("user.dir")+"\\gtomdata.xls"; 
        x3=new Xlaccess();
        int rowsExec=1; 
        
         workbook=x3.getworkbook(Affluencexlfilepath);
         sheet=x3.getsheet(workbook, sheetname);    
          int k=-1;
         int rows=x3.getrows(sheet);
         
         System.out.println("No. of Rows"+rows);
        
       
         obj3=new Object[rows-1][colnums];
            for(int j=1;j<rows;j++)
            {            k++;
                                 List<String> list=x3.getdetails(j,colnums,sheet);
                                           for(int p=0;p<list.size();p++)
                                                  { 
                                                       obj3[k][p]=list.get(p); 
                                                    
                                                   }
                             
                             
    
            }
            return obj3;
    
        
    }
    
    
    public String[][] Csv() throws Exception{
    
        
        
            
                  Map<Integer, String>map=new HashMap<Integer, String>();
                  BufferedReader CSVFile =   new BufferedReader(new FileReader("D:/ex.csv"));
                  CSVFile.readLine(); // Read headers line.
                  String dataRow ;
                  dataRow= CSVFile.readLine(); // Read first line.
                  int i=0;
                  while (dataRow != null){
                   map.put(i,dataRow);
                   i++;
                   dataRow= CSVFile.readLine(); // Read next lines.  
                  }  
                  CSVFile.close();
                  String[][] csvdata=new String[map.size()][];      
                  
                  for(int j=0;j<map.size();j++){
                  csvdata[j]=map.get(j).split(",");
                  }
                return csvdata;
            } 
                  
                  
    public String   isAlertPresent() {
         
         // boolean presentFlag = false;
        String  al="No alert";
          try {
         
           // Check the presence of alert
           Alert alert = driver.switchTo().alert();
           // Alert present; set the flag
           al=alert.getText();
           // if present consume the alert
           alert.accept();
         
          } catch (NoAlertPresentException ex) {
           // Alert not present
           ex.printStackTrace();
           
          }
         
          return al;
         
         }          
                    
            
        public List<Integer> RandomList(int min,int max,int nums)
        {  List<Integer> generated = new ArrayList<Integer>();
        
        for (int i = 0; i < nums; i++)
        {
            while(true)
            {
               // Integer next = rng.nextInt(max) + 1;
                Integer next = (int) (Math.random() * (max - min + 1) ) + min;
                if (!generated.contains(next))
                {
                    // Done for this iteration
                    generated.add(next);
                    break;
                }
            }
        }

         
        
    
            return generated;
            
        
        }
    
    
    public void teardownsetup()
    {
            obj3=null;
            //driver.close();
            
    }
    
    @BeforeSuite
    public void beforeSuite()
    {
        setup();
        
    }
    
    @AfterSuite
    public void afterSuite()
    {
        teardownsetup();
        
    }
    
    
         
         
          public  String getMonth(int month) {
                return new DateFormatSymbols().getMonths()[month-1];
            }
    
          
          public String StringtoDate(String date,String month,String year)
            {
                String status="Upcoming";
//                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                Date dateNow = new Date();

                 try { String str_date=date+"-"+month+"-"+year;
                 DateFormat formatter1 ; 
                 Date date1; 
                  formatter1 = new SimpleDateFormat("dd-MM-yy");
                  date1 = formatter1.parse(str_date);  
                  if(date1.before(dateNow))
                  {
                      status="past";
                  }
                  else
                  {
                      status="Upcoming";
                  }
                 }
                   catch (ParseException e)
                  {System.out.println("Exception :"+e);  }  
                 
                   
                 
                return status;
                
            }

}
