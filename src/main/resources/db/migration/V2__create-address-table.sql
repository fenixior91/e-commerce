DROP TABLE IF EXISTS addresses;

CREATE TABLE addresses
(
    id         BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    version    INT UNSIGNED DEFAULT 0,
    user_id    BIGINT UNSIGNED,
    street     VARCHAR(255),
    city       VARCHAR(255),
    zip        VARCHAR(20),
    country    VARCHAR(100),
    created_at TIMESTAMP NULL,
    updated_at TIMESTAMP NULL,
    FOREIGN KEY (user_id) REFERENCES users (id)
);

CREATE INDEX idx_addresses_user_id ON addresses (user_id);