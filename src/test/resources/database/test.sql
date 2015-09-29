---------------------------------------------------
-- Export file for user SA@ORCL                  --
-- Created by wangpengfei on 2015/9/29, 11:08:41 --
---------------------------------------------------

set define off
spool test.log

prompt
prompt Creating table TEST
prompt ===================
prompt
create table SA.TEST
(
  id   NUMBER(19) not null,
  name VARCHAR2(50) not null
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
alter table SA.TEST
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
create sequence SA.TEST_SEQUENCE
minvalue 1
maxvalue 9999999999999999999999999999
start with 2
increment by 1
nocache;

prompt
prompt Creating trigger TEST_TRIGER
prompt ============================
prompt
CREATE OR REPLACE TRIGGER SA.test_triger
  BEFORE INSERT ON test  
 FOR EACH ROW  
  BEGIN  
   SELECT test_sequence.nextval INTO :new.id  FROM dual;  
  END;
/


spool off
