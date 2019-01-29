<%-- 
    Document   : teste
    Created on : 17/11/2018, 09:44:30
    Author     : Acer
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
  <html>
    <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <!--Import Google Icon Font-->
      <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
      <!--Import materialize.css-->
      <link href="<c:url value="resources/css/materialize.min.css"/>" rel="stylesheet" type="text/css" media="screen,projection"/>
      
      <!--jQuery-->
      <script src="<c:url value="resources/js/jquery-3.3.1.js"/>"></script>
      <script src="<c:url value="resources/js/funcao.js"/>"></script>
      <script type="text/javascript" src="<c:url value="resources/js/materialize.min.js"/>"></script>
      <!--JavaScript at end of body for optimized loading-->
      
      <!--Let browser know website is optimized for mobile-->
      <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
      <script>
        function teste(){
            document.forms[0].acao.value="teste";
            document.forms[0].action="index";
            document.forms[0].submit();
        }
        function redireciona(param){
            location.href=param;
        }
      </script>
      
    </head>

    <body>
    	<div class="container">
		<table class="striped">
                        <input type="hidden" name="acao">
			<thead>
				<tr>
                                    
                                    <th><center><form action="lista" method="POST"><input type="submit" name="submit" id="submit" class="btn btn-primary " value="Front-end" required=""></form></center></th>
                                    <th><center><form action="index" method="POST"><input type="submit" name="submit" id="submit" class="btn btn-primary " value="Back-end" required=""></form></center></th>
				</tr>
			</thead>

			<tbody>
				<tr>
					<td><center>HTML</center></td>
					<td><center>PHP</center></td>
				</tr>
				<tr>
					<td><center>CSS</center></td>
					<td><center>C#</center></td>
				</tr>
				<tr>
					<td><center>JavaScript</center></td>
                                        <td><center>JSP</center></td>
				</tr>
			</tbody>
		</table>
            <div class="form-group">
                <br /> <center><input type="button" onClick="redireciona('cadastro');" class="btn btn-primary " value="Cadrastrar" required=""></center>
            </div>
               
		<div class="carousel">
                    <a class="carousel-item" href="#one!"><input type="image" ondblclick="redireciona('cadastro');" img src="<c:url value="resources/img/port1.jpg" />" width="287" height="176"  /></a>              
                    <a class="carousel-item" href="#two!"><input type="image" ondblclick="redireciona('cadastro');" img src="<c:url value="resources/img/port2.jpg" />" width="287" height="176" /></a>
                    <a class="carousel-item" href="#three!"><input type="image" ondblclick="redireciona('cadastro');" img src="<c:url value="resources/img/port3.jpg" />" width="287" height="176" /></a>
                    <a class="carousel-item" href="#four!"><input type="image" ondblclick="redireciona('cadastro');" img src="<c:url value="resources/img/port4.jpg" />" width="287" height="176" /></a>
                    <a class="carousel-item" href="#five!"><input type="image" ondblclick="redireciona('cadastro');" img src="<c:url value="resources/img/port5.jpg" />" width="287" height="176" /></a>
			
		</div>
	</div>
    </body>
</html>