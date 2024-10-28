<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Relationship Manager</title>
<!-- Bootstrap CSS -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
 <div class="container mt-4">
  <div class="row">
   <div class="col-md-10 offset-md-1">
    <h2>CRM - Customer Relationship Manager</h2>
    <hr />

    <button type="button" class="btn btn-primary" onclick="window.location.href='showForm';">Add Customer</button>
    <br/><br/>

    <div class="card">
     <div class="card-header">
      <h5 class="card-title mb-0">Customer List</h5>
     </div>
     <div class="card-body">
      <table class="table table-striped table-bordered">
       <thead>
        <tr>
         <th>First Name</th>
         <th>Last Name</th>
         <th>Email</th>
         <th>Action</th>
        </tr>
       </thead>
       <tbody>
        <!-- loop over and print our customers -->
        <c:forEach var="tempCustomer" items="${customers}">
         <!-- construct an "update" link with customer id -->
         <c:url var="updateLink" value="/customer/updateForm">
          <c:param name="customerId" value="${tempCustomer.id}" />
         </c:url>

         <!-- construct a "delete" link with customer id -->
         <c:url var="deleteLink" value="/customer/delete">
          <c:param name="customerId" value="${tempCustomer.id}" />
         </c:url>

         <tr>
          <td>${tempCustomer.firstName}</td>
          <td>${tempCustomer.lastName}</td>
          <td>${tempCustomer.email}</td>

          <td>
           <!-- display the update link -->
           <a href="${updateLink}" class="btn btn-warning btn-sm">Update</a>
           <!-- display the delete link -->
           <a href="${deleteLink}" class="btn btn-danger btn-sm"
              onclick="return confirm('Are you sure you want to delete this customer?');">Delete</a>
          </td>
         </tr>
        </c:forEach>
       </tbody>
      </table>
     </div>
    </div>
   </div>
  </div>
 </div>

 <!-- jQuery and Bootstrap JS -->
 <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
 <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
