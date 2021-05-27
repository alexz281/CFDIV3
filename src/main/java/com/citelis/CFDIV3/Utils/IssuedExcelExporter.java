package com.citelis.CFDIV3.Utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import com.citelis.CFDIV3.Model.IssuedModel;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.data.domain.Page;

public class IssuedExcelExporter {
    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    static String[] HEADERs =
            {
                    "Status",
                    "Fecha de Cancelación",
                    "Versión",
                    "Tipo de CFDI",
                    "Series",
                    "Folio",
                    "CFDI",
                    "Emisión",
                    "Receptor",
                    "Descripción del Receptor",
                    "Emisor",
                    "Descripción Emisor",
                    "Descripcion",
                    "Metodo de Pago",
                    "Forma de Pago",
                    "SubTotal",
                    "Descuento",
                    "Impuestos",
                    "IVA Retenido",
                    "Total"
            };

    static String SHEET = "Issued";

    public static ByteArrayInputStream issuedToExcel(Page<IssuedModel> issuedModels) {
        try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
            Sheet sheet = workbook.createSheet(SHEET);
            // Header
            Row headerRow = sheet.createRow(0);
            for (int col = 0; col < HEADERs.length; col++) {
                Cell cell = headerRow.createCell(col);
                cell.setCellValue(HEADERs[col]);
            }
            int rowIdx = 1;
            for (IssuedModel issuedModel : issuedModels) {
                Row row = sheet.createRow(rowIdx++);
                row.createCell(0).setCellValue(issuedModel.getStatus());
                row.createCell(1).setCellValue(issuedModel.getCancellation_datetime().toString());
                row.createCell(2).setCellValue(issuedModel.getVersion());
                row.createCell(3).setCellValue(issuedModel.getCfditype());
                row.createCell(4).setCellValue(issuedModel.getSeries());
                row.createCell(5).setCellValue(issuedModel.getFolio());
                row.createCell(6).setCellValue(issuedModel.getUuid());
                row.createCell(7).setCellValue(issuedModel.getCfdidatetime());
                row.createCell(8).setCellValue(issuedModel.getReceiver_rfc());
                row.createCell(9).setCellValue(issuedModel.getReceiver_name());
                row.createCell(10).setCellValue(issuedModel.getIssuer_rfc());
                row.createCell(11).setCellValue(issuedModel.getIssuer_name());
                row.createCell(12).setCellValue(issuedModel.getDescripcion());
                row.createCell(13).setCellValue(issuedModel.getPayment_method());
                row.createCell(14).setCellValue(issuedModel.getPayment_mode());
                row.createCell(15).setCellValue(issuedModel.getSubtotal());
                row.createCell(16).setCellValue(issuedModel.getDiscount_total_amount());
                row.createCell(17).setCellValue(issuedModel.getIva());
                row.createCell(18).setCellValue(issuedModel.getIva_retenido());
                row.createCell(19).setCellValue(issuedModel.getTotal());
            }
            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
        }
    }
}
