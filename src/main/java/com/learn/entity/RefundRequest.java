/*
 * Copyright (C), 2002-2017, 苏宁易购电子商务有限公司
 * FileName: RefundRequest.java
 * Author:   13082136
 * Date:     2017年11月21日 下午5:08:28
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.learn.entity;


import com.learn.annotation.Table;

import javax.persistence.Column;
import java.io.Serializable;


@Table("refund")
public class RefundRequest implements Serializable {
    private String uuid;
    @Column(name = "store_type")
    private String storeType;
    @Column(name = "app_id")
    private String appid;// 公众账号ID
    @Column(name = "mch_id")
    private String mchId;// 商户号
    @Column(name = "transaction_id")
    private String transactionId;// 微信订单号
    @Column(name = "out_trade_no")
    private String outTradeNo;// 商户订单号
    @Column(name = "out_refund_no")
    private String outRefundNo;// 商户退款单号
    @Column(name = "tatal_fee")
    private String totalFee;// 订单金额
    @Column(name = "refund_fee")
    private String refundFee;// 退款金额
    @Column(name = "refund_fee_type")
    private String refundFeeType;// 货币种类
    @Column(name = "refund_desc")
    private String refundDesc;// 退款原因
    @Column(name = "refund_account")
    private String refundAccount;// 退款资金来源

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getStoreType() {
        return storeType;
    }

    public void setStoreType(String storeType) {
        this.storeType = storeType;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getOutRefundNo() {
        return outRefundNo;
    }

    public void setOutRefundNo(String outRefundNo) {
        this.outRefundNo = outRefundNo;
    }

    public String getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(String totalFee) {
        this.totalFee = totalFee;
    }

    public String getRefundFee() {
        return refundFee;
    }

    public void setRefundFee(String refundFee) {
        this.refundFee = refundFee;
    }

    public String getRefundFeeType() {
        return refundFeeType;
    }

    public void setRefundFeeType(String refundFeeType) {
        this.refundFeeType = refundFeeType;
    }

    public String getRefundDesc() {
        return refundDesc;
    }

    public void setRefundDesc(String refundDesc) {
        this.refundDesc = refundDesc;
    }

    public String getRefundAccount() {
        return refundAccount;
    }

    public void setRefundAccount(String refundAccount) {
        this.refundAccount = refundAccount;
    }
}
