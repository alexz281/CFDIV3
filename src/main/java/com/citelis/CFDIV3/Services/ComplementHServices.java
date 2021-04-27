package com.citelis.CFDIV3.Services;

import com.citelis.CFDIV3.Model.ComplementHModel;
import com.citelis.CFDIV3.Repository.IComplementHRepository;
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
public class ComplementHServices {
    @Autowired
    IComplementHRepository iComplementHRepository;

    public Page<ComplementHResource> getAllComplement(String company_group, String id, String cfditype, String paymentmethod, Timestamp datestart, Timestamp dateend, Integer pageNo, Integer pageSize)
    {
        Page<ComplementHModel> complementHModel;
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        List<ComplementHModel> ComplementHResourceslist = this.getAllComplementList(company_group,id,cfditype,paymentmethod,datestart,dateend,pageable);
        complementHModel = iComplementHRepository.findByCompanygroupAndCompanyAndCfditypeAndPaymentmethodAndCfdidatetimeBetween(company_group,id,cfditype,paymentmethod,datestart,dateend,pageable);
        return new PageImpl(ComplementHResourceslist, pageable, complementHModel.getTotalElements());
    }

    public Page<ComplementHResource> getAllCompanyGroup(String company_group, Integer pageNo, Integer pageSize)
    {
        Page<ComplementHModel> complementHModel;
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        List<ComplementHModel> ComplementHResourceslist = this.getAllListGroupCompany(company_group,pageable);
        complementHModel = iComplementHRepository.findAll(pageable);
        return new PageImpl(ComplementHResourceslist, pageable, complementHModel.getTotalElements());
    }

    public Page<ComplementHResource> getAllCompanyGroupCompany(String company_group, String id, Integer pageNo, Integer pageSize)
    {
        Page<ComplementHModel> complementHModel;
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        List<ComplementHModel> ComplementHResourceslist = this.getAllListGroupCompanyCompany(company_group,id,pageable);
        complementHModel = iComplementHRepository.findByCompanygroupAndCompany(company_group,id,pageable);
        return new PageImpl(ComplementHResourceslist, pageable, complementHModel.getTotalElements());
    }

    //

    public Page<ComplementHResource> getAllCompanyGroupCompanyCfdiDate(String company_group, Timestamp datestart,Timestamp dateend, Integer pageNo, Integer pageSize)
    {
        Page<ComplementHModel> complementHModel;
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        List<ComplementHModel> ComplementHResourceslist = this.getAllCompanyGroupCompanyCfdiDate(company_group,datestart,dateend,pageable);
        complementHModel = iComplementHRepository.findByCompanygroupAndCfdidatetimeBetween(company_group,datestart,dateend,pageable);
        return new PageImpl(ComplementHResourceslist, pageable, complementHModel.getTotalElements());
    }

    public Page<ComplementHResource> getAllCompanyGroupCompanyCfdiDateCfditype(String company_group,String cfditype, Integer pageNo, Integer pageSize)
    {
        Page<ComplementHModel> complementHModel;
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        List<ComplementHModel> ComplementHResourceslist = this.getAllListGroupCompanyCompanyCfdiDateCfditype(company_group,cfditype,pageable);
        complementHModel = iComplementHRepository.findByCompanygroupAndCfditype(company_group,cfditype,pageable);
        return new PageImpl(ComplementHResourceslist, pageable, complementHModel.getTotalElements());
    }

    public Page<ComplementHResource> getAllCompanyGroupCompanyCfdiDateCfditype(String company_group,String cfditype, Timestamp datestart,Timestamp dateend, Integer pageNo, Integer pageSize)
    {
        Page<ComplementHModel> complementHModel;
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        List<ComplementHModel> ComplementHResourceslist = this.getAllListGroupCompanyCompanyCfdiDateCfditype(company_group,cfditype,datestart,dateend,pageable);
        complementHModel = iComplementHRepository.findByCompanygroupAndCfditypeAndCfdidatetimeBetween(company_group,cfditype,datestart,dateend,pageable);
        return new PageImpl(ComplementHResourceslist, pageable, complementHModel.getTotalElements());
    }

