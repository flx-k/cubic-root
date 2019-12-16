/*
Navicat MySQL Data Transfer

Source Server         : localhost_33061
Source Server Version : 50140
Source Host           : localhost:3306
Source Database       : cubic

Target Server Type    : MYSQL
Target Server Version : 50140
File Encoding         : 65001

Date: 2019-12-16 17:44:27
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
INSERT INTO `account` VALUES ('USER_46339c52-85c0-47ec-b10a-486462cc1b44', 'flx', '1', 'USER', '0', '0', '0', '1', '2019-12-06 17:47:00', '2019-12-06 17:47:00');
INSERT INTO `account` VALUES ('USER_986dd530-614a-4e01-a8c6-507613dfc9b1', 'admin', '1', 'USER', '0', '0', '0', '1', '2019-12-09 15:34:08', '2019-12-09 15:34:08');

-- ----------------------------
-- Table structure for `account_password`
-- ----------------------------
DROP TABLE IF EXISTS `account_password`;
CREATE TABLE `account_password` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `pwd` varchar(255) NOT NULL,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account_password
-- ----------------------------
INSERT INTO `account_password` VALUES ('USER_46339c52-85c0-47ec-b10a-486462cc1b44', 'flx', '$2a$10$ScVirX/HNBAr9weXuEbWTuN/4KPTkutb5oa6i3qPgxu.ON6C51dtS', '2019-12-06 17:47:00');
INSERT INTO `account_password` VALUES ('USER_986dd530-614a-4e01-a8c6-507613dfc9b1', 'admin', '$2a$10$q8jCUkAwpmget7Xy6OsUhekpyB2Ug4MLeW6O63B0cxf9Pf6YTBcu2', '2019-12-09 15:34:08');

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
-- Table structure for `groups`
-- ----------------------------
DROP TABLE IF EXISTS `groups`;
CREATE TABLE `groups` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `desc` varchar(255) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of groups
-- ----------------------------
INSERT INTO `groups` VALUES ('GROUP_052ed7eb-2520-45dd-9343-53e1619192ca', 'gasd', null, '2019-12-06 17:59:51');
INSERT INTO `groups` VALUES ('GROUP_d0b37bf4-9758-4c5a-b1ad-ce1a60431f03', 'dudud', null, '2019-12-09 15:41:49');

-- ----------------------------
-- Table structure for `group_member`
-- ----------------------------
DROP TABLE IF EXISTS `group_member`;
CREATE TABLE `group_member` (
  `id` varchar(255) NOT NULL,
  `group_id` varchar(255) NOT NULL,
  `member_id` varchar(255) NOT NULL,
  `join_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of group_member
-- ----------------------------
INSERT INTO `group_member` VALUES ('GROUPMEMBER_11902fc0-b7ed-406b-841f-56c8647e8a9a', 'GROUP_d0b37bf4-9758-4c5a-b1ad-ce1a60431f03', 'USER_46339c52-85c0-47ec-b10a-486462cc1b44', '2019-12-09 15:49:43');
INSERT INTO `group_member` VALUES ('GROUPMEMBER_77b31087-d8e2-4977-984f-9b32a9311080', 'GROUP_d0b37bf4-9758-4c5a-b1ad-ce1a60431f03', 'USER_986dd530-614a-4e01-a8c6-507613dfc9b1', '2019-12-09 17:53:43');
INSERT INTO `group_member` VALUES ('GROUPMEMBER_994c434d-1d33-4dbe-98f4-bb85394b8451', 'GROUP_052ed7eb-2520-45dd-9343-53e1619192ca', 'USER_986dd530-614a-4e01-a8c6-507613dfc9b1', '2019-12-09 15:48:37');

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
