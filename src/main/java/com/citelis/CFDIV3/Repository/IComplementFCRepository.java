package com.citelis.CFDIV3.Repository;

import com.citelis.CFDIV3.Model.ComplementFCModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.UUID;

@Repository

public interface IComplementFCRepository extends JpaRepository<ComplementFCModel, UUID>, QuerydslPredicateExecutor<ComplementFCModel> {

}
