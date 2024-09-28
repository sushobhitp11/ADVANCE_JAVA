<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="Header.jsp"%>
	<form action="UserCtl.do" method="post">
		<div align="center">
			<%
				String msg = (String) request.getAttribute("msg");
				UserBean bean = (UserBean) request.getAttribute("bean");
			%>
			<%
				if (bean != null && bean.getId() > 0) {
			%>
			<h1>Update User</h1>
			<%
				} else {
			%>
			<h1>Add User</h1>
			<%
				}
			%>
			<%
				if (msg != null) {
			%>
			<h3>
				<font colour="green"><%=msg%></font>
			</h3>
			<%
				}
			%>
			<table>
				<input type="hidden" name="id"
					value="<%=(bean != null && bean.getId() > 0) ? bean.getId() : ""%>">
				</td>
				<tr>
					<th>First Name:</th>
					<td><input type="text" name="firstName"
						value="<%=(bean != null && bean.getFirstName() != null) ? bean.getFirstName() : ""%>"></td>
				</tr>
				<tr>
					<th>Last Name:</th>
					<td><input type="text" name="lastName"
						value="<%=(bean != null && bean.getLastName() != null) ? bean.getLastName() : ""%>"></td>
				</tr>
				<tr>
					<th>Gender:</th>
					<td><input type="text" name="gender"
						value="<%=(bean != null && bean.getGender() != null) ? bean.getGender() : ""%>"></td>
				</tr>
				<tr>
					<th>Login Id:</th>
					<td><input type="text" name="loginId"
						value="<%=(bean != null && bean.getLoginId() != null) ? bean.getLoginId() : ""%>"></td>
				</tr>
				<tr>
					<th>Password:</th>
					<td><input type="text" name="password"
						value="<%=(bean != null && bean.getPassword() != null) ? bean.getPassword() : ""%>"></td>
				</tr>
				<tr>
					<th>DOB:</th>
					<td><input type="date" name="dob"
						value="<%=(bean != null && bean.getDob() != null) ? bean.getDob() : ""%>"></td>
				</tr>
				<tr>
					<th>PhoneNo:</th>
					<td><input type="text" name="phoneNo"
						value="<%=(bean != null && bean.getPhoneNo() != null) ? bean.getPhoneNo() : ""%>"></td>
				</tr>
				<tr>
					<th>Address:</th>
					<td><input type="text" name="address"
						value="<%=(bean != null && bean.getAddress() != null) ? bean.getAddress() : ""%>"></td>
				</tr>
				<tr>
					<th></th>
					<td><input type="submit" name="operation"
						value="<%=(bean != null && bean.getId() > 0) ? "update" : "save"%>"></td>
					</div>
					</form>
</body>
</html>