package com.citelis.CFDIV3.Controller;

import com.citelis.CFDIV3.Services.RecipServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;


@RestController
public class RecipController {
    @Autowired
    RecipServices recipServices;

    @GetMapping("/Recip")
    public ResponseEntity getAllCompanyGroupRecip(
            @RequestParam(name = "companygroup", required = false) String companygroup,
            @RequestParam(name = "company", required = false) String company,
            @RequestParam(name = "cfditype", required = false) String cfditype,
            @RequestParam(name = "cfdidatetimestart", required = false) Timestamp datestart,
            @RequestParam(name = "cfdidatetimeend", required = false) Timestamp dateend,
            @RequestParam(name = "pageNo") Integer pageNo,
            @RequestParam(name = "pageSize") Integer pageSize){

        if (company == null && cfditype == null && datestart == null && dateend == null){
            return ResponseEntity.ok(recipServices.getAllCompanyGroup(companygroup, pageNo,pageSize));
        }
        else if (company != null && cfditype == null && datestart == null && dateend == null){
            return ResponseEntity.ok(recipServices.getAllCompanyGroupCompany(companygroup, company,pageNo,pageSize));
        }
        else if (company == null && cfditype != null && datestart == null && dateend == null){
            return ResponseEntity.ok(recipServices.getAllCompanyGroupCompanyCfdiDateCfditype(companygroup,cfditype,pageNo,pageSize));
        }
        else if(company != null && cfditype != null  && datestart == null && dateend == null){
            return ResponseEntity.ok(recipServices.getAllCompanyGroupCompanyCompanyCfdiType (companygroup,company,cfditype,pageNo,pageSize));
        }
        else if (datestart != null && dateend != null){
            if(company == null && cfditype == null){
                return ResponseEntity.ok(recipServices.getAllCompanyGroupCompanyCfdiDate(companygroup,datestart,dateend,pageNo,pageSize));
            }
            if(company == null && cfditype != null){
                return ResponseEntity.ok(recipServices.getAllCompanyGroupCompanyCfdiDateCfditype (companygroup,cfditype,datestart,dateend,pageNo,pageSize));
            }
            if(company != null && cfditype == null){
                return ResponseEntity.ok(recipServices.getAllCompanyGroupCompanyCompanyCfdiDate (companygroup,company,datestart,dateend,pageNo,pageSize));
            }
            return ResponseEntity.ok(recipServices.getAllRecip(companygroup, company,cfditype,datestart,dateend,pageNo,pageSize));
        }
        else return  null;
    }
}
