----------------------------------------------------
-- Export file for user SA@ORCL                   --
-- Created by wangpengfei on 2015/10/10, 16:49:41 --
----------------------------------------------------

set define off
spool triger.log

prompt
prompt Creating trigger RESOURCE_TRIGER
prompt ================================
prompt
CREATE OR REPLACE TRIGGER SA.
resource_triger
  BEFORE INSERT ON RESOURCES
 FOR EACH ROW
  
BEGIN
   SELECT resoureces_seq.nextval INTO :new.id  FROM dual;
  END;
/

prompt
prompt Creating trigger ROLES_TRIGER
prompt =============================
prompt
CREATE OR REPLACE TRIGGER SA.
roles_triger
  BEFORE INSERT ON ROLES
 FOR EACH ROW
  
BEGIN
   SELECT roles_seq.nextval INTO :new.id  FROM dual;
  END;
/

prompt
prompt Creating trigger USERS_TRIGER
prompt =============================
prompt
CREATE OR REPLACE TRIGGER SA.
users_triger
  BEFORE INSERT ON USERS
 FOR EACH ROW
  
BEGIN
   SELECT users_seq.nextval INTO :new.id  FROM dual;
  END;
/


spool off
