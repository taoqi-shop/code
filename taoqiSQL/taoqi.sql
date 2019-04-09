/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 8.0.13 : Database - taoqi
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`taoqi` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;

USE `taoqi`;

/*Table structure for table `t_apply` */

DROP TABLE IF EXISTS `t_apply`;

CREATE TABLE `t_apply` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `audit` int(11) DEFAULT NULL,
  `name` varchar(55) DEFAULT NULL,
  `info` varchar(255) DEFAULT NULL,
  `flag` int(1) DEFAULT NULL,
  `stat` int(1) DEFAULT NULL,
  `time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `t_apply_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `t_apply` */

insert  into `t_apply`(`id`,`user_id`,`audit`,`name`,`info`,`flag`,`stat`,`time`) values (1,1,2,'易可旗舰店','撒打算',1,1,'2019-04-09 10:22:12'),(2,2,2,'林林旗舰店','啊萨达萨达',1,1,'2019-04-09 10:24:03'),(3,1,2,'耐克','官方正品',3,0,'2019-04-09 10:25:23'),(4,4,1,'沙发','沙发质量不好',2,0,'2019-04-09 10:28:12');

/*Table structure for table `t_auth` */

DROP TABLE IF EXISTS `t_auth`;

CREATE TABLE `t_auth` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `t_auth_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`),
  CONSTRAINT `t_auth_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `t_role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `t_auth` */

insert  into `t_auth`(`id`,`user_id`,`role_id`) values (1,1,3),(2,3,2),(3,2,3),(4,4,1),(5,1,1),(6,2,1),(7,3,1);

/*Table structure for table `t_car` */

DROP TABLE IF EXISTS `t_car`;

CREATE TABLE `t_car` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `product_id` (`product_id`),
  CONSTRAINT `t_car_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`),
  CONSTRAINT `t_car_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `t_product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `t_car` */

insert  into `t_car`(`id`,`user_id`,`product_id`,`price`,`count`,`time`) values (1,1,1,'7888.00',1,'2019-04-09 10:19:06'),(2,2,2,'580.00',1,'2019-04-09 10:19:18'),(3,3,3,'5800.00',1,'2019-04-09 10:19:54');

/*Table structure for table `t_evaluate` */

DROP TABLE IF EXISTS `t_evaluate`;

CREATE TABLE `t_evaluate` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `order_id` int(11) DEFAULT NULL,
  `reply_id` int(11) DEFAULT NULL,
  `star` int(11) DEFAULT NULL,
  `info` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `order_id` (`order_id`),
  KEY `reply_id` (`reply_id`),
  CONSTRAINT `t_evaluate_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`),
  CONSTRAINT `t_evaluate_ibfk_2` FOREIGN KEY (`order_id`) REFERENCES `t_order` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `t_evaluate` */

insert  into `t_evaluate`(`id`,`user_id`,`order_id`,`reply_id`,`star`,`info`) values (1,4,1,0,5,'物流速度挺快的'),(2,4,1,1,NULL,'谢谢您的好评'),(3,4,3,0,3,'质量不怎么样'),(4,1,3,3,NULL,'谢谢您的意见，我会进行改进的');

/*Table structure for table `t_order` */

DROP TABLE IF EXISTS `t_order`;

CREATE TABLE `t_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `sum` float DEFAULT NULL,
  `del` int(1) DEFAULT NULL,
  `stat` int(1) DEFAULT NULL,
  `time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `product_id` (`product_id`),
  CONSTRAINT `t_order_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`),
  CONSTRAINT `t_order_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `t_product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `t_order` */

insert  into `t_order`(`id`,`user_id`,`product_id`,`count`,`sum`,`del`,`stat`,`time`) values (1,4,2,2,1160,0,0,'2019-04-09 10:05:57'),(2,4,1,1,8888,0,1,'2019-04-09 10:06:26'),(3,4,3,1,5800,1,2,'2019-04-09 10:06:52');

/*Table structure for table `t_product` */

DROP TABLE IF EXISTS `t_product`;

CREATE TABLE `t_product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type_id` int(11) DEFAULT NULL,
  `shop_id` int(11) DEFAULT NULL,
  `imgSrc` varchar(255) DEFAULT NULL,
  `name` varchar(55) DEFAULT NULL,
  `info` varchar(255) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `stock` int(11) DEFAULT NULL,
  `time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `t_product` */

insert  into `t_product`(`id`,`type_id`,`shop_id`,`imgSrc`,`name`,`info`,`price`,`stock`,`time`) values (1,12,1,'暂无图片','iphone X','128GB 黑色 移动联通电信4G全网通手机 双卡双待',8888,100,'2019-04-06 19:44:23'),(2,8,2,'暂无图片','耐克','短袖圆领 黑色',580,150,'2019-04-09 09:58:23'),(3,10,2,'暂无图片','沙发','布艺沙发',5800,200,'2019-04-09 09:59:41');

/*Table structure for table `t_role` */

DROP TABLE IF EXISTS `t_role`;

CREATE TABLE `t_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(55) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `t_role` */

