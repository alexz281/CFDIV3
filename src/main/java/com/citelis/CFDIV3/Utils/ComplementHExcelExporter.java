package com.citelis.CFDIV3.Utils;

import com.citelis.CFDIV3.Model.ComplementHModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.data.domain.Page;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ComplementHExcelExporter {
    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    static String[] HEADERs =
            {
                    "Compañia",
                    "UUID de Pago",
                    "Fecha Pago (ERP)",
                    "Fecha CFDI de Pago",
                    "Serie Folio",
                    "UUID Factura",
                    "Emisión factura",
                    "RFC",
                    "Descripción",
                    "Método de Pago",
                    "Monto del Pago (Complemento)",
                    "Moneda",
                    "SubTotal",
                    "Descuento",
                    "IVA",
                    "Total",
                    "Saldo Insoluto"
            };

    static String SHEET = "ComplementH";

    public static ByteArrayInputStream complementHToExcel(Page<ComplementHModel> complementHModels) {
        try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
            Sheet sheet = workbook.createSheet(SHEET);
            // Header
            Row headerRow = sheet.createRow(0);
            for (int col = 0; col < HEADERs.length; col++) {
                Cell cell = headerRow.createCell(col);
                cell.setCellValue(HEADERs[col]);
            }
            int rowIdx = 1;
            for (ComplementHModel complementHModel : complementHModels) {
                Row row = sheet.createRow(rowIdx++);
                row.createCell(0).setCellValue(complementHModel.getCompany());
                row.createCell(1).setCellValue(complementHModel.getUuid_pay());
                row.createCell(2).setCellValue(complementHModel.getTransdate());
                row.createCell(3).setCellValue(complementHModel.getPayment_date_time());
                row.createCell(4).setCellValue(complementHModel.getFolio());
                row.createCell(5).setCellValue(complementHModel.getUuid_invoice());
                row.createCell(6).setCellValue(complementHModel.getCfdidatetime());
                row.createCell(7).setCellValue(complementHModel.getIssuer_rfc());
                row.createCell(8).setCellValue(complementHModel.getDesc_vend());
                row.createCell(9).setCellValue(complementHModel.getPaymentmethod());
                row.createCell(10).setCellValue(complementHModel.getPay_amount());
                row.createCell(11).setCellValue(complementHModel.getCurrency_invoice());
                row.createCell(12).setCellValue(complementHModel.getSubtotal());
                row.createCell(13).setCellValue(complementHModel.getDiscount_total_amount());
                row.createCell(14).setCellValue(complementHModel.getTaxes_invoice());
                row.createCell(15).setCellValue(complementHModel.getTotal());
                row.createCell(16).setCellValue(complementHModel.getOutstanding_balance());

            }
            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
        }
    }
}