    public Page<ComplementHResource> getAllCompanyGroupCompanyCompanyCfdiDate(String company_group,String company, Timestamp datestart,Timestamp dateend, Integer pageNo, Integer pageSize)
    {
        Page<ComplementHModel> complementHModel;
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        List<ComplementHModel> ComplementHResourceslist = this.getAllListGroupCompanyCompanyCfdiDateCompany(company_group,company,datestart,dateend,pageable);
        complementHModel = iComplementHRepository.findByCompanygroupAndCompanyAndCfdidatetimeBetween(company_group,company,datestart,dateend,pageable);
        return new PageImpl(ComplementHResourceslist, pageable, complementHModel.getTotalElements());
    }

    public Page<ComplementHResource> getAllCompanyGroupCompanyCompanyCfdiType(String company_group,String company, String cfditype, Integer pageNo, Integer pageSize)
    {
        Page<ComplementHModel> complementHModel;
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        List<ComplementHModel> ComplementHResourceslist = this.getAllListGroupCompanyCompanyTypeCfdi(company_group,company,cfditype,pageable);
        complementHModel = iComplementHRepository.findByCompanygroupAndCompanyAndCfditype(company_group,company,cfditype,pageable);
        return new PageImpl(ComplementHResourceslist, pageable, complementHModel.getTotalElements());
    }

    public Page<ComplementHResource> getAllCompanygroupAndPaymentmethod(String companygroup, String paymentmethod, Integer pageNo, Integer pageSize) {
        Page<ComplementHModel> complementHModel;
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        List<ComplementHModel> ComplementHResourceslist = this.getAllListGroupCompanyPaymentmethod(companygroup,paymentmethod,pageable);
        complementHModel = iComplementHRepository.findByCompanygroupAndPaymentmethod(companygroup,paymentmethod,pageable);
        return new PageImpl(ComplementHResourceslist, pageable, complementHModel.getTotalElements());
    }

    public Page<ComplementHResource> getAllCompanygroupAndCompanyAndPaymentmethod(String companygroup, String company, String paymentmethod, Integer pageNo, Integer pageSize) {
        Page<ComplementHModel> complementHModel;
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        List<ComplementHModel> ComplementHResourceslist = this.getAllListGroupCompanyCompanyPaymentmethod(companygroup,company,paymentmethod,pageable);
        complementHModel = iComplementHRepository.findByCompanygroupAndPaymentmethod(companygroup,paymentmethod,pageable);
        return new PageImpl(ComplementHResourceslist, pageable, complementHModel.getTotalElements());
    }

    public Page<ComplementHResource> getAllCompanygroupAndCfditypeAndPaymentmethod(String companygroup, String cfditype, String paymentmethod, Integer pageNo, Integer pageSize) {
        Page<ComplementHModel> complementHModel;
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        List<ComplementHModel> ComplementHResourceslist = this.getAllListGroupCompanyCfditypePaymentmethod(companygroup,cfditype,paymentmethod,pageable);
        complementHModel = iComplementHRepository.findByCompanygroupAndCfditypeAndPaymentmethod(companygroup,cfditype,paymentmethod,pageable);
        return new PageImpl(ComplementHResourceslist, pageable, complementHModel.getTotalElements());
    }

    public Page<ComplementHResource> getAllCompanyGroupCompanyCfdiDatePaymentmethod(String company_group,String paymentmethod, Timestamp datestart,Timestamp dateend, Integer pageNo, Integer pageSize)
    {
        Page<ComplementHModel> complementHModel;
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        List<ComplementHModel> ComplementHResourceslist = this.getAllListGroupCompanyCfdiDatePaymentmethod(company_group,paymentmethod,datestart,dateend,pageable);
        complementHModel = iComplementHRepository.findByCompanygroupAndPaymentmethodAndCfdidatetimeBetween(company_group,paymentmethod,datestart,dateend,pageable);
        return new PageImpl(ComplementHResourceslist, pageable, complementHModel.getTotalElements());
    }

