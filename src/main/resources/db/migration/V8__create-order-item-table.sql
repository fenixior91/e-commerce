DROP TABLE IF EXISTS order_items;

CREATE TABLE order_items
(
    id                BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    version           INT DEFAULT 0,
    order_id          BIGINT UNSIGNED NOT NULL,
    product_id        BIGINT UNSIGNED NOT NULL,
    quantity          INT,
    price_at_purchase DECIMAL(10, 2),
    created_at        TIMESTAMP       NULL,
    updated_at        TIMESTAMP       NULL,
    FOREIGN KEY (order_id) REFERENCES orders (id),
    FOREIGN KEY (product_id) REFERENCES products (id)
);

CREATE INDEX idx_order_items_order_id ON order_items (order_id);
CREATE INDEX idx_order_items_product_id ON order_items (product_id);