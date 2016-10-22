/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50631
Source Host           : localhost:3306
Source Database       : ipro

Target Server Type    : MYSQL
Target Server Version : 50631
File Encoding         : 65001

Date: 2016-10-23 00:16:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for system_jurisdiction
-- ----------------------------
DROP TABLE IF EXISTS `system_jurisdiction`;
CREATE TABLE `system_jurisdiction` (
  `jurisdiction_id` char(24) NOT NULL COMMENT '权限ID',
  `jurisdiction_name` varchar(20) NOT NULL COMMENT '权限名称',
  `jurisdiction_code` varchar(64) NOT NULL COMMENT '权限编码',
  `jurisdiction_descript` varchar(200) NOT NULL DEFAULT '' COMMENT '权限描述',
  PRIMARY KEY (`jurisdiction_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of system_jurisdiction
-- ----------------------------

-- ----------------------------
-- Table structure for system_jurisdiction_group
-- ----------------------------
DROP TABLE IF EXISTS `system_jurisdiction_group`;
CREATE TABLE `system_jurisdiction_group` (
  `group_id` char(24) NOT NULL COMMENT '权限组ID',
  `group_name` varchar(20) NOT NULL COMMENT '权限组名称',
  `group_descript` varchar(200) NOT NULL DEFAULT '' COMMENT '权限组描述',
  PRIMARY KEY (`group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of system_jurisdiction_group
-- ----------------------------

-- ----------------------------
-- Table structure for system_jurisdiction_group_rel
-- ----------------------------
DROP TABLE IF EXISTS `system_jurisdiction_group_rel`;
CREATE TABLE `system_jurisdiction_group_rel` (
  `group_id` char(24) NOT NULL COMMENT '权限组ID',
  `jurisdiction_id` char(24) NOT NULL COMMENT '权限ID',
  PRIMARY KEY (`group_id`,`jurisdiction_id`),
  UNIQUE KEY `group_jurisdiction_unique_key` (`group_id`,`jurisdiction_id`) USING BTREE,
  KEY `jurisdiction_id` (`jurisdiction_id`),
  CONSTRAINT `system_jurisdiction_group_rel_ibfk_1` FOREIGN KEY (`group_id`) REFERENCES `system_jurisdiction_group` (`group_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `system_jurisdiction_group_rel_ibfk_2` FOREIGN KEY (`jurisdiction_id`) REFERENCES `system_jurisdiction` (`jurisdiction_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of system_jurisdiction_group_rel
-- ----------------------------

-- ----------------------------
-- Table structure for system_jurisdiction_menu_rel
-- ----------------------------
DROP TABLE IF EXISTS `system_jurisdiction_menu_rel`;
CREATE TABLE `system_jurisdiction_menu_rel` (
  `jurisdiction_id` char(24) NOT NULL COMMENT '权限ID',
  `menu_id` char(24) NOT NULL COMMENT '菜单ID',
  PRIMARY KEY (`jurisdiction_id`,`menu_id`),
  UNIQUE KEY `jurisdiction_id` (`jurisdiction_id`,`menu_id`),
  KEY `system_jurisdiction_menu_rel_ibfk_2` (`menu_id`),
  CONSTRAINT `system_jurisdiction_menu_rel_ibfk_1` FOREIGN KEY (`jurisdiction_id`) REFERENCES `system_jurisdiction` (`jurisdiction_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `system_jurisdiction_menu_rel_ibfk_2` FOREIGN KEY (`menu_id`) REFERENCES `system_menu` (`menu_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of system_jurisdiction_menu_rel
-- ----------------------------

-- ----------------------------
-- Table structure for system_menu
-- ----------------------------
DROP TABLE IF EXISTS `system_menu`;
CREATE TABLE `system_menu` (
  `menu_id` char(24) NOT NULL COMMENT '菜单ID',
  `parent_menu_id` char(24) DEFAULT NULL COMMENT '父级',
  `menu_name` varchar(20) NOT NULL COMMENT '菜单名称',
  `menu_level` enum('level1','level2','level3') NOT NULL DEFAULT 'level1' COMMENT '菜单级别',
  `menu_address` varchar(200) NOT NULL DEFAULT '' COMMENT '菜单链接地址',
  `menu_status` enum('y','n') NOT NULL DEFAULT 'y' COMMENT '菜单有效性',
  `menu_sort_no` smallint(6) NOT NULL DEFAULT '10' COMMENT '排序字段',
  `menu_icon` varchar(100) NOT NULL DEFAULT 'fa fa-list' COMMENT '菜单图标',
  PRIMARY KEY (`menu_id`),
  KEY `parent_menu_id` (`parent_menu_id`),
  CONSTRAINT `system_menu_ibfk_1` FOREIGN KEY (`parent_menu_id`) REFERENCES `system_menu` (`menu_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of system_menu
-- ----------------------------
INSERT INTO `system_menu` VALUES ('5808e049d8c6f5724ffe9da7', null, '主页', 'level1', 'sys/menu', 'y', '1', 'fa fa-list');
INSERT INTO `system_menu` VALUES ('5808e049d8c6f5724ffe9da8', null, '一级菜单', 'level1', 'default', 'y', '2', 'fa fa-list');
INSERT INTO `system_menu` VALUES ('5808e049d8c6f5724ffe9da9', '5808e049d8c6f5724ffe9da8', '菜单管理', 'level2', 'default', 'y', '6', 'fa fa-list');
INSERT INTO `system_menu` VALUES ('5808e049d8c6f5724ffe9daa', '5808e049d8c6f5724ffe9da8', '二级菜单', 'level2', 'sys/upload', 'y', '4', 'fa fa-list');

-- ----------------------------
-- Table structure for system_role
-- ----------------------------
DROP TABLE IF EXISTS `system_role`;
CREATE TABLE `system_role` (
  `role_id` char(24) NOT NULL COMMENT '角色ID',
  `role_name` varchar(20) NOT NULL COMMENT '角色名称',
  `role_descript` varchar(200) NOT NULL DEFAULT '' COMMENT '角色说明',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of system_role
-- ----------------------------

-- ----------------------------
-- Table structure for system_role_jurisdiction_group_rel
-- ----------------------------
DROP TABLE IF EXISTS `system_role_jurisdiction_group_rel`;
CREATE TABLE `system_role_jurisdiction_group_rel` (
  `role_id` char(24) NOT NULL COMMENT '角色ID',
  `jurisdiction_group_id` char(24) NOT NULL COMMENT '权限组ID',
  PRIMARY KEY (`role_id`,`jurisdiction_group_id`),
  UNIQUE KEY `role_id` (`role_id`,`jurisdiction_group_id`) USING BTREE,
  KEY `jurisdiction_group_id` (`jurisdiction_group_id`),
  CONSTRAINT `system_role_jurisdiction_group_rel_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `system_role` (`role_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `system_role_jurisdiction_group_rel_ibfk_2` FOREIGN KEY (`jurisdiction_group_id`) REFERENCES `system_jurisdiction_group` (`group_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of system_role_jurisdiction_group_rel
-- ----------------------------

-- ----------------------------
-- Table structure for system_role_jurisdiction_rel
-- ----------------------------
DROP TABLE IF EXISTS `system_role_jurisdiction_rel`;
CREATE TABLE `system_role_jurisdiction_rel` (
  `role_id` char(24) NOT NULL COMMENT '角色ID',
  `jurisdiction_id` char(24) NOT NULL COMMENT '权限ID',
  PRIMARY KEY (`role_id`,`jurisdiction_id`),
  UNIQUE KEY `role_id` (`role_id`,`jurisdiction_id`),
  KEY `system_role_jurisdiction_rel_ibfk_2` (`jurisdiction_id`),
  CONSTRAINT `system_role_jurisdiction_rel_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `system_role` (`role_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `system_role_jurisdiction_rel_ibfk_2` FOREIGN KEY (`jurisdiction_id`) REFERENCES `system_jurisdiction` (`jurisdiction_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of system_role_jurisdiction_rel
-- ----------------------------

-- ----------------------------
-- Table structure for tenant_user
-- ----------------------------
DROP TABLE IF EXISTS `tenant_user`;
CREATE TABLE `tenant_user` (
  `user_id` char(24) NOT NULL COMMENT '用户iD',
  `user_name` varchar(20) NOT NULL COMMENT '用户名称-登录名',
  `user_password` varchar(256) NOT NULL COMMENT '用户登录密码',
  `user_phone` varchar(20) NOT NULL DEFAULT '' COMMENT '用户手机号',
  `user_disable` enum('n','y') NOT NULL DEFAULT 'n' COMMENT '用户禁用标识',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_name` (`user_name`),
  UNIQUE KEY `user_phone` (`user_phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tenant_user
-- ----------------------------

-- ----------------------------
-- Table structure for tenant_user_role_rel
-- ----------------------------
DROP TABLE IF EXISTS `tenant_user_role_rel`;
CREATE TABLE `tenant_user_role_rel` (
  `user_id` char(24) NOT NULL COMMENT '用户ID',
  `role_id` char(24) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`user_id`,`role_id`),
  UNIQUE KEY `user_id` (`user_id`,`role_id`),
  KEY `tenant_user_role_rel_ibfk_2` (`role_id`),
  CONSTRAINT `tenant_user_role_rel_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `tenant_user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `tenant_user_role_rel_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `system_role` (`role_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tenant_user_role_rel
-- ----------------------------
