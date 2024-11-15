<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Confirmation de Réservation</title>
  <style>
    .success { color: green; }
  </style>
</head>
<body>
<h1>Confirmation de Réservation</h1>
<p class="success">Réservation enregistrée avec succès !</p>

<!-- Affichage des informations -->
<table border="1">
  <tr>
    <th>Nom</th>
    <td>${reservation.nom}</td>
  </tr>
  <tr>
    <th>Prénom</th>
    <td>${reservation.prenom}</td>
  </tr>
  <tr>
    <th>Téléphone</th>
    <td>${reservation.telephone}</td>
  </tr>
  <tr>
    <th>Email</th>
    <td>${reservation.email}</td>
  </tr>
  <tr>
    <th>Type d'Appartement</th>
    <td>${reservation.typeAppartement}</td>
  </tr>
  <tr>
    <th>Prix</th>
    <td>${reservation.prix} €</td>
  </tr>
  <tr>
    <th>Options</th>
    <td>${reservation.options}</td>
  </tr>
</table>
</body>
</html>
