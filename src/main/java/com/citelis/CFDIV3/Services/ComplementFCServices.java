package com.citelis.CFDIV3.Services;

import com.citelis.CFDIV3.Model.ComplementFCModel;
import com.citelis.CFDIV3.Repository.IComplementFCRepository;
import com.citelis.CFDIV3.Resource.ComplementFCResource;
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
public class ComplementFCServices {
    @Autowired
    IComplementFCRepository iComplementFCRepository;

    public Page<ComplementFCResource> getAllComplement(String company_group, String id, String cfditype, String paymentmethod, Timestamp datestart, Timestamp dateend, Integer pageNo, Integer pageSize)
    {
        Page<ComplementFCModel> complementHModel;
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        List<ComplementFCModel> complementFCResourceslist = this.getAllComplementList(company_group,id,cfditype,paymentmethod,datestart,dateend,pageable);
        complementHModel = iComplementFCRepository.findByCompanygroupAndCompanyAndCfditypeAndPaymentmethodAndCfdidatetimeBetween(company_group,id,cfditype,paymentmethod,datestart,dateend,pageable);
        return new PageImpl(complementFCResourceslist, pageable, complementHModel.getTotalElements());
    }

    public Page<ComplementFCResource> getAllCompanyGroup(String company_group, Integer pageNo, Integer pageSize)
    {
        Page<ComplementFCModel> complementHModel;
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        List<ComplementFCModel> complementFCResourceslist = this.getAllListGroupCompany(company_group,pageable);
        complementHModel = iComplementFCRepository.findAll(pageable);
        return new PageImpl(complementFCResourceslist, pageable, complementHModel.getTotalElements());
    }

    public Page<ComplementFCResource> getAllCompanyGroupCompany(String company_group, String id, Integer pageNo, Integer pageSize)
    {
        Page<ComplementFCModel> complementHModel;
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        List<ComplementFCModel> complementFCResourceslist = this.getAllListGroupCompanyCompany(company_group,id,pageable);
        complementHModel = iComplementFCRepository.findByCompanygroupAndCompany(company_group,id,pageable);
        return new PageImpl(complementFCResourceslist, pageable, complementHModel.getTotalElements());
    }

    //

    public Page<ComplementFCResource> getAllCompanyGroupCompanyCfdiDate(String company_group, Timestamp datestart,Timestamp dateend, Integer pageNo, Integer pageSize)
    {
        Page<ComplementFCModel> complementHModel;
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        List<ComplementFCModel> complementFCResourceslist = this.getAllCompanyGroupCompanyCfdiDate(company_group,datestart,dateend,pageable);
        complementHModel = iComplementFCRepository.findByCompanygroupAndCfdidatetimeBetween(company_group,datestart,dateend,pageable);
        return new PageImpl(complementFCResourceslist, pageable, complementHModel.getTotalElements());
    }

    public Page<ComplementFCResource> getAllCompanyGroupCompanyCfdiDateCfditype(String company_group,String cfditype, Integer pageNo, Integer pageSize)
    {
        Page<ComplementFCModel> complementHModel;
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        List<ComplementFCModel> complementFCResourceslist = this.getAllListGroupCompanyCompanyCfdiDateCfditype(company_group,cfditype,pageable);
        complementHModel = iComplementFCRepository.findByCompanygroupAndCfditype(company_group,cfditype,pageable);
        return new PageImpl(complementFCResourceslist, pageable, complementHModel.getTotalElements());
    }

    public Page<ComplementFCResource> getAllCompanyGroupCompanyCfdiDateCfditype(String company_group,String cfditype, Timestamp datestart,Timestamp dateend, Integer pageNo, Integer pageSize)
    {
        Page<ComplementFCModel> complementHModel;
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        List<ComplementFCModel> complementFCResourceslist = this.getAllListGroupCompanyCompanyCfdiDateCfditype(company_group,cfditype,datestart,dateend,pageable);
        complementHModel = iComplementFCRepository.findByCompanygroupAndCfditypeAndCfdidatetimeBetween(company_group,cfditype,datestart,dateend,pageable);
        return new PageImpl(complementFCResourceslist, pageable, complementHModel.getTotalElements());
    }

