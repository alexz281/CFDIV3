package com.citelis.CFDIV3.Services;

import com.citelis.CFDIV3.Model.ComplementFCModel;
import com.citelis.CFDIV3.Model.ComplementHCModel;
import com.citelis.CFDIV3.Model.QComplementFModel;
import com.citelis.CFDIV3.Repository.IComplementFCRepository;
import com.citelis.CFDIV3.Resource.ComplementFCResource;
import com.querydsl.core.BooleanBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class ComplementFCServices {

    IComplementFCRepository iComplementFCRepository;

    public Page<ComplementFCResource> getAllComplement(String company_group, String id, String cfditype, String paymentmethod, Timestamp datestart, Timestamp dateend, Integer pageNo, Integer pageSize)
    {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        BooleanBuilder builder = new BooleanBuilder();
        QComplementFModel qComplementFModel = QComplementFModel.complementFModel;

        if (!company_group.isEmpty()) {
            builder.and(qComplementFModel.companygroup.eq(company_group));
        }

        if (id != null && !id.isEmpty()) {
            builder.and(qComplementFModel.company.eq(id));
        }
        if(cfditype != null && !cfditype.isEmpty()){
            builder.and(qComplementFModel.cfditype.eq(cfditype));
        }
        if(paymentmethod != null && !paymentmethod.isEmpty()){
            builder.and(qComplementFModel.paymentmethod.eq(paymentmethod));
        }
        if(datestart != null && dateend != null){
            builder.and(qComplementFModel.cfdidatetime.between(datestart,dateend));
        }

        Page<ComplementHCModel> ComplementFCResourceslist = iComplementFCRepository.findAll(builder.getValue(), pageable);
        return new PageImpl(ComplementFCResourceslist.getContent(), pageable, ComplementFCResourceslist.getTotalElements());
    }


}
