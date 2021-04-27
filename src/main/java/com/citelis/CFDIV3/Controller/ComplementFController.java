package com.citelis.CFDIV3.Controller;

import com.citelis.CFDIV3.Services.ComplementFServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;


@RestController
public class ComplementFController {


    @Autowired
    ComplementFServices complementFServices;

    @GetMapping("/ComplementF")
    public ResponseEntity getAllGroupComplementH(
            @RequestParam(name = "companygroup", required = false) String companygroup,
            @RequestParam(name = "company", required = false) String company,
            @RequestParam(name = "cfditype", required = false) String cfditype,
            @RequestParam(name = "paymentmethod", required = false) String paymentmethod,
            @RequestParam(name = "cfdidatetimestart", required = false) Timestamp datestart,
            @RequestParam(name = "cfdidatetimeend", required = false) Timestamp dateend,
            @RequestParam(name = "pageNo") Integer pageNo,
            @RequestParam(name = "pageSize") Integer pageSize){

        if (company == null && cfditype == null && paymentmethod == null && datestart == null && dateend == null){
            return ResponseEntity.ok(complementFServices.getAllCompanyGroup(companygroup, pageNo,pageSize));
        }
        else if (company != null && cfditype == null && paymentmethod == null && datestart == null && dateend == null){
            return ResponseEntity.ok(complementFServices.getAllCompanyGroupCompany(companygroup, company,pageNo,pageSize));
        }
        else if (company == null && cfditype != null && paymentmethod == null && datestart == null && dateend == null){
            return ResponseEntity.ok(complementFServices.getAllCompanyGroupCompanyCfdiDateCfditype(companygroup,cfditype,pageNo,pageSize));
        }
        else if(company != null && cfditype != null && paymentmethod == null && datestart == null && dateend == null){
            return ResponseEntity.ok(complementFServices.getAllCompanyGroupCompanyCompanyCfdiType (companygroup,company,cfditype,pageNo,pageSize));
        }
        else if (company == null && cfditype == null && paymentmethod != null && datestart == null && dateend == null){
            return ResponseEntity.ok(complementFServices.getAllCompanygroupAndPaymentmethod(companygroup,paymentmethod,pageNo,pageSize));
        }
        else if (company != null && cfditype == null && paymentmethod != null && datestart == null && dateend == null){
            return ResponseEntity.ok(complementFServices.getAllCompanygroupAndCompanyAndPaymentmethod(companygroup,company,paymentmethod,pageNo,pageSize));
        }
        else if (company == null && cfditype != null && paymentmethod != null && datestart == null && dateend == null){
            return ResponseEntity.ok(complementFServices.getAllCompanygroupAndCfditypeAndPaymentmethod(companygroup,cfditype,paymentmethod,pageNo,pageSize));
        }
        else if (company != null && cfditype != null && paymentmethod != null && datestart == null && dateend == null){
            return ResponseEntity.ok(complementFServices.getAllCompanyGroupCompanyCfditypePaymentmethod(companygroup,company,cfditype,paymentmethod,pageNo,pageSize));
        }
        else if (datestart != null && dateend != null){
            if(company == null && cfditype == null && paymentmethod == null){
                return ResponseEntity.ok(complementFServices.getAllCompanyGroupCompanyCfdiDate(companygroup,datestart,dateend,pageNo,pageSize));
            }
            if(company != null && cfditype == null && paymentmethod == null){
                return ResponseEntity.ok(complementFServices.getAllCompanyGroupCompanyCompanyCfdiDate(companygroup,company,datestart,dateend,pageNo,pageSize));
            }
            if(company == null && cfditype != null && paymentmethod == null){
                return ResponseEntity.ok(complementFServices.getAllCompanyGroupCompanyCfdiDateCfditype (companygroup,cfditype,datestart,dateend,pageNo,pageSize));
            }
            if(company == null && cfditype == null && paymentmethod != null){
                return ResponseEntity.ok(complementFServices.getAllCompanyGroupCompanyCfdiDatePaymentmethod(companygroup,paymentmethod,datestart,dateend,pageNo,pageSize));
            }
            if(company != null && cfditype == null && paymentmethod != null){
                return ResponseEntity.ok(complementFServices.getAllCompanyGroupCompanyCompanyCfdiDatePaymentmethod (companygroup,company,paymentmethod,datestart,dateend,pageNo,pageSize));
            }
            if(company == null && cfditype != null && paymentmethod != null){
                return ResponseEntity.ok(complementFServices.getAllCompanygroupAndCfditypeAndPaymentmethod(companygroup,cfditype,paymentmethod,pageNo,pageSize));
            }

            return ResponseEntity.ok(complementFServices.getAllComplement(companygroup, company,cfditype,paymentmethod,datestart,dateend,pageNo,pageSize));

        }
        else return  null;
    }
}
