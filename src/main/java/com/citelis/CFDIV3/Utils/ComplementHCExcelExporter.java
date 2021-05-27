package com.citelis.CFDIV3.Utils;

import com.citelis.CFDIV3.Model.ComplementHCModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.data.domain.Page;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ComplementHCExcelExporter {
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

    static String SHEET = "ComplementHC";

    public static ByteArrayInputStream complementHCToExcel(Page<ComplementHCModel> complementHCModels) {
        try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
            Sheet sheet = workbook.createSheet(SHEET);
            // Header
            Row headerRow = sheet.createRow(0);
            for (int col = 0; col < HEADERs.length; col++) {
                Cell cell = headerRow.createCell(col);
                cell.setCellValue(HEADERs[col]);
            }
            int rowIdx = 1;
            for (ComplementHCModel complementHCModel : complementHCModels) {
                Row row = sheet.createRow(rowIdx++);
                row.createCell(0).setCellValue(complementHCModel.getCompany());
                row.createCell(1).setCellValue(complementHCModel.getUuid_pay());
                row.createCell(2).setCellValue(complementHCModel.getTransdate());
                row.createCell(3).setCellValue(complementHCModel.getPayment_date_time());
                row.createCell(4).setCellValue(complementHCModel.getFolio());
                row.createCell(5).setCellValue(complementHCModel.getUuid_invoice());
                row.createCell(6).setCellValue(complementHCModel.getCfdidatetime());
                row.createCell(7).setCellValue(complementHCModel.getIssuer_rfc());
                row.createCell(8).setCellValue(complementHCModel.getDesc_vend());
                row.createCell(9).setCellValue(complementHCModel.getPaymentmethod());
                row.createCell(10).setCellValue(complementHCModel.getPay_amount());
                row.createCell(11).setCellValue(complementHCModel.getCurrency_invoice());
                row.createCell(12).setCellValue(complementHCModel.getSubtotal());
                row.createCell(13).setCellValue(complementHCModel.getDiscount_total_amount());
                row.createCell(14).setCellValue(complementHCModel.getTaxes_invoice());
                row.createCell(15).setCellValue(complementHCModel.getTotal());
                row.createCell(16).setCellValue(complementHCModel.getOutstanding_balance());

            }
            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
        }
    }
}
