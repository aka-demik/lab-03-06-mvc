<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%--@elvariable id="car" type="carshop.models.Car"--%>
<%--@elvariable id="myText" type="java.lang.String"--%>
<%--
  Created by IntelliJ IDEA.
  User: mail4
  Date: 06.03.2017
  Time: 11:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Text</title>
</head>
<body>
    <h1>${myText}</h1>
    <h2>${car.model}</h2>
    <a href="/model/showfullcar">Show full carr</a>
    <form action="/text" method="post">
        <input name="param1" type="text"/>
        <button type="submit">Go</button>
    </form>

    <spring:form method="post"  modelAttribute="car" action="/model/showfullcar">
        <spring:input path="model"/>
        <spring:input path="regNum"/>
        <spring:button>Next Page</spring:button>
    </spring:form>

</body>
</html>
