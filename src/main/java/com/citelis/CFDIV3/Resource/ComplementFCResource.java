package com.citelis.CFDIV3.Resource;

import com.citelis.CFDIV3.Model.ComplementFCModel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.UUID;

@Data
@NoArgsConstructor
public class ComplementFCResource {

    private UUID id_num;
    private  String companygroup;
    private  String issuer_company_id;
    private  String transdate;
    private  String requestinguser;
    private  String originaldocument;
    private  String status;
    private  String payment;
    private  String invoice;
    private  String folio;
    private  String uuid_invoice;
    private  float amountm;
    private  Timestamp cfdi_datetime;
    private  String issuer_rfc;
    private  String desc_vend;
    private  String payment_method;
    private  String currency_invoice;
    private  float exchrateinvoice;
    private  String cfdi_type;
    private  float subtotal;
    private  float taxes_invoice;
    private  float discount_total_amount;
    private  float total;


    public ComplementFCResource(ComplementFCResourceBuilder builder) {
        this.id_num=builder.id_num;
        this.companygroup=builder.companygroup;
        this.issuer_company_id=builder.issuer_company_id;
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

    public static class ComplementFCResourceBuilder {
        private final UUID id_num;
        private final String companygroup;
        private final String issuer_company_id;
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


        public ComplementFCResourceBuilder(ComplementFCModel complementFCModel){
            this.id_num=complementFCModel.getId_num();
            this.companygroup=complementFCModel.getCompanygroup();
            this.issuer_company_id=complementFCModel.getCompany();
            this.transdate=complementFCModel.getTransdate();
            this.requestinguser=complementFCModel.getRequestinguser();
            this.originaldocument=complementFCModel.getOriginaldocument();
            this.status=complementFCModel.getStatus();
            this.payment=complementFCModel.getPayment();
            this.invoice=complementFCModel.getInvoice();
            this.folio=complementFCModel.getFolio();
            this.uuid_invoice=complementFCModel.getUuid_invoice();
            this.amountm=complementFCModel.getAmountm();
            this.cfdi_datetime=complementFCModel.getCfdidatetime();
            this.issuer_rfc=complementFCModel.getIssuer_rfc();
            this.desc_vend=complementFCModel.getDesc_vend();
            this.payment_method=complementFCModel.getPaymentmethod();
            this.currency_invoice=complementFCModel.getCurrency_invoice();
            this.exchrateinvoice=complementFCModel.getExchrateinvoice();
            this.cfdi_type=complementFCModel.getCfditype();
            this.subtotal=complementFCModel.getSubtotal();
            this.taxes_invoice=complementFCModel.getTaxes_invoice();
            this.discount_total_amount=complementFCModel.getDiscount_total_amount();
            this.total=complementFCModel.getTotal();

        }
    }
}
