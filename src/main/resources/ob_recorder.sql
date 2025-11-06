CREATE TABLE `job` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `company_name` varchar(255) NOT NULL,
  `job_name` varchar(255) NOT NULL,
  `salary` varchar(255) DEFAULT NULL,
  `requirements` text,
  `location` varchar(255) DEFAULT NULL,
  `experience` varchar(255) DEFAULT NULL,
  `education` varchar(255) DEFAULT NULL,
  `description` text,
  `contact_info` varchar(255) DEFAULT NULL,
  `source` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL COMMENT '申请状态：未申请、已申请、面试中、已录用、已拒绝',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 创建常用查询索引
CREATE INDEX idx_company_name ON `job` (`company_name`);
CREATE INDEX idx_job_name ON `job` (`job_name`);
CREATE INDEX idx_status ON `job` (`status`);
CREATE INDEX idx_create_time ON `job` (`create_time`);