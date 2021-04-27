package com.citelis.CFDIV3.Repository;

import com.citelis.CFDIV3.Model.ComplementHModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.UUID;

@Repository

public interface IComplementHRepository extends JpaRepository<ComplementHModel, UUID> {
    Page<ComplementHModel> findByCompanygroupAndCompanyAndCfditypeAndPaymentmethodAndCfdidatetimeBetween(String company_group, String company, String cfditype, String paymentmethod,Timestamp datestart, Timestamp dateend, Pageable pageable);

    Page<ComplementHModel> findByCompanygroup(String company_group, Pageable pageable);

    Page<ComplementHModel> findByCompanygroupAndCompany(String company_group,String company,Pageable pageable);

    Page<ComplementHModel> findByCompanygroupAndCfdidatetimeBetween(String company_group,Timestamp datestart,Timestamp dateend,Pageable pageable);

    Page<ComplementHModel> findByCompanygroupAndCfditype(String company_group,String cfditype,Pageable pageable);

    Page<ComplementHModel> findByCompanygroupAndCfditypeAndCfdidatetimeBetween(String company_group,String cfditype,Timestamp datestart,Timestamp dateend,Pageable pageable);

    Page<ComplementHModel> findByCompanygroupAndCompanyAndCfdidatetimeBetween(String company_group,String company,Timestamp datestart,Timestamp dateend,Pageable pageable);

    Page<ComplementHModel> findByCompanygroupAndCompanyAndCfditype(String company_group,String company,String cfditype,Pageable pageable);

    Page<ComplementHModel> findByCompanygroupAndPaymentmethod(String company_group,String paymentmethod,Pageable pageable);

    Page<ComplementHModel> findByCompanygroupAndCompanyAndPaymentmethod(String company_group,String company,String paymentmethod,Pageable pageable);

    Page<ComplementHModel> findByCompanygroupAndCompanyAndPaymentmethodAndCfdidatetimeBetween(String company_group,String company,String paymentmethod,Timestamp datestart, Timestamp dateend,Pageable pageable);

    Page<ComplementHModel> findByCompanygroupAndPaymentmethodAndCfdidatetimeBetween(String company_group, String paymentmethod, Timestamp datestart, Timestamp dateend, Pageable pageable);

    Page<ComplementHModel> findByCompanygroupAndCfditypeAndPaymentmethod(String company_group,String cditype,String paymentmethod,Pageable pageable);

    Page<ComplementHModel> findByCompanygroupAndCfditypeAndPaymentmethodAndCfdidatetimeBetween(String company_group, String cfditype, String paymentmethod, Timestamp datestart, Timestamp dateend, Pageable pageable);


    Page<ComplementHModel> findByCompanygroupAndCompanyAndCfditypeAndPaymentmethod(String companygroup, String company, String cfditype,String paymentmethod, Pageable pageable);
}
