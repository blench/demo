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
<script type="text/javascript"
	src="${APP_PATH}/static/js/jquery-1.9.1.min.js"></script>
<link rel="stylesheet"
	href="${APP_PATH}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" />
<script type="text/javascript"
	src="${APP_PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>

<title>用户管理页面</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h1>用户增删改查</h1>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4 col-md-offset-8">
				<button class="btn btn-primary" id="user_add_modal_btn">新增</button>
				<button class="btn btn-danger" id="user_del_all_btn">删除</button>
			</div>
		</div>
		<div class="row">
			<table class="table table-hover" id="user_table">
				<thead>
					<tr>
						<th><input type="checkbox" id="check_all"></input></th>						<th>用户名</th>
						<th>性别</th>
						<th>年龄</th>
						<th>电话号码</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>

				</tbody>

			</table>
		</div>
		<div class="row">
			<nav aria-label="Page navigation">
				<ul class="pagination">
					<li><a href="#">首页 </a></li>
					<li><a href="#" aria-label="Previous"> <span
							aria-hidden="true">&laquo;</span>
					</a></li>
					<li><a href="#">1</a></li>
					<li><a href="#">2</a></li>
					<li><a href="#">3</a></li>
					<li><a href="#">4</a></li>
					<li><a href="#">5</a></li>
					<li><a href="#" aria-label="Next"> <span
							aria-hidden="true">&raquo;</span>
					</a></li>
					<li>
                        <a href="#">尾页 </a>
                    </li>
				</ul>
			</nav>
			<div class="col-md-6" id="page_info_area"></div>
			<div class="col-md-6" id="page_nav_area"></div>
		</div>
	</div>

	<script type="text/javascript">
    	//刚刚载入页面时，使用ajax进行table的构建
    	$(function(){
    		to_page(1);
    	});
    	var currentPage = 1,totalRecords;
    	
    	function to_page(pn)
    	{
    		$.ajax({
    			type:"GET",
    			url:"${APP_PATH}/users",
    			data:"pn=" + pn,
    			success:function(result){
    				//1、构建用户表
    				build_user_table(result);
    				//2、构建分页信息、
    				build_page_info(result);
    				//3、构建分页导航条
    				build_page_nav(result);
    			}
    		});
    	}
    	
    	function build_user_table(result){
    		$("#user_table tbody").empty();
    		var user = result.extend.pageInfo.record;
    		$.each(user, function(index,item){
    			var checkTd = $("<td><input type='checkbox' class='check-box'/></td>");
    			var usernameTd = $("<td></td>").append(item.username);
    			var genderTd = $("<td></td>").append(item.gender);
    			var ageTd = $("<td></td>").append(item.age);
    			var telTd = $("<td></td>").append(item.tel);
    			var edit_btn = $("<button></button>").append("修改").
    			addClass("btn btn-primary btn-sm edit-btn")
				.append("<span></span>").addClass(
				"glyphicon glyphicon-pencil").attr(
				"aria-hidden", "true");
    			edit_btn.attr("edit-id", item.username);
    			
    			var del_btn = $("<button></button>").append("删除")
				.addClass(
						"btn btn-danger btn-sm delete-btn")
				.append("<span></span>").addClass(
						"glyphicon glyphicon-trash").attr(
						"aria-hidden", "true");
    			
    			del_btn.attr("delete-id", item.username);
    			
    			//转义字符&nbsp;
    			var btnTd = $("<td></td>").append(edit_btn).append("&nbsp;").append(del_btn);
    			$("<tr></tr>").append(checkTd).append(usernameTd)
    			.append(genderTd).append(ageTd).append(telTd).append(btnTd).appendTo("#user_table tbody");
    		});
    	}
    	
    	function build_page_info(result)
    	{
    		
    	}
    	
    	function build_page_nav(result)
    	{
    		
    	}
    	
    	/*
    	给按钮添加删除事件
    	
    	*/
    	$(document).on("click", ".delete-btn", function(){
    		var username = $(this).attr("delete-id");
    		if(confirm("你确定要删除【" + username +"】吗？"))
    		{
    			$.ajax({
    				type:"DELETE",
    				url:"${APP_PATH}/user/"+username,
    				success:function(result)
    				{
    					alert(result.msg);
    					to_page(currentPage);
    				}
    			});
    		}
    	});
    </script>
</body>
</html>