    public Page<ComplementFCResource> getAllCompanyGroupCompanyCompanyCfdiDate(String company_group,String company, Timestamp datestart,Timestamp dateend, Integer pageNo, Integer pageSize)
    {
        Page<ComplementFCModel> complementHModel;
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        List<ComplementFCModel> complementFCResourceslist = this.getAllListGroupCompanyCompanyCfdiDateCompany(company_group,company,datestart,dateend,pageable);
        complementHModel = iComplementFCRepository.findByCompanygroupAndCompanyAndCfdidatetimeBetween(company_group,company,datestart,dateend,pageable);
        return new PageImpl(complementFCResourceslist, pageable, complementHModel.getTotalElements());
    }

    public Page<ComplementFCResource> getAllCompanyGroupCompanyCompanyCfdiType(String company_group,String company, String cfditype, Integer pageNo, Integer pageSize)
    {
        Page<ComplementFCModel> complementHModel;
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        List<ComplementFCModel> complementFCResourceslist = this.getAllListGroupCompanyCompanyTypeCfdi(company_group,company,cfditype,pageable);
        complementHModel = iComplementFCRepository.findByCompanygroupAndCompanyAndCfditype(company_group,company,cfditype,pageable);
        return new PageImpl(complementFCResourceslist, pageable, complementHModel.getTotalElements());
    }

    public Page<ComplementFCResource> getAllCompanygroupAndPaymentmethod(String companygroup, String paymentmethod, Integer pageNo, Integer pageSize) {
        Page<ComplementFCModel> complementHModel;
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        List<ComplementFCModel> complementFCResourceslist = this.getAllListGroupCompanyPaymentmethod(companygroup,paymentmethod,pageable);
        complementHModel = iComplementFCRepository.findByCompanygroupAndPaymentmethod(companygroup,paymentmethod,pageable);
        return new PageImpl(complementFCResourceslist, pageable, complementHModel.getTotalElements());
    }

    public Page<ComplementFCResource> getAllCompanygroupAndCompanyAndPaymentmethod(String companygroup, String company, String paymentmethod, Integer pageNo, Integer pageSize) {
        Page<ComplementFCModel> complementHModel;
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        List<ComplementFCModel> complementFCResourceslist = this.getAllListGroupCompanyCompanyPaymentmethod(companygroup,company,paymentmethod,pageable);
        complementHModel = iComplementFCRepository.findByCompanygroupAndPaymentmethod(companygroup,paymentmethod,pageable);
        return new PageImpl(complementFCResourceslist, pageable, complementHModel.getTotalElements());
    }

    public Page<ComplementFCResource> getAllCompanygroupAndCfditypeAndPaymentmethod(String companygroup, String cfditype, String paymentmethod, Integer pageNo, Integer pageSize) {
        Page<ComplementFCModel> complementHModel;
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        List<ComplementFCModel> complementFCResourceslist = this.getAllListGroupCompanyCfditypePaymentmethod(companygroup,cfditype,paymentmethod,pageable);
        complementHModel = iComplementFCRepository.findByCompanygroupAndCfditypeAndPaymentmethod(companygroup,cfditype,paymentmethod,pageable);
        return new PageImpl(complementFCResourceslist, pageable, complementHModel.getTotalElements());
    }

    public Page<ComplementFCResource> getAllCompanyGroupCompanyCfdiDatePaymentmethod(String company_group,String paymentmethod, Timestamp datestart,Timestamp dateend, Integer pageNo, Integer pageSize)
    {
        Page<ComplementFCModel> complementHModel;
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        List<ComplementFCModel> complementFCResourceslist = this.getAllListGroupCompanyCfdiDatePaymentmethod(company_group,paymentmethod,datestart,dateend,pageable);
        complementHModel = iComplementFCRepository.findByCompanygroupAndPaymentmethodAndCfdidatetimeBetween(company_group,paymentmethod,datestart,dateend,pageable);
        return new PageImpl(complementFCResourceslist, pageable, complementHModel.getTotalElements());
    }

