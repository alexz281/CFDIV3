package com.citelis.CFDIV3.Services;

import com.citelis.CFDIV3.Model.ComplementFModel;
import com.citelis.CFDIV3.Repository.IComplementFRepository;
import com.citelis.CFDIV3.Resource.ComplementHResource;
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
public class ComplementFServices {
    @Autowired
    IComplementFRepository iComplementFRepository;

    public Page<ComplementHResource> getAllComplement(String company_group, String id, String cfditype, String paymentmethod, Timestamp datestart, Timestamp dateend, Integer pageNo, Integer pageSize)
    {
        Page<ComplementFModel> complementHModel;
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        List<ComplementFModel> ComplementHResourceslist = this.getAllComplementList(company_group,id,cfditype,paymentmethod,datestart,dateend,pageable);
        complementHModel = iComplementFRepository.findByCompanygroupAndCompanyAndCfditypeAndPaymentmethodAndCfdidatetimeBetween(company_group,id,cfditype,paymentmethod,datestart,dateend,pageable);
        return new PageImpl(ComplementHResourceslist, pageable, complementHModel.getTotalElements());
    }

    public Page<ComplementHResource> getAllCompanyGroup(String company_group, Integer pageNo, Integer pageSize)
    {
        Page<ComplementFModel> complementHModel;
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        List<ComplementFModel> ComplementHResourceslist = this.getAllListGroupCompany(company_group,pageable);
        complementHModel = iComplementFRepository.findAll(pageable);
        return new PageImpl(ComplementHResourceslist, pageable, complementHModel.getTotalElements());
    }

    public Page<ComplementHResource> getAllCompanyGroupCompany(String company_group, String id, Integer pageNo, Integer pageSize)
    {
        Page<ComplementFModel> complementHModel;
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        List<ComplementFModel> ComplementHResourceslist = this.getAllListGroupCompanyCompany(company_group,id,pageable);
        complementHModel = iComplementFRepository.findByCompanygroupAndCompany(company_group,id,pageable);
        return new PageImpl(ComplementHResourceslist, pageable, complementHModel.getTotalElements());
    }

    //

    public Page<ComplementHResource> getAllCompanyGroupCompanyCfdiDate(String company_group, Timestamp datestart,Timestamp dateend, Integer pageNo, Integer pageSize)
    {
        Page<ComplementFModel> complementHModel;
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        List<ComplementFModel> ComplementHResourceslist = this.getAllCompanyGroupCompanyCfdiDate(company_group,datestart,dateend,pageable);
        complementHModel = iComplementFRepository.findByCompanygroupAndCfdidatetimeBetween(company_group,datestart,dateend,pageable);
        return new PageImpl(ComplementHResourceslist, pageable, complementHModel.getTotalElements());
    }

    public Page<ComplementHResource> getAllCompanyGroupCompanyCfdiDateCfditype(String company_group,String cfditype, Integer pageNo, Integer pageSize)
    {
        Page<ComplementFModel> complementHModel;
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        List<ComplementFModel> ComplementHResourceslist = this.getAllListGroupCompanyCompanyCfdiDateCfditype(company_group,cfditype,pageable);
        complementHModel = iComplementFRepository.findByCompanygroupAndCfditype(company_group,cfditype,pageable);
        return new PageImpl(ComplementHResourceslist, pageable, complementHModel.getTotalElements());
    }

    public Page<ComplementHResource> getAllCompanyGroupCompanyCfdiDateCfditype(String company_group,String cfditype, Timestamp datestart,Timestamp dateend, Integer pageNo, Integer pageSize)
    {
        Page<ComplementFModel> complementHModel;
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        List<ComplementFModel> ComplementHResourceslist = this.getAllListGroupCompanyCompanyCfdiDateCfditype(company_group,cfditype,datestart,dateend,pageable);
        complementHModel = iComplementFRepository.findByCompanygroupAndCfditypeAndCfdidatetimeBetween(company_group,cfditype,datestart,dateend,pageable);
        return new PageImpl(ComplementHResourceslist, pageable, complementHModel.getTotalElements());
    }

    public Page<ComplementHResource> getAllCompanyGroupCompanyCompanyCfdiDate(String company_group,String company, Timestamp datestart,Timestamp dateend, Integer pageNo, Integer pageSize)
    {
        Page<ComplementFModel> complementHModel;
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        List<ComplementFModel> ComplementHResourceslist = this.getAllListGroupCompanyCompanyCfdiDateCompany(company_group,company,datestart,dateend,pageable);
        complementHModel = iComplementFRepository.findByCompanygroupAndCompanyAndCfdidatetimeBetween(company_group,company,datestart,dateend,pageable);
        return new PageImpl(ComplementHResourceslist, pageable, complementHModel.getTotalElements());
    }

    public Page<ComplementHResource> getAllCompanyGroupCompanyCompanyCfdiType(String company_group,String company, String cfditype, Integer pageNo, Integer pageSize)
    {
        Page<ComplementFModel> complementHModel;
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        List<ComplementFModel> ComplementHResourceslist = this.getAllListGroupCompanyCompanyTypeCfdi(company_group,company,cfditype,pageable);
        complementHModel = iComplementFRepository.findByCompanygroupAndCompanyAndCfditype(company_group,company,cfditype,pageable);
        return new PageImpl(ComplementHResourceslist, pageable, complementHModel.getTotalElements());
    }

