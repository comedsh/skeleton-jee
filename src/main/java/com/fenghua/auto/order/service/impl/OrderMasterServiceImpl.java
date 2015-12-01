/**
 * 
 */
package com.fenghua.auto.order.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fenghua.auto.backend.dao.BaseDao;
import com.fenghua.auto.backend.domain.user.PaymentType;
import com.fenghua.auto.backend.domain.user.UserAddress;
import com.fenghua.auto.backend.service.impl.BaseServiceImpl;
import com.fenghua.auto.backend.service.user.PaymentTypeService;
import com.fenghua.auto.backend.service.user.UserAddressService;
import com.fenghua.auto.order.dao.OrderMasterDao;
import com.fenghua.auto.order.domain.OrderMaster;
import com.fenghua.auto.order.domain.ShoppingCart;
import com.fenghua.auto.order.dto.OrderHeaderSubmitDTO;
import com.fenghua.auto.order.dto.OrderItemSubmitDTO;
import com.fenghua.auto.order.dto.OrderMasterResultDTO;
import com.fenghua.auto.order.dto.OrderMasterSubmitDTO;
import com.fenghua.auto.order.service.OrderMasterService;
import com.fenghua.auto.sku.domain.Sku;
import com.fenghua.auto.sku.service.SkuService;

/**
 * Service实现类
 *
 * @author 王直元
 * @createTime 2015-11-25 11:11:35
 *
 */
@Service
public class OrderMasterServiceImpl extends BaseServiceImpl<OrderMaster> implements OrderMasterService {

	@Autowired
	private OrderMasterDao dao;
	@Autowired
	private SkuService skuService;
	@Autowired
	private UserAddressService userAddressService;
	@Autowired
	private PaymentTypeService paymentTypeService;
	
	
	@Override
	protected BaseDao<OrderMaster> getBaseDao() {
		return dao;
	}

	@Override
	public OrderMasterSubmitDTO initSubmit(List<ShoppingCart> shoppingCarts, Long buyerId) {
		OrderMasterSubmitDTO dto = new OrderMasterSubmitDTO();
		
		//地址信息
		UserAddress userAddrQuery = new UserAddress();
		userAddrQuery.setUserId(buyerId);
		UserAddress defaultAddress = null;
		List<UserAddress> userAddrList = userAddressService.selectList(userAddrQuery);
		if(userAddrList != null && !userAddrList.isEmpty()) {
			for (UserAddress userAddress : userAddrList) {
				if(userAddress.getDefaultAddr().booleanValue()) {
					defaultAddress = userAddress;
					break;
				}
			}
			if(defaultAddress == null) {
				defaultAddress = userAddrList.get(0);
			} else {
				userAddrList.remove(defaultAddress);
			}
		}
		dto.setAddress(defaultAddress);
		dto.setAddressList(userAddrList);
		
		List<PaymentType> paymentTypeList = paymentTypeService.selectAll();
		dto.setPaymentTypeList(paymentTypeList);
		//子订单信息
		dto.setOrderHeaders(initOrderHeader(buyerId, shoppingCarts));
		
		return dto;
	}

	private List<OrderHeaderSubmitDTO> initOrderHeader(Long buyerId, List<ShoppingCart> shoppingCarts) {
		Map<Long, List<ShoppingCart>> cartMap = new HashMap<Long, List<ShoppingCart>>();
		if(shoppingCarts != null && !shoppingCarts.isEmpty()) {
			for (ShoppingCart scart : shoppingCarts) {
//				Sku sku = skuService.selectById(scart.getSkuId());
//				scart.setSalePrice(sku.getSalePrice());
//				scart.setCurrentPrice(sku.getSalePrice());
//				scart.setOriginalPrice(sku.getPrice());
				if(!cartMap.containsKey(scart.getSellerId())) {
					cartMap.put(scart.getSellerId(), new ArrayList<ShoppingCart>());
				}
				cartMap.get(scart.getSellerId()).add(scart);
			}
		}
		List<OrderHeaderSubmitDTO> ohList = new ArrayList<OrderHeaderSubmitDTO>();
		for (Long sellerId : cartMap.keySet()) {
			//TODO: 调用价格策略计算价格  sellerId，cartMap.get(sellerId)
			//TODO: 调用库存中心check库存 sellerId，cartMap.get(sellerId)
			
			BigDecimal totalAmount = new BigDecimal(0);
			BigDecimal discountAmount = new BigDecimal(0);
			BigDecimal needPayAmount = new BigDecimal(0);
			
			OrderHeaderSubmitDTO orderHeader = new OrderHeaderSubmitDTO();
			orderHeader.setSellerId(sellerId);
			orderHeader.setBuyerId(buyerId);
			List<ShoppingCart> scartList = cartMap.get(sellerId);
			for (ShoppingCart scart : scartList) {
				Sku sku = skuService.selectById(scart.getSkuId());
				OrderItemSubmitDTO item = new OrderItemSubmitDTO();
			    
			    item.setSkuId(scart.getSkuId());
			    item.setSkuCode(sku.getCode());
			    item.setSkuName(sku.getName());
			    item.setSkuIcon(sku.getUrl());
			    
			    item.setOriginalPrice(scart.getOriginalPrice());
			    item.setSalePrice(scart.getSalePrice());
			    item.setTradePrice(scart.getCurrentPrice());
			    item.setQty(scart.getQty());
			    totalAmount = totalAmount.add(scart.getCurrentPrice().multiply(new BigDecimal(scart.getQty())));
			    orderHeader.addItem(item);
			}
			needPayAmount = totalAmount.subtract(discountAmount);
			orderHeader.setTotalAmount(totalAmount);
			orderHeader.setDiscountAmount(discountAmount);
			orderHeader.setNeedPayAmount(needPayAmount);
			orderHeader.setTransportAmount(new BigDecimal(0.0));
			ohList.add(orderHeader);
		}
		
		return ohList;
	}
	
	@Override
	public List<OrderMasterResultDTO> submit(OrderMasterSubmitDTO submitDTO) {
		return null;
	}

}
