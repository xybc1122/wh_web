package com.wh.utils;

import com.wh.exception.LsException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class XlsUtils {


    private static final String EXCEL_XLS = "xls";
    private static final String EXCEL_XLSX = "xlsx";


    public static List<String> getXlsHead(Sheet sheet, int totalNumber) {
        Row row;
        Cell cell;
        List<String> xlsListHead = new ArrayList<>();
        for (int i = 0; i < 1; i++) {
            row = sheet.getRow(i);
            for (int j = 0; j < totalNumber; j++) {
                cell = row.getCell(j);
                //拿到数据表的表头
                xlsListHead.add(cell.toString().trim());
                //System.out.println(cell.toString().trim());
            }
        }
        return xlsListHead;
    }

    /**
     * 判断文件类型
     */
    public static Workbook fileType(FileInputStream in, File file) throws IOException {

        //判断文件是否是excel
        XlsUtils.checkExcel(file);
        //判断Excel的版本,获取Workbook
        return XlsUtils.getWorkbook(in, file);

    }

    /**
     * 判断Excel的版本,获取Workbook
     *
     * @param in
     * @return
     * @throws IOException
     */
    public static Workbook getWorkbook(InputStream in, File file) throws IOException {
        Workbook wb = null;
        if (file.getName().endsWith(EXCEL_XLS)) {  //Excel 2003
            throw new LsException("版本为2003请升级到2007");
        } else if (file.getName().endsWith(EXCEL_XLSX)) {  // Excel 2007/2010
            wb = new XSSFWorkbook(in);
        }
        return wb;
    }

    /**
     * 判断文件是否是excel
     *
     * @throws Exception
     */
    public static void checkExcel(File file) {
        if (!file.exists()) {
            throw new LsException("文件不存在");
        }
        if (!(file.isFile() && (file.getName().endsWith(EXCEL_XLS) || file.getName().endsWith(EXCEL_XLSX)))) {
            throw new LsException("文件不是Excel");
        }
    }

    /**
     * 类型判断
     *
     * @param cell
     * @return
     */
    public static String getCellValue(Cell cell) {
        String str = null;
        if (cell == null) {
            return null;
        }
        switch (cell.getCellType()) {
            case STRING:
                str = cell.getRichStringCellValue().getString();
                break;
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    str = String.valueOf(cell.getDateCellValue().getTime());
                } else {
                    str = String.valueOf(cell.getNumericCellValue());
                }
                break;
            case BOOLEAN:
                str = String.valueOf(cell.getBooleanCellValue());
                break;
            case FORMULA:
                str = String.valueOf(cell.getCellFormula());
                break;
            case BLANK:
                return null;
            default:
                return null;
        }
        return str;
    }

    /**
     * 简单导出Excel
     *
     * @param xssList
     * @param filePath
     */
    public static void outPutXssFile(List<List<String>> xssList, String filePath, String uuidName) {
        FileUtils.mkdirFile(filePath);
        Workbook wb = new XSSFWorkbook();
        Sheet sheet = wb.createSheet();
        for (int i = 0; i < xssList.size(); i++) {
            List<String> d = xssList.get(i);
            Row row = sheet.createRow(i);
            for (int j = 0; j < d.size(); j++) {
                String p = d.get(j);
                row.createCell(j).setCellValue(p);
            }
        }
        OutputStream fileOut = null;
        try {
            fileOut = new FileOutputStream(filePath + uuidName);
            wb.write(fileOut);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileOut != null) {
                try {
                    fileOut.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}