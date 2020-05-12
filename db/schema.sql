/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
DROP TABLE IF EXISTS `t_config`;
CREATE TABLE `t_config` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `conf_name` varchar(50) NOT NULL DEFAULT '' COMMENT '名称，必须唯一，用英文不要用空格',
  `conf_value` varchar(1000) DEFAULT NULL COMMENT '属性的值',
  `comment` varchar(128) DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`id`),
  UNIQUE KEY `key_name_UNIQUE` (`conf_name`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='全局配置表，保存一些基本配置信息或参数，也用于做某些后台任务的锁定，任务启动时锁定某行，避免一个任务在多个服务器上同时执行';


DROP TABLE IF EXISTS `t_block`;
CREATE TABLE `t_block` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `height` bigint(20) NOT NULL COMMENT '区块高度',
  `hash` varchar(64) NOT NULL COMMENT '区块哈希',
  `created_at` datetime NOT NULL COMMENT '出块时间',
  `tx_num` int(11) NOT NULL COMMENT '交易个数',
  `reward` bigint(11) NOT NULL COMMENT '奖励',
  `sent` bigint(11) NOT NULL COMMENT '交易的发送主币数量',
  `fee` bigint(11) NOT NULL COMMENT '手续费',
  `version` int(11) NOT NULL COMMENT '版本号',
  `size` int(11) NOT NULL COMMENT '区块大小',
  `proposer_address` varchar(64) NOT NULL COMMENT '出块人哈希',
  PRIMARY KEY (`id`),
  UNIQUE KEY `ix_hash` (`hash`),
  UNIQUE KEY `ix_height` (`height`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

DROP TABLE IF EXISTS `t_transaction`;
CREATE TABLE `t_transaction` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type` tinyint(4) NOT NULL COMMENT '1 转账（包括内置货币和代币的转账） 2: 创建订单 3： 取消订单 4 发行代币 5 创建交易市场',
  `success` tinyint(1) NOT NULL COMMENT '1 成功 0 失败',
  `height` bigint(20) NOT NULL COMMENT '区块高度',
  `hash` varchar(64) NOT NULL COMMENT '交易哈希',
  `sender` varchar(64) NOT NULL COMMENT '交易发送者地址',
  `memo` varchar(64) NOT NULL COMMENT '交易备注',
  `created_at` datetime NOT NULL COMMENT '所在区块的时间',
  `msg_num` int(11) NOT NULL COMMENT '消息个数',
  `fee` bigint(11) NOT NULL COMMENT '手续费',
  PRIMARY KEY (`id`),
  UNIQUE KEY `ix_hash` (`hash`),
  KEY `ix_height` (`height`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


DROP TABLE IF EXISTS `t_account`;
CREATE TABLE `t_account` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(64) NOT NULL ,
  `asset_num` bigint(20) NOT NULL COMMENT '创建高度',
  `tx_num` bigint(20) NOT NULL COMMENT '创建高度',
  `fee` bigint(20) NOT NULL COMMENT '创建高度',
  `created_at` datetime NOT NULL COMMENT '出块时间',
  `creation_height` bigint(20) NOT NULL COMMENT '出块时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `ix_address` (`address`),
  KEY `ix_height` (`creation_height`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


DROP TABLE IF EXISTS `t_asset`;
CREATE TABLE `t_asset` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(16) NOT NULL ,
  `description` varchar(64) NOT NULL COMMENT '全部数量' ,
  `total_supply` bigint(20) NOT NULL COMMENT '全部数量',
  `issuer` varchar(64) NOT NULL COMMENT '发行账号地址',
  `decimals` int(20) NOT NULL COMMENT '分解个数',
  `created_at` datetime NOT NULL COMMENT '出块时间',
  `creation_height` bigint(20) NOT NULL COMMENT '出块时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `ix_name` (`name`),
  KEY `ix_height` (`creation_height`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


DROP TABLE IF EXISTS `t_transfer`;
CREATE TABLE `t_transfer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type` tinyint(2) NOT NULL COMMENT '1: 发行token 2: 转移token 3: 创建市场 4： DEX订单',
  `height` bigint(20) NOT NULL COMMENT '区块高度',
  `tx_hash` varchar(64) NOT NULL COMMENT '交易哈希',
  `sender` varchar(64) NOT NULL COMMENT '交易发送者',
  `recipient` varchar(64) NOT NULL COMMENT '交易接受者，在发币交易中，接收者就是发币者, 在市场交易中，没有接收者',
  `amount` bigint(20) NOT NULL COMMENT '数量',
  `token` varchar(64) NOT NULL COMMENT '发送的代币名称',
  `created_at` datetime NOT NULL COMMENT '交易时间',
  PRIMARY KEY (`id`),
  KEY `ix_hash` (`tx_hash`),
  KEY `ix_sender` (`sender`),
  KEY `ix_recipient` (`recipient`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

DROP TABLE IF EXISTS `t_validator`;
CREATE TABLE `t_validator` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `operator_address` varchar(128) NOT NULL COMMENT '运营商地址',
  `address` varchar(64) NOT NULL COMMENT '验证人地址',
  `consensus_pubkey` varchar(256) NOT NULL COMMENT '验证节点公钥',
  `proposer_address` varchar(64) NOT NULL COMMENT '验证节点地址，就是每个block的proposer_address',
  `moniker` varchar(64) NOT NULL COMMENT '验证节点名称',
  `status` tinyint(2) NOT NULL COMMENT '2 正常',
  `created_at` datetime NOT NULL COMMENT '交易时间',
  PRIMARY KEY (`id`),
  KEY `ix_hash` (`proposer_address`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;