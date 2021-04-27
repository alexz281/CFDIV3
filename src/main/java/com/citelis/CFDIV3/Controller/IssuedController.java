package com.citelis.CFDIV3.Controller;

import com.citelis.CFDIV3.Services.IssuedServices;
import com.citelis.CFDIV3.Services.V2.IssuedServicesV2;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;

@RequiredArgsConstructor
@RestController
public class IssuedController {


    private final IssuedServices issuedServices;
    private final IssuedServicesV2 issuedServicesv2;

    @GetMapping("/Issued/v2")
    public ResponseEntity getAllCompanyGroupV2(@RequestParam(name = "companygroup", required = false) String companygroup,
                                             @RequestParam(name = "company", required = false) String company,
                                               @RequestParam(name = "pageNo") Integer pageNo,
                                               @RequestParam(name = "pageSize") Integer pageSize){
        return ResponseEntity.ok(issuedServicesv2.getAllIssued(companygroup,company,null,null,null,pageNo,pageSize));

    }
    @GetMapping("/Issued")
    public ResponseEntity getAllCompanyGroup(
            @RequestParam(name = "companygroup", required = false) String companygroup,
            @RequestParam(name = "company", required = false) String company,
            @RequestParam(name = "cfditype", required = false) String cfditype,
            @RequestParam(name = "cfdidatetimestart", required = false) Timestamp datestart,
            @RequestParam(name = "cfdidatetimeend", required = false) Timestamp dateend,
            @RequestParam(name = "pageNo") Integer pageNo,
            @RequestParam(name = "pageSize") Integer pageSize){

        if (company == null && cfditype == null && datestart == null && dateend == null){
            return ResponseEntity.ok(issuedServices.getAllCompanyGroup(companygroup, pageNo,pageSize));
        }
        else if (company != null && cfditype == null && datestart == null && dateend == null){
            return ResponseEntity.ok(issuedServices.getAllCompanyGroupCompany(companygroup, company,pageNo,pageSize));
        }
        else if (company == null && cfditype != null && datestart == null && dateend == null){
            return ResponseEntity.ok(issuedServices.getAllCompanyGroupCompanyCfdiDateCfditype(companygroup,cfditype,pageNo,pageSize));
        }
        else if(company != null && cfditype != null  && datestart == null && dateend == null){
            return ResponseEntity.ok(issuedServices.getAllCompanyGroupCompanyCompanyCfdiType (companygroup,company,cfditype,pageNo,pageSize));
        }
        else if (datestart != null && dateend != null){
            if(company == null && cfditype == null){
                return ResponseEntity.ok(issuedServices.getAllCompanyGroupCompanyCfdiDate(companygroup,datestart,dateend,pageNo,pageSize));
            }
            if(company == null && cfditype != null){
                return ResponseEntity.ok(issuedServices.getAllCompanyGroupCompanyCfdiDateCfditype (companygroup,cfditype,datestart,dateend,pageNo,pageSize));
            }
            if(company != null && cfditype == null){
                return ResponseEntity.ok(issuedServices.getAllCompanyGroupCompanyCompanyCfdiDate (companygroup,company,datestart,dateend,pageNo,pageSize));
            }
            return ResponseEntity.ok(issuedServices.getAllIssued(companygroup, company,cfditype,datestart,dateend,pageNo,pageSize));
        }
        else return  null;
    }
}
