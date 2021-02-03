package com.gl.utils;

import lombok.Data;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author 郭亮
 * @date 2021/1/6 17:39
 **/
public class DBUtils {

    public static void main(String[] args) throws Exception {
        oracleHandle(getMateData());
    }

    private static MetaData getMateData() throws Exception {
        MetaData metaData = new MetaData();
        Connection connection = null;
        ResultSet resultSet = null;
        ResultSet rs = null;
        try {
            Set<String> tables = new HashSet<>();
            Map<String, String> map = new HashMap<>();
            //connection =  DriverManager.getConnection("jdbc:dm://192.168.20.80:5236", "ZGY_ECOURT", "123456789");
            connection =  DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.74:1521:orcl", "wzcourt", "wzcourt");
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT DISTINCT TABLE_NAME FROM USER_TAB_COLUMNS");
            while (resultSet.next()) {
                String table_name = resultSet.getString("TABLE_NAME");
                tables.add(table_name.toUpperCase());
            }
            metaData.setTables(tables);
            rs = statement.executeQuery("SELECT TABLE_NAME,COLUMN_NAME,DATA_LENGTH FROM USER_TAB_COLUMNS");
            while (rs.next()) {
                String table_name = rs.getString("TABLE_NAME");
                String column_name = rs.getString("COLUMN_NAME");
                String data_length = rs.getString("DATA_LENGTH");
                String key = table_name + "::" + column_name;
                map.put(key, data_length);
            }
            metaData.setData(map);
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return metaData;
    }

    private static void handle(MetaData metaData) throws Exception {
        Set<String> repeatSet = new HashSet<>();
        Set tables = metaData.getTables();
        Map<String, String> data = metaData.getData();
        XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream("E:\\Zha\\TAB(1).xlsx"));
        XSSFSheet sheet3 = workbook.getSheet("sheet3");
        for (int i=0;i<=sheet3.getLastRowNum();i++) {
            XSSFRow row = sheet3.getRow(i);
            if (i==0 || i==sheet3.getLastRowNum()) {
                row.cellIterator().forEachRemaining((cell)-> System.out.println(cell.getStringCellValue()));
            }
            String tablename = String.valueOf(row.getCell(0));
            if (!tables.contains(tablename.toUpperCase())) {
                XSSFCell cell = row.createCell(4);
                cell.setCellValue("无表");
                continue;
            }
            String colname = String.valueOf(row.getCell(1));
            String orglength = String.valueOf(row.getCell(3));
            String key = tablename + "::" + colname;
            if (repeatSet.contains(key)) {
                XSSFCell cell = row.createCell(4);
                cell.setCellValue("重复");
                continue;
            }
            repeatSet.add(key);
            String length = data.get(key);
            if (length == null || "".equals(length)) {
                XSSFCell cell = row.createCell(4);
                cell.setCellValue("为此字段");
                continue;
            }
            if (orglength.equals(length)) {
                XSSFCell cell = row.createCell(4);
                cell.setCellValue("无问题");
                continue;
            }
            XSSFCell cell = row.createCell(4);
            cell.setCellValue("需修改");
            XSSFCell cell1 = row.createCell(5);
            cell1.setCellValue("ALTER TABLE " + tablename.toUpperCase() + " MODIFY " + colname.toUpperCase() + " VARCHAR2(" + length + ") NULL;");
        }
        FileOutputStream fileOutputStream = new FileOutputStream("E:\\Zha\\out.xlsx");
        workbook.write(fileOutputStream);
    }

    private static void oracleHandle(MetaData metaData) throws Exception {
        Set tables = metaData.getTables();
        Map<String, String> data = metaData.getData();
        XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream("E:\\Zha\\outer.xlsx"));
        XSSFSheet sheet3 = workbook.getSheet("sheet3");
        for (int i=0;i<=sheet3.getLastRowNum();i++) {
            XSSFRow row = sheet3.getRow(i);
            if (i==0 || i==sheet3.getLastRowNum()) {
                row.cellIterator().forEachRemaining((cell)-> System.out.println(cell.getStringCellValue()));
            }
            String tablename = String.valueOf(row.getCell(0));
            String colname = String.valueOf(row.getCell(1));
            String orglength = String.valueOf(row.getCell(3));
            String desc = String.valueOf(row.getCell(4));
            if ("需修改".equals(desc)||"重复".equals(desc)) {
                continue;
            }
            String key = tablename + "::" + colname;
            String length = data.get(key);
            if (!tables.contains(tablename.toUpperCase())) {
                XSSFCell cell = row.getCell(4);
                cell.setCellValue(desc + "_oracle无表");
                continue;
            }
            if (length == null || "".equals(length)) {
                XSSFCell cell = row.createCell(4);
                cell.setCellValue(desc + "_oracle为此字段");
                continue;
            }
            if (!"8188".equals(orglength) && "无问题".equals(desc)) {
                continue;
            }
            row.getCell(4).setCellValue(desc + "_oracle数据库修改");
            XSSFCell cell1 = row.createCell(5);
            cell1.setCellValue("ALTER TABLE " + tablename.toUpperCase() + " MODIFY " + colname.toUpperCase() + " VARCHAR2(" + ((int)(Integer.parseInt(length)*1.5)) + ") NULL;");
        }
        FileOutputStream fileOutputStream = new FileOutputStream("E:\\Zha\\out.xlsx");
        workbook.write(fileOutputStream);
    }
}

@Data
class MetaData {
    private Set tables;
    private Map<String, String> data;
}
