/*
Navicat MySQL Data Transfer

Source Server         : 连接
Source Server Version : 80028
Source Host           : localhost:3306
Source Database       : ordermanagement

Target Server Type    : MYSQL
Target Server Version : 80028
File Encoding         : 65001

Date: 2022-10-31 21:18:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for orders
-- ----------------------------
USE ordermanagement;

DROP TABLE IF EXISTS `orders`;

create table orders
(
    order_num   varchar(30)   not null,
    stu_num     varchar(30)   not null,
    stu_name    varchar(20)   not null,
    stu_class   varchar(30)   not null,
    stu_money   float         not null,
    order_time  datetime      not null,
    order_state int default 0 not null,
    primary key ( order_num),
    check ((`order_state` >= 0) and (`order_state` <= 1))
);

