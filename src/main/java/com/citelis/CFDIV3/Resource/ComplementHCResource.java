package com.citelis.CFDIV3.Resource;

import com.citelis.CFDIV3.Model.ComplementHModel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.UUID;

@Data
@NoArgsConstructor
public class ComplementHCResource {

    private UUID id_num;
    private String receivercompanyid;
    private String uuid_pay;
    private Timestamp transdate;
    private Timestamp payment_date_time;
    private String folio;
    private String uuid_invoice;
    private Timestamp cfdidatetime;
    private String issuer_rfc;
    private String desc_vend;
    private String payment_method;
    private float pay_amount;
    private String currency_invoice;
    private String cfditype;
    private float subtotal;
    private float taxes_invoice;
    private float discount_total_amount;
    private float total;
    private float outstanding_balance;

    public ComplementHCResource(ComplementHResourceBuilder builder) {
        this.id_num=builder.id_num;
        this.receivercompanyid=builder.receivercompanyid;
        this.uuid_pay=builder.uuid_pay;
        this.transdate=builder.transdate;
        this.payment_date_time=builder.payment_date_time;
        this.folio=builder.folio;
        this.uuid_invoice=builder.uuid_invoice;
        this.cfdidatetime=builder.cfdidatetime;
        this.issuer_rfc=builder.issuer_rfc;
        this.desc_vend=builder.desc_vend;
        this.payment_method=builder.payment_method;
        this.pay_amount=builder.pay_amount;
        this.currency_invoice=builder.currency_invoice;
        this.cfditype=builder.cfditype;
        this.subtotal=builder.subtotal;
        this.taxes_invoice=builder.taxes_invoice;
        this.discount_total_amount=builder.discount_total_amount;
        this.total=builder.total;
        this.outstanding_balance=builder.outstanding_balance;
    }
    public static class ComplementHResourceBuilder {
        private final UUID id_num;
        private final String receivercompanyid;
        private final String uuid_pay;
        private final Timestamp transdate;
        private final Timestamp payment_date_time;
        private final String folio;
        private final String uuid_invoice;
        private final Timestamp cfdidatetime;
        private final String issuer_rfc;
        private final String desc_vend;
        private final String payment_method;
        private final Float pay_amount;
        private final String currency_invoice;
        private final String cfditype;
        private final Float subtotal;
        private final Float taxes_invoice;
        private final Float discount_total_amount;
        private final Float total;
        private final Float outstanding_balance;

        public ComplementHResourceBuilder(ComplementHModel complementHModel){
            this.id_num=complementHModel.getId_num();
            this.receivercompanyid=complementHModel.getCompany();
            this.uuid_pay=complementHModel.getUuid_pay();
            this.transdate=complementHModel.getTransdate();
            this.payment_date_time=complementHModel.getPayment_date_time();
            this.folio=complementHModel.getFolio();
            this.uuid_invoice=complementHModel.getUuid_invoice();
            this.cfdidatetime=complementHModel.getCfdidatetime();
            this.issuer_rfc=complementHModel.getIssuer_rfc();
            this.desc_vend=complementHModel.getDesc_vend();
            this.payment_method=complementHModel.getPaymentmethod();
            this.pay_amount=complementHModel.getPay_amount();
            this.currency_invoice=complementHModel.getCurrency_invoice();
            this.cfditype=complementHModel.getCfditype();
            this.subtotal=complementHModel.getSubtotal();
            this.taxes_invoice=complementHModel.getTaxes_invoice();
            this.discount_total_amount=complementHModel.getDiscount_total_amount();
            this.total=complementHModel.getTotal();
            this.outstanding_balance=complementHModel.getOutstanding_balance();
        }
    }
}
