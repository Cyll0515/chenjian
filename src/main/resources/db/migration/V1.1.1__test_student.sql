-- 新增一个表用于统计每个法院新增的用户
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `student_name` VARCHAR(11) NULL DEFAULT NULL COMMENT '学生姓名',
  `sex` VARCHAR(11) NULL DEFAULT NULL COMMENT '性别',
  `age` VARCHAR(11) NULL DEFAULT NULL COMMENT '年龄',
  `create_time` DATETIME NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8 COMMENT = '学生表';


INSERT INTO `student` (`student_name`,`sex`,`age`,`create_time`) VALUES ('大娃', '男','27','2019-01-01 00:00:00');
INSERT INTO `student` (`student_name`,`sex`,`age`,`create_time`) VALUES ('二娃', '女','23','2019-01-01 00:00:00');
INSERT INTO `student` (`student_name`,`sex`,`age`,`create_time`) VALUES ('三娃', '男','28','2019-01-01 00:00:00');
INSERT INTO `student` (`student_name`,`sex`,`age`,`create_time`) VALUES ('四娃', '女','21','2019-01-01 00:00:00');