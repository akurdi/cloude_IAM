DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence`
(
    `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `login_table`
--

DROP TABLE IF EXISTS `my_identity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `my_identity`
(
    `id`           bigint NOT NULL,
    `created_date` datetime     DEFAULT NULL,
    `uuid`         varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY            `my_identity_id` (`id`),
    KEY            `my_identity_uuid` (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `my_identityrel`
--

DROP TABLE IF EXISTS `my_identityrel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `my_identityrel`
(
    `id`           bigint       NOT NULL,
    `created_date` datetime DEFAULT NULL,
    `rel_type`     varchar(255) NOT NULL,
    `identity1`    bigint       NOT NULL,
    `identity2`    bigint       NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `UKeeeod89kjytey6lw0afwvcigg` (`identity1`,`identity2`,`rel_type`),
    KEY            `FK10yo3m0dq9wldruqv2smegpce` (`identity2`),
    CONSTRAINT `FK10yo3m0dq9wldruqv2smegpce` FOREIGN KEY (`identity2`) REFERENCES `my_identity` (`id`),
    CONSTRAINT `FKkr7dvchscaqhf9df6sjx0jd2l` FOREIGN KEY (`identity1`) REFERENCES `my_identity` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `my_user`
--

DROP TABLE IF EXISTS `my_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `my_user`
(
    `email`      varchar(255) DEFAULT NULL,
    `first_name` varchar(255) DEFAULT NULL,
    `last_name`  varchar(255) DEFAULT NULL,
    `role`       varchar(255) NOT NULL,
    `id`         bigint       NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `UK_oojv0tfv8mcxgq60bbibie6cm` (`email`),
    KEY          `my_user_email` (`email`),
    CONSTRAINT `FK5750t7mofk606g7ge11h5l6sw` FOREIGN KEY (`id`) REFERENCES `my_identity` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;


DROP TABLE IF EXISTS `my_login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `my_login`
(
    `first_time` bit(1)       NOT NULL,
    `password`   varchar(255) NOT NULL,
    `username`   varchar(255) NOT NULL,
    `id`         bigint       NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `UK_mfr1h6cjt9a0ppemqy41dc9io` (`username`),
    KEY          `my_login_email` (`username`),
    CONSTRAINT `FKkc28xngkwfk2tkod881lagrux` FOREIGN KEY (`id`) REFERENCES `my_identity` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `my_login_log`
--

DROP TABLE IF EXISTS `my_login_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `my_login_log` (
                                `id` bigint NOT NULL,
                                `email` varchar(255) DEFAULT NULL,
                                `login_time` datetime DEFAULT NULL,
                                PRIMARY KEY (`id`),
                                KEY `my_login_loginTime` (`login_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;













