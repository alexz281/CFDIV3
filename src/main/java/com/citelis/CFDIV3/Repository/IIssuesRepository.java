package com.citelis.CFDIV3.Repository;

import com.citelis.CFDIV3.Model.IssuedModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface IIssuesRepository extends JpaRepository<IssuedModel, UUID>, QuerydslPredicateExecutor<IssuedModel> {
}
