USE example_db;

CREATE TABLE oauth_access_token (
  authentication_id VARCHAR(256) NOT NULL,
  token_id VARCHAR(256) NOT NULL,
  token byte,
  user_name VARCHAR(256) DEFAULT NULL,
  client_id VARCHAR(256) DEFAULT NULL,
  authentication byte,
  refresh_token VARCHAR(256) DEFAULT NULL,
  PRIMARY KEY (authentication_id)
);

CREATE TABLE oauth_refresh_token (
  token_id VARCHAR(256) NOT NULL,
  token byte,
  authentication byte
);

CREATE TABLE tbl_user (
  user_email VARCHAR(256) NOT NULL,
  user_pass VARCHAR(256) NOT NULL,
  user_role VARCHAR(256) NOT NULL,
  PRIMARY KEY (user_email)
);

INSERT INTO tbl_user (user_email, user_pass, user_role) VALUES ("admin1@pm.com", "admin123", "ROLE_ADMIN");
INSERT INTO tbl_user (user_email, user_pass, user_role) VALUES ("user1@pm.com", "user123", "ROLE_USER");