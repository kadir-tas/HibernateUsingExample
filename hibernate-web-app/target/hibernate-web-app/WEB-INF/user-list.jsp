<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
 <title>User Management Application</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/edit" method="post">
		<p>Phone: 
		<input type="text" name="phone" />
		</p>
		  <br>
			<input type="submit" value="Search User">
	</form>
	
</body>
</html>