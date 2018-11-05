<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css" />
    <script type="text/javascript" src="static/js/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>

    <title>登录</title>
</head>

<body>
    <div class="container" width="400px" height="800px">
        <div class="row">
            <div class="col-xs-6 col-md-4"></div>
            <div class="col-xs-6 col-md-4">用户登录与注册</div>
        </div>

        <div class="container">
            <form class="form-horizontal">
                <div class="form-group">
                    <label for="username" class="col-sm-2 control-label">用户名</label>
                    <div class="col-sm-5">
                        <input type="email" name="username" class="form-control" id="username" placeholder="用户名">
                    </div>
                </div>
                <div class="form-group">
                    <label for="password" class="col-sm-2 control-label">密码</label>
                    <div class="col-sm-5">
                        <input type="password" name="pwd" class="form-control" id="pwd" placeholder="密码">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <div class="checkbox">
                            <label>
                                <input type="checkbox"> 记住用户名和密码
                            </label>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-3 col-sm-3">
                        <button type="submit" class="btn btn-default btn-lg btn-block">登录</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</body>

</html>