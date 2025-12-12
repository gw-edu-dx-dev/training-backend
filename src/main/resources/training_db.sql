CREATE DATABASE training_db CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
-- アプリ用の接続専用アカウント作成
CREATE USER 'training_user'@'localhost' IDENTIFIED BY 'training_pass';
-- 作成したアカウントへの権限付与
GRANT ALL PRIVILEGES ON training_db.* TO 'training_user'@'localhost';
-- 設定をMySQLに反映
FLUSH PRIVILEGES;

