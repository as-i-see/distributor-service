/*
H2 test database schema creation
*/

/* Create table for entity Category */
                CREATE TABLE category (
            id IDENTITY AUTO_INCREMENT NOT NULL,
            title VARCHAR NOT NULL,
            PRIMARY KEY(id)
            );
    
/* Create table for entity Databasechangelog */
                CREATE TABLE DATABASECHANGELOG (
            ID VARCHAR NOT NULL,
            AUTHOR VARCHAR NOT NULL,
            FILENAME VARCHAR NOT NULL,
            DATEEXECUTED TIMESTAMP NOT NULL,
            ORDEREXECUTED INTEGER NOT NULL,
            EXECTYPE VARCHAR NOT NULL,
            MD5SUM VARCHAR ,
            DESCRIPTION VARCHAR ,
            COMMENTS VARCHAR ,
            TAG VARCHAR ,
            LIQUIBASE VARCHAR ,
            CONTEXTS VARCHAR ,
            LABELS VARCHAR ,
            DEPLOYMENT_ID VARCHAR 
            );
    
/* Create table for entity Databasechangeloglock */
                CREATE TABLE DATABASECHANGELOGLOCK (
            ID INTEGER NOT NULL,
            LOCKED BOOLEAN NOT NULL,
            LOCKGRANTED TIMESTAMP ,
            LOCKEDBY VARCHAR ,
            PRIMARY KEY(ID)
            );
    
/* Create table for entity Invoice */
                CREATE TABLE invoice (
            id IDENTITY AUTO_INCREMENT NOT NULL,
            user INTEGER NOT NULL,
            payment BIGINT NOT NULL,
            paid TINYINT NOT NULL,
            PRIMARY KEY(id)
            );
    
/* Create table for entity Periodical */
                CREATE TABLE periodical (
            id IDENTITY AUTO_INCREMENT NOT NULL,
            category INTEGER NOT NULL,
            title VARCHAR NOT NULL,
            price INTEGER NOT NULL,
            PRIMARY KEY(id)
            );
    
/* Create table for entity Subscription */
                CREATE TABLE subscription (
            id IDENTITY AUTO_INCREMENT NOT NULL,
            user INTEGER NOT NULL,
            periodical INTEGER NOT NULL,
            invoice INTEGER NOT NULL,
            expires DATE NOT NULL,
            PRIMARY KEY(id)
            );
    
/* Create table for entity User */
                CREATE TABLE user (
            id IDENTITY AUTO_INCREMENT NOT NULL,
            name VARCHAR NOT NULL,
            email VARCHAR NOT NULL,
            password VARCHAR NOT NULL,
            role VARCHAR NOT NULL,
            PRIMARY KEY(id)
            );
    
