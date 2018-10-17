package com.jis.platform.fmj.sfexpress;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.xssf.usermodel.extensions.XSSFCellBorder.BorderSide;

import javax.servlet.http.HttpServletResponse;
import java.awt.Color;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.*;
import java.util.List;

public class ExportExcelUtils {
    public static void exportExcel(HttpServletResponse response, String fileName, ExcelData data) throws Exception {
        // 告诉浏览器用什么软件可以打开此文件
        response.setHeader("content-Type", "application/vnd.ms-excel");
        // 下载文件的默认名称
        response.setHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode(fileName, "UTF-8"));
        exportExcel(data, response.getOutputStream());
    }

    private static void exportExcel(ExcelData data, OutputStream out) throws Exception {

        XSSFWorkbook wb = new XSSFWorkbook();
        try {
            Map<String, List<LinkedHashMap<String, Object>>> datas = data.getDatas();
            Iterator<String> it = datas.keySet().iterator();
            while(it.hasNext()){
                String sheetName = it.next();
                if (org.springframework.util.StringUtils.isEmpty(sheetName)) {
                    break;
                }
                XSSFSheet sheet = wb.createSheet(sheetName);
                writeExcel(wb, sheet, data, datas.get(sheetName));
            }
            wb.write(out);
        } finally {
            wb = null;
        }
    }

    private static void writeExcel(XSSFWorkbook wb, Sheet sheet, ExcelData data, List<LinkedHashMap<String, Object>> rows) {

        int rowIndex = 0;

        rowIndex = writeTitlesToExcel(wb, sheet, rows.get(0));
        writeRowsToExcel(wb, sheet, rows, rowIndex);
        autoSizeColumns(sheet, rows.get(0).keySet().size());

    }

    private static int writeTitlesToExcel(XSSFWorkbook wb, Sheet sheet, LinkedHashMap<String, Object> titles) {
        Set<String> set = titles.keySet();
        List<String> list = new ArrayList<>();
        for(String s :set){
            list.add(String.valueOf(titles.get(s)));
        }
        return writeTitlesToExcel(wb,sheet,list);
    }

    private static int writeTitlesToExcel(XSSFWorkbook wb, Sheet sheet, List<String> titles) {
        int rowIndex = 0;
        int colIndex = 0;

        Font titleFont = wb.createFont();
        titleFont.setFontName("simsun");
        ((XSSFFont) titleFont).setBold(true);
        titleFont.setColor(IndexedColors.BLACK.index);

        XSSFCellStyle titleStyle = wb.createCellStyle();
        titleStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);
        titleStyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
        titleStyle.setFillForegroundColor(new XSSFColor(new Color(182, 184, 192)));
        titleStyle.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
        titleStyle.setFont(titleFont);
        setBorder(titleStyle, BorderStyle.THIN, new XSSFColor(new Color(0, 0, 0)));

        Row titleRow = sheet.createRow(rowIndex);

        if(titles!=null){
            for (String field : titles) {
                Cell cell = titleRow.createCell(colIndex);
                cell.setCellValue(field);
                cell.setCellStyle(titleStyle);
                colIndex++;
            }
        }


        rowIndex++;
        return rowIndex;
    }

    private static int writeRowsToExcel(XSSFWorkbook wb, Sheet sheet, List<LinkedHashMap<String,Object>> rows, int rowIndex) {
        int colIndex = 0;
        Font dataFont = wb.createFont();
        dataFont.setFontName("simsun");
        dataFont.setColor(IndexedColors.BLACK.index);

        XSSFCellStyle dataStyle = wb.createCellStyle();
        dataStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);
        dataStyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
        dataStyle.setFont(dataFont);
        setBorder(dataStyle, BorderStyle.THIN, new XSSFColor(new Color(0, 0, 0)));

        //标记从第一行开始
        for(int i = 1; i < rows.size(); i++){
            LinkedHashMap<String,Object> m = rows.get(i);
            Row dataRow = sheet.createRow(rowIndex);
            colIndex = 0;
            Set<String> set = m.keySet();
            for(String s: set){
                Cell cell = dataRow.createCell(colIndex);
                if (m.get(s) != null) {
                    cell.setCellValue(String.valueOf(m.get(s)));
                } else {
                    cell.setCellValue("");
                }
                cell.setCellStyle(dataStyle);
                colIndex++;
            }
            rowIndex++;
        }
        return rowIndex;
    }

    private static void autoSizeColumns(Sheet sheet, int columnNumber) {

        for (int i = 0; i < columnNumber; i++) {
            int orgWidth = sheet.getColumnWidth(i);
            sheet.autoSizeColumn(i, true);
            int newWidth = (int) (sheet.getColumnWidth(i) + 100);
            if (newWidth > orgWidth) {
                sheet.setColumnWidth(i, newWidth);
            } else {
                sheet.setColumnWidth(i, orgWidth);
            }
        }
    }

    private static void setBorder(XSSFCellStyle style, BorderStyle border, XSSFColor color) {
        style.setBorderTop(border);
        style.setBorderLeft(border);
        style.setBorderRight(border);
        style.setBorderBottom(border);
        style.setBorderColor(BorderSide.TOP, color);
        style.setBorderColor(BorderSide.LEFT, color);
        style.setBorderColor(BorderSide.RIGHT, color);
        style.setBorderColor(BorderSide.BOTTOM, color);
    }
}