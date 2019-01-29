<%-- 
    Document   : cadastraProfessor
    Created on : 14/10/2017, 16:35:31
    Author     : lucas
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="<c:url value="resources/_estilos/GetPoc_MenuStyle.css" />" />
<link rel="stylesheet" href="<c:url value="resources/_estilos/GetPoc_CadastrarProfessor_Stylesheet.css" />" />
<link rel="stylesheet" href="<c:url value="resources/_estilos/Abel_Font_Stylesheet" /> " />
<title>GetPoc | Cadastro Professor</title>
</head>
<body>
<header class="cabecalho">
<img src="<c:url value="resources/_imagens/header_lateral.png" />" width="269" height="100" class="header_lateral" />
<img src="<c:url value="resources/_imagens/logo2.png" />" width="427" height="100" class="logo" />
<img src="<c:url value="resources/_imagens/header_linha.png" />" width="938" height="15" class="bar" />
</header>

<input type="checkbox" id="menu" />
<label id="icone" for="menu" ><img src="<c:url value="resources/_imagens/botao_menu.png" />" width="39px" height="29px"  /></label>
<div class ="barra">
<div class="user">
<h1>Usuário:</h1>
<h2>Gláucia</h2>
</div>
<nav>
<a href="pesquisaTCC"><div class="link">Pesquisar TCC</div></a>
<a href="cadastroTCC"><div class="link">Cadastrar TCC</div></a>
<a href="cadastraProfessor"><div class="linkSpecial">Cadastrar Professor<img src="<c:url value="resources/_imagens/seta.png" />" width="11px" height="15px" /></div></a>
<a href="cadastraAreaConhecimento"><div class="link">Cadastrar Área de<br />Conhecimento</div></a>
</nav>
</div>
<div class="bloco">
<h1>Cadastro de Professor</h1>
<h2>Nome:</h2>
<form method="post" action="okpage">
<input type="text" name="nome" id="nome" class="text" />
<h2>CPF:</h2>
<input type="text" name="cpf" id="cpf" class="text" required=""/>
<h2>Sexo </h2>
<h3><input type="radio" name="sexo" id="sexo" value="male" checked /> Masculino &nbsp; &nbsp;<input type="radio" name="sexo" value="female" /> Feminino</h3>
</div>
<div class="bloco1">
<h2>Sobrenome:</h2>
<input type="text" name="sobrenome" id="sobrenome" />
<h2>Curso:</h2>
<input type="text" name="curso" id="curso" />
<h2>E-mail:</h2>
<input type="email" name="login" id="login" required=""/>
</div>
<div class="bloco3">
    <button type="submit">Cadastrar</button>
</form>
</div>
</body>
</html>
