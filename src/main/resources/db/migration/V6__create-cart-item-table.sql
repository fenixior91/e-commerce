    DROP TABLE IF EXISTS cart_items;

    CREATE TABLE cart_items
    (
        id         BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
        version    INT UNSIGNED DEFAULT 0,
        cart_id    BIGINT UNSIGNED NOT NULL,
        product_id BIGINT UNSIGNED NOT NULL,
        quantity   INT,
        created_at TIMESTAMP NULL,
        updated_at TIMESTAMP NULL,
        FOREIGN KEY (cart_id) REFERENCES carts (id),
        FOREIGN KEY (product_id) REFERENCES products (id)
    );

    CREATE INDEX idx_cart_items_cart_id ON cart_items (cart_id);
    CREATE INDEX idx_cart_items_product_id ON cart_items (product_id);