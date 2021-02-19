<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>School contact manager</title>
    <style>
        body{

            background-color: darkgreen;
            height: 100%;
        }
        .inputGroup{
            background-color: cornsilk;
            border: 1px solid crimson;
            padding: 10px;
            color: black;
            margin: 10px;
            font-size: 1.2em;
            display: block;
        }
        button{
            background-color: crimson;
            height: 50px;
            width: 100px;
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
<div align="center" style="display: inline-block">
    <div>
        <form action="/">
            <label>please login</label>
            <input class="inputGroup" placeholder="username" type="text" name="username">
            <input class="inputGroup" placeholder="password" type="password" name="password">
            <button type="submit">Login</button>
        </form>
    </div>
</div>
</body>
</html>