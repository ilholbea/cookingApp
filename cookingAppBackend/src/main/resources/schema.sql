CREATE TABLE recipe (
    id   INTEGER      NOT NULL AUTO_INCREMENT,
    name VARCHAR(128) NOT NULL,
    description VARCHAR(128),
    ingredients VARCHAR(1000) NOT NULL,
    PRIMARY KEY (id),
    UNIQUE (name)
);