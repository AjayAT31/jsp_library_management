
<%@page import="jsp_library_management.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%List<User> list = (List) request.getAttribute("list"); %>
	<table border="2px" cellspacing="0px">
		<% for(User user: list) { %>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Phone</th>
			<th>Email</th>
			<th>Password</th>
		</tr>

		<tr>
			<td><%=user.getId()%></td>
			<td><%=user.getName()%></td>
			<td><%=user.getPhone()%></td>
			<td><%=user.getEmail()%></td>
			<td><%=user.getPassword()%></td>
			<td><a href="delete?id=<%=user.getId()%>"><button>DELETE</button></a></td>
			<td><a href="update?id=<%=user.getId()%>"><button>UPDATE</button></a></td>
		</tr>
		<%
		}
		%>
	</table>


	<a href="login.jsp"><button>Log Out</button></a>

	<a href="AddBook.jsp"><button>Add a Book</button></a>
	<a href="DisplayBook.jsp"><button>Available Books</button></a>
</body>
</html>