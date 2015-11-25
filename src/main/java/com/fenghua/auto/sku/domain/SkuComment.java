package com.fenghua.auto.sku.domain;

import java.util.Date;

import com.fenghua.auto.backend.domain.DomainObject;

public class SkuComment implements DomainObject{
    private Long id;

    private Long skuId;

    private Long orderId;

    private Long orderDetailId;

    private Boolean star;

    private String userId;

    private Date createTime;

    private Integer status;

    private Boolean commentOrigin;

    private String comtent;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(Long orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public Boolean getStar() {
        return star;
    }

    public void setStar(Boolean star) {
        this.star = star;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Boolean getCommentOrigin() {
        return commentOrigin;
    }

    public void setCommentOrigin(Boolean commentOrigin) {
        this.commentOrigin = commentOrigin;
    }

    public String getComtent() {
        return comtent;
    }

    public void setComtent(String comtent) {
        this.comtent = comtent == null ? null : comtent.trim();
    }
}