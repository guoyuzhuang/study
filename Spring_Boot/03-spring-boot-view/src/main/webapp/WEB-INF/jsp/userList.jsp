<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>这里可以展示用户信息</title>
</head>
<body>
用列表的方式展示用户的信息：<br />
<c:forEach items="${list}" var="users">
用户名：${users.name}
<br />
</c:forEach>
</body>
</html>