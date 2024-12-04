<!DOCTYPE html>
<html lang="fr">
<head>
  <meta charset="UTF-8">
  <title>WebSocket Chat</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      margin: 20px;
    }
    textarea {
      width: 100%;
      height: 200px;
      margin-bottom: 10px;
    }
    input {
      width: 70%;
      padding: 10px;
      margin-right: 10px;
    }
    button {
      padding: 10px 20px;
    }
  </style>
</head>
<body>
<%
  // Récupération du pseudo de l'utilisateur
  String username = request.getParameter("username");
  if (username == null || username.trim().isEmpty()) {
    username = "Anonyme"; // Valeur par défaut si aucun pseudo n'est fourni
  }
%>
<h3>Bienvenue, <%= username %> !</h3>
<textarea id="output" readonly></textarea><br>
<input type="text" id="message" placeholder="Entrez un message">
<button onclick="sendMessage()">Envoyer</button>

<script type="text/javascript">
  const username = "<%= username %>"; // Pseudo transmis depuis le serveur
  const socket = new WebSocket("ws://localhost:8080/JSP_Tuts/textEndpoint");


  socket.onmessage = (event) => {
    document.getElementById("output").value += "Serveur : " + event.data + "\n";
  };


  function sendMessage() {
    const message = document.getElementById("message").value;
    if (message.trim() !== "") {
      socket.send(username + " : " + message);
      document.getElementById("output").value += username + " : " + message + "\n";
      document.getElementById("message").value = ""; // Efface le champ
    }
  }
</script>
</body>
</html>
