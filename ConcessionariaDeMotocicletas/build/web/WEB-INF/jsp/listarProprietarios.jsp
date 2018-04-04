<%-- 
    Document   : listarProprietarios
    Created on : 28/03/2018, 20:53:04
    Author     : Victorio Zansavio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Estes são os proprietarios Cadastrados ${proprietarios.size()}</h1>
        <c:forEach items="${proprietarios}" var="item">
            <p> <c:out value="${item.nome}"/> </p>
        </c:forEach>
     
    </body>
</html>
