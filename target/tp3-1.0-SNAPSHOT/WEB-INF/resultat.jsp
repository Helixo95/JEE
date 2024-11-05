<%--
  Created by IntelliJ IDEA.
  User: aurelienruppe
  Date: 05/11/2024
  Time: 09:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
  <head>
    <meta charset="UTF-8">
    <title>Résultat</title>
  </head>
  <body>
    <h2>Résultat de l'authentification</h2>
    <p>
      <%= request.getAttribute("message") %>
    </p>
  </body>
</html>
