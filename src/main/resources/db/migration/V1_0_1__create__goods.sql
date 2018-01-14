CREATE TABLE `goods` (
  `id`             BIGINT       NOT NULL AUTO_INCREMENT,
  `name`           VARCHAR(50)  NOT NULL,
  `price`          FLOAT        NOT NULL,
  `description`    VARCHAR(200) NULL,
  `stock_quantity` INT          NULL,
  PRIMARY KEY (`id`)
);
