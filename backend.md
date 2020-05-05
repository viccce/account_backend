# 表结构
## 用户表 user
| 字段名 | 备注 |
| --- | --- |
| user_id | ID |
| nickname| 名称 |
| mobile | 手机号 |
| email | 邮箱 |
| password| 密码 |
| remark | 备注 |
``` sql
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `nickname` varchar(64) NOT NULL COMMENT '昵称',
  `mobile` varchar(32) NOT NULL COMMENT '手机号',
  `email` varchar(64) NOT NULL COMMENT '邮箱',
  `password` varchar(64) NOT NULL COMMENT '密码',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```

## 账目表 account
| 字段名 | 备注 |
| --- | --- |
| account_id | ID |
| account_name| 账目名称|
| balance | 余额(单位: 分)|
| timestamp| 时间戳 |
``` sql
CREATE TABLE `account` (
  `account_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `account_name` varchar(64) NOT NULL COMMENT '账目名称',
  `balance` bigint(20) NOT NULL COMMENT '余额(单位: 分',
  `timestamap` bigint(20) NOT NULL COMMENT '时间戳',
  PRIMARY KEY (`account_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
```
## 账目明细表 account_line
| 字段名 | 备注 |
| --- | --- |
| account_line_id | ID |
| account_id | 主表ID |
| account_type| 账目明细类型 |
| change_money | 金额变动(单位: 分) |
| change_time | 变动时间 |
| change_user_id| 交易人ID |
| pay_type | 支付方式 |
```sql
CREATE TABLE `account_line` (
  `account_line_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '明细ID',
  `account_id` int(11) NOT NULL COMMENT '账目ID',
  `change_money` bigint(20) NOT NULL COMMENT '金额变动(单位: 分)',
  `account_type` varchar(20) NOT NULL COMMENT '账目明细类型',
  `change_time` datetime NOT NULL COMMENT '交易时间',
  `change_user_id` int(11) NOT NULL COMMENT '交易人ID',
  `pay_type` varchar(20) DEFAULT NULL COMMENT '支付方式',
  PRIMARY KEY (`account_line_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```
## 账目用户关联关系表 account_user_relation
| 字段名 | 备注 |
| --- | --- |
| account_id | 账目ID |
| user_id | 用户ID |
```sql
CREATE TABLE `account_user_relation` (
  `account_id` int(11) NOT NULL COMMENT '账目ID',
  `user_id` int(11) NOT NULL COMMENT '用户ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```
