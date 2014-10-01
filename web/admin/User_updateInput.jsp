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
    <title>更新会员资料</title>
</head>

<body>
 <form action="admin/User_update" method="post">
  	<input type="hidden" name="user.id" value="<s:property value="user.id"/>" /><br/>
  	  	用户:<input name="user.name"  value="<s:property value="user.name"/>"/><br/>
	  	说明:<input name="user.description" value="<s:property value="user.description"/>" /><br/>
  		<input type="submit" value="更新" /> 	  	
  </form>
</body>
</html>