    public Page<ComplementFCResource> getAllCompanyGroupCompanyCompanyCfdiDatePaymentmethod(String company_group,String company,String paymentmethod, Timestamp datestart,Timestamp dateend, Integer pageNo, Integer pageSize)
    {
        Page<ComplementFCModel> complementHModel;
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        List<ComplementFCModel> complementFCResourceslist = this.getAllListGroupCompanyCompanyCfdiDatePaymentmethod(company_group,company,paymentmethod,datestart,dateend,pageable);
        complementHModel = iComplementFCRepository.findByCompanygroupAndCompanyAndPaymentmethodAndCfdidatetimeBetween(company_group,company,paymentmethod,datestart,dateend,pageable);
        return new PageImpl(complementFCResourceslist, pageable, complementHModel.getTotalElements());
    }


    public Page<ComplementFCResource> getAllCompanyGroupCompanyCfditypePaymentmethod(String company_group,String company,String cfditype,String paymentmethod,Integer pageNo, Integer pageSize)
    {
        Page<ComplementFCModel> complementHModel;
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        List<ComplementFCModel> complementFCResourceslist = this.getAllCompanygroupAndCompanyAndPaymentmethod(company_group,company,cfditype,paymentmethod,pageable);
        complementHModel = iComplementFCRepository.findByCompanygroupAndCompanyAndCfditypeAndPaymentmethod(company_group,company,cfditype,paymentmethod,pageable);
        return new PageImpl(complementFCResourceslist, pageable, complementHModel.getTotalElements());
    }


    //Lista

