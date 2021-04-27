package com.citelis.CFDIV3.Resource;

import com.citelis.CFDIV3.Model.IssuedModel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.ZonedDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
public class IssuedResource {

    private UUID id_num;

    private String status;

    private ZonedDateTime cancellation_datetime;

    private String version;

    private String cfditype;

    private String uuid;

    private String series;

    private String folio;

    private Timestamp cfdidatetime;

    private String cfdi_date_time_t;

    private Integer year;

    private Integer month;

    private String receiver_rfc;

    private String receiver_name;

    private String issuer_rfc;

    private String issuer_name;

    private String descripcion;

    private float discount_total_amount;

    private float subtotal;

    private float taxes;

    private float isr;

    private float iva;

    private float ieps;

    private float iva_retenido;

    private float isr_retenido;

    private float transferred_taxes_total_amount;

    private float withheld_taxes_total_amount;

    private float total;

    private String payment_method;

    private String payment_mode;

    private String complement;

    private String company;

    private String companygroup;

    public IssuedResource(IssuedResourceBuilder builder){
        this.id_num=builder.id_num;
        this.status=builder.status;
        this.cancellation_datetime=builder.cancellation_datetime;
        this.version=builder.version;
        this.cfditype=builder.cfditype;
        this.uuid=builder.uuid;
        this.series=builder.series;
        this.folio=builder.folio;
        this.cfdidatetime=builder.cfdidatetime;
        this.cfdi_date_time_t=builder.cfdi_date_time_t;
        this.year=builder.year;
        this.month=builder.month;
        this.receiver_rfc=builder.receiver_rfc;
        this.receiver_name=builder.receiver_name;
        this.issuer_rfc=builder.issuer_rfc;
        this.issuer_name=builder.issuer_name;
        this.descripcion=builder.descripcion;
        this.discount_total_amount=builder.discount_total_amount;
        this.subtotal=builder.subtotal;
        this.taxes=builder.taxes;
        this.isr=builder.isr;
        this.iva=builder.iva;
        this.ieps=builder.ieps;
        this.iva_retenido=builder.iva_retenido;
        this.isr_retenido=builder.isr_retenido;
        this.transferred_taxes_total_amount=builder.transferred_taxes_total_amount;
        this.withheld_taxes_total_amount=builder.withheld_taxes_total_amount;
        this.total=builder.total;
        this.payment_method=builder.payment_method;
        this.payment_mode=builder.payment_mode;
        this.complement=builder.complement;
        this.company=builder.company;
        this.companygroup=builder.companygroup;
    }


public static class IssuedResourceBuilder {
        private final UUID id_num;

        private final String status;

        private final ZonedDateTime cancellation_datetime;

        private final String version;

        private final String cfditype;

        private final String uuid;

        private final String series;

        private final String folio;

        private final Timestamp cfdidatetime;

        private final String cfdi_date_time_t;

        private final Integer year;

        private final Integer month;

        private final String receiver_rfc;

        private final String receiver_name;

        private final String issuer_rfc;

        private final String issuer_name;

        private final String descripcion;

        private final float discount_total_amount;

        private final float subtotal;

        private final float taxes;

        private final float isr;

        private final float iva;

        private final float ieps;

        private final float iva_retenido;

        private final float isr_retenido;

        private final float transferred_taxes_total_amount;

        private final float withheld_taxes_total_amount;

        private final float total;

        private final String payment_method;

        private final String payment_mode;

        private final String complement;

        private final String company;

        private final String companygroup;

        public IssuedResourceBuilder(IssuedModel issuedModel){
            this.id_num=issuedModel.getId_num();
            this.status=issuedModel.getStatus();
            this.cancellation_datetime=issuedModel.getCancellation_datetime();
            this.version=issuedModel.getVersion();
            this.cfditype=issuedModel.getCfditype();
            this.uuid=issuedModel.getUuid();
            this.series=issuedModel.getSeries();
            this.folio=issuedModel.getFolio();
            this.cfdidatetime=issuedModel.getCfdidatetime();
            this.cfdi_date_time_t=issuedModel.getCfdi_date_time_t();
            this.year=issuedModel.getYear();
            this.month=issuedModel.getMonth();
            this.receiver_rfc=issuedModel.getReceiver_rfc();
            this.receiver_name=issuedModel.getReceiver_name();
            this.issuer_rfc=issuedModel.getIssuer_rfc();
            this.issuer_name=issuedModel.getIssuer_name();
            this.descripcion=issuedModel.getDescripcion();
            this.discount_total_amount=issuedModel.getDiscount_total_amount();
            this.subtotal=issuedModel.getSubtotal();
            this.taxes=issuedModel.getTaxes();
            this.isr=issuedModel.getIsr();
            this.iva=issuedModel.getIva();
            this.ieps=issuedModel.getIeps();
            this.iva_retenido=issuedModel.getIva_retenido();
            this.isr_retenido=issuedModel.getIsr_retenido();
            this.transferred_taxes_total_amount=issuedModel.getTransferred_taxes_total_amount();
            this.withheld_taxes_total_amount=issuedModel.getWithheld_taxes_total_amount();
            this.total=issuedModel.getTotal();
            this.payment_method=issuedModel.getPayment_method();
            this.payment_mode=issuedModel.getPayment_mode();
            this.complement=issuedModel.getComplement();
            this.company=issuedModel.getCompany();
            this.companygroup=issuedModel.getCompanygroup();
        }
    }
}
