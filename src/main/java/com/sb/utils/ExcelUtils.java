package com.sb.utils;

import com.sb.constants.FrameworkConstants;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public final class ExcelUtils {
    private ExcelUtils(){

    }

    //try with resources

    public static List<Map<String,String>> getTestDetails(String sheetName) {

        List <Map<String,String>> list = new ArrayList<>();
        FileInputStream excelFile =null;
        XSSFWorkbook workbook =null;
        try {
            excelFile = new FileInputStream(FrameworkConstants.getExcelTestdataPath());
            workbook = new XSSFWorkbook(excelFile);
            XSSFSheet sheet = workbook.getSheet(sheetName);

            Map<String,String> map;

            int lastRowNum = sheet.getLastRowNum();
            int lastColNum = sheet.getRow(0).getLastCellNum();

            for(int i=1; i<=lastRowNum; i++){
                map= new HashMap<>();
                for (int j=0; j<lastColNum; j++){
                    String key = sheet.getRow(0).getCell(j).getStringCellValue();
                    String value = sheet.getRow(i).getCell(j).getStringCellValue();
                    map.put(key,value);
                }
                list.add(map);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (Objects.nonNull(excelFile) && Objects.nonNull(workbook)){
                try {
                    workbook.close();
                    excelFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }
}
