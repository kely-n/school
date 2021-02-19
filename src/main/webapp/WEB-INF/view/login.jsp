<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>School contact manager</title>
    <style>
        body{
            display: flex;
            justify-content: center;
            align-items: center;
            background-color: #0a484a;

        }
        .inputGroup{
            background-color: cornsilk;
            border: 1px solid steelblue;
            padding: 10px;
            color: black;
            margin: 20px;
            font-size: 1.2em;
            display: block;
        }
        button{
            background-color: #12a3a8;
            height: 50px;
            width: 150px;
            font-size: 1.2em;
            display: block;
        }
        label{
            padding: 10px;
            color: white;
            margin: 10px;
            font-size: 1.2em;
            font-weight: 900;
            display: block;
        }
    </style>
</head>
<body>
<div align="center" style=" margin-top: 10%" >

        <form action="login" method="POST">
            <label>please login</label>
            <input class="inputGroup" placeholder="username" type="text" name="username" value="" required>
            <input class="inputGroup" placeholder="password" type="password" name="password" value="" required>
            <button type="submit" name="submit" value="submit">Login</button>
        </form>
            <div style="background-color: crimson">${SPRING_SECURITY_LAST_EXCEPTION.message}</div>

</div>
</body>
</html>