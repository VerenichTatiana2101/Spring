CREATE TABLE tasks (
                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                      description VARCHAR(255) NOT NULL,
                      status VARCHAR(20) NOT NULL,
                      create_date DATETIME DEFAULT CURRENT_TIMESTAMP
);