-- 创建crmdb数据库
create database if not exists `crmdb`;

-- 使用该数据库
USE `crmdb`;

-- 创建部门表
CREATE TABLE `crm_department` (
  `depId` varchar(255) NOT NULL PRIMARY KEY,
  `depName` varchar(50) DEFAULT NULL
);

-- 向部门表中插入数据
insert  into `crm_department`(`depId`,`depName`) 
	values ('2c9091c14c78e58b014c78e67de10001','java学院'),
			('2c9091c14c78e58b014c78e68ded0002','咨询部');

-- 创建职务表
CREATE TABLE `crm_post` (
  `postId` varchar(255) NOT NULL PRIMARY KEY,
  `postName` varchar(100) DEFAULT NULL,
  `depId` varchar(255) DEFAULT NULL,
  CONSTRAINT FOREIGN KEY (`depId`) REFERENCES `crm_department` (`depId`)
);

-- 向职务表中插入数据
insert  into `crm_post`(`postId`,`postName`,`depId`) 
	values ('2c9091c14c78e58b014c78e6b34a0003','总监','2c9091c14c78e58b014c78e67de10001'),
			('2c9091c14c78e58b014c78e6d4510004','讲师','2c9091c14c78e58b014c78e67de10001'),
			('2c9091c14c78e58b014c78e6f2340005','主管','2c9091c14c78e58b014c78e68ded0002');

-- 创建员工表
CREATE TABLE `crm_staff` (
  `staffId` varchar(255) NOT NULL PRIMARY KEY,
  `loginName` varchar(100) DEFAULT NULL,
  `loginPwd` varchar(100) DEFAULT NULL,
  `staffName` varchar(100) DEFAULT NULL,
  `gender` varchar(20) DEFAULT NULL,
  `onDutyDate` datetime DEFAULT NULL,
  `postId` varchar(255) DEFAULT NULL,
  CONSTRAINT FOREIGN KEY (`postId`) REFERENCES `crm_post` (`postId`)
);

-- 向员工表中插入数据
insert  into `crm_staff`(`staffId`,`loginName`,`loginPwd`,`staffName`,`gender`,`onDutyDate`,`postId`) 
	values ('2c9091c14c78e58b014c78e5c32a0000','jack','81dc9bdb52d04dc20036dbd8313ed055','管理员',NULL,NULL,NULL),
			('2c9091c14c78e58b014c78e759b40006','rose','81dc9bdb52d04dc20036dbd8313ed055','肉丝','女','2013-04-16 00:00:00','2c9091c14c78e58b014c78e6f2340005'),
			('2c9091c14c78e58b014c78e7ecd90007','tom','81dc9bdb52d04dc20036dbd8313ed055','汤姆','男','2014-04-24 00:00:00','2c9091c14c78e58b014c78e6d4510004');

-- 创建课程类别表
CREATE TABLE `crm_course_type` (
  `courseTypeId` varchar(255) NOT NULL PRIMARY KEY,
  `courseCost` double DEFAULT NULL,
  `total` int(11) DEFAULT NULL,
  `courseName` varchar(500) DEFAULT NULL,
  `remark` varchar(5000) DEFAULT NULL
);

-- 向课程类别表中插入数据
insert  into `crm_course_type`(`courseTypeId`,`courseCost`,`total`,`courseName`,`remark`) 
	values ('2c9091c14c78e58b014c78e829b70008',2000,1000,'java基础',''),
		('2c9091c14c78e58b014c78e867b80009',18000,4000,'java就业','');

-- 创建班级表	
CREATE TABLE `crm_class` (
  `classId` varchar(50) NOT NULL PRIMARY KEY,
  `courseTypeId` varchar(255) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `beginTime` datetime DEFAULT NULL,
  `endTime` datetime DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  `totalCount` int(11) DEFAULT NULL,
  `upgradeCount` int(11) DEFAULT NULL,
  `changeCount` int(11) DEFAULT NULL,
  `runoffCount` int(11) DEFAULT NULL,
  `remark` varchar(500) DEFAULT NULL,
  `uploadTime` datetime DEFAULT NULL,
  `uploadPath` varchar(200) DEFAULT NULL,
  `uploadFilename` varchar(100) DEFAULT NULL,
  CONSTRAINT FOREIGN KEY (`courseTypeId`) REFERENCES `crm_course_type` (`courseTypeId`)
) ;

-- 向班级表中插入数据
insert  into `crm_class`(`classId`,`courseTypeId`,`name`,`beginTime`,`endTime`,`status`,`totalCount`,`upgradeCount`,`changeCount`,`runoffCount`,`remark`,`uploadTime`,`uploadPath`,`uploadFilename`) 
	values ('2c9091c14c78e58b014c78e8cc62000a','2c9091c14c78e58b014c78e829b70008','1期','2015-03-10 00:00:00','2015-04-30 00:00:00',NULL,80,2,0,2,'','2015-04-02 16:33:09','/WEB-INF/upload/0d7a042741544da988b2d2462c683e57','(第173期)2015年01月22日 JavaEE就业班.xls'),
	('2c9091c14c78e58b014c78e9106e000b','2c9091c14c78e58b014c78e829b70008','2期','2015-04-28 00:00:00','2015-05-27 00:00:00',NULL,67,0,0,0,'',NULL,NULL,NULL),
	('2c9091c14c78e58b014c78e9601a000c','2c9091c14c78e58b014c78e867b80009','1期ee','2015-03-29 00:00:00','2015-07-13 00:00:00',NULL,120,0,0,0,'',NULL,NULL,NULL);


