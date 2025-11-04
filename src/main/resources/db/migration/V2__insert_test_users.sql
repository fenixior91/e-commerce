INSERT INTO users (version, username, password, email, role, created_at, updated_at)
VALUES (0, 'admin', 'admin123', 'admin@example.com', 'ADMIN', NOW(), NOW()),
       (0, 'jan.kowalski', 'qwerty123', 'jan.kowalski@example.com', 'USER', NOW(), NOW()),
       (0, 'anna.nowak', 'haslo123', 'anna.nowak@example.com', 'USER', NOW(), NOW()),
       (0, 'michal.nowicki', 'test1234', 'michal.nowicki@example.com', 'USER', NOW(), NOW()),
       (0, 'ewa.kowalczyk', 'password', 'ewa.kowalczyk@example.com', 'USER', NOW(), NOW());
