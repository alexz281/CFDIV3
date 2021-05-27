package com.citelis.CFDIV3.Utils;

import com.citelis.CFDIV3.Model.ComplementFCModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.data.domain.Page;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ComplementFCExcelExporter {
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

    public static ByteArrayInputStream complementFCToExcel(Page<ComplementFCModel> complementFCModels) {
        try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
            Sheet sheet = workbook.createSheet(SHEET);
            // Header
            Row headerRow = sheet.createRow(0);
            for (int col = 0; col < HEADERs.length; col++) {
                Cell cell = headerRow.createCell(col);
                cell.setCellValue(HEADERs[col]);
            }
            int rowIdx = 1;
            for (ComplementFCModel complementFCModel : complementFCModels) {
                Row row = sheet.createRow(rowIdx++);
                row.createCell(0).setCellValue(complementFCModel.getCompany());
                row.createCell(1).setCellValue(complementFCModel.getTransdate());
                row.createCell(2).setCellValue(complementFCModel.getOriginaldocument());
                row.createCell(3).setCellValue(complementFCModel.getPayment());
                row.createCell(4).setCellValue(complementFCModel.getInvoice());
                row.createCell(5).setCellValue(complementFCModel.getStatus());
                row.createCell(6).setCellValue(complementFCModel.getFolio());
                row.createCell(7).setCellValue(complementFCModel.getUuid_invoice());
                row.createCell(8).setCellValue(complementFCModel.getCfdidatetime());
                row.createCell(9).setCellValue(complementFCModel.getIssuer_rfc());
                row.createCell(10).setCellValue(complementFCModel.getDesc_vend());
                row.createCell(11).setCellValue(complementFCModel.getPaymentmethod());
                row.createCell(12).setCellValue(complementFCModel.getAmountm());
                row.createCell(13).setCellValue(complementFCModel.getExchrateinvoice());
                row.createCell(14).setCellValue(complementFCModel.getSubtotal());
                row.createCell(15).setCellValue(complementFCModel.getDiscount_total_amount());
                row.createCell(16).setCellValue(complementFCModel.getTaxes_invoice());
                row.createCell(17).setCellValue(complementFCModel.getTotal());
            }
            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
        }
    }
}
