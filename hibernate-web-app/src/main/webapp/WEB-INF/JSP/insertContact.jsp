<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/home/insert" method="post" style="text-align:center">
		<p>Name: 
		<input type="text" name="name" />
		</p>
		<p>Mail: 
		<input type="email" name="email" />
		</p>
		<p>Country: 
		<input type="text" name="country" />
		</p>
		<p>Phone: 
		<input type="tel" name="phone" pattern="\d*" minlength="11" maxlength="11" />
		</p>
		  <br>
			<input type="submit" value="Create Contact">
	</form>
</body>
</html>