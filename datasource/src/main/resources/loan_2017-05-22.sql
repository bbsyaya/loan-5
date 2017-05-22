# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.7.18)
# Database: loan
# Generation Time: 2017-05-22 13:26:03 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table bussiness_monitor
# ------------------------------------------------------------

CREATE TABLE `bussiness_monitor` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `app_id` bigint(20) DEFAULT NULL COMMENT 'cooperation 外键',
  `visit_time` datetime DEFAULT NULL COMMENT '访问时间',
  `client_ip` int(11) DEFAULT NULL COMMENT '客户端访问时的ip',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `charge` float DEFAULT NULL COMMENT '费用',
  `module_code` varchar(10) DEFAULT NULL COMMENT '模块id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table cooperation
# ------------------------------------------------------------

CREATE TABLE `cooperation` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `app_name` varchar(32) DEFAULT NULL COMMENT '对应app名称',
  `logo` varchar(256) DEFAULT NULL COMMENT 'app logo',
  `rate` varchar(32) DEFAULT NULL COMMENT '费率',
  `service_charge` varchar(32) DEFAULT NULL COMMENT '服务费，（砍头息）',
  `top_qota` int(11) DEFAULT NULL COMMENT '最高可申请额度',
  `bottom_qota` int(11) DEFAULT NULL COMMENT '最低可申请额度',
  `out_time` varchar(32) DEFAULT NULL COMMENT '放款时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `order_no` int(11) DEFAULT NULL COMMENT '排序字段',
  `enabled` tinyint(4) DEFAULT NULL COMMENT '是否启用 0 禁用 1 启用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table news
# ------------------------------------------------------------

CREATE TABLE `news` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `msg_type` tinyint(4) DEFAULT NULL COMMENT '0 url 1 内容',
  `content` varchar(3000) DEFAULT NULL COMMENT '内容',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_by` varchar(30) DEFAULT NULL COMMENT '创建人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table module
# ------------------------------------------------------------

CREATE TABLE `module` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(30) DEFAULT NULL COMMENT '模块名称',
  `code` varchar(10) DEFAULT NULL COMMENT '模块代码',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `sort` tinyint(4) DEFAULT '0' COMMENT '排序',
  `enabled` tinyint(4) DEFAULT '1' COMMENT '是否启用 0 禁用 1 启用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table operator
# ------------------------------------------------------------

CREATE TABLE `operator` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table relation
# ------------------------------------------------------------

DROP TABLE IF EXISTS `relation`;

CREATE TABLE `relation` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `contact_name` varchar(32) NOT NULL DEFAULT '' COMMENT '联系人姓名',
  `contact_mobile` varchar(16) NOT NULL DEFAULT '' COMMENT '联系电话',
  `relation_type` int(11) DEFAULT NULL COMMENT '0 配偶 1 同事 2 同学 3 亲属',
  `qq` varchar(16) DEFAULT NULL COMMENT '联系人qq',
  `webchart` varchar(32) DEFAULT NULL COMMENT '联系人微信',
  `email` varchar(32) DEFAULT NULL COMMENT '联系人邮箱',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table user
# ------------------------------------------------------------

CREATE TABLE `user` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `login_name` varchar(32) NOT NULL DEFAULT '' COMMENT '用户名',
  `login_pwd` varchar(32) NOT NULL DEFAULT '' COMMENT '用户密码',
  `user_name` varchar(32) DEFAULT '' COMMENT '用户真实姓名',
  `id_card` varchar(18) DEFAULT '' COMMENT '身份证号',
  `mobile` varchar(24) NOT NULL DEFAULT '' COMMENT '手机号',
  `qq` varchar(10) DEFAULT '' COMMENT 'qq号码',
  `wechart` varchar(32) DEFAULT '' COMMENT '微信号',
  `email` varchar(32) DEFAULT '' COMMENT '电子邮箱',
  `phone` varchar(32) DEFAULT '' COMMENT '家庭电话',
  `education` tinyint(1) DEFAULT NULL COMMENT '教育程度',
  `job` varchar(255) DEFAULT NULL COMMENT '职业',
  `reg_time` datetime DEFAULT NULL COMMENT '注册时间',
  `last_login_time` datetime DEFAULT NULL COMMENT '上次登录时间',
  `update_time` datetime DEFAULT NULL COMMENT '上次更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table zhima
# ------------------------------------------------------------

CREATE TABLE `zhima` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `score` int(8) NOT NULL COMMENT '芝麻分数',
  `customer_id` varchar(16) DEFAULT '' COMMENT '获取芝麻分的id',
  `enabled` tinyint(4) DEFAULT NULL COMMENT '是否可用',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
