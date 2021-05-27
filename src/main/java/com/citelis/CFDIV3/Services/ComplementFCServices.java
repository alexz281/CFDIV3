package com.citelis.CFDIV3.Services;

import com.citelis.CFDIV3.Model.ComplementFCModel;
import com.citelis.CFDIV3.Model.QComplementFCModel;
import com.citelis.CFDIV3.Repository.IComplementFCRepository;
import com.citelis.CFDIV3.Resource.ComplementFCResource;
import com.citelis.CFDIV3.Utils.ComplementFCExcelExporter;
import com.querydsl.core.BooleanBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.sql.Timestamp;


@Service
public class ComplementFCServices {

    IComplementFCRepository iComplementFCRepository;

    public Page<ComplementFCResource> getAllComplement(String company_group, String id, String cfditype, String paymentmethod, Timestamp datestart, Timestamp dateend, Integer pageNo, Integer pageSize)
    {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        BooleanBuilder builder = new BooleanBuilder();
        QComplementFCModel qComplementFCModel = QComplementFCModel.complementFCModel;

        if (!company_group.isEmpty()) {
            builder.and(qComplementFCModel.companygroup.eq(company_group));
        }

        if (id != null && !id.isEmpty()) {
            builder.and(qComplementFCModel.company.eq(id));
        }
        if(cfditype != null && !cfditype.isEmpty()){
            builder.and(qComplementFCModel.cfditype.eq(cfditype));
        }
        if(paymentmethod != null && !paymentmethod.isEmpty()){
            builder.and(qComplementFCModel.paymentmethod.eq(paymentmethod));
        }
        if(datestart != null && dateend != null){
            builder.and(qComplementFCModel.cfdidatetime.between(datestart,dateend));
        }

        Page<ComplementFCModel> ComplementFCResourceslist = iComplementFCRepository.findAll(builder.getValue(), pageable);
        return new PageImpl(ComplementFCResourceslist.getContent(), pageable, ComplementFCResourceslist.getTotalElements());
    }

    public ByteArrayInputStream load(String company_group, String id, String cfditype, String paymentmethod, Timestamp datestart, Timestamp dateend){
        BooleanBuilder builder = new BooleanBuilder();
        QComplementFCModel qComplementFCModel = QComplementFCModel.complementFCModel;

        if (!company_group.isEmpty()) {
            builder.and(qComplementFCModel.companygroup.eq(company_group));
        }

        if ( id != null && !id.isEmpty()) {
            builder.and(qComplementFCModel.company.eq(id));
        }
        if(cfditype != null && !cfditype.isEmpty()){
            builder.and(qComplementFCModel.cfditype.eq(cfditype));
        }
        if(paymentmethod != null && !paymentmethod.isEmpty()){
            builder.and(qComplementFCModel.paymentmethod.eq(paymentmethod));
        }
        if(datestart != null && dateend != null){
            builder.and(qComplementFCModel.cfdidatetime.between(datestart,dateend));
        }
        Page<ComplementFCModel> complementFCModels = iComplementFCRepository.findAll(builder.getValue(),Pageable.unpaged());
        ByteArrayInputStream in = ComplementFCExcelExporter.complementFCToExcel(complementFCModels);
        return in;
    }

}
