<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en-US">
<head><title>Spring 4 MVC + Hibernate</title>
</head>
<body>
	<form:form id="myform" action="addEmployee" method="POST" commandName="employee">
	 <h3> <c:if test="${employee.employeeid==null}">
			         Add New Employee
	        </c:if>
			<c:if test="${employee.employeeid!=null}">
			         Update Employee for Id: <c:out value="${employee.employeeid}"/>
					 <form:hidden path="employeeid"/>
	        </c:if>
       </h3>
       <table>
       		<tr>
       			<td>Employee Name: </td><td><form:input path="employeename" value="Sandeep"/></td>
       		</tr>
       		<tr>
       			<td>Employee Gender: </td><td><form:input path="gender" value="M"/></td>
       		</tr>
       		<tr>
       			<td>Employee Salary: </td><td><form:input path="salary" value="1000.00"/></td>
       		</tr>
       		<tr>
       			<td>Employee Company: </td><td><form:input path="company" value="TCSasd"/></td>
       		</tr>
       		<tr>
       			<td>Address: </td><td><form:input path="address.addeess" value="1452 Bell"/></td>
       		</tr>
       		<tr>
       			<td>City: </td><td><form:input path="address.city" value="Fairborn"/></td>
       		</tr>
       		<tr>
       			<td>Country: </td><td><form:input path="address.country" value="USA"/></td>
       		</tr>
       		<tr>
       			<c:if test="${employee.employeeid==null}">
			       <td colspan="2"><input type="submit" value="Add" id="btn-add"></td>
	         </c:if>
			 <c:if test="${employee.employeeid!=null}">
			      <td colspan="2"><input type="submit" value="Update" id="btn-update" formaction="updateEmployee"></td>
	         </c:if>
	         </tr>
	         <tr><td><c:out value="${msg}"/></td></tr>
       </table>
		  <table>   
	      <tr>   <td> ID </td>
		         <td> User Name </td>
				 <td> Company </td>
				 <td> Gender </td>
				 <td> Salary </td>
		  </tr>
		 
    	  <c:forEach var="obj" items="${allData}">
		      <tr>
		         <td> <c:out value="${obj.employeeid}"/> </td>
		         <td> <c:out value="${obj.employeename}"/> </td>
				 <td> <c:out value="${obj.company}"/> </td>
				 <td> <c:out value="${obj.gender}"/> </td>
				 <td> <c:out value="${obj.salary}"/> </td>
				 <td> <a href="${pageContext.request.contextPath}/deleteEmployee?employeeid=${obj.employeeid}">Delete </a> |
				     <a href="${pageContext.request.contextPath}/employeeById?employeeid=${obj.employeeid}">Edit</a> 
				 </td>
		      </tr>
	      </c:forEach>
      </table> 
	</form:form>
</body>
</html>