package com.citelis.CFDIV3.Services;

import com.citelis.CFDIV3.Model.RecipModel;
import com.citelis.CFDIV3.Repository.IRecipRepository;
import com.citelis.CFDIV3.Resource.RecipResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class RecipServices {
    @Autowired
    IRecipRepository iRecipRepository;

    public Page<RecipResource> getAllRecip(String company_group, String id, String cfditype, Timestamp datestart, Timestamp dateend, Integer pageNo, Integer pageSize)
    {
        Page<RecipModel> reciModel;
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        List<RecipModel> recipResourceslist = this.getAllIssuedList(company_group,id,cfditype,datestart,dateend,pageable);
        reciModel = iRecipRepository.findByCompanygroupAndCompanyAndCfditypeAndCfdidatetimeBetween(company_group,id,cfditype,datestart,dateend,pageable);
        return new PageImpl(recipResourceslist, pageable, reciModel.getTotalElements());
    }

    public Page<RecipResource> getAllCompanyGroup(String company_group, Integer pageNo, Integer pageSize)
    {
        Page<RecipModel> reciModel;
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        List<RecipModel> recipResourceslist = this.getAllListGroupCompany(company_group,pageable);
        reciModel = iRecipRepository.findAll(pageable);
        return new PageImpl(recipResourceslist, pageable, reciModel.getTotalElements());
    }

    public Page<RecipResource> getAllCompanyGroupCompany(String company_group, String id, Integer pageNo, Integer pageSize)
    {
        Page<RecipModel> reciModel;
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        List<RecipModel> recipResourceslist = this.getAllListGroupCompanyCompany(company_group,id,pageable);
        reciModel = iRecipRepository.findByCompanygroupAndCompany(company_group,id,pageable);
        return new PageImpl(recipResourceslist, pageable, reciModel.getTotalElements());
    }

    //

    public Page<RecipResource> getAllCompanyGroupCompanyCfdiDate(String company_group, Timestamp datestart,Timestamp dateend, Integer pageNo, Integer pageSize)
    {
        Page<RecipModel> reciModel;
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        List<RecipModel> recipResourceslist = this.getAllCompanyGroupCompanyCfdiDate(company_group,datestart,dateend,pageable);
        reciModel = iRecipRepository.findByCompanygroupAndCfdidatetimeBetween(company_group,datestart,dateend,pageable);
        return new PageImpl(recipResourceslist, pageable, reciModel.getTotalElements());
    }

    public Page<RecipResource> getAllCompanyGroupCompanyCfdiDateCfditype(String company_group,String cfditype, Integer pageNo, Integer pageSize)
    {
        Page<RecipModel> reciModel;
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        List<RecipModel> recipResourceslist = this.getAllListGroupCompanyCompanyCfdiDateCfditype(company_group,cfditype,pageable);
        reciModel = iRecipRepository.findByCompanygroupAndCfditype(company_group,cfditype,pageable);
        return new PageImpl(recipResourceslist, pageable, reciModel.getTotalElements());
    }

    public Page<RecipResource> getAllCompanyGroupCompanyCfdiDateCfditype(String company_group,String cfditype, Timestamp datestart,Timestamp dateend, Integer pageNo, Integer pageSize)
    {
        Page<RecipModel> reciModel;
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        List<RecipModel> recipResourceslist = this.getAllListGroupCompanyCompanyCfdiDateCfditype(company_group,cfditype,datestart,dateend,pageable);
        reciModel = iRecipRepository.findByCompanygroupAndCfditypeAndCfdidatetimeBetween(company_group,cfditype,datestart,dateend,pageable);
        return new PageImpl(recipResourceslist, pageable, reciModel.getTotalElements());
    }

    public Page<RecipResource> getAllCompanyGroupCompanyCompanyCfdiDate(String company_group,String company, Timestamp datestart,Timestamp dateend, Integer pageNo, Integer pageSize)
    {
        Page<RecipModel> reciModel;
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        List<RecipModel> recipResourceslist = this.getAllListGroupCompanyCompanyCfdiDateCompany(company_group,company,datestart,dateend,pageable);
        reciModel = iRecipRepository.findByCompanygroupAndCompanyAndCfdidatetimeBetween(company_group,company,datestart,dateend,pageable);
        return new PageImpl(recipResourceslist, pageable, reciModel.getTotalElements());
    }

    public Page<RecipResource> getAllCompanyGroupCompanyCompanyCfdiType(String company_group,String company, String cfditype, Integer pageNo, Integer pageSize)
    {
        Page<RecipModel> reciModel;
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        List<RecipModel> recipResourceslist = this.getAllListGroupCompanyCompanyTypeCfdi(company_group,company,cfditype,pageable);
        reciModel = iRecipRepository.findByCompanygroupAndCompanyAndCfditype(company_group,company,cfditype,pageable);
        return new PageImpl(recipResourceslist, pageable, reciModel.getTotalElements());
    }



    //Lista

    private List<RecipModel> getAllIssuedList(String company_group, String id, String cfditype,  Timestamp datestart,Timestamp dateend, Pageable pageable) {

        Page<RecipModel> pagedResult = iRecipRepository.findByCompanygroupAndCompanyAndCfditypeAndCfdidatetimeBetween(company_group,id,cfditype,datestart,dateend,pageable);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<RecipModel>();
        }
    }

    private List<RecipModel> getAllListGroupCompany(String company_group,Pageable pageable) {

        Page<RecipModel> pagedResult = iRecipRepository.findByCompanygroup(company_group, pageable);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<RecipModel>();
        }
    }

    private List<RecipModel> getAllListGroupCompanyCompany(String company_group, String id, Pageable pageable) {

        Page<RecipModel> pagedResult = iRecipRepository.findByCompanygroupAndCompany(company_group,id,pageable);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<RecipModel>();
        }
    }

    private List<RecipModel> getAllCompanyGroupCompanyCfdiDate(String company_group, Timestamp datestart,Timestamp dateend, Pageable pageable) {

        Page<RecipModel> pagedResult = iRecipRepository.findByCompanygroupAndCfdidatetimeBetween(company_group,datestart,dateend,pageable);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<RecipModel>();
        }
    }

    private List<RecipModel> getAllListGroupCompanyCompanyCfdiDateCfditype(String company_group, String cfditype, Pageable pageable) {

        Page<RecipModel> pagedResult = iRecipRepository.findByCompanygroupAndCfditype(company_group,cfditype,pageable);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<RecipModel>();
        }
    }

    private List<RecipModel> getAllListGroupCompanyCompanyCfdiDateCfditype(String company_group, String cfditype, Timestamp datestart,Timestamp dateend, Pageable pageable) {

        Page<RecipModel> pagedResult = iRecipRepository.findByCompanygroupAndCfditypeAndCfdidatetimeBetween(company_group,cfditype,datestart,dateend,pageable);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<RecipModel>();
        }
    }

    private List<RecipModel> getAllListGroupCompanyCompanyCfdiDateCompany(String company_group, String company, Timestamp datestart,Timestamp dateend, Pageable pageable) {

        Page<RecipModel> pagedResult = iRecipRepository.findByCompanygroupAndCompanyAndCfdidatetimeBetween(company_group,company,datestart,dateend,pageable);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<RecipModel>();
        }
    }

    private List<RecipModel> getAllListGroupCompanyCompanyTypeCfdi(String company_group, String company, String cfditype, Pageable pageable) {

        Page<RecipModel> pagedResult = iRecipRepository.findByCompanygroupAndCompanyAndCfditype(company_group,company,cfditype,pageable);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<RecipModel>();
        }
    }
}
