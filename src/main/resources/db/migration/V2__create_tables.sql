CREATE TABLE comments (
    id INT DEFAULT NULL AUTO_INCREMENT PRIMARY KEY,
    post_id INT NOT NULL,
    message VARCHAR(1000000) NOT NULL,
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    FOREIGN KEY (post_id) REFERENCES posts(id)
);