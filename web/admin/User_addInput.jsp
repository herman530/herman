<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>后台首页</title>
</head>

<body>
<body>
  <form action="admin/User_add" method="post">
	  	用户:<input name="user.name" /><br/>
	  	说明:<input name="user.description"/><br/>
	  	<input type="submit" value="注册" /> 
  </form>
  </body>
</body>
</html>