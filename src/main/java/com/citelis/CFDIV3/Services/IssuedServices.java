package com.citelis.CFDIV3.Services;

import com.citelis.CFDIV3.Utils.IssuedExcelExporter;
import com.citelis.CFDIV3.Model.IssuedModel;
import com.citelis.CFDIV3.Model.QIssuedModel;
import com.citelis.CFDIV3.Repository.IIssuesRepository;
import com.citelis.CFDIV3.Resource.IssuedResource;
import com.querydsl.core.BooleanBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.sql.Timestamp;


@RequiredArgsConstructor
@Service
public class IssuedServices {

    private final IIssuesRepository iIssuesRepository;

    public Page<IssuedResource> getAllIssued(String company_group, String id, String cfditype, Timestamp datestart, Timestamp dateend, Integer pageNo, Integer pageSize)
    {
        Page<IssuedModel> issuedModel;
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        BooleanBuilder builder = new BooleanBuilder();
        QIssuedModel qIssuedModel = QIssuedModel.issuedModel;
        if (!company_group.isEmpty()) {
            builder.and(qIssuedModel.companygroup.eq(company_group));
        }
        if (id != null && !id.isEmpty() ) {
            builder.and(qIssuedModel.company.eq(id));
        }
        if(cfditype != null && !cfditype.isEmpty()){
            builder.and(qIssuedModel.cfditype.eq(cfditype));
        }
        if(datestart != null && dateend != null){
            builder.and(qIssuedModel.cfdidatetime.between(datestart,dateend));
        }
        Page<IssuedModel> issuedResourceslist = iIssuesRepository.findAll(builder.getValue(), pageable);
        return new PageImpl(issuedResourceslist.getContent(), pageable, issuedResourceslist.getTotalElements());
    }
    public ByteArrayInputStream load(String company_group, String id, String cfditype, Timestamp datestart, Timestamp dateend){
        BooleanBuilder builder = new BooleanBuilder();
        QIssuedModel qIssuedModel = QIssuedModel.issuedModel;

        if (!company_group.isEmpty()) {
            builder.and(qIssuedModel.companygroup.eq(company_group));
        }
        if (id != null && !id.isEmpty() ) {
            builder.and(qIssuedModel.company.eq(id));
        }
        if(cfditype != null && !cfditype.isEmpty()){
            builder.and(qIssuedModel.cfditype.eq(cfditype));
        }
        if(datestart != null && dateend != null){
            builder.and(qIssuedModel.cfdidatetime.between(datestart,dateend));
        }

        Page<IssuedModel> issuedModels = iIssuesRepository.findAll(builder.getValue(),Pageable.unpaged());
        ByteArrayInputStream in = IssuedExcelExporter.issuedToExcel(issuedModels);
        return in;
    }
}