    public Page<ComplementHResource> getAllCompanygroupAndPaymentmethod(String companygroup, String paymentmethod, Integer pageNo, Integer pageSize) {
        Page<ComplementFModel> complementHModel;
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        List<ComplementFModel> ComplementHResourceslist = this.getAllListGroupCompanyPaymentmethod(companygroup,paymentmethod,pageable);
        complementHModel = iComplementFRepository.findByCompanygroupAndPaymentmethod(companygroup,paymentmethod,pageable);
        return new PageImpl(ComplementHResourceslist, pageable, complementHModel.getTotalElements());
    }

    public Page<ComplementHResource> getAllCompanygroupAndCompanyAndPaymentmethod(String companygroup, String company, String paymentmethod, Integer pageNo, Integer pageSize) {
        Page<ComplementFModel> complementHModel;
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        List<ComplementFModel> ComplementHResourceslist = this.getAllListGroupCompanyCompanyPaymentmethod(companygroup,company,paymentmethod,pageable);
        complementHModel = iComplementFRepository.findByCompanygroupAndPaymentmethod(companygroup,paymentmethod,pageable);
        return new PageImpl(ComplementHResourceslist, pageable, complementHModel.getTotalElements());
    }

    public Page<ComplementHResource> getAllCompanygroupAndCfditypeAndPaymentmethod(String companygroup, String cfditype, String paymentmethod, Integer pageNo, Integer pageSize) {
        Page<ComplementFModel> complementHModel;
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        List<ComplementFModel> ComplementHResourceslist = this.getAllListGroupCompanyCfditypePaymentmethod(companygroup,cfditype,paymentmethod,pageable);
        complementHModel = iComplementFRepository.findByCompanygroupAndCfditypeAndPaymentmethod(companygroup,cfditype,paymentmethod,pageable);
        return new PageImpl(ComplementHResourceslist, pageable, complementHModel.getTotalElements());
    }

    public Page<ComplementHResource> getAllCompanyGroupCompanyCfdiDatePaymentmethod(String company_group,String paymentmethod, Timestamp datestart,Timestamp dateend, Integer pageNo, Integer pageSize)
    {
        Page<ComplementFModel> complementHModel;
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        List<ComplementFModel> ComplementHResourceslist = this.getAllListGroupCompanyCfdiDatePaymentmethod(company_group,paymentmethod,datestart,dateend,pageable);
        complementHModel = iComplementFRepository.findByCompanygroupAndPaymentmethodAndCfdidatetimeBetween(company_group,paymentmethod,datestart,dateend,pageable);
        return new PageImpl(ComplementHResourceslist, pageable, complementHModel.getTotalElements());
    }

    public Page<ComplementHResource> getAllCompanyGroupCompanyCompanyCfdiDatePaymentmethod(String company_group,String company,String paymentmethod, Timestamp datestart,Timestamp dateend, Integer pageNo, Integer pageSize)
    {
        Page<ComplementFModel> complementHModel;
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        List<ComplementFModel> ComplementHResourceslist = this.getAllListGroupCompanyCompanyCfdiDatePaymentmethod(company_group,company,paymentmethod,datestart,dateend,pageable);
        complementHModel = iComplementFRepository.findByCompanygroupAndCompanyAndPaymentmethodAndCfdidatetimeBetween(company_group,company,paymentmethod,datestart,dateend,pageable);
        return new PageImpl(ComplementHResourceslist, pageable, complementHModel.getTotalElements());
    }


    public Page<ComplementHResource> getAllCompanyGroupCompanyCfditypePaymentmethod(String company_group,String company,String cfditype,String paymentmethod,Integer pageNo, Integer pageSize)
    {
        Page<ComplementFModel> complementHModel;
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        List<ComplementFModel> ComplementHResourceslist = this.getAllCompanygroupAndCompanyAndPaymentmethod(company_group,company,cfditype,paymentmethod,pageable);
        complementHModel = iComplementFRepository.findByCompanygroupAndCompanyAndCfditypeAndPaymentmethod(company_group,company,cfditype,paymentmethod,pageable);
        return new PageImpl(ComplementHResourceslist, pageable, complementHModel.getTotalElements());
    }


    //Lista

