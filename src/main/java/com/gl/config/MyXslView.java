package com.gl.config;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 
 * @author 郭亮
 * @date 2020/11/8 15:04 
 **/
public class MyXslView extends AbstractXlsView {
    @Override
    protected void buildExcelDocument(Map<String, Object> model, org.apache.poi.ss.usermodel.Workbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception {
        int row = (int) model.get("row");
        int col = (int) model.get("col");
        Sheet sheet = workbook.createSheet();
        for (int i=0;i<row;i++) {
            Row row1 = sheet.createRow(i);
            for (int j=0;j<col;j++) {
                Cell cell = row1.createCell(j);
                cell.setCellValue(i*j);
            }
        }
    }
}
