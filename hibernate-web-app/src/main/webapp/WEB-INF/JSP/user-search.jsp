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
</head>
<body>


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



	<form action="${pageContext.request.contextPath}/home/search"
		method="post" style="text-align: center">
		<p>
		<div>
			<br> <p>Phone 
			<br> <input type="tel" name="phone"
				pattern="\d*" minlength="11" maxlength="11"
				placeholder="Enter phone number">
		</div>
		<p>
			<br>
			<button type="submit" class="btn btn-primary" name="button">
				Search Contact</button>

			<!-- <br> <input type="submit" value="Search Contact"> -->
	</form>

	<c:if test="${pageContext.request.method=='POST'}">
		<c:choose>
			<c:when test="${param.phone==''}">
				<%
					System.out.println("helloooooooo");
				%>
				<script type="text/javascript">
					$('#myModal').modal('show');
				</script>
			</c:when>
			<c:otherwise>
				<%
					System.out.println("other helloooooooo");
				%>
				<jsp:forward page="/home/list"></jsp:forward>
			</c:otherwise>
		</c:choose>
	</c:if>

	<%
		System.out.println("body 2 helloooooooo");
	%>
</body>
</html>