insert  into `t_role`(`id`,`role`) values (1,'USER'),(2,'ADMIN'),(3,'STORE');

/*Table structure for table `t_shop` */

DROP TABLE IF EXISTS `t_shop`;

CREATE TABLE `t_shop` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `name` varchar(55) DEFAULT NULL,
  `info` varchar(255) DEFAULT NULL,
  `time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `t_shop_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `t_shop` */

insert  into `t_shop`(`id`,`user_id`,`name`,`info`,`time`) values (1,2,'林林旗舰店','什么都卖','2019-04-09 10:01:12'),(2,1,'可可旗舰店','精美商品','2019-04-09 10:02:09');

/*Table structure for table `t_spread` */

DROP TABLE IF EXISTS `t_spread`;

CREATE TABLE `t_spread` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `info` varchar(255) DEFAULT NULL,
  `imgSrc` varchar(255) DEFAULT NULL,
  `price` float DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `t_spread_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `t_spread` */

insert  into `t_spread`(`id`,`user_id`,`info`,`imgSrc`,`price`) values (1,1,'暂无地址','暂无图片',2000),(2,2,'暂无地址','暂无图片',5000);

/*Table structure for table `t_type` */

DROP TABLE IF EXISTS `t_type`;

CREATE TABLE `t_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(55) DEFAULT NULL,
  `parent` int(11) DEFAULT NULL,
  `flag` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `t_type` */

insert  into `t_type`(`id`,`name`,`parent`,`flag`) values (1,'电子3C',0,0),(2,'食品',0,0),(3,'手机',1,0),(4,'电脑',1,0),(7,'图像影音',0,0),(8,'服装',0,0),(9,'家电数码',0,0),(10,'家具',0,0),(11,'美妆护肤',0,0),(12,'苹果',3,0),(13,'小米',3,0),(14,'oppo',3,0),(15,'苹果',4,0),(16,'华硕',4,0),(17,'联想',4,0);

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nick_name` varchar(55) DEFAULT NULL,
  `user_name` varchar(55) DEFAULT NULL,
  `pass_word` char(64) DEFAULT NULL,
  `imgSrc` varchar(255) DEFAULT NULL,
  `Salt` varchar(255) DEFAULT NULL,
  `phone` char(11) DEFAULT NULL,
  `address` varchar(55) DEFAULT NULL,
  `stat` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_name` (`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `t_user` */

insert  into `t_user`(`id`,`nick_name`,`user_name`,`pass_word`,`imgSrc`,`Salt`,`phone`,`address`,`stat`) values (1,'易可','oy123','123','1.jpg','55','18335045611','湖南长沙',1),(2,'欧阳御林','oy222','123456','2.jpg','1','13576545911','湖南株洲',1),(3,'刘时明','oy111','333','3.jpg','2','15345624566','广州',2),(4,'小冯','ou123','22222','4.jpg','2','15325645557','湖南湘潭',0);

/*Table structure for table `v` */

DROP TABLE IF EXISTS `v`;

/*!50001 DROP VIEW IF EXISTS `v` */;
/*!50001 DROP TABLE IF EXISTS `v` */;

/*!50001 CREATE TABLE  `v`(
 `id` int(11) ,
 `price` decimal(10,2) ,
 `count` int(11) ,
 `time` datetime ,
 `imgSrc` varchar(255) ,
 `name` varchar(55) 
)*/;

/*Table structure for table `v_evaluate` */

DROP TABLE IF EXISTS `v_evaluate`;

/*!50001 DROP VIEW IF EXISTS `v_evaluate` */;
/*!50001 DROP TABLE IF EXISTS `v_evaluate` */;

/*!50001 CREATE TABLE  `v_evaluate`(
 `id` int(11) ,
 `user_name` varchar(55) ,
 `order_id` int(11) ,
 `reply_id` int(11) ,
 `star` int(11) 
)*/;

/*View structure for view v */

/*!50001 DROP TABLE IF EXISTS `v` */;
/*!50001 DROP VIEW IF EXISTS `v` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v` AS select `c`.`id` AS `id`,`c`.`price` AS `price`,`c`.`count` AS `count`,`c`.`time` AS `time`,`p`.`imgSrc` AS `imgSrc`,`p`.`name` AS `name` from (`t_car` `c` join `t_product` `p`) where (`c`.`product_id` = `p`.`id`) */;

/*View structure for view v_evaluate */

/*!50001 DROP TABLE IF EXISTS `v_evaluate` */;
/*!50001 DROP VIEW IF EXISTS `v_evaluate` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_evaluate` AS select `e`.`id` AS `id`,`u`.`user_name` AS `user_name`,`e`.`order_id` AS `order_id`,`e`.`reply_id` AS `reply_id`,`e`.`star` AS `star` from (`t_evaluate` `e` join `t_user` `u`) where (`e`.`id` = `u`.`id`) */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
