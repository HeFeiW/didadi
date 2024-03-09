create table USERS
(
    ID          INTEGER auto_increment,
    NAME        CHARACTER VARYING(100),
    ACCOUNTID   CHARACTER VARYING(50),
    TOKEN       CHARACTER(36),
    GMTCREATE   BIGINT,
    GMTMODIFIED BIGINT,
    SEX         INTEGER,
    AUTH        CHARACTER VARYING(50),
    ENCRYPTPWD  CHARACTER VARYING(36),
    constraint USERS_PK
        primary key (ID)
);

