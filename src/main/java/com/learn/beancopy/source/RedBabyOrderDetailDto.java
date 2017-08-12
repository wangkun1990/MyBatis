package com.learn.beancopy.source;

import java.io.Serializable;
import java.math.BigDecimal;

public class RedBabyOrderDetailDto implements Serializable {

    private String uuid;

    /**
     * 门店号
     */
    private String storeCode;

    /**
     * 合并单号，M单号
     */
    private String mdh;

    /**
     * 订单行号，D单号
     */
    private String dh;

    /**
     * 商品编码
     */
    private String cmmdtyCode;

    /**
     * 商品名称
     */
    private String cmmdtyName;

    /**
     * 商品单价
     */
    private BigDecimal cmmdtyPrice;

    /**
     * 商品数量
     */
    private BigDecimal cmmdtyQuantity;

    /**
     * 品牌
     */
    private String cmmdtyBrand;

    /**
     * 商品组
     */
    private String cmmdtyGroup;

    /**
     * 商品类型
     */
    private String cmmdtyType;

    /**
     * 商品EAN码
     */
    private String cmmdtyEan;

    /**
     * 销售单位
     */
    private String saleUnit;

    /**
     * 订单行金额
     */
    private BigDecimal orderLineAmount;

    /**
     * 配送地址
     */
    private String deliveryAddress;

    /**
     * SAP单据类型
     */
    private String sapOrdType;

    /**
     * 地点
     */
    private String place;

    /**
     * 库位
     */
    private String storage;

    /**
     * 供应商
     */
    private String supplier;

    /**
     * 提货方式
     * 01：配送
     */
    private String deliveryType;

    /**
     * 送货日期
     */
    private String deliveryDate;

    /**
     * 送货时间
     */
    private String deliveryTime;

    /**
     * 安装时间
     */
    private String installDate;

    /**
     * 安装时间
     */
    private String installTime;

    /**
     * 厂送标识
     */
    private String sendingMark;

    /**
     * 厂装标识
     */
    private String loadingMark;

    /**
     * 先销后采标识
     */
    private String purchaseFlag;

    /**
     * 发票类型
     */
    private String invoiceType;

    /**
     * 发票抬头
     */
    private String invoiceTitle;

    /**
     * 纳税人识别号
     */
    private String taxpayerId;

    /**
     * 校验码
     */
    private String checkCode;

    /**
     * 是否存在服务商品
     */
    private String existSrvCmmdty;

    /**
     * 服务商品
     */
    private RedBabySrvCommdtyInfoDto redBabySrvCommdtyInfoDto;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public String getMdh() {
        return mdh;
    }

    public void setMdh(String mdh) {
        this.mdh = mdh;
    }

    public String getDh() {
        return dh;
    }

    public void setDh(String dh) {
        this.dh = dh;
    }

    public String getCmmdtyCode() {
        return cmmdtyCode;
    }

    public void setCmmdtyCode(String cmmdtyCode) {
        this.cmmdtyCode = cmmdtyCode;
    }

    public String getCmmdtyName() {
        return cmmdtyName;
    }

    public void setCmmdtyName(String cmmdtyName) {
        this.cmmdtyName = cmmdtyName;
    }

    public BigDecimal getCmmdtyPrice() {
        return cmmdtyPrice;
    }

    public void setCmmdtyPrice(BigDecimal cmmdtyPrice) {
        this.cmmdtyPrice = cmmdtyPrice;
    }

    public BigDecimal getCmmdtyQuantity() {
        return cmmdtyQuantity;
    }

    public void setCmmdtyQuantity(BigDecimal cmmdtyQuantity) {
        this.cmmdtyQuantity = cmmdtyQuantity;
    }

    public String getCmmdtyBrand() {
        return cmmdtyBrand;
    }

    public void setCmmdtyBrand(String cmmdtyBrand) {
        this.cmmdtyBrand = cmmdtyBrand;
    }

    public String getCmmdtyGroup() {
        return cmmdtyGroup;
    }

    public void setCmmdtyGroup(String cmmdtyGroup) {
        this.cmmdtyGroup = cmmdtyGroup;
    }

    public String getCmmdtyType() {
        return cmmdtyType;
    }

    public void setCmmdtyType(String cmmdtyType) {
        this.cmmdtyType = cmmdtyType;
    }

    public String getCmmdtyEan() {
        return cmmdtyEan;
    }

    public void setCmmdtyEan(String cmmdtyEan) {
        this.cmmdtyEan = cmmdtyEan;
    }

