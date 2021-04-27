package com.citelis.CFDIV3.Model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "citviewpaymentscomplement")
@Data
public class ComplementHModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id_num;

    @Column(name = "companygroup")
    String companygroup;

    @Column(name = "receiver_company_id")
    String company;

    @Column(name = "uuid_pay")
    String uuid_pay;

    @Column(name = "transdate")
    Timestamp transdate;

    @Column(name = "payment_date_time")
    Timestamp payment_date_time;

    @Column(name = "folio")
    String folio;

    @Column(name = "uuid_invoice")
    String uuid_invoice;

    @Column(name = "cfdi_datetime")
    Timestamp cfdidatetime;

    @Column(name = "issuer_rfc")
    String issuer_rfc;

    @Column(name = "desc_vend")
    String desc_vend;

    @Column(name = "payment_method")
    String paymentmethod;

    @Column(name = "pay_amount")
    Float pay_amount;

    @Column(name = "currency_invoice")
    String currency_invoice;

    @Column(name = "cfdi_type")
    String cfditype;

    @Column(name = "subtotal")
    float subtotal;

    @Column(name = "taxes_invoice")
    float taxes_invoice;

    @Column(name = "discount_total_amount")
    float discount_total_amount;

    @Column(name = "total")
    float total;

    @Column(name = "outstanding_balance")
    float outstanding_balance;

}
