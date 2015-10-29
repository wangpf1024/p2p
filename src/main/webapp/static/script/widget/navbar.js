define(function(require, exports, module) {

     var $ = require('jquery');
    //导航栏
    function navbar(){
        this.login = $("#navbar-login");
        this.loginOut = $("#navbar-loginout");
        this.userName = $("#navbar-username");
    }

    //检测用户登录 session
    navbar.prototype.checkSession = function(){
        var $_navbar = this;
        $.ajax({url: "session/check.do",
         dataType: "json",
         success: function(data){
             if(data.result){
                 $_navbar.loginOut.show();
                 $_navbar.userName.find('a').html(data.data.userName)
                 $_navbar.userName.show();
             }else{
                 $_navbar.login.show();
             }
         }
         });
    }

    //导航栏初始化
    navbar.prototype.init = function(){
        //this.checkSession();
    }

    return  new navbar();

});