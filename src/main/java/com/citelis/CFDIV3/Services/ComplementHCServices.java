package com.citelis.CFDIV3.Services;

import com.citelis.CFDIV3.Model.ComplementHCModel;
import com.citelis.CFDIV3.Repository.IComplementHCRepository;
import com.citelis.CFDIV3.Resource.ComplementHCResource;
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
public class ComplementHCServices {
    @Autowired
    IComplementHCRepository iComplementHCRepository;

    public Page<ComplementHCResource> getAllComplement(String company_group, String id, String cfditype, String paymentmethod, Timestamp datestart, Timestamp dateend, Integer pageNo, Integer pageSize)
    {
        Page<ComplementHCModel> complementHCModel;
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        List<ComplementHCModel> ComplementHResourceslist = this.getAllComplementList(company_group,id,cfditype,paymentmethod,datestart,dateend,pageable);
        complementHCModel = iComplementHCRepository.findByCompanygroupAndCompanyAndCfditypeAndPaymentmethodAndCfdidatetimeBetween(company_group,id,cfditype,paymentmethod,datestart,dateend,pageable);
        return new PageImpl(ComplementHResourceslist, pageable, complementHCModel.getTotalElements());
    }

    public Page<ComplementHCResource> getAllCompanyGroup(String company_group, Integer pageNo, Integer pageSize)
    {
        Page<ComplementHCModel> complementHCModel;
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        List<ComplementHCModel> ComplementHCResourceslist = this.getAllListGroupCompany(company_group,pageable);
        complementHCModel = iComplementHCRepository.findAll(pageable);
        return new PageImpl(ComplementHCResourceslist, pageable, complementHCModel.getTotalElements());
    }

    public Page<ComplementHCResource> getAllCompanyGroupCompany(String company_group, String id, Integer pageNo, Integer pageSize)
    {
        Page<ComplementHCModel> complementHCModel;
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        List<ComplementHCModel> ComplementHCResourceslist = this.getAllListGroupCompanyCompany(company_group,id,pageable);
        complementHCModel = iComplementHCRepository.findByCompanygroupAndCompany(company_group,id,pageable);
        return new PageImpl(ComplementHCResourceslist, pageable, complementHCModel.getTotalElements());
    }

    //

    public Page<ComplementHCResource> getAllCompanyGroupCompanyCfdiDate(String company_group, Timestamp datestart,Timestamp dateend, Integer pageNo, Integer pageSize)
    {
        Page<ComplementHCModel> complementHCModel;
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        List<ComplementHCModel> ComplementHCResourceslist = this.getAllCompanyGroupCompanyCfdiDate(company_group,datestart,dateend,pageable);
        complementHCModel = iComplementHCRepository.findByCompanygroupAndCfdidatetimeBetween(company_group,datestart,dateend,pageable);
        return new PageImpl(ComplementHCResourceslist, pageable, complementHCModel.getTotalElements());
    }

    public Page<ComplementHCResource> getAllCompanyGroupCompanyCfdiDateCfditype(String company_group,String cfditype, Integer pageNo, Integer pageSize)
    {
        Page<ComplementHCModel> complementHCModel;
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        List<ComplementHCModel> ComplementHCResourceslist = this.getAllListGroupCompanyCompanyCfdiDateCfditype(company_group,cfditype,pageable);
        complementHCModel = iComplementHCRepository.findByCompanygroupAndCfditype(company_group,cfditype,pageable);
        return new PageImpl(ComplementHCResourceslist, pageable, complementHCModel.getTotalElements());
    }

    public Page<ComplementHCResource> getAllCompanyGroupCompanyCfdiDateCfditype(String company_group,String cfditype, Timestamp datestart,Timestamp dateend, Integer pageNo, Integer pageSize)
    {
        Page<ComplementHCModel> complementHCModel;
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        List<ComplementHCModel> ComplementHCResourceslist = this.getAllListGroupCompanyCompanyCfdiDateCfditype(company_group,cfditype,datestart,dateend,pageable);
        complementHCModel = iComplementHCRepository.findByCompanygroupAndCfditypeAndCfdidatetimeBetween(company_group,cfditype,datestart,dateend,pageable);
        return new PageImpl(ComplementHCResourceslist, pageable, complementHCModel.getTotalElements());
    }

