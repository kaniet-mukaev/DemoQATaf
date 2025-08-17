package com.demoqa.listeners;

import com.demoqa.drivers.DriverManager;
import io.qameta.allure.Attachment;
import org.apache.poi.common.usermodel.HyperlinkType;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class ScreenShotListener extends TestListenerAdapter {

    private static final String FAILED_TESTS_FILE = "test-output/failed_tests.xlsx";
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenShotAsPNG() {
        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        saveScreenShotAsPNG();
        Workbook workbook;
        Sheet sheet;
        File file = new File(FAILED_TESTS_FILE);

        try {
            if (file.exists()) {
                workbook = new XSSFWorkbook(new FileInputStream(file));
                sheet = workbook.getSheet("Failed Tests");
                if (sheet == null) {
                    sheet = workbook.createSheet("Failed Tests");
                    createHeaderRow(sheet);
                }
            } else {
                workbook = new XSSFWorkbook();
                sheet = workbook.createSheet("Failed Tests");
                createHeaderRow(sheet);
            }

            int lastRowNum = sheet.getLastRowNum();
            Row row = sheet.createRow(lastRowNum + 1);

            // 1. Основная информация о тесте
            row.createCell(0).setCellValue(LocalDateTime.now().format(DATE_FORMATTER));
            row.createCell(1).setCellValue(result.getTestClass().getName());
            row.createCell(2).setCellValue(result.getName());
            row.createCell(3).setCellValue(result.getThrowable().getMessage());

            // 2. Параметры теста (если есть)
            if (result.getParameters() != null && result.getParameters().length > 0) {
                row.createCell(4).setCellValue(Arrays.toString(result.getParameters()));
            }

            // 3. Скриншот (добавляется как картинка в Excel)
            addScreenshotToExcel(workbook, sheet, row);

            // 4. Ссылка на Allure отчет
            Hyperlink link = workbook.getCreationHelper().createHyperlink(HyperlinkType.FILE);
            link.setAddress("allure-report/index.html");
            Cell cell = row.createCell(5);
            cell.setHyperlink(link);
            cell.setCellValue("Allure Report");

            // Автонастройка ширины колонок
            for (int i = 0; i < 6; i++) { // Увеличили до 6, так как добавили новые колонки
                sheet.autoSizeColumn(i);
            }

            // Сохраняем файл
            try (FileOutputStream fos = new FileOutputStream(file)) {
                workbook.write(fos);
            }
            workbook.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createHeaderRow(Sheet sheet) {
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Timestamp");
        headerRow.createCell(1).setCellValue("Test Class");
        headerRow.createCell(2).setCellValue("Test Method");
        headerRow.createCell(3).setCellValue("Error Message");
        headerRow.createCell(4).setCellValue("Parameters");
        headerRow.createCell(5).setCellValue("Report Link");
    }

    private void addScreenshotToExcel(Workbook workbook, Sheet sheet, Row row) throws IOException {
        byte[] screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
        int pictureIdx = workbook.addPicture(screenshot, Workbook.PICTURE_TYPE_PNG);

        CreationHelper helper = workbook.getCreationHelper();
        Drawing<?> drawing = sheet.createDrawingPatriarch();

        ClientAnchor anchor = helper.createClientAnchor();
        anchor.setCol1(6); // Колонка после всех данных (0-5)
        anchor.setRow1(row.getRowNum());

        drawing.createPicture(anchor, pictureIdx);
        sheet.autoSizeColumn(6); // Автоподбор ширины для колонки со скриншотом
    }
}
