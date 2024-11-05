
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Gestion de la Matrice</title>
</head>
<body>
<h1>Gestion de la Matrice</h1>

<!-- Formulaire pour visualiser la matrice -->
<form action="MatriceServlet" method="get">
    <h2>GET sans paramètres</h2>
    <input type="submit" value="Afficher la matrice">
</form>

<!-- Formulaire pour obtenir la valeur d'une cellule -->
<form action="MatriceServlet" method="get">
    <h2>GET avec paramètres</h2>
    <label for="x">x :</label>
    <input type="text" id="x" name="x" required>
    <label for="y">y :</label>
    <input type="text" id="y" name="y" required>
    <input type="submit" value="Obtenir la valeur">
</form>

<!-- Formulaire pour réinitialiser la matrice -->
<form action="MatriceServlet" method="post">
    <h2>Post sans paramètres</h2>
    <input type="submit" value="Réinitialiser">
</form>

<!-- Formulaire pour mettre à jour une cellule -->
<form action="MatriceServlet" method="post">
    <h2>Post avec paramètres</h2>
    <label for="x">x :</label>
    <input type="text" id="x" name="x" required>
    <label for="y">y :</label>
    <input type="text" id="y" name="y" required>
    <label for="val">Valeur :</label>
    <input type="text" id="val" name="val" required>
    <input type="submit" value="Mettre à jour">
</form>
</body>
</html>

