/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50631
Source Host           : localhost:3306
Source Database       : ipro

Target Server Type    : MYSQL
Target Server Version : 50631
File Encoding         : 65001

Date: 2016-10-20 23:37:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for system_menu
-- ----------------------------
DROP TABLE IF EXISTS `system_menu`;
CREATE TABLE `system_menu` (
  `menu_id` char(24) NOT NULL COMMENT '菜单ID',
  `parent_menu_id` char(24) DEFAULT NULL COMMENT '父级',
  `menu_name` varchar(20) NOT NULL COMMENT '菜单名称',
  `menu_level` enum('level1','level2','level3') NOT NULL DEFAULT 'level1' COMMENT '菜单级别',
  `menu_address` varchar(200) DEFAULT NULL COMMENT '菜单链接地址',
  `menu_status` enum('y','n') NOT NULL DEFAULT 'y' COMMENT '菜单有效性',
  `menu_icon` varchar(100) DEFAULT 'fa fa-list' COMMENT '菜单图标',
  PRIMARY KEY (`menu_id`),
  KEY `parent_menu_id` (`parent_menu_id`),
  CONSTRAINT `system_menu_ibfk_1` FOREIGN KEY (`parent_menu_id`) REFERENCES `system_menu` (`menu_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of system_menu
-- ----------------------------
INSERT INTO `system_menu` VALUES ('5808e049d8c6f5724ffe9da7', null, '主页', 'level1', 'index', 'y', 'fa fa-list');
INSERT INTO `system_menu` VALUES ('5808e049d8c6f5724ffe9da8', null, '一级菜单', 'level1', '', 'y', 'fa fa-list');
INSERT INTO `system_menu` VALUES ('5808e049d8c6f5724ffe9da9', '5808e049d8c6f5724ffe9da8', '菜单管理', 'level2', 'default1', 'y', 'fa fa-list');
INSERT INTO `system_menu` VALUES ('5808e049d8c6f5724ffe9daa', '5808e049d8c6f5724ffe9da8', '二级菜单', 'level2', 'default2', 'y', 'fa fa-list');
