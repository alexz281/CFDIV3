package com.citelis.CFDIV3.Model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Table(name = "citcfdireceiberexpensesincome")
@Data
public class RecipModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id_num;

    @Column(name="status")
    String status;

    @Column(name="cancellation_datetime")
    ZonedDateTime cancellation_datetime;

    @Column(name="version")
    String version;

    @Column(name="cfdi_type")
    String cfditype;

    @Column(name="uuid")
    String uuid;

    @Column(name="series")
    String series;

    @Column(name="folio")
    String folio;

    @Column(name="cfdi_date_time")
    Timestamp cfdidatetime;

    @Column(name="cfdi_date_time_t")
    String cfdi_date_time_t;

    @Column(name="ejercicio")
    Integer year;

    @Column(name="receiver_rfc")
    String receiver_rfc;

    @Column(name="receiver_name")
    String receiver_name;

    @Column(name="issuer_rfc")
    String issuer_rfc;

    @Column(name="issuer_name")
    String issuer_name;

    @Column(name="descripcion")
    String descripcion;

    @Column(name="discount_total_amount")
    float discount_total_amount;

    @Column(name="subtotal")
    float subtotal;

    @Column(name="isr")
    float isr;

    @Column(name="iva")
    float iva;

    @Column(name="ieps")
    float ieps;

    @Column(name="iva_retenido")
    float iva_retenido;

    @Column(name="isr_retenido")
    float isr_retenido;

    @Column(name="iva_local")
    float iva_local;

    @Column(name="isr_local")
    float isr_local;


    @Column(name="total")
    float total;

    @Column(name="payment_method")
    String payment_method;

    @Column(name="payment_mode")
    String payment_mode;

    @Column(name="complement")
    String complement;

    @Column(name="referenced_cfdi_uuid")
    String referenced_cfdi_uuid;

    @Column(name="id")
    String company;

    @Column(name="company_group")
    String companygroup;

}
