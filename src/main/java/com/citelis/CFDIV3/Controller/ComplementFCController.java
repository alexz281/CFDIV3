package com.citelis.CFDIV3.Controller;

import com.citelis.CFDIV3.Services.ComplementFCServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;


@RestController
public class ComplementFCController {


    @Autowired
    ComplementFCServices complementFCServices;

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

        if (company == null && cfditype == null && paymentmethod == null && datestart == null && dateend == null){
            return ResponseEntity.ok(complementFCServices.getAllCompanyGroup(companygroup, pageNo,pageSize));
        }
        else if (company != null && cfditype == null && paymentmethod == null && datestart == null && dateend == null){
            return ResponseEntity.ok(complementFCServices.getAllCompanyGroupCompany(companygroup, company,pageNo,pageSize));
        }
        else if (company == null && cfditype != null && paymentmethod == null && datestart == null && dateend == null){
            return ResponseEntity.ok(complementFCServices.getAllCompanyGroupCompanyCfdiDateCfditype(companygroup,cfditype,pageNo,pageSize));
        }
        else if(company != null && cfditype != null && paymentmethod == null && datestart == null && dateend == null){
            return ResponseEntity.ok(complementFCServices.getAllCompanyGroupCompanyCompanyCfdiType (companygroup,company,cfditype,pageNo,pageSize));
        }
        else if (company == null && cfditype == null && paymentmethod != null && datestart == null && dateend == null){
            return ResponseEntity.ok(complementFCServices.getAllCompanygroupAndPaymentmethod(companygroup,paymentmethod,pageNo,pageSize));
        }
        else if (company != null && cfditype == null && paymentmethod != null && datestart == null && dateend == null){
            return ResponseEntity.ok(complementFCServices.getAllCompanygroupAndCompanyAndPaymentmethod(companygroup,company,paymentmethod,pageNo,pageSize));
        }
        else if (company == null && cfditype != null && paymentmethod != null && datestart == null && dateend == null){
            return ResponseEntity.ok(complementFCServices.getAllCompanygroupAndCfditypeAndPaymentmethod(companygroup,cfditype,paymentmethod,pageNo,pageSize));
        }
        else if (company != null && cfditype != null && paymentmethod != null && datestart == null && dateend == null){
            return ResponseEntity.ok(complementFCServices.getAllCompanyGroupCompanyCfditypePaymentmethod(companygroup,company,cfditype,paymentmethod,pageNo,pageSize));
        }
        else if (datestart != null && dateend != null){
            if(company == null && cfditype == null && paymentmethod == null){
                return ResponseEntity.ok(complementFCServices.getAllCompanyGroupCompanyCfdiDate(companygroup,datestart,dateend,pageNo,pageSize));
            }
            if(company != null && cfditype == null && paymentmethod == null){
                return ResponseEntity.ok(complementFCServices.getAllCompanyGroupCompanyCompanyCfdiDate(companygroup,company,datestart,dateend,pageNo,pageSize));
            }
            if(company == null && cfditype != null && paymentmethod == null){
                return ResponseEntity.ok(complementFCServices.getAllCompanyGroupCompanyCfdiDateCfditype (companygroup,cfditype,datestart,dateend,pageNo,pageSize));
            }
            if(company == null && cfditype == null && paymentmethod != null){
                return ResponseEntity.ok(complementFCServices.getAllCompanyGroupCompanyCfdiDatePaymentmethod(companygroup,paymentmethod,datestart,dateend,pageNo,pageSize));
            }
            if(company != null && cfditype == null && paymentmethod != null){
                return ResponseEntity.ok(complementFCServices.getAllCompanyGroupCompanyCompanyCfdiDatePaymentmethod (companygroup,company,paymentmethod,datestart,dateend,pageNo,pageSize));
            }
            if(company == null && cfditype != null && paymentmethod != null){
                return ResponseEntity.ok(complementFCServices.getAllCompanygroupAndCfditypeAndPaymentmethod(companygroup,cfditype,paymentmethod,pageNo,pageSize));
            }

            return ResponseEntity.ok(complementFCServices.getAllComplement(companygroup, company,cfditype,paymentmethod,datestart,dateend,pageNo,pageSize));

        }
        else return  null;
    }
}
