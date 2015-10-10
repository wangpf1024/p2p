----------------------------------------------------
-- Export file for user SA@ORCL                   --
-- Created by wangpengfei on 2015/10/10, 16:49:24 --
----------------------------------------------------

set define off
spool seq.log

prompt
prompt Creating sequence RESOURECES_SEQ
prompt ================================
prompt
create sequence SA.RESOURECES_SEQ
minvalue 1
maxvalue 9999999999999999999999999999
start with 4
increment by 1
nocache;

prompt
prompt Creating sequence ROLES_SEQ
prompt ===========================
prompt
create sequence SA.ROLES_SEQ
minvalue 1
maxvalue 9999999999999999999999999999
start with 4
increment by 1
nocache;

prompt
prompt Creating sequence USERS_SEQ
prompt ===========================
prompt
create sequence SA.USERS_SEQ
minvalue 1
maxvalue 9999999999999999999999999999
start with 3
increment by 1
nocache;


spool off
