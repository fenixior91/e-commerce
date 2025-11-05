DROP TABLE IF EXISTS orders;

CREATE TABLE orders
(
    id          BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    version     INT                                                           DEFAULT 0,
    user_id     BIGINT UNSIGNED NOT NULL,
    address_id  BIGINT UNSIGNED NOT NULL,
    total_price DECIMAL(10, 2),
    status      ENUM ('PENDING', 'PAID', 'SHIPPED', 'COMPLETED', 'CANCELLED') DEFAULT 'PENDING',
    created_at  TIMESTAMP       NULL,
    updated_at  TIMESTAMP       NULL,
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (address_id) REFERENCES addresses (id)
);

CREATE INDEX idx_orders_user_id ON orders (user_id);
CREATE INDEX idx_orders_address_id ON orders (address_id);