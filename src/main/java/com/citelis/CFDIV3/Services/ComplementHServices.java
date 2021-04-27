package com.citelis.CFDIV3.Services;

import com.citelis.CFDIV3.Model.ComplementHModel;
import com.citelis.CFDIV3.Model.QComplementHModel;
import com.citelis.CFDIV3.Repository.IComplementHRepository;
import com.citelis.CFDIV3.Resource.ComplementHResource;
import com.querydsl.core.BooleanBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;


@Service
public class ComplementHServices {
    @Autowired
    IComplementHRepository iComplementHRepository;

    public Page<ComplementHResource> getAllComplement(String company_group, String id, String cfditype, String paymentmethod, Timestamp datestart, Timestamp dateend, Integer pageNo, Integer pageSize)
    {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        BooleanBuilder builder = new BooleanBuilder();
        QComplementHModel qComplementHModel = QComplementHModel.complementHModel;

        if (!company_group.isEmpty()) {
            builder.and(qComplementHModel.companygroup.eq(company_group));
        }

        if ( id != null && !id.isEmpty()) {
            builder.and(qComplementHModel.company.eq(id));
        }
        if(cfditype != null && !cfditype.isEmpty()){
            builder.and(qComplementHModel.cfditype.eq(cfditype));
        }
        if(paymentmethod != null && !paymentmethod.isEmpty()){
            builder.and(qComplementHModel.paymentmethod.eq(paymentmethod));
        }
        if(datestart != null && dateend != null){
            builder.and(qComplementHModel.cfdidatetime.between(datestart,dateend));
        }

        Page<ComplementHModel> ComplementHResourceslist = iComplementHRepository.findAll(builder.getValue(), pageable);
        return new PageImpl(ComplementHResourceslist.getContent(), pageable, ComplementHResourceslist.getTotalElements());
    }


}
