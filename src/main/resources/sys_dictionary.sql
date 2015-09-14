/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50626
Source Host           : localhost:3306
Source Database       : ssr3

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2015-09-06 09:48:28
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `sys_dictionary`
-- ----------------------------
DROP TABLE IF EXISTS `sys_dictionary`;
CREATE TABLE `sys_dictionary` (
  `dic_id` varchar(255) NOT NULL DEFAULT '',
  `dic_name` varchar(255) DEFAULT NULL,
  `dic_value` varchar(255) DEFAULT NULL,
  `dic_group` varchar(255) DEFAULT NULL,
  `dic_type` varchar(255) DEFAULT NULL,
  `dic_order` int(11) DEFAULT NULL,
  `dic_status` varchar(255) DEFAULT NULL,
  `dic_parent_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`dic_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_dictionary
-- ----------------------------
