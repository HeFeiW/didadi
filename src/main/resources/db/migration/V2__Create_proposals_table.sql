create table PROPOSALS
(
    ID               INTEGER auto_increment,
    TITLE            CHARACTER VARYING(50),
    DESCRIPTION      CHARACTER VARYING,
    EXPECT_TIME      DATE,
    LOCATION         CHARACTER VARYING,
    GMT_CREATE       BIGINT,
    CREATOR          INTEGER,
    GMT_MODIFIED     BIGINT,
    EXPECT_NUMBER    INTEGER,
    RECRUITED_NUMBER INTEGER,
    VIEW_COUNT       INTEGER,
    TAG              CHARACTER VARYING(256),
    constraint PROPOSALS_PK
        primary key (ID)
);

