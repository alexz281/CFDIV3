package com.citelis.CFDIV3.Model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "citviewrelationcomplementf")
@Data
public class ComplementFModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id_num;

    @Column(name = "companygroup")
    String companygroup;

    @Column(name = "receiver_company_id")
    String company;

    @Column(name = "transdate")
    String transdate;

    @Column(name = "requestinguser")
    String requestinguser;

    @Column(name = "originaldocument")
    String originaldocument;

    @Column(name = "status")
    String status;

    @Column(name = "payment")
    String payment;

    @Column(name = "invoice")
    String invoice;

    @Column(name = "folio")
    String folio;

    @Column(name = "uuid_invoice")
    String uuid_invoice;

    @Column(name = "amountm")
    float amountm;

    @Column(name = "cfdi_datetime")
    Timestamp cfdidatetime;

    @Column(name = "issuer_rfc")
    String issuer_rfc;

    @Column(name = "desc_vend")
    String desc_vend;

    @Column(name = "payment_method")
    String paymentmethod;

    @Column(name = "currency_invoice")
    String currency_invoice;

    @Column(name = "exchrateinvoice")
    float exchrateinvoice;

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

}
