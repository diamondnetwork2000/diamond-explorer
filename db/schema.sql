/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
DROP TABLE IF EXISTS `t_config`;
CREATE TABLE `t_config` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `conf_name` varchar(50) NOT NULL DEFAULT '' COMMENT 'name',
  `conf_value` varchar(1000) DEFAULT NULL COMMENT 'value',
  `comment` varchar(128) DEFAULT NULL COMMENT 'comment',
  PRIMARY KEY (`id`),
  UNIQUE KEY `key_name_UNIQUE` (`conf_name`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC COMMENT='Global configurations';


DROP TABLE IF EXISTS `t_block`;
CREATE TABLE `t_block` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `height` bigint(20) NOT NULL COMMENT 'block height',
  `hash` varchar(64) NOT NULL COMMENT 'block hash',
  `created_at` datetime NOT NULL COMMENT 'block creation time',
  `tx_num` int(11) NOT NULL COMMENT 'transction number in this block',
  `reward` bigint(11) NOT NULL COMMENT 'block reward (only minted)',
  `sent` bigint(11) NOT NULL COMMENT 'how much token is sent in this block',
  `fee` bigint(11) NOT NULL COMMENT 'fee',
  `version` int(11) NOT NULL COMMENT 'version',
  `size` int(11) NOT NULL COMMENT 'block size in byte',
  `proposer_address` varchar(64) NOT NULL COMMENT 'the address in HEX format',
  PRIMARY KEY (`id`),
  UNIQUE KEY `ix_hash` (`hash`),
  UNIQUE KEY `ix_height` (`height`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

DROP TABLE IF EXISTS `t_transaction`;
CREATE TABLE `t_transaction` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type` tinyint(4) NOT NULL COMMENT '1 transfer 2: create order 3： cancel order 4 issue token 5 create market',
  `success` tinyint(1) NOT NULL COMMENT '1 successful 0 failed',
  `height` bigint(20) NOT NULL COMMENT 'block height',
  `hash` varchar(64) NOT NULL COMMENT 'transaction hash',
  `sender` varchar(64) NOT NULL COMMENT 'the address of sender',
  `memo` varchar(64) NOT NULL COMMENT 'the comment of transaction',
  `created_at` datetime NOT NULL COMMENT 'block creation time',
  `msg_num` int(11) NOT NULL COMMENT 'message number',
  `fee` bigint(11) NOT NULL COMMENT 'fee',
  PRIMARY KEY (`id`),
  UNIQUE KEY `ix_hash` (`hash`),
  KEY `ix_height` (`height`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;


DROP TABLE IF EXISTS `t_account`;
CREATE TABLE `t_account` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(64) NOT NULL ,
  `asset_num` bigint(20) NOT NULL COMMENT 'ceation time',
  `tx_num` bigint(20) NOT NULL COMMENT 'transaction number',
  `fee` bigint(20) NOT NULL COMMENT 'fee',
  `created_at` datetime NOT NULL COMMENT 'ceation time',
  `creation_height` bigint(20) NOT NULL COMMENT 'creation block height',
  PRIMARY KEY (`id`),
  UNIQUE KEY `ix_address` (`address`),
  KEY `ix_height` (`creation_height`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;


DROP TABLE IF EXISTS `t_asset`;
CREATE TABLE `t_asset` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(16) NOT NULL ,
  `description` varchar(64) NOT NULL COMMENT 'description' ,
  `total_supply` decimal(32,0) NOT NULL COMMENT 'total supply',
  `issuer` varchar(64) NOT NULL COMMENT 'the account who issue this token',
  `owner` varchar(64) NOT NULL COMMENT 'the account who owns this token',
  `decimals` int(20) NOT NULL COMMENT 'decimals',
  `created_at` datetime NOT NULL COMMENT 'creation time',
  `creation_height` bigint(20) NOT NULL COMMENT 'creation block height',
  PRIMARY KEY (`id`),
  UNIQUE KEY `ix_name` (`name`),
  KEY `ix_height` (`creation_height`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;


DROP TABLE IF EXISTS `t_transfer`;
CREATE TABLE `t_transfer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type` tinyint(2) NOT NULL COMMENT '1 transfer 2: create order 3： cancel order 4 issue token 5 create market',
  `height` bigint(20) NOT NULL COMMENT 'block height',
  `tx_hash` varchar(64) NOT NULL COMMENT 'transaction hash',
  `sender` varchar(64) NOT NULL COMMENT 'the account who sends the token',
  `recipient` varchar(64) NOT NULL COMMENT 'the account who receives the token',
  `amount` decimal(32,0) NOT NULL COMMENT 'amount',
  `token` varchar(64) NOT NULL COMMENT 'token symbol',
  `created_at` datetime NOT NULL COMMENT 'block creation time',
  PRIMARY KEY (`id`),
  KEY `ix_hash` (`tx_hash`),
  KEY `ix_sender` (`sender`),
  KEY `ix_recipient` (`recipient`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

DROP TABLE IF EXISTS `t_validator`;
CREATE TABLE `t_validator` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `operator_address` varchar(128) NOT NULL COMMENT 'operation address',
  `address` varchar(64) NOT NULL COMMENT 'validator address',
  `consensus_pubkey` varchar(256) NOT NULL COMMENT 'public key of node',
  `proposer_address` varchar(64) NOT NULL COMMENT 'proposer_address in each blok',
  `moniker` varchar(64) NOT NULL COMMENT 'node name',
  `status` tinyint(2) NOT NULL COMMENT '2 success',
  `created_at` datetime NOT NULL COMMENT 'creation time',
  PRIMARY KEY (`id`),
  KEY `ix_hash` (`proposer_address`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

DROP TABLE IF EXISTS `t_bill`;
CREATE TABLE `t_bill` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `account` varchar(64) NOT NULL COMMENT 'the account who receives the token',
  `change_amount` decimal(32,0)  NOT NULL COMMENT 'amount',
  `token` varchar(64) NOT NULL COMMENT 'token symbol',
  `type` tinyint(2) NOT NULL COMMENT '1 transfer 2: create order 3： cancel order 4 issue token 5 create market',
  `height` bigint(20) NOT NULL COMMENT 'block height',
  `tx_hash` varchar(64) NOT NULL COMMENT 'transaction hash',
  `sender` varchar(64) NOT NULL COMMENT 'the account who sends the token',
  `recipient` varchar(64) NOT NULL COMMENT 'the account who receives the token',
  `created_at` datetime NOT NULL COMMENT 'block creation time',
  PRIMARY KEY (`id`),
  KEY `ix_hash` (`tx_hash`),
  KEY `ix_account` (`account`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;


DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sender` varchar(64) NOT NULL COMMENT 'the account who create the order',
  `price` decimal(32,0)  NOT NULL COMMENT 'price',
  `quantity` decimal(32,0)  NOT NULL COMMENT 'quantity',
  `trading_pair` varchar(64) NOT NULL COMMENT 'market',
  `type` tinyint(2) NOT NULL COMMENT '1 transfer 2: create order 3： cancel order 4 issue token 5 create market',
  `price_precision` int(2) NOT NULL COMMENT '1 transfer 2: create order 3： cancel order 4 issue token 5 create market',
  `side` tinyint(2) NOT NULL COMMENT '1 buy 2: sell',
  `height` bigint(20) NOT NULL COMMENT 'block height',
  `tx_hash` varchar(64) NOT NULL COMMENT 'transaction hash',
  `created_at` datetime NOT NULL COMMENT 'block creation time',
  PRIMARY KEY (`id`),
  KEY `ix_hash` (`tx_hash`),
  KEY `ix_sender` (`sender`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;


DROP TABLE IF EXISTS `t_message`;
CREATE TABLE `t_message` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sender` varchar(64) NOT NULL COMMENT 'the account who create the order',
  `json_content` varchar(512) DEFAULT NULL COMMENT 'the detailed content',
  `type` tinyint(2) NOT NULL COMMENT '1 transfer 2: create order 3： cancel order 4 issue token 5 create market',
  `height` bigint(20) NOT NULL COMMENT 'block height',
  `tx_hash` varchar(64) NOT NULL COMMENT 'transaction hash',
  `created_at` datetime NOT NULL COMMENT 'block creation time',
  PRIMARY KEY (`id`),
  KEY `ix_hash` (`tx_hash`),
  KEY `ix_sender` (`sender`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;