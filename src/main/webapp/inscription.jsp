<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Inscription</title>
    <style>
        .error { color: red; }
    </style>
</head>
<body>
<h1>Inscription d'un nouveau client</h1>

<!-- Message d'erreur ou de succès -->
<c:if test="${not empty message}">
    <p class="error">${message}</p>
</c:if>

<form action="CreerClient" method="post">
    <label for="nom">Nom :</label>
    <input type="text" id="nom" name="nom" value="${nom}"><br><br>

    <label for="prenom">Prénom :</label>
    <input type="text" id="prenom" name="prenom" value="${prenom}"><br><br>

    <label for="telephone">Téléphone :</label>
    <input type="text" id="telephone" name="telephone" value="${telephone}"><br><br>

    <label for="email">Email :</label>
    <input type="email" id="email" name="email" value="${email}"><br><br>

    <button type="submit">S'inscrire</button>
</form>
</body>
</html>
