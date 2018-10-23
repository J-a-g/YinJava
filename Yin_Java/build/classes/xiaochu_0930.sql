/*
Navicat MySQL Data Transfer

Source Server         : suchengjian
Source Server Version : 50723
Source Host           : localhost:3306
Source Database       : xiaochu

Target Server Type    : MYSQL
Target Server Version : 50723
File Encoding         : 65001

Date: 2018-09-30 18:04:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `admin_uid` int(11) NOT NULL AUTO_INCREMENT,
  `admin_username` varchar(255) NOT NULL,
  `admin_pwd` varchar(255) NOT NULL,
  `power` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`admin_uid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'root', '888888', '1');

-- ----------------------------
-- Table structure for `business`
-- ----------------------------
DROP TABLE IF EXISTS `business`;
CREATE TABLE `business` (
  `businessId` int(11) NOT NULL AUTO_INCREMENT,
  `phone_number` varchar(20) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '0正常 1关闭',
  `type` int(11) NOT NULL DEFAULT '0' COMMENT '0小厨用户，1小二',
  `integral` int(11) NOT NULL DEFAULT '0' COMMENT '积分',
  `complain_num` int(11) NOT NULL DEFAULT '0' COMMENT '投诉次数',
  `comment_num` int(11) NOT NULL DEFAULT '0' COMMENT '评论次数',
  `shopping_num` int(11) NOT NULL DEFAULT '0' COMMENT '消费次数',
  `name` varchar(20) DEFAULT NULL,
  `id_card_url_1` varchar(255) DEFAULT NULL,
  `id_card_url_2` varchar(255) DEFAULT NULL,
  `kitchenId` int(11) DEFAULT NULL,
  `create_time` varchar(20) DEFAULT NULL,
  `delete` int(11) DEFAULT '0' COMMENT '0正常，1删除',
  PRIMARY KEY (`businessId`),
  KEY `kitchenId` (`kitchenId`),
  CONSTRAINT `business_ibfk_1` FOREIGN KEY (`kitchenId`) REFERENCES `kitchen` (`kitchenId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of business
-- ----------------------------

-- ----------------------------
-- Table structure for `comment`
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `commentId` int(11) NOT NULL,
  `comment_content` varchar(255) NOT NULL DEFAULT '',
  `create_time` varchar(20) DEFAULT NULL,
  `delete` int(11) NOT NULL DEFAULT '0' COMMENT '0正常 1删除',
  `wechat_uid` int(11) NOT NULL COMMENT '评论者id',
  `goodsId` int(11) NOT NULL COMMENT '被评论商品id',
  `kitchenId` int(11) NOT NULL COMMENT '被评论厨房id',
  PRIMARY KEY (`commentId`),
  KEY `wechat_uid` (`wechat_uid`),
  KEY `goodsId` (`goodsId`),
  KEY `kitchenId` (`kitchenId`),
  CONSTRAINT `comment_ibfk_1` FOREIGN KEY (`wechat_uid`) REFERENCES `wechat_user` (`wechat_uid`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `comment_ibfk_2` FOREIGN KEY (`goodsId`) REFERENCES `goods` (`goodsId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `comment_ibfk_3` FOREIGN KEY (`kitchenId`) REFERENCES `kitchen` (`kitchenId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------

-- ----------------------------
-- Table structure for `goods`
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `goodsId` int(11) NOT NULL,
  `goods_name` varchar(100) DEFAULT NULL,
  `goods_price` float DEFAULT '1' COMMENT '价格单位分',
  `goods_desc` varchar(255) DEFAULT NULL,
  `goods_img_1` varchar(255) DEFAULT NULL,
  `goods_img_2` varchar(255) DEFAULT NULL,
  `goods_img_3` varchar(255) DEFAULT NULL,
  `day_max` int(11) NOT NULL DEFAULT '0' COMMENT '当前最大量',
  `day_surplus` int(11) NOT NULL DEFAULT '0' COMMENT '当天剩余值',
  `create_time` varchar(20) DEFAULT NULL,
  `delete` int(11) NOT NULL DEFAULT '0' COMMENT '0正常 1删除',
  `goods_detail_desc` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`goodsId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------

-- ----------------------------
-- Table structure for `kitchen`
-- ----------------------------
DROP TABLE IF EXISTS `kitchen`;
CREATE TABLE `kitchen` (
  `kitchenId` int(11) NOT NULL,
  `businessId` int(11) NOT NULL,
  `statut` int(11) NOT NULL DEFAULT '0' COMMENT '0未开通、1正常、2停业、3关闭、4整顿',
  `kitchen_url_1` varchar(255) DEFAULT NULL COMMENT '厨房照片',
  `kitchen_url_2` varchar(255) DEFAULT NULL,
  `kitchen_url_3` varchar(255) DEFAULT NULL,
  `goodsId_1` int(11) DEFAULT NULL,
  `goodsId_2` int(11) DEFAULT NULL,
  `goodsId_3` int(11) DEFAULT NULL,
  `goodsId_4` int(11) DEFAULT NULL,
  `goodsId_5` int(11) DEFAULT NULL,
  `service_time` int(11) NOT NULL DEFAULT '0',
  `order_num` int(11) NOT NULL DEFAULT '0',
  `service_distance` int(11) NOT NULL,
  `longitude` varchar(10) DEFAULT NULL,
  `latitude` varchar(10) DEFAULT NULL,
  `goods_num` int(11) DEFAULT '5',
  `create_time` varchar(20) DEFAULT NULL,
  `delete` int(11) NOT NULL DEFAULT '0' COMMENT '0正常，1删除',
  PRIMARY KEY (`kitchenId`),
  KEY `goodsId_1` (`goodsId_1`),
  KEY `goodsId_2` (`goodsId_2`),
  KEY `goodsId_3` (`goodsId_3`),
  KEY `goodsId_4` (`goodsId_4`),
  KEY `goodsId_5` (`goodsId_5`),
  CONSTRAINT `kitchen_ibfk_1` FOREIGN KEY (`goodsId_1`) REFERENCES `goods` (`goodsId`) ON DELETE SET NULL ON UPDATE NO ACTION,
  CONSTRAINT `kitchen_ibfk_2` FOREIGN KEY (`goodsId_2`) REFERENCES `goods` (`goodsId`) ON DELETE SET NULL ON UPDATE NO ACTION,
  CONSTRAINT `kitchen_ibfk_3` FOREIGN KEY (`goodsId_3`) REFERENCES `goods` (`goodsId`) ON DELETE SET NULL ON UPDATE NO ACTION,
  CONSTRAINT `kitchen_ibfk_4` FOREIGN KEY (`goodsId_4`) REFERENCES `goods` (`goodsId`) ON DELETE SET NULL ON UPDATE NO ACTION,
  CONSTRAINT `kitchen_ibfk_5` FOREIGN KEY (`goodsId_5`) REFERENCES `goods` (`goodsId`) ON DELETE SET NULL ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of kitchen
-- ----------------------------

-- ----------------------------
-- Table structure for `order`
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `orderId` int(11) NOT NULL,
  `mark` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_time` varchar(20) DEFAULT NULL COMMENT '订单创建时间',
  `complete_time` varchar(20) DEFAULT NULL COMMENT '订单完成时间',
  `close_time` varchar(20) DEFAULT NULL,
  `delete` int(11) NOT NULL DEFAULT '0' COMMENT '0正常 1删除',
  `order_price` float NOT NULL DEFAULT '0' COMMENT '订单价格（单位分）',
  `wechat_uid` int(11) NOT NULL,
  `kitchenId` int(11) NOT NULL,
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '处理状态（0未处理、1已接单、2完成)',
  `pay_status` int(11) NOT NULL DEFAULT '0' COMMENT '支付状态（0到付、1已支付）',
  `pay_type` int(11) NOT NULL DEFAULT '0' COMMENT '支付类型（0微信、1支付宝、2现金）',
  PRIMARY KEY (`orderId`),
  KEY `wechat_uid` (`wechat_uid`),
  KEY `kitchenId` (`kitchenId`),
  CONSTRAINT `order_ibfk_1` FOREIGN KEY (`wechat_uid`) REFERENCES `wechat_user` (`wechat_uid`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `order_ibfk_2` FOREIGN KEY (`kitchenId`) REFERENCES `kitchen` (`kitchenId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order
-- ----------------------------

-- ----------------------------
-- Table structure for `order_goods`
-- ----------------------------
DROP TABLE IF EXISTS `order_goods`;
CREATE TABLE `order_goods` (
  `order_goods_id` int(11) NOT NULL,
  `orderId` int(11) NOT NULL,
  `goodsId` int(11) NOT NULL,
  `num` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`order_goods_id`),
  KEY `goodsId` (`goodsId`),
  CONSTRAINT `order_goods_ibfk_1` FOREIGN KEY (`goodsId`) REFERENCES `goods` (`goodsId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_goods
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` int(11) NOT NULL,
  `phone_number` varchar(20) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '0正常 1关闭',
  `integral` int(11) NOT NULL DEFAULT '0' COMMENT '积分',
  `complain_num` int(11) NOT NULL DEFAULT '0' COMMENT '投诉次数',
  `shopping_num` int(11) NOT NULL DEFAULT '0' COMMENT '`shopping_num` int NOT NULL COMMENT ''消费次数'',',
  `comment_num` int(11) NOT NULL DEFAULT '0' COMMENT '评论次数',
  `name` varchar(20) DEFAULT NULL,
  `create_time` varchar(20) DEFAULT NULL,
  `delete` int(11) NOT NULL DEFAULT '0' COMMENT '0正常，1删除',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------

-- ----------------------------
-- Table structure for `wechat_user`
-- ----------------------------
DROP TABLE IF EXISTS `wechat_user`;
CREATE TABLE `wechat_user` (
  `wechat_uid` int(11) NOT NULL AUTO_INCREMENT,
  `nickName` varchar(100) DEFAULT NULL,
  `gender` int(11) DEFAULT NULL,
  `language` varchar(20) DEFAULT NULL,
  `city` varchar(20) DEFAULT NULL,
  `province` varchar(20) DEFAULT NULL,
  `country` varchar(20) DEFAULT NULL,
  `avatarUrl` varchar(255) DEFAULT NULL COMMENT '头像',
  `signature` varchar(100) NOT NULL DEFAULT '',
  `uid` int(11) DEFAULT NULL,
  `businessId` int(11) DEFAULT NULL,
  PRIMARY KEY (`wechat_uid`),
  KEY `uid` (`uid`),
  KEY `businessId` (`businessId`),
  CONSTRAINT `wechat_user_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`) ON DELETE SET NULL ON UPDATE NO ACTION,
  CONSTRAINT `wechat_user_ibfk_2` FOREIGN KEY (`businessId`) REFERENCES `business` (`businessId`) ON DELETE SET NULL ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wechat_user
-- ----------------------------
