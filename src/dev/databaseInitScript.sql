CREATE SCHEMA IF NOT EXISTS productList DEFAULT CHARACTER SET utf8;
USE productList;

CREATE TABLE IF NOT EXISTS products
(
  ProductId          BIGINT                            NOT NULL AUTO_INCREMENT,
  productName        VARCHAR(100)                      NOT NULL,
  productCategory    ENUM ('FRUIT', 'ALCOHOL', 'MEAT') NOT NULL,
  productPrice       DECIMAL                           NOT NULL,
  productDiscount    DECIMAL                           NOT NULL,
  productActualPrice DECIMAL                           NOT NULL,
  productDescription VARCHAR(100)                      NULL,
  createdProduct     TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (ProductId)
)
  character set utf8
  ENGINE = InnoDB
  AUTO_INCREMENT = 1;

CREATE TABLE IF NOT EXISTS shopping_cart
(
  shoppingCartId BIGINT NOT NULL AUTO_INCREMENT,
  createdProduct TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (shoppingCartId)
)
  character set utf8
  ENGINE = InnoDB
  AUTO_INCREMENT = 1;

CREATE TABLE IF NOT EXISTS product_shopping_cart
(
  productShoppingCartId BIGINT NOT NULL AUTO_INCREMENT,
  productId             BIGINT NOT NULL,
  shoppingCartId        BIGINT NOT NULL,
  createdProduct        TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (productShoppingCartId)
)
  character set utf8
  ENGINE = InnoDB
  AUTO_INCREMENT = 1;

ALTER TABLE product_shopping_cart
  ADD CONSTRAINT fk_productShoppingCart_shoppingCartId FOREIGN KEY (shoppingCartId)
    REFERENCES shopping_cart (shoppingCartId);

ALTER TABLE product_shopping_cart
  ADD CONSTRAINT fk_productId_productId FOREIGN KEY (productId)
    REFERENCES products (ProductId);