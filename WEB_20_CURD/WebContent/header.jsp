<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- 登录 注册 购物车... -->
<div class="container-fluid">
	<div class="col-md-4">
		<img src="img/logo2.png" />
	</div>
	<div class="col-md-5">
		<img src="img/header.png" />
	</div>
	<div class="col-md-3" style="padding-top:20px">
		<ol class="list-inline">
			<li><a href="login.jsp">登录</a></li>
			<li><a href="register.jsp">注册</a></li>
			<li><a href="cart.jsp">购物车</a></li>
			<li><a href="order_list.jsp">我的订单</a></li>
		</ol>
	</div>
</div>

<!-- 导航条 -->
<div class="container-fluid">
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					
				</button>
				<a class="navbar-brand" href="#">首页</a>
			</div>

			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li class="active"><a href="product_list.htm">手机数码<span class="sr-only">(current)</span></a></li>
					<li><a href="#">电脑办公</a></li>
					<li><a href="#">孕婴保健</a></li>
					<li><a href="#">鞋靴箱包</a></li>
				</ul>
				<form class="navbar-form navbar-right" role="search">
					<div class="form-group" style="position:relative">
						<input id="search" type="text" class="form-control" placeholder="Search" onkeyup="SearchWord(this)">
						<div id="showDiv" style="display:none;position:absolute;z-index:1000;background:#fff; width:170px; border:1px solid #ccc;">
							
						</div>
						<!-- 完成异步搜索 -->
						<script type="text/javascript">
						 function overFn(obj){
							 $(obj).css("background","#DBEAF9");
						 }
						 
						 function outFn(obj){
							 $(obj).css("background","#fff");
							 
						 }
						 
						 function checkWord(obj){
							 //获取showDiv中的值,添加到Search中
							 $("#search").val($(obj).html());
							 //showDiv隐藏
							 $("#showDiv").css("display","none");
						 }
						  
						
						
						    //绑定keyup事件会在按键释放时触发
						    function SearchWord(obj){
						    	//1.获取text文本框中的内容
						    	var searchText=$(obj).val();
						    	var context="";
						    	//2.ajax传递数据
						    	$.post(
						    		  "${pageContext.request.contextPath}/searchWord",
						    		  {"word":searchText},
						    		  function(data){
						    				//3、将返回的商品的名称 现在showDiv中
						    				//进行判断返回值是否有值
						    				if(data.length>0){
						    					//遍历该集合
						    					for(var i=0;i<data.length;i++){
						    						context+="<div style='padding:5px;cursor:pointer' onclick='checkWord(this)' onmouseover='overFn(this)' onmouseout='outFn(this)'>"+data[i]+"</div>";//cursor:pointer:当鼠标移到这个DIV上时,鼠标变成小手状
						    					}
						    					//将内容添加到showDiv
						    					$("#showDiv").html(context);
						    					//改变showDiv的隐藏属性
						    					$("#showDiv").css("display","block");
						    				}
						    		
						    		  },
						    		  "json"
						    	);
						    }
						   
						</script>
					</div>
					<button type="submit" class="btn btn-default">Submit</button>
				</form>
			</div>
		</div>
	</nav>
</div>