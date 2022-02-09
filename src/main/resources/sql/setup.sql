-- 数据库
CREATE DATABASE ps_db;

-- 用户表
CREATE TABLE user_t(
    id       INT          AUTO_INCREMENT PRIMARY KEY,
    name     VARCHAR(64)  UNIQUE,
    email    VARCHAR(64)  UNIQUE,
    password VARCHAR(256),
    token    VARCHAR(64)  UNIQUE
);

-- 文章表
CREATE TABLE article_t(
    id          INT         AUTO_INCREMENT PRIMARY KEY,
    title       VARCHAR(64),
    author      VARCHAR(64),
    category    VARCHAR(8),
    content     TEXT,
    reading     BIGINT,
    releaseDate TIMESTAMP
);

-- 连接用户
CREATE USER 'spring'@'127.0.0.1' IDENTIFIED BY '123456';
GRANT ALL ON ps_db.* TO 'spring'@'127.0.0.1';