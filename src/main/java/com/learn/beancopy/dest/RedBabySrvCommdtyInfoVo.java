package com.learn.beancopy.dest;

import java.io.Serializable;
import java.math.BigDecimal;

public class RedBabySrvCommdtyInfoVo implements Serializable {

    private String uuid;
    /**
     * 门店号
     */
    private String storeCode;

    /**
     * D单号
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
     * 供应商编码
     */
    private String supplierCode;
    /**
     * 服务商品数量
     */
    private BigDecimal cmmdtyQty;

    /**
     * 发货日期
     */
    private String deliveryDate;

    /**
     * 发货时间
     */
    private String deliveryTime;

    /**
     * 安装日期
     */
    private String installDate;

    /**
     * 安装时间
     */
    private String installTime;

    /**
     * 服务地址,取送货地址
     */
    private String serviceAddress;

    /**
     * 送装一体标记
     */
    private String integratedDeliveryMark;

    /**
     * 服务区域,取配送区域
     */
    private String serviceArea;

    /**
     * 服务备注
     */
    private String serviceMemo;

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

    public String getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }

    public BigDecimal getCmmdtyQty() {
        return cmmdtyQty;
    }

    public void setCmmdtyQty(BigDecimal cmmdtyQty) {
        this.cmmdtyQty = cmmdtyQty;
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

    public String getServiceAddress() {
        return serviceAddress;
    }

    public void setServiceAddress(String serviceAddress) {
        this.serviceAddress = serviceAddress;
    }

    public String getIntegratedDeliveryMark() {
        return integratedDeliveryMark;
    }

    public void setIntegratedDeliveryMark(String integratedDeliveryMark) {
        this.integratedDeliveryMark = integratedDeliveryMark;
    }

    public String getServiceArea() {
        return serviceArea;
    }

    public void setServiceArea(String serviceArea) {
        this.serviceArea = serviceArea;
    }

    public String getServiceMemo() {
        return serviceMemo;
    }

    public void setServiceMemo(String serviceMemo) {
        this.serviceMemo = serviceMemo;
    }

    @Override
    public String toString() {
        return "RedBabySrvCommdtyInfoVo{" +
                "uuid='" + uuid + '\'' +
                ", storeCode='" + storeCode + '\'' +
                ", dh='" + dh + '\'' +
                ", cmmdtyCode='" + cmmdtyCode + '\'' +
                ", cmmdtyName='" + cmmdtyName + '\'' +
                ", cmmdtyBrand='" + cmmdtyBrand + '\'' +
                ", cmmdtyGroup='" + cmmdtyGroup + '\'' +
                ", cmmdtyType='" + cmmdtyType + '\'' +
                ", cmmdtyEan='" + cmmdtyEan + '\'' +
                ", saleUnit='" + saleUnit + '\'' +
                ", supplierCode='" + supplierCode + '\'' +
                ", cmmdtyQty=" + cmmdtyQty +
                ", deliveryDate='" + deliveryDate + '\'' +
                ", deliveryTime='" + deliveryTime + '\'' +
                ", installDate='" + installDate + '\'' +
                ", installTime='" + installTime + '\'' +
                ", serviceAddress='" + serviceAddress + '\'' +
                ", integratedDeliveryMark='" + integratedDeliveryMark + '\'' +
                ", serviceArea='" + serviceArea + '\'' +
                ", serviceMemo='" + serviceMemo + '\'' +
                '}';
    }
}
