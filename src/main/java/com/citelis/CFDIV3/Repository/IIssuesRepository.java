package com.citelis.CFDIV3.Repository;

import com.citelis.CFDIV3.Model.IssuedModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.UUID;
@Repository

public interface IIssuesRepository extends JpaRepository<IssuedModel, UUID>, QuerydslPredicateExecutor<IssuedModel> {
    Page<IssuedModel> findByCompanygroupAndCompanyAndCfditypeAndCfdidatetimeBetween(String company_group,String company,String cfditype,Timestamp datestart,Timestamp dateend,Pageable pageable);

    Page<IssuedModel> findByCompanygroup(String company_group, Pageable pageable);

    Page<IssuedModel> findByCompanygroupAndCompany(String company_group,String company,Pageable pageable);

    Page<IssuedModel> findByCompanygroupAndCfdidatetimeBetween(String company_group,Timestamp datestart,Timestamp dateend,Pageable pageable);

    Page<IssuedModel> findByCompanygroupAndCfditype(String company_group,String cfditype,Pageable pageable);

    Page<IssuedModel> findByCompanygroupAndCfditypeAndCfdidatetimeBetween(String company_group,String cfditype,Timestamp datestart,Timestamp dateend,Pageable pageable);

    Page<IssuedModel> findByCompanygroupAndCompanyAndCfdidatetimeBetween(String company_group,String company,Timestamp datestart,Timestamp dateend,Pageable pageable);

    Page<IssuedModel> findByCompanygroupAndCompanyAndCfditype(String company_group,String company,String cfditype,Pageable pageable);

}
