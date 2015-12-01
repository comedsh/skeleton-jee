package com.fenghua.auto.order.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author zhiyuan.wang@auto007.com
 *
 */

public class OrderHeaderSubmitDTO implements Serializable {

	private static final long serialVersionUID = 7087623229639728262L;

    private Long buyerId;

    private Long sellerId;

    private BigDecimal totalAmount;

    private BigDecimal discountAmount;

    private BigDecimal needPayAmount;

    private BigDecimal transportAmount;

    private Integer payMethod;

    private Integer deliveryMethod;

    private String receiver;

    private String receiverPhone;

    private String receiverIdcard;

    private String receiverAddress;

    private Integer invoiceFlag;

    private Integer comeFrom;

    private String remark;
	
	private List<OrderItemSubmitDTO> items;

	public List<OrderItemSubmitDTO> getItems() {
		return items;
	}

	public void setItems(List<OrderItemSubmitDTO> items) {
		this.items = items;
	}
	
	public void addItem(OrderItemSubmitDTO item) {
		if(this.items == null) {
			this.items = new ArrayList<OrderItemSubmitDTO>();
		}
		this.items.add(item);
	}

	public Long getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(Long buyerId) {
		this.buyerId = buyerId;
	}

	public Long getSellerId() {
		return sellerId;
	}

	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public BigDecimal getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(BigDecimal discountAmount) {
		this.discountAmount = discountAmount;
	}

	public BigDecimal getNeedPayAmount() {
		return needPayAmount;
	}

	public void setNeedPayAmount(BigDecimal needPayAmount) {
		this.needPayAmount = needPayAmount;
	}

	public BigDecimal getTransportAmount() {
		return transportAmount;
	}

	public void setTransportAmount(BigDecimal transportAmount) {
		this.transportAmount = transportAmount;
	}

	public Integer getPayMethod() {
		return payMethod;
	}

	public void setPayMethod(Integer payMethod) {
		this.payMethod = payMethod;
	}

	public Integer getDeliveryMethod() {
		return deliveryMethod;
	}

	public void setDeliveryMethod(Integer deliveryMethod) {
		this.deliveryMethod = deliveryMethod;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getReceiverPhone() {
		return receiverPhone;
	}

	public void setReceiverPhone(String receiverPhone) {
		this.receiverPhone = receiverPhone;
	}

	public String getReceiverIdcard() {
		return receiverIdcard;
	}

	public void setReceiverIdcard(String receiverIdcard) {
		this.receiverIdcard = receiverIdcard;
	}

	public String getReceiverAddress() {
		return receiverAddress;
	}

	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
	}

	public Integer getInvoiceFlag() {
		return invoiceFlag;
	}

	public void setInvoiceFlag(Integer invoiceFlag) {
		this.invoiceFlag = invoiceFlag;
	}

	public Integer getComeFrom() {
		return comeFrom;
	}

	public void setComeFrom(Integer comeFrom) {
		this.comeFrom = comeFrom;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
