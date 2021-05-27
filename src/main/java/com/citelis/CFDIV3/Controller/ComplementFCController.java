package com.citelis.CFDIV3.Controller;

import com.citelis.CFDIV3.Services.ComplementFCServices;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@RequiredArgsConstructor
@RestController
public class ComplementFCController {



    private final ComplementFCServices complementFCServices;

    @GetMapping("/ComplementFC")
    public ResponseEntity getAllGroupComplementFC(
            @RequestParam(name = "companygroup", required = false) String companygroup,
            @RequestParam(name = "company", required = false) String company,
            @RequestParam(name = "cfditype", required = false) String cfditype,
            @RequestParam(name = "paymentmethod", required = false) String paymentmethod,
            @RequestParam(name = "cfdidatetimestart", required = false) Timestamp datestart,
            @RequestParam(name = "cfdidatetimeend", required = false) Timestamp dateend,
            @RequestParam(name = "pageNo") Integer pageNo,
            @RequestParam(name = "pageSize") Integer pageSize){

        return ResponseEntity.ok(complementFCServices.getAllComplement(companygroup, company, cfditype, paymentmethod, datestart, dateend, pageNo, pageSize));
    }

    @GetMapping("/ComplementFC/export/excel")
    public ResponseEntity exportToExcel(@RequestParam(name = "companygroup", required = false) String companygroup,
                                        @RequestParam(name = "company", required = false) String company,
                                        @RequestParam(name = "cfditype", required = false) String cfditype,
                                        @RequestParam(name = "paymentmethod", required = false) String paymentmethod,
                                        @RequestParam(name = "cfdidatetimestart", required = false) Timestamp datestart,
                                        @RequestParam(name = "cfdidatetimeend", required = false) Timestamp dateend){
        InputStreamResource file = new InputStreamResource(complementFCServices.load(companygroup, company, cfditype,paymentmethod, datestart, dateend));
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
        String headerValue = "attachment; filename=ComplementFC_" + currentDateTime + ".xlsx";
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,headerValue)
                .contentType(MediaType.parseMediaType("application/vnd.ms-excel")).body(file);
    }
}
