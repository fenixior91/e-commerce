DROP TABLE IF EXISTS reviews;

CREATE TABLE reviews
(
    id         BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    version    INT DEFAULT 0,
    product_id BIGINT UNSIGNED NOT NULL,
    user_id    BIGINT UNSIGNED NOT NULL,
    rating     INT CHECK (rating BETWEEN 1 AND 5),
    comment    TEXT,
    created_at TIMESTAMP       NULL,
    updated_at TIMESTAMP       NULL,
    FOREIGN KEY (product_id) REFERENCES products (id),
    FOREIGN KEY (user_id) REFERENCES users (id)
);

CREATE INDEX idx_reviews_user_id ON reviews (user_id);
CREATE INDEX idx_reviews_product_id ON reviews (product_id);