    public String getSaleUnit() {
        return saleUnit;
    }

    public void setSaleUnit(String saleUnit) {
        this.saleUnit = saleUnit;
    }

    public BigDecimal getOrderLineAmount() {
        return orderLineAmount;
    }

    public void setOrderLineAmount(BigDecimal orderLineAmount) {
        this.orderLineAmount = orderLineAmount;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getSapOrdType() {
        return sapOrdType;
    }

    public void setSapOrdType(String sapOrdType) {
        this.sapOrdType = sapOrdType;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getInstallDate() {
        return installDate;
    }

    public void setInstallDate(String installDate) {
        this.installDate = installDate;
    }

    public String getInstallTime() {
        return installTime;
    }

    public void setInstallTime(String installTime) {
        this.installTime = installTime;
    }

    public String getSendingMark() {
        return sendingMark;
    }

    public void setSendingMark(String sendingMark) {
        this.sendingMark = sendingMark;
    }

    public String getLoadingMark() {
        return loadingMark;
    }

    public void setLoadingMark(String loadingMark) {
        this.loadingMark = loadingMark;
    }

    public String getPurchaseFlag() {
        return purchaseFlag;
    }

    public void setPurchaseFlag(String purchaseFlag) {
        this.purchaseFlag = purchaseFlag;
    }

    public String getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(String invoiceType) {
        this.invoiceType = invoiceType;
    }

    public String getInvoiceTitle() {
        return invoiceTitle;
    }

    public void setInvoiceTitle(String invoiceTitle) {
        this.invoiceTitle = invoiceTitle;
    }

    public String getTaxpayerId() {
        return taxpayerId;
    }

    public void setTaxpayerId(String taxpayerId) {
        this.taxpayerId = taxpayerId;
    }

    public String getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode;
    }

    public String getExistSrvCmmdty() {
        return existSrvCmmdty;
    }

    public void setExistSrvCmmdty(String existSrvCmmdty) {
        this.existSrvCmmdty = existSrvCmmdty;
    }

    public RedBabySrvCommdtyInfoDto getRedBabySrvCommdtyInfoDto() {
        return redBabySrvCommdtyInfoDto;
    }

    public void setRedBabySrvCommdtyInfoDto(RedBabySrvCommdtyInfoDto redBabySrvCommdtyInfoDto) {
        this.redBabySrvCommdtyInfoDto = redBabySrvCommdtyInfoDto;
    }

    @Override
    public String toString() {
        return "RedBabyOrderDetailDto{" +
                "uuid='" + uuid + '\'' +
                ", storeCode='" + storeCode + '\'' +
                ", mdh='" + mdh + '\'' +
                ", dh='" + dh + '\'' +
                ", cmmdtyCode='" + cmmdtyCode + '\'' +
                ", cmmdtyName='" + cmmdtyName + '\'' +
                ", cmmdtyPrice=" + cmmdtyPrice +
                ", cmmdtyQuantity=" + cmmdtyQuantity +
                ", cmmdtyBrand='" + cmmdtyBrand + '\'' +
                ", cmmdtyGroup='" + cmmdtyGroup + '\'' +
                ", cmmdtyType='" + cmmdtyType + '\'' +
                ", cmmdtyEan='" + cmmdtyEan + '\'' +
                ", saleUnit='" + saleUnit + '\'' +
                ", orderLineAmount=" + orderLineAmount +
                ", deliveryAddress='" + deliveryAddress + '\'' +
                ", sapOrdType='" + sapOrdType + '\'' +
                ", place='" + place + '\'' +
                ", storage='" + storage + '\'' +
                ", supplier='" + supplier + '\'' +
                ", deliveryType='" + deliveryType + '\'' +
                ", deliveryDate='" + deliveryDate + '\'' +
                ", deliveryTime='" + deliveryTime + '\'' +
                ", installDate='" + installDate + '\'' +
                ", installTime='" + installTime + '\'' +
                ", sendingMark='" + sendingMark + '\'' +
                ", loadingMark='" + loadingMark + '\'' +
                ", purchaseFlag='" + purchaseFlag + '\'' +
                ", invoiceType='" + invoiceType + '\'' +
                ", invoiceTitle='" + invoiceTitle + '\'' +
                ", taxpayerId='" + taxpayerId + '\'' +
                ", checkCode='" + checkCode + '\'' +
                ", existSrvCmmdty='" + existSrvCmmdty + '\'' +
                ", redBabySrvCommdtyInfoDto=" + redBabySrvCommdtyInfoDto +
                '}';
    }
}
