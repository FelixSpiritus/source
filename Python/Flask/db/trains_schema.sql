CREATE TABLE `trains` (
  `id` int NOT NULL AUTO_INCREMENT,
  `train_num` text,
  `dep_date` text,
  `dep_time` text,
  `arr_date` text,
  `arr_time` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;