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
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `order_seq` int NOT NULL AUTO_INCREMENT,
  `order_num` varchar(30) NOT NULL,
  `stu_num` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `stu_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `stu_class` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `stu_money` float NOT NULL,
  `order_time` datetime NOT NULL,
  `order_state` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`order_seq`,`order_num`),
  KEY `student_number` (`stu_num`),
  KEY `student_name` (`stu_name`),
  KEY `student_class` (`stu_class`),
  CONSTRAINT `student_class` FOREIGN KEY (`stu_class`) REFERENCES `students` (`user_class`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `student_name` FOREIGN KEY (`stu_name`) REFERENCES `students` (`stu_name`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `student_number` FOREIGN KEY (`stu_num`) REFERENCES `students` (`stu_num`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `orders_chk_1` CHECK (((`order_state` >= 0) and (`order_state` <= 1)))
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Table structure for students
-- ----------------------------
DROP TABLE IF EXISTS `students`;
CREATE TABLE `students` (
  `stu_num` varchar(30) NOT NULL,
  `stu_name` varchar(20) NOT NULL,
  `user_class` varchar(30) NOT NULL,
  PRIMARY KEY (`stu_num`),
  KEY `stu_name` (`stu_name`),
  KEY `user_class` (`user_class`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
