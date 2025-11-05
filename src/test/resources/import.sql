-- =====================
-- USERS
-- =====================
INSERT INTO users (version, username, password, email, role, created_at, updated_at) VALUES (0, 'jan_kowalski', 'password123', 'jan.kowalski@example.com', 'USER', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO users (version, username, password, email, role, created_at, updated_at) VALUES (0, 'anna_nowak', 'securepass', 'anna.nowak@example.com', 'USER', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO users (version, username, password, email, role, created_at, updated_at) VALUES (0, 'marek_zielinski', 'pass456', 'marek.zielinski@example.com', 'USER', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO users (version, username, password, email, role, created_at, updated_at) VALUES (0, 'ewa_kaczmarek', 'mypassword', 'ewa.kaczmarek@example.com', 'USER', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO users (version, username, password, email, role, created_at, updated_at) VALUES (0, 'piotr_wisniewski', 'piotr123', 'piotr.wisniewski@example.com', 'USER', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO users (version, username, password, email, role, created_at, updated_at) VALUES (0, 'agnieszka_michalska', 'agnieszka123', 'agnieszka.michalska@example.com', 'USER', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO users (version, username, password, email, role, created_at, updated_at) VALUES (0, 'admin', 'adminpass', 'admin@example.com', 'ADMIN', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO users (version, username, password, email, role, created_at, updated_at) VALUES (0, 'katarzyna_nowicka', 'katarzyna456', 'katarzyna.nowicka@example.com', 'USER', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO users (version, username, password, email, role, created_at, updated_at) VALUES (0, 'tomasz_wozniak', 'tomaszpass', 'tomasz.wozniak@example.com', 'USER', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO users (version, username, password, email, role, created_at, updated_at) VALUES (0, 'magdalena_kowalczyk', 'magda789', 'magdalena.kowalczyk@example.com', 'USER', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());


-- =====================
-- ADDRESSES
-- =====================
INSERT INTO addresses (version, user_id, street, city, zip, country, created_at, updated_at) VALUES (0, 1, 'ul. Kwiatowa 10', 'Warszawa', '00-001', 'Polska', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO addresses (version, user_id, street, city, zip, country, created_at, updated_at) VALUES (0, 2, 'ul. Polna 5', 'Kraków', '30-101', 'Polska', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO addresses (version, user_id, street, city, zip, country, created_at, updated_at) VALUES (0, 3, 'ul. Lipowa 12', 'Gdańsk', '80-200', 'Polska', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO addresses (version, user_id, street, city, zip, country, created_at, updated_at) VALUES (0, 4, 'ul. Długa 20', 'Poznań', '61-001', 'Polska', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO addresses (version, user_id, street, city, zip, country, created_at, updated_at) VALUES (0, 5, 'ul. Słoneczna 7', 'Łódź', '90-100', 'Polska', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO addresses (version, user_id, street, city, zip, country, created_at, updated_at) VALUES (0, 6, 'ul. Krótka 3', 'Wrocław', '50-001', 'Polska', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO addresses (version, user_id, street, city, zip, country, created_at, updated_at) VALUES (0, 7, 'ul. Nowa 15', 'Warszawa', '00-002', 'Polska', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO addresses (version, user_id, street, city, zip, country, created_at, updated_at) VALUES (0, 8, 'ul. Stroma 8', 'Kraków', '30-102', 'Polska', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO addresses (version, user_id, street, city, zip, country, created_at, updated_at) VALUES (0, 9, 'ul. Zielona 11', 'Gdynia', '81-001', 'Polska', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO addresses (version, user_id, street, city, zip, country, created_at, updated_at) VALUES (0, 10, 'ul. Wiosenna 9', 'Szczecin', '70-100', 'Polska', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

-- =====================
-- CATEGORIES
-- =====================
INSERT INTO categories (version, name, description, created_at, updated_at) VALUES (0, 'Elektronika', 'Telefony, komputery, akcesoria', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO categories (version, name, description, created_at, updated_at) VALUES (0, 'Odzież', 'Koszulki, spodnie, kurtki', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO categories (version, name, description, created_at, updated_at) VALUES (0, 'Dom', 'Meble, dekoracje, wyposażenie', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO categories (version, name, description, created_at, updated_at) VALUES (0, 'Sport', 'Sprzęt sportowy, odzież sportowa', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO categories (version, name, description, created_at, updated_at) VALUES (0, 'Książki', 'Literatura, poradniki, komiksy', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

-- =====================
-- PRODUCTS (20)
-- =====================
INSERT INTO products (version, name, description, price, stock_quantity, category_id, image_url, created_at, updated_at) VALUES (0, 'Smartfon XYZ', 'Nowoczesny smartfon', 1999.99, 10, 1, 'https://example.com/xyz.jpg', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO products (version, name, description, price, stock_quantity, category_id, image_url, created_at, updated_at) VALUES (0, 'Laptop ABC', 'Laptop do pracy i nauki', 3499.99, 5, 1, 'https://example.com/abc.jpg', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO products (version, name, description, price, stock_quantity, category_id, image_url, created_at, updated_at) VALUES (0, 'Tablet QWE', 'Tablet multimedialny', 1599.99, 8, 1, 'https://example.com/tablet.jpg', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO products (version, name, description, price, stock_quantity, category_id, image_url, created_at, updated_at) VALUES (0, 'T-shirt Cool', 'Bawełniana koszulka', 49.99, 50, 2, 'https://example.com/tshirt.jpg', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO products (version, name, description, price, stock_quantity, category_id, image_url, created_at, updated_at) VALUES (0, 'Bluza Sport', 'Bluza sportowa z kapturem', 129.99, 30, 2, 'https://example.com/bluza.jpg', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO products (version, name, description, price, stock_quantity, category_id, image_url, created_at, updated_at) VALUES (0, 'Kurtka Zimowa', 'Ciepła kurtka na zimę', 499.99, 12, 2, 'https://example.com/kurtka.jpg', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO products (version, name, description, price, stock_quantity, category_id, image_url, created_at, updated_at) VALUES (0, 'Krzesło Drewniane', 'Wygodne krzesło do domu', 299.99, 15, 3, 'https://example.com/krzeslo.jpg', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO products (version, name, description, price, stock_quantity, category_id, image_url, created_at, updated_at) VALUES (0, 'Stół Szklany', 'Elegancki stół do salonu', 899.99, 8, 3, 'https://example.com/stol.jpg', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO products (version, name, description, price, stock_quantity, category_id, image_url, created_at, updated_at) VALUES (0, 'Lampa Stołowa', 'Nowoczesna lampa', 199.99, 20, 3, 'https://example.com/lampa.jpg', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO products (version, name, description, price, stock_quantity, category_id, image_url, created_at, updated_at) VALUES (0, 'Piłka Nożna', 'Profesjonalna piłka nożna', 79.99, 20, 4, 'https://example.com/pilka.jpg', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO products (version, name, description, price, stock_quantity, category_id, image_url, created_at, updated_at) VALUES (0, 'Rękawice Bokserskie', 'Skórzane rękawice', 149.99, 15, 4, 'https://example.com/rękawice.jpg', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO products (version, name, description, price, stock_quantity, category_id, image_url, created_at, updated_at) VALUES (0, 'Mata Joga', 'Antypoślizgowa mata', 99.99, 25, 4, 'https://example.com/mata.jpg', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO products (version, name, description, price, stock_quantity, category_id, image_url, created_at, updated_at) VALUES (0, 'Książka Java', 'Podręcznik programowania w Javie', 99.99, 40, 5, 'https://example.com/java.jpg', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO products (version, name, description, price, stock_quantity, category_id, image_url, created_at, updated_at) VALUES (0, 'Książka Python', 'Poradnik Pythona', 89.99, 35, 5, 'https://example.com/python.jpg', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO products (version, name, description, price, stock_quantity, category_id, image_url, created_at, updated_at) VALUES (0, 'Książka C++', 'Podstawy C++', 79.99, 30, 5, 'https://example.com/cpp.jpg', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO products (version, name, description, price, stock_quantity, category_id, image_url, created_at, updated_at) VALUES (0, 'Słownik Angielski', 'Słownik językowy', 49.99, 60, 5, 'https://example.com/slownik.jpg', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO products (version, name, description, price, stock_quantity, category_id, image_url, created_at, updated_at) VALUES (0, 'Smartwatch', 'Monitor aktywności', 599.99, 15, 1, 'https://example.com/smartwatch.jpg', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO products (version, name, description, price, stock_quantity, category_id, image_url, created_at, updated_at) VALUES (0, 'Słuchawki', 'Bezprzewodowe słuchawki', 299.99, 25, 1, 'https://example.com/sluchawki.jpg', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO products (version, name, description, price, stock_quantity, category_id, image_url, created_at, updated_at) VALUES (0, 'Spodnie Jeans', 'Męskie spodnie', 149.99, 40, 2, 'https://example.com/jeans.jpg', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO products (version, name, description, price, stock_quantity, category_id, image_url, created_at, updated_at) VALUES (0, 'Kurtka Przejściowa', 'Lekka kurtka na wiosnę', 249.99, 20, 2, 'https://example.com/kurtka_wiosna.jpg', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

-- =====================
-- CARTS (10)
-- =====================
INSERT INTO carts (version, user_id, created_at, updated_at) VALUES (0, 1, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO carts (version, user_id, created_at, updated_at) VALUES (0, 2, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO carts (version, user_id, created_at, updated_at) VALUES (0, 3, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO carts (version, user_id, created_at, updated_at) VALUES (0, 4, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO carts (version, user_id, created_at, updated_at) VALUES (0, 5, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO carts (version, user_id, created_at, updated_at) VALUES (0, 6, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO carts (version, user_id, created_at, updated_at) VALUES (0, 7, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO carts (version, user_id, created_at, updated_at) VALUES (0, 8, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO carts (version, user_id, created_at, updated_at) VALUES (0, 9, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO carts (version, user_id, created_at, updated_at) VALUES (0, 10, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());


-- =====================
-- CART_ITEMS (40)
-- =====================
INSERT INTO cart_items (version, cart_id, product_id, quantity, created_at, updated_at) VALUES (0, 1, 1, 1, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO cart_items (version, cart_id, product_id, quantity, created_at, updated_at) VALUES (0, 1, 4, 2, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO cart_items (version, cart_id, product_id, quantity, created_at, updated_at) VALUES (0, 2, 2, 1, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO cart_items (version, cart_id, product_id, quantity, created_at, updated_at) VALUES (0, 2, 5, 1, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO cart_items (version, cart_id, product_id, quantity, created_at, updated_at) VALUES (0, 3, 3, 1, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO cart_items (version, cart_id, product_id, quantity, created_at, updated_at) VALUES (0, 3, 6, 2, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO cart_items (version, cart_id, product_id, quantity, created_at, updated_at) VALUES (0, 4, 7, 1, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO cart_items (version, cart_id, product_id, quantity, created_at, updated_at) VALUES (0, 4, 10, 2, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO cart_items (version, cart_id, product_id, quantity, created_at, updated_at) VALUES (0, 5, 8, 1, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO cart_items (version, cart_id, product_id, quantity, created_at, updated_at) VALUES (0, 5, 11, 1, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO cart_items (version, cart_id, product_id, quantity, created_at, updated_at) VALUES (0, 6, 9, 1, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO cart_items (version, cart_id, product_id, quantity, created_at, updated_at) VALUES (0, 6, 12, 1, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO cart_items (version, cart_id, product_id, quantity, created_at, updated_at) VALUES (0, 7, 13, 1, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO cart_items (version, cart_id, product_id, quantity, created_at, updated_at) VALUES (0, 7, 14, 2, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO cart_items (version, cart_id, product_id, quantity, created_at, updated_at) VALUES (0, 8, 15, 1, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO cart_items (version, cart_id, product_id, quantity, created_at, updated_at) VALUES (0, 8, 16, 1, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO cart_items (version, cart_id, product_id, quantity, created_at, updated_at) VALUES (0, 9, 17, 1, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO cart_items (version, cart_id, product_id, quantity, created_at, updated_at) VALUES (0, 9, 18, 2, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO cart_items (version, cart_id, product_id, quantity, created_at, updated_at) VALUES (0, 10, 19, 1, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO cart_items (version, cart_id, product_id, quantity, created_at, updated_at) VALUES (0, 10, 20, 1, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO cart_items (version, cart_id, product_id, quantity, created_at, updated_at) VALUES (0, 1, 2, 1, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO cart_items (version, cart_id, product_id, quantity, created_at, updated_at) VALUES (0, 2, 3, 2, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO cart_items (version, cart_id, product_id, quantity, created_at, updated_at) VALUES (0, 3, 4, 1, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO cart_items (version, cart_id, product_id, quantity, created_at, updated_at) VALUES (0, 4, 5, 1, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO cart_items (version, cart_id, product_id, quantity, created_at, updated_at) VALUES (0, 5, 6, 2, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO cart_items (version, cart_id, product_id, quantity, created_at, updated_at) VALUES (0, 6, 7, 1, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO cart_items (version, cart_id, product_id, quantity, created_at, updated_at) VALUES (0, 7, 8, 1, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO cart_items (version, cart_id, product_id, quantity, created_at, updated_at) VALUES (0, 8, 9, 2, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO cart_items (version, cart_id, product_id, quantity, created_at, updated_at) VALUES (0, 9, 10, 1, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO cart_items (version, cart_id, product_id, quantity, created_at, updated_at) VALUES (0, 10, 11, 1, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO cart_items (version, cart_id, product_id, quantity, created_at, updated_at) VALUES (0, 1, 12, 1, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO cart_items (version, cart_id, product_id, quantity, created_at, updated_at) VALUES (0, 2, 13, 2, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO cart_items (version, cart_id, product_id, quantity, created_at, updated_at) VALUES (0, 3, 14, 1, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO cart_items (version, cart_id, product_id, quantity, created_at, updated_at) VALUES (0, 4, 15, 1, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO cart_items (version, cart_id, product_id, quantity, created_at, updated_at) VALUES (0, 5, 16, 2, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO cart_items (version, cart_id, product_id, quantity, created_at, updated_at) VALUES (0, 6, 17, 1, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO cart_items (version, cart_id, product_id, quantity, created_at, updated_at) VALUES (0, 7, 18, 1, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO cart_items (version, cart_id, product_id, quantity, created_at, updated_at) VALUES (0, 8, 19, 2, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO cart_items (version, cart_id, product_id, quantity, created_at, updated_at) VALUES (0, 9, 20, 1, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO cart_items (version, cart_id, product_id, quantity, created_at, updated_at) VALUES (0, 10, 1, 1, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());


-- =====================
-- ORDERS (10)
-- =====================
INSERT INTO orders (version, user_id, address_id, total_price, status, created_at, updated_at) VALUES (0, 1, 1, 2279.97, 'PENDING', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO orders (version, user_id, address_id, total_price, status, created_at, updated_at) VALUES (0, 2, 2, 1799.98, 'PAID', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO orders (version, user_id, address_id, total_price, status, created_at, updated_at) VALUES (0, 3, 3, 499.97, 'SHIPPED', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO orders (version, user_id, address_id, total_price, status, created_at, updated_at) VALUES (0, 4, 4, 229.98, 'COMPLETED', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO orders (version, user_id, address_id, total_price, status, created_at, updated_at) VALUES (0, 5, 5, 1199.96, 'CANCELLED', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO orders (version, user_id, address_id, total_price, status, created_at, updated_at) VALUES (0, 6, 6, 249.99, 'PENDING', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO orders (version, user_id, address_id, total_price, status, created_at, updated_at) VALUES (0, 7, 7, 399.98, 'PAID', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO orders (version, user_id, address_id, total_price, status, created_at, updated_at) VALUES (0, 8, 8, 599.97, 'SHIPPED', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO orders (version, user_id, address_id, total_price, status, created_at, updated_at) VALUES (0, 9, 9, 149.99, 'COMPLETED', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO orders (version, user_id, address_id, total_price, status, created_at, updated_at) VALUES (0, 10, 10, 249.99, 'PENDING', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

-- =====================
-- ORDER_ITEMS (30)
-- =====================
INSERT INTO order_items (version, order_id, product_id, quantity, price_at_purchase, created_at, updated_at) VALUES (0, 1, 1, 1, 1999.99, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO order_items (version, order_id, product_id, quantity, price_at_purchase, created_at, updated_at) VALUES (0, 1, 4, 2, 49.99, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO order_items (version, order_id, product_id, quantity, price_at_purchase, created_at, updated_at) VALUES (0, 1, 5, 1, 129.99, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO order_items (version, order_id, product_id, quantity, price_at_purchase, created_at, updated_at) VALUES (0, 2, 2, 1, 3499.99, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO order_items (version, order_id, product_id, quantity, price_at_purchase, created_at, updated_at) VALUES (0, 2, 3, 1, 1599.99, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO order_items (version, order_id, product_id, quantity, price_at_purchase, created_at, updated_at) VALUES (0, 3, 6, 2, 499.99, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO order_items (version, order_id, product_id, quantity, price_at_purchase, created_at, updated_at) VALUES (0, 3, 7, 1, 299.99, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO order_items (version, order_id, product_id, quantity, price_at_purchase, created_at, updated_at) VALUES (0, 4, 8, 1, 899.99, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO order_items (version, order_id, product_id, quantity, price_at_purchase, created_at, updated_at) VALUES (0, 4, 9, 1, 199.99, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO order_items (version, order_id, product_id, quantity, price_at_purchase, created_at, updated_at) VALUES (0, 5, 10, 2, 79.99, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO order_items (version, order_id, product_id, quantity, price_at_purchase, created_at, updated_at) VALUES (0, 5, 11, 1, 149.99, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO order_items (version, order_id, product_id, quantity, price_at_purchase, created_at, updated_at) VALUES (0, 6, 12, 1, 99.99, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO order_items (version, order_id, product_id, quantity, price_at_purchase, created_at, updated_at) VALUES (0, 6, 13, 1, 99.99, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO order_items (version, order_id, product_id, quantity, price_at_purchase, created_at, updated_at) VALUES (0, 7, 14, 2, 89.99, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO order_items (version, order_id, product_id, quantity, price_at_purchase, created_at, updated_at) VALUES (0, 7, 15, 1, 79.99, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO order_items (version, order_id, product_id, quantity, price_at_purchase, created_at, updated_at) VALUES (0, 8, 16, 1, 49.99, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO order_items (version, order_id, product_id, quantity, price_at_purchase, created_at, updated_at) VALUES (0, 8, 17, 1, 599.99, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO order_items (version, order_id, product_id, quantity, price_at_purchase, created_at, updated_at) VALUES (0, 9, 18, 1, 299.99, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO order_items (version, order_id, product_id, quantity, price_at_purchase, created_at, updated_at) VALUES (0, 9, 19, 1, 149.99, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO order_items (version, order_id, product_id, quantity, price_at_purchase, created_at, updated_at) VALUES (0, 10, 20, 1, 249.99, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO order_items (version, order_id, product_id, quantity, price_at_purchase, created_at, updated_at) VALUES (0, 10, 1, 1, 1999.99, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO order_items (version, order_id, product_id, quantity, price_at_purchase, created_at, updated_at) VALUES (0, 1, 2, 1, 3499.99, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO order_items (version, order_id, product_id, quantity, price_at_purchase, created_at, updated_at) VALUES (0, 2, 3, 1, 1599.99, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO order_items (version, order_id, product_id, quantity, price_at_purchase, created_at, updated_at) VALUES (0, 3, 4, 2, 129.99, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO order_items (version, order_id, product_id, quantity, price_at_purchase, created_at, updated_at) VALUES (0, 4, 5, 1, 129.99, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO order_items (version, order_id, product_id, quantity, price_at_purchase, created_at, updated_at) VALUES (0, 5, 6, 1, 499.99, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO order_items (version, order_id, product_id, quantity, price_at_purchase, created_at, updated_at) VALUES (0, 6, 7, 1, 299.99, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO order_items (version, order_id, product_id, quantity, price_at_purchase, created_at, updated_at) VALUES (0, 7, 8, 2, 899.99, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO order_items (version, order_id, product_id, quantity, price_at_purchase, created_at, updated_at) VALUES (0, 8, 9, 1, 199.99, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO order_items (version, order_id, product_id, quantity, price_at_purchase, created_at, updated_at) VALUES (0, 9, 10, 1, 79.99, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO order_items (version, order_id, product_id, quantity, price_at_purchase, created_at, updated_at) VALUES (0, 10, 11, 1, 149.99, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

-- =====================
-- REVIEWS (20)
-- =====================
INSERT INTO reviews (version, product_id, user_id, rating, comment, created_at, updated_at) VALUES (0, 1, 1, 5, 'Super telefon!', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO reviews (version, product_id, user_id, rating, comment, created_at, updated_at) VALUES (0, 2, 2, 4, 'Dobry laptop', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO reviews (version, product_id, user_id, rating, comment, created_at, updated_at) VALUES (0, 3, 3, 3, 'Tablet ok', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO reviews (version, product_id, user_id, rating, comment, created_at, updated_at) VALUES (0, 4, 4, 5, 'Świetna koszulka', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO reviews (version, product_id, user_id, rating, comment, created_at, updated_at) VALUES (0, 5, 5, 2, 'Nie najlepsza bluza', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO reviews (version, product_id, user_id, rating, comment, created_at, updated_at) VALUES (0, 6, 6, 4, 'Wygodne krzesło', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO reviews (version, product_id, user_id, rating, comment, created_at, updated_at) VALUES (0, 7, 7, 5, 'Stół rewelacyjny', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO reviews (version, product_id, user_id, rating, comment, created_at, updated_at) VALUES (0, 8, 8, 3, 'Lampa OK', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO reviews (version, product_id, user_id, rating, comment, created_at, updated_at) VALUES (0, 9, 9, 4, 'Fajna piłka', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO reviews (version, product_id, user_id, rating, comment, created_at, updated_at) VALUES (0, 10, 10, 5, 'Rękawice idealne', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO reviews (version, product_id, user_id, rating, comment, created_at, updated_at) VALUES (0, 1, 1, 3, 'Mata w porządku', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO reviews (version, product_id, user_id, rating, comment, created_at, updated_at) VALUES (0, 2, 2, 4, 'Książka Python super', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO reviews (version, product_id, user_id, rating, comment, created_at, updated_at) VALUES (0, 3, 3, 2, 'C++ trochę trudne', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO reviews (version, product_id, user_id, rating, comment, created_at, updated_at) VALUES (0, 4, 4, 5, 'Słownik pomocny', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO reviews (version, product_id, user_id, rating, comment, created_at, updated_at) VALUES (0, 5, 5, 4, 'Smartwatch OK', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO reviews (version, product_id, user_id, rating, comment, created_at, updated_at) VALUES (0, 6, 6, 5, 'Słuchawki świetne', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO reviews (version, product_id, user_id, rating, comment, created_at, updated_at) VALUES (0, 7, 7, 3, 'Spodnie wygodne', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO reviews (version, product_id, user_id, rating, comment, created_at, updated_at) VALUES (0, 8, 8, 4, 'Kurtka super', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO reviews (version, product_id, user_id, rating, comment, created_at, updated_at) VALUES (0, 9, 9, 5, 'Lekka kurtka OK', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO reviews (version, product_id, user_id, rating, comment, created_at, updated_at) VALUES (0, 10, 10, 4, 'Podsumowując, dobry zakup', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());