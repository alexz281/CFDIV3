package com.citelis.CFDIV3.Services;

import com.citelis.CFDIV3.Model.IssuedModel;
import com.citelis.CFDIV3.Repository.IIssuesRepository;
import com.citelis.CFDIV3.Resource.IssuedResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class IssuedServices {
    @Autowired
    IIssuesRepository iIssuesRepository;

    public Page<IssuedResource> getAllIssued(String company_group, String id, String cfditype, Timestamp datestart, Timestamp dateend, Integer pageNo, Integer pageSize)
    {
        Page<IssuedModel> issuedModel;
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        List<IssuedModel> issuedResourceslist = this.getAllIssuedList(company_group,id,cfditype,datestart,dateend,pageable);
        issuedModel = iIssuesRepository.findByCompanygroupAndCompanyAndCfditypeAndCfdidatetimeBetween(company_group,id,cfditype,datestart,dateend,pageable);
        return new PageImpl(issuedResourceslist, pageable, issuedModel.getTotalElements());
    }

    public Page<IssuedResource> getAllCompanyGroup(String company_group, Integer pageNo, Integer pageSize)
    {
        Page<IssuedModel> issuedModel;
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        List<IssuedModel> issuedResourceslist = this.getAllListGroupCompany(company_group,pageable);
        issuedModel = iIssuesRepository.findAll(pageable);
        return new PageImpl(issuedResourceslist, pageable, issuedModel.getTotalElements());
    }

    public Page<IssuedResource> getAllCompanyGroupCompany(String company_group, String id, Integer pageNo, Integer pageSize)
    {
        Page<IssuedModel> issuedModel;
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        List<IssuedModel> issuedResourceslist = this.getAllListGroupCompanyCompany(company_group,id,pageable);
        issuedModel = iIssuesRepository.findByCompanygroupAndCompany(company_group,id,pageable);
        return new PageImpl(issuedResourceslist, pageable, issuedModel.getTotalElements());
    }

    //

    public Page<IssuedResource> getAllCompanyGroupCompanyCfdiDate(String company_group, Timestamp datestart,Timestamp dateend, Integer pageNo, Integer pageSize)
    {
        Page<IssuedModel> issuedModel;
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        List<IssuedModel> issuedResourceslist = this.getAllCompanyGroupCompanyCfdiDate(company_group,datestart,dateend,pageable);
        issuedModel = iIssuesRepository.findByCompanygroupAndCfdidatetimeBetween(company_group,datestart,dateend,pageable);
        return new PageImpl(issuedResourceslist, pageable, issuedModel.getTotalElements());
    }

    public Page<IssuedResource> getAllCompanyGroupCompanyCfdiDateCfditype(String company_group,String cfditype, Integer pageNo, Integer pageSize)
    {
        Page<IssuedModel> issuedModel;
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        List<IssuedModel> issuedResourceslist = this.getAllListGroupCompanyCompanyCfdiDateCfditype(company_group,cfditype,pageable);
        issuedModel = iIssuesRepository.findByCompanygroupAndCfditype(company_group,cfditype,pageable);
        return new PageImpl(issuedResourceslist, pageable, issuedModel.getTotalElements());
    }

    public Page<IssuedResource> getAllCompanyGroupCompanyCfdiDateCfditype(String company_group,String cfditype, Timestamp datestart,Timestamp dateend, Integer pageNo, Integer pageSize)
    {
        Page<IssuedModel> issuedModel;
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        List<IssuedModel> issuedResourceslist = this.getAllListGroupCompanyCompanyCfdiDateCfditype(company_group,cfditype,datestart,dateend,pageable);
        issuedModel = iIssuesRepository.findByCompanygroupAndCfditypeAndCfdidatetimeBetween(company_group,cfditype,datestart,dateend,pageable);
        return new PageImpl(issuedResourceslist, pageable, issuedModel.getTotalElements());
    }

    public Page<IssuedResource> getAllCompanyGroupCompanyCompanyCfdiDate(String company_group,String company, Timestamp datestart,Timestamp dateend, Integer pageNo, Integer pageSize)
    {
        Page<IssuedModel> issuedModel;
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        List<IssuedModel> issuedResourceslist = this.getAllListGroupCompanyCompanyCfdiDateCompany(company_group,company,datestart,dateend,pageable);
        issuedModel = iIssuesRepository.findByCompanygroupAndCompanyAndCfdidatetimeBetween(company_group,company,datestart,dateend,pageable);
        return new PageImpl(issuedResourceslist, pageable, issuedModel.getTotalElements());
    }

    public Page<IssuedResource> getAllCompanyGroupCompanyCompanyCfdiType(String company_group,String company, String cfditype, Integer pageNo, Integer pageSize)
    {
        Page<IssuedModel> issuedModel;
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        List<IssuedModel> issuedResourceslist = this.getAllListGroupCompanyCompanyTypeCfdi(company_group,company,cfditype,pageable);
        issuedModel = iIssuesRepository.findByCompanygroupAndCompanyAndCfditype(company_group,company,cfditype,pageable);
        return new PageImpl(issuedResourceslist, pageable, issuedModel.getTotalElements());
    }



    //Lista

    private List<IssuedModel> getAllIssuedList(String company_group, String id, String cfditype,  Timestamp datestart,Timestamp dateend, Pageable pageable) {

        Page<IssuedModel> pagedResult = iIssuesRepository.findByCompanygroupAndCompanyAndCfditypeAndCfdidatetimeBetween(company_group,id,cfditype,datestart,dateend,pageable);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<IssuedModel>();
        }
    }

    private List<IssuedModel> getAllListGroupCompany(String company_group,Pageable pageable) {

        Page<IssuedModel> pagedResult = iIssuesRepository.findByCompanygroup(company_group, pageable);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<IssuedModel>();
        }
    }

    private List<IssuedModel> getAllListGroupCompanyCompany(String company_group, String id, Pageable pageable) {

        Page<IssuedModel> pagedResult = iIssuesRepository.findByCompanygroupAndCompany(company_group,id,pageable);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<IssuedModel>();
        }
    }

    private List<IssuedModel> getAllCompanyGroupCompanyCfdiDate(String company_group, Timestamp datestart,Timestamp dateend, Pageable pageable) {

        Page<IssuedModel> pagedResult = iIssuesRepository.findByCompanygroupAndCfdidatetimeBetween(company_group,datestart,dateend,pageable);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<IssuedModel>();
        }
    }

    private List<IssuedModel> getAllListGroupCompanyCompanyCfdiDateCfditype(String company_group, String cfditype, Pageable pageable) {

        Page<IssuedModel> pagedResult = iIssuesRepository.findByCompanygroupAndCfditype(company_group,cfditype,pageable);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<IssuedModel>();
        }
    }

    private List<IssuedModel> getAllListGroupCompanyCompanyCfdiDateCfditype(String company_group, String cfditype, Timestamp datestart,Timestamp dateend, Pageable pageable) {

        Page<IssuedModel> pagedResult = iIssuesRepository.findByCompanygroupAndCfditypeAndCfdidatetimeBetween(company_group,cfditype,datestart,dateend,pageable);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<IssuedModel>();
        }
    }

    private List<IssuedModel> getAllListGroupCompanyCompanyCfdiDateCompany(String company_group, String company, Timestamp datestart,Timestamp dateend, Pageable pageable) {

        Page<IssuedModel> pagedResult = iIssuesRepository.findByCompanygroupAndCompanyAndCfdidatetimeBetween(company_group,company,datestart,dateend,pageable);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<IssuedModel>();
        }
    }

    private List<IssuedModel> getAllListGroupCompanyCompanyTypeCfdi(String company_group, String company, String cfditype, Pageable pageable) {

        Page<IssuedModel> pagedResult = iIssuesRepository.findByCompanygroupAndCompanyAndCfditype(company_group,company,cfditype,pageable);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<IssuedModel>();
        }
    }
}
