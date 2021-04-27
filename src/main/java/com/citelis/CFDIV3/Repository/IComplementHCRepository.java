package com.citelis.CFDIV3.Repository;

import com.citelis.CFDIV3.Model.ComplementHCModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.UUID;

@Repository

public interface IComplementHCRepository extends JpaRepository<ComplementHCModel, UUID> {
    Page<ComplementHCModel> findByCompanygroupAndCompanyAndCfditypeAndPaymentmethodAndCfdidatetimeBetween(String company_group, String company, String cfditype, String paymentmethod,Timestamp datestart, Timestamp dateend, Pageable pageable);

    Page<ComplementHCModel> findByCompanygroup(String company_group, Pageable pageable);

    Page<ComplementHCModel> findByCompanygroupAndCompany(String company_group,String company,Pageable pageable);

    Page<ComplementHCModel> findByCompanygroupAndCfdidatetimeBetween(String company_group,Timestamp datestart,Timestamp dateend,Pageable pageable);

    Page<ComplementHCModel> findByCompanygroupAndCfditype(String company_group,String cfditype,Pageable pageable);

    Page<ComplementHCModel> findByCompanygroupAndCfditypeAndCfdidatetimeBetween(String company_group,String cfditype,Timestamp datestart,Timestamp dateend,Pageable pageable);

    Page<ComplementHCModel> findByCompanygroupAndCompanyAndCfdidatetimeBetween(String company_group,String company,Timestamp datestart,Timestamp dateend,Pageable pageable);

    Page<ComplementHCModel> findByCompanygroupAndCompanyAndCfditype(String company_group,String company,String cfditype,Pageable pageable);

    Page<ComplementHCModel> findByCompanygroupAndPaymentmethod(String company_group,String paymentmethod,Pageable pageable);

    Page<ComplementHCModel> findByCompanygroupAndCompanyAndPaymentmethod(String company_group,String company,String paymentmethod,Pageable pageable);

    Page<ComplementHCModel> findByCompanygroupAndCompanyAndPaymentmethodAndCfdidatetimeBetween(String company_group,String company,String paymentmethod,Timestamp datestart, Timestamp dateend,Pageable pageable);

    Page<ComplementHCModel> findByCompanygroupAndPaymentmethodAndCfdidatetimeBetween(String company_group, String paymentmethod, Timestamp datestart, Timestamp dateend, Pageable pageable);

    Page<ComplementHCModel> findByCompanygroupAndCfditypeAndPaymentmethod(String company_group,String cditype,String paymentmethod,Pageable pageable);

    Page<ComplementHCModel> findByCompanygroupAndCfditypeAndPaymentmethodAndCfdidatetimeBetween(String company_group, String cfditype, String paymentmethod, Timestamp datestart, Timestamp dateend, Pageable pageable);


    Page<ComplementHCModel> findByCompanygroupAndCompanyAndCfditypeAndPaymentmethod(String companygroup, String company, String cfditype,String paymentmethod, Pageable pageable);
}
