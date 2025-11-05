DROP TABLE IF EXISTS users;

CREATE TABLE users
(
    id         BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    version    INT                    DEFAULT 0,
    username   VARCHAR(255) NOT NULL UNIQUE,
    password   VARCHAR(255) NOT NULL,
    email      VARCHAR(255) NOT NULL UNIQUE,
    role       ENUM ('USER', 'ADMIN') DEFAULT 'USER',
    created_at TIMESTAMP    NULL,
    updated_at TIMESTAMP    NULL
);