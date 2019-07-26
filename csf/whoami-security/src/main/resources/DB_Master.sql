create table S02ST_ROLE
(
    role_id             varchar(36)       not null primary key,
    createdatetime timestamp,
    delflg         integer,
    role_code           varchar(20)  not null,
    role_name           varchar(100) not null
);

create table S03ST_AUTHORITY
(
    auth_id             varchar(36)
       not null primary key,
    createdatetime timestamp,
    delflg         integer,
    auth_code           varchar(20)  not null,
    auth_name           varchar(100) not null
);

create table S04ST_USER_ROLES
(
    user_id varchar(36) not null
            references H01DT_USERS,
    role_id varchar(36)
       not null
            references S02ST_ROLE,
        primary key (role_id, user_id)
);

create table S05ST_ROLE_AUTHORITIES
(
    role_id      varchar(36)
 not null
            references S02ST_ROLE,
    authority_id varchar(36)
 not null
            references S03ST_AUTHORITY,
        primary key (authority_id, role_id)
);
