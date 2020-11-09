/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : flinkplus

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2020-11-09 15:36:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `job`
-- ----------------------------
DROP TABLE IF EXISTS `job`;
CREATE TABLE `job` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(255) NOT NULL COMMENT '作业名称',
  `description` varchar(1024) NOT NULL DEFAULT '' COMMENT '作业描述',
  `type` tinyint(4) NOT NULL COMMENT '作业类型',
  `client_version` varchar(20) NOT NULL DEFAULT '' COMMENT '客户端版本',
  `flink_config_json` mediumtext COMMENT '作业flink参数配置',
  `extra_config_json` mediumtext COMMENT '作业额外配置',
  `last_instance_id` bigint(20) DEFAULT NULL COMMENT '最新实例的ID',
  `last_status` tinyint(4) DEFAULT NULL COMMENT '最新实例的状态',
  `last_app_id` varchar(100) DEFAULT NULL COMMENT '最新实例的app_id',
  `last_start_time` timestamp NULL DEFAULT NULL COMMENT '最新实例的开始时间',
  `last_stop_time` timestamp NULL DEFAULT NULL COMMENT '最新实例的结束时间',
  `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '记录的创建时间',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '记录的更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniq_name` (`name`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='作业表';

-- ----------------------------
-- Records of job
-- ----------------------------

-- ----------------------------
-- Table structure for `job_instance`
-- ----------------------------
DROP TABLE IF EXISTS `job_instance`;
CREATE TABLE `job_instance` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `job_id` bigint(20) NOT NULL COMMENT '作业的ID, 即 job 表的 id',
  `flink_config_json` mediumtext COMMENT '实例启动时的镜像flink参数配置',
  `extra_config_json` mediumtext COMMENT '实例启动时的镜像额外配置',
  `status` tinyint(4) NOT NULL COMMENT '实例的状态',
  `app_id` varchar(100) DEFAULT NULL COMMENT '实例的集群任务id',
  `start_time` timestamp NULL DEFAULT NULL COMMENT '实例的开始时间',
  `stop_time` timestamp NULL DEFAULT NULL COMMENT '实例的结束时间',
  `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '记录的创建时间',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '记录的更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_job_id` (`job_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='作业实例表';

-- ----------------------------
-- Records of job_instance
-- ----------------------------
