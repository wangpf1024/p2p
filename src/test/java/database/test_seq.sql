---------------------------------------------------
-- Export file for user SA@ORCL                  --
-- Created by wangpengfei on 2015/10/9, 11:44:35 --
---------------------------------------------------

set define off
spool test_seq.log

prompt
prompt Creating sequence TEST_RESOURECE_SEQ
prompt ====================================
prompt
create sequence SA.TEST_RESOURECE_SEQ
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
nocache;

prompt
prompt Creating sequence TEST_ROLE_SEQ
prompt ===============================
prompt
create sequence SA.TEST_ROLE_SEQ
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
nocache;

prompt
prompt Creating sequence TEST_SEQ
prompt ==========================
prompt
create sequence SA.TEST_SEQ
minvalue 1
maxvalue 9999999999999999999999999999
start with 3
increment by 1
nocache;

prompt
prompt Creating sequence TEST_USER_SEQ
prompt ===============================
prompt
create sequence SA.TEST_USER_SEQ
minvalue 1
maxvalue 9999999999999999999999999999
start with 3
increment by 1
nocache;


spool off
