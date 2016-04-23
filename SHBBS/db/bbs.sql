/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50540
Source Host           : localhost:3306
Source Database       : bbs

Target Server Type    : MYSQL
Target Server Version : 50540
File Encoding         : 65001

Date: 2016-04-24 01:13:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `bbs_user`
-- ----------------------------
DROP TABLE IF EXISTS `bbs_user`;
CREATE TABLE `bbs_user` (
  `id` varchar(64) NOT NULL,
  `password` varchar(32) NOT NULL,
  `username` varchar(32) NOT NULL,
  `level` decimal(8,0) NOT NULL,
  `email` varchar(32) NOT NULL,
  `time` datetime NOT NULL,
  `privilige` int(3) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bbs_user
-- ----------------------------
INSERT INTO `bbs_user` VALUES ('d825975e8c2f421daabe040277fe385c', 'E10ADC3949BA59ABBE56E057F20F883E', 'tanliu', '0', '987420817@qq.com', '2016-04-05 00:00:00', '1');
INSERT INTO `bbs_user` VALUES ('14', '14', '15', '14', '14', '2016-04-20 16:47:30', '0');
INSERT INTO `bbs_user` VALUES ('03ae874dda984495b45695bd28cac3b0', 'E10ADC3949BA59ABBE56E057F20F883E', 'liu', '0', '9876456546@qq.com', '2016-04-05 00:00:00', '0');

-- ----------------------------
-- Table structure for `blog`
-- ----------------------------
DROP TABLE IF EXISTS `blog`;
CREATE TABLE `blog` (
  `id` varchar(64) NOT NULL,
  `use_id` varchar(64) NOT NULL,
  `title` varchar(80) NOT NULL,
  `content` varchar(500) NOT NULL,
  `time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_userPublic` (`use_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog
-- ----------------------------
INSERT INTO `blog` VALUES ('1', '1', '1', '1', '2016-04-12 01:09:47');
INSERT INTO `blog` VALUES ('2', '2', '2', '2', '2016-04-14 01:09:59');
INSERT INTO `blog` VALUES ('3', '3', '3', '3', '2016-03-30 01:10:13');
INSERT INTO `blog` VALUES ('4', '4', '4', '4', '2016-04-06 01:10:23');
INSERT INTO `blog` VALUES ('5', '5', '5', '5', '2016-04-07 01:10:32');

-- ----------------------------
-- Table structure for `reply`
-- ----------------------------
DROP TABLE IF EXISTS `reply`;
CREATE TABLE `reply` (
  `id` varchar(64) NOT NULL,
  `pub_id` varchar(64) NOT NULL,
  `use_id` varchar(64) NOT NULL,
  `content` text NOT NULL,
  `time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_reply_blog` (`pub_id`),
  KEY `FK_user_reply` (`use_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of reply
-- ----------------------------
INSERT INTO `reply` VALUES ('453e0fffc6f8454dab1b98a9fecd594c', 'efb9535df99c48ccaeecf7031d83e649', 'd825975e8c2f421daabe040277fe385c', 'fad adfad adfadf', '2016-04-05 23:13:26');
INSERT INTO `reply` VALUES ('68b937ac87604657a8d28fccb9bfd4d7', 'efb9535df99c48ccaeecf7031d83e649', 'd825975e8c2f421daabe040277fe385c', '465454dfad56f46', '2016-04-05 23:13:20');
INSERT INTO `reply` VALUES ('d7f61c0250b64a30b3d06c6faef0e75c', 'efb9535df99c48ccaeecf7031d83e649', 'd825975e8c2f421daabe040277fe385c', 'fadfadfadfadf fadfa', '2016-04-05 23:13:32');

-- ----------------------------
-- View structure for `stu_use`
-- ----------------------------
DROP VIEW IF EXISTS `stu_use`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `stu_use` AS select `l`.`id` AS `id`,`l`.`password` AS `password`,`l`.`username` AS `username`,`s`.`description` AS `description` from (`lab_user` `l` join `student` `s`) where (`l`.`id` = `s`.`sid`) ;
