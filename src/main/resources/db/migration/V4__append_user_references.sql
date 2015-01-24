 ALTER TABLE posts
ADD user_id INT NOT NULL;

ALTER TABLE comments
ADD user_id INT NOT NULL;

ALTER TABLE posts
ADD FOREIGN KEY (user_id) REFERENCES users(id);

ALTER TABLE comments
ADD FOREIGN KEY (user_id) REFERENCES users(id);