package com.quotations;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class Xlaccess {

    public HSSFWorkbook getworkbook(String filepath) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(filepath);
            HSSFWorkbook wb = new HSSFWorkbook(fis);
            return wb;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

        return null;

    }

    public HSSFSheet getsheet(HSSFWorkbook workbook,String sheetname){
        HSSFSheet sheet=workbook.getSheet(sheetname);
        return sheet;
    }
    
    public int getrows(HSSFSheet sheet){
                
        
        int rows=sheet.getPhysicalNumberOfRows();
        return rows;
    }
    
    public String getRunMode(int rno,HSSFSheet sheet){
        HSSFRow row=sheet.getRow(rno);
        HSSFCell cell=row.getCell((short) 1);
        return cell.toString();
    }
    
    public List<String> getdetails(int rowno,int colnums,HSSFSheet sheet){
        HSSFRow row=sheet.getRow(rowno);
        List< String> list=new ArrayList<String>();
        for(Short i=0;i<colnums;i++){
            Object value=null;
            HSSFCell cell=row.getCell(i);   
           
            switch (cell.getCellType()) 
            {

                case HSSFCell.CELL_TYPE_FORMULA:
                    value = "FORMULA value=" + cell.getCellFormula();
                    break;

                case HSSFCell.CELL_TYPE_NUMERIC:
                    value =cell.getNumericCellValue();
                	
                    
                    break;

                case HSSFCell.CELL_TYPE_STRING:
                    value = cell.getRichStringCellValue();
                    break;

                default:
            }
        list.add((value.toString()));    
        
        
        }
            
        return list;
                    
}
    
    
    public void writeresult(String filepath,int row,int col,String sheetname,String data){
        Xlaccess xl=new Xlaccess();
        HSSFWorkbook wb=xl.getworkbook(filepath);
        HSSFSheet s1=xl.getsheet(wb, sheetname);
        HSSFRow r=s1.getRow(row);
        HSSFCell c=r.getCell((short) col);
        c.setCellValue(new HSSFRichTextString(data));
        FileOutputStream stream=null;
        try {
            stream=new FileOutputStream(filepath);
            wb.write(stream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(stream!=null){
                try {
                    stream.flush();
                    stream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }}}
                
            
        
    
                    
                
            
    }
}




