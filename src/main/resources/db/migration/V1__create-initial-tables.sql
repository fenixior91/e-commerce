DROP TABLE IF EXISTS order_items;
DROP TABLE IF EXISTS reviews;
DROP TABLE IF EXISTS cart_items;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS carts;
DROP TABLE IF EXISTS products;
DROP TABLE IF EXISTS categories;
DROP TABLE IF EXISTS addresses;
DROP TABLE IF EXISTS users;

CREATE TABLE users
(
    id         BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    version    INT                   DEFAULT 0,
    username   VARCHAR(255) NOT NULL UNIQUE,
    password   VARCHAR(255) NOT NULL,
    email      VARCHAR(255) NOT NULL UNIQUE,
    role       ENUM ('USER','ADMIN') DEFAULT 'USER',
    created_at TIMESTAMP    NULL,
    updated_at TIMESTAMP    NULL
);

CREATE TABLE addresses
(
    id         BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    version    INT DEFAULT 0,
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

CREATE TABLE categories
(
    id          BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    version     INT DEFAULT 0,
    name        VARCHAR(255),
    description TEXT,
    created_at  TIMESTAMP NULL,
    updated_at  TIMESTAMP NULL
);

CREATE TABLE products
(
    id             BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    version        INT DEFAULT 0,
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

CREATE TABLE cart_items
(
    id         BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    version    INT DEFAULT 0,
    cart_id    BIGINT UNSIGNED NOT NULL,
    product_id BIGINT UNSIGNED NOT NULL,
    quantity   INT,
    created_at TIMESTAMP       NULL,
    updated_at TIMESTAMP       NULL,
    FOREIGN KEY (cart_id) REFERENCES carts (id),
    FOREIGN KEY (product_id) REFERENCES products (id)
);
CREATE INDEX idx_cart_items_cart_id ON cart_items (cart_id);
CREATE INDEX idx_cart_items_product_id ON cart_items (product_id);

CREATE TABLE orders
(
    id          BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    version     INT                                                       DEFAULT 0,
    user_id     BIGINT UNSIGNED NOT NULL,
    address_id  BIGINT UNSIGNED NOT NULL,
    total_price DECIMAL(10, 2),
    status      ENUM ('PENDING','PAID','SHIPPED','COMPLETED','CANCELLED') DEFAULT 'PENDING',
    created_at  TIMESTAMP       NULL,
    updated_at  TIMESTAMP       NULL,
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (address_id) REFERENCES addresses (id)
);
CREATE INDEX idx_orders_user_id ON orders (user_id);
CREATE INDEX idx_orders_address_id ON orders (address_id);

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
