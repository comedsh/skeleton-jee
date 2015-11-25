/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50626
Source Host           : localhost:3306
Source Database       : auto007db

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2015-11-25 13:29:32
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for catalog
-- ----------------------------
DROP TABLE IF EXISTS `catalog`;
CREATE TABLE `catalog` (
  `id` bigint(20) NOT NULL,
  `code` varchar(20) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `sort_no` int(11) DEFAULT NULL,
  `remark` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `AK_code` (`code`),
  KEY `FK_fk_pid` (`parent_id`),
  CONSTRAINT `FK_fk_pid` FOREIGN KEY (`parent_id`) REFERENCES `catalog` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of catalog
-- ----------------------------

-- ----------------------------
-- Table structure for catalog_attribute
-- ----------------------------
DROP TABLE IF EXISTS `catalog_attribute`;
CREATE TABLE `catalog_attribute` (
  `id` bigint(20) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `catalog_id` bigint(20) DEFAULT NULL,
  `s_no` int(11) DEFAULT NULL,
  `remark` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_catalog_attr` (`catalog_id`),
  CONSTRAINT `FK_catalog_attr` FOREIGN KEY (`catalog_id`) REFERENCES `catalog` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of catalog_attribute
-- ----------------------------

-- ----------------------------
-- Table structure for catalog_sku
-- ----------------------------
DROP TABLE IF EXISTS `catalog_sku`;
CREATE TABLE `catalog_sku` (
  `catalog_id` bigint(20) DEFAULT NULL,
  `sku_id` bigint(20) DEFAULT NULL,
  KEY `FK_Reference_21` (`sku_id`),
  KEY `FK_Reference_23` (`catalog_id`),
  CONSTRAINT `FK_Reference_21` FOREIGN KEY (`sku_id`) REFERENCES `sku` (`id`),
  CONSTRAINT `FK_Reference_23` FOREIGN KEY (`catalog_id`) REFERENCES `catalog` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of catalog_sku
-- ----------------------------

-- ----------------------------
-- Table structure for city
-- ----------------------------
DROP TABLE IF EXISTS `city`;
CREATE TABLE `city` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of city
-- ----------------------------

-- ----------------------------
-- Table structure for price_strategy
-- ----------------------------
DROP TABLE IF EXISTS `price_strategy`;
CREATE TABLE `price_strategy` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `start_time` datetime DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  `amount` int(11) DEFAULT NULL,
  `discount` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of price_strategy
-- ----------------------------

-- ----------------------------
-- Table structure for repertory
-- ----------------------------
DROP TABLE IF EXISTS `repertory`;
CREATE TABLE `repertory` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `saller_id` bigint(20) DEFAULT NULL,
  `name` int(11) DEFAULT NULL,
  `address` int(11) DEFAULT NULL,
  `area` int(11) DEFAULT NULL,
  `city_region_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Relationship_18` (`city_region_id`),
  KEY `FK_Relationship_24` (`saller_id`),
  CONSTRAINT `FK_Relationship_18` FOREIGN KEY (`city_region_id`) REFERENCES `city` (`id`),
  CONSTRAINT `FK_Relationship_24` FOREIGN KEY (`saller_id`) REFERENCES `seller` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of repertory
-- ----------------------------

-- ----------------------------
-- Table structure for sale_area
-- ----------------------------
DROP TABLE IF EXISTS `sale_area`;
CREATE TABLE `sale_area` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sale_id` bigint(20) NOT NULL,
  `type` int(11) DEFAULT NULL COMMENT '1.包含， 2 不包含',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sale_area
-- ----------------------------

-- ----------------------------
-- Table structure for seller
-- ----------------------------
DROP TABLE IF EXISTS `seller`;
CREATE TABLE `seller` (
  `id` bigint(20) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `code` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of seller
-- ----------------------------
INSERT INTO `seller` VALUES ('1', '新疆丰华神州', 'S1001');

-- ----------------------------
-- Table structure for sku
-- ----------------------------
DROP TABLE IF EXISTS `sku`;
CREATE TABLE `sku` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(20) NOT NULL,
  `seller_id` bigint(20) NOT NULL,
  `name` varchar(200) DEFAULT NULL,
  `title` varchar(200) DEFAULT NULL,
  `url` text COMMENT '商品缩略图',
  `introduce` text,
  `status` bit(1) DEFAULT NULL COMMENT '1,待上架，2.已上架 3。已下架，默认 待上架',
  `type` bit(1) DEFAULT NULL COMMENT '1.品牌件 , 2 原厂件',
  `shelf_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `under_time` datetime DEFAULT NULL,
  `produce_time` date DEFAULT NULL,
  `down_time` date DEFAULT NULL,
  `min_quantity` int(11) DEFAULT NULL,
  `gross_weight` double(7,2) DEFAULT NULL,
  `weight` double(7,2) DEFAULT NULL,
  `unit` varchar(10) DEFAULT NULL COMMENT '件，台，支,个',
  `brand` varchar(100) DEFAULT NULL,
  `score` int(11) DEFAULT NULL,
  `supplier_id` bigint(20) DEFAULT NULL,
  `price` decimal(9,4) DEFAULT NULL,
  `sale_price` decimal(9,4) DEFAULT NULL,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `AK_Key_2` (`code`,`seller_id`),
  KEY `FK_Reference_24` (`seller_id`),
  KEY `FK_Reference_25` (`supplier_id`),
  CONSTRAINT `FK_Reference_24` FOREIGN KEY (`seller_id`) REFERENCES `seller` (`id`),
  CONSTRAINT `FK_Reference_25` FOREIGN KEY (`supplier_id`) REFERENCES `supplier` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sku
-- ----------------------------
INSERT INTO `sku` VALUES ('1', 'S001', '1', '火花塞 铂金', '火花塞 铂金 10KG', null, null, '', '', '2015-11-24 16:50:50', null, null, null, '10', null, null, '只', '日产', '0', null, '100.0500', '99.9000', '2015-11-24 16:50:50', null);
INSERT INTO `sku` VALUES ('2', 'S002', '1', '火花塞 普通', '火花塞 普通 100KG', null, null, null, '', '2015-11-24 16:50:50', null, null, null, '10', null, null, '只', '日产', '0', null, '100.0500', '99.9000', '2015-11-24 16:50:50', null);

-- ----------------------------
-- Table structure for sku_catalog_attr_value
-- ----------------------------
DROP TABLE IF EXISTS `sku_catalog_attr_value`;
CREATE TABLE `sku_catalog_attr_value` (
  `id` bigint(20) NOT NULL,
  `catalog_attr_id` bigint(20) DEFAULT NULL,
  `sttr_value` varchar(100) DEFAULT NULL,
  `sku_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Reference_22` (`catalog_attr_id`),
  KEY `FK_Relationship_2` (`sku_id`),
  CONSTRAINT `FK_Reference_22` FOREIGN KEY (`catalog_attr_id`) REFERENCES `catalog_attribute` (`id`),
  CONSTRAINT `FK_Relationship_2` FOREIGN KEY (`sku_id`) REFERENCES `sku` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sku_catalog_attr_value
-- ----------------------------

-- ----------------------------
-- Table structure for sku_comment
-- ----------------------------
DROP TABLE IF EXISTS `sku_comment`;
CREATE TABLE `sku_comment` (
  `id` bigint(20) NOT NULL,
  `sku_id` bigint(20) DEFAULT NULL,
  `order_id` bigint(20) DEFAULT NULL,
  `order_detail_id` bigint(20) DEFAULT NULL,
  `star` bit(1) DEFAULT NULL COMMENT '1到5个星，>=4,好评  ，3< 差评，3 中评',
  `comtent` text,
  `user_id` varchar(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `status` int(11) DEFAULT '1' COMMENT '1 显示，2不显示，默认显示',
  `comment_origin` bit(1) DEFAULT NULL COMMENT '0, pc ,1.android 2. iphone  ;',
  PRIMARY KEY (`id`),
  KEY `FK_Relationship_5` (`sku_id`),
  CONSTRAINT `FK_Relationship_5` FOREIGN KEY (`sku_id`) REFERENCES `sku` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sku_comment
-- ----------------------------
INSERT INTO `sku_comment` VALUES ('1', '1', null, null, '', '第一个商品', '1', '2015-11-24 17:04:31', '1', '');

-- ----------------------------
-- Table structure for sku_extend_attrs
-- ----------------------------
DROP TABLE IF EXISTS `sku_extend_attrs`;
CREATE TABLE `sku_extend_attrs` (
  `id` bigint(20) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `contents` varchar(100) DEFAULT NULL,
  `sort_no` int(11) DEFAULT NULL,
  `sku_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Reference_18` (`sku_id`),
  CONSTRAINT `FK_Reference_18` FOREIGN KEY (`sku_id`) REFERENCES `sku` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sku_extend_attrs
-- ----------------------------

-- ----------------------------
-- Table structure for sku_images
-- ----------------------------
DROP TABLE IF EXISTS `sku_images`;
CREATE TABLE `sku_images` (
  `id` bigint(20) NOT NULL,
  `url` text,
  `title` char(100) DEFAULT NULL,
  `sort_no` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime DEFAULT NULL,
  `sku_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Reference_19` (`sku_id`),
  CONSTRAINT `FK_Reference_19` FOREIGN KEY (`sku_id`) REFERENCES `sku` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sku_images
-- ----------------------------

-- ----------------------------
-- Table structure for sku_image_html
-- ----------------------------
DROP TABLE IF EXISTS `sku_image_html`;
CREATE TABLE `sku_image_html` (
  `id` bigint(20) NOT NULL,
  `contents_html` text,
  `sku_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Reference_16` (`sku_id`),
  CONSTRAINT `FK_Reference_16` FOREIGN KEY (`sku_id`) REFERENCES `sku` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sku_image_html
-- ----------------------------

-- ----------------------------
-- Table structure for sku_reply
-- ----------------------------
DROP TABLE IF EXISTS `sku_reply`;
CREATE TABLE `sku_reply` (
  `id` bigint(20) NOT NULL,
  `reply_code` varchar(20) DEFAULT NULL,
  `comtent` text,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `user_id` char(20) DEFAULT NULL,
  `sku_comment_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Relationship_28` (`sku_comment_id`),
  CONSTRAINT `FK_Relationship_28` FOREIGN KEY (`sku_comment_id`) REFERENCES `sku_comment` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sku_reply
-- ----------------------------

-- ----------------------------
-- Table structure for sku_stock
-- ----------------------------
DROP TABLE IF EXISTS `sku_stock`;
CREATE TABLE `sku_stock` (
  `id` bigint(20) NOT NULL,
  `stock_count` int(11) DEFAULT NULL,
  `stock_availability` int(11) DEFAULT NULL,
  `repertory_id` bigint(20) DEFAULT NULL,
  `sku_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Reference_17` (`repertory_id`),
  KEY `FK_Reference_27` (`sku_id`),
  CONSTRAINT `FK_Reference_17` FOREIGN KEY (`repertory_id`) REFERENCES `repertory` (`id`),
  CONSTRAINT `FK_Reference_27` FOREIGN KEY (`sku_id`) REFERENCES `sku` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sku_stock
-- ----------------------------
INSERT INTO `sku_stock` VALUES ('1', '1000', '900', null, '1');

-- ----------------------------
-- Table structure for stock_lock
-- ----------------------------
DROP TABLE IF EXISTS `stock_lock`;
CREATE TABLE `stock_lock` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_id` bigint(20) DEFAULT NULL,
  `sku_id` bigint(20) DEFAULT NULL,
  `stock_id` bigint(20) DEFAULT NULL,
  `nums` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stock_lock
-- ----------------------------

-- ----------------------------
-- Table structure for supplier
-- ----------------------------
DROP TABLE IF EXISTS `supplier`;
CREATE TABLE `supplier` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(20) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `fax` varchar(15) DEFAULT NULL,
  `telephone` varchar(15) DEFAULT NULL,
  `mobile_phone` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `supplier_code` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of supplier
-- ----------------------------

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_order
-- ----------------------------

-- ----------------------------
-- Table structure for vehicle_oe_sku
-- ----------------------------
DROP TABLE IF EXISTS `vehicle_oe_sku`;
CREATE TABLE `vehicle_oe_sku` (
  `id` bigint(20) NOT NULL,
  `oe_code` varchar(50) DEFAULT NULL,
  `vehicle_id` bigint(20) DEFAULT NULL,
  `vehicle_name` varchar(100) DEFAULT NULL,
  `brand` varchar(20) DEFAULT NULL,
  `engine` varchar(20) DEFAULT NULL,
  `period` varchar(20) DEFAULT NULL,
  `output_value` varchar(10) DEFAULT NULL,
  `sku_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Reference_20` (`sku_id`),
  CONSTRAINT `FK_Reference_20` FOREIGN KEY (`sku_id`) REFERENCES `sku` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of vehicle_oe_sku
-- ----------------------------

-- ----------------------------
-- Table structure for 系统
-- ----------------------------
DROP TABLE IF EXISTS `系统`;
CREATE TABLE `系统` (
  `id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 系统
-- ----------------------------
