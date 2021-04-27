package com.citelis.CFDIV3.Repository;

import com.citelis.CFDIV3.Model.ComplementFModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.UUID;

@Repository

public interface IComplementFRepository extends JpaRepository<ComplementFModel, UUID> {
    Page<ComplementFModel> findByCompanygroupAndCompanyAndCfditypeAndPaymentmethodAndCfdidatetimeBetween(String company_group, String company, String cfditype, String paymentmethod,Timestamp datestart, Timestamp dateend, Pageable pageable);

    Page<ComplementFModel> findByCompanygroup(String company_group, Pageable pageable);

    Page<ComplementFModel> findByCompanygroupAndCompany(String company_group,String company,Pageable pageable);

    Page<ComplementFModel> findByCompanygroupAndCfdidatetimeBetween(String company_group,Timestamp datestart,Timestamp dateend,Pageable pageable);

    Page<ComplementFModel> findByCompanygroupAndCfditype(String company_group,String cfditype,Pageable pageable);

    Page<ComplementFModel> findByCompanygroupAndCfditypeAndCfdidatetimeBetween(String company_group,String cfditype,Timestamp datestart,Timestamp dateend,Pageable pageable);

    Page<ComplementFModel> findByCompanygroupAndCompanyAndCfdidatetimeBetween(String company_group,String company,Timestamp datestart,Timestamp dateend,Pageable pageable);

    Page<ComplementFModel> findByCompanygroupAndCompanyAndCfditype(String company_group,String company,String cfditype,Pageable pageable);

    Page<ComplementFModel> findByCompanygroupAndPaymentmethod(String company_group,String paymentmethod,Pageable pageable);

    Page<ComplementFModel> findByCompanygroupAndCompanyAndPaymentmethod(String company_group,String company,String paymentmethod,Pageable pageable);

    Page<ComplementFModel> findByCompanygroupAndCompanyAndPaymentmethodAndCfdidatetimeBetween(String company_group,String company,String paymentmethod,Timestamp datestart, Timestamp dateend,Pageable pageable);

    Page<ComplementFModel> findByCompanygroupAndPaymentmethodAndCfdidatetimeBetween(String company_group, String paymentmethod, Timestamp datestart, Timestamp dateend, Pageable pageable);

    Page<ComplementFModel> findByCompanygroupAndCfditypeAndPaymentmethod(String company_group,String cditype,String paymentmethod,Pageable pageable);

    Page<ComplementFModel> findByCompanygroupAndCfditypeAndPaymentmethodAndCfdidatetimeBetween(String company_group, String cfditype, String paymentmethod, Timestamp datestart, Timestamp dateend, Pageable pageable);


    Page<ComplementFModel> findByCompanygroupAndCompanyAndCfditypeAndPaymentmethod(String companygroup, String company, String cfditype,String paymentmethod, Pageable pageable);
}
