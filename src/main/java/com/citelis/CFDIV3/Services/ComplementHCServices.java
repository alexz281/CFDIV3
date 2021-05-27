package com.citelis.CFDIV3.Services;

import com.citelis.CFDIV3.Model.ComplementHCModel;
import com.citelis.CFDIV3.Model.QComplementHCModel;
import com.citelis.CFDIV3.Repository.IComplementHCRepository;
import com.citelis.CFDIV3.Resource.ComplementHCResource;
import com.citelis.CFDIV3.Utils.ComplementHCExcelExporter;
import com.querydsl.core.BooleanBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.sql.Timestamp;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ComplementHCServices {

    private final IComplementHCRepository iComplementHCRepository;

    public Page<ComplementHCResource> getAllComplement(String company_group, String id, String cfditype, String paymentmethod, Timestamp datestart, Timestamp dateend, Integer pageNo, Integer pageSize)
    {

        Pageable pageable = PageRequest.of(pageNo, pageSize);
        BooleanBuilder builder = new BooleanBuilder();
        QComplementHCModel qComplementHCModel = QComplementHCModel.complementHCModel;

        if (!company_group.isEmpty()) {
            builder.and(qComplementHCModel.companygroup.eq(company_group));
        }

        if (id != null && !id.isEmpty()) {
            builder.and(qComplementHCModel.company.eq(id));
        }
        if(cfditype != null && !cfditype.isEmpty()){
            builder.and(qComplementHCModel.cfditype.eq(cfditype));
        }
        if(paymentmethod != null && !paymentmethod.isEmpty()){
            builder.and(qComplementHCModel.paymentmethod.eq(paymentmethod));
        }
        if(datestart != null && dateend != null){
            builder.and(qComplementHCModel.cfdidatetime.between(datestart,dateend));
        }

        Page<ComplementHCModel> complementHCResourceslist = iComplementHCRepository.findAll(builder.getValue(), pageable);
        return new PageImpl(complementHCResourceslist.getContent(), pageable, complementHCResourceslist.getTotalElements());
    }
    public ByteArrayInputStream load(String company_group, String id, String cfditype, String paymentmethod, Timestamp datestart, Timestamp dateend){
        BooleanBuilder builder = new BooleanBuilder();
        QComplementHCModel qComplementHCModel = QComplementHCModel.complementHCModel;

        if (!company_group.isEmpty()) {
            builder.and(qComplementHCModel.companygroup.eq(company_group));
        }

        if ( id != null && !id.isEmpty()) {
            builder.and(qComplementHCModel.company.eq(id));
        }
        if(cfditype != null && !cfditype.isEmpty()){
            builder.and(qComplementHCModel.cfditype.eq(cfditype));
        }
        if(paymentmethod != null && !paymentmethod.isEmpty()){
            builder.and(qComplementHCModel.paymentmethod.eq(paymentmethod));
        }
        if(datestart != null && dateend != null){
            builder.and(qComplementHCModel.cfdidatetime.between(datestart,dateend));
        }
        Page<ComplementHCModel> complementHCModels = iComplementHCRepository.findAll(builder.getValue(),Pageable.unpaged());
        ByteArrayInputStream in = ComplementHCExcelExporter.complementHCToExcel(complementHCModels);
        return in;
    }


}
