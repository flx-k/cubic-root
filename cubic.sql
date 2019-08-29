/*
Navicat MySQL Data Transfer

Source Server         : my
Source Server Version : 50720
Source Host           : 139.199.36.234:3306
Source Database       : cubic

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2019-08-29 14:00:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `account`
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `id` varchar(255) NOT NULL,
  `name` varchar(64) NOT NULL,
  `level` int(2) NOT NULL,
  `pwd` varchar(255) NOT NULL,
  `auths` varchar(255) NOT NULL,
  `expired` tinyint(1) NOT NULL,
  `locked` tinyint(1) NOT NULL,
  `credentials_expired` tinyint(1) NOT NULL,
  `enable` tinyint(1) NOT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `last_online_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('admin', 'admin', '1', '$2a$10$00eaHpCgP/YVEHJN.X0cT.zccd8luwtcuzqEeoAYr5nBCV9eAAuH6', 'user', '0', '0', '0', '1', '2019-08-29 13:35:37', '2019-08-29 13:35:39');

-- ----------------------------
-- Table structure for `download_load`
-- ----------------------------
DROP TABLE IF EXISTS `download_load`;
CREATE TABLE `download_load` (
  `id` varchar(255) NOT NULL,
  `account_id` varchar(255) NOT NULL,
  `account_name` varchar(255) NOT NULL,
  `project_id` varchar(255) NOT NULL,
  `project_name` varchar(255) NOT NULL,
  `download_times` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of download_load
-- ----------------------------

-- ----------------------------
-- Table structure for `project`
-- ----------------------------
DROP TABLE IF EXISTS `project`;
CREATE TABLE `project` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `desc` text,
  `type` varchar(255) DEFAULT NULL,
  `download_count` int(11) NOT NULL,
  `upload_time` timestamp NULL DEFAULT NULL,
  `account_id` varchar(255) NOT NULL,
  `account_name` varchar(255) NOT NULL,
  `path` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of project
-- ----------------------------

-- ----------------------------
-- Table structure for `test`
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of test
-- ----------------------------
INSERT INTO `test` VALUES ('18a65bad-9e4b-44b0-a264-604a68d6824e', 'user');
INSERT INTO `test` VALUES ('6e8be6a6-4554-492a-bfa5-b626285d7194', 'user2');
INSERT INTO `test` VALUES ('754a8ec1-2ef8-4120-abd7-2ffce9173ac7', 'asdasda');
INSERT INTO `test` VALUES ('8521308d-94a7-435c-b504-f719b55fa108', 'asdasda');
INSERT INTO `test` VALUES ('944cb69c-2337-429a-8e97-bdce11ef2f9e', 'asdasda');
INSERT INTO `test` VALUES ('admin', 'admin');
INSERT INTO `test` VALUES ('aea40727-ba52-4fa1-a435-c10f51488936', 'user22');
