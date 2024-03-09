alter table USERS
    alter column ACCOUNTID rename to account_id;

alter table USERS
    alter column GMTCREATE rename to gmt_create;

alter table USERS
    alter column GMTMODIFIED rename to gmt_modified;

