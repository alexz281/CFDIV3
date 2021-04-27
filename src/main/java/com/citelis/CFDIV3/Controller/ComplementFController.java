package com.citelis.CFDIV3.Controller;

import com.citelis.CFDIV3.Services.ComplementFServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;

@RequiredArgsConstructor
@RestController
public class ComplementFController {


    final private ComplementFServices complementFServices;

    @GetMapping("/ComplementF")
    public ResponseEntity getAllGroupComplementH(
            @RequestParam(name = "companygroup", required = false) String companygroup,
            @RequestParam(name = "company", required = false) String company,
            @RequestParam(name = "cfditype", required = false) String cfditype,
            @RequestParam(name = "paymentmethod", required = false) String paymentmethod,
            @RequestParam(name = "cfdidatetimestart", required = false) Timestamp datestart,
            @RequestParam(name = "cfdidatetimeend", required = false) Timestamp dateend,
            @RequestParam(name = "pageNo") Integer pageNo,
            @RequestParam(name = "pageSize") Integer pageSize) {
        return ResponseEntity.ok(complementFServices.getAllComplement(companygroup, company, cfditype, paymentmethod, datestart, dateend, pageNo, pageSize));
    }
}
