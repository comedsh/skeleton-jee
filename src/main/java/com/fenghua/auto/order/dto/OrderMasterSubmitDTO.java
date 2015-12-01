/**
 * 
 */
package com.fenghua.auto.order.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.fenghua.auto.backend.domain.user.PaymentType;
import com.fenghua.auto.backend.domain.user.UserAddress;
import com.fenghua.auto.order.domain.OrderInvoice;

/**
 * 
 * @author zhiyuan.wang@auto007.com
 *
 */
public class OrderMasterSubmitDTO implements Serializable {

	private static final long serialVersionUID = 2263634449096339797L;
	
	private Long buyerId;

    private BigDecimal totalAmount;

    private BigDecimal discountAmount;

    private BigDecimal transportAmount;

    private BigDecimal needPayAmount;

	private UserAddress address;
	
	private PaymentType paymentType;
	
	private OrderInvoice orderInvoice;
	
	private List<OrderHeaderSubmitDTO> orderHeaders;
	
	private List<UserAddress> addressList;
	
	private List<PaymentType> paymentTypeList;

	public Long getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(Long buyerId) {
		this.buyerId = buyerId;
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

	public BigDecimal getTransportAmount() {
		return transportAmount;
	}

	public void setTransportAmount(BigDecimal transportAmount) {
		this.transportAmount = transportAmount;
	}

	public BigDecimal getNeedPayAmount() {
		return needPayAmount;
	}

	public void setNeedPayAmount(BigDecimal needPayAmount) {
		this.needPayAmount = needPayAmount;
	}

	public UserAddress getAddress() {
		return address;
	}

	public void setAddress(UserAddress address) {
		this.address = address;
	}

	public PaymentType getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}

	public OrderInvoice getOrderInvoice() {
		return orderInvoice;
	}

	public void setOrderInvoice(OrderInvoice orderInvoice) {
		this.orderInvoice = orderInvoice;
	}

	public List<OrderHeaderSubmitDTO> getOrderHeaders() {
		return orderHeaders;
	}

	public void setOrderHeaders(List<OrderHeaderSubmitDTO> orderHeaders) {
		this.orderHeaders = orderHeaders;
	}
	
	public void addOrderHeader(OrderHeaderSubmitDTO header) {
		if(this.orderHeaders == null) {
			this.orderHeaders = new ArrayList<OrderHeaderSubmitDTO>();
		}
		this.orderHeaders.add(header);
	}

	public List<UserAddress> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<UserAddress> addressList) {
		this.addressList = addressList;
	}

	public List<PaymentType> getPaymentTypeList() {
		return paymentTypeList;
	}

	public void setPaymentTypeList(List<PaymentType> paymentTypeList) {
		this.paymentTypeList = paymentTypeList;
	}
}
