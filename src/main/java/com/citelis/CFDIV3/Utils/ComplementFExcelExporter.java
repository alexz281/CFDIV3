package com.citelis.CFDIV3.Utils;

import com.citelis.CFDIV3.Model.ComplementFModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.data.domain.Page;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ComplementFExcelExporter {
    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    static String[] HEADERs =
            {
                    "Compañia",
                    "Fecha Pago (ERP)",
                    "Usuario Solicitante",
                    "Documento Original",
                    "Folio de Pago de ERP",
                    "Folio de Factura en el ERP",
                    "Status",
                    "Serie Folio",
                    "UUID",
                    "Emisión Factura",
                    "RFC",
                    "Descripcion",
                    "Método de pago",
                    "Monto del pago(ERP)",
                    "Moneda",
                    "Tipo de cambio CFDI",
                    "SubTotal",
                    "Descuento",
                    "IVA",
                    "Total"
            };

    static String SHEET = "ComplementF";

    public static ByteArrayInputStream complementFToExcel(Page<ComplementFModel> complementFModels) {
        try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
            Sheet sheet = workbook.createSheet(SHEET);
            // Header
            Row headerRow = sheet.createRow(0);
            for (int col = 0; col < HEADERs.length; col++) {
                Cell cell = headerRow.createCell(col);
                cell.setCellValue(HEADERs[col]);
            }
            int rowIdx = 1;
            for (ComplementFModel complementFModel : complementFModels) {
                Row row = sheet.createRow(rowIdx++);
                row.createCell(0).setCellValue(complementFModel.getCompany());
                row.createCell(1).setCellValue(complementFModel.getTransdate());
                row.createCell(2).setCellValue(complementFModel.getOriginaldocument());
                row.createCell(3).setCellValue(complementFModel.getPayment());
                row.createCell(4).setCellValue(complementFModel.getInvoice());
                row.createCell(5).setCellValue(complementFModel.getStatus());
                row.createCell(6).setCellValue(complementFModel.getFolio());
                row.createCell(7).setCellValue(complementFModel.getUuid_invoice());
                row.createCell(8).setCellValue(complementFModel.getCfdidatetime());
                row.createCell(9).setCellValue(complementFModel.getIssuer_rfc());
                row.createCell(10).setCellValue(complementFModel.getDesc_vend());
                row.createCell(11).setCellValue(complementFModel.getPaymentmethod());
                row.createCell(12).setCellValue(complementFModel.getAmountm());
                row.createCell(13).setCellValue(complementFModel.getExchrateinvoice());
                row.createCell(14).setCellValue(complementFModel.getSubtotal());
                row.createCell(15).setCellValue(complementFModel.getDiscount_total_amount());
                row.createCell(16).setCellValue(complementFModel.getTaxes_invoice());
                row.createCell(17).setCellValue(complementFModel.getTotal());
            }
            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
        }
    }
}
