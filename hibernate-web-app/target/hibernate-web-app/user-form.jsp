<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>User Management Application</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/update" method="post">
		<p>
			Id: ${id}<br>
		</p>
		<p>OldName: ${name}<br>
		<input type="text" name="name"/>
		</p>
		<p>OldMail: ${email}<br>
		<input type="text" name="mail" />
		</p>
		<p>Country: ${country}<br>
		<input type="text" name="country" />
		</p>
		<p>Phone: ${phone}<br>
		<input type="text" name="phone" />
		</p>
		  <br>
			<input type="submit" value="Search User">
	</form>
</body>
</html>