<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.List"%>
<%@ page import="schoolApp.Beans.*"%>
<%@ page import="schoolApp.Beans.Class"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div id="searchbar" style="">
		<form action="Accountant" method="get">
			<input type="text" name="key" placeholder="Enter Student name or id"
				size="50" /> <input type="submit" name="type" value="search" />
		</form>
		<div>
			<%
				String key = (String) request.getSession(false).getAttribute("key");
				out.print("showing results for \""+ key+"\"");
				if (key.equals("") || key.equals(null)) {
					out.print("<h1>To get full details enter id<br>To find id enter a part of name</h1>");
				} else {
					Search search = (Search) request.getSession(false).getAttribute("search");
					List<Student> SDlist = (List<Student>) search.getSD();
					if (!SDlist.isEmpty()) {
						out.print(
								"<table><tr><th>ID</th><th>Name</th><th>Parent Name</th><th>Occupation</th><th>Address</th><th>Phone</th><th>DOB</th><th>DateOfJoinig</th></tr>");
						for (Student student : SDlist) {
							out.print("<tr><td>" + student.getId() + "</td><td>" + student.getName() + "</td><td>"
									+ student.getParentName() + "</td><td>" + student.getOccupation() + "</td><td>"
									+ student.getAddress() + "</td><td>" + student.getPhone() + "</td><td>"
									+ student.getDob() + "</td><td>" + student.getDateOfJoining() + "</td></tr>");
						}
						out.print("</table>");
					}
					List<Payment> Plist = (List<Payment>) search.getFD();
					if (!Plist.isEmpty()) {
						out.print(
								"<table><tr><th>ID</th><th>AmountPaid</th><th>PaidForMonth</th><th>StudentID</th><th>Date</th></tr>");
						for (Payment payment : Plist) {
							out.print("<tr><td>" + payment.getId() + "</td><td>" + payment.getAmount() + "</td><td>"
									+ payment.getPaidForMonth() + "</td><td>" + payment.getStudentId() + "</td><td>"
									+ payment.getDate() + "</td></tr>");
						}
						out.print("</table>");
					}
					List<Academics> Alist = (List<Academics>) search.getAD();
					if (!Alist.isEmpty()) {
						out.print("<table><tr><th>ID</th><th>StudentID</th><th>ClassID</th><th>Year</th></tr>");
						for (Academics academic : Alist) {
							out.print("<tr><td>" + academic.getId() + "</td><td>" + academic.getStudentId() + "</td><td>"
									+ academic.getClassId() + "</td><td>" + academic.getYear() + "</td></tr>");
						}
						out.print("</table>");
					}
					/* List<Class> Clist = (List<Class>) search.getCD();
					out.print("<table><tr><th>ID</th><th>Name</th><th>Fee</th></tr>");
					for (Class c : Clist) {
						out.print("<tr><td>" + c.getId() + "</td><td>" + c.getName() + "</td><td>" + c.getFee()+ "</td></tr>");
					}
					out.print("</table>"); */
				}
			%>
		</div>

	</div>
</body>
</html>