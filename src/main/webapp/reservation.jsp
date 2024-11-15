<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Réservation</title>
  <style>
    .error { color: red; }
  </style>
</head>
<body>
<h1>Formulaire de Réservation</h1>

<!-- Message d'erreur -->
<c:if test="${not empty message}">
  <p class="error">${message}</p>
</c:if>

<form action="CreerReservation" method="post">
  <label for="nom">Nom :</label>
  <input type="text" id="nom" name="nom" value="${nom}"><br><br>

  <label for="prenom">Prénom :</label>
  <input type="text" id="prenom" name="prenom" value="${prenom}"><br><br>

  <label for="telephone">Téléphone :</label>
  <input type="text" id="telephone" name="telephone" value="${telephone}"><br><br>

  <label for="email">Email :</label>
  <input type="email" id="email" name="email" value="${email}"><br><br>

  <label for="typeAppartement">Type d'Appartement :</label>
  <select id="typeAppartement" name="typeAppartement">
    <option value="">--Sélectionnez--</option>
    <option value="Studio">Studio</option>
    <option value="Appartement 2 chambres">Appartement 2 chambres</option>
    <option value="Appartement 3 chambres">Appartement 3 chambres</option>
  </select><br><br>

  <label for="prix">Prix :</label>
  <input type="number" id="prix" name="prix" step="0.01"><br><br>

  <label>Options :</label><br>
  <input type="checkbox" name="options" value="Proche de la mer"> Proche de la mer<br>
  <input type="checkbox" name="options" value="Piscine"> Piscine<br>
  <input type="checkbox" name="options" value="Jardin"> Jardin<br><br>

  <button type="submit">Réserver</button>
</form>
</body>
</html>
