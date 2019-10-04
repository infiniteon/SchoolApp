<%@page import="schoolApp.Beans.Academics"%>
<%@page import="schoolApp.Beans.Payment"%>
<%@page import="schoolApp.Beans.Student"%>
<%@page import="schoolApp.Beans.Class"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
#navbar {
	width: 13%;
	float: left;
	margin: 1%;
}

#mainContainer {
	float: left;
	width: 85%;
}

#result {
	margin: 1% 2% 1% 0%;
	text-align: center;
}

#navbar input {
	border: none;
	width: 100%;
	padding: 10px;
	background-color: white;
	border: 1px solid green;
}

table {
	border-collapse: collapse;
	border: 1px solid silver;
	width: 100%;
	margin: 5px;
}

th {
	background-color: orange;
}

th, td {
	border: 1px solid silver;
	text-align: center;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div style="margin: 5px 0px; overflow: auto;">
		<div id="navbar">
			<form action="Accountant" method="post">
				<input type="submit" name="type" value="Student Details" /> <br>
				<input type="submit" name="type" value="Fee Details" /> <br> <input
					type="submit" name="type" value="Academic Details" /> <br> <input
					type="submit" name="type" value="Class Details" /><br> <input
					type="submit" name="type" value="Find Student" /><br> <input
					type="submit" name="type" value="Refresh Data" />
			</form>
		</div>
		<div id="mainContainer" style="">
			<div id="result" style="">
				<%
					String type = (String) request.getAttribute("type");
					if (type.equals("")) {
						out.print("<h1>Welcome Accountant</h1>");
					} else if (type.equals("SD")) {
						List<Student> list = (List<Student>) request.getSession(false).getAttribute("dataSD");
						out.print(
								"<table><tr><th>ID</th><th>Name</th><th>Parent Name</th><th>Occupation</th><th>Address</th><th>Phone</th><th>DOB</th><th>DateOfJoinig</th></tr>");
						for (Student student : list) {
							out.print("<tr><td>" + student.getId() + "</td><td>" + student.getName() + "</td><td>"
									+ student.getParentName() + "</td><td>" + student.getOccupation() + "</td><td>"
									+ student.getAddress() + "</td><td>" + student.getPhone() + "</td><td>" + student.getDob()
									+ "</td><td>" + student.getDateOfJoining() + "</td></tr>");
						}
						out.print("</table>");
					} else if (type.equals("FD")) {
						List<Payment> list = (List<Payment>) request.getSession(false).getAttribute("dataFD");
						boolean find = (boolean) request.getSession(false).getAttribute("find");
						out.print(
								"<form action=\"Accountant\" method=\"get\"><input type=\"submit\" name=\"type\" value=\"Find Due\"/>"
										+ "<input type=\"submit\" name=\"type\" value=\"Get All Payments\"/>" + "</form>");
						if (!find) {
							out.print(
									"<table><tr><th>ID</th><th>AmountPaid</th><th>PaidForMonth</th><th>StudentID</th><th>Date</th></tr>");
							for (Payment payment : list) {
								out.print("<tr><td>" + payment.getId() + "</td><td>" + payment.getAmount() + "</td><td>"
										+ payment.getPaidForMonth() + "</td><td>" + payment.getStudentId() + "</td><td>"
										+ payment.getDate() + "</td></tr>");
							}
							out.print("</table>");
						} else {
							%>
							<jsp:include page="search.jsp" />
							<%
						}
					} else if (type.equals("AD")) {
						List<Academics> list = (List<Academics>) request.getSession(false).getAttribute("dataAD");
						out.print("<table><tr><th>ID</th><th>StudentID</th><th>ClassID</th><th>Year</th></tr>");
						for (Academics academic : list) {
							out.print("<tr><td>" + academic.getId() + "</td><td>" + academic.getStudentId() + "</td><td>"
									+ academic.getClassId() + "</td><td>" + academic.getYear() + "</td></tr>");
						}
						out.print("</table>");
					} else if (type.equals("CD")) {
						List<Class> list = (List<Class>) request.getSession(false).getAttribute("dataCD");
						out.print("<table><tr><th>ID</th><th>Name</th><th>Fee</th></tr>");
						for (Class c : list) {
							out.print("<tr><td>" + c.getId() + "</td><td>" + c.getName() + "</td><td>" + c.getFee()
									+ "</td></tr>");
						}
						out.print("</table>");
					} else if (type.equals("FS")) {
						System.out.println("sending to search jsp" + request.getParameterNames());
				%>
				<jsp:include page="search.jsp" />
				<%
					}
				%>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>