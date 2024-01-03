-- 创建表
CREATE TABLE users (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       name VARCHAR(50),
                       password VARCHAR(50),
                       email VARCHAR(50),
                       birthday DATE
);

-- 插入数据
INSERT INTO users (name, password, email, birthday) VALUES ('Alice', 'alice123', 'alice@example.com', '1990-01-01');
INSERT INTO users (name, password, email, birthday) VALUES ('Bob', 'bob123', 'bob@example.com', '1992-02-02');
