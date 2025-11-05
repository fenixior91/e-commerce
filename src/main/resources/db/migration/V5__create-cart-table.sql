DROP TABLE IF EXISTS carts;

CREATE TABLE carts
(
    id         BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    version    INT DEFAULT 0,
    user_id    BIGINT UNSIGNED UNIQUE,
    created_at TIMESTAMP NULL,
    updated_at TIMESTAMP NULL,
    FOREIGN KEY (user_id) REFERENCES users (id)
);

CREATE INDEX idx_carts_user_id ON carts (user_id);