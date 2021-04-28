-- 新增一个表用于统计每个法院新增的用户
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` VARCHAR(32) NOT NULL COMMENT '主键UUID',
  `user_name` VARCHAR(50) NULL DEFAULT NULL COMMENT '用户姓名',
  `user_type` VARCHAR(2) NULL DEFAULT NULL COMMENT '用户类型：1-学生；2-老师',
  `account` VARCHAR(50) NULL DEFAULT NULL COMMENT '账号',
  `password` VARCHAR(50) NULL DEFAULT NULL COMMENT '密码',
  `id_card_no` VARCHAR(25) NULL DEFAULT NULL COMMENT '身份证号',
  `department_id` INT(11) NULL DEFAULT NULL COMMENT '部门',
  `position_id` INT(11) NULL DEFAULT NULL COMMENT '职务',
  `phone` VARCHAR(50) NULL DEFAULT NULL COMMENT '电话',
  `email` VARCHAR(50) NULL DEFAULT NULL COMMENT '邮箱',
  `create_user` INT(11) NULL DEFAULT NULL COMMENT '创建人',
  `create_time` DATETIME NULL DEFAULT NULL COMMENT '创建时间',
  `update_user` INT(11) NULL DEFAULT NULL COMMENT '修改人',
  `update_time` DATETIME NULL DEFAULT NULL COMMENT '修改时间',
  `valid` VARCHAR(10) NULL DEFAULT NULL COMMENT '数据是否失效：0:-失效，1-有效',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8 COMMENT = '系统用户表';

INSERT INTO `sys_user` (`id`,`user_name`,`user_type`,`account`,`password`,`id_card_no`,`department_id`,`position_id`,`phone`,`email`,`create_user`,`create_time`,`update_user`,`update_time`,`valid`) VALUES ('7e83839f7b4e42b2a11f4f3473278e2d','管理员', '0','admin','123456','身份证号',1,1,'电话','邮箱',1,'2019-01-01 00:00:00',null,null,'1');
INSERT INTO `sys_user` (`id`,`user_name`,`user_type`,`account`,`password`,`id_card_no`,`department_id`,`position_id`,`phone`,`email`,`create_user`,`create_time`,`update_user`,`update_time`,`valid`) VALUES ('f384d5037dc84718a35c6755a7fa77c2','爷爷', '1','admin1','123456','身份证号',2,2,'电话','邮箱',1,'2019-01-01 00:00:00',null,null,'1');
INSERT INTO `sys_user` (`id`,`user_name`,`user_type`,`account`,`password`,`id_card_no`,`department_id`,`position_id`,`phone`,`email`,`create_user`,`create_time`,`update_user`,`update_time`,`valid`) VALUES ('bb1f8ea5b95b416ebd6dce59fb696052','蛇精', '2','admin2','123456','身份证号',3,3,'电话','邮箱',1,'2019-01-01 00:00:00',null,null,'1');