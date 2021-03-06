DROP DATABASE IF EXISTS blogDB;

CREATE DATABASE IF NOT EXISTS blogDB;

USE blogDB;

DROP TABLE IF EXISTS user;

CREATE TABLE IF NOT EXISTS user(
	id INT UNSIGNED NOT NULL UNIQUE AUTO_INCREMENT,
    user_name VARCHAR(50) UNIQUE,
    emil_address VARCHAR(100) UNIQUE,
    pwd_hash VARCHAR(500),
    role ENUM(
		'user',
        'moderator',
        'admin'
        ) DEFAULT 'user',
	pic BLOB,
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS template;

CREATE TABLE IF NOT EXISTS template(
    id INT UNSIGNED NOT NULL UNIQUE AUTO_INCREMENT,
    name VARCHAR(20) UNIQUE,
    color_theme ENUM(
        'light',
        'dark',
        'pale',
        'B&W',
        'pink'
        ) DEFAULT 'light',
    category ENUM(
        'lifestyle',
        'food',
        'art',
        'science&tech',
        'political',
        'travel'
        ),
        background BLOB, /* maybe refactor into a foreign key to a img table */
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS blog;

CREATE TABLE IF NOT EXISTS blog(
	id INT UNSIGNED NOT NULL UNIQUE AUTO_INCREMENT,
	title VARCHAR(20) UNIQUE,
	author_id INT UNSIGNED,
	template_id int UNSIGNED,
    PRIMARY KEY (id),
    FOREIGN KEY (author_id) REFERENCES user(id),
    FOREIGN KEY (template_id) REFERENCES template(id)
);

DROP TABLE IF EXISTS entry;

CREATE TABLE IF NOT EXISTS entry(
	id INT UNSIGNED NOT NULL UNIQUE AUTO_INCREMENT,
    blog_id INT UNSIGNED,
    subtitle VARCHAR(100),
    intro VARCHAR(1000),
    body VARCHAR(5000),
    posted_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    FOREIGN KEY (blog_id) REFERENCES blog(id)
);

DROP TABLE IF EXISTS comment;

CREATE TABLE IF NOT EXISTS comment(
	id INT UNSIGNED NOT NULL UNIQUE AUTO_INCREMENT,
    user_id INT UNSIGNED,
    entry_id INT UNSIGNED,
    previous_id INT UNSIGNED DEFAULT NULL,
    text VARCHAR(1000),
    posted_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES user(id),
    FOREIGN KEY (entry_id) REFERENCES entry(id),
    FOREIGN KEY (previous_id) REFERENCES comment(id)
);