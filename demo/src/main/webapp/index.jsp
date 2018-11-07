<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <script type="text/javascript" src="${APP_PATH}/static/js/jquery-1.9.1.min.js"></script>
    <link rel="stylesheet" href="${APP_PATH}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" />
    <script type="text/javascript" src="${APP_PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>

    <title>首页</title>
</head>

<body>
    <div class="container" width="400px" height="800px">
        <div class="row">
            <div class="col-xs-6 col-md-4"></div>
            <div class="col-xs-6 col-md-4">用户注册</div>
        </div>

        <div class="container">
            <form class="form-horizontal" action=""  method="POST" id="login_form">
                <div class="form-group" id="usernameDiv">
                    <label for="username" class="col-sm-2 control-label">用户名</label>
                    <div class="col-sm-5">
                        <input type="text" msg="用户名" name="username" class="form-control" id="username" placeholder="用户名由字母和数字组成首位不能为数字，6-11位"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="password" class="col-sm-2 control-label">密码</label>
                    <div class="col-sm-5">
                        <input type="password"  msg="密码" name="pwd" class="form-control" id="pwd" placeholder="最少输入6位"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="gender" class="col-sm-2 control-label">性别</label>
                    <div class="col-sm-5">
                        <label class="radio-inline">
                            <input type="radio" name="gender" id="gender" value="男" checked="checked"/> 男
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="gender" id="gender" value="女"/> 女
                        </label>
                    </div>
                </div>
                <div class="form-group">
                    <label for="age" class="col-sm-2 control-label">年龄</label>
                    <div class="col-sm-5">
                        <input type="text" msg="年龄" name="age" class="form-control" id="age" placeholder="输入数字例如18">
                    </div>
                </div>
                <div class="form-group">
                    <label for="tel" class="col-sm-2 control-label">电话号码</label>
                    <div class="col-sm-5">
                        <input type="text" msg="电话号码" name="tel" class="form-control" id="tel" placeholder="电话号码长度为11位">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-3 col-sm-3">
                        <button type="button" class="btn btn-default btn-lg btn-block" onclick="validate_add_form()">注册</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <script type="text/javascript">
    /*
	验证表单的合理性
	首先是用户名：首字母不能为数字，6-11位，不能使用重复的用户名
	密码：最少为6位
	手机号码只能为11位
	*/
    function validate_add_form() {
        var username = $("#username").val();
        // alert(username);
        var pwd = $("#pwd").val();
        var tel = $("#tel").val();
        //注意，这里不能加上""
        var ureg = /^[a-zA-z][a-zA-Z0-9_]{5,11}$/;
        var preg = /^[0-9a-zA-Z]{6,}$/;
        var treg = /^((0\d{2,3}-\d{7,8})|(1[3584]\d{9}))$/;
        $("#login_form").attr("action","${APP_PATH}/register");
        //$("#login_form").submit();
        //$("span").text("");
        var num = 0;
        var str = [];
        var onsubmit = false;

        $("#login_form input").each(function (n) {
            if ($(this).val() == "") {
                num++;
                str = str.concat($(this).attr("msg"));
            }
        });
        if (num > 0) {
            alert(str  + "不能为空！\n");
            onsubmit = false;
            return;
        }
        else {
            onsubmit = true;
        }

        if (!ureg.test(username)) {
            onsubmit = false;
            alert("用户名输入格式不正确");
        } else if (!preg.test(pwd)) {
            onsubmit = false;
            alert("密码输入格式不正确,请检查后再输入");
        } else if (!treg.test(tel)) {
            onsubmit = false;
            alert("电话输入格式不正确,请检查后再输入");
        }
        if(onsubmit && num == 0)
       	{
        	$("#login_form").submit();
       	}
            
    }
    	
    	/*
    	使用ajax进行用户名是否重复的校验
    	*/
    	$("#username").change(function(){
    		var username = this.value;
    		/*
    		谨记ajax post 和get方式的区别
    		*/
    		$.ajax({
    			type:"POST",
    			url:"${APP_PATH}/checkUser",
    			data:"username=" + username,
    			success:function(result)
    			{
    				//var str = jQuery.parseJSON(result);
    				//alert(str);
    				$("#usernameDiv").removeClass("has-error");
    				$("#usernameDiv").removeClass("has-success");
    				if(100 == result.code)
   					{
   						$("#usernameDiv").addClass("has-error");
   					}else{
   						$("#usernameDiv").addClass("has-success");   					
   					}
    			}
    		});
    	});
    	
    	
    </script>
</body>
</html>