
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Resultat</title>
</head>
<body>

<p style="color: <%= request.getParameter("couleur") %>;">
<%= request.getParameter("texte")%>
</p>
</body>
</html>
