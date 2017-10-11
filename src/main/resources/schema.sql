CREATE TABLE clients (
    client_id BIGINT PRIMARY KEY auto_increment,
    firstname VARCHAR(10),
    lastname VARCHAR(10),
    login VARCHAR(10),
    password VARCHAR(10),
    tel VARCHAR(10)
);

CREATE TABLE pets (
    pet_id BIGINT PRIMARY KEY auto_increment,
    nick VARCHAR(10),
    kind VARCHAR(10),
    weight VARCHAR(10)
);

CREATE TABLE catalog (
  client_id BIGINT NOT NULL REFERENCES clients (client_id),
  pet_id BIGINT NOT NULL REFERENCES pets (pet_id),
  PRIMARY KEY (client_id, pet_id)
);
