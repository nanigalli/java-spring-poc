DROP TABLE IF EXISTS users;

CREATE TABLE users (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  dni INT NOT NULL,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  enabled BIT default 1
);

INSERT INTO users (dni, first_name, last_name, enabled) VALUES
  (35000000, 'Juan', 'Perez', 1),
  (35806000, 'Maria', 'Antonieta', 1),
  (35005980, 'Jacinta', 'Antonieta', 0);