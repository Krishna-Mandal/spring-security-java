DROP TABLE IF EXISTS USERS ;
CREATE TABLE USERS (
  id INTEGER PRIMARY KEY,
  user VARCHAR(250) NOT NULL,
  password VARCHAR(250) NOT NULL,
  roles VARCHAR(250) NOT NULL ,
  active BOOLEAN );

INSERT INTO USERS (id, user, password, roles, active) VALUES
  ('1', 'user1', 'pass1', 'ROLE_USER', true),
  ('2', 'user2', 'pass2', 'ROLE_ADMIN', true),
  ('3', 'user2', 'pass3', 'ROLE_USER,ROLE_ADMIN', true)