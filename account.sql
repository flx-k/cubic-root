/*
Navicat MySQL Data Transfer

Source Server         : my
Source Server Version : 50720
Source Host           : 139.199.36.234:3306
Source Database       : cubic

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2019-08-29 13:27:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `account`
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `id` varchar(255) NOT NULL,
  `name` varchar(64) NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `level` int(2) NOT NULL,
  `last_online_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `pwd` varchar(255) NOT NULL,
  `auths` varchar(255) NOT NULL,
  `expired` tinyint(1) NOT NULL,
  `locked` tinyint(1) NOT NULL,
  `credentials_expired` tinyint(1) NOT NULL,
  `enable` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('admin', 'admin', '2019-08-29 11:29:24', '1', '2019-08-29 11:29:27', '111111', 'admin', '0', '0', '0', '1');
