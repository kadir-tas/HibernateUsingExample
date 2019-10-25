<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>User Management Application</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css"
	rel="stylesheet" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<%
		System.out.println("user-form1 helloooooooo");
	%>

	<form action="${pageContext.request.contextPath}/home/update" 
			method="post" style="text-align: center">
		<p>
			<br>
		</p>
		<p>
			${user.name}<br>
		</p>
		<p>
			Name: <input type="text" name="name" value='${user.name}' /><br>

		</p>
		<p>
			Mail: <input type="email" name="email" value='${user.email}' /><br>

		</p>
		<p>
			Country: <input type="text" name="country" value='${user.country}' /><br>

		</p>
		<p>
			Phone: ${user.phone} <br>

		</p>
		<!-- Trigger the modal with a button -->
		<br>
		<!-- <button type="submit" class="btn btn-primary" id="updateButon"> Update Contact </button> -->
 		  <input type="submit" value="Update Contact" name="updateButon">  
	</form>

	<div class="container mt-3">
		<!-- The Modal -->
		<div class="modal fade" id="myModal">
			<div class="modal-dialog">
				<div class="modal-content">

					<!-- Modal Header -->
					<div class="modal-header">
						<h4 class="modal-title">Modal Heading</h4>
						<button type="button" class="close" data-dismiss="modal">×</button>
					</div>

					<!-- Modal body -->
					<div class="modal-body">Please enter all values in the
						fields.</div>

					<!-- Modal footer -->
					<div class="modal-footer">
						<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>
	</div>

<c:if test="${param.updateButon}">
		<c:choose>
			<c:when test="${param.user.name==''}"> 
				<script type="text/javascript">
				<%
				System.out.println("update when helloooooooo");
			%>
					$('myModal').modal();
				</script>
			</c:when>
			<c:otherwise>
			<%
		System.out.println("update otherwise helloooooooo");
	%>
				<jsp:forward page="/home/update" />
			</c:otherwise>
		</c:choose> 
	</c:if>
<%
		System.out.println("user-form 2 helloooooooo");
	%>
</body>
</html>