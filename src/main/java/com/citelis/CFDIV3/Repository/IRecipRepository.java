package com.citelis.CFDIV3.Repository;

import com.citelis.CFDIV3.Model.RecipModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.UUID;

@Repository

public interface IRecipRepository extends JpaRepository<RecipModel, UUID> {
    Page<RecipModel> findByCompanygroupAndCompanyAndCfditypeAndCfdidatetimeBetween(String company_group, String company, String cfditype, Timestamp datestart, Timestamp dateend, Pageable pageable);

    Page<RecipModel> findByCompanygroup(String company_group, Pageable pageable);

    Page<RecipModel> findByCompanygroupAndCompany(String company_group,String company,Pageable pageable);

    Page<RecipModel> findByCompanygroupAndCfdidatetimeBetween(String company_group,Timestamp datestart,Timestamp dateend,Pageable pageable);

    Page<RecipModel> findByCompanygroupAndCfditype(String company_group,String cfditype,Pageable pageable);
    Page<RecipModel> findByCompanygroupAndCfditypeAndCfdidatetimeBetween(String company_group,String cfditype,Timestamp datestart,Timestamp dateend,Pageable pageable);

    Page<RecipModel> findByCompanygroupAndCompanyAndCfdidatetimeBetween(String company_group,String company,Timestamp datestart,Timestamp dateend,Pageable pageable);

    Page<RecipModel> findByCompanygroupAndCompanyAndCfditype(String company_group,String company,String cfditype,Pageable pageable);

}
