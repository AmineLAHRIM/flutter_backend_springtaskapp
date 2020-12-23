/*
 Navicat Premium Data Transfer

 Source Server         : new
 Source Server Type    : MySQL
 Source Server Version : 50730
 Source Host           : localhost:8889
 Source Schema         : taskapp

 Target Server Type    : MySQL
 Target Server Version : 50730
 File Encoding         : 65001

 Date: 23/12/2020 19:15:38
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for hibernate_sequence
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hibernate_sequence
-- ----------------------------
BEGIN;
INSERT INTO `hibernate_sequence` VALUES (18);
COMMIT;

-- ----------------------------
-- Table structure for task
-- ----------------------------
DROP TABLE IF EXISTS `task`;
CREATE TABLE `task` (
  `id` bigint(20) NOT NULL,
  `date` datetime DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `description` varchar(255) DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `status` int(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of task
-- ----------------------------
BEGIN;
INSERT INTO `task` VALUES (1, '2020-12-23 01:52:28', 0, NULL, NULL, 'Daily Scrum Meeting', 2);
INSERT INTO `task` VALUES (2, '2020-12-23 01:52:28', 0, NULL, NULL, 'Complex Animation', 1);
INSERT INTO `task` VALUES (3, '2020-12-23 01:52:28', 0, NULL, NULL, 'Local/Remote Notification', 3);
INSERT INTO `task` VALUES (4, '2020-12-23 01:52:28', 0, NULL, NULL, 'Setup Payment Getway', 1);
INSERT INTO `task` VALUES (5, '2020-12-24 01:52:21', 0, NULL, NULL, 'Upload Images', 0);
INSERT INTO `task` VALUES (6, '2020-12-24 01:52:10', 0, NULL, NULL, 'Have a Breakfast', 0);
INSERT INTO `task` VALUES (7, '2020-12-24 01:51:56', 0, NULL, NULL, 'Run 5km', 0);
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `email` varchar(255) DEFAULT NULL,
  `geo_localisation` varchar(255) DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES (1, 0, 'lee@gmail.com', '', 'https://i.ibb.co/tzjwxFV/Screenshot-2020-12-23-at-1-39-51-pm.png', 'Lee', 'lee123');
INSERT INTO `user` VALUES (2, 0, 'emma@gmail.com', '', 'https://i.ibb.co/CVd8ZG5/Screenshot-2020-12-23-at-1-40-05-pm.png', 'Emma', 'emma123');
INSERT INTO `user` VALUES (3, 0, 'yuri@gmail.com', '', 'https://i.ibb.co/XkMVspf/Screenshot-2020-12-23-at-1-40-17-pm.png', 'Yuri', 'yuri123');
INSERT INTO `user` VALUES (4, 0, 'elsa@gmail.com', '', 'https://i.ibb.co/WBgq8HF/Screenshot-2020-12-23-at-1-40-22-pm.png', 'Elsa', 'elsa123');
INSERT INTO `user` VALUES (5, 0, 'moly@gmail.com', '', 'https://i.ibb.co/XSGkqF6/Screenshot-2020-12-23-at-1-40-37-pm.png', 'Moly', 'moly123');
INSERT INTO `user` VALUES (6, 0, 'aminelahrimdev@gmail.com', NULL, 'https://i.ibb.co/DfFnm2t/Screenshot-2020-12-23-at-1-40-27-pm.png', 'amine', 'hola');
COMMIT;

-- ----------------------------
-- Table structure for user_task_detail
-- ----------------------------
DROP TABLE IF EXISTS `user_task_detail`;
CREATE TABLE `user_task_detail` (
  `id` bigint(20) NOT NULL,
  `task` bigint(20) DEFAULT NULL,
  `user` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK51hfbpp6rw86w0ow5659xrw2f` (`task`),
  KEY `FKfei91crgg6n9lyrbbp75nw758` (`user`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_task_detail
-- ----------------------------
BEGIN;
INSERT INTO `user_task_detail` VALUES (1, 1, 1);
INSERT INTO `user_task_detail` VALUES (2, 1, 2);
INSERT INTO `user_task_detail` VALUES (3, 1, 3);
INSERT INTO `user_task_detail` VALUES (4, 1, 4);
INSERT INTO `user_task_detail` VALUES (5, 2, 4);
INSERT INTO `user_task_detail` VALUES (6, 2, 5);
INSERT INTO `user_task_detail` VALUES (7, 2, 1);
INSERT INTO `user_task_detail` VALUES (8, 2, 2);
INSERT INTO `user_task_detail` VALUES (9, 2, 3);
INSERT INTO `user_task_detail` VALUES (10, 3, 1);
INSERT INTO `user_task_detail` VALUES (11, 3, 2);
INSERT INTO `user_task_detail` VALUES (12, 3, 5);
INSERT INTO `user_task_detail` VALUES (13, 3, 4);
INSERT INTO `user_task_detail` VALUES (14, 4, 5);
INSERT INTO `user_task_detail` VALUES (15, 4, 3);
INSERT INTO `user_task_detail` VALUES (16, 4, 1);
INSERT INTO `user_task_detail` VALUES (17, 4, 6);
INSERT INTO `user_task_detail` VALUES (18, 5, 6);
INSERT INTO `user_task_detail` VALUES (19, 5, 4);
INSERT INTO `user_task_detail` VALUES (20, 5, 5);
INSERT INTO `user_task_detail` VALUES (21, 5, 1);
INSERT INTO `user_task_detail` VALUES (22, 6, 1);
INSERT INTO `user_task_detail` VALUES (23, 6, 2);
INSERT INTO `user_task_detail` VALUES (24, 6, 3);
INSERT INTO `user_task_detail` VALUES (25, 7, 5);
INSERT INTO `user_task_detail` VALUES (26, 7, 6);
INSERT INTO `user_task_detail` VALUES (27, 7, 2);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
