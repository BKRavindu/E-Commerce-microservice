CREATE TABLE tb_orders (
                           id BIGINT AUTO_INCREMENT PRIMARY KEY,
                           order_id VARCHAR(100) NOT NULL,
                           sku_code VARCHAR(100) NOT NULL,
                           quantity INT NOT NULL,
                           price DECIMAL(15, 2) NOT NULL
);