    public Page<ComplementHCResource> getAllCompanyGroupCompanyCompanyCfdiDate(String company_group,String company, Timestamp datestart,Timestamp dateend, Integer pageNo, Integer pageSize)
    {
        Page<ComplementHCModel> complementHCModel;
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        List<ComplementHCModel> ComplementHCResourceslist = this.getAllListGroupCompanyCompanyCfdiDateCompany(company_group,company,datestart,dateend,pageable);
        complementHCModel = iComplementHCRepository.findByCompanygroupAndCompanyAndCfdidatetimeBetween(company_group,company,datestart,dateend,pageable);
        return new PageImpl(ComplementHCResourceslist, pageable, complementHCModel.getTotalElements());
    }

    public Page<ComplementHCResource> getAllCompanyGroupCompanyCompanyCfdiType(String company_group,String company, String cfditype, Integer pageNo, Integer pageSize)
    {
        Page<ComplementHCModel> complementHCModel;
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        List<ComplementHCModel> ComplementHCResourceslist = this.getAllListGroupCompanyCompanyTypeCfdi(company_group,company,cfditype,pageable);
        complementHCModel = iComplementHCRepository.findByCompanygroupAndCompanyAndCfditype(company_group,company,cfditype,pageable);
        return new PageImpl(ComplementHCResourceslist, pageable, complementHCModel.getTotalElements());
    }

    public Page<ComplementHCResource> getAllCompanygroupAndPaymentmethod(String companygroup, String paymentmethod, Integer pageNo, Integer pageSize) {
        Page<ComplementHCModel> complementHCModel;
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        List<ComplementHCModel> ComplementHCResourceslist = this.getAllListGroupCompanyPaymentmethod(companygroup,paymentmethod,pageable);
        complementHCModel = iComplementHCRepository.findByCompanygroupAndPaymentmethod(companygroup,paymentmethod,pageable);
        return new PageImpl(ComplementHCResourceslist, pageable, complementHCModel.getTotalElements());
    }

    public Page<ComplementHCResource> getAllCompanygroupAndCompanyAndPaymentmethod(String companygroup, String company, String paymentmethod, Integer pageNo, Integer pageSize) {
        Page<ComplementHCModel> complementHCModel;
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        List<ComplementHCModel> ComplementHCResourceslist = this.getAllListGroupCompanyCompanyPaymentmethod(companygroup,company,paymentmethod,pageable);
        complementHCModel = iComplementHCRepository.findByCompanygroupAndPaymentmethod(companygroup,paymentmethod,pageable);
        return new PageImpl(ComplementHCResourceslist, pageable, complementHCModel.getTotalElements());
    }

    public Page<ComplementHCResource> getAllCompanygroupAndCfditypeAndPaymentmethod(String companygroup, String cfditype, String paymentmethod, Integer pageNo, Integer pageSize) {
        Page<ComplementHCModel> complementHCModel;
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        List<ComplementHCModel> ComplementHCResourceslist = this.getAllListGroupCompanyCfditypePaymentmethod(companygroup,cfditype,paymentmethod,pageable);
        complementHCModel = iComplementHCRepository.findByCompanygroupAndCfditypeAndPaymentmethod(companygroup,cfditype,paymentmethod,pageable);
        return new PageImpl(ComplementHCResourceslist, pageable, complementHCModel.getTotalElements());
    }

