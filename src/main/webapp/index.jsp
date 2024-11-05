
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calcul du Discriminant</title>
</head>
<body>
<h1>Entrez les coefficients</h1>
<form action="calcul-discriminant" method="get">
    <label for="a">Coefficient a:</label>
    <input type="number" id="a" name="a" required />
    <br>
    <label for="b">Coefficient b:</label>
    <input type="number" id="b" name="b" required />
    <br>
    <label for="c">Coefficient c:</label>
    <input type="number" id="c" name="c" required />
    <br><br>
    <button type="submit">Calculer</button>
</form>
</body>
</html>
