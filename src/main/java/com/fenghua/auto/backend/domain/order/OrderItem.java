package com.fenghua.auto.backend.domain.order;

import com.fenghua.auto.backend.domain.DomainObject;
import java.math.BigDecimal;
import java.util.Date;

public class OrderItem implements DomainObject {
	private static final long serialVersionUID = 1L;
    private Long id;

    private Long orderId;

    private Long sellerId;

    private Long buyerId;

    private Long skuId;

    private String skuCode;

    private String skuName;

    private BigDecimal originalPrice;

    private BigDecimal salePrice;

    private BigDecimal tradePrice;

    private Integer qty;

    private Integer status;

    private Integer forkStatus;

    private String note;

    private Integer evaluatedFlag;

    private Date evaluatedTime;

    private Long entryId;

    private Date entryDate;

    private Long editId;

    private Date editDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode == null ? null : skuCode.trim();
    }

    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName == null ? null : skuName.trim();
    }

    public BigDecimal getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(BigDecimal originalPrice) {
        this.originalPrice = originalPrice;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public BigDecimal getTradePrice() {
        return tradePrice;
    }

    public void setTradePrice(BigDecimal tradePrice) {
        this.tradePrice = tradePrice;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getForkStatus() {
        return forkStatus;
    }

    public void setForkStatus(Integer forkStatus) {
        this.forkStatus = forkStatus;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public Integer getEvaluatedFlag() {
        return evaluatedFlag;
    }

    public void setEvaluatedFlag(Integer evaluatedFlag) {
        this.evaluatedFlag = evaluatedFlag;
    }

    public Date getEvaluatedTime() {
        return evaluatedTime;
    }

    public void setEvaluatedTime(Date evaluatedTime) {
        this.evaluatedTime = evaluatedTime;
    }

    public Long getEntryId() {
        return entryId;
    }

    public void setEntryId(Long entryId) {
        this.entryId = entryId;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public Long getEditId() {
        return editId;
    }

    public void setEditId(Long editId) {
        this.editId = editId;
    }

    public Date getEditDate() {
        return editDate;
    }

    public void setEditDate(Date editDate) {
        this.editDate = editDate;
    }
}