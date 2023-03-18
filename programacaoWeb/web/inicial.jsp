<%@page import="Models.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    User user = (User) session.getAttribute("user");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página de Entrada</title>
        <link rel="stylesheet" type="text/css" href="login.css" />
    </head>
    <body>
        Usuário logado: <%= user.getName() %>
        <div class="menu">
            <a href="inicial.jsp"> Home </a> |
            <a href="index.html"> Sair </a>
        </div>
    </body>
</html>
