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
	name VARCHAR(20),
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
	background BLOB,
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS blog;

CREATE TABLE IF NOT EXISTS blog(
	id INT UNSIGNED NOT NULL UNIQUE AUTO_INCREMENT,
    user_id INT UNSIGNED,
    template_id INT UNSIGNED,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES user(id),
    FOREIGN KEY (template_id) REFERENCES template(id)
);

DROP TABLE IF EXISTS entry;

CREATE TABLE IF NOT EXISTS entry(
	id INT UNSIGNED NOT NULL UNIQUE AUTO_INCREMENT,
    blog_id INT UNSIGNED,
    title VARCHAR(100),
    intro VARCHAR(1000),
    body VARCHAR(5000),
    date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    FOREIGN KEY (blog_id) REFERENCES blog(id)
);

DROP TABLE IF EXISTS comment;

CREATE TABLE IF NOT EXISTS comment(
	id INT UNSIGNED NOT NULL UNIQUE AUTO_INCREMENT,
    user_id INT UNSIGNED,
    blog_id INT UNSIGNED,
    previous_id INT UNSIGNED,
    text VARCHAR(1000),
    date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES user(id),
    FOREIGN KEY (blog_id) REFERENCES blog(id),
    FOREIGN KEY (previous_id) REFERENCES comment(id)
);