    public Page<ComplementHCResource> getAllCompanyGroupCompanyCfdiDatePaymentmethod(String company_group,String paymentmethod, Timestamp datestart,Timestamp dateend, Integer pageNo, Integer pageSize)
    {
        Page<ComplementHCModel> complementHCModel;
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        List<ComplementHCModel> ComplementHCResourceslist = this.getAllListGroupCompanyCfdiDatePaymentmethod(company_group,paymentmethod,datestart,dateend,pageable);
        complementHCModel = iComplementHCRepository.findByCompanygroupAndPaymentmethodAndCfdidatetimeBetween(company_group,paymentmethod,datestart,dateend,pageable);
        return new PageImpl(ComplementHCResourceslist, pageable, complementHCModel.getTotalElements());
    }

    public Page<ComplementHCResource> getAllCompanyGroupCompanyCompanyCfdiDatePaymentmethod(String company_group,String company,String paymentmethod, Timestamp datestart,Timestamp dateend, Integer pageNo, Integer pageSize)
    {
        Page<ComplementHCModel> complementHCModel;
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        List<ComplementHCModel> ComplementHCResourceslist = this.getAllListGroupCompanyCompanyCfdiDatePaymentmethod(company_group,company,paymentmethod,datestart,dateend,pageable);
        complementHCModel = iComplementHCRepository.findByCompanygroupAndCompanyAndPaymentmethodAndCfdidatetimeBetween(company_group,company,paymentmethod,datestart,dateend,pageable);
        return new PageImpl(ComplementHCResourceslist, pageable, complementHCModel.getTotalElements());
    }


    public Page<ComplementHCResource> getAllCompanyGroupCompanyCfditypePaymentmethod(String company_group,String company,String cfditype,String paymentmethod,Integer pageNo, Integer pageSize)
    {
        Page<ComplementHCModel> complementHCModel;
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        List<ComplementHCModel> ComplementHCResourceslist = this.getAllCompanygroupAndCompanyAndPaymentmethod(company_group,company,cfditype,paymentmethod,pageable);
        complementHCModel = iComplementHCRepository.findByCompanygroupAndCompanyAndCfditypeAndPaymentmethod(company_group,company,cfditype,paymentmethod,pageable);
        return new PageImpl(ComplementHCResourceslist, pageable, complementHCModel.getTotalElements());
    }


    //Lista

