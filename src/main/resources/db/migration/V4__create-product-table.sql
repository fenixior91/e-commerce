DROP TABLE IF EXISTS products;

CREATE TABLE products
(
    id             BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    version        INT UNSIGNED DEFAULT 0,
    name           VARCHAR(255),
    description    TEXT,
    price          DECIMAL(10, 2),
    stock_quantity INT,
    category_id    BIGINT UNSIGNED,
    image_url      VARCHAR(500),
    created_at     TIMESTAMP NULL,
    updated_at     TIMESTAMP NULL,
    FOREIGN KEY (category_id) REFERENCES categories (id)
);

CREATE INDEX idx_products_category_id ON products (category_id);