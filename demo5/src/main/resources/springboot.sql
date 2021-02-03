/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50024
Source Host           : localhost:3306
Source Database       : springboot

Target Server Type    : MYSQL
Target Server Version : 50024
File Encoding         : 65001

Date: 2021-02-03 14:44:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_authority
-- ----------------------------
DROP TABLE IF EXISTS `tb_authority`;
CREATE TABLE `tb_authority` (
  `authorityId` int(10) unsigned NOT NULL auto_increment,
  `authorityName` varchar(255) default NULL,
  PRIMARY KEY  (`authorityId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_authority
-- ----------------------------
INSERT INTO `tb_authority` VALUES ('1', 'ROLE_ADMIN');
INSERT INTO `tb_authority` VALUES ('2', 'ROLE_USER');

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `userId` int(10) unsigned NOT NULL auto_increment,
  `userName` varchar(255) default NULL,
  `userPwd` varchar(255) default NULL,
  PRIMARY KEY  (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user
-- ----------------------------

-- ----------------------------
-- Table structure for tb_user_authority
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_authority`;
CREATE TABLE `tb_user_authority` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `userId` int(10) unsigned default NULL,
  `authorityId` int(10) unsigned default NULL,
  PRIMARY KEY  (`id`),
  KEY `userId` (`userId`),
  KEY `authorityId` (`authorityId`),
  CONSTRAINT `tb_user_authority_ibfk_2` FOREIGN KEY (`authorityId`) REFERENCES `tb_authority` (`authorityId`),
  CONSTRAINT `tb_user_authority_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `tb_user` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user_authority
-- ----------------------------
