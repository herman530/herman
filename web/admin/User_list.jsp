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
    <title>用户管理系统</title>
</head>

<body>

<a href="admin/User_addInput">添加会员资料</a>
<hr/>
用户列表
<hr/>
<s:iterator value="users" var="user">
	<s:property value="#user.name"/> |
	<s:property value="#user.description"/> |
	<a href="admin/User_delete?id=<s:property value="#user.id"/>">删除会员资料</a> |
	<a href="admin/User_updateInput?id=<s:property value="#user.id"/>">更新会员资料</a>
	<br/>
</s:iterator>

</body>
</html>