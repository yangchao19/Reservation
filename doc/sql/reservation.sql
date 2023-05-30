CREATE DATABASE reservation;

USE reservation;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`(
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
    `student_id` BIGINT(20) NOT NULL COMMENT '学生id',
    `student_name` VARCHAR(64) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '学生姓名',
    `parent_name` VARCHAR(64) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '家长姓名',
    `phone` VARCHAR(64) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '家长电话',
    `grade` VARCHAR(64) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '年级',
    `register_date` DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '注册时间',
    `update_date` DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `unique_student_id`(`student_id`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='学生配置';


-- ----------------------------
-- Records of student
-- ----------------------------
BEGIN;
INSERT INTO `student` VALUES (1,100001, '学生名', '家长名','1234567890', '三年级', '2023-05-01 00:00:00', '2023-05-07 23:59:59');
COMMIT;

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;

CREATE TABLE `teacher`(
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
    `teacher_id` BIGINT(20) NOT NULL COMMENT '教师id',
    `username` VARCHAR(64) NOT NULL COMMENT '用户名',
    `password` VARCHAR(64) NOT NULL COMMENT '密码',
    `status` INT DEFAULT 1 COMMENT '用户状态信息',
    `teacher_name` VARCHAR(64) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '教师姓名',
    `subject` VARCHAR(64) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '教学科目 0：其他 1:语文 2：数学 3：外语 4：物理 5：化学 6：生物 7：政治 8：历史 9：地理 10：技术',
    `phone` VARCHAR(64) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '教师电话',
    `info` VARCHAR(64) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '教师备注信息',
    `register_date` DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '注册时间',
    `update_date` DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    `creator_id` BIGINT(20) NOT NULL COMMENT '创建者id',
    `updater_id` BIGINT(20) NOT NULL COMMENT '更新人id',
    PRIMARY KEY (`id`),
    UNIQUE KEY `unique_teacher_id`(`teacher_id`),
    UNIQUE KEY `unique_username`(`username`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='教师配置';

-- ----------------------------
-- Records of teacher
-- ----------------------------
BEGIN;
INSERT INTO `teacher` VALUES ('1', '100001', 'admin', 'e10adc3949ba59abbe56e057f20f883e', '1', '教师名', '1', '1234567890', '备注信息',  '2023-05-01 00:00:00', '2023-05-07 23:59:59', '100001', '100001');
COMMIT;

-- ----------------------------
-- Table structure for curriculum
-- ----------------------------
DROP TABLE IF EXISTS `curriculum`;
CREATE TABLE `curriculum`(
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
    `curriculum_id` BIGINT(20) NOT NULL COMMENT '课程ID',
    `curriculum_name` VARCHAR(64) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '课程名称',
    `teacher_id` BIGINT(20) NOT NULL COMMENT '教师ID',
    `teacher_name` VARCHAR(64) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '教师姓名',
    `price` INT DEFAULT 0 COMMENT '价格',
    `stock` INT NOT NULL COMMENT '课程可预约总数',
    `stock_used` INT NOT NULL COMMENT '课程已预约数',
    `begin_time` DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '课程开始时间',
    `end_time` DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '课程结束时间',
    `info` VARCHAR(64) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '课程备注信息',
    PRIMARY KEY (`id`),
    UNIQUE KEY `unique_curriculum_id`(`curriculum_id`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='课程配置';



-- ----------------------------
-- Records of curriculum
-- ----------------------------
BEGIN;
INSERT INTO `curriculum` VALUES (1, '10008','测试课程', '100001', 'admin',80, 100, 3, '2023-05-07 08:00:00', '2023-05-07 11:00:00', '课程备注信息');
COMMIT;


-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`(
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
    `order_id` BIGINT(20) NOT NULL COMMENT '订单ID',
    `student_id` BIGINT(20) NOT NULL COMMENT '学生ID',
    `curriculum_id` BIGINT(20) NOT NULL COMMENT '课程ID',
    `teacher_id` BIGINT(20) NOT NULL COMMENT '教师ID',
    `status` INT DEFAULT 0 COMMENT '订单状态',
    `date` DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '下单时间',
    `money` INT DEFAULT 0 COMMENT '实付金额',
    PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='课程预约订单配置';

-- ----------------------------
-- Records of order
-- ----------------------------
BEGIN;
INSERT INTO `order` VALUES (1,'1000001','100001','10008','321217272',0,NOW(),90);
COMMIT