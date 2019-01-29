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
    </head>

    <body>
    	<div class="container">
		<table class="striped">
			<thead>
				<tr>
					<th>Front-end</th>
					<th>Back-end</th>
				</tr>
			</thead>

			<tbody>
				<tr>
					<td>HTML</td>
					<td>PHP</td>
				</tr>
				<tr>
					<td>CSS</td>
					<td>C#</td>
				</tr>
				<tr>
					<td>JavaScript</td>
					<td>JSP</td>
				</tr>
			</tbody>
		</table>
		<div class="carousel">
                        <a class="carousel-item" href="#one!"><img src="<c:url value="resources/img/port1.jpg" />"</a>
			<a class="carousel-item" href="#two!"><img src="<c:url value="resources/img/port2.jpg" />"</a>
			<a class="carousel-item" href="#three!"><img src="<c:url value="resources/img/port3.jpg" />"</a>
			<a class="carousel-item" href="#four!"><img src="<c:url value="resources/img/port4.jpg" />"</a>
			<a class="carousel-item" href="#five!"><img src="<c:url value="resources/img/port5.jpg" />"</a>
			
		</div>
		
	</div>
    </body>
</html>
  
  