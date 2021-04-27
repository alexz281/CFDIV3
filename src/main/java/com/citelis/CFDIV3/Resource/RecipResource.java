package com.citelis.CFDIV3.Resource;

import com.citelis.CFDIV3.Model.RecipModel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.ZonedDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
public class RecipResource {

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

    private String receiver_rfc;

    private String receiver_name;

    private String issuer_rfc;

    private String issuer_name;

    private String descripcion;

    private float discount_total_amount;

    private float subtotal;

    private float isr;

    private float iva;

    private float ieps;

    private float iva_retenido;

    private float isr_retenido;

    private float iva_local;

    private float isr_local;

    private float total;

    private String payment_method;

    private String payment_mode;

    private String complement;

    private String referenced_cfdi_uuid;

    private String company;

    private String companygroup;

    public RecipResource(IssuedResourceBuilder builder){
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
        this.receiver_rfc=builder.receiver_rfc;
        this.receiver_name=builder.receiver_name;
        this.issuer_rfc=builder.issuer_rfc;
        this.issuer_name=builder.issuer_name;
        this.descripcion=builder.descripcion;
        this.discount_total_amount=builder.discount_total_amount;
        this.subtotal=builder.subtotal;
        this.isr=builder.isr;
        this.iva=builder.iva;
        this.ieps=builder.ieps;
        this.iva_retenido=builder.iva_retenido;
        this.isr_retenido=builder.isr_retenido;
        this.iva_local=builder.iva_local;
        this.isr_local=builder.isr_local;
        this.total=builder.total;
        this.payment_method=builder.payment_method;
        this.payment_mode=builder.payment_mode;
        this.complement=builder.complement;
        this.referenced_cfdi_uuid=builder.referenced_cfdi_uuid;
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

        private final String receiver_rfc;

        private final String receiver_name;

        private final String issuer_rfc;

        private final String issuer_name;

        private final String descripcion;

        private final float discount_total_amount;

        private final float subtotal;

        private final float isr;

        private final float iva;

        private final float ieps;

        private final float iva_retenido;

        private final float isr_retenido;

        private final float iva_local;

        private final float isr_local;

        private final float total;

        private final String payment_method;

        private final String payment_mode;

        private final String complement;

        private final String referenced_cfdi_uuid;

        private final String company;

        private final String companygroup;

        public IssuedResourceBuilder(RecipModel recipModel){
            this.id_num=recipModel.getId_num();
            this.status=recipModel.getStatus();
            this.cancellation_datetime=recipModel.getCancellation_datetime();
            this.version=recipModel.getVersion();
            this.cfditype=recipModel.getCfditype();
            this.uuid=recipModel.getUuid();
            this.series=recipModel.getSeries();
            this.folio=recipModel.getFolio();
            this.cfdidatetime=recipModel.getCfdidatetime();
            this.cfdi_date_time_t=recipModel.getCfdi_date_time_t();
            this.year=recipModel.getYear();
            this.receiver_rfc=recipModel.getReceiver_rfc();
            this.receiver_name=recipModel.getReceiver_name();
            this.issuer_rfc=recipModel.getIssuer_rfc();
            this.issuer_name=recipModel.getIssuer_name();
            this.descripcion=recipModel.getDescripcion();
            this.discount_total_amount=recipModel.getDiscount_total_amount();
            this.subtotal=recipModel.getSubtotal();
            this.isr=recipModel.getIsr();
            this.iva=recipModel.getIva();
            this.ieps=recipModel.getIeps();
            this.iva_retenido=recipModel.getIva_retenido();
            this.isr_retenido=recipModel.getIsr_retenido();
            this.iva_local=recipModel.getIva_local();
            this.isr_local=recipModel.getIsr_local();
            this.total=recipModel.getTotal();
            this.payment_method=recipModel.getPayment_method();
            this.payment_mode=recipModel.getPayment_mode();
            this.complement=recipModel.getComplement();
            this.referenced_cfdi_uuid=recipModel.getReferenced_cfdi_uuid();
            this.company=recipModel.getCompany();
            this.companygroup=recipModel.getCompanygroup();
        }
    }
}
