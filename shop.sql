CREATE TABLE IF NOT EXISTS category
(
    id    INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    title TINYTEXT     NOT NULL
)
    ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS user
(
    id       INT UNSIGNED           NOT NULL AUTO_INCREMENT
        PRIMARY KEY,
    name     TINYTEXT               NOT NULL,
    email    VARCHAR(45)            NOT NULL,
    password VARCHAR(45)            NOT NULL,
    role     ENUM ('user', 'admin') NOT NULL DEFAULT 'user'
)
    ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS invoice
(
    id      INT UNSIGNED    NOT NULL
        AUTO_INCREMENT PRIMARY KEY,
    user    INT UNSIGNED    NOT NULL,
    payment BIGINT UNSIGNED NOT NULL,
    paid    TINYINT         NOT NULL,
    CONSTRAINT `sos`
        FOREIGN KEY (user)
            REFERENCES user (id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS periodical
(
    id       INT UNSIGNED NOT NULL
        AUTO_INCREMENT PRIMARY KEY,
    category INT UNSIGNED NOT NULL,
    title    TINYTEXT     NOT NULL,
    price    INT UNSIGNED NOT NULL,
    CONSTRAINT
        FOREIGN KEY (category)
            REFERENCES category (id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS subscription
(
    id         INT UNSIGNED NOT NULL
        AUTO_INCREMENT PRIMARY KEY,
    user       INT UNSIGNED NOT NULL,
    periodical INT UNSIGNED NOT NULL,
    invoice    INT UNSIGNED NOT NULL,
    expires    DATE         NOT NULL,
    CONSTRAINT FOREIGN KEY (user)
        REFERENCES user (id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION,
    CONSTRAINT
        FOREIGN KEY (periodical)
            REFERENCES periodical (id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT
        FOREIGN KEY (invoice)
            REFERENCES invoice (id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB;