<%-- 
    Document   : cadrastro
    Created on : 15/11/2018, 11:32:31
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
        <title>Cadastro</title>
    </head>
    <body>
        
        
        
        <div class="container">
            <div class="col-md-6 cadastro"
            <h1>Tela de Cadastro!</h1>
                <form action="index" method="POST">
                <div class="form-group">
                    Nome
                    <input type="text" name="nome" id="nome" class="form-control" required=""
                </div>
                
                <div class="form-group">
                    Endereco
                    <input type="text" name="endereco" id="endereco" class="form-control" required=""
                </div>
                
                <div class="form-group">
                    Telefone
                    <input type="number" name="telefone" id="telefone" class="form-control" required=""
                </div>
             
                <div class="form-group">
                    Email
                    <input type="email" name="email" id="email" class="form-control" required=""
                </div>
              
                <div class="form-group">
                    <input type="submit" name="submit" id="submit" class="btn btn-primary " value="Cadrastrar" required=""
                </div>  
            </form>
            </div>
        </div>                           
    </body>
</html>
