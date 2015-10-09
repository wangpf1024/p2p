---------------------------------------------------
-- Export file for user SA@ORCL                  --
-- Created by wangpengfei on 2015/10/9, 11:44:46 --
---------------------------------------------------

set define off
spool test_tri.log

prompt
prompt Creating trigger TEST_RESOURCE_TRIGER
prompt =====================================
prompt
CREATE OR REPLACE TRIGGER SA.test_resource_triger
  BEFORE INSERT ON test_resource
 FOR EACH ROW
  BEGIN
   SELECT test_resourece_seq.nextval INTO :new.id  FROM dual;
  END;
/

prompt
prompt Creating trigger TEST_ROLE_TRIGER
prompt =================================
prompt
CREATE OR REPLACE TRIGGER SA.test_role_triger
  BEFORE INSERT ON test_role
 FOR EACH ROW
  BEGIN
   SELECT test_role_seq.nextval INTO :new.id  FROM dual;
  END;
/

prompt
prompt Creating trigger TEST_TRIGER
prompt ============================
prompt
CREATE OR REPLACE TRIGGER SA.test_triger
  BEFORE INSERT ON test  
 FOR EACH ROW  
  BEGIN  
   SELECT test_seq.nextval INTO :new.id  FROM dual;  
  END;
/

prompt
prompt Creating trigger TEST_USER_TRIGER
prompt =================================
prompt
CREATE OR REPLACE TRIGGER SA.test_user_triger
  BEFORE INSERT ON test_user
 FOR EACH ROW
  BEGIN
   SELECT test_user_seq.nextval INTO :new.id  FROM dual;
  END;
/


spool off
