package az.mm.algoritms.arbitrage.currency;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author MM
 */
public class ExcelPOI {

    static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    public static void main(String[] args) throws FileNotFoundException, IOException {
        FileInputStream file = new FileInputStream(new File("C:\\Users\\USER\\Desktop\\arbitrage.xlsx"));
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheetAt(3);

        Iterator<Row> rowIterator = sheet.iterator();
        int a = 1;
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();

            if (row.getRowNum() == 0) continue;
            
            System.out.print(row.getRowNum() + "\t");
            System.out.print(getCellStringValue(row, 0) + "\t");
            System.out.print(getCellValue(row, 1) + "\t");
            System.out.print(getCellValue(row, 2) + "\t");
            System.out.print(getCellValue(row, 3) + "\t");
            System.out.print(getCellValue(row, 4) + "\t");
            System.out.print(getCellValue(row, 5) + "\t");
            System.out.print(getCellValue(row, 6) + "\t");
            System.out.print(getCellValue(row, 7) + "\t");
            System.out.print(getCellValue(row, 8) + "\t");
            System.out.print(getCellValue(row, 9) + "\t");
            System.out.print(getCellValue(row, 10) + "\t");
//            System.out.println(getCellValue(row, 11) + "\t");
//            System.out.println(getCellValue(row, 12) + "\t");
            System.out.println(row.getCell(11).getDateCellValue() == null ? "" : formatter.format(row.getCell(11).getDateCellValue()));
//            System.out.println(row.getCell(6).getDateCellValue() == null ? "" : formatter.format(row.getCell(6).getDateCellValue()));
//            System.out.println(row.getCell(5).getNumericCellValue());

        }

    }

    private static double getCellValue(Row row, int i) {
        Cell kodcell = row.getCell(i);
        if(kodcell.getCellType() == Cell.CELL_TYPE_NUMERIC)
            return kodcell.getNumericCellValue();
        
        return -654;
    }
    
    private static String getCellStringValue(Row row, int i) {
        Cell kodcell = row.getCell(i);
        String cellvalue = null;
        switch (kodcell.getCellType()) {
            case Cell.CELL_TYPE_BOOLEAN:
                if (kodcell.getBooleanCellValue()) {
                    cellvalue = "true";
                } else {
                    cellvalue = "false";
                }
                break;
            case Cell.CELL_TYPE_NUMERIC:
//                cellvalue = Long.toString((long) kodcell.getNumericCellValue());
                cellvalue = Double.toString((double) kodcell.getNumericCellValue());
                break;
            case Cell.CELL_TYPE_STRING:
                cellvalue = kodcell.getStringCellValue();
                break;
        }
        return cellvalue;
    }

    public static List<Bank> getBankList() {
        List<Bank> bankList = new ArrayList<>();
        Bank b;

        try {
            FileInputStream file = new FileInputStream(new File("C:\\Users\\USER\\Desktop\\arbitrage.xlsx"));

            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(3);

            Iterator<Row> rowIterator = sheet.iterator();
            int a = 1;
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();

                if (row.getRowNum() == 0) continue;
                
                b = new Bank(row.getRowNum(),
                            getCellStringValue(row, 0),
                            getCellValue(row, 1),
                            getCellValue(row, 2),
                            getCellValue(row, 3),
                            getCellValue(row, 4),
                            getCellValue(row, 5),
                            getCellValue(row, 6),
                            getCellValue(row, 7),
                            getCellValue(row, 8),
                            getCellValue(row, 9),
                            getCellValue(row, 10)
                           );
                bankList.add(b);
                
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }

        return bankList;
    }
}
