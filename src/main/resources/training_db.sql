CREATE DATABASE training_db CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

CREATE USER 'training_user'@'localhost' IDENTIFIED BY 'training_pass';

GRANT ALL PRIVILEGES ON training_db.* TO 'training_user'@'localhost';

FLUSH PRIVILEGES;
