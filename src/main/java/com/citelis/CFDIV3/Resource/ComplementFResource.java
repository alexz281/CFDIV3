package com.citelis.CFDIV3.Resource;

import com.citelis.CFDIV3.Model.ComplementFModel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.UUID;

@Data
@NoArgsConstructor
public class ComplementFResource {

    private UUID id_num;
    private String companygroup;
    private String receiver_company_id;
    private String transdate;
    private String requestinguser;
    private String originaldocument;
    private String status;
    private String payment;
    private String invoice;
    private String folio;
    private String uuid_invoice;
    private float amountm;
    private Timestamp cfdi_datetime;
    private String issuer_rfc;
    private String desc_vend;
    private String payment_method;
    private String currency_invoice;
    private float exchrateinvoice;
    private String cfdi_type;
    private float subtotal;
    private float taxes_invoice;
    private float discount_total_amount;
    private float total;

    public ComplementFResource(ComplementFResourceBuilder builder) {
        this.id_num=builder.id_num;
        this.companygroup=builder.companygroup;
        this.receiver_company_id=builder.receiver_company_id;
        this.transdate=builder.transdate;
        this.requestinguser=builder.requestinguser;
        this.originaldocument=builder.originaldocument;
        this.status=builder.status;
        this.payment=builder.payment;
        this.invoice=builder.invoice;
        this.folio=builder.folio;
        this.uuid_invoice=builder.uuid_invoice;
        this.amountm=builder.amountm;
        this.cfdi_datetime=builder.cfdi_datetime;
        this.issuer_rfc=builder.issuer_rfc;
        this.desc_vend=builder.desc_vend;
        this.payment_method=builder.payment_method;
        this.currency_invoice=builder.currency_invoice;
        this.exchrateinvoice=builder.exchrateinvoice;
        this.cfdi_type=builder.cfdi_type;
        this.subtotal=builder.subtotal;
        this.taxes_invoice=builder.taxes_invoice;
        this.discount_total_amount=builder.discount_total_amount;
        this.total=builder.total;
    }

    public static class ComplementFResourceBuilder {
        private final UUID id_num;
        private final String companygroup;
        private final String receiver_company_id;
        private final String transdate;
        private final String requestinguser;
        private final String originaldocument;
        private final String status;
        private final String payment;
        private final String invoice;
        private final String folio;
        private final String uuid_invoice;
        private final float amountm;
        private final Timestamp cfdi_datetime;
        private final String issuer_rfc;
        private final String desc_vend;
        private final String payment_method;
        private final String currency_invoice;
        private final float exchrateinvoice;
        private final String cfdi_type;
        private final float subtotal;
        private final float taxes_invoice;
        private final float discount_total_amount;
        private final float total;

        public ComplementFResourceBuilder(ComplementFModel complementFModel){
            this.id_num=complementFModel.getId_num();
            this.companygroup=complementFModel.getCompanygroup();
            this.receiver_company_id=complementFModel.getCompany();
            this.transdate=complementFModel.getTransdate();
            this.requestinguser=complementFModel.getRequestinguser();
            this.originaldocument=complementFModel.getOriginaldocument();
            this.status=complementFModel.getStatus();
            this.payment=complementFModel.getPayment();
            this.invoice=complementFModel.getInvoice();
            this.folio=complementFModel.getFolio();
            this.uuid_invoice=complementFModel.getUuid_invoice();
            this.amountm=complementFModel.getAmountm();
            this.cfdi_datetime=complementFModel.getCfdidatetime();
            this.issuer_rfc=complementFModel.getIssuer_rfc();
            this.desc_vend=complementFModel.getDesc_vend();
            this.payment_method=complementFModel.getPaymentmethod();
            this.currency_invoice=complementFModel.getCurrency_invoice();
            this.exchrateinvoice=complementFModel.getExchrateinvoice();
            this.cfdi_type=complementFModel.getCfditype();
            this.subtotal=complementFModel.getSubtotal();
            this.taxes_invoice=complementFModel.getTaxes_invoice();
            this.discount_total_amount=complementFModel.getDiscount_total_amount();
            this.total=complementFModel.getTotal();

        }
    }
}
