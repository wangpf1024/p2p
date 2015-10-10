----------------------------------------------------
-- Export file for user SA@ORCL                   --
-- Created by wangpengfei on 2015/10/10, 16:52:14 --
----------------------------------------------------

set define off
spool tables.log

prompt
prompt Creating table RESOURCES
prompt ========================
prompt
create table SA.RESOURCES
(
  id       NUMBER(19) not null,
  name     VARCHAR2(50) not null,
  descript VARCHAR2(50) not null,
  url      VARCHAR2(50) not null,
  type     NUMBER(2) not null
)
tablespace SA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on column SA.RESOURCES.id
  is '主键';
comment on column SA.RESOURCES.name
  is '资源名称';
comment on column SA.RESOURCES.descript
  is '资源描述';
comment on column SA.RESOURCES.url
  is '资源地址';
comment on column SA.RESOURCES.type
  is '资源类型';
alter table SA.RESOURCES
  add constraint TEST_RESOURCES_PK primary key (ID)
  using index 
  tablespace JXMMS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table ROLES
prompt ====================
prompt
create table SA.ROLES
(
  id       NUMBER(19) not null,
  name     VARCHAR2(50) not null,
  descript VARCHAR2(50) not null,
  type     NUMBER(2)
)
tablespace SA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on column SA.ROLES.id
  is '主键';
comment on column SA.ROLES.name
  is '名称';
comment on column SA.ROLES.descript
  is '描述';
comment on column SA.ROLES.type
  is '类型';
alter table SA.ROLES
  add constraint TEST_ROLE_PK primary key (ID)
  using index 
  tablespace JXMMS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table ROLES_RESOURCES
prompt ==============================
prompt
create table SA.ROLES_RESOURCES
(
  role_id     NUMBER(19) not null,
  resource_id NUMBER(19) not null
)
tablespace SA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on column SA.ROLES_RESOURCES.role_id
  is '角色主键';
comment on column SA.ROLES_RESOURCES.resource_id
  is '资源主键';

prompt
prompt Creating table USERS
prompt ====================
prompt
create table SA.USERS
(
  id                      NUMBER(19) not null,
  firstname               VARCHAR2(50) not null,
  lastname                VARCHAR2(50) not null,
  email                   VARCHAR2(50) not null,
  password                VARCHAR2(50) not null,
  username                VARCHAR2(50) not null,
  isaccountnonexpired     NUMBER(2) default 0 not null,
  isaccountnonlocked      NUMBER(2) default 0 not null,
  iscredentialsnonexpired NUMBER(2) default 0 not null,
  isenabled               NUMBER(2) default 0 not null
)
tablespace SA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on column SA.USERS.id
  is '主键';
comment on column SA.USERS.firstname
  is '名';
comment on column SA.USERS.lastname
  is '姓';
comment on column SA.USERS.email
  is '邮箱';
comment on column SA.USERS.password
  is '密码';
comment on column SA.USERS.username
  is '用户名/登录名';
comment on column SA.USERS.isaccountnonexpired
  is '是否过期 0 未过期 ，1 已过期';
comment on column SA.USERS.isaccountnonlocked
  is '是否锁定 0 未锁定 ，1 已锁定';
comment on column SA.USERS.iscredentialsnonexpired
  is '证件是否过期 0 未过期  ，1 已过期';
comment on column SA.USERS.isenabled
  is '是否禁用 0 未禁用 ，1 已禁用';
alter table SA.USERS
  add constraint TEST_USER_PK primary key (ID)
  using index 
  tablespace JXMMS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table USERS_ROLES
prompt ==========================
prompt
create table SA.USERS_ROLES
(
  user_id NUMBER(19) not null,
  role_id NUMBER(19) not null
)
tablespace SA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on column SA.USERS_ROLES.user_id
  is '用户主键';
comment on column SA.USERS_ROLES.role_id
  is '角色主键';


spool off
