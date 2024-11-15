<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Informations du client</title>
  <style>
    .success { color: green; }
  </style>
</head>
<body>
<h1>Informations du client</h1>

<!-- Message de succès -->
<p class="success">${message}</p>

<!-- Afficher les informations du client -->
<table border="1">
  <tr>
    <th>Nom</th>
    <td>${client.nom}</td>
  </tr>
  <tr>
    <th>Prénom</th>
    <td>${client.prenom}</td>
  </tr>
  <tr>
    <th>Téléphone</th>
    <td>${client.telephone}</td>
  </tr>
  <tr>
    <th>Email</th>
    <td>${client.email}</td>
  </tr>
</table>
</body>
</html>
