<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Formulaire</title>
  <style>
    .error { color: red; }
  </style>
</head>
<body>
<h1>Formulaire d'inscription</h1>

<!-- Message d'erreur -->
<c:if test="${not empty message}">
  <p class="error">${message}</p>
</c:if>

<form action="FormController" method="post" accept-charset="UTF-8">
  <label for="nom">Nom :</label>
  <input type="text" id="nom" name="nom"><br><br>

  <label for="prenom">Prénom :</label>
  <input type="text" id="prenom" name="prenom"><br><br>

  <label for="sexe">Sexe :</label>
  <select id="sexe" name="sexe" required>
    <option value="">--Sélectionnez--</option>
    <option value="Homme">Homme</option>
    <option value="Femme">Femme</option>
  </select><br><br>

  <label for="codePostal">Code Postal :</label>
  <input type="text" id="codePostal" name="codePostal"><br><br>

  <label>Transports :</label><br>
  <input type="checkbox" name="transports" value="Voiture"> Voiture<br>
  <input type="checkbox" name="transports" value="Train"> Train<br>
  <input type="checkbox" name="transports" value="Avion"> Avion<br>
  <input type="checkbox" name="transports" value="Bateau"> Bateau<br><br>

  <button type="submit">Envoyer</button>
</form>
</body>
</html>