    public Page<ComplementHResource> getAllCompanyGroupCompanyCompanyCfdiDatePaymentmethod(String company_group,String company,String paymentmethod, Timestamp datestart,Timestamp dateend, Integer pageNo, Integer pageSize)
    {
        Page<ComplementHModel> complementHModel;
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        List<ComplementHModel> ComplementHResourceslist = this.getAllListGroupCompanyCompanyCfdiDatePaymentmethod(company_group,company,paymentmethod,datestart,dateend,pageable);
        complementHModel = iComplementHRepository.findByCompanygroupAndCompanyAndPaymentmethodAndCfdidatetimeBetween(company_group,company,paymentmethod,datestart,dateend,pageable);
        return new PageImpl(ComplementHResourceslist, pageable, complementHModel.getTotalElements());
    }


    public Page<ComplementHResource> getAllCompanyGroupCompanyCfditypePaymentmethod(String company_group,String company,String cfditype,String paymentmethod,Integer pageNo, Integer pageSize)
    {
        Page<ComplementHModel> complementHModel;
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        List<ComplementHModel> ComplementHResourceslist = this.getAllCompanygroupAndCompanyAndPaymentmethod(company_group,company,cfditype,paymentmethod,pageable);
        complementHModel = iComplementHRepository.findByCompanygroupAndCompanyAndCfditypeAndPaymentmethod(company_group,company,cfditype,paymentmethod,pageable);
        return new PageImpl(ComplementHResourceslist, pageable, complementHModel.getTotalElements());
    }


    //Lista