    private List<ComplementFModel> getAllComplementList(String company_group, String id, String cfditype, String paymentmethod, Timestamp datestart,Timestamp dateend, Pageable pageable) {

        Page<ComplementFModel> pagedResult = iComplementFRepository.findByCompanygroupAndCompanyAndCfditypeAndPaymentmethodAndCfdidatetimeBetween(company_group,id,cfditype,paymentmethod,datestart,dateend,pageable);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<ComplementFModel>();
        }
    }

    private List<ComplementFModel> getAllListGroupCompany(String company_group,Pageable pageable) {

        Page<ComplementFModel> pagedResult = iComplementFRepository.findByCompanygroup(company_group, pageable);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<ComplementFModel>();
        }
    }

    private List<ComplementFModel> getAllListGroupCompanyCompany(String company_group, String id, Pageable pageable) {

        Page<ComplementFModel> pagedResult = iComplementFRepository.findByCompanygroupAndCompany(company_group,id,pageable);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<ComplementFModel>();
        }
    }

    private List<ComplementFModel> getAllCompanyGroupCompanyCfdiDate(String company_group, Timestamp datestart,Timestamp dateend, Pageable pageable) {

        Page<ComplementFModel> pagedResult = iComplementFRepository.findByCompanygroupAndCfdidatetimeBetween(company_group,datestart,dateend,pageable);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<ComplementFModel>();
        }
    }

    private List<ComplementFModel> getAllListGroupCompanyCompanyCfdiDateCfditype(String company_group, String cfditype, Pageable pageable) {

        Page<ComplementFModel> pagedResult = iComplementFRepository.findByCompanygroupAndCfditype(company_group,cfditype,pageable);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<ComplementFModel>();
        }
    }

    private List<ComplementFModel> getAllListGroupCompanyCompanyCfdiDateCfditype(String company_group, String cfditype, Timestamp datestart,Timestamp dateend, Pageable pageable) {

        Page<ComplementFModel> pagedResult = iComplementFRepository.findByCompanygroupAndCfditypeAndCfdidatetimeBetween(company_group,cfditype,datestart,dateend,pageable);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<ComplementFModel>();
        }
    }


    private List<ComplementFModel> getAllListGroupCompanyCompanyCfdiDateCompany(String company_group, String company, Timestamp datestart,Timestamp dateend, Pageable pageable) {

        Page<ComplementFModel> pagedResult = iComplementFRepository.findByCompanygroupAndCompanyAndCfdidatetimeBetween(company_group,company,datestart,dateend,pageable);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<ComplementFModel>();
        }
    }

    private List<ComplementFModel> getAllListGroupCompanyCompanyTypeCfdi(String company_group, String company, String cfditype, Pageable pageable) {

        Page<ComplementFModel> pagedResult = iComplementFRepository.findByCompanygroupAndCompanyAndCfditype(company_group,company,cfditype,pageable);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<ComplementFModel>();
        }
    }

    private List<ComplementFModel> getAllListGroupCompanyPaymentmethod(String company_group, String paymentmethod, Pageable pageable) {

        Page<ComplementFModel> pagedResult = iComplementFRepository.findByCompanygroupAndPaymentmethod(company_group,paymentmethod,pageable);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<ComplementFModel>();
        }
    }

    private List<ComplementFModel> getAllListGroupCompanyCompanyPaymentmethod(String company_group, String company, String paymentmethod, Pageable pageable) {

        Page<ComplementFModel> pagedResult = iComplementFRepository.findByCompanygroupAndCompanyAndPaymentmethod(company_group,company,paymentmethod,pageable);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<ComplementFModel>();
        }
    }

    private List<ComplementFModel> getAllListGroupCompanyCfditypePaymentmethod(String company_group, String cfditype, String paymentmethod, Pageable pageable) {

        Page<ComplementFModel> pagedResult = iComplementFRepository.findByCompanygroupAndCfditypeAndPaymentmethod(company_group,cfditype,paymentmethod,pageable);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<ComplementFModel>();
        }
    }

    private List<ComplementFModel> getAllListGroupCompanyCfdiDatePaymentmethod(String company_group, String paymentmethod, Timestamp datestart,Timestamp dateend, Pageable pageable) {

        Page<ComplementFModel> pagedResult = iComplementFRepository.findByCompanygroupAndPaymentmethodAndCfdidatetimeBetween(company_group,paymentmethod,datestart,dateend,pageable);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<ComplementFModel>();
        }
    }

    private List<ComplementFModel> getAllListGroupCompanyCompanyCfdiDatePaymentmethod(String company_group, String company, String paymentmethod, Timestamp datestart, Timestamp dateend, Pageable pageable) {
        Page<ComplementFModel> pagedResult = iComplementFRepository.findByCompanygroupAndCompanyAndPaymentmethodAndCfdidatetimeBetween(company_group,company,paymentmethod,datestart,dateend,pageable);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<ComplementFModel>();
        }
    }

    private List<ComplementFModel> getAllListGroupCompanyCfditypeCfdiDatePaymentmethod(String company_group, String cfditype, String paymentmethod, Timestamp datestart, Timestamp dateend, Pageable pageable) {
        Page<ComplementFModel> pagedResult = iComplementFRepository.findByCompanygroupAndCfditypeAndPaymentmethodAndCfdidatetimeBetween(company_group,cfditype,paymentmethod,datestart,dateend,pageable);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<ComplementFModel>();
        }
    }

    public List<ComplementFModel> getAllCompanygroupAndCompanyAndPaymentmethod(String companygroup, String company, String cfditype, String paymentmethod, Pageable pageable) {
        Page<ComplementFModel> pagedResult = iComplementFRepository.findByCompanygroupAndCompanyAndCfditypeAndPaymentmethod(companygroup,company,cfditype,paymentmethod,pageable);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<ComplementFModel>();
        }
    }
}
