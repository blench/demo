<%@page import="org.springframework.web.context.annotation.SessionScope"%>
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

    <title>登录</title>
</head>

<body>
    <div class="container" width="400px" height="800px">
        <div class="row">
            <div class="col-xs-6 col-md-4"></div>
            <div class="col-xs-6 col-md-4">用户登录与注册</div>
        </div>

        <div class="container">
            <form class="form-horizontal" id="loginform">
                <div class="form-group">
                    <label for="username" class="col-sm-2 control-label">用户名</label>
                    <div class="col-sm-5">
                        <input type="email" msg="用户名" name="username" class="form-control" id="username" placeholder="用户名">
                    </div>
                </div>
                <div class="form-group">
                    <label for="password" class="col-sm-2 control-label">密码</label>
                    <div class="col-sm-5">
                        <input type="password" msg="密码" name="pwd" class="form-control" id="pwd" placeholder="密码">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <div class="checkbox">
                            <label>
                                <input type="checkbox" > 记住用户名和密码
                            </label>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-3 col-sm-3">
                        <button type="button" class="btn btn-default btn-lg btn-block" id="btn_login">登录</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <script type="text/javascript">
    	function validate_form(){
    		var num = 0;
    		var str = [];
    	//	$("#loginform").action = "";
	    	$("loginform input").each(function(){
	    		if($(this).val()=="")
	    		{
	    			num++;
	    			str = str.contact($(this).attr("msg"));
	    		}
	    	});
	    	
	    	if(num > 0)
	    	{
	    		alert(str + "不能为空!\n");
	    		return false;
	    	}else{
	    		return true;
	    	}
    	}
    	
    	$("#btn_login").click(function(){
    		if(!validate_form())
    			return false;
    		else{
    			$.ajax({
    				type:"POST",
    				url:"${APP_PATH}/userLogin",
    				data:$("#loginform").serialize(),
    				success:function(result){
    					//登录成功，跳转到list.jsp页面，登录失败则出现弹窗
    					if(result.code==100)
    					{
    						window.location.href="${APP_PATH}/toList";
    					}else{
    						alert("请检查用户名和密码是否一致");
    					}
    				}
    			});
    		}
    	});
    </script>
</body>

</html>