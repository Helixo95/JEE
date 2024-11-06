<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="fr">
<head>
  <meta charset="UTF-8">
  <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %></h1>
<br/>
<a href="<%= request.getContextPath() %>/hello-servlet">Hello Servlet</a>
<br/>
<a href="<%= request.getContextPath() %>/redirect-servlet?action=redirect&redirectURL=https%3A%2F%2Fwww.google.com">Aller Vers Google.com</a>
<a href="<%= request.getContextPath() %>/redirect-servlet?action=Erreur&redirectURL=Volontaire">Faire une erreur volontaire</a>
</body>
</html>
