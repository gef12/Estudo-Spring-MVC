<%-- 
    Document   : index
    Created on : 14/11/2018, 22:54:18
    Author     : Acer
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<c:url value="resources/css/bootstrap.css"/>" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="resources/css/style.css"/>" rel="stylesheet" type="text/css"/>
        <title>Iniciando</title>
    </head>
    <body>
        <h1><center>Olá,${retorno}, cadastro realizado...</center></h1>
        <form action="lista" method="POST">
        <div class="form-group">
            <input type="submit" name="submit" id="submit" class="btn btn-primary " value="Listar" required=""
        </div>  
    </body>
</html>
