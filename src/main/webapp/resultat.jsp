<%@ page import="java.util.List" %>
<%@ page import="com.usr.user.Utilisateur" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Résultat</title>
  <style>
    .table {
      border-collapse: collapse;
      width: 50%;
    }
    .table th, .table td {
      border: 1px solid black;
      padding: 10px;
    }
    .table th {
      background-color: #f2f2f2;
    }
  </style>
</head>
<body>
<h1>Résultat du Formulaire</h1>
<table class="table">
  <tr>
    <th>Nom</th>
    <td>${utilisateur.nom}</td>
  </tr>
  <tr>
    <th>Prénom</th>
    <td>${utilisateur.prenom}</td>
  </tr>
  <tr>
    <th>Sexe</th>
    <td>${utilisateur.sexe}</td>
  </tr>
  <tr>
    <th>Code Postal</th>
    <td>${utilisateur.codePostal}</td>
  </tr>
  <tr>
    <th>Transports</th>
    <td>
      <!-- Utilisation de la boucle for classique pour afficher les transports -->
      <%
        Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
        if (utilisateur != null && utilisateur.getTransports() != null && utilisateur.getTransports()!=null) {
          String[] transports = utilisateur.getTransports();
          for (int i = 0; i < transports.length; i++) {
            String transport = transports[i];
      %>
      <p><%= transport %></p>
      <%
        }
      } else {
      %>
      <p>Aucun transport sélectionné.</p>
      <%
        }
      %>
    </td>
  </tr>
</table>
</body>
</html>
