package com.quotations;

import org.testng.Assert;
import org.testng.Reporter;

public class ErrorReport {
    
    public StringBuffer verificationErrors;

     public void Reporting() {
      verificationErrors = new StringBuffer();
     }
     
     public void verifyEquals(String msg, String s1, String s2) {
          try {
           Assert.assertEquals(s1, s2);
          } catch (Error e) {
           verificationErrors.append(e);
           Reporter.log(msg +"");
          }
         }
     
     public void verifyEquals(String msg, int s1, int s2) {
          try {
           Assert.assertEquals(s1, s2);
          } catch (Error e) {
           verificationErrors.append(e);
           Reporter.log(msg +"");
          }
         }
     
     public  void verifyEquals(String msg,boolean iswebpage ) {
          try {
           Assert.assertTrue(iswebpage);
          } catch (Error e) {
           verificationErrors.append(e);
           Reporter.log(msg +"");
           
          }
         }
     
     public void clearVerificationErrors() {
          verificationErrors = new StringBuffer();
          
         }

         public String Report() {
          String verificationErrorString = verificationErrors.toString();
          
          // Clear Verification Errors so that it is ready to test new verifications
          clearVerificationErrors();
          if (!"".equals(verificationErrorString))
          
          Reporter.log(verificationErrorString);
        return verificationErrorString;
           }
         
         public  void message(String msg) {
             
               verificationErrors.append(msg);
               Reporter.log(msg +"");
               
              }

}






