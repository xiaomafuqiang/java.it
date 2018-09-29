drop table if exists sys_user, sys_role, sys_user_role;

 CREATE TABLE `sys_user` (
`user_id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '用户id',
`user_code` varchar(32) NOT NULL COMMENT '用户账号',
`user_name` varchar(64) NOT NULL COMMENT '用户名称',
`user_password` varchar(32) NOT NULL COMMENT '用户密码',
`user_state` char(1) NOT NULL COMMENT '1:正常,0:暂停',
PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

 CREATE TABLE `sys_role` (
`role_id` bigint(32) NOT NULL AUTO_INCREMENT,
`role_name` varchar(32) NOT NULL COMMENT '角色名称',
`role_memo` varchar(128) DEFAULT NULL COMMENT '备注',
PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `sys_user_role` (
  `role_id` bigint(32) NOT NULL COMMENT '角色id',
  `user_id` bigint(32) NOT NULL COMMENT '用户id',
  PRIMARY KEY (`role_id`,`user_id`),
  KEY `FK_user_role_user_id` (`user_id`),
  CONSTRAINT `FK_user_role_role_id` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`role_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_user_role_user_id` FOREIGN KEY (`user_id`) REFERENCES `sys_user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;