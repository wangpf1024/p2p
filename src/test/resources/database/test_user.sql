---------------------------------------------------
-- Export file for user SA@ORCL                  --
-- Created by wangpengfei on 2015/9/29, 11:08:41 --
---------------------------------------------------

set define off
spool test.log

prompt
prompt Creating table TEST_USER
prompt ===================
prompt
create table SA.TEST_USER
(
  id        NUMBER(19) not null,
  firstname VARCHAR2(50) not null,
  lastname  VARCHAR2(50) not null,
  email     VARCHAR2(50) not null,
  password  VARCHAR2(50) not null
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
alter table SA.TEST_USER
  add constraint TEST_PK primary key (ID)
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
prompt Creating sequence TEST_SEQUENCE
prompt ===============================
prompt
create sequence SA.TEST_USER_SEQUENCE
minvalue 1
maxvalue 9999999999999999999999999999
start with 2
increment by 1
nocache;

prompt
prompt Creating trigger TEST_TRIGER
prompt ============================
prompt
CREATE OR REPLACE TRIGGER SA.test_user_triger
  BEFORE INSERT ON test_user
 FOR EACH ROW
  BEGIN
   SELECT test_user_sequence.nextval INTO :new.id  FROM dual;
  END;
/


spool off
