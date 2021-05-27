package com.citelis.CFDIV3.Utils;

import com.citelis.CFDIV3.Model.RecipModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.data.domain.Page;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class RecipExcelExporter {
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
                    "Descripción Receptor",
                    "Emisor",
                    "Descripción Emisor",
                    "Descripción",
                    "Método de Pago",
                    "Forma de Pago",
                    "CFDI de Referencia",
                    //"Encontrados de el DAX",
                    "SubTotal",
                    "Descuento",
                    "IEPS",
                    "IVA",
                    "IVA Retenido",
                    "ISR Retenido",
                    "Impuesto Local",
                    "Retención Local",
                    "Total"

            };

    static String SHEET = "Issued";

    public static ByteArrayInputStream recipToExcel(Page<RecipModel> recipModels) {
        try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
            Sheet sheet = workbook.createSheet(SHEET);
            // Header
            Row headerRow = sheet.createRow(0);
            for (int col = 0; col < HEADERs.length; col++) {
                Cell cell = headerRow.createCell(col);
                cell.setCellValue(HEADERs[col]);
            }
            int rowIdx = 1;
            for (RecipModel recipModel : recipModels) {
                Row row = sheet.createRow(rowIdx++);
                row.createCell(0).setCellValue(recipModel.getStatus());
                row.createCell(1).setCellValue(recipModel.getCancellation_datetime().toString());
                row.createCell(2).setCellValue(recipModel.getVersion());
                row.createCell(3).setCellValue(recipModel.getCfditype());
                row.createCell(4).setCellValue(recipModel.getSeries());
                row.createCell(5).setCellValue(recipModel.getFolio());
                row.createCell(6).setCellValue(recipModel.getUuid());
                row.createCell(7).setCellValue(recipModel.getCfdidatetime());
                row.createCell(8).setCellValue(recipModel.getReceiver_rfc());
                row.createCell(9).setCellValue(recipModel.getReceiver_name());
                row.createCell(10).setCellValue(recipModel.getIssuer_rfc());
                row.createCell(11).setCellValue(recipModel.getIssuer_name());
                row.createCell(12).setCellValue(recipModel.getDescripcion());
                row.createCell(13).setCellValue(recipModel.getPayment_method());
                row.createCell(14).setCellValue(recipModel.getPayment_mode());
                row.createCell(15).setCellValue(recipModel.getReferenced_cfdi_uuid());
                row.createCell(16).setCellValue(recipModel.getSubtotal());
                row.createCell(17).setCellValue(recipModel.getDiscount_total_amount());
                row.createCell(18).setCellValue(recipModel.getIeps());
                row.createCell(19).setCellValue(recipModel.getIva());
                row.createCell(20).setCellValue(recipModel.getIva_retenido());
                row.createCell(21).setCellValue(recipModel.getIsr_retenido());
                row.createCell(22).setCellValue(recipModel.getIva_local());
                row.createCell(23).setCellValue(recipModel.getIsr_local());
                row.createCell(24).setCellValue(recipModel.getTotal());
            }
            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
        }
    }
}
