/*
Navicat MySQL Data Transfer

Source Server         : yin
Source Server Version : 50723
Source Host           : localhost:3306
Source Database       : xiaochu

Target Server Type    : MYSQL
Target Server Version : 50723
File Encoding         : 65001

Date: 2018-11-05 01:04:15
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
  `phone_number` varchar(20) DEFAULT NULL,
  `power` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `create_time` varchar(20) DEFAULT NULL,
  `del` int(11) NOT NULL DEFAULT '0' COMMENT '0正常 1删除',
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '0未启用，1已启用',
  PRIMARY KEY (`admin_uid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='web后台管理员账号';

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'root', '888888', '13282221172', '1', null, null, '0', '0');

-- ----------------------------
-- Table structure for `business`
-- ----------------------------
DROP TABLE IF EXISTS `business`;
CREATE TABLE `business` (
  `businessId` int(11) NOT NULL AUTO_INCREMENT,
  `phone_number` varchar(20) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '0正常 1用户注销，2，被管理员停用，3待审核',
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
  `del` int(11) DEFAULT '0' COMMENT '0正常，1删除',
  PRIMARY KEY (`businessId`),
  KEY `kitchenId` (`kitchenId`),
  CONSTRAINT `business_ibfk_1` FOREIGN KEY (`kitchenId`) REFERENCES `kitchen` (`kitchenId`) ON DELETE SET NULL ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='商户信息表';

-- ----------------------------
-- Records of business
-- ----------------------------
INSERT INTO `business` VALUES ('1', '222222222', 'sljfdlkgafgjlsfjg slg', '0', '0', '99', '7', '5', '20', '222222222', null, null, null, '2018-01-01 10:10:00', '0');
INSERT INTO `business` VALUES ('2', '333333333', 'hello world', '2', '0', '88', '10', '20', '25', '333333333', null, null, null, '2018-01-02 12:30:10', '0');
INSERT INTO `business` VALUES ('3', '4444444444', '我喜欢什么啊', '2', '0', '99', '7', '5', '20', '4444444444', null, null, null, '2018-01-03 10:10:00', '0');
INSERT INTO `business` VALUES ('4', '55555555555', '我也不知道啊', '2', '0', '88', '10', '20', '25', '55555555555', null, null, null, '2018-01-04 12:30:10', '0');
INSERT INTO `business` VALUES ('5', '6666666666', '我喜欢析木吗', '0', '0', '99', '7', '5', '20', '6666666666', null, null, null, '2018-01-05 11:11:11', '0');
INSERT INTO `business` VALUES ('6', '77777777777', '嗯是的', '0', '0', '88', '10', '20', '25', '77777777777', null, null, null, '2018-01-06 12:30:33', '0');
INSERT INTO `business` VALUES ('7', '8888888888', '接下来我要这么做', '3', '0', '99', '7', '5', '20', '8888888888', null, null, null, '2018-01-07 01:10:11', '0');
INSERT INTO `business` VALUES ('8', '99999999999', '我也不知道啊，跟随心的感觉？？', '3', '0', '88', '10', '20', '25', '99999999999', null, null, null, '2018-08-22 12:30:10', '0');

-- ----------------------------
-- Table structure for `comment`
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `commentId` int(11) NOT NULL AUTO_INCREMENT,
  `comment_content` varchar(255) NOT NULL DEFAULT '',
  `create_time` varchar(20) DEFAULT NULL,
  `del` int(11) NOT NULL DEFAULT '0' COMMENT '0正常 1删除',
  `wechat_uid` int(11) NOT NULL COMMENT '评论者id',
  `goodsId` int(11) DEFAULT NULL COMMENT '被评论商品id',
  `kitchenId` int(11) NOT NULL COMMENT '被评论厨房id',
  PRIMARY KEY (`commentId`),
  KEY `goodsId` (`goodsId`),
  KEY `comment_ibfk_1` (`wechat_uid`),
  KEY `comment_ibfk_3` (`kitchenId`),
  CONSTRAINT `comment_ibfk_1` FOREIGN KEY (`wechat_uid`) REFERENCES `wechat_info` (`wechat_uid`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `comment_ibfk_3` FOREIGN KEY (`kitchenId`) REFERENCES `kitchen` (`kitchenId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `comment_ibfk_4` FOREIGN KEY (`goodsId`) REFERENCES `goods` (`goodsId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='评论表';

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('1', '难吃的要死', '2018-10-29 00:10:10', '0', '19', '2', '3');
INSERT INTO `comment` VALUES ('2', '不怎么好吃', '2018-10-29 12:00:00', '0', '19', null, '3');

-- ----------------------------
-- Table structure for `goods`
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `goodsId` int(11) NOT NULL AUTO_INCREMENT,
  `goods_name` varchar(100) DEFAULT NULL,
  `goods_price` float DEFAULT '1' COMMENT '价格单位元，保留2位小数',
  `goods_desc` varchar(255) DEFAULT NULL,
  `goods_img_1` varchar(255) DEFAULT NULL,
  `goods_img_2` varchar(255) DEFAULT NULL,
  `goods_img_3` varchar(255) DEFAULT NULL,
  `day_max` int(11) NOT NULL DEFAULT '0' COMMENT '当前最大量',
  `day_surplus` int(11) NOT NULL DEFAULT '0' COMMENT '当天剩余值',
  `create_time` varchar(20) DEFAULT NULL,
  `del` int(11) NOT NULL DEFAULT '0' COMMENT '0正常 1删除',
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '0正常可以使用状态，1被管理员禁用',
  `goods_detail_desc` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`goodsId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='商品信息表';

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('1', '水煮鱼', '60.5', '水煮活鱼', 'http://paq4vnk6w.bkt.clouddn.com/1.jpg', 'http://paq4vnk6w.bkt.clouddn.com/1.jpg', 'http://paq4vnk6w.bkt.clouddn.com/1.jpg', '10', '10', '2018-01-01 10:10:00', '0', '0', '非常好吃的鱼');
INSERT INTO `goods` VALUES ('2', '麻辣香锅', '1.5', 'JAG麻辣香锅', 'http://paq4vnk6w.bkt.clouddn.com/1.jpg', 'http://paq4vnk6w.bkt.clouddn.com/1.jpg', 'http://paq4vnk6w.bkt.clouddn.com/1.jpg', '10', '8', '2018-01-02 11:11:11', '0', '0', '非常好吃的麻辣香锅');
INSERT INTO `goods` VALUES ('3', '甜筒', '0.5', 'JAG甜筒', 'http://paq4vnk6w.bkt.clouddn.com/1.jpg', 'http://paq4vnk6w.bkt.clouddn.com/1.jpg', 'http://paq4vnk6w.bkt.clouddn.com/1.jpg', '10', '7', '2018-02-02 12:12:02', '0', '0', '非常好吃的甜筒');
INSERT INTO `goods` VALUES ('4', '苦瓜炒蛋', '6.5', 'JAG苦瓜炒蛋', 'http://paq4vnk6w.bkt.clouddn.com/1.jpg', 'http://paq4vnk6w.bkt.clouddn.com/1.jpg', 'http://paq4vnk6w.bkt.clouddn.com/1.jpg', '10', '6', '2018-10-05 13:13:00', '0', '0', '非常好吃的苦瓜炒蛋');
INSERT INTO `goods` VALUES ('5', '黑暗料理', '5', 'JAG黑暗料理', 'http://paq4vnk6w.bkt.clouddn.com/1.jpg', 'http://paq4vnk6w.bkt.clouddn.com/1.jpg', 'http://paq4vnk6w.bkt.clouddn.com/1.jpg', '10', '5', '2018-05-08 10:10:00', '0', '0', '非常好吃的黑暗料理');

-- ----------------------------
-- Table structure for `kitchen`
-- ----------------------------
DROP TABLE IF EXISTS `kitchen`;
CREATE TABLE `kitchen` (
  `kitchenId` int(11) NOT NULL AUTO_INCREMENT,
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
  `del` int(11) NOT NULL DEFAULT '0' COMMENT '0正常，1删除',
  PRIMARY KEY (`kitchenId`),
  KEY `goodsId_1` (`goodsId_1`),
  KEY `goodsId_2` (`goodsId_2`),
  KEY `goodsId_3` (`goodsId_3`),
  KEY `goodsId_4` (`goodsId_4`),
  KEY `goodsId_5` (`goodsId_5`),
  KEY `businessId` (`businessId`),
  CONSTRAINT `kitchen_ibfk_1` FOREIGN KEY (`goodsId_1`) REFERENCES `goods` (`goodsId`) ON DELETE SET NULL ON UPDATE NO ACTION,
  CONSTRAINT `kitchen_ibfk_2` FOREIGN KEY (`goodsId_2`) REFERENCES `goods` (`goodsId`) ON DELETE SET NULL ON UPDATE NO ACTION,
  CONSTRAINT `kitchen_ibfk_3` FOREIGN KEY (`goodsId_3`) REFERENCES `goods` (`goodsId`) ON DELETE SET NULL ON UPDATE NO ACTION,
  CONSTRAINT `kitchen_ibfk_4` FOREIGN KEY (`goodsId_4`) REFERENCES `goods` (`goodsId`) ON DELETE SET NULL ON UPDATE NO ACTION,
  CONSTRAINT `kitchen_ibfk_5` FOREIGN KEY (`goodsId_5`) REFERENCES `goods` (`goodsId`) ON DELETE SET NULL ON UPDATE NO ACTION,
  CONSTRAINT `kitchen_ibfk_6` FOREIGN KEY (`businessId`) REFERENCES `business` (`businessId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='小厨信息表，类似门店的意思';

-- ----------------------------
-- Records of kitchen
-- ----------------------------
INSERT INTO `kitchen` VALUES ('3', '2', '0', '11111111111', '222222222222', '33333333333', '1', '2', '3', '4', '5', '100', '100', '10', '0.222222', '0.33333', '5', '2018-10-29 00:00:00', '0');

-- ----------------------------
-- Table structure for `order`
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `orderId` int(11) NOT NULL AUTO_INCREMENT,
  `order_sn` varchar(255) NOT NULL DEFAULT '',
  `mark` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_time` varchar(20) DEFAULT NULL COMMENT '订单创建时间',
  `complete_time` varchar(20) DEFAULT NULL COMMENT '订单完成时间',
  `close_time` varchar(20) DEFAULT '',
  `time` int(11) DEFAULT '0' COMMENT '结束订单用时，单位分钟，有complete_time时，这个字段才有值',
  `del` int(11) NOT NULL DEFAULT '0' COMMENT '0正常 1删除',
  `order_price` float NOT NULL DEFAULT '0' COMMENT '订单价格（单位元），保留两位小数',
  `wechat_uid` int(11) NOT NULL,
  `kitchenId` int(11) NOT NULL,
  `order_status` int(11) NOT NULL DEFAULT '0' COMMENT '处理状态（0未处理、1已接单、2完成)',
  `pay_status` int(11) NOT NULL DEFAULT '0' COMMENT '支付状态（0到付、1已支付）',
  `pay_type` int(11) NOT NULL DEFAULT '0' COMMENT '支付类型（0微信、1支付宝、2现金）',
  PRIMARY KEY (`orderId`),
  KEY `kitchenId` (`kitchenId`),
  KEY `order_ibfk_2` (`wechat_uid`),
  CONSTRAINT `order_ibfk_1` FOREIGN KEY (`kitchenId`) REFERENCES `kitchen` (`kitchenId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `order_ibfk_2` FOREIGN KEY (`wechat_uid`) REFERENCES `wechat_info` (`wechat_uid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='订单表';

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES ('1', 'xxxxxxxxxxxxxxxxxxxxxxxxxxxx', 'mark1111111111111', '2018-10-29 08:11:11', '2018-10-29 08:30:11', '', '19', '0', '100.5', '19', '3', '0', '0', '0');
INSERT INTO `order` VALUES ('2', 'zzzzzzzzzzzzzzzzzzzzzz', 'mark22222222222222222', '2018-10-29 12:00:11', '2018-10-29 12:30:11', '', '30', '0', '88.8', '19', '3', '0', '0', '0');

-- ----------------------------
-- Table structure for `order_goods`
-- ----------------------------
DROP TABLE IF EXISTS `order_goods`;
CREATE TABLE `order_goods` (
  `order_goods_id` int(11) NOT NULL AUTO_INCREMENT,
  `orderId` int(11) NOT NULL,
  `goodsId` int(11) NOT NULL,
  `num` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`order_goods_id`),
  KEY `goodsId` (`goodsId`),
  KEY `orderId` (`orderId`),
  CONSTRAINT `order_goods_ibfk_1` FOREIGN KEY (`orderId`) REFERENCES `order` (`orderId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `order_goods_ibfk_2` FOREIGN KEY (`goodsId`) REFERENCES `goods` (`goodsId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='关联订单表和商品信息表';

-- ----------------------------
-- Records of order_goods
-- ----------------------------
INSERT INTO `order_goods` VALUES ('1', '1', '1', '2');
INSERT INTO `order_goods` VALUES ('2', '1', '2', '1');
INSERT INTO `order_goods` VALUES ('3', '1', '3', '1');
INSERT INTO `order_goods` VALUES ('4', '2', '4', '1');
INSERT INTO `order_goods` VALUES ('5', '2', '5', '5');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `phone_number` varchar(20) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '0正常 1用户自己注销，2.被管理员停用',
  `integral` int(11) NOT NULL DEFAULT '0' COMMENT '积分',
  `complain_num` int(11) NOT NULL DEFAULT '0' COMMENT '投诉次数',
  `shopping_num` int(11) NOT NULL DEFAULT '0' COMMENT '消费次数'',',
  `comment_num` int(11) NOT NULL DEFAULT '0' COMMENT '评论次数',
  `name` varchar(20) DEFAULT NULL,
  `create_time` varchar(20) DEFAULT NULL,
  `del` int(11) NOT NULL DEFAULT '0' COMMENT '0正常，1删除',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COMMENT='用户信息信息表，是wechat_user的外键表';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '13282221172', '西溪北苑北区', '2', '100', '5', '8', '2', '13282221172', '2018-10-15 23:00:00', '0');
INSERT INTO `user` VALUES ('2', '13282221173', '西港新界', '2', '99', '7', '20', '5', '13282221173', '2018-10-12 18:00:00', '1');
INSERT INTO `user` VALUES ('3', '13282221174', '西溪湿地1001', '2', '88', '10', '25', '20', '13282221174', '2018-10-11 18:00:00', '0');
INSERT INTO `user` VALUES ('4', '13283421173', '西奥地利发掘的', '2', '99', '7', '20', '5', '13283421173', '2018-10-12 10:10:00', '1');
INSERT INTO `user` VALUES ('5', '13223421174', '看来简历库离开家', '1', '88', '10', '25', '20', '13223421174', '2018-10-11 12:30:10', '0');
INSERT INTO `user` VALUES ('6', '1123123132', '喀军队积分卡的法律科技发达', '2', '99', '7', '20', '5', '1123123132', '2018-09-12 10:10:00', '0');
INSERT INTO `user` VALUES ('7', '8739418327', '西湖凤起路', '0', '88', '10', '25', '20', '8739418327', '2018-9-11 12:30:10', '0');
INSERT INTO `user` VALUES ('8', '8787987987', '，仙女v年下半年', '1', '99', '7', '20', '5', '8787987987', '2018-10-1 11:11:11', '0');
INSERT INTO `user` VALUES ('9', '797987987', '哦i破i哦i哦iuiu皇家空军哈地方', '2', '88', '10', '25', '20', '797987987', '2018-10-02 12:30:33', '0');
INSERT INTO `user` VALUES ('10', '295245295', 'NBA唐人接', '0', '99', '7', '20', '5', '295245295', '2018-09-01 01:10:11', '0');
INSERT INTO `user` VALUES ('11', '1111111111', '海贼王路我的天啊', '1', '88', '10', '25', '20', '1111111111', '2018-9-22 12:30:10', '0');
INSERT INTO `user` VALUES ('12', '222222222', 'sljfdlkgafgjlsfjg slg', '2', '99', '7', '20', '5', '222222222', '2018-01-01 10:10:00', '0');
INSERT INTO `user` VALUES ('13', '333333333', 'hello world', '0', '88', '10', '25', '20', '333333333', '2018-01-02 12:30:10', '0');
INSERT INTO `user` VALUES ('14', '4444444444', '我喜欢什么啊', '1', '99', '7', '20', '5', '4444444444', '2018-01-03 10:10:00', '0');
INSERT INTO `user` VALUES ('15', '55555555555', '我也不知道啊', '2', '88', '10', '25', '20', '55555555555', '2018-01-04 12:30:10', '0');
INSERT INTO `user` VALUES ('16', '6666666666', '我喜欢析木吗', '0', '99', '7', '20', '5', '6666666666', '2018-01-05 11:11:11', '0');
INSERT INTO `user` VALUES ('17', '77777777777', '嗯是的', '1', '88', '10', '25', '20', '77777777777', '2018-01-06 12:30:33', '0');
INSERT INTO `user` VALUES ('18', '8888888888', '接下来我要这么做', '2', '99', '7', '20', '5', '8888888888', '2018-01-07 01:10:11', '0');
INSERT INTO `user` VALUES ('19', '99999999999', '我也不知道啊，跟随心的感觉？？', '0', '88', '10', '25', '20', '99999999999', '2018-08-22 12:30:10', '0');

-- ----------------------------
-- Table structure for `wechat_info`
-- ----------------------------
DROP TABLE IF EXISTS `wechat_info`;
CREATE TABLE `wechat_info` (
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
  KEY `businessId` (`businessId`),
  KEY `uid` (`uid`),
  CONSTRAINT `wechat_info_ibfk_2` FOREIGN KEY (`businessId`) REFERENCES `business` (`businessId`) ON DELETE SET NULL ON UPDATE NO ACTION,
  CONSTRAINT `wechat_info_ibfk_3` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`) ON DELETE SET NULL ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8 COMMENT='用户信息微信部分的抽象表';

-- ----------------------------
-- Records of wechat_info
-- ----------------------------
INSERT INTO `wechat_info` VALUES ('1', 'JAG', '1', 'zh_CN', 'Wenzhou', 'Zhejiang', 'China', 'https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIuE3Yv6JpNT0WibIgHB8qkdANLMibdJ2Fwick8evW9KcA3MNeMfWKEZukKefj1ibmpLFsgtWic5tsnic5w/132', '1111111111', '1', null);
INSERT INTO `wechat_info` VALUES ('2', '析木', '2', 'zh_CN', 'Wenzhou', 'Zhejiang', 'China', 'https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIuE3Yv6JpNT0WibIgHB8qkdANLMibdJ2Fwick8evW9KcA3MNeMfWKEZukKefj1ibmpLFsgtWic5tsnic5w/132', '22222222222', '2', null);
INSERT INTO `wechat_info` VALUES ('3', '测试11', '1', 'zh_CN', 'Hangzhou', 'Zhejiang', 'China', 'xxxxxxx', 'eafjdaskfjdlakfjdlaf', '3', null);
INSERT INTO `wechat_info` VALUES ('4', '测试22', '2', 'zh_CN', 'Ningbo', 'Zhejiang', 'China', 'xxxxxxx', 'eafjdaskfjdlakfjdlaf', '4', null);
INSERT INTO `wechat_info` VALUES ('5', '测试333', '1', 'zh_CN', 'Hangzhou', 'Zhejiang', 'China', 'xxxxxxx', 'eafjdaskfjdlakfjdlaf', '5', null);
INSERT INTO `wechat_info` VALUES ('6', '析木2222', '2', 'zh_CN', 'Ningbo', 'Zhejiang', 'China', 'xxxxxxx', 'eafjdaskfjdlakfjdlaf', '6', null);
INSERT INTO `wechat_info` VALUES ('7', '苏城建', '1', 'zh_CN', 'Beijiang', 'Beijian', 'China', 'xxxxxxx', 'eafjdaskfjdlakfjdlaf', '7', null);
INSERT INTO `wechat_info` VALUES ('8', '析木aksdhfak', '2', 'zh_CN', 'Ningbo', 'Zhejiang', 'China', 'xxxxxxx', 'eafjdaskfjdlakfjdlaf', '8', null);
INSERT INTO `wechat_info` VALUES ('9', '苏城建33333', '1', 'zh_CN', 'Beijiang', 'Beijian', 'China', 'xxxxxxx', 'eafjdaskfjdlakfjdlaf', '9', null);
INSERT INTO `wechat_info` VALUES ('10', '析木33333', '2', 'zh_CN', 'Ningbo', 'Zhejiang', 'China', 'xxxxxxx', 'eafjdaskfjdlakfjdlaf', '10', null);
INSERT INTO `wechat_info` VALUES ('11', '苏城建4444', '1', 'zh_CN', 'Beijiang', 'Beijian', 'China', 'xxxxxxx', 'eafjdaskfjdlakfjdlaf', '11', null);
INSERT INTO `wechat_info` VALUES ('12', '析木44444', '2', 'zh_CN', 'Ningbo', 'Zhejiang', 'China', 'xxxxxxx', 'eafjdaskfjdlakfjdlaf', '12', null);
INSERT INTO `wechat_info` VALUES ('13', '苏城建55555', '1', 'zh_CN', 'Beijiang', 'Beijian', 'China', 'xxxxxxx', 'eafjdaskfjdlakfjdlaf', '13', null);
INSERT INTO `wechat_info` VALUES ('14', '析木555555', '2', 'zh_CN', 'Ningbo', 'Zhejiang', 'China', 'xxxxxxx', 'eafjdaskfjdlakfjdlaf', '14', null);
INSERT INTO `wechat_info` VALUES ('15', '苏城建', '1', 'zh_CN', 'Beijiang', 'Beijian', 'China', 'xxxxxxx', 'eafjdaskfjdlakfjdlaf', '15', null);
INSERT INTO `wechat_info` VALUES ('16', '析木2222', '2', 'zh_CN', 'Ningbo', 'Zhejiang', 'China', 'xxxxxxx', 'eafjdaskfjdlakfjdlaf', '16', null);
INSERT INTO `wechat_info` VALUES ('17', '苏城建', '1', 'zh_CN', 'Beijiang', 'Beijian', 'China', 'xxxxxxx', 'eafjdaskfjdlakfjdlaf', '17', null);
INSERT INTO `wechat_info` VALUES ('19', '引点', '1', 'zh_CN', 'Beijiang', 'Beijian', 'China', 'xxxxxxx', 'eafjdaskfjdlakfjdlaf', null, '2');
INSERT INTO `wechat_info` VALUES ('20', '浙江大学宁波理工学院11111', '2', 'zh_CN', 'Ningbo', 'Zhejiang', 'China', 'xxxxxxx', 'eafjdaskfjdlakfjdlaf', null, '3');
INSERT INTO `wechat_info` VALUES ('21', '引点22', '1', 'zh_CN', 'Beijiang', 'Beijian', 'China', 'xxxxxxx', 'eafjdaskfjdlakfjdlaf', null, '4');
INSERT INTO `wechat_info` VALUES ('22', '浙江大院', '2', 'zh_CN', 'Ningbo', 'Zhejiang', 'China', 'xxxxxxx', 'eafjdaskfjdlakfjdlaf', null, '5');
INSERT INTO `wechat_info` VALUES ('23', '引点33', '1', 'zh_CN', 'Beijiang', 'Beijian', 'China', 'xxxxxxx', 'eafjdaskfjdlakfjdlaf', null, '6');
INSERT INTO `wechat_info` VALUES ('24', '浙江大学', '2', 'zh_CN', 'Ningbo', 'Zhejiang', 'China', 'xxxxxxx', 'eafjdaskfjdlakfjdlaf', null, '7');
INSERT INTO `wechat_info` VALUES ('25', '引点444', '1', 'zh_CN', 'Beijiang', 'Beijian', 'China', 'xxxxxxx', 'eafjdaskfjdlakfjdlaf', null, '8');
