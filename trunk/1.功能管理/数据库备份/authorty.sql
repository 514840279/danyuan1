CREATE TABLE username
(
   id                   VARCHAR(36) NOT NULL,
   user_name            VARCHAR(50) NOT NULL,
   user_password        VARCHAR(50),
   last_time            DATETIME,
   last_ip              VARCHAR(20),
   group_id             VARCHAR(50),
   other                VARCHAR(200),
   PRIMARY KEY (id)
);
CREATE TABLE groupautho
(
   id                   VARCHAR(36) NOT NULL,
   group_name           VARCHAR(50) NOT NULL,
   group_describe       VARCHAR(100),
   PRIMARY KEY (id)
);

CREATE TABLE authority
(
   id                   VARCHAR(32) NOT NULL,
   author_name          VARCHAR(20) NOT NULL,
   authority            VARCHAR(20) NOT NULL,
   group_id             VARCHAR(36),
   user_id              VARCHAR(36),
   system_id            VARCHAR(36),
   PRIMARY KEY (id)
);

CREATE TABLE systemmenu
(
   id                   VARCHAR(36) NOT NULL,
   NAME                 VARCHAR(50) NOT NULL,
   icon                 VARCHAR(50),
   parent_id            VARCHAR(36),
   link                 VARCHAR(100),
   PRIMARY KEY (id)
);
