<%-- 
    Document   : exibir
    Created on : 15/11/2018, 23:31:27
    Author     : Acer
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<c:url value="resources/css/bootstrap.css"/>" rel="stylesheet" type="text/css"/>
        <script src="<c:url value="resources/js/jquery-3.3.1.min.js"/>"></script>
        
        <script>
            $(document).ready(function(){
                $.ajax({
                    url: "retorno",
                    dataType: 'json',
                    success: function(data){
                       $.each(data, function(idx, obj){
                           $('#tabela > tbody').append('<tr><td>'+obj.nome+'</td><td>'+obj.endereco+'</td><td>'+obj.telefone+'</td><td>'+obj.email+'</td><td>'+obj.sexo+'</td></tr>');
                       });
                    }
                });
            });
        </script>
        <title>Exibir Cadastro</title>
    </head>
    <body>
        <div class="container">
            
            <table class="table" id="tabela">
                <thead>
                    <tr>
                        <th>Nome</th>
                        <th>Endereço</th>
                        <th>Telefone</th>
                        <th>Email</th>
                        <th>Sexo</th>
                    </tr>
                </thead>
                <tbody>
                    <%-- comentário em jsp para usar ajax
                    <c:forEach items="${lista}" var="atributo">
                        <tr>
                            <td>${atributo.nome}</td>
                            <td>${atributo.endereco}</td>
                            <td>${atributo.telefone}</td>
                            <td>${atributo.email}</td>
                        </tr>
                    </c:forEach>
                    --%>
                </tbody>
            </table>
        </div>
    </body>
</html>