    private List<ComplementHModel> getAllComplementList(String company_group, String id, String cfditype, String paymentmethod, Timestamp datestart,Timestamp dateend, Pageable pageable) {

        Page<ComplementHModel> pagedResult = iComplementHRepository.findByCompanygroupAndCompanyAndCfditypeAndPaymentmethodAndCfdidatetimeBetween(company_group,id,cfditype,paymentmethod,datestart,dateend,pageable);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<ComplementHModel>();
        }
    }

    private List<ComplementHModel> getAllListGroupCompany(String company_group,Pageable pageable) {

        Page<ComplementHModel> pagedResult = iComplementHRepository.findByCompanygroup(company_group, pageable);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<ComplementHModel>();
        }
    }

    private List<ComplementHModel> getAllListGroupCompanyCompany(String company_group, String id, Pageable pageable) {

        Page<ComplementHModel> pagedResult = iComplementHRepository.findByCompanygroupAndCompany(company_group,id,pageable);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<ComplementHModel>();
        }
    }

    private List<ComplementHModel> getAllCompanyGroupCompanyCfdiDate(String company_group, Timestamp datestart,Timestamp dateend, Pageable pageable) {

        Page<ComplementHModel> pagedResult = iComplementHRepository.findByCompanygroupAndCfdidatetimeBetween(company_group,datestart,dateend,pageable);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<ComplementHModel>();
        }
    }

    private List<ComplementHModel> getAllListGroupCompanyCompanyCfdiDateCfditype(String company_group, String cfditype, Pageable pageable) {

        Page<ComplementHModel> pagedResult = iComplementHRepository.findByCompanygroupAndCfditype(company_group,cfditype,pageable);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<ComplementHModel>();
        }
    }

    private List<ComplementHModel> getAllListGroupCompanyCompanyCfdiDateCfditype(String company_group, String cfditype, Timestamp datestart,Timestamp dateend, Pageable pageable) {

        Page<ComplementHModel> pagedResult = iComplementHRepository.findByCompanygroupAndCfditypeAndCfdidatetimeBetween(company_group,cfditype,datestart,dateend,pageable);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<ComplementHModel>();
        }
    }


    private List<ComplementHModel> getAllListGroupCompanyCompanyCfdiDateCompany(String company_group, String company, Timestamp datestart,Timestamp dateend, Pageable pageable) {

        Page<ComplementHModel> pagedResult = iComplementHRepository.findByCompanygroupAndCompanyAndCfdidatetimeBetween(company_group,company,datestart,dateend,pageable);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<ComplementHModel>();
        }
    }

    private List<ComplementHModel> getAllListGroupCompanyCompanyTypeCfdi(String company_group, String company, String cfditype, Pageable pageable) {

        Page<ComplementHModel> pagedResult = iComplementHRepository.findByCompanygroupAndCompanyAndCfditype(company_group,company,cfditype,pageable);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<ComplementHModel>();
        }
    }

    private List<ComplementHModel> getAllListGroupCompanyPaymentmethod(String company_group, String paymentmethod, Pageable pageable) {

        Page<ComplementHModel> pagedResult = iComplementHRepository.findByCompanygroupAndPaymentmethod(company_group,paymentmethod,pageable);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<ComplementHModel>();
        }
    }

    private List<ComplementHModel> getAllListGroupCompanyCompanyPaymentmethod(String company_group, String company, String paymentmethod, Pageable pageable) {

        Page<ComplementHModel> pagedResult = iComplementHRepository.findByCompanygroupAndCompanyAndPaymentmethod(company_group,company,paymentmethod,pageable);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<ComplementHModel>();
        }
    }

    private List<ComplementHModel> getAllListGroupCompanyCfditypePaymentmethod(String company_group, String cfditype, String paymentmethod, Pageable pageable) {

        Page<ComplementHModel> pagedResult = iComplementHRepository.findByCompanygroupAndCfditypeAndPaymentmethod(company_group,cfditype,paymentmethod,pageable);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<ComplementHModel>();
        }
    }

    private List<ComplementHModel> getAllListGroupCompanyCfdiDatePaymentmethod(String company_group, String paymentmethod, Timestamp datestart,Timestamp dateend, Pageable pageable) {

        Page<ComplementHModel> pagedResult = iComplementHRepository.findByCompanygroupAndPaymentmethodAndCfdidatetimeBetween(company_group,paymentmethod,datestart,dateend,pageable);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<ComplementHModel>();
        }
    }

    private List<ComplementHModel> getAllListGroupCompanyCompanyCfdiDatePaymentmethod(String company_group, String company, String paymentmethod, Timestamp datestart, Timestamp dateend, Pageable pageable) {
        Page<ComplementHModel> pagedResult = iComplementHRepository.findByCompanygroupAndCompanyAndPaymentmethodAndCfdidatetimeBetween(company_group,company,paymentmethod,datestart,dateend,pageable);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<ComplementHModel>();
        }
    }

    private List<ComplementHModel> getAllListGroupCompanyCfditypeCfdiDatePaymentmethod(String company_group, String cfditype, String paymentmethod, Timestamp datestart, Timestamp dateend, Pageable pageable) {
        Page<ComplementHModel> pagedResult = iComplementHRepository.findByCompanygroupAndCfditypeAndPaymentmethodAndCfdidatetimeBetween(company_group,cfditype,paymentmethod,datestart,dateend,pageable);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<ComplementHModel>();
        }
    }

    public List<ComplementHModel> getAllCompanygroupAndCompanyAndPaymentmethod(String companygroup, String company, String cfditype, String paymentmethod, Pageable pageable) {
        Page<ComplementHModel> pagedResult = iComplementHRepository.findByCompanygroupAndCompanyAndCfditypeAndPaymentmethod(companygroup,company,cfditype,paymentmethod,pageable);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<ComplementHModel>();
        }
    }
}
