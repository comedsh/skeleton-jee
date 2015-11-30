/**
 * 
 */
package com.fenghua.auto.order;

import java.util.HashMap;
import java.util.Map;

/**
 * 订单模块常量类
 * 
 * @author zhiyuan.wang@auto007.com
 *
 */

public final class OrderConstants {

	public static enum OrderMasterStatus {
		NEW(0, "新建"), 
		WAIT_PAY(10, "待支付"), 
		WAIT_AUDIT(15, "待审核"), 
		PAYED(20, "已支付"),
		AUDIT_OK(25, "审核通过"), 
		SPLITED(30, "已拆分"),
		
		CANCEL(-10, "已取消"),
		AUDIT_REJECT(-20, "审核拒绝");

		private final int value;
		private final String name;

		private OrderMasterStatus(int value, String name) {
			this.value = value;
			this.name = name;
		}

		public int getValue() {
			return value;
		}

		public String getName() {
			return name;
		}

		public static String findName(int value) {
			for (OrderMasterStatus item : OrderMasterStatus.values()) {
				if(item.getValue() == value) {
					return item.getName();
				}
			}
			return "";
		}
		public static Map<Integer, String> toMap() {
			Map<Integer, String> map = new HashMap<Integer, String>();
			for (OrderMasterStatus item : OrderMasterStatus.values()) {
				map.put(item.getValue(), item.getName());
			}
			return map;
		}
	}
	
	public static enum OrderHeaderStatus {
		NEW(0, "新建"), 
		WAIT_PAY(10, "待支付"), 
		WAIT_AUDIT(15, "待审核"), 
		PAYED(20, "已支付"),
		AUDIT_OK(25, "审核通过"), 
		
		SPLITED(30, "待发货"),
		
		WAIT_REC(40, "待收货"),
		
		DONE(50, "已完成"),
		
		CANCEL(-10, "已取消"),
		AUDIT_REJECT(-20, "审核拒绝");

		private final int value;
		private final String name;

		private OrderHeaderStatus(int value, String name) {
			this.value = value;
			this.name = name;
		}

		public int getValue() {
			return value;
		}

		public String getName() {
			return name;
		}

		public static String findName(int value) {
			for (OrderHeaderStatus item : OrderHeaderStatus.values()) {
				if(item.getValue() == value) {
					return item.getName();
				}
			}
			return "";
		}
		public static Map<Integer, String> toMap() {
			Map<Integer, String> map = new HashMap<Integer, String>();
			for (OrderHeaderStatus item : OrderHeaderStatus.values()) {
				map.put(item.getValue(), item.getName());
			}
			return map;
		}
	}
	public static enum OrderHeaderForkStatus {
		CANCEL_HANDLING(10, "取消处理中"), 
		REFUND_HANDLING(20, "退款处理中"), 
		RETURN_HANDLING(30, "退换货处理中"), 
		
		CANCELLED(-10, "已取消"),
		REFUNDED(-20, "已退款"), 
		
		PART_RETURNED(-30, "已部分退货"),
		RETURNED(-35, "已退货");

		private final int value;
		private final String name;

		private OrderHeaderForkStatus(int value, String name) {
			this.value = value;
			this.name = name;
		}

		public int getValue() {
			return value;
		}

		public String getName() {
			return name;
		}

		public static String findName(int value) {
			for (OrderHeaderForkStatus item : OrderHeaderForkStatus.values()) {
				if(item.getValue() == value) {
					return item.getName();
				}
			}
			return "";
		}
		public static Map<Integer, String> toMap() {
			Map<Integer, String> map = new HashMap<Integer, String>();
			for (OrderHeaderForkStatus item : OrderHeaderForkStatus.values()) {
				map.put(item.getValue(), item.getName());
			}
			return map;
		}
	}
	
	public static enum OrderDetailStatus {
		NORMAL(1, "正常"), 
		
		PART_RETURNED(-30, "已部分退货"),
		RETURNED(-35, "已退货");

		private final int value;
		private final String name;

		private OrderDetailStatus(int value, String name) {
			this.value = value;
			this.name = name;
		}

		public int getValue() {
			return value;
		}

		public String getName() {
			return name;
		}

		public static String findName(int value) {
			for (OrderDetailStatus item : OrderDetailStatus.values()) {
				if(item.getValue() == value) {
					return item.getName();
				}
			}
			return "";
		}
		public static Map<Integer, String> toMap() {
			Map<Integer, String> map = new HashMap<Integer, String>();
			for (OrderDetailStatus item : OrderDetailStatus.values()) {
				map.put(item.getValue(), item.getName());
			}
			return map;
		}
	}
	
	public static enum OrderDetailForkStatus {
		RETURN_HANDLING(30, "退换货处理中"), 
		
		PART_RETURNED(-30, "已部分退货"),
		RETURNED(-35, "已退货");

		private final int value;
		private final String name;

		private OrderDetailForkStatus(int value, String name) {
			this.value = value;
			this.name = name;
		}

		public int getValue() {
			return value;
		}

		public String getName() {
			return name;
		}

		public static String findName(int value) {
			for (OrderDetailForkStatus item : OrderDetailForkStatus.values()) {
				if(item.getValue() == value) {
					return item.getName();
				}
			}
			return "";
		}
		public static Map<Integer, String> toMap() {
			Map<Integer, String> map = new HashMap<Integer, String>();
			for (OrderDetailForkStatus item : OrderDetailForkStatus.values()) {
				map.put(item.getValue(), item.getName());
			}
			return map;
		}
	}
}
