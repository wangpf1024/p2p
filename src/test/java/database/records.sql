prompt PL/SQL Developer import file
prompt Created on 2015年10月10日 by wangpengfei
set feedback off
set define off
prompt Disabling triggers for RESOURCES...
alter table RESOURCES disable all triggers;
prompt Disabling triggers for ROLES...
alter table ROLES disable all triggers;
prompt Disabling triggers for ROLES_RESOURCES...
alter table ROLES_RESOURCES disable all triggers;
prompt Disabling triggers for USERS...
alter table USERS disable all triggers;
prompt Disabling triggers for USERS_ROLES...
alter table USERS_ROLES disable all triggers;
prompt Deleting USERS_ROLES...
delete from USERS_ROLES;
commit;
prompt Deleting USERS...
delete from USERS;
commit;
prompt Deleting ROLES_RESOURCES...
delete from ROLES_RESOURCES;
commit;
prompt Deleting ROLES...
delete from ROLES;
commit;
prompt Deleting RESOURCES...
delete from RESOURCES;
commit;
prompt Loading RESOURCES...
insert into RESOURCES (id, name, descript, url, type)
values (2, 'admin', '管理员', '/admin/index.do', 0);
insert into RESOURCES (id, name, descript, url, type)
values (3, 'member', '普通用户', '/member/index.do', 0);
commit;
prompt 2 records loaded
prompt Loading ROLES...
insert into ROLES (id, name, descript, type)
values (2, 'admin', '管理员', 0);
insert into ROLES (id, name, descript, type)
values (3, 'member', '普通用户', 0);
commit;
prompt 2 records loaded
prompt Loading ROLES_RESOURCES...
insert into ROLES_RESOURCES (role_id, resource_id)
values (2, 2);
insert into ROLES_RESOURCES (role_id, resource_id)
values (3, 3);
commit;
prompt 2 records loaded
prompt Loading USERS...
insert into USERS (id, firstname, lastname, email, password, username, isaccountnonexpired, isaccountnonlocked, iscredentialsnonexpired, isenabled)
values (2, '鹏飞', '王', '13522921121@163.com', '111111', '13522921121', 0, 0, 0, 0);
commit;
prompt 1 records loaded
prompt Loading USERS_ROLES...
insert into USERS_ROLES (user_id, role_id)
values (2, 3);
commit;
prompt 1 records loaded
prompt Enabling triggers for RESOURCES...
alter table RESOURCES enable all triggers;
prompt Enabling triggers for ROLES...
alter table ROLES enable all triggers;
prompt Enabling triggers for ROLES_RESOURCES...
alter table ROLES_RESOURCES enable all triggers;
prompt Enabling triggers for USERS...
alter table USERS enable all triggers;
prompt Enabling triggers for USERS_ROLES...
alter table USERS_ROLES enable all triggers;
set feedback on
set define on
prompt Done.
