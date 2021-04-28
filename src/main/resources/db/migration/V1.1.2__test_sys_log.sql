-- 新增一个表用于统计每个法院新增的用户
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
  `log_id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `request_ip` VARCHAR(50) NULL DEFAULT NULL COMMENT '请求ip',
  `request_uri` VARCHAR(100) NULL DEFAULT NULL COMMENT '请求路径',
  `request_method` VARCHAR(50) NULL DEFAULT NULL COMMENT '请求方式(get,post)',
  `request_params` VARCHAR(500) NULL DEFAULT NULL COMMENT '请求参数',
  `user_agent` VARCHAR(500) NULL DEFAULT NULL COMMENT '代理',
  `create_time` DATETIME NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`log_id`) USING BTREE
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8 COMMENT = '系统日志表';