    private List<ComplementHCModel> getAllComplementList(String company_group, String id, String cfditype, String paymentmethod, Timestamp datestart,Timestamp dateend, Pageable pageable) {

        Page<ComplementHCModel> pagedResult = iComplementHCRepository.findByCompanygroupAndCompanyAndCfditypeAndPaymentmethodAndCfdidatetimeBetween(company_group,id,cfditype,paymentmethod,datestart,dateend,pageable);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<ComplementHCModel>();
        }
    }

    private List<ComplementHCModel> getAllListGroupCompany(String company_group,Pageable pageable) {

        Page<ComplementHCModel> pagedResult = iComplementHCRepository.findByCompanygroup(company_group, pageable);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<ComplementHCModel>();
        }
    }

    private List<ComplementHCModel> getAllListGroupCompanyCompany(String company_group, String id, Pageable pageable) {

        Page<ComplementHCModel> pagedResult = iComplementHCRepository.findByCompanygroupAndCompany(company_group,id,pageable);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<ComplementHCModel>();
        }
    }

    private List<ComplementHCModel> getAllCompanyGroupCompanyCfdiDate(String company_group, Timestamp datestart,Timestamp dateend, Pageable pageable) {

        Page<ComplementHCModel> pagedResult = iComplementHCRepository.findByCompanygroupAndCfdidatetimeBetween(company_group,datestart,dateend,pageable);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<ComplementHCModel>();
        }
    }

    private List<ComplementHCModel> getAllListGroupCompanyCompanyCfdiDateCfditype(String company_group, String cfditype, Pageable pageable) {

        Page<ComplementHCModel> pagedResult = iComplementHCRepository.findByCompanygroupAndCfditype(company_group,cfditype,pageable);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<ComplementHCModel>();
        }
    }

    private List<ComplementHCModel> getAllListGroupCompanyCompanyCfdiDateCfditype(String company_group, String cfditype, Timestamp datestart,Timestamp dateend, Pageable pageable) {

        Page<ComplementHCModel> pagedResult = iComplementHCRepository.findByCompanygroupAndCfditypeAndCfdidatetimeBetween(company_group,cfditype,datestart,dateend,pageable);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<ComplementHCModel>();
        }
    }


    private List<ComplementHCModel> getAllListGroupCompanyCompanyCfdiDateCompany(String company_group, String company, Timestamp datestart,Timestamp dateend, Pageable pageable) {

        Page<ComplementHCModel> pagedResult = iComplementHCRepository.findByCompanygroupAndCompanyAndCfdidatetimeBetween(company_group,company,datestart,dateend,pageable);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<ComplementHCModel>();
        }
    }

    private List<ComplementHCModel> getAllListGroupCompanyCompanyTypeCfdi(String company_group, String company, String cfditype, Pageable pageable) {

        Page<ComplementHCModel> pagedResult = iComplementHCRepository.findByCompanygroupAndCompanyAndCfditype(company_group,company,cfditype,pageable);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<ComplementHCModel>();
        }
    }

    private List<ComplementHCModel> getAllListGroupCompanyPaymentmethod(String company_group, String paymentmethod, Pageable pageable) {

        Page<ComplementHCModel> pagedResult = iComplementHCRepository.findByCompanygroupAndPaymentmethod(company_group,paymentmethod,pageable);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<ComplementHCModel>();
        }
    }

    private List<ComplementHCModel> getAllListGroupCompanyCompanyPaymentmethod(String company_group, String company, String paymentmethod, Pageable pageable) {

        Page<ComplementHCModel> pagedResult = iComplementHCRepository.findByCompanygroupAndCompanyAndPaymentmethod(company_group,company,paymentmethod,pageable);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<ComplementHCModel>();
        }
    }

    private List<ComplementHCModel> getAllListGroupCompanyCfditypePaymentmethod(String company_group, String cfditype, String paymentmethod, Pageable pageable) {

        Page<ComplementHCModel> pagedResult = iComplementHCRepository.findByCompanygroupAndCfditypeAndPaymentmethod(company_group,cfditype,paymentmethod,pageable);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<ComplementHCModel>();
        }
    }

    private List<ComplementHCModel> getAllListGroupCompanyCfdiDatePaymentmethod(String company_group, String paymentmethod, Timestamp datestart,Timestamp dateend, Pageable pageable) {

        Page<ComplementHCModel> pagedResult = iComplementHCRepository.findByCompanygroupAndPaymentmethodAndCfdidatetimeBetween(company_group,paymentmethod,datestart,dateend,pageable);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<ComplementHCModel>();
        }
    }

    private List<ComplementHCModel> getAllListGroupCompanyCompanyCfdiDatePaymentmethod(String company_group, String company, String paymentmethod, Timestamp datestart, Timestamp dateend, Pageable pageable) {
        Page<ComplementHCModel> pagedResult = iComplementHCRepository.findByCompanygroupAndCompanyAndPaymentmethodAndCfdidatetimeBetween(company_group,company,paymentmethod,datestart,dateend,pageable);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<ComplementHCModel>();
        }
    }

    private List<ComplementHCModel> getAllListGroupCompanyCfditypeCfdiDatePaymentmethod(String company_group, String cfditype, String paymentmethod, Timestamp datestart, Timestamp dateend, Pageable pageable) {
        Page<ComplementHCModel> pagedResult = iComplementHCRepository.findByCompanygroupAndCfditypeAndPaymentmethodAndCfdidatetimeBetween(company_group,cfditype,paymentmethod,datestart,dateend,pageable);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<ComplementHCModel>();
        }
    }

    public List<ComplementHCModel> getAllCompanygroupAndCompanyAndPaymentmethod(String companygroup, String company, String cfditype, String paymentmethod, Pageable pageable) {
        Page<ComplementHCModel> pagedResult = iComplementHCRepository.findByCompanygroupAndCompanyAndCfditypeAndPaymentmethod(companygroup,company,cfditype,paymentmethod,pageable);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<ComplementHCModel>();
        }
    }
}
