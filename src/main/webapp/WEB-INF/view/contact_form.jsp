<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>create new contact</title>
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
               <td colspan="2" align="center"><input type="submit" value = "save" /> </td>
           </tr>
       </table>
    </form:form>

</div>

</body>
</html>