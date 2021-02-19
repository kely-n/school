<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>School contact manager</title>
    <style>
        body{

            background-color: #0a484a;
            color: white;
        }
        a{
            text-decoration: unset;
            color: #74c9cc;
        }
        a:hover{
            color: #9ae9ec;
        }
        table{
            border-collapse: collapse;
        }
        th, td {
            padding: 12px;
        }
        tr:hover{
            background-color: #083a3c;
        }
    </style>
</head>
<body>
<div align="center">
    <h1>Contact List</h1>
    <h3><a href="new">Create Contact</a></h3>
    <table border="1" cellpadding="5">
         <tr>
             <th>Number</th>
             <th>Name</th>
             <th>Email</th>
             <th>address</th>
             <th>phone</th>
             <th>Action</th>
         </tr>
        <c:forEach items="${listContact}" var="contact" varStatus="status">
            <tr>
                <td>${status.index + 1}</td>
                <td>${contact.name}</td>
                <td>${contact.email}</td>
                <td>${contact.address}</td>
                <td>${contact.phone}</td>
                <td>
                    <a href="edit?id=${contact.contactId}">Edit</a>
                        &nbsp; &nbsp;
                    <a href="delete?id=${contact.contactId}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<div align="center" style="padding: 30px"><a href="/logout" >Logout</a></div>
</body>
</html>