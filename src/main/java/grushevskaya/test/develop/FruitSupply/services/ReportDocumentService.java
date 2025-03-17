package grushevskaya.test.develop.FruitSupply.services;

import grushevskaya.test.develop.FruitSupply.TO.ReportedSuppliedFruitTO;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ReportDocumentService {

    public byte[] generateExcelReport(List<ReportedSuppliedFruitTO> data) throws IOException {
        Map<LocalDate, Map<String, List<ReportedSuppliedFruitTO>>> groupedData = data.stream()
                .collect(Collectors.groupingBy(
                        ReportedSuppliedFruitTO::getSupplierDate,
                        Collectors.groupingBy(ReportedSuppliedFruitTO::getSupplierName)
                ));

        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Отчет по поставкам");

            CellStyle headerStyle = workbook.createCellStyle();
            Font headerFont = workbook.createFont();
            headerFont.setBold(true);
            headerStyle.setFont(headerFont);

            int rowIndex = 0;

            for (Map.Entry<LocalDate, Map<String, List<ReportedSuppliedFruitTO>>> dateEntry : groupedData.entrySet()) {
                LocalDate date = dateEntry.getKey();
                Map<String, List<ReportedSuppliedFruitTO>> suppliers = dateEntry.getValue();

                Row dateRow = sheet.createRow(rowIndex++);
                Cell dateCell = dateRow.createCell(0);
                dateCell.setCellValue("Дата: " + date);
                dateCell.setCellStyle(headerStyle);

                for (Map.Entry<String, List<ReportedSuppliedFruitTO>> supplierEntry : suppliers.entrySet()) {
                    String supplierName = supplierEntry.getKey();
                    List<ReportedSuppliedFruitTO> fruits = supplierEntry.getValue();

                    Row supplierRow = sheet.createRow(rowIndex++);
                    Cell supplierCell = supplierRow.createCell(0);
                    supplierCell.setCellValue("Поставщик: " + supplierName);
                    supplierCell.setCellStyle(headerStyle);

                    Row headerRow = sheet.createRow(rowIndex++);
                    String[] headers = {"Фрукт", "Вес (кг)", "Цена (руб)"};
                    for (int i = 0; i < headers.length; i++) {
                        Cell cell = headerRow.createCell(i);
                        cell.setCellValue(headers[i]);
                        cell.setCellStyle(headerStyle);
                    }

                    for (ReportedSuppliedFruitTO fruit : fruits) {
                        Row fruitRow = sheet.createRow(rowIndex++);
                        fruitRow.createCell(0).setCellValue(fruit.getFruitName());
                        fruitRow.createCell(1).setCellValue(fruit.getWeight());
                        fruitRow.createCell(2).setCellValue(fruit.getPrice());
                    }

                    rowIndex++;
                }
            }

            for (int i = 0; i < 3; i++) {
                sheet.autoSizeColumn(i);
            }

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            workbook.write(outputStream);
            return outputStream.toByteArray();
        }
    }
}
