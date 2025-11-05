DROP TABLE IF EXISTS categories;

CREATE TABLE categories
(
    id          BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    version     INT DEFAULT 0,
    name        VARCHAR(255),
    description TEXT,
    created_at  TIMESTAMP NULL,
    updated_at  TIMESTAMP NULL
);