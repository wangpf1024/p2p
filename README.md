# p2p  
   
p2p 互联网金融项目 Demo

使用技术： bootstrap , jquery ,spring mvc , spring security , mybatis , bonecp ,oracle

介绍

   1.技术层面前后台分离
   
    前台使用纯 html5 + css3 + bootstrap + javascript + js框架     
    后台业务层使用 spring mvc 注解方式    
    后台安全框架 spring security ioc 方式（简单）    
    后台数据库 mybatis + oracle ,连接池采用 bonecp   
    日志框架 log4j   
   
   2.前后台使用 http 协议通讯  数据格式为 json      
   
   3. Spring Security   
     数据库文件 ： records.sql（默认记录）， seq.sql（序列）， tables.sql（表），triger.sql（触发器）  
     数据表 ：RESOURCES（资源表），ROLES（角色表），ROLES_RESOURCES（角色资源表），USERS（用户表），USERS_ROLES（用户角色表）
     业务关系：系统启动时默认加载全部受保护的资源（RESOURCES），同时根据（ROLES_RESOURCES）对某个角色（ROLES）对应的资源进   
     行划分。Spring Security 框架自动拦截全部url请求。如果发现请求的url是属于受保护的资源。要求请求用户登录系统。用户登录   
     时会加载对应用户角色（USERS_ROLES）。然后将请求url需要的角色与用户的角色进行对比。判断是否存在权限。  
   
   
   
   4.自定义监控日志-检测业务控制层的执行时间注解方式实现  


