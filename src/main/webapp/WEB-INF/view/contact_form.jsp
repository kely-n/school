<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>create new contact</title>
    <style>
        body{

            background-color: #0a484a;
            color: white;

        }

        button{
            background-color: #12a3a8;
            height: 50px;
            width: 150px;
            font-size: 1.2em;
            display: block;
            margin-top: 50px;
        }
        a{
            text-decoration: unset;
            color: #74c9cc;
            padding: 10px;
        }
        a:hover{
            color: #9ae9ec;
        }
    </style>
</head>
<body>
<div align="center">
    <h1>create/edit contact</h1>
    <%--@elvariable id="contact" type=""--%>
    <form:form action="save" method="post" modelAttribute="contact">
       <table>
           <form:hidden path="contactId" />
           <tr>
               <td>Name:</td>
               <td><form:input path="name" /></td>
           </tr>
           <tr>
               <td>Email:</td>
               <td><form:input path="email" /></td>
           </tr>
           <tr>
               <td>Address:</td>
               <td><form:input path="address" /></td>
           </tr>
           <tr>
               <td>Phone:</td>
               <td><form:input path="phone" /></td>
           </tr>

           <tr>
               <td colspan="2" align="center"><button type="submit" value = "save">save</button> </td>
           </tr>
       </table>
    </form:form>


</div>
<div>
    <a href="/">back</a>
</div>
</body>
</html>