<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/edit" method="post">
		<p>Id: 
		<input type="text" name="userId" />
		</p>
		<p>Name: 
		<input type="text" name="name" />
		</p>
		<p>Mail: 
		<input type="text" name="mail" />
		</p>
		<p>Country: 
		<input type="text" name="country" />
		</p>
		<p>Phone: 
		<input type="text" name="phone" />
		</p>
		  <br>
			<input type="submit" value="Search User">
	</form>
</body>
</html>