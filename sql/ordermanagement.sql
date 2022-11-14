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
    order_state int default 1 not null,
    show_state int default 1 not null ,
    primary key ( order_num)
);


DROP TABLE IF EXISTS `abnormalOrder`;
create table abnormalOrder
(
    order_num   varchar(30)   not null,
    stu_num     varchar(30)   not null,
    stu_name    varchar(20)   not null,
    stu_class   varchar(30)   not null,
    stu_money   float         not null,
    order_time  datetime      not null,
    order_state int default 0 not null,
    show_state int default 1  not null ,
    primary key ( order_num)
);





DROP TABLE IF EXISTS `feedback`;
CREATE TABLE `feedback` (
                            `order_num`  varchar(30) NOT NULL ,
                            `stu_num`  varchar(30) NOT NULL ,
                            `stu_name`  varchar(20) NOT NULL ,
                            `phone`  varchar(30) NOT NULL ,
                            `time`  datetime NOT NULL ,
                            `feedbackContent`  varchar(150) NOT NULL ,
                            `state`  int default 0 NOT NULL ,
                            `show_state` int  default 1 NOT NULL ,
                            PRIMARY KEY (`order_num`)
);


DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
                            `number`  varchar(30) NOT NULL ,
                            `password`  varchar(20) NOT NULL ,
                            PRIMARY KEY (`number`)
);



DROP TABLE IF EXISTS `paylist`;
CREATE TABLE `paylist` (
                            `stu_num`  varchar(30) NOT NULL ,
                            `stu_name`  varchar(20) NOT NULL ,
                            `time`  datetime NOT NULL ,
                            `state`  int default 0 NOT NULL ,
                            `class`  varchar(30) NOT NULL ,
                            `payment`  float NOT NULL ,
                            `show_state` int default 1 NOT NULL ,
                            PRIMARY KEY (`stu_num`),
                            check ((`state` >= 0) and (`state` <= 1))
);
