package com.citelis.CFDIV3.Services.V2;

import com.citelis.CFDIV3.Model.IssuedModel;
import com.citelis.CFDIV3.Model.QIssuedModel;
import com.citelis.CFDIV3.Repository.IIssuesRepository;
import com.citelis.CFDIV3.Resource.IssuedResource;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class IssuedServicesV2 {

    private final IIssuesRepository iIssuesRepository;

    public Page<IssuedResource> getAllIssued(String company_group, String id, String cfditype, Timestamp datestart, Timestamp dateend, Integer pageNo, Integer pageSize)
    {
        Page<IssuedModel> issuedModel;
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        BooleanBuilder builder = new BooleanBuilder();
        QIssuedModel qIssuedModel = QIssuedModel.issuedModel;

        if (!company_group.isEmpty()) {
          builder.and(qIssuedModel.companygroup.eq(company_group));
        }

        if (!id.isEmpty()) {
              builder.and(qIssuedModel.company.eq(id));
        }
        if(!cfditype.isEmpty()){
            builder.and(qIssuedModel.cfditype.eq(cfditype));
        }
        if(datestart != null && dateend != null){
            builder.and(qIssuedModel.cfdidatetime.between(datestart,dateend));
        }

        Page<IssuedModel> issuedResourceslist = iIssuesRepository.findAll(builder.getValue(), pageable);
//        List<IssuedModel> issuedResourceslist = this.getAllIssuedList(company_group,id,cfditype,datestart,dateend,pageable);
//        issuedModel = iIssuesRepository.findByCompanygroupAndCompanyAndCfditypeAndCfdidatetimeBetween(company_group,id,cfditype,datestart,dateend,pageable);
        return new PageImpl(issuedResourceslist.getContent(), pageable, issuedResourceslist.getTotalElements());
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
