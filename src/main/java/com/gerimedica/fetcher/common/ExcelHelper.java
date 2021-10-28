package com.gerimedica.fetcher.common;

import com.gerimedica.fetcher.model.Record;
import org.apache.poi.ss.usermodel.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelHelper {
    static String[] HEADERs = {"Source", "CodeListCode", "Code", "DisplayValue", "FromDate", "ToDate", "SortingPriority"};
    static String SHEET = "exercise";

    public static List<Record> excelToRecords(InputStream is) {
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(is);
            Sheet sheet = workbook.getSheet(SHEET);
            Iterator<Row> rows = sheet.iterator();

            List<Record> records = new ArrayList<Record>();

            int rowNumber = 0;
            while (rows.hasNext()) {
                Row currentRow = rows.next();

                // skip header
                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }

                Iterator<Cell> cellsInRow = currentRow.iterator();

                Record record = new Record();

                int cellIdx = 0;
                while (cellsInRow.hasNext()) {
                    Cell currentCell = cellsInRow.next();

                    switch (cellIdx) {
                        case 0:
                            record.setSource(currentCell.getStringCellValue());
                            break;

                        case 1:
                            record.setCodeListCode(currentCell.getStringCellValue());
                            break;

                        case 2:
                            record.setCode(currentCell.getStringCellValue());
                            break;

                        case 3:
                            record.setDisplayValue(currentCell.getStringCellValue());
                            break;

                        case 4:
                            record.setLongDescription(currentCell.getStringCellValue());
                            break;

                        case 5:
                            record.setFromDate(currentCell.getLocalDateTimeCellValue());
                            break;

                        case 6:
                            record.setToDate(currentCell.getLocalDateTimeCellValue());
                            break;

                        case 7:
                            record.setSortingPriority((long) currentCell.getNumericCellValue());
                            break;

                        default:
                            break;
                    }
                    cellIdx++;
                }
                records.add(record);
            }
            workbook.close();

            return records;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
        }
    }
}