    private List<ComplementFCModel> getAllComplementList(String company_group, String id, String cfditype, String paymentmethod, Timestamp datestart,Timestamp dateend, Pageable pageable) {

        Page<ComplementFCModel> pagedResult = iComplementFCRepository.findByCompanygroupAndCompanyAndCfditypeAndPaymentmethodAndCfdidatetimeBetween(company_group,id,cfditype,paymentmethod,datestart,dateend,pageable);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<ComplementFCModel>();
        }
    }

    private List<ComplementFCModel> getAllListGroupCompany(String company_group,Pageable pageable) {

        Page<ComplementFCModel> pagedResult = iComplementFCRepository.findByCompanygroup(company_group, pageable);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<ComplementFCModel>();
        }
    }

    private List<ComplementFCModel> getAllListGroupCompanyCompany(String company_group, String id, Pageable pageable) {

        Page<ComplementFCModel> pagedResult = iComplementFCRepository.findByCompanygroupAndCompany(company_group,id,pageable);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<ComplementFCModel>();
        }
    }

    private List<ComplementFCModel> getAllCompanyGroupCompanyCfdiDate(String company_group, Timestamp datestart,Timestamp dateend, Pageable pageable) {

        Page<ComplementFCModel> pagedResult = iComplementFCRepository.findByCompanygroupAndCfdidatetimeBetween(company_group,datestart,dateend,pageable);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<ComplementFCModel>();
        }
    }

    private List<ComplementFCModel> getAllListGroupCompanyCompanyCfdiDateCfditype(String company_group, String cfditype, Pageable pageable) {

        Page<ComplementFCModel> pagedResult = iComplementFCRepository.findByCompanygroupAndCfditype(company_group,cfditype,pageable);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<ComplementFCModel>();
        }
    }

    private List<ComplementFCModel> getAllListGroupCompanyCompanyCfdiDateCfditype(String company_group, String cfditype, Timestamp datestart,Timestamp dateend, Pageable pageable) {

        Page<ComplementFCModel> pagedResult = iComplementFCRepository.findByCompanygroupAndCfditypeAndCfdidatetimeBetween(company_group,cfditype,datestart,dateend,pageable);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<ComplementFCModel>();
        }
    }


    private List<ComplementFCModel> getAllListGroupCompanyCompanyCfdiDateCompany(String company_group, String company, Timestamp datestart,Timestamp dateend, Pageable pageable) {

        Page<ComplementFCModel> pagedResult = iComplementFCRepository.findByCompanygroupAndCompanyAndCfdidatetimeBetween(company_group,company,datestart,dateend,pageable);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<ComplementFCModel>();
        }
    }

    private List<ComplementFCModel> getAllListGroupCompanyCompanyTypeCfdi(String company_group, String company, String cfditype, Pageable pageable) {

        Page<ComplementFCModel> pagedResult = iComplementFCRepository.findByCompanygroupAndCompanyAndCfditype(company_group,company,cfditype,pageable);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<ComplementFCModel>();
        }
    }

    private List<ComplementFCModel> getAllListGroupCompanyPaymentmethod(String company_group, String paymentmethod, Pageable pageable) {

        Page<ComplementFCModel> pagedResult = iComplementFCRepository.findByCompanygroupAndPaymentmethod(company_group,paymentmethod,pageable);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<ComplementFCModel>();
        }
    }

    private List<ComplementFCModel> getAllListGroupCompanyCompanyPaymentmethod(String company_group, String company, String paymentmethod, Pageable pageable) {

        Page<ComplementFCModel> pagedResult = iComplementFCRepository.findByCompanygroupAndCompanyAndPaymentmethod(company_group,company,paymentmethod,pageable);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<ComplementFCModel>();
        }
    }

    private List<ComplementFCModel> getAllListGroupCompanyCfditypePaymentmethod(String company_group, String cfditype, String paymentmethod, Pageable pageable) {

        Page<ComplementFCModel> pagedResult = iComplementFCRepository.findByCompanygroupAndCfditypeAndPaymentmethod(company_group,cfditype,paymentmethod,pageable);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<ComplementFCModel>();
        }
    }

    private List<ComplementFCModel> getAllListGroupCompanyCfdiDatePaymentmethod(String company_group, String paymentmethod, Timestamp datestart,Timestamp dateend, Pageable pageable) {

        Page<ComplementFCModel> pagedResult = iComplementFCRepository.findByCompanygroupAndPaymentmethodAndCfdidatetimeBetween(company_group,paymentmethod,datestart,dateend,pageable);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<ComplementFCModel>();
        }
    }

    private List<ComplementFCModel> getAllListGroupCompanyCompanyCfdiDatePaymentmethod(String company_group, String company, String paymentmethod, Timestamp datestart, Timestamp dateend, Pageable pageable) {
        Page<ComplementFCModel> pagedResult = iComplementFCRepository.findByCompanygroupAndCompanyAndPaymentmethodAndCfdidatetimeBetween(company_group,company,paymentmethod,datestart,dateend,pageable);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<ComplementFCModel>();
        }
    }

    private List<ComplementFCModel> getAllListGroupCompanyCfditypeCfdiDatePaymentmethod(String company_group, String cfditype, String paymentmethod, Timestamp datestart, Timestamp dateend, Pageable pageable) {
        Page<ComplementFCModel> pagedResult = iComplementFCRepository.findByCompanygroupAndCfditypeAndPaymentmethodAndCfdidatetimeBetween(company_group,cfditype,paymentmethod,datestart,dateend,pageable);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<ComplementFCModel>();
        }
    }

    public List<ComplementFCModel> getAllCompanygroupAndCompanyAndPaymentmethod(String companygroup, String company, String cfditype, String paymentmethod, Pageable pageable) {
        Page<ComplementFCModel> pagedResult = iComplementFCRepository.findByCompanygroupAndCompanyAndCfditypeAndPaymentmethod(companygroup,company,cfditype,paymentmethod,pageable);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<ComplementFCModel>();
        }
    }
}
