package com.citelis.CFDIV3.Repository;

import com.citelis.CFDIV3.Model.ComplementFCModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.UUID;

@Repository

public interface IComplementFCRepository extends JpaRepository<ComplementFCModel, UUID> {
    Page<ComplementFCModel> findByCompanygroupAndCompanyAndCfditypeAndPaymentmethodAndCfdidatetimeBetween(String company_group, String company, String cfditype, String paymentmethod,Timestamp datestart, Timestamp dateend, Pageable pageable);

    Page<ComplementFCModel> findByCompanygroup(String company_group, Pageable pageable);

    Page<ComplementFCModel> findByCompanygroupAndCompany(String company_group,String company,Pageable pageable);

    Page<ComplementFCModel> findByCompanygroupAndCfdidatetimeBetween(String company_group,Timestamp datestart,Timestamp dateend,Pageable pageable);

    Page<ComplementFCModel> findByCompanygroupAndCfditype(String company_group,String cfditype,Pageable pageable);

    Page<ComplementFCModel> findByCompanygroupAndCfditypeAndCfdidatetimeBetween(String company_group,String cfditype,Timestamp datestart,Timestamp dateend,Pageable pageable);

    Page<ComplementFCModel> findByCompanygroupAndCompanyAndCfdidatetimeBetween(String company_group,String company,Timestamp datestart,Timestamp dateend,Pageable pageable);

    Page<ComplementFCModel> findByCompanygroupAndCompanyAndCfditype(String company_group,String company,String cfditype,Pageable pageable);

    Page<ComplementFCModel> findByCompanygroupAndPaymentmethod(String company_group,String paymentmethod,Pageable pageable);

    Page<ComplementFCModel> findByCompanygroupAndCompanyAndPaymentmethod(String company_group,String company,String paymentmethod,Pageable pageable);

    Page<ComplementFCModel> findByCompanygroupAndCompanyAndPaymentmethodAndCfdidatetimeBetween(String company_group,String company,String paymentmethod,Timestamp datestart, Timestamp dateend,Pageable pageable);

    Page<ComplementFCModel> findByCompanygroupAndPaymentmethodAndCfdidatetimeBetween(String company_group, String paymentmethod, Timestamp datestart, Timestamp dateend, Pageable pageable);

    Page<ComplementFCModel> findByCompanygroupAndCfditypeAndPaymentmethod(String company_group,String cditype,String paymentmethod,Pageable pageable);

    Page<ComplementFCModel> findByCompanygroupAndCfditypeAndPaymentmethodAndCfdidatetimeBetween(String company_group, String cfditype, String paymentmethod, Timestamp datestart, Timestamp dateend, Pageable pageable);


    Page<ComplementFCModel> findByCompanygroupAndCompanyAndCfditypeAndPaymentmethod(String companygroup, String company, String cfditype,String paymentmethod, Pageable pageable);
}
