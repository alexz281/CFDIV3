package com.citelis.CFDIV3.Services;

import com.citelis.CFDIV3.Model.IssuedModel;
import com.citelis.CFDIV3.Model.QIssuedModel;
import com.citelis.CFDIV3.Model.QRecipModel;
import com.citelis.CFDIV3.Model.RecipModel;
import com.citelis.CFDIV3.Repository.IRecipRepository;
import com.citelis.CFDIV3.Resource.RecipResource;
import com.querydsl.core.BooleanBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@RequiredArgsConstructor
@Service
public class RecipServices {

    private final IRecipRepository iRecipRepository;


    public Page<RecipResource> getAllRecip(String company_group, String id, String cfditype, Timestamp datestart, Timestamp dateend, Integer pageNo, Integer pageSize)
    {

        Pageable pageable = PageRequest.of(pageNo, pageSize);
        BooleanBuilder builder = new BooleanBuilder();
        QRecipModel qRecipModel = QRecipModel.recipModel;

        if (!company_group.isEmpty()) {
            builder.and(qRecipModel.companygroup.eq(company_group));
        }

        if (id != null && !id.isEmpty()) {
            builder.and(qRecipModel.company.eq(id));
        }
        if(cfditype != null && !cfditype.isEmpty()){
            builder.and(qRecipModel.cfditype.eq(cfditype));
        }
        if(datestart != null && dateend != null){
            builder.and(qRecipModel.cfdidatetime.between(datestart,dateend));
        }

        Page<RecipModel> recipResourceslist = iRecipRepository.findAll(builder.getValue(), pageable);
        return new PageImpl(recipResourceslist.getContent(), pageable, recipResourceslist.getTotalElements());
